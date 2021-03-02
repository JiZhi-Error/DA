package com.facebook.appevents;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> validatedIdentifiers = new HashSet<>();
    private final String checksum;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    static {
        AppMethodBeat.i(17312);
        AppMethodBeat.o(17312);
    }

    public AppEvent(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(17303);
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d2, bundle, z, uuid);
        this.isImplicit = z;
        this.name = str2;
        this.checksum = calculateChecksum();
        AppMethodBeat.o(17303);
    }

    public String getName() {
        return this.name;
    }

    private AppEvent(String str, boolean z, String str2) {
        AppMethodBeat.i(17304);
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        this.checksum = str2;
        AppMethodBeat.o(17304);
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public boolean isChecksumValid() {
        AppMethodBeat.i(17305);
        if (this.checksum == null) {
            AppMethodBeat.o(17305);
            return true;
        }
        boolean equals = calculateChecksum().equals(this.checksum);
        AppMethodBeat.o(17305);
        return equals;
    }

    private static void validateIdentifier(String str) {
        boolean contains;
        AppMethodBeat.i(17306);
        if (str == null || str.length() == 0 || str.length() > 40) {
            if (str == null) {
                str = "<None Provided>";
            }
            FacebookException facebookException = new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", str, 40));
            AppMethodBeat.o(17306);
            throw facebookException;
        }
        synchronized (validatedIdentifiers) {
            try {
                contains = validatedIdentifiers.contains(str);
            } finally {
                AppMethodBeat.o(17306);
            }
        }
        if (contains) {
            AppMethodBeat.o(17306);
        } else if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            synchronized (validatedIdentifiers) {
                try {
                    validatedIdentifiers.add(str);
                } finally {
                    AppMethodBeat.o(17306);
                }
            }
        } else {
            FacebookException facebookException2 = new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", str));
            AppMethodBeat.o(17306);
            throw facebookException2;
        }
    }

    private static JSONObject getJSONObjectForAppEvent(String str, String str2, Double d2, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(17307);
        validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, str2);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, md5Checksum(str2));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d2 != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d2.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", "1");
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                validateIdentifier(str3);
                Object obj = bundle.get(str3);
                if ((obj instanceof String) || (obj instanceof Number)) {
                    jSONObject.put(str3, obj.toString());
                } else {
                    FacebookException facebookException = new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", obj, str3));
                    AppMethodBeat.o(17307);
                    throw facebookException;
                }
            }
        }
        if (!z) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        AppMethodBeat.o(17307);
        return jSONObject;
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV1(String str, boolean z) {
            this.jsonString = str;
            this.isImplicit = z;
        }

        private Object readResolve() {
            AppMethodBeat.i(17301);
            AppEvent appEvent = new AppEvent(this.jsonString, this.isImplicit, null);
            AppMethodBeat.o(17301);
            return appEvent;
        }
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV2(String str, boolean z, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.checksum = str2;
        }

        private Object readResolve() {
            AppMethodBeat.i(17302);
            AppEvent appEvent = new AppEvent(this.jsonString, this.isImplicit, this.checksum);
            AppMethodBeat.o(17302);
            return appEvent;
        }
    }

    private Object writeReplace() {
        AppMethodBeat.i(17308);
        SerializationProxyV2 serializationProxyV2 = new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
        AppMethodBeat.o(17308);
        return serializationProxyV2;
    }

    public String toString() {
        AppMethodBeat.i(17309);
        String format = String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString());
        AppMethodBeat.o(17309);
        return format;
    }

    private String calculateChecksum() {
        AppMethodBeat.i(17310);
        if (Build.VERSION.SDK_INT > 19) {
            String md5Checksum = md5Checksum(this.jsonObject.toString());
            AppMethodBeat.o(17310);
            return md5Checksum;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str).append(" = ").append(this.jsonObject.optString(str)).append('\n');
        }
        String md5Checksum2 = md5Checksum(sb.toString());
        AppMethodBeat.o(17310);
        return md5Checksum2;
    }

    private static String md5Checksum(String str) {
        AppMethodBeat.i(17311);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            instance.update(bytes, 0, bytes.length);
            String bytesToHex = AppEventUtility.bytesToHex(instance.digest());
            AppMethodBeat.o(17311);
            return bytesToHex;
        } catch (NoSuchAlgorithmException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            AppMethodBeat.o(17311);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (UnsupportedEncodingException e3) {
            Utility.logd("Failed to generate checksum: ", e3);
            AppMethodBeat.o(17311);
            return "1";
        }
    }
}
