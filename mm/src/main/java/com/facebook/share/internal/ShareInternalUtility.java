package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String STAGING_PARAM = "file";

    static /* synthetic */ NativeAppCallAttachmentStore.Attachment access$000(UUID uuid, ShareMedia shareMedia) {
        AppMethodBeat.i(8331);
        NativeAppCallAttachmentStore.Attachment attachment = getAttachment(uuid, shareMedia);
        AppMethodBeat.o(8331);
        return attachment;
    }

    public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        AppMethodBeat.i(8298);
        if (exc instanceof FacebookException) {
            invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
            AppMethodBeat.o(8298);
            return;
        }
        invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exc.getLocalizedMessage());
        AppMethodBeat.o(8298);
    }

    public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        AppMethodBeat.i(8299);
        invokeOnErrorCallback(facebookCallback, str);
        AppMethodBeat.o(8299);
    }

    public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        AppMethodBeat.i(8300);
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            AppMethodBeat.o(8300);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
        AppMethodBeat.o(8300);
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        AppMethodBeat.i(8301);
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            String string = bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
            AppMethodBeat.o(8301);
            return string;
        }
        String string2 = bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
        AppMethodBeat.o(8301);
        return string2;
    }

    public static String getShareDialogPostId(Bundle bundle) {
        AppMethodBeat.i(8302);
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            String string = bundle.getString(ShareConstants.RESULT_POST_ID);
            AppMethodBeat.o(8302);
            return string;
        } else if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            String string2 = bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
            AppMethodBeat.o(8302);
            return string2;
        } else {
            String string3 = bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
            AppMethodBeat.o(8302);
            return string3;
        }
    }

    public static boolean handleActivityResult(int i2, int i3, Intent intent, ResultProcessor resultProcessor) {
        AppMethodBeat.i(8303);
        AppCall appCallFromActivityResult = getAppCallFromActivityResult(i2, i3, intent);
        if (appCallFromActivityResult == null) {
            AppMethodBeat.o(8303);
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            AppMethodBeat.o(8303);
            return true;
        }
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCallFromActivityResult, NativeProtocol.getSuccessResultsFromIntent(intent));
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
        }
        AppMethodBeat.o(8303);
        return true;
    }

    public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> facebookCallback) {
        AppMethodBeat.i(8304);
        AnonymousClass1 r0 = new ResultProcessor(facebookCallback) {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass1 */

            @Override // com.facebook.share.internal.ResultProcessor
            public final void onSuccess(AppCall appCall, Bundle bundle) {
                AppMethodBeat.i(8279);
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
                        AppMethodBeat.o(8279);
                        return;
                    } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                        AppMethodBeat.o(8279);
                        return;
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(facebookCallback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
                AppMethodBeat.o(8279);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public final void onCancel(AppCall appCall) {
                AppMethodBeat.i(8280);
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                AppMethodBeat.o(8280);
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public final void onError(AppCall appCall, FacebookException facebookException) {
                AppMethodBeat.i(8281);
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
                AppMethodBeat.o(8281);
            }
        };
        AppMethodBeat.o(8304);
        return r0;
    }

    private static AppCall getAppCallFromActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(8305);
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            AppMethodBeat.o(8305);
            return null;
        }
        AppCall finishPendingCall = AppCall.finishPendingCall(callIdFromIntent, i2);
        AppMethodBeat.o(8305);
        return finishPendingCall;
    }

    public static void registerStaticShareCallback(final int i2) {
        AppMethodBeat.i(8306);
        CallbackManagerImpl.registerStaticCallback(i2, new CallbackManagerImpl.Callback() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass2 */

            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                AppMethodBeat.i(8286);
                boolean handleActivityResult = ShareInternalUtility.handleActivityResult(i2, i2, intent, ShareInternalUtility.getShareResultProcessor(null));
                AppMethodBeat.o(8286);
                return handleActivityResult;
            }
        });
        AppMethodBeat.o(8306);
    }

    public static void registerSharerCallback(final int i2, CallbackManager callbackManager, final FacebookCallback<Sharer.Result> facebookCallback) {
        AppMethodBeat.i(8307);
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            AppMethodBeat.o(8307);
            throw facebookException;
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(i2, new CallbackManagerImpl.Callback() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass3 */

            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i2, Intent intent) {
                AppMethodBeat.i(8287);
                boolean handleActivityResult = ShareInternalUtility.handleActivityResult(i2, i2, intent, ShareInternalUtility.getShareResultProcessor(facebookCallback));
                AppMethodBeat.o(8287);
                return handleActivityResult;
            }
        });
        AppMethodBeat.o(8307);
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, final UUID uuid) {
        List<SharePhoto> photos;
        AppMethodBeat.i(8308);
        if (sharePhotoContent == null || (photos = sharePhotoContent.getPhotos()) == null) {
            AppMethodBeat.o(8308);
            return null;
        }
        List map = Utility.map(photos, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8289);
                NativeAppCallAttachmentStore.Attachment apply = apply(sharePhoto);
                AppMethodBeat.o(8289);
                return apply;
            }

            public final NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8288);
                NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                AppMethodBeat.o(8288);
                return access$000;
            }
        });
        List<String> map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ String apply(NativeAppCallAttachmentStore.Attachment attachment) {
                AppMethodBeat.i(8291);
                String apply = apply(attachment);
                AppMethodBeat.o(8291);
                return apply;
            }

            public final String apply(NativeAppCallAttachmentStore.Attachment attachment) {
                AppMethodBeat.i(8290);
                String attachmentUrl = attachment.getAttachmentUrl();
                AppMethodBeat.o(8290);
                return attachmentUrl;
            }
        });
        NativeAppCallAttachmentStore.addAttachments(map);
        AppMethodBeat.o(8308);
        return map2;
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        AppMethodBeat.i(8309);
        if (shareVideoContent == null || shareVideoContent.getVideo() == null) {
            AppMethodBeat.o(8309);
            return null;
        }
        NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(createAttachment);
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        String attachmentUrl = createAttachment.getAttachmentUrl();
        AppMethodBeat.o(8309);
        return attachmentUrl;
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, final UUID uuid) {
        List<ShareMedia> media;
        AppMethodBeat.i(8310);
        if (shareMediaContent == null || (media = shareMediaContent.getMedia()) == null) {
            AppMethodBeat.o(8310);
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        List<Bundle> map = Utility.map(media, new Utility.Mapper<ShareMedia, Bundle>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ Bundle apply(ShareMedia shareMedia) {
                AppMethodBeat.i(8293);
                Bundle apply = apply(shareMedia);
                AppMethodBeat.o(8293);
                return apply;
            }

            public final Bundle apply(ShareMedia shareMedia) {
                AppMethodBeat.i(8292);
                NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                arrayList.add(access$000);
                Bundle bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                AppMethodBeat.o(8292);
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        AppMethodBeat.o(8310);
        return map;
    }

    public static Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        CameraEffectTextures textures;
        AppMethodBeat.i(8311);
        if (shareCameraEffectContent == null || (textures = shareCameraEffectContent.getTextures()) == null) {
            AppMethodBeat.o(8311);
            return null;
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (String str : textures.keySet()) {
            NativeAppCallAttachmentStore.Attachment attachment = getAttachment(uuid, textures.getTextureUri(str), textures.getTextureBitmap(str));
            arrayList.add(attachment);
            bundle.putString(str, attachment.getAttachmentUrl());
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        AppMethodBeat.o(8311);
        return bundle;
    }

    public static JSONObject toJSONObjectForCall(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) {
        HashSet jsonArrayToSet;
        AppMethodBeat.i(8312);
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = OpenGraphJSONUtility.toJSONObject(action, new OpenGraphJSONUtility.PhotoJSONProcessor() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass7 */

            @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
            public final JSONObject toJSONObject(SharePhoto sharePhoto) {
                AppMethodBeat.i(8294);
                NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                if (access$000 == null) {
                    AppMethodBeat.o(8294);
                    return null;
                }
                arrayList.add(access$000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", access$000.getAttachmentUrl());
                    if (sharePhoto.getUserGenerated()) {
                        jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                    }
                    AppMethodBeat.o(8294);
                    return jSONObject;
                } catch (JSONException e2) {
                    FacebookException facebookException = new FacebookException("Unable to attach images", e2);
                    AppMethodBeat.o(8294);
                    throw facebookException;
                }
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(jSONObject.optString("place"))) {
            jSONObject.put("place", shareOpenGraphContent.getPlaceId());
        }
        if (shareOpenGraphContent.getPeopleIds() != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("tags");
            if (optJSONArray == null) {
                jsonArrayToSet = new HashSet();
            } else {
                jsonArrayToSet = Utility.jsonArrayToSet(optJSONArray);
            }
            for (String str : shareOpenGraphContent.getPeopleIds()) {
                jsonArrayToSet.add(str);
            }
            jSONObject.put("tags", new JSONArray((Collection) jsonArrayToSet));
        }
        AppMethodBeat.o(8312);
        return jSONObject;
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) {
        AppMethodBeat.i(8313);
        JSONObject jSONObject = OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass8 */

            @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
            public final JSONObject toJSONObject(SharePhoto sharePhoto) {
                AppMethodBeat.i(8295);
                Uri imageUrl = sharePhoto.getImageUrl();
                if (!Utility.isWebUri(imageUrl)) {
                    FacebookException facebookException = new FacebookException("Only web images may be used in OG objects shared via the web dialog");
                    AppMethodBeat.o(8295);
                    throw facebookException;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", imageUrl.toString());
                    AppMethodBeat.o(8295);
                    return jSONObject;
                } catch (JSONException e2) {
                    FacebookException facebookException2 = new FacebookException("Unable to attach images", e2);
                    AppMethodBeat.o(8295);
                    throw facebookException2;
                }
            }
        });
        AppMethodBeat.o(8313);
        return jSONObject;
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) {
        AppMethodBeat.i(8314);
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONArray) {
                obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
            } else if (obj instanceof JSONObject) {
                obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
            }
            jSONArray2.put(obj);
        }
        AppMethodBeat.o(8314);
        return jSONArray2;
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2;
        AppMethodBeat.i(8315);
        if (jSONObject == null) {
            AppMethodBeat.o(8315);
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i2 = 0; i2 < names.length(); i2++) {
                String string = names.getString(i2);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    jSONObject2 = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    jSONObject2 = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                } else {
                    jSONObject2 = obj;
                }
                Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject3.put(string, jSONObject2);
                    } else if (str == null || str.equals("og")) {
                        jSONObject3.put(str2, jSONObject2);
                    } else {
                        jSONObject4.put(str2, jSONObject2);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject3.put(str2, jSONObject2);
                } else {
                    jSONObject3.put(string, jSONObject2);
                }
            }
            if (jSONObject4.length() > 0) {
                jSONObject3.put("data", jSONObject4);
            }
            AppMethodBeat.o(8315);
            return jSONObject3;
        } catch (JSONException e2) {
            FacebookException facebookException = new FacebookException("Failed to create json object from share content");
            AppMethodBeat.o(8315);
            throw facebookException;
        }
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        AppMethodBeat.i(8316);
        String str2 = null;
        int indexOf = str.indexOf(58);
        if (indexOf != -1 && str.length() > indexOf + 1) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        }
        Pair<String, String> pair = new Pair<>(str2, str);
        AppMethodBeat.o(8316);
        return pair;
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        AppMethodBeat.i(8317);
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            Bitmap bitmap2 = sharePhoto.getBitmap();
            uri = sharePhoto.getImageUrl();
            bitmap = bitmap2;
        } else if (shareMedia instanceof ShareVideo) {
            uri = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            uri = null;
            bitmap = null;
        }
        NativeAppCallAttachmentStore.Attachment attachment = getAttachment(uuid, uri, bitmap);
        AppMethodBeat.o(8317);
        return attachment;
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        AppMethodBeat.i(8318);
        NativeAppCallAttachmentStore.Attachment attachment = null;
        if (bitmap != null) {
            attachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        } else if (uri != null) {
            attachment = NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        AppMethodBeat.o(8318);
        return attachment;
    }

    static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        AppMethodBeat.i(8319);
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
        AppMethodBeat.o(8319);
    }

    static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        AppMethodBeat.i(8320);
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Sharer.Result(str));
        }
        AppMethodBeat.o(8320);
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        AppMethodBeat.i(8321);
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
        AppMethodBeat.o(8321);
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        AppMethodBeat.i(8322);
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
        AppMethodBeat.o(8322);
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        AppMethodBeat.i(8323);
        logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
        AppMethodBeat.o(8323);
    }

    private static void logShareResult(String str, String str2) {
        AppMethodBeat.i(8324);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        }
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_SHARE_RESULT, null, bundle);
        AppMethodBeat.o(8324);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        AppMethodBeat.i(8325);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, bitmap);
        GraphRequest graphRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        AppMethodBeat.o(8325);
        return graphRequest;
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) {
        AppMethodBeat.i(8326);
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
        GraphRequest graphRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        AppMethodBeat.o(8326);
        return graphRequest;
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) {
        AppMethodBeat.i(8327);
        if (Utility.isFileUri(uri)) {
            GraphRequest newUploadStagingResourceWithImageRequest = newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
            AppMethodBeat.o(8327);
            return newUploadStagingResourceWithImageRequest;
        } else if (!Utility.isContentUri(uri)) {
            FacebookException facebookException = new FacebookException("The image Uri must be either a file:// or content:// Uri");
            AppMethodBeat.o(8327);
            throw facebookException;
        } else {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            GraphRequest graphRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
            AppMethodBeat.o(8327);
            return graphRequest;
        }
    }

    public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == LikeView.ObjectType.UNKNOWN) {
            return objectType2;
        }
        if (objectType2 != LikeView.ObjectType.UNKNOWN) {
            return null;
        }
        return objectType;
    }

    public static Bundle getStickerUrl(ShareStoryContent shareStoryContent, final UUID uuid) {
        AppMethodBeat.i(8328);
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            AppMethodBeat.o(8328);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getStickerAsset());
        List map = Utility.map(arrayList, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass9 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8297);
                NativeAppCallAttachmentStore.Attachment apply = apply(sharePhoto);
                AppMethodBeat.o(8297);
                return apply;
            }

            public final NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                AppMethodBeat.i(8296);
                NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                AppMethodBeat.o(8296);
                return access$000;
            }
        });
        List map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass10 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
                AppMethodBeat.i(8283);
                Bundle apply = apply(attachment);
                AppMethodBeat.o(8283);
                return apply;
            }

            public final Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
                AppMethodBeat.i(8282);
                Bundle bundle = new Bundle();
                bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
                String uriExtension = ShareInternalUtility.getUriExtension(attachment.getOriginalUri());
                if (uriExtension != null) {
                    Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                }
                AppMethodBeat.o(8282);
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.addAttachments(map);
        Bundle bundle = (Bundle) map2.get(0);
        AppMethodBeat.o(8328);
        return bundle;
    }

    public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, final UUID uuid) {
        AppMethodBeat.i(8329);
        if (shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null) {
            AppMethodBeat.o(8329);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getBackgroundAsset());
        final ArrayList arrayList2 = new ArrayList();
        List map = Utility.map(arrayList, new Utility.Mapper<ShareMedia, Bundle>() {
            /* class com.facebook.share.internal.ShareInternalUtility.AnonymousClass11 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.internal.Utility.Mapper
            public final /* bridge */ /* synthetic */ Bundle apply(ShareMedia shareMedia) {
                AppMethodBeat.i(8285);
                Bundle apply = apply(shareMedia);
                AppMethodBeat.o(8285);
                return apply;
            }

            public final Bundle apply(ShareMedia shareMedia) {
                AppMethodBeat.i(8284);
                NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                arrayList2.add(access$000);
                Bundle bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                String uriExtension = ShareInternalUtility.getUriExtension(access$000.getOriginalUri());
                if (uriExtension != null) {
                    Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                }
                AppMethodBeat.o(8284);
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList2);
        Bundle bundle = (Bundle) map.get(0);
        AppMethodBeat.o(8329);
        return bundle;
    }

    public static String getUriExtension(Uri uri) {
        AppMethodBeat.i(8330);
        if (uri == null) {
            AppMethodBeat.o(8330);
            return null;
        }
        String uri2 = uri.toString();
        int lastIndexOf = uri2.lastIndexOf(46);
        if (lastIndexOf == -1) {
            AppMethodBeat.o(8330);
            return null;
        }
        String substring = uri2.substring(lastIndexOf);
        AppMethodBeat.o(8330);
        return substring;
    }
}
