package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
public final class JsonUtils {
    private static final Pattern zzaae = Pattern.compile("\\\\.");
    private static final Pattern zzaaf = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    static {
        AppMethodBeat.i(5268);
        AppMethodBeat.o(5268);
    }

    private JsonUtils() {
    }

    public static boolean areJsonStringsEquivalent(String str, String str2) {
        AppMethodBeat.i(5266);
        if (str == null && str2 == null) {
            AppMethodBeat.o(5266);
            return true;
        } else if (str == null || str2 == null) {
            AppMethodBeat.o(5266);
            return false;
        } else {
            try {
                boolean areJsonValuesEquivalent = areJsonValuesEquivalent(new JSONObject(str), new JSONObject(str2));
                AppMethodBeat.o(5266);
                return areJsonValuesEquivalent;
            } catch (JSONException e2) {
                try {
                    boolean areJsonValuesEquivalent2 = areJsonValuesEquivalent(new JSONArray(str), new JSONArray(str2));
                    AppMethodBeat.o(5266);
                    return areJsonValuesEquivalent2;
                } catch (JSONException e3) {
                    AppMethodBeat.o(5266);
                    return false;
                }
            }
        }
    }

    public static boolean areJsonValuesEquivalent(Object obj, Object obj2) {
        AppMethodBeat.i(5267);
        if (obj == null && obj2 == null) {
            AppMethodBeat.o(5267);
            return true;
        } else if (obj == null || obj2 == null) {
            AppMethodBeat.o(5267);
            return false;
        } else if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                AppMethodBeat.o(5267);
                return false;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    AppMethodBeat.o(5267);
                    return false;
                }
                try {
                    if (!areJsonValuesEquivalent(jSONObject.get(next), jSONObject2.get(next))) {
                        AppMethodBeat.o(5267);
                        return false;
                    }
                } catch (JSONException e2) {
                    AppMethodBeat.o(5267);
                    return false;
                }
            }
            AppMethodBeat.o(5267);
            return true;
        } else if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(5267);
            return equals;
        } else {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                AppMethodBeat.o(5267);
                return false;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (!areJsonValuesEquivalent(jSONArray.get(i2), jSONArray2.get(i2))) {
                        AppMethodBeat.o(5267);
                        return false;
                    }
                } catch (JSONException e3) {
                    AppMethodBeat.o(5267);
                    return false;
                }
            }
            AppMethodBeat.o(5267);
            return true;
        }
    }

    public static String escapeString(String str) {
        AppMethodBeat.i(5265);
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = zzaaf.matcher(str);
            StringBuffer stringBuffer = null;
            while (matcher.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                switch (matcher.group().charAt(0)) {
                    case '\b':
                        matcher.appendReplacement(stringBuffer, "\\\\b");
                        break;
                    case '\t':
                        matcher.appendReplacement(stringBuffer, "\\\\t");
                        break;
                    case '\n':
                        matcher.appendReplacement(stringBuffer, "\\\\n");
                        break;
                    case '\f':
                        matcher.appendReplacement(stringBuffer, "\\\\f");
                        break;
                    case '\r':
                        matcher.appendReplacement(stringBuffer, "\\\\r");
                        break;
                    case '\"':
                        matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                        break;
                    case '/':
                        matcher.appendReplacement(stringBuffer, "\\\\/");
                        break;
                    case '\\':
                        matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                        break;
                }
            }
            if (stringBuffer == null) {
                AppMethodBeat.o(5265);
                return str;
            }
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(5265);
            return stringBuffer2;
        }
        AppMethodBeat.o(5265);
        return str;
    }

    public static String unescapeString(String str) {
        AppMethodBeat.i(5264);
        if (!TextUtils.isEmpty(str)) {
            String unescape = UnicodeUtils.unescape(str);
            Matcher matcher = zzaae.matcher(unescape);
            StringBuffer stringBuffer = null;
            while (matcher.find()) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                switch (matcher.group().charAt(1)) {
                    case '\"':
                        matcher.appendReplacement(stringBuffer, "\"");
                        break;
                    case '/':
                        matcher.appendReplacement(stringBuffer, FilePathGenerator.ANDROID_DIR_SEP);
                        break;
                    case '\\':
                        matcher.appendReplacement(stringBuffer, "\\\\");
                        break;
                    case 'b':
                        matcher.appendReplacement(stringBuffer, "\b");
                        break;
                    case 'f':
                        matcher.appendReplacement(stringBuffer, "\f");
                        break;
                    case 'n':
                        matcher.appendReplacement(stringBuffer, "\n");
                        break;
                    case 'r':
                        matcher.appendReplacement(stringBuffer, "\r");
                        break;
                    case 't':
                        matcher.appendReplacement(stringBuffer, "\t");
                        break;
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException("Found an escaped character that should never be.");
                        AppMethodBeat.o(5264);
                        throw illegalStateException;
                }
            }
            if (stringBuffer == null) {
                AppMethodBeat.o(5264);
                return unescape;
            }
            matcher.appendTail(stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(5264);
            return stringBuffer2;
        }
        AppMethodBeat.o(5264);
        return str;
    }
}
