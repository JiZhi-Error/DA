package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator<LoginClient>() {
        /* class com.facebook.login.LoginClient.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final LoginClient createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7813);
            LoginClient loginClient = new LoginClient(parcel);
            AppMethodBeat.o(7813);
            return loginClient;
        }

        @Override // android.os.Parcelable.Creator
        public final LoginClient[] newArray(int i2) {
            return new LoginClient[i2];
        }
    };
    BackgroundProcessingListener backgroundProcessingListener;
    boolean checkedInternetPermission;
    int currentHandler = -1;
    Map<String, String> extraData;
    Fragment fragment;
    LoginMethodHandler[] handlersToTry;
    Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    OnCompletedListener onCompletedListener;
    Request pendingRequest;

    /* access modifiers changed from: package-private */
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    public LoginClient(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    /* access modifiers changed from: package-private */
    public void setFragment(Fragment fragment2) {
        AppMethodBeat.i(7839);
        if (this.fragment != null) {
            FacebookException facebookException = new FacebookException("Can't set fragment once it is already set.");
            AppMethodBeat.o(7839);
            throw facebookException;
        }
        this.fragment = fragment2;
        AppMethodBeat.o(7839);
    }

    /* access modifiers changed from: package-private */
    public FragmentActivity getActivity() {
        AppMethodBeat.i(7840);
        FragmentActivity activity = this.fragment.getActivity();
        AppMethodBeat.o(7840);
        return activity;
    }

    public Request getPendingRequest() {
        return this.pendingRequest;
    }

    public static int getLoginRequestCode() {
        AppMethodBeat.i(7841);
        int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        AppMethodBeat.o(7841);
        return requestCode;
    }

    /* access modifiers changed from: package-private */
    public void startOrContinueAuth(Request request) {
        AppMethodBeat.i(7842);
        if (!getInProgress()) {
            authorize(request);
        }
        AppMethodBeat.o(7842);
    }

    /* access modifiers changed from: package-private */
    public void authorize(Request request) {
        AppMethodBeat.i(7843);
        if (request == null) {
            AppMethodBeat.o(7843);
        } else if (this.pendingRequest != null) {
            FacebookException facebookException = new FacebookException("Attempted to authorize while a request is pending.");
            AppMethodBeat.o(7843);
            throw facebookException;
        } else if (!AccessToken.isCurrentAccessTokenActive() || checkInternetPermission()) {
            this.pendingRequest = request;
            this.handlersToTry = getHandlersToTry(request);
            tryNextHandler();
            AppMethodBeat.o(7843);
        } else {
            AppMethodBeat.o(7843);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    /* access modifiers changed from: package-private */
    public void cancelCurrentHandler() {
        AppMethodBeat.i(7844);
        if (this.currentHandler >= 0) {
            getCurrentHandler().cancel();
        }
        AppMethodBeat.o(7844);
    }

    /* access modifiers changed from: package-private */
    public LoginMethodHandler getCurrentHandler() {
        if (this.currentHandler >= 0) {
            return this.handlersToTry[this.currentHandler];
        }
        return null;
    }

    public boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(7845);
        if (this.pendingRequest != null) {
            boolean onActivityResult = getCurrentHandler().onActivityResult(i2, i3, intent);
            AppMethodBeat.o(7845);
            return onActivityResult;
        }
        AppMethodBeat.o(7845);
        return false;
    }

    /* access modifiers changed from: protected */
    public LoginMethodHandler[] getHandlersToTry(Request request) {
        AppMethodBeat.i(7846);
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (loginBehavior.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        AppMethodBeat.o(7846);
        return loginMethodHandlerArr;
    }

    /* access modifiers changed from: package-private */
    public boolean checkInternetPermission() {
        AppMethodBeat.i(7847);
        if (this.checkedInternetPermission) {
            AppMethodBeat.o(7847);
            return true;
        } else if (checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity activity = getActivity();
            complete(Result.createErrorResult(this.pendingRequest, activity.getString(R.string.b81), activity.getString(R.string.b80)));
            AppMethodBeat.o(7847);
            return false;
        } else {
            this.checkedInternetPermission = true;
            AppMethodBeat.o(7847);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void tryNextHandler() {
        AppMethodBeat.i(7848);
        if (this.currentHandler >= 0) {
            logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
        }
        while (this.handlersToTry != null && this.currentHandler < this.handlersToTry.length - 1) {
            this.currentHandler++;
            if (tryCurrentHandler()) {
                AppMethodBeat.o(7848);
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
        AppMethodBeat.o(7848);
    }

    private void completeWithFailure() {
        AppMethodBeat.i(7849);
        complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
        AppMethodBeat.o(7849);
    }

    private void addLoggingExtra(String str, String str2, boolean z) {
        AppMethodBeat.i(7850);
        if (this.loggingExtras == null) {
            this.loggingExtras = new HashMap();
        }
        if (this.loggingExtras.containsKey(str) && z) {
            str2 = this.loggingExtras.get(str) + "," + str2;
        }
        this.loggingExtras.put(str, str2);
        AppMethodBeat.o(7850);
    }

    /* access modifiers changed from: package-private */
    public void addExtraData(String str, String str2, boolean z) {
        AppMethodBeat.i(7851);
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        if (this.extraData.containsKey(str) && z) {
            str2 = this.extraData.get(str) + "," + str2;
        }
        this.extraData.put(str, str2);
        AppMethodBeat.o(7851);
    }

    /* access modifiers changed from: package-private */
    public boolean tryCurrentHandler() {
        boolean z = false;
        AppMethodBeat.i(7852);
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (!currentHandler2.needsInternetPermission() || checkInternetPermission()) {
            z = currentHandler2.tryAuthorize(this.pendingRequest);
            if (z) {
                getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), currentHandler2.getNameForLogging());
            } else {
                getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), currentHandler2.getNameForLogging());
                addLoggingExtra("not_tried", currentHandler2.getNameForLogging(), true);
            }
            AppMethodBeat.o(7852);
        } else {
            addLoggingExtra("no_internet_permission", "1", false);
            AppMethodBeat.o(7852);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void completeAndValidate(Result result) {
        AppMethodBeat.i(7853);
        if (result.token == null || !AccessToken.isCurrentAccessTokenActive()) {
            complete(result);
            AppMethodBeat.o(7853);
            return;
        }
        validateSameFbidAndFinish(result);
        AppMethodBeat.o(7853);
    }

    /* access modifiers changed from: package-private */
    public void complete(Result result) {
        AppMethodBeat.i(7854);
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            logAuthorizationMethodComplete(currentHandler2.getNameForLogging(), result, currentHandler2.methodLoggingExtras);
        }
        if (this.loggingExtras != null) {
            result.loggingExtras = this.loggingExtras;
        }
        if (this.extraData != null) {
            result.extraData = this.extraData;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        notifyOnCompleteListener(result);
        AppMethodBeat.o(7854);
    }

    /* access modifiers changed from: package-private */
    public OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnCompletedListener(OnCompletedListener onCompletedListener2) {
        this.onCompletedListener = onCompletedListener2;
    }

    /* access modifiers changed from: package-private */
    public BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener2) {
        this.backgroundProcessingListener = backgroundProcessingListener2;
    }

    /* access modifiers changed from: package-private */
    public int checkPermission(String str) {
        AppMethodBeat.i(7855);
        int checkCallingOrSelfPermission = getActivity().checkCallingOrSelfPermission(str);
        AppMethodBeat.o(7855);
        return checkCallingOrSelfPermission;
    }

    /* access modifiers changed from: package-private */
    public void validateSameFbidAndFinish(Result result) {
        Result createErrorResult;
        AppMethodBeat.i(7856);
        if (result.token == null) {
            FacebookException facebookException = new FacebookException("Can't validate without a token");
            AppMethodBeat.o(7856);
            throw facebookException;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AccessToken accessToken = result.token;
        if (!(currentAccessToken == null || accessToken == null)) {
            try {
                if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                    createErrorResult = Result.createTokenResult(this.pendingRequest, result.token);
                    complete(createErrorResult);
                    AppMethodBeat.o(7856);
                }
            } catch (Exception e2) {
                complete(Result.createErrorResult(this.pendingRequest, "Caught exception", e2.getMessage()));
                AppMethodBeat.o(7856);
                return;
            }
        }
        createErrorResult = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
        complete(createErrorResult);
        AppMethodBeat.o(7856);
    }

    private LoginLogger getLogger() {
        AppMethodBeat.i(7857);
        if (this.loginLogger == null || !this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())) {
            this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
        }
        LoginLogger loginLogger2 = this.loginLogger;
        AppMethodBeat.o(7857);
        return loginLogger2;
    }

    private void notifyOnCompleteListener(Result result) {
        AppMethodBeat.i(7858);
        if (this.onCompletedListener != null) {
            this.onCompletedListener.onCompleted(result);
        }
        AppMethodBeat.o(7858);
    }

    /* access modifiers changed from: package-private */
    public void notifyBackgroundProcessingStart() {
        AppMethodBeat.i(7859);
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStarted();
        }
        AppMethodBeat.o(7859);
    }

    /* access modifiers changed from: package-private */
    public void notifyBackgroundProcessingStop() {
        AppMethodBeat.i(7860);
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStopped();
        }
        AppMethodBeat.o(7860);
    }

    private void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        AppMethodBeat.i(7861);
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
        AppMethodBeat.o(7861);
    }

    private void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        AppMethodBeat.i(7862);
        if (this.pendingRequest == null) {
            getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            AppMethodBeat.o(7862);
            return;
        }
        getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), str, str2, str3, str4, map);
        AppMethodBeat.o(7862);
    }

    static String getE2E() {
        AppMethodBeat.i(7863);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, System.currentTimeMillis());
        } catch (JSONException e2) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(7863);
        return jSONObject2;
    }

    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
            /* class com.facebook.login.LoginClient.Request.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final Request createFromParcel(Parcel parcel) {
                AppMethodBeat.i(7816);
                Request request = new Request(parcel);
                AppMethodBeat.o(7816);
                return request;
            }

            @Override // android.os.Parcelable.Creator
            public final Request[] newArray(int i2) {
                return new Request[i2];
            }
        };
        private final String applicationId;
        private final String authId;
        private String authType;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        Request(LoginBehavior loginBehavior2, Set<String> set, DefaultAudience defaultAudience2, String str, String str2, String str3) {
            AppMethodBeat.i(7819);
            this.isRerequest = false;
            this.loginBehavior = loginBehavior2;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience2;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
            AppMethodBeat.o(7819);
        }

        /* access modifiers changed from: package-private */
        public Set<String> getPermissions() {
            return this.permissions;
        }

        /* access modifiers changed from: package-private */
        public void setPermissions(Set<String> set) {
            AppMethodBeat.i(7820);
            Validate.notNull(set, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            this.permissions = set;
            AppMethodBeat.o(7820);
        }

        /* access modifiers changed from: package-private */
        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        /* access modifiers changed from: package-private */
        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        /* access modifiers changed from: package-private */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* access modifiers changed from: package-private */
        public String getAuthId() {
            return this.authId;
        }

        /* access modifiers changed from: package-private */
        public boolean isRerequest() {
            return this.isRerequest;
        }

        /* access modifiers changed from: package-private */
        public void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        /* access modifiers changed from: package-private */
        public String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        /* access modifiers changed from: package-private */
        public void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        /* access modifiers changed from: package-private */
        public String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        /* access modifiers changed from: package-private */
        public void setDeviceAuthTargetUserId(String str) {
            this.deviceAuthTargetUserId = str;
        }

        /* access modifiers changed from: package-private */
        public String getAuthType() {
            return this.authType;
        }

        /* access modifiers changed from: package-private */
        public void setAuthType(String str) {
            this.authType = str;
        }

        /* access modifiers changed from: package-private */
        public boolean hasPublishPermission() {
            AppMethodBeat.i(7821);
            for (String str : this.permissions) {
                if (LoginManager.isPublishPermission(str)) {
                    AppMethodBeat.o(7821);
                    return true;
                }
            }
            AppMethodBeat.o(7821);
            return false;
        }

        private Request(Parcel parcel) {
            boolean z;
            DefaultAudience defaultAudience2 = null;
            AppMethodBeat.i(7822);
            this.isRerequest = false;
            String readString = parcel.readString();
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.defaultAudience = readString2 != null ? DefaultAudience.valueOf(readString2) : defaultAudience2;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isRerequest = z;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = parcel.readString();
            this.deviceAuthTargetUserId = parcel.readString();
            AppMethodBeat.o(7822);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            String str = null;
            AppMethodBeat.i(7823);
            parcel.writeString(this.loginBehavior != null ? this.loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            if (this.defaultAudience != null) {
                str = this.defaultAudience.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte((byte) (this.isRerequest ? 1 : 0));
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
            AppMethodBeat.o(7823);
        }

        static {
            AppMethodBeat.i(7824);
            AppMethodBeat.o(7824);
        }
    }

    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
            /* class com.facebook.login.LoginClient.Result.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final Result createFromParcel(Parcel parcel) {
                AppMethodBeat.i(7825);
                Result result = new Result(parcel);
                AppMethodBeat.o(7825);
                return result;
            }

            @Override // android.os.Parcelable.Creator
            public final Result[] newArray(int i2) {
                return new Result[i2];
            }
        };
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        /* access modifiers changed from: package-private */
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            public static Code valueOf(String str) {
                AppMethodBeat.i(7829);
                Code code = (Code) Enum.valueOf(Code.class, str);
                AppMethodBeat.o(7829);
                return code;
            }

            static {
                AppMethodBeat.i(7830);
                AppMethodBeat.o(7830);
            }

            private Code(String str) {
                this.loggingValue = str;
            }

            /* access modifiers changed from: package-private */
            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        Result(Request request2, Code code2, AccessToken accessToken, String str, String str2) {
            AppMethodBeat.i(7831);
            Validate.notNull(code2, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            this.request = request2;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code2;
            this.errorCode = str2;
            AppMethodBeat.o(7831);
        }

        static Result createTokenResult(Request request2, AccessToken accessToken) {
            AppMethodBeat.i(7832);
            Result result = new Result(request2, Code.SUCCESS, accessToken, null, null);
            AppMethodBeat.o(7832);
            return result;
        }

        static Result createCancelResult(Request request2, String str) {
            AppMethodBeat.i(7833);
            Result result = new Result(request2, Code.CANCEL, null, str, null);
            AppMethodBeat.o(7833);
            return result;
        }

        static Result createErrorResult(Request request2, String str, String str2) {
            AppMethodBeat.i(7834);
            Result createErrorResult = createErrorResult(request2, str, str2, null);
            AppMethodBeat.o(7834);
            return createErrorResult;
        }

        static Result createErrorResult(Request request2, String str, String str2, String str3) {
            AppMethodBeat.i(7835);
            Result result = new Result(request2, Code.ERROR, null, TextUtils.join(": ", Utility.asListNoNulls(str, str2)), str3);
            AppMethodBeat.o(7835);
            return result;
        }

        private Result(Parcel parcel) {
            AppMethodBeat.i(7836);
            this.code = Code.valueOf(parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
            this.extraData = Utility.readStringMapFromParcel(parcel);
            AppMethodBeat.o(7836);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(7837);
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i2);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i2);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeStringMapToParcel(parcel, this.extraData);
            AppMethodBeat.o(7837);
        }

        static {
            AppMethodBeat.i(7838);
            AppMethodBeat.o(7838);
        }
    }

    public LoginClient(Parcel parcel) {
        AppMethodBeat.i(7864);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.handlersToTry = new LoginMethodHandler[readParcelableArray.length];
        for (int i2 = 0; i2 < readParcelableArray.length; i2++) {
            this.handlersToTry[i2] = (LoginMethodHandler) readParcelableArray[i2];
            this.handlersToTry[i2].setLoginClient(this);
        }
        this.currentHandler = parcel.readInt();
        this.pendingRequest = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.loggingExtras = Utility.readStringMapFromParcel(parcel);
        this.extraData = Utility.readStringMapFromParcel(parcel);
        AppMethodBeat.o(7864);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7865);
        parcel.writeParcelableArray(this.handlersToTry, i2);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i2);
        Utility.writeStringMapToParcel(parcel, this.loggingExtras);
        Utility.writeStringMapToParcel(parcel, this.extraData);
        AppMethodBeat.o(7865);
    }

    static {
        AppMethodBeat.i(7866);
        AppMethodBeat.o(7866);
    }
}
