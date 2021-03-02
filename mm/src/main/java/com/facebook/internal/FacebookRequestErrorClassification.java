package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FacebookRequestErrorClassification {
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    private static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    FacebookRequestErrorClassification(Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map2, Map<Integer, Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        AppMethodBeat.i(17720);
        switch (category) {
            case OTHER:
                String str = this.otherRecoveryMessage;
                AppMethodBeat.o(17720);
                return str;
            case LOGIN_RECOVERABLE:
                String str2 = this.loginRecoverableRecoveryMessage;
                AppMethodBeat.o(17720);
                return str2;
            case TRANSIENT:
                String str3 = this.transientRecoveryMessage;
                AppMethodBeat.o(17720);
                return str3;
            default:
                AppMethodBeat.o(17720);
                return null;
        }
    }

    public final FacebookRequestError.Category classify(int i2, int i3, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        AppMethodBeat.i(17721);
        if (z) {
            FacebookRequestError.Category category = FacebookRequestError.Category.TRANSIENT;
            AppMethodBeat.o(17721);
            return category;
        } else if (this.otherErrors != null && this.otherErrors.containsKey(Integer.valueOf(i2)) && ((set3 = this.otherErrors.get(Integer.valueOf(i2))) == null || set3.contains(Integer.valueOf(i3)))) {
            FacebookRequestError.Category category2 = FacebookRequestError.Category.OTHER;
            AppMethodBeat.o(17721);
            return category2;
        } else if (this.loginRecoverableErrors != null && this.loginRecoverableErrors.containsKey(Integer.valueOf(i2)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i2))) == null || set2.contains(Integer.valueOf(i3)))) {
            FacebookRequestError.Category category3 = FacebookRequestError.Category.LOGIN_RECOVERABLE;
            AppMethodBeat.o(17721);
            return category3;
        } else if (this.transientErrors == null || !this.transientErrors.containsKey(Integer.valueOf(i2)) || ((set = this.transientErrors.get(Integer.valueOf(i2))) != null && !set.contains(Integer.valueOf(i3)))) {
            FacebookRequestError.Category category4 = FacebookRequestError.Category.OTHER;
            AppMethodBeat.o(17721);
            return category4;
        } else {
            FacebookRequestError.Category category5 = FacebookRequestError.Category.TRANSIENT;
            AppMethodBeat.o(17721);
            return category5;
        }
    }

    public static synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            AppMethodBeat.i(17722);
            if (defaultInstance == null) {
                defaultInstance = getDefaultErrorClassificationImpl();
            }
            facebookRequestErrorClassification = defaultInstance;
            AppMethodBeat.o(17722);
        }
        return facebookRequestErrorClassification;
    }

    private static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
        AppMethodBeat.i(17723);
        FacebookRequestErrorClassification facebookRequestErrorClassification = new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() {
            /* class com.facebook.internal.FacebookRequestErrorClassification.AnonymousClass1 */

            {
                AppMethodBeat.i(17717);
                put(2, null);
                put(4, null);
                put(9, null);
                put(17, null);
                put(Integer.valueOf((int) FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null);
                AppMethodBeat.o(17717);
            }
        }, new HashMap<Integer, Set<Integer>>() {
            /* class com.facebook.internal.FacebookRequestErrorClassification.AnonymousClass2 */

            {
                AppMethodBeat.i(17718);
                put(102, null);
                put(Integer.valueOf((int) FacebookRequestErrorClassification.EC_INVALID_TOKEN), null);
                put(412, null);
                AppMethodBeat.o(17718);
            }
        }, null, null, null);
        AppMethodBeat.o(17723);
        return facebookRequestErrorClassification;
    }

    private static Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
        int optInt;
        HashSet hashSet;
        AppMethodBeat.i(17724);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray.length() == 0) {
            AppMethodBeat.o(17724);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (!(optJSONObject == null || (optInt = optJSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) == 0)) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    hashSet = null;
                } else {
                    HashSet hashSet2 = new HashSet();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        int optInt2 = optJSONArray2.optInt(i3);
                        if (optInt2 != 0) {
                            hashSet2.add(Integer.valueOf(optInt2));
                        }
                    }
                    hashSet = hashSet2;
                }
                hashMap.put(Integer.valueOf(optInt), hashSet);
            }
        }
        AppMethodBeat.o(17724);
        return hashMap;
    }

    public static FacebookRequestErrorClassification createFromJSON(JSONArray jSONArray) {
        String optString;
        AppMethodBeat.i(17725);
        if (jSONArray == null) {
            AppMethodBeat.o(17725);
            return null;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        Map<Integer, Set<Integer>> map = null;
        Map<Integer, Set<Integer>> map2 = null;
        Map<Integer, Set<Integer>> map3 = null;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                if (optString.equalsIgnoreCase(KEY_OTHER)) {
                    str3 = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                    map3 = parseJSONDefinition(optJSONObject);
                } else if (optString.equalsIgnoreCase(KEY_TRANSIENT)) {
                    str2 = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                    map2 = parseJSONDefinition(optJSONObject);
                } else if (optString.equalsIgnoreCase(KEY_LOGIN_RECOVERABLE)) {
                    str = optJSONObject.optString(KEY_RECOVERY_MESSAGE, null);
                    map = parseJSONDefinition(optJSONObject);
                }
            }
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
        AppMethodBeat.o(17725);
        return facebookRequestErrorClassification;
    }
}
