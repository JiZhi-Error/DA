package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.d;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class LikeActionController {
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    @Deprecated
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    @Deprecated
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    @Deprecated
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
    private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static final String TAG = LikeActionController.class.getSimpleName();
    private static AccessTokenTracker accessTokenTracker;
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap<>();
    private static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
    private static Handler handler;
    private static boolean isInitialized;
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Bundle facebookDialogAnalyticsBundle;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private LikeView.ObjectType objectType;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;

    @Deprecated
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    interface LikeRequestWrapper extends RequestWrapper {
        String getUnlikeToken();

        boolean isObjectLiked();
    }

    /* access modifiers changed from: package-private */
    public interface RequestCompletionCallback {
        void onComplete();
    }

    interface RequestWrapper {
        void addToBatch(GraphRequestBatch graphRequestBatch);

        FacebookRequestError getError();
    }

    static /* synthetic */ void access$000(LikeActionController likeActionController, int i2, int i3, Intent intent) {
        AppMethodBeat.i(8083);
        likeActionController.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(8083);
    }

    static /* synthetic */ AppEventsLogger access$1200(LikeActionController likeActionController) {
        AppMethodBeat.i(8086);
        AppEventsLogger appEventsLogger2 = likeActionController.getAppEventsLogger();
        AppMethodBeat.o(8086);
        return appEventsLogger2;
    }

    static /* synthetic */ void access$1300(LikeActionController likeActionController, boolean z, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(8087);
        likeActionController.updateState(z, str, str2, str3, str4, str5);
        AppMethodBeat.o(8087);
    }

    static /* synthetic */ void access$1400(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.i(8088);
        likeActionController.logAppEventForError(str, bundle);
        AppMethodBeat.o(8088);
    }

    static /* synthetic */ void access$1500(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.i(8089);
        broadcastAction(likeActionController, str, bundle);
        AppMethodBeat.o(8089);
    }

    static /* synthetic */ void access$1900(LikeActionController likeActionController, boolean z) {
        AppMethodBeat.i(8090);
        likeActionController.publishDidError(z);
        AppMethodBeat.o(8090);
    }

    static /* synthetic */ void access$200(LikeActionController likeActionController) {
        AppMethodBeat.i(8084);
        likeActionController.refreshStatusAsync();
        AppMethodBeat.o(8084);
    }

    static /* synthetic */ void access$2100(LikeActionController likeActionController, Bundle bundle) {
        AppMethodBeat.i(8091);
        likeActionController.publishAgainIfNeeded(bundle);
        AppMethodBeat.o(8091);
    }

    static /* synthetic */ void access$2400(LikeActionController likeActionController, String str, FacebookRequestError facebookRequestError) {
        AppMethodBeat.i(8092);
        likeActionController.logAppEventForError(str, facebookRequestError);
        AppMethodBeat.o(8092);
    }

    static /* synthetic */ void access$2600(String str, String str2) {
        AppMethodBeat.i(8093);
        serializeToDiskSynchronously(str, str2);
        AppMethodBeat.o(8093);
    }

    static /* synthetic */ void access$2700(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        AppMethodBeat.i(8094);
        createControllerForObjectIdAndType(str, objectType2, creationCallback);
        AppMethodBeat.o(8094);
    }

    static /* synthetic */ void access$600(LikeActionController likeActionController, String str) {
        AppMethodBeat.i(8085);
        broadcastAction(likeActionController, str);
        AppMethodBeat.o(8085);
    }

    static {
        AppMethodBeat.i(8095);
        AppMethodBeat.o(8095);
    }

    @Deprecated
    public static boolean handleOnActivityResult(final int i2, final int i3, final Intent intent) {
        AppMethodBeat.i(8045);
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            AppMethodBeat.o(8045);
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass1 */

            @Override // com.facebook.share.internal.LikeActionController.CreationCallback
            public final void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
                AppMethodBeat.i(8004);
                if (facebookException == null) {
                    LikeActionController.access$000(likeActionController, i2, i3, intent);
                    AppMethodBeat.o(8004);
                    return;
                }
                Utility.logd(LikeActionController.TAG, facebookException);
                AppMethodBeat.o(8004);
            }
        });
        AppMethodBeat.o(8045);
        return true;
    }

    @Deprecated
    public static void getControllerForObjectId(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        AppMethodBeat.i(8046);
        if (!isInitialized) {
            performFirstInitialize();
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType2, creationCallback);
            AppMethodBeat.o(8046);
            return;
        }
        diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(str, objectType2, creationCallback));
        AppMethodBeat.o(8046);
    }

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        FacebookException facebookException;
        AppMethodBeat.i(8047);
        LikeView.ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType2, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.objectId, likeActionController.objectType.toString(), objectType2.toString());
            likeActionController = null;
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
        }
        invokeCallbackWithController(creationCallback, likeActionController, facebookException);
        AppMethodBeat.o(8047);
    }

    private static void createControllerForObjectIdAndType(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
        AppMethodBeat.i(8048);
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType2, creationCallback);
            AppMethodBeat.o(8048);
            return;
        }
        LikeActionController deserializeFromDiskSynchronously = deserializeFromDiskSynchronously(str);
        if (deserializeFromDiskSynchronously == null) {
            deserializeFromDiskSynchronously = new LikeActionController(str, objectType2);
            serializeToDiskAsync(deserializeFromDiskSynchronously);
        }
        putControllerInMemoryCache(str, deserializeFromDiskSynchronously);
        handler.post(new Runnable(deserializeFromDiskSynchronously) {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass2 */
            final /* synthetic */ LikeActionController val$controllerToRefresh;

            {
                this.val$controllerToRefresh = r1;
            }

            public final void run() {
                AppMethodBeat.i(8008);
                LikeActionController.access$200(this.val$controllerToRefresh);
                AppMethodBeat.o(8008);
            }
        });
        invokeCallbackWithController(creationCallback, deserializeFromDiskSynchronously, null);
        AppMethodBeat.o(8048);
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            AppMethodBeat.i(8049);
            if (isInitialized) {
                AppMethodBeat.o(8049);
            } else {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
                controllerDiskCache = new FileLruCache(TAG, new FileLruCache.Limits());
                registerAccessTokenTracker();
                CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new CallbackManagerImpl.Callback() {
                    /* class com.facebook.share.internal.LikeActionController.AnonymousClass3 */

                    @Override // com.facebook.internal.CallbackManagerImpl.Callback
                    public final boolean onActivityResult(int i2, Intent intent) {
                        AppMethodBeat.i(8009);
                        boolean handleOnActivityResult = LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), i2, intent);
                        AppMethodBeat.o(8009);
                        return handleOnActivityResult;
                    }
                });
                isInitialized = true;
                AppMethodBeat.o(8049);
            }
        }
    }

    private static void invokeCallbackWithController(final CreationCallback creationCallback, final LikeActionController likeActionController, final FacebookException facebookException) {
        AppMethodBeat.i(8050);
        if (creationCallback == null) {
            AppMethodBeat.o(8050);
            return;
        }
        handler.post(new Runnable() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(8010);
                creationCallback.onComplete(likeActionController, facebookException);
                AppMethodBeat.o(8010);
            }
        });
        AppMethodBeat.o(8050);
    }

    private static void registerAccessTokenTracker() {
        AppMethodBeat.i(8051);
        accessTokenTracker = new AccessTokenTracker() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass5 */

            @Override // com.facebook.AccessTokenTracker
            public final void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                AppMethodBeat.i(8011);
                Context applicationContext = FacebookSdk.getApplicationContext();
                if (accessToken2 == null) {
                    int unused = LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
                    applicationContext.getSharedPreferences(LikeActionController.LIKE_ACTION_CONTROLLER_STORE, 0).edit().putInt(LikeActionController.LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, LikeActionController.objectSuffix).apply();
                    LikeActionController.cache.clear();
                    LikeActionController.controllerDiskCache.clearCache();
                }
                LikeActionController.access$600(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
                AppMethodBeat.o(8011);
            }
        };
        AppMethodBeat.o(8051);
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        AppMethodBeat.i(8052);
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
        AppMethodBeat.o(8052);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        AppMethodBeat.i(8053);
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, false));
        }
        AppMethodBeat.o(8053);
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        AppMethodBeat.i(8054);
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!Utility.isNullOrEmpty(serializeToJson) && !Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKeyForObjectId, serializeToJson));
        }
        AppMethodBeat.o(8054);
    }

    private static void serializeToDiskSynchronously(String str, String str2) {
        AppMethodBeat.i(8055);
        OutputStream outputStream = null;
        try {
            outputStream = controllerDiskCache.openPutStream(str);
            outputStream.write(str2.getBytes());
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
                AppMethodBeat.o(8055);
                return;
            }
        } catch (IOException e2) {
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
                AppMethodBeat.o(8055);
                return;
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                Utility.closeQuietly(outputStream);
            }
            AppMethodBeat.o(8055);
            throw th;
        }
        AppMethodBeat.o(8055);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.facebook.share.internal.LikeActionController deserializeFromDiskSynchronously(java.lang.String r5) {
        /*
            r0 = 0
            r4 = 8056(0x1f78, float:1.1289E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r1 = getCacheKeyForObjectId(r5)     // Catch:{ IOException -> 0x0029, all -> 0x0031 }
            com.facebook.internal.FileLruCache r2 = com.facebook.share.internal.LikeActionController.controllerDiskCache     // Catch:{ IOException -> 0x0029, all -> 0x0031 }
            java.io.InputStream r1 = r2.get(r1)     // Catch:{ IOException -> 0x0029, all -> 0x0031 }
            if (r1 == 0) goto L_0x0020
            java.lang.String r2 = com.facebook.internal.Utility.readStreamToString(r1)     // Catch:{ IOException -> 0x0041, all -> 0x003d }
            boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r2)     // Catch:{ IOException -> 0x0041, all -> 0x003d }
            if (r3 != 0) goto L_0x0020
            com.facebook.share.internal.LikeActionController r0 = deserializeFromJson(r2)     // Catch:{ IOException -> 0x0041, all -> 0x003d }
        L_0x0020:
            if (r1 == 0) goto L_0x0025
            com.facebook.internal.Utility.closeQuietly(r1)
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0029:
            r1 = move-exception
            r1 = r0
        L_0x002b:
            if (r1 == 0) goto L_0x0025
            com.facebook.internal.Utility.closeQuietly(r1)
            goto L_0x0025
        L_0x0031:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0034:
            if (r3 == 0) goto L_0x0039
            com.facebook.internal.Utility.closeQuietly(r3)
        L_0x0039:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x003d:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0034
        L_0x0041:
            r2 = move-exception
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeActionController.deserializeFromDiskSynchronously(java.lang.String):com.facebook.share.internal.LikeActionController");
    }

    private static LikeActionController deserializeFromJson(String str) {
        LikeActionController likeActionController;
        AppMethodBeat.i(8057);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != 3) {
                AppMethodBeat.o(8057);
                return null;
            }
            likeActionController = new LikeActionController(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
            likeActionController.likeCountStringWithLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, null);
            likeActionController.likeCountStringWithoutLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, null);
            likeActionController.socialSentenceWithLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, null);
            likeActionController.socialSentenceWithoutLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, null);
            likeActionController.isObjectLiked = jSONObject.optBoolean(JSON_BOOL_IS_OBJECT_LIKED_KEY);
            likeActionController.unlikeToken = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE);
            if (optJSONObject != null) {
                likeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(optJSONObject);
            }
            AppMethodBeat.o(8057);
            return likeActionController;
        } catch (JSONException e2) {
            likeActionController = null;
        }
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        JSONObject convertToJSON;
        AppMethodBeat.i(8058);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_INT_VERSION_KEY, 3);
            jSONObject.put("object_id", likeActionController.objectId);
            jSONObject.put("object_type", likeActionController.objectType.getValue());
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, likeActionController.likeCountStringWithLike);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, likeActionController.likeCountStringWithoutLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, likeActionController.socialSentenceWithLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, likeActionController.socialSentenceWithoutLike);
            jSONObject.put(JSON_BOOL_IS_OBJECT_LIKED_KEY, likeActionController.isObjectLiked);
            jSONObject.put("unlike_token", likeActionController.unlikeToken);
            if (!(likeActionController.facebookDialogAnalyticsBundle == null || (convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.facebookDialogAnalyticsBundle)) == null)) {
                jSONObject.put(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE, convertToJSON);
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(8058);
            return jSONObject2;
        } catch (JSONException e2) {
            AppMethodBeat.o(8058);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        AppMethodBeat.i(8059);
        String str2 = null;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (AccessToken.isCurrentAccessTokenActive()) {
            str2 = currentAccessToken.getToken();
        }
        if (str2 != null) {
            str2 = Utility.md5hash(str2);
        }
        String format = String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, Utility.coerceValueIfNullOrEmpty(str2, ""), Integer.valueOf(objectSuffix));
        AppMethodBeat.o(8059);
        return format;
    }

    private static void broadcastAction(LikeActionController likeActionController, String str) {
        AppMethodBeat.i(8060);
        broadcastAction(likeActionController, str, null);
        AppMethodBeat.o(8060);
    }

    private static void broadcastAction(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.i(8061);
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d.W(FacebookSdk.getApplicationContext()).b(intent);
        AppMethodBeat.o(8061);
    }

    private LikeActionController(String str, LikeView.ObjectType objectType2) {
        this.objectId = str;
        this.objectType = objectType2;
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    @Deprecated
    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    @Deprecated
    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    @Deprecated
    public boolean shouldEnableView() {
        return false;
    }

    @Deprecated
    public void toggleLike(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(8062);
        boolean z2 = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z2);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                AppMethodBeat.o(8062);
                return;
            }
            if (!publishLikeOrUnlikeAsync(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                updateLikeState(z);
            }
            AppMethodBeat.o(8062);
        }
        presentLikeDialog(activity, fragmentWrapper, bundle);
        AppMethodBeat.o(8062);
    }

    private AppEventsLogger getAppEventsLogger() {
        AppMethodBeat.i(8063);
        if (this.appEventsLogger == null) {
            this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        }
        AppEventsLogger appEventsLogger2 = this.appEventsLogger;
        AppMethodBeat.o(8063);
        return appEventsLogger2;
    }

    private boolean publishLikeOrUnlikeAsync(boolean z, Bundle bundle) {
        boolean z2 = true;
        AppMethodBeat.i(8064);
        if (canUseOGPublish()) {
            if (z) {
                publishLikeAsync(bundle);
            } else if (!Utility.isNullOrEmpty(this.unlikeToken)) {
                publishUnlikeAsync(bundle);
            }
            AppMethodBeat.o(8064);
            return z2;
        }
        z2 = false;
        AppMethodBeat.o(8064);
        return z2;
    }

    private void publishDidError(boolean z) {
        AppMethodBeat.i(8065);
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
        AppMethodBeat.o(8065);
    }

    private void updateLikeState(boolean z) {
        AppMethodBeat.i(8066);
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
        AppMethodBeat.o(8066);
    }

    private void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(8067);
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        if (!(z != this.isObjectLiked || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) || !Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken))) {
            AppMethodBeat.o(8067);
            return;
        }
        this.isObjectLiked = z;
        this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
        this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
        this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
        this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
        this.unlikeToken = coerceValueIfNullOrEmpty5;
        serializeToDiskAsync(this);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        AppMethodBeat.o(8067);
    }

    private void presentLikeDialog(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        String str;
        String objectType2;
        AppMethodBeat.i(8068);
        if (LikeDialog.canShowNativeDialog()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG;
        } else if (LikeDialog.canShowWebFallback()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK;
        } else {
            logAppEventForError("present_dialog", bundle);
            Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
            broadcastAction(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
            str = null;
        }
        if (str != null) {
            if (this.objectType != null) {
                objectType2 = this.objectType.toString();
            } else {
                objectType2 = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(objectType2).build();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
        }
        AppMethodBeat.o(8068);
    }

    private void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(8069);
        ShareInternalUtility.handleActivityResult(i2, i3, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
        AppMethodBeat.o(8069);
    }

    private ResultProcessor getResultProcessor(final Bundle bundle) {
        AppMethodBeat.i(8070);
        AnonymousClass6 r0 = new ResultProcessor(null) {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass6 */

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                String str;
                AppMethodBeat.i(8012);
                if (bundle == null || !bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    AppMethodBeat.o(8012);
                    return;
                }
                boolean z = bundle.getBoolean(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY);
                String str2 = LikeActionController.this.likeCountStringWithLike;
                String str3 = LikeActionController.this.likeCountStringWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY)) {
                    String string = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY);
                    str3 = string;
                    str2 = string;
                }
                String str4 = LikeActionController.this.socialSentenceWithLike;
                String str5 = LikeActionController.this.socialSentenceWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY)) {
                    String string2 = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY);
                    str5 = string2;
                    str4 = string2;
                }
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    str = bundle.getString("unlike_token");
                } else {
                    str = LikeActionController.this.unlikeToken;
                }
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
                LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
                LikeActionController.access$1300(LikeActionController.this, z, str2, str3, str4, str5, str);
                AppMethodBeat.o(8012);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onError(AppCall appCall, FacebookException facebookException) {
                AppMethodBeat.i(8013);
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
                Bundle bundle = bundle == null ? new Bundle() : bundle;
                bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
                LikeActionController.access$1400(LikeActionController.this, "present_dialog", bundle);
                LikeActionController.access$1500(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
                AppMethodBeat.o(8013);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onCancel(AppCall appCall) {
                AppMethodBeat.i(8014);
                onError(appCall, new FacebookOperationCanceledException());
                AppMethodBeat.o(8014);
            }
        };
        AppMethodBeat.o(8070);
        return r0;
    }

    private void saveState(Bundle bundle) {
        AppMethodBeat.i(8071);
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
        AppMethodBeat.o(8071);
    }

    private void clearState() {
        AppMethodBeat.i(8072);
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
        AppMethodBeat.o(8072);
    }

    private static void storeObjectIdForPendingController(String str) {
        AppMethodBeat.i(8073);
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
        AppMethodBeat.o(8073);
    }

    private boolean canUseOGPublish() {
        AppMethodBeat.i(8074);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (this.objectIsPage || this.verifiedObjectId == null || !AccessToken.isCurrentAccessTokenActive() || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) {
            AppMethodBeat.o(8074);
            return false;
        }
        AppMethodBeat.o(8074);
        return true;
    }

    private void publishLikeAsync(final Bundle bundle) {
        AppMethodBeat.i(8075);
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new RequestCompletionCallback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass7 */

            @Override // com.facebook.share.internal.LikeActionController.RequestCompletionCallback
            public void onComplete() {
                AppMethodBeat.i(8016);
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
                    LikeActionController.access$1500(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                    AppMethodBeat.o(8016);
                    return;
                }
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                final PublishLikeRequestWrapper publishLikeRequestWrapper = new PublishLikeRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                publishLikeRequestWrapper.addToBatch(graphRequestBatch);
                graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                    /* class com.facebook.share.internal.LikeActionController.AnonymousClass7.AnonymousClass1 */

                    @Override // com.facebook.GraphRequestBatch.Callback
                    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                        AppMethodBeat.i(8015);
                        LikeActionController.this.isPendingLikeOrUnlike = false;
                        if (publishLikeRequestWrapper.getError() != null) {
                            LikeActionController.access$1900(LikeActionController.this, false);
                            AppMethodBeat.o(8015);
                            return;
                        }
                        LikeActionController.this.unlikeToken = Utility.coerceValueIfNullOrEmpty(publishLikeRequestWrapper.unlikeToken, null);
                        LikeActionController.this.isObjectLikedOnServer = true;
                        LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, bundle);
                        LikeActionController.access$2100(LikeActionController.this, bundle);
                        AppMethodBeat.o(8015);
                    }
                });
                graphRequestBatch.executeAsync();
                AppMethodBeat.o(8016);
            }
        });
        AppMethodBeat.o(8075);
    }

    private void publishUnlikeAsync(final Bundle bundle) {
        AppMethodBeat.i(8076);
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        final PublishUnlikeRequestWrapper publishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
        publishUnlikeRequestWrapper.addToBatch(graphRequestBatch);
        graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass8 */

            @Override // com.facebook.GraphRequestBatch.Callback
            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                AppMethodBeat.i(8017);
                LikeActionController.this.isPendingLikeOrUnlike = false;
                if (publishUnlikeRequestWrapper.getError() != null) {
                    LikeActionController.access$1900(LikeActionController.this, true);
                    AppMethodBeat.o(8017);
                    return;
                }
                LikeActionController.this.unlikeToken = null;
                LikeActionController.this.isObjectLikedOnServer = false;
                LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, bundle);
                LikeActionController.access$2100(LikeActionController.this, bundle);
                AppMethodBeat.o(8017);
            }
        });
        graphRequestBatch.executeAsync();
        AppMethodBeat.o(8076);
    }

    private void refreshStatusAsync() {
        AppMethodBeat.i(8077);
        if (!AccessToken.isCurrentAccessTokenActive()) {
            refreshStatusViaService();
            AppMethodBeat.o(8077);
            return;
        }
        fetchVerifiedObjectId(new RequestCompletionCallback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass9 */

            @Override // com.facebook.share.internal.LikeActionController.RequestCompletionCallback
            public void onComplete() {
                final LikeRequestWrapper getPageLikesRequestWrapper;
                AppMethodBeat.i(8019);
                switch (LikeActionController.this.objectType) {
                    case PAGE:
                        getPageLikesRequestWrapper = new GetPageLikesRequestWrapper(LikeActionController.this.verifiedObjectId);
                        break;
                    default:
                        getPageLikesRequestWrapper = new GetOGObjectLikesRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                        break;
                }
                final GetEngagementRequestWrapper getEngagementRequestWrapper = new GetEngagementRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                getPageLikesRequestWrapper.addToBatch(graphRequestBatch);
                getEngagementRequestWrapper.addToBatch(graphRequestBatch);
                graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                    /* class com.facebook.share.internal.LikeActionController.AnonymousClass9.AnonymousClass1 */

                    @Override // com.facebook.GraphRequestBatch.Callback
                    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                        AppMethodBeat.i(8018);
                        if (getPageLikesRequestWrapper.getError() == null && getEngagementRequestWrapper.getError() == null) {
                            LikeActionController.access$1300(LikeActionController.this, getPageLikesRequestWrapper.isObjectLiked(), getEngagementRequestWrapper.likeCountStringWithLike, getEngagementRequestWrapper.likeCountStringWithoutLike, getEngagementRequestWrapper.socialSentenceStringWithLike, getEngagementRequestWrapper.socialSentenceStringWithoutLike, getPageLikesRequestWrapper.getUnlikeToken());
                            AppMethodBeat.o(8018);
                            return;
                        }
                        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", LikeActionController.this.objectId);
                        AppMethodBeat.o(8018);
                    }
                });
                graphRequestBatch.executeAsync();
                AppMethodBeat.o(8019);
            }
        });
        AppMethodBeat.o(8077);
    }

    private void refreshStatusViaService() {
        AppMethodBeat.i(8078);
        LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (!likeStatusClient.start()) {
            AppMethodBeat.o(8078);
            return;
        }
        likeStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass10 */

            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public void completed(Bundle bundle) {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                AppMethodBeat.i(8005);
                if (bundle == null || !bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
                    AppMethodBeat.o(8005);
                    return;
                }
                boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
                if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                    str = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
                } else {
                    str = LikeActionController.this.likeCountStringWithLike;
                }
                if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                    str2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
                } else {
                    str2 = LikeActionController.this.likeCountStringWithoutLike;
                }
                if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                    str3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
                } else {
                    str3 = LikeActionController.this.socialSentenceWithLike;
                }
                if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                    str4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
                } else {
                    str4 = LikeActionController.this.socialSentenceWithoutLike;
                }
                if (bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
                    str5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
                } else {
                    str5 = LikeActionController.this.unlikeToken;
                }
                LikeActionController.access$1300(LikeActionController.this, z, str, str2, str3, str4, str5);
                AppMethodBeat.o(8005);
            }
        });
        AppMethodBeat.o(8078);
    }

    private void publishAgainIfNeeded(Bundle bundle) {
        AppMethodBeat.i(8079);
        if (this.isObjectLiked != this.isObjectLikedOnServer && !publishLikeOrUnlikeAsync(this.isObjectLiked, bundle)) {
            publishDidError(!this.isObjectLiked);
        }
        AppMethodBeat.o(8079);
    }

    private void fetchVerifiedObjectId(final RequestCompletionCallback requestCompletionCallback) {
        AppMethodBeat.i(8080);
        if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
            if (requestCompletionCallback != null) {
                requestCompletionCallback.onComplete();
            }
            AppMethodBeat.o(8080);
            return;
        }
        final GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
        final GetPageIdRequestWrapper getPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId, this.objectType);
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        getOGObjectIdRequestWrapper.addToBatch(graphRequestBatch);
        getPageIdRequestWrapper.addToBatch(graphRequestBatch);
        graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
            /* class com.facebook.share.internal.LikeActionController.AnonymousClass11 */

            @Override // com.facebook.GraphRequestBatch.Callback
            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                FacebookRequestError error;
                AppMethodBeat.i(8006);
                LikeActionController.this.verifiedObjectId = getOGObjectIdRequestWrapper.verifiedObjectId;
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    LikeActionController.this.verifiedObjectId = getPageIdRequestWrapper.verifiedObjectId;
                    LikeActionController.this.objectIsPage = getPageIdRequestWrapper.objectIsPage;
                }
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.objectId);
                    LikeActionController likeActionController = LikeActionController.this;
                    if (getPageIdRequestWrapper.getError() != null) {
                        error = getPageIdRequestWrapper.getError();
                    } else {
                        error = getOGObjectIdRequestWrapper.getError();
                    }
                    LikeActionController.access$2400(likeActionController, "get_verified_id", error);
                }
                if (requestCompletionCallback != null) {
                    requestCompletionCallback.onComplete();
                }
                AppMethodBeat.o(8006);
            }
        });
        graphRequestBatch.executeAsync();
        AppMethodBeat.o(8080);
    }

    private void logAppEventForError(String str, Bundle bundle) {
        AppMethodBeat.i(8081);
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.objectId);
        bundle2.putString("object_type", this.objectType.toString());
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
        AppMethodBeat.o(8081);
    }

    private void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        JSONObject requestResult;
        AppMethodBeat.i(8082);
        Bundle bundle = new Bundle();
        if (!(facebookRequestError == null || (requestResult = facebookRequestError.getRequestResult()) == null)) {
            bundle.putString("error", requestResult.toString());
        }
        logAppEventForError(str, bundle);
        AppMethodBeat.o(8082);
    }

    /* access modifiers changed from: package-private */
    public class GetOGObjectIdRequestWrapper extends AbstractRequestWrapper {
        String verifiedObjectId;

        GetOGObjectIdRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.i(8025);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "og_object.fields(id)");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
            AppMethodBeat.o(8025);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8026);
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                AppMethodBeat.o(8026);
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            AppMethodBeat.o(8026);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            AppMethodBeat.i(8027);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (!(tryGetJSONObjectFromResponse == null || (optJSONObject = tryGetJSONObjectFromResponse.optJSONObject("og_object")) == null)) {
                this.verifiedObjectId = optJSONObject.optString("id");
            }
            AppMethodBeat.o(8027);
        }
    }

    /* access modifiers changed from: package-private */
    public class GetPageIdRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsPage;
        String verifiedObjectId;

        GetPageIdRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.i(8031);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
            AppMethodBeat.o(8031);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.i(8032);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                this.objectIsPage = !Utility.isNullOrEmpty(this.verifiedObjectId);
            }
            AppMethodBeat.o(8032);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8033);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            AppMethodBeat.o(8033);
        }
    }

    class PublishLikeRequestWrapper extends AbstractRequestWrapper {
        String unlikeToken;

        PublishLikeRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.i(8039);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.POST));
            AppMethodBeat.o(8039);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.i(8040);
            this.unlikeToken = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), "id");
            AppMethodBeat.o(8040);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8041);
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.error = null;
                AppMethodBeat.o(8041);
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "publish_like", facebookRequestError);
            AppMethodBeat.o(8041);
        }
    }

    /* access modifiers changed from: package-private */
    public class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
        private String unlikeToken;

        PublishUnlikeRequestWrapper(String str) {
            super(null, null);
            AppMethodBeat.i(8042);
            this.unlikeToken = str;
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
            AppMethodBeat.o(8042);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8043);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "publish_unlike", facebookRequestError);
            AppMethodBeat.o(8043);
        }
    }

    class GetPageLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private String pageId;

        GetPageLikesRequestWrapper(String str) {
            super(str, LikeView.ObjectType.PAGE);
            AppMethodBeat.i(8034);
            this.pageId = str;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/".concat(String.valueOf(str)), bundle, HttpMethod.GET));
            AppMethodBeat.o(8034);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.i(8035);
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.objectIsLiked = true;
            }
            AppMethodBeat.o(8035);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8036);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.pageId, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_page_like", facebookRequestError);
            AppMethodBeat.o(8036);
        }

        @Override // com.facebook.share.internal.LikeActionController.LikeRequestWrapper
        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        @Override // com.facebook.share.internal.LikeActionController.LikeRequestWrapper
        public String getUnlikeToken() {
            return null;
        }
    }

    class GetOGObjectLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private final String objectId;
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private final LikeView.ObjectType objectType;
        private String unlikeToken;

        GetOGObjectLikesRequestWrapper(String str, LikeView.ObjectType objectType2) {
            super(str, objectType2);
            AppMethodBeat.i(8028);
            this.objectId = str;
            this.objectType = objectType2;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,application");
            bundle.putString("object", this.objectId);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
            AppMethodBeat.o(8028);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.i(8029);
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null) {
                for (int i2 = 0; i2 < tryGetJSONArrayFromResponse.length(); i2++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.objectIsLiked = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && AccessToken.isCurrentAccessTokenActive() && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.unlikeToken = optJSONObject.optString("id");
                        }
                    }
                }
            }
            AppMethodBeat.o(8029);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8030);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_og_object_like", facebookRequestError);
            AppMethodBeat.o(8030);
        }

        @Override // com.facebook.share.internal.LikeActionController.LikeRequestWrapper
        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        @Override // com.facebook.share.internal.LikeActionController.LikeRequestWrapper
        public String getUnlikeToken() {
            return this.unlikeToken;
        }
    }

    class GetEngagementRequestWrapper extends AbstractRequestWrapper {
        String likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
        String likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
        String socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
        String socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;

        GetEngagementRequestWrapper(String str, LikeView.ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.i(8022);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
            AppMethodBeat.o(8022);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.i(8023);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.likeCountStringWithLike = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.likeCountStringWithLike);
                this.likeCountStringWithoutLike = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
                this.socialSentenceStringWithLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.socialSentenceStringWithLike);
                this.socialSentenceStringWithoutLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.socialSentenceStringWithoutLike);
            }
            AppMethodBeat.o(8023);
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.share.internal.LikeActionController.AbstractRequestWrapper
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.i(8024);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_engagement", facebookRequestError);
            AppMethodBeat.o(8024);
        }
    }

    abstract class AbstractRequestWrapper implements RequestWrapper {
        protected FacebookRequestError error;
        protected String objectId;
        protected LikeView.ObjectType objectType;
        private GraphRequest request;

        /* access modifiers changed from: protected */
        public abstract void processSuccess(GraphResponse graphResponse);

        protected AbstractRequestWrapper(String str, LikeView.ObjectType objectType2) {
            this.objectId = str;
            this.objectType = objectType2;
        }

        @Override // com.facebook.share.internal.LikeActionController.RequestWrapper
        public void addToBatch(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.request);
        }

        @Override // com.facebook.share.internal.LikeActionController.RequestWrapper
        public FacebookRequestError getError() {
            return this.error;
        }

        /* access modifiers changed from: protected */
        public void setRequest(GraphRequest graphRequest) {
            this.request = graphRequest;
            graphRequest.setVersion(FacebookSdk.getGraphApiVersion());
            graphRequest.setCallback(new GraphRequest.Callback() {
                /* class com.facebook.share.internal.LikeActionController.AbstractRequestWrapper.AnonymousClass1 */

                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(8020);
                    AbstractRequestWrapper.this.error = graphResponse.getError();
                    if (AbstractRequestWrapper.this.error != null) {
                        AbstractRequestWrapper.this.processError(AbstractRequestWrapper.this.error);
                        AppMethodBeat.o(8020);
                        return;
                    }
                    AbstractRequestWrapper.this.processSuccess(graphResponse);
                    AppMethodBeat.o(8020);
                }
            });
        }

        /* access modifiers changed from: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
        }
    }

    /* access modifiers changed from: package-private */
    public static class MRUCacheWorkItem implements Runnable {
        private static ArrayList<String> mruCachedItems = new ArrayList<>();
        private String cacheItem;
        private boolean shouldTrim;

        static {
            AppMethodBeat.i(8038);
            AppMethodBeat.o(8038);
        }

        MRUCacheWorkItem(String str, boolean z) {
            this.cacheItem = str;
            this.shouldTrim = z;
        }

        public void run() {
            AppMethodBeat.i(8037);
            if (this.cacheItem != null) {
                mruCachedItems.remove(this.cacheItem);
                mruCachedItems.add(0, this.cacheItem);
            }
            if (this.shouldTrim && mruCachedItems.size() >= 128) {
                while (64 < mruCachedItems.size()) {
                    ArrayList<String> arrayList = mruCachedItems;
                    LikeActionController.cache.remove(arrayList.remove(arrayList.size() - 1));
                }
            }
            AppMethodBeat.o(8037);
        }
    }

    /* access modifiers changed from: package-private */
    public static class SerializeToDiskWorkItem implements Runnable {
        private String cacheKey;
        private String controllerJson;

        SerializeToDiskWorkItem(String str, String str2) {
            this.cacheKey = str;
            this.controllerJson = str2;
        }

        public void run() {
            AppMethodBeat.i(8044);
            LikeActionController.access$2600(this.cacheKey, this.controllerJson);
            AppMethodBeat.o(8044);
        }
    }

    /* access modifiers changed from: package-private */
    public static class CreateLikeActionControllerWorkItem implements Runnable {
        private CreationCallback callback;
        private String objectId;
        private LikeView.ObjectType objectType;

        CreateLikeActionControllerWorkItem(String str, LikeView.ObjectType objectType2, CreationCallback creationCallback) {
            this.objectId = str;
            this.objectType = objectType2;
            this.callback = creationCallback;
        }

        public void run() {
            AppMethodBeat.i(8021);
            LikeActionController.access$2700(this.objectId, this.objectType, this.callback);
            AppMethodBeat.o(8021);
        }
    }
}
