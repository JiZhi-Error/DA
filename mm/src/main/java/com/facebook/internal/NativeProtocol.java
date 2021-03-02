package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_ARGS_PROFILE = "com.facebook.platform.extra.PROFILE";
    public static final String EXTRA_ARGS_PROFILE_FIRST_NAME = "com.facebook.platform.extra.PROFILE_FIRST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LAST_NAME = "com.facebook.platform.extra.PROFILE_LAST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LINK = "com.facebook.platform.extra.PROFILE_LINK";
    public static final String EXTRA_ARGS_PROFILE_MIDDLE_NAME = "com.facebook.platform.extra.PROFILE_MIDDLE_NAME";
    public static final String EXTRA_ARGS_PROFILE_NAME = "com.facebook.platform.extra.PROFILE_NAME";
    public static final String EXTRA_ARGS_PROFILE_USER_ID = "com.facebook.platform.extra.PROFILE_USER_ID";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(Integer.valueOf((int) PROTOCOL_VERSION_20170417), Integer.valueOf((int) PROTOCOL_VERSION_20160327), Integer.valueOf((int) PROTOCOL_VERSION_20141218), Integer.valueOf((int) PROTOCOL_VERSION_20141107), Integer.valueOf((int) PROTOCOL_VERSION_20141028), Integer.valueOf((int) PROTOCOL_VERSION_20141001), Integer.valueOf((int) PROTOCOL_VERSION_20140701), Integer.valueOf((int) PROTOCOL_VERSION_20140324), Integer.valueOf((int) PROTOCOL_VERSION_20140204), Integer.valueOf((int) PROTOCOL_VERSION_20131107), Integer.valueOf((int) PROTOCOL_VERSION_20130618), Integer.valueOf((int) PROTOCOL_VERSION_20130502), Integer.valueOf((int) PROTOCOL_VERSION_20121101));
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG = NativeProtocol.class.getName();
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static final List<NativeAppInfo> effectCameraAppInfoList = buildEffectCameraAppInfoList();
    private static final List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
    private static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    static /* synthetic */ TreeSet access$000(NativeAppInfo nativeAppInfo) {
        AppMethodBeat.i(17907);
        TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo = fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        AppMethodBeat.o(17907);
        return fetchAllAvailableProtocolVersionsForAppInfo;
    }

    static {
        AppMethodBeat.i(17908);
        AppMethodBeat.o(17908);
    }

    /* access modifiers changed from: package-private */
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* access modifiers changed from: protected */
        public abstract String getLoginActivity();

        /* access modifiers changed from: protected */
        public abstract String getPackage();

        private NativeAppInfo() {
        }

        public TreeSet<Integer> getAvailableVersions() {
            if (this.availableVersions == null) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0005, code lost:
            if (r1.availableVersions == null) goto L_0x0007;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void fetchAvailableVersions(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L_0x0007
                java.util.TreeSet<java.lang.Integer> r0 = r1.availableVersions     // Catch:{ all -> 0x000f }
                if (r0 != 0) goto L_0x000d
            L_0x0007:
                java.util.TreeSet r0 = com.facebook.internal.NativeProtocol.access$000(r1)     // Catch:{ all -> 0x000f }
                r1.availableVersions = r0     // Catch:{ all -> 0x000f }
            L_0x000d:
                monitor-exit(r1)
                return
            L_0x000f:
                r0 = move-exception
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }
    }

    /* access modifiers changed from: package-private */
    public static class KatanaAppInfo extends NativeAppInfo {
        static final String KATANA_PACKAGE = "com.facebook.katana";

        private KatanaAppInfo() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return KATANA_PACKAGE;
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }
    }

    /* access modifiers changed from: package-private */
    public static class MessengerAppInfo extends NativeAppInfo {
        static final String MESSENGER_PACKAGE = "com.facebook.orca";

        private MessengerAppInfo() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return MESSENGER_PACKAGE;
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class WakizashiAppInfo extends NativeAppInfo {
        static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";

        private WakizashiAppInfo() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return WAKIZASHI_PACKAGE;
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }
    }

    static class FBLiteAppInfo extends NativeAppInfo {
        static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";
        static final String FBLITE_PACKAGE = "com.facebook.lite";

        private FBLiteAppInfo() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return FBLITE_PACKAGE;
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return FACEBOOK_LITE_ACTIVITY;
        }
    }

    /* access modifiers changed from: package-private */
    public static class EffectTestAppInfo extends NativeAppInfo {
        static final String EFFECT_TEST_APP_PACKAGE = "com.facebook.arstudio.player";

        private EffectTestAppInfo() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return EFFECT_TEST_APP_PACKAGE;
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return null;
        }
    }

    private static List<NativeAppInfo> buildFacebookAppList() {
        AppMethodBeat.i(17876);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KatanaAppInfo());
        arrayList.add(new WakizashiAppInfo());
        AppMethodBeat.o(17876);
        return arrayList;
    }

    private static List<NativeAppInfo> buildEffectCameraAppInfoList() {
        AppMethodBeat.i(17877);
        ArrayList arrayList = new ArrayList(buildFacebookAppList());
        arrayList.add(0, new EffectTestAppInfo());
        AppMethodBeat.o(17877);
        return arrayList;
    }

    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        AppMethodBeat.i(17878);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_APPINVITE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
        hashMap.put(ACTION_SHARE_STORY, facebookAppInfoList);
        AppMethodBeat.o(17878);
        return hashMap;
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        AppMethodBeat.i(17879);
        if (intent == null) {
            AppMethodBeat.o(17879);
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            AppMethodBeat.o(17879);
            return null;
        } else if (!FacebookSignatureValidator.validateSignature(context, resolveActivity.activityInfo.packageName)) {
            AppMethodBeat.o(17879);
            return null;
        } else {
            AppMethodBeat.o(17879);
            return intent;
        }
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        AppMethodBeat.i(17880);
        if (intent == null) {
            AppMethodBeat.o(17880);
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            AppMethodBeat.o(17880);
            return null;
        } else if (!FacebookSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            AppMethodBeat.o(17880);
            return null;
        } else {
            AppMethodBeat.o(17880);
            return intent;
        }
    }

    public static Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.i(17881);
        FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
        Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), fBLiteAppInfo);
        AppMethodBeat.o(17881);
        return validateActivityIntent;
    }

    private static Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.i(17882);
        String loginActivity = nativeAppInfo.getLoginActivity();
        if (loginActivity == null) {
            AppMethodBeat.o(17882);
            return null;
        }
        Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
        putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if (z2) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
        AppMethodBeat.o(17882);
        return putExtra;
    }

    public static Intent createProxyAuthIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.i(17883);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(nativeAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), nativeAppInfo);
            if (validateActivityIntent != null) {
                AppMethodBeat.o(17883);
                return validateActivityIntent;
            }
        }
        AppMethodBeat.o(17883);
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        AppMethodBeat.i(17884);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), nativeAppInfo);
            if (validateServiceIntent != null) {
                AppMethodBeat.o(17884);
                return validateServiceIntent;
            }
        }
        AppMethodBeat.o(17884);
        return null;
    }

    public static final int getLatestKnownVersion() {
        AppMethodBeat.i(17885);
        int intValue = KNOWN_PROTOCOL_VERSIONS.get(0).intValue();
        AppMethodBeat.o(17885);
        return intValue;
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i2) {
        AppMethodBeat.i(17886);
        if (!KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i2)) || i2 < 20140701) {
            AppMethodBeat.o(17886);
            return false;
        }
        AppMethodBeat.o(17886);
        return true;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        AppMethodBeat.i(17887);
        if (protocolVersionQueryResult == null) {
            AppMethodBeat.o(17887);
            return null;
        }
        NativeAppInfo nativeAppInfo = protocolVersionQueryResult.nativeAppInfo;
        if (nativeAppInfo == null) {
            AppMethodBeat.o(17887);
            return null;
        }
        Intent validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
        if (validateActivityIntent == null) {
            AppMethodBeat.o(17887);
            return null;
        }
        setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.protocolVersion, bundle);
        AppMethodBeat.o(17887);
        return validateActivityIntent;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i2, Bundle bundle) {
        AppMethodBeat.i(17888);
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i2).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            AppMethodBeat.o(17888);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        intent.putExtras(bundle);
        AppMethodBeat.o(17888);
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(17889);
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            AppMethodBeat.o(17889);
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
        }
        AppMethodBeat.o(17889);
        return intent2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        AppMethodBeat.i(17890);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (validateServiceIntent != null) {
                AppMethodBeat.o(17890);
                return validateServiceIntent;
            }
        }
        AppMethodBeat.o(17890);
        return null;
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        AppMethodBeat.i(17891);
        int intExtra = intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        AppMethodBeat.o(17891);
        return intExtra;
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        String stringExtra;
        UUID uuid = null;
        AppMethodBeat.i(17892);
        if (intent == null) {
            AppMethodBeat.o(17892);
        } else {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (stringExtra != null) {
                try {
                    uuid = UUID.fromString(stringExtra);
                } catch (IllegalArgumentException e2) {
                }
            }
            AppMethodBeat.o(17892);
        }
        return uuid;
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        AppMethodBeat.i(17893);
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            AppMethodBeat.o(17893);
            return null;
        }
        Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
        AppMethodBeat.o(17893);
        return bundleExtra;
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        AppMethodBeat.i(17894);
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle extras = intent.getExtras();
            AppMethodBeat.o(17894);
            return extras;
        }
        Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        AppMethodBeat.o(17894);
        return bundleExtra;
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        AppMethodBeat.i(17895);
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        if (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) {
            AppMethodBeat.o(17895);
            return extras;
        }
        Bundle bundle = extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
        AppMethodBeat.o(17895);
        return bundle;
    }

    public static boolean isErrorResult(Intent intent) {
        AppMethodBeat.i(17896);
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            boolean containsKey = bridgeArgumentsFromIntent.containsKey("error");
            AppMethodBeat.o(17896);
            return containsKey;
        }
        boolean hasExtra = intent.hasExtra(STATUS_ERROR_TYPE);
        AppMethodBeat.o(17896);
        return hasExtra;
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        AppMethodBeat.i(17897);
        if (!isErrorResult(intent)) {
            AppMethodBeat.o(17897);
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            Bundle bundle = bridgeArgumentsFromIntent.getBundle("error");
            AppMethodBeat.o(17897);
            return bundle;
        }
        Bundle extras = intent.getExtras();
        AppMethodBeat.o(17897);
        return extras;
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        AppMethodBeat.i(17898);
        if (bundle == null) {
            AppMethodBeat.o(17898);
            return null;
        }
        String string = bundle.getString(BRIDGE_ARG_ERROR_TYPE);
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        if (string == null || !string.equalsIgnoreCase(ERROR_USER_CANCELED)) {
            FacebookException facebookException = new FacebookException(string2);
            AppMethodBeat.o(17898);
            return facebookException;
        }
        FacebookOperationCanceledException facebookOperationCanceledException = new FacebookOperationCanceledException(string2);
        AppMethodBeat.o(17898);
        return facebookOperationCanceledException;
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        AppMethodBeat.i(17899);
        if (facebookException == null) {
            AppMethodBeat.o(17899);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
        }
        AppMethodBeat.o(17899);
        return bundle;
    }

    public static int getLatestAvailableProtocolVersionForService(int i2) {
        AppMethodBeat.i(17900);
        int protocolVersion = getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i2}).getProtocolVersion();
        AppMethodBeat.o(17900);
        return protocolVersion;
    }

    public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        AppMethodBeat.i(17901);
        ProtocolVersionQueryResult latestAvailableProtocolVersionForAppInfoList = getLatestAvailableProtocolVersionForAppInfoList(actionToAppInfoMap.get(str), iArr);
        AppMethodBeat.o(17901);
        return latestAvailableProtocolVersionForAppInfoList;
    }

    private static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> list, int[] iArr) {
        AppMethodBeat.i(17902);
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            ProtocolVersionQueryResult createEmpty = ProtocolVersionQueryResult.createEmpty();
            AppMethodBeat.o(17902);
            return createEmpty;
        }
        for (NativeAppInfo nativeAppInfo : list) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                ProtocolVersionQueryResult create = ProtocolVersionQueryResult.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                AppMethodBeat.o(17902);
                return create;
            }
        }
        ProtocolVersionQueryResult createEmpty2 = ProtocolVersionQueryResult.createEmpty();
        AppMethodBeat.o(17902);
        return createEmpty2;
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        AppMethodBeat.i(17903);
        if (!protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            AppMethodBeat.o(17903);
            return;
        }
        FacebookSdk.getExecutor().execute(new Runnable() {
            /* class com.facebook.internal.NativeProtocol.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(17873);
                try {
                    for (NativeAppInfo nativeAppInfo : NativeProtocol.facebookAppInfoList) {
                        nativeAppInfo.fetchAvailableVersions(true);
                    }
                } finally {
                    NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                    AppMethodBeat.o(17873);
                }
            }
        });
        AppMethodBeat.o(17903);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r9) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i2, int[] iArr) {
        AppMethodBeat.i(17905);
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int i3 = -1;
        int length = iArr.length - 1;
        while (descendingIterator.hasNext()) {
            int intValue = descendingIterator.next().intValue();
            int max = Math.max(i3, intValue);
            while (length >= 0 && iArr[length] > intValue) {
                length--;
            }
            if (length < 0) {
                AppMethodBeat.o(17905);
                return -1;
            } else if (iArr[length] != intValue) {
                i3 = max;
            } else if (length % 2 == 0) {
                int min = Math.min(max, i2);
                AppMethodBeat.o(17905);
                return min;
            } else {
                AppMethodBeat.o(17905);
                return -1;
            }
        }
        AppMethodBeat.o(17905);
        return -1;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        AppMethodBeat.i(17906);
        Uri parse = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
        AppMethodBeat.o(17906);
        return parse;
    }

    public static class ProtocolVersionQueryResult {
        private NativeAppInfo nativeAppInfo;
        private int protocolVersion;

        public static ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo2, int i2) {
            AppMethodBeat.i(17874);
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.nativeAppInfo = nativeAppInfo2;
            protocolVersionQueryResult.protocolVersion = i2;
            AppMethodBeat.o(17874);
            return protocolVersionQueryResult;
        }

        public static ProtocolVersionQueryResult createEmpty() {
            AppMethodBeat.i(17875);
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.protocolVersion = -1;
            AppMethodBeat.o(17875);
            return protocolVersionQueryResult;
        }

        private ProtocolVersionQueryResult() {
        }

        public NativeAppInfo getAppInfo() {
            return this.nativeAppInfo;
        }

        public int getProtocolVersion() {
            return this.protocolVersion;
        }
    }
}
