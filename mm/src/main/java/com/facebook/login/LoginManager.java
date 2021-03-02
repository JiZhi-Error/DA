package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager {
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static volatile LoginManager instance;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private final SharedPreferences sharedPreferences;

    static /* synthetic */ void access$100(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.i(7950);
        handleLoginStatusError(str, str2, str3, loginLogger, loginStatusCallback);
        AppMethodBeat.o(7950);
    }

    static /* synthetic */ Profile access$200(Bundle bundle) {
        AppMethodBeat.i(7951);
        Profile profileFromBundle = getProfileFromBundle(bundle);
        AppMethodBeat.o(7951);
        return profileFromBundle;
    }

    static {
        AppMethodBeat.i(7952);
        AppMethodBeat.o(7952);
    }

    LoginManager() {
        AppMethodBeat.i(7905);
        Validate.sdkInitialized();
        this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        AppMethodBeat.o(7905);
    }

    public static LoginManager getInstance() {
        AppMethodBeat.i(7906);
        if (instance == null) {
            synchronized (LoginManager.class) {
                try {
                    if (instance == null) {
                        instance = new LoginManager();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(7906);
                    throw th;
                }
            }
        }
        LoginManager loginManager = instance;
        AppMethodBeat.o(7906);
        return loginManager;
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        AppMethodBeat.i(7907);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
        AppMethodBeat.o(7907);
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        AppMethodBeat.i(7908);
        resolveError(new FragmentWrapper(fragment), graphResponse);
        AppMethodBeat.o(7908);
    }

    public void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        AppMethodBeat.i(7909);
        resolveError(new FragmentWrapper(fragment), graphResponse);
        AppMethodBeat.o(7909);
    }

    private void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        AppMethodBeat.i(7910);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
        AppMethodBeat.o(7910);
    }

    private LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        AppMethodBeat.i(7911);
        Validate.notNull(graphResponse, "response");
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        LoginClient.Request createLoginRequest = createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
        AppMethodBeat.o(7911);
        return createLoginRequest;
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.i(7912);
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            AppMethodBeat.o(7912);
            throw facebookException;
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.login.LoginManager.AnonymousClass1 */

            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i2, Intent intent) {
                AppMethodBeat.i(7894);
                boolean onActivityResult = LoginManager.this.onActivityResult(i2, intent, facebookCallback);
                AppMethodBeat.o(7894);
                return onActivityResult;
            }
        });
        AppMethodBeat.o(7912);
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        AppMethodBeat.i(7913);
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            AppMethodBeat.o(7913);
            throw facebookException;
        }
        ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
        AppMethodBeat.o(7913);
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i2, Intent intent) {
        AppMethodBeat.i(7914);
        boolean onActivityResult = onActivityResult(i2, intent, null);
        AppMethodBeat.o(7914);
        return onActivityResult;
    }

    /* access modifiers changed from: package-private */
    public boolean onActivityResult(int i2, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        AccessToken accessToken;
        FacebookException facebookException;
        LoginClient.Request request;
        Map<String, String> map;
        LoginClient.Result.Code code;
        AccessToken accessToken2;
        AccessToken accessToken3;
        FacebookException facebookException2;
        AppMethodBeat.i(7915);
        FacebookException facebookException3 = null;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        Map<String, String> map2 = null;
        LoginClient.Request request2 = null;
        boolean z2 = false;
        if (intent != null) {
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i2 == -1) {
                    if (result.code == LoginClient.Result.Code.SUCCESS) {
                        accessToken3 = result.token;
                        facebookException2 = null;
                    } else {
                        facebookException2 = new FacebookAuthorizationException(result.errorMessage);
                        accessToken3 = null;
                    }
                } else if (i2 == 0) {
                    z2 = true;
                    accessToken3 = null;
                    facebookException2 = null;
                } else {
                    accessToken3 = null;
                    facebookException2 = null;
                }
                Map<String, String> map3 = result.loggingExtras;
                request = request3;
                map = map3;
                code = code3;
                accessToken2 = accessToken3;
                facebookException3 = facebookException2;
            } else {
                request = null;
                map = null;
                code = code2;
                accessToken2 = null;
            }
            z = z2;
            request2 = request;
            map2 = map;
            code2 = code;
            accessToken = accessToken2;
        } else if (i2 == 0) {
            code2 = LoginClient.Result.Code.CANCEL;
            z = true;
            accessToken = null;
        } else {
            z = false;
            accessToken = null;
        }
        if (facebookException3 == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        } else {
            facebookException = facebookException3;
        }
        logCompleteLogin(null, code2, map2, facebookException, true, request2);
        finishLogin(accessToken, request2, facebookException, z, facebookCallback);
        AppMethodBeat.o(7915);
        return true;
    }

    static Map<String, String> getExtraDataFromIntent(Intent intent) {
        AppMethodBeat.i(7916);
        if (intent == null) {
            AppMethodBeat.o(7916);
            return null;
        }
        LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
        if (result == null) {
            AppMethodBeat.o(7916);
            return null;
        }
        Map<String, String> map = result.extraData;
        AppMethodBeat.o(7916);
        return map;
    }

    public LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        this.loginBehavior = loginBehavior2;
        return this;
    }

    public DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public String getAuthType() {
        return this.authType;
    }

    public LoginManager setAuthType(String str) {
        this.authType = str;
        return this;
    }

    public void logOut() {
        AppMethodBeat.i(7917);
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
        setExpressLoginStatus(false);
        AppMethodBeat.o(7917);
    }

    public void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.i(7918);
        retrieveLoginStatus(context, 5000, loginStatusCallback);
        AppMethodBeat.o(7918);
    }

    public void retrieveLoginStatus(Context context, long j2, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.i(7919);
        retrieveLoginStatusImpl(context, loginStatusCallback, j2);
        AppMethodBeat.o(7919);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        AppMethodBeat.i(7920);
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
        AppMethodBeat.o(7920);
    }

    public void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        AppMethodBeat.i(7921);
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
        AppMethodBeat.o(7921);
    }

    private void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        AppMethodBeat.i(7922);
        validateReadPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequest(collection));
        AppMethodBeat.o(7922);
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        AppMethodBeat.i(7923);
        validateReadPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
        AppMethodBeat.o(7923);
    }

    public void reauthorizeDataAccess(Activity activity) {
        AppMethodBeat.i(7924);
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
        AppMethodBeat.o(7924);
    }

    public void reauthorizeDataAccess(Fragment fragment) {
        AppMethodBeat.i(7925);
        reauthorizeDataAccess(new FragmentWrapper(fragment));
        AppMethodBeat.o(7925);
    }

    private void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        AppMethodBeat.i(7926);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
        AppMethodBeat.o(7926);
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        AppMethodBeat.i(7927);
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
        AppMethodBeat.o(7927);
    }

    public void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        AppMethodBeat.i(7928);
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
        AppMethodBeat.o(7928);
    }

    private void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        AppMethodBeat.i(7929);
        validatePublishPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequest(collection));
        AppMethodBeat.o(7929);
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        AppMethodBeat.i(7930);
        validatePublishPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
        AppMethodBeat.o(7930);
    }

    private void validateReadPermissions(Collection<String> collection) {
        AppMethodBeat.i(7931);
        if (collection == null) {
            AppMethodBeat.o(7931);
            return;
        }
        for (String str : collection) {
            if (isPublishPermission(str)) {
                FacebookException facebookException = new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                AppMethodBeat.o(7931);
                throw facebookException;
            }
        }
        AppMethodBeat.o(7931);
    }

    private void validatePublishPermissions(Collection<String> collection) {
        AppMethodBeat.i(7932);
        if (collection == null) {
            AppMethodBeat.o(7932);
            return;
        }
        for (String str : collection) {
            if (!isPublishPermission(str)) {
                FacebookException facebookException = new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", str));
                AppMethodBeat.o(7932);
                throw facebookException;
            }
        }
        AppMethodBeat.o(7932);
    }

    static boolean isPublishPermission(String str) {
        AppMethodBeat.i(7933);
        if (str == null || (!str.startsWith(PUBLISH_PERMISSION_PREFIX) && !str.startsWith(MANAGE_PERMISSION_PREFIX) && !OTHER_PUBLISH_PERMISSIONS.contains(str))) {
            AppMethodBeat.o(7933);
            return false;
        }
        AppMethodBeat.o(7933);
        return true;
    }

    private static Set<String> getOtherPublishPermissions() {
        AppMethodBeat.i(7934);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet<String>() {
            /* class com.facebook.login.LoginManager.AnonymousClass2 */

            {
                AppMethodBeat.i(7895);
                add("ads_management");
                add("create_event");
                add("rsvp_event");
                AppMethodBeat.o(7895);
            }
        });
        AppMethodBeat.o(7934);
        return unmodifiableSet;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        AppMethodBeat.i(7935);
        LoginClient.Request request = new LoginClient.Request(this.loginBehavior, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.defaultAudience, this.authType, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.setRerequest(AccessToken.isCurrentAccessTokenActive());
        AppMethodBeat.o(7935);
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createReauthorizeRequest() {
        AppMethodBeat.i(7936);
        LoginClient.Request request = new LoginClient.Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.defaultAudience, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        AppMethodBeat.o(7936);
        return request;
    }

    private void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        AppMethodBeat.i(7937);
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() {
            /* class com.facebook.login.LoginManager.AnonymousClass3 */

            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i2, Intent intent) {
                AppMethodBeat.i(7896);
                boolean onActivityResult = LoginManager.this.onActivityResult(i2, intent);
                AppMethodBeat.o(7896);
                return onActivityResult;
            }
        });
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
            AppMethodBeat.o(7937);
            throw facebookException;
        }
        AppMethodBeat.o(7937);
    }

    private void logStartLogin(Context context, LoginClient.Request request) {
        AppMethodBeat.i(7938);
        LoginLogger access$000 = LoginLoggerHolder.access$000(context);
        if (!(access$000 == null || request == null)) {
            access$000.logStartLogin(request);
        }
        AppMethodBeat.o(7938);
    }

    private void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        AppMethodBeat.i(7939);
        LoginLogger access$000 = LoginLoggerHolder.access$000(context);
        if (access$000 == null) {
            AppMethodBeat.o(7939);
        } else if (request == null) {
            access$000.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            AppMethodBeat.o(7939);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("try_login_activity", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            access$000.logCompleteLogin(request.getAuthId(), hashMap, code, map, exc);
            AppMethodBeat.o(7939);
        }
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        AppMethodBeat.i(7940);
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            AppMethodBeat.o(7940);
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.getLoginRequestCode());
            AppMethodBeat.o(7940);
            return true;
        } catch (ActivityNotFoundException e2) {
            AppMethodBeat.o(7940);
            return false;
        }
    }

    private boolean resolveIntent(Intent intent) {
        AppMethodBeat.i(7941);
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null) {
            AppMethodBeat.o(7941);
            return true;
        }
        AppMethodBeat.o(7941);
        return false;
    }

    /* access modifiers changed from: protected */
    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        AppMethodBeat.i(7942);
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        AppMethodBeat.o(7942);
        return intent;
    }

    static LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken) {
        AppMethodBeat.i(7943);
        Set<String> permissions = request.getPermissions();
        HashSet hashSet = new HashSet(accessToken.getPermissions());
        if (request.isRerequest()) {
            hashSet.retainAll(permissions);
        }
        HashSet hashSet2 = new HashSet(permissions);
        hashSet2.removeAll(hashSet);
        LoginResult loginResult = new LoginResult(accessToken, hashSet, hashSet2);
        AppMethodBeat.o(7943);
        return loginResult;
    }

    private void finishLogin(AccessToken accessToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.i(7944);
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = accessToken != null ? computeLoginResult(request, accessToken) : null;
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
                AppMethodBeat.o(7944);
                return;
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
                AppMethodBeat.o(7944);
                return;
            } else if (accessToken != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
        AppMethodBeat.o(7944);
    }

    private void retrieveLoginStatusImpl(Context context, final LoginStatusCallback loginStatusCallback, long j2) {
        AppMethodBeat.i(7945);
        final String applicationId = FacebookSdk.getApplicationId();
        final String uuid = UUID.randomUUID().toString();
        final LoginLogger loginLogger = new LoginLogger(context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            AppMethodBeat.o(7945);
            return;
        }
        LoginStatusClient loginStatusClient = new LoginStatusClient(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j2);
        loginStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
            /* class com.facebook.login.LoginManager.AnonymousClass4 */

            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public void completed(Bundle bundle) {
                String str;
                AppMethodBeat.i(7897);
                if (bundle != null) {
                    String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
                    String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
                    if (string != null) {
                        LoginManager.access$100(string, string2, uuid, loginLogger, loginStatusCallback);
                        AppMethodBeat.o(7897);
                        return;
                    }
                    String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
                    Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                    String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
                    Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
                    if (!Utility.isNullOrEmpty(string4)) {
                        str = LoginMethodHandler.getUserIDFromSignedRequest(string4);
                    } else {
                        str = null;
                    }
                    if (Utility.isNullOrEmpty(string3) || stringArrayList == null || stringArrayList.isEmpty() || Utility.isNullOrEmpty(str)) {
                        loginLogger.logLoginStatusFailure(uuid);
                        loginStatusCallback.onFailure();
                        AppMethodBeat.o(7897);
                        return;
                    }
                    AccessToken accessToken = new AccessToken(string3, applicationId, str, stringArrayList, null, null, bundleLongAsDate, null, bundleLongAsDate2);
                    AccessToken.setCurrentAccessToken(accessToken);
                    Profile access$200 = LoginManager.access$200(bundle);
                    if (access$200 != null) {
                        Profile.setCurrentProfile(access$200);
                    } else {
                        Profile.fetchProfileForCurrentAccessToken();
                    }
                    loginLogger.logLoginStatusSuccess(uuid);
                    loginStatusCallback.onCompleted(accessToken);
                    AppMethodBeat.o(7897);
                    return;
                }
                loginLogger.logLoginStatusFailure(uuid);
                loginStatusCallback.onFailure();
                AppMethodBeat.o(7897);
            }
        });
        loginLogger.logLoginStatusStart(uuid);
        if (!loginStatusClient.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
        AppMethodBeat.o(7945);
    }

    private void setExpressLoginStatus(boolean z) {
        AppMethodBeat.i(7946);
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        edit.apply();
        AppMethodBeat.o(7946);
    }

    private boolean isExpressLoginAllowed() {
        AppMethodBeat.i(7947);
        boolean z = this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
        AppMethodBeat.o(7947);
        return z;
    }

    private static Profile getProfileFromBundle(Bundle bundle) {
        AppMethodBeat.i(7948);
        String string = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_NAME);
        String string2 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_FIRST_NAME);
        String string3 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_MIDDLE_NAME);
        String string4 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_LAST_NAME);
        String string5 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_LINK);
        String string6 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_USER_ID);
        if (string == null || string2 == null || string3 == null || string4 == null || string5 == null || string6 == null) {
            AppMethodBeat.o(7948);
            return null;
        }
        Profile profile = new Profile(string6, string2, string3, string4, string, Uri.parse(string5));
        AppMethodBeat.o(7948);
        return profile;
    }

    private static void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.i(7949);
        FacebookException facebookException = new FacebookException(str + ": " + str2);
        loginLogger.logLoginStatusError(str3, facebookException);
        loginStatusCallback.onError(facebookException);
        AppMethodBeat.o(7949);
    }

    static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity2) {
            AppMethodBeat.i(7898);
            Validate.notNull(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            this.activity = activity2;
            AppMethodBeat.o(7898);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i2) {
            AppMethodBeat.i(7899);
            this.activity.startActivityForResult(intent, i2);
            AppMethodBeat.o(7899);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activity;
        }
    }

    /* access modifiers changed from: package-private */
    public static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            AppMethodBeat.i(7900);
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            AppMethodBeat.o(7900);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i2) {
            AppMethodBeat.i(7901);
            this.fragment.startActivityForResult(intent, i2);
            AppMethodBeat.o(7901);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            AppMethodBeat.i(7902);
            Activity activity = this.fragment.getActivity();
            AppMethodBeat.o(7902);
            return activity;
        }
    }

    /* access modifiers changed from: package-private */
    public static class LoginLoggerHolder {
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        static /* synthetic */ LoginLogger access$000(Context context) {
            AppMethodBeat.i(7904);
            LoginLogger logger2 = getLogger(context);
            AppMethodBeat.o(7904);
            return logger2;
        }

        private static synchronized LoginLogger getLogger(Context context) {
            LoginLogger loginLogger;
            synchronized (LoginLoggerHolder.class) {
                AppMethodBeat.i(7903);
                if (context == null) {
                    context = FacebookSdk.getApplicationContext();
                }
                if (context == null) {
                    loginLogger = null;
                    AppMethodBeat.o(7903);
                } else {
                    if (logger == null) {
                        logger = new LoginLogger(context, FacebookSdk.getApplicationId());
                    }
                    loginLogger = logger;
                    AppMethodBeat.o(7903);
                }
            }
            return loginLogger;
        }
    }
}
