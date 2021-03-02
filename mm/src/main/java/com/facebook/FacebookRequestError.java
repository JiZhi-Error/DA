package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() {
        /* class com.facebook.FacebookRequestError.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final FacebookRequestError createFromParcel(Parcel parcel) {
            AppMethodBeat.i(17018);
            FacebookRequestError facebookRequestError = new FacebookRequestError(parcel);
            AppMethodBeat.o(17018);
            return facebookRequestError;
        }

        @Override // android.os.Parcelable.Creator
        public final FacebookRequestError[] newArray(int i2) {
            return new FacebookRequestError[i2];
        }
    };
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    static final Range HTTP_RANGE_SUCCESS = new Range(200, h.CTRL_INDEX);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    /* access modifiers changed from: package-private */
    public static class Range {
        private final int end;
        private final int start;

        private Range(int i2, int i3) {
            this.start = i2;
            this.end = i3;
        }

        /* access modifiers changed from: package-private */
        public boolean contains(int i2) {
            return this.start <= i2 && i2 <= this.end;
        }
    }

    static {
        AppMethodBeat.i(17032);
        AppMethodBeat.o(17032);
    }

    private FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Category classify;
        AppMethodBeat.i(17024);
        this.requestStatusCode = i2;
        this.errorCode = i3;
        this.subErrorCode = i4;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        boolean z2 = false;
        if (facebookException != null) {
            this.exception = facebookException;
            z2 = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (z2) {
            classify = Category.OTHER;
        } else {
            classify = errorClassification.classify(i3, i4, z);
        }
        this.category = classify;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
        AppMethodBeat.o(17024);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FacebookRequestError(java.net.HttpURLConnection r16, java.lang.Exception r17) {
        /*
            r15 = this;
            r2 = -1
            r3 = -1
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r0 = r17
            boolean r1 = r0 instanceof com.facebook.FacebookException
            if (r1 == 0) goto L_0x0026
            com.facebook.FacebookException r17 = (com.facebook.FacebookException) r17
            r14 = r17
        L_0x0015:
            r1 = r15
            r13 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = 17025(0x4281, float:2.3857E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 17025(0x4281, float:2.3857E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0026:
            com.facebook.FacebookException r14 = new com.facebook.FacebookException
            r0 = r17
            r14.<init>(r0)
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.<init>(java.net.HttpURLConnection, java.lang.Exception):void");
    }

    public FacebookRequestError(int i2, String str, String str2) {
        this(-1, i2, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorMessage() {
        AppMethodBeat.i(17026);
        if (this.errorMessage != null) {
            String str = this.errorMessage;
            AppMethodBeat.o(17026);
            return str;
        }
        String localizedMessage = this.exception.getLocalizedMessage();
        AppMethodBeat.o(17026);
        return localizedMessage;
    }

    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final String toString() {
        AppMethodBeat.i(17027);
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        AppMethodBeat.o(17027);
        return str;
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        JSONObject jSONObject2;
        AppMethodBeat.i(17028);
        try {
            if (jSONObject.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                int i2 = jSONObject.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    JSONObject jSONObject3 = (JSONObject) stringPropertyAsJSON;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i3 = 0;
                    int i4 = 0;
                    boolean z2 = false;
                    if (jSONObject3.has("error")) {
                        JSONObject jSONObject4 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject3, "error", null);
                        str = jSONObject4.optString("type", null);
                        str2 = jSONObject4.optString("message", null);
                        i3 = jSONObject4.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, -1);
                        i4 = jSONObject4.optInt("error_subcode", -1);
                        str3 = jSONObject4.optString(ERROR_USER_MSG_KEY, null);
                        str4 = jSONObject4.optString(ERROR_USER_TITLE_KEY, null);
                        z = jSONObject4.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        z2 = true;
                    } else if (jSONObject3.has("error_code") || jSONObject3.has(ERROR_MSG_KEY) || jSONObject3.has(ERROR_REASON_KEY)) {
                        str = jSONObject3.optString(ERROR_REASON_KEY, null);
                        str2 = jSONObject3.optString(ERROR_MSG_KEY, null);
                        i3 = jSONObject3.optInt("error_code", -1);
                        i4 = jSONObject3.optInt("error_subcode", -1);
                        z2 = true;
                    }
                    if (z2) {
                        FacebookRequestError facebookRequestError = new FacebookRequestError(i2, i3, i4, str, str2, str4, str3, z, jSONObject3, jSONObject, obj, httpURLConnection, null);
                        AppMethodBeat.o(17028);
                        return facebookRequestError;
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i2)) {
                    if (jSONObject.has(BODY_KEY)) {
                        jSONObject2 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                    } else {
                        jSONObject2 = null;
                    }
                    FacebookRequestError facebookRequestError2 = new FacebookRequestError(i2, -1, -1, null, null, null, null, false, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    AppMethodBeat.o(17028);
                    return facebookRequestError2;
                }
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(17028);
        return null;
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification errorClassification;
        synchronized (FacebookRequestError.class) {
            AppMethodBeat.i(17029);
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                errorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                AppMethodBeat.o(17029);
            } else {
                errorClassification = appSettingsWithoutQuery.getErrorClassification();
                AppMethodBeat.o(17029);
            }
        }
        return errorClassification;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(17030);
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
        AppMethodBeat.o(17030);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
        AppMethodBeat.i(17031);
        AppMethodBeat.o(17031);
    }

    public final int describeContents() {
        return 0;
    }

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        public static Category valueOf(String str) {
            AppMethodBeat.i(17022);
            Category category = (Category) Enum.valueOf(Category.class, str);
            AppMethodBeat.o(17022);
            return category;
        }

        static {
            AppMethodBeat.i(17023);
            AppMethodBeat.o(17023);
        }
    }
}
