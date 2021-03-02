package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class LoginLogger {
    static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    static final String EVENT_EXTRAS_FAILURE = "failure";
    static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    static final String EVENT_PARAM_EXTRAS = "6_extras";
    static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    static final String EVENT_PARAM_METHOD = "3_method";
    static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private final AppEventsLogger appEventsLogger;
    private String applicationId;
    private String facebookVersion;

    LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        AppMethodBeat.i(7881);
        this.applicationId = str;
        this.appEventsLogger = AppEventsLogger.newLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(FACEBOOK_PACKAGE_NAME, 0)) == null)) {
                this.facebookVersion = packageInfo.versionName;
            }
            AppMethodBeat.o(7881);
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(7881);
        }
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        AppMethodBeat.i(7882);
        Bundle bundle = new Bundle();
        bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, str);
        bundle.putString(EVENT_PARAM_METHOD, "");
        bundle.putString(EVENT_PARAM_LOGIN_RESULT, "");
        bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
        bundle.putString(EVENT_PARAM_ERROR_CODE, "");
        bundle.putString(EVENT_PARAM_EXTRAS, "");
        AppMethodBeat.o(7882);
        return bundle;
    }

    public void logStartLogin(LoginClient.Request request) {
        AppMethodBeat.i(7883);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EVENT_EXTRAS_LOGIN_BEHAVIOR, request.getLoginBehavior().toString());
            jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, LoginClient.getLoginRequestCode());
            jSONObject.put("permissions", TextUtils.join(",", request.getPermissions()));
            jSONObject.put("default_audience", request.getDefaultAudience().toString());
            jSONObject.put(EVENT_EXTRAS_IS_REAUTHORIZE, request.isRerequest());
            if (this.facebookVersion != null) {
                jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, this.facebookVersion);
            }
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
        } catch (JSONException e2) {
        }
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_START, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7883);
    }

    public void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        JSONObject jSONObject;
        AppMethodBeat.i(7884);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (code != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
        }
        if (!(exc == null || exc.getMessage() == null)) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
        }
        JSONObject jSONObject2 = !map.isEmpty() ? new JSONObject(map) : null;
        if (map2 != null) {
            if (jSONObject2 == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = jSONObject2;
            }
            try {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject2 = jSONObject;
            } catch (JSONException e2) {
                jSONObject2 = jSONObject;
            }
        }
        if (jSONObject2 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject2.toString());
        }
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7884);
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        AppMethodBeat.i(7885);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_START, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7885);
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        AppMethodBeat.i(7886);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (str3 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
        }
        if (str4 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
        }
        if (str5 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
        }
        if (map != null && !map.isEmpty()) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(map).toString());
        }
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7886);
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        AppMethodBeat.i(7887);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_NOT_TRIED, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7887);
    }

    public void logLoginStatusStart(String str) {
        AppMethodBeat.i(7888);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_START, null, newAuthorizationLoggingBundle(str));
        AppMethodBeat.o(7888);
    }

    public void logLoginStatusSuccess(String str) {
        AppMethodBeat.i(7889);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7889);
    }

    public void logLoginStatusFailure(String str) {
        AppMethodBeat.i(7890);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7890);
    }

    public void logLoginStatusError(String str, Exception exc) {
        AppMethodBeat.i(7891);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7891);
    }

    public void logUnexpectedError(String str, String str2) {
        AppMethodBeat.i(7892);
        logUnexpectedError(str, str2, "");
        AppMethodBeat.o(7892);
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        AppMethodBeat.i(7893);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
        this.appEventsLogger.logSdkEvent(str, null, newAuthorizationLoggingBundle);
        AppMethodBeat.o(7893);
    }
}
