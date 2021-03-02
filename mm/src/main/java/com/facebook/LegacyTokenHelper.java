package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    static {
        AppMethodBeat.i(17236);
        AppMethodBeat.o(17236);
    }

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String str) {
        AppMethodBeat.i(17210);
        Validate.notNull(context, "context");
        this.cacheKey = Utility.isNullOrEmpty(str) ? DEFAULT_CACHE_KEY : str;
        Context applicationContext = context.getApplicationContext();
        this.cache = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.cacheKey, 0);
        AppMethodBeat.o(17210);
    }

    public final Bundle load() {
        AppMethodBeat.i(17211);
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + e2);
                AppMethodBeat.o(17211);
                return null;
            }
        }
        AppMethodBeat.o(17211);
        return bundle;
    }

    public final void save(Bundle bundle) {
        AppMethodBeat.i(17212);
        Validate.notNull(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + e2);
                AppMethodBeat.o(17212);
                return;
            }
        }
        edit.apply();
        AppMethodBeat.o(17212);
    }

    public final void clear() {
        AppMethodBeat.i(17213);
        this.cache.edit().clear().apply();
        AppMethodBeat.o(17213);
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        AppMethodBeat.i(17214);
        if (bundle == null) {
            AppMethodBeat.o(17214);
            return false;
        }
        String string = bundle.getString(TOKEN_KEY);
        if (string == null || string.length() == 0) {
            AppMethodBeat.o(17214);
            return false;
        } else if (bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) {
            AppMethodBeat.o(17214);
            return false;
        } else {
            AppMethodBeat.o(17214);
            return true;
        }
    }

    public static String getToken(Bundle bundle) {
        AppMethodBeat.i(17215);
        Validate.notNull(bundle, "bundle");
        String string = bundle.getString(TOKEN_KEY);
        AppMethodBeat.o(17215);
        return string;
    }

    public static void putToken(Bundle bundle, String str) {
        AppMethodBeat.i(17216);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, "value");
        bundle.putString(TOKEN_KEY, str);
        AppMethodBeat.o(17216);
    }

    public static Date getExpirationDate(Bundle bundle) {
        AppMethodBeat.i(17217);
        Validate.notNull(bundle, "bundle");
        Date date = getDate(bundle, EXPIRATION_DATE_KEY);
        AppMethodBeat.o(17217);
        return date;
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        AppMethodBeat.i(17218);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, EXPIRATION_DATE_KEY, date);
        AppMethodBeat.o(17218);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        AppMethodBeat.i(17219);
        Validate.notNull(bundle, "bundle");
        long j2 = bundle.getLong(EXPIRATION_DATE_KEY);
        AppMethodBeat.o(17219);
        return j2;
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j2) {
        AppMethodBeat.i(17220);
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, j2);
        AppMethodBeat.o(17220);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        AppMethodBeat.i(17221);
        Validate.notNull(bundle, "bundle");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            AppMethodBeat.o(17221);
            return null;
        }
        HashSet hashSet = new HashSet(stringArrayList);
        AppMethodBeat.o(17221);
        return hashSet;
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        AppMethodBeat.i(17222);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList<>(collection));
        AppMethodBeat.o(17222);
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        AppMethodBeat.i(17223);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, "value");
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList<>(collection));
        AppMethodBeat.o(17223);
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        AppMethodBeat.i(17224);
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            AccessTokenSource accessTokenSource = (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
            AppMethodBeat.o(17224);
            return accessTokenSource;
        } else if (bundle.getBoolean(IS_SSO_KEY)) {
            AccessTokenSource accessTokenSource2 = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            AppMethodBeat.o(17224);
            return accessTokenSource2;
        } else {
            AccessTokenSource accessTokenSource3 = AccessTokenSource.WEB_VIEW;
            AppMethodBeat.o(17224);
            return accessTokenSource3;
        }
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        AppMethodBeat.i(17225);
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
        AppMethodBeat.o(17225);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        AppMethodBeat.i(17226);
        Validate.notNull(bundle, "bundle");
        Date date = getDate(bundle, LAST_REFRESH_DATE_KEY);
        AppMethodBeat.o(17226);
        return date;
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        AppMethodBeat.i(17227);
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, "value");
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
        AppMethodBeat.o(17227);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        AppMethodBeat.i(17228);
        Validate.notNull(bundle, "bundle");
        long j2 = bundle.getLong(LAST_REFRESH_DATE_KEY);
        AppMethodBeat.o(17228);
        return j2;
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j2) {
        AppMethodBeat.i(17229);
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, j2);
        AppMethodBeat.o(17229);
    }

    public static String getApplicationId(Bundle bundle) {
        AppMethodBeat.i(17230);
        Validate.notNull(bundle, "bundle");
        String string = bundle.getString(APPLICATION_ID_KEY);
        AppMethodBeat.o(17230);
        return string;
    }

    public static void putApplicationId(Bundle bundle, String str) {
        AppMethodBeat.i(17231);
        Validate.notNull(bundle, "bundle");
        bundle.putString(APPLICATION_ID_KEY, str);
        AppMethodBeat.o(17231);
    }

    static Date getDate(Bundle bundle, String str) {
        AppMethodBeat.i(17232);
        if (bundle == null) {
            AppMethodBeat.o(17232);
            return null;
        }
        long j2 = bundle.getLong(str, INVALID_BUNDLE_MILLISECONDS);
        if (j2 == INVALID_BUNDLE_MILLISECONDS) {
            AppMethodBeat.o(17232);
            return null;
        }
        Date date = new Date(j2);
        AppMethodBeat.o(17232);
        return date;
    }

    static void putDate(Bundle bundle, String str, Date date) {
        AppMethodBeat.i(17233);
        bundle.putLong(str, date.getTime());
        AppMethodBeat.o(17233);
    }

    private void serializeKey(String str, Bundle bundle, SharedPreferences.Editor editor) {
        JSONArray jSONArray;
        Object obj;
        int i2 = 0;
        AppMethodBeat.i(17234);
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            AppMethodBeat.o(17234);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (obj2 instanceof Byte) {
            jSONObject.put("value", ((Byte) obj2).intValue());
            jSONArray = null;
            obj = TYPE_BYTE;
        } else if (obj2 instanceof Short) {
            jSONObject.put("value", ((Short) obj2).intValue());
            jSONArray = null;
            obj = TYPE_SHORT;
        } else if (obj2 instanceof Integer) {
            jSONObject.put("value", ((Integer) obj2).intValue());
            jSONArray = null;
            obj = TYPE_INTEGER;
        } else if (obj2 instanceof Long) {
            jSONObject.put("value", ((Long) obj2).longValue());
            jSONArray = null;
            obj = TYPE_LONG;
        } else if (obj2 instanceof Float) {
            jSONObject.put("value", ((Float) obj2).doubleValue());
            jSONArray = null;
            obj = TYPE_FLOAT;
        } else if (obj2 instanceof Double) {
            jSONObject.put("value", ((Double) obj2).doubleValue());
            jSONArray = null;
            obj = TYPE_DOUBLE;
        } else if (obj2 instanceof Boolean) {
            jSONObject.put("value", ((Boolean) obj2).booleanValue());
            jSONArray = null;
            obj = TYPE_BOOLEAN;
        } else if (obj2 instanceof Character) {
            jSONObject.put("value", obj2.toString());
            jSONArray = null;
            obj = TYPE_CHAR;
        } else if (obj2 instanceof String) {
            jSONObject.put("value", (String) obj2);
            jSONArray = null;
            obj = TYPE_STRING;
        } else if (obj2 instanceof Enum) {
            jSONObject.put("value", obj2.toString());
            jSONObject.put(JSON_VALUE_ENUM_TYPE, obj2.getClass().getName());
            jSONArray = null;
            obj = TYPE_ENUM;
        } else {
            JSONArray jSONArray2 = new JSONArray();
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length;
                while (i2 < length) {
                    jSONArray2.put((int) bArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_BYTE_ARRAY;
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length;
                while (i2 < length2) {
                    jSONArray2.put((int) sArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_SHORT_ARRAY;
            } else if (obj2 instanceof int[]) {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length;
                while (i2 < length3) {
                    jSONArray2.put(iArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_INTEGER_ARRAY;
            } else if (obj2 instanceof long[]) {
                long[] jArr = (long[]) obj2;
                int length4 = jArr.length;
                while (i2 < length4) {
                    jSONArray2.put(jArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_LONG_ARRAY;
            } else if (obj2 instanceof float[]) {
                float[] fArr = (float[]) obj2;
                int length5 = fArr.length;
                while (i2 < length5) {
                    jSONArray2.put((double) fArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_FLOAT_ARRAY;
            } else if (obj2 instanceof double[]) {
                double[] dArr = (double[]) obj2;
                int length6 = dArr.length;
                while (i2 < length6) {
                    jSONArray2.put(dArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_DOUBLE_ARRAY;
            } else if (obj2 instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj2;
                int length7 = zArr.length;
                while (i2 < length7) {
                    jSONArray2.put(zArr[i2]);
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_BOOLEAN_ARRAY;
            } else if (obj2 instanceof char[]) {
                char[] cArr = (char[]) obj2;
                int length8 = cArr.length;
                while (i2 < length8) {
                    jSONArray2.put(String.valueOf(cArr[i2]));
                    i2++;
                }
                jSONArray = jSONArray2;
                obj = TYPE_CHAR_ARRAY;
            } else if (obj2 instanceof List) {
                for (Object obj3 : (List) obj2) {
                    if (obj3 == null) {
                        obj3 = JSONObject.NULL;
                    }
                    jSONArray2.put(obj3);
                }
                jSONArray = jSONArray2;
                obj = TYPE_STRING_LIST;
            } else {
                jSONArray = null;
                obj = null;
            }
        }
        if (obj != null) {
            jSONObject.put(JSON_VALUE_TYPE, obj);
            if (jSONArray != null) {
                jSONObject.putOpt("value", jSONArray);
            }
            editor.putString(str, jSONObject.toString());
        }
        AppMethodBeat.o(17234);
    }

    private void deserializeKey(String str, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(17235);
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            JSONArray jSONArray = jSONObject.getJSONArray("value");
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i2 < zArr.length) {
                zArr[i2] = jSONArray.getBoolean(i2);
                i2++;
            }
            bundle.putBooleanArray(str, zArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
            byte[] bArr = new byte[jSONArray2.length()];
            while (i2 < bArr.length) {
                bArr[i2] = (byte) jSONArray2.getInt(i2);
                i2++;
            }
            bundle.putByteArray(str, bArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
            short[] sArr = new short[jSONArray3.length()];
            while (i2 < sArr.length) {
                sArr[i2] = (short) jSONArray3.getInt(i2);
                i2++;
            }
            bundle.putShortArray(str, sArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
            int[] iArr = new int[jSONArray4.length()];
            while (i2 < iArr.length) {
                iArr[i2] = jSONArray4.getInt(i2);
                i2++;
            }
            bundle.putIntArray(str, iArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
            long[] jArr = new long[jSONArray5.length()];
            while (i2 < jArr.length) {
                jArr[i2] = jSONArray5.getLong(i2);
                i2++;
            }
            bundle.putLongArray(str, jArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
            float[] fArr = new float[jSONArray6.length()];
            while (i2 < fArr.length) {
                fArr[i2] = (float) jSONArray6.getDouble(i2);
                i2++;
            }
            bundle.putFloatArray(str, fArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
            double[] dArr = new double[jSONArray7.length()];
            while (i2 < dArr.length) {
                dArr[i2] = jSONArray7.getDouble(i2);
                i2++;
            }
            bundle.putDoubleArray(str, dArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_CHAR)) {
            String string2 = jSONObject.getString("value");
            if (string2 != null && string2.length() == 1) {
                bundle.putChar(str, string2.charAt(0));
            }
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
            char[] cArr = new char[jSONArray8.length()];
            for (int i3 = 0; i3 < cArr.length; i3++) {
                String string3 = jSONArray8.getString(i3);
                if (string3 != null && string3.length() == 1) {
                    cArr[i3] = string3.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString("value"));
            AppMethodBeat.o(17235);
        } else if (string.equals(TYPE_STRING_LIST)) {
            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
            int length = jSONArray9.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = jSONArray9.get(i4);
                arrayList.add(i4, obj == JSONObject.NULL ? null : (String) obj);
            }
            bundle.putStringArrayList(str, arrayList);
            AppMethodBeat.o(17235);
        } else {
            if (string.equals(TYPE_ENUM)) {
                try {
                    bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
                    AppMethodBeat.o(17235);
                    return;
                } catch (ClassNotFoundException e2) {
                    AppMethodBeat.o(17235);
                    return;
                } catch (IllegalArgumentException e3) {
                }
            }
            AppMethodBeat.o(17235);
        }
    }
}
