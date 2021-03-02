package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final int GINGERBREAD_MR1 = 10;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = noCarrierConstant;
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static final String noCarrierConstant = "NoCarrier";
    private static int numCPUCores = 0;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public interface Mapper<T, K> {
        K apply(T t);
    }

    public interface Predicate<T> {
        boolean apply(T t);
    }

    public static int[] intersectRanges(int[] iArr, int[] iArr2) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(17928);
        if (iArr == null) {
            AppMethodBeat.o(17928);
            return iArr2;
        } else if (iArr2 == null) {
            AppMethodBeat.o(17928);
            return iArr;
        } else {
            int[] iArr3 = new int[(iArr.length + iArr2.length)];
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                if (i7 >= iArr.length || i6 >= iArr2.length) {
                    break;
                }
                int i9 = iArr[i7];
                int i10 = iArr2[i6];
                if (i7 < iArr.length - 1) {
                    i2 = iArr[i7 + 1];
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                if (i6 < iArr2.length - 1) {
                    i3 = iArr2[i6 + 1];
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                if (i9 < i10) {
                    if (i2 <= i10) {
                        i4 = i7 + 2;
                        i2 = Integer.MAX_VALUE;
                        i10 = Integer.MIN_VALUE;
                    } else if (i2 <= i3) {
                        i4 = i7 + 2;
                    } else {
                        i5 = i10;
                        i2 = i3;
                        i10 = i5;
                        i6 += 2;
                        i4 = i7;
                    }
                } else if (i3 <= i9) {
                    i2 = Integer.MAX_VALUE;
                    i10 = Integer.MIN_VALUE;
                    i6 += 2;
                    i4 = i7;
                } else if (i3 > i2) {
                    i4 = i7 + 2;
                    i10 = i9;
                } else {
                    i5 = i9;
                    i2 = i3;
                    i10 = i5;
                    i6 += 2;
                    i4 = i7;
                }
                if (i10 != Integer.MIN_VALUE) {
                    int i11 = i8 + 1;
                    iArr3[i8] = i10;
                    if (i2 == Integer.MAX_VALUE) {
                        i8 = i11;
                        break;
                    }
                    i8 = i11 + 1;
                    iArr3[i11] = i2;
                }
                i7 = i4;
            }
            int[] copyOf = Arrays.copyOf(iArr3, i8);
            AppMethodBeat.o(17928);
            return copyOf;
        }
    }

    public static <T> boolean isSubset(Collection<T> collection, Collection<T> collection2) {
        AppMethodBeat.i(17929);
        if (collection2 != null && collection2.size() != 0) {
            HashSet hashSet = new HashSet(collection2);
            for (T t : collection) {
                if (!hashSet.contains(t)) {
                    AppMethodBeat.o(17929);
                    return false;
                }
            }
            AppMethodBeat.o(17929);
            return true;
        } else if (collection == null || collection.size() == 0) {
            AppMethodBeat.o(17929);
            return true;
        } else {
            AppMethodBeat.o(17929);
            return false;
        }
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        AppMethodBeat.i(17930);
        if (collection == null || collection.size() == 0) {
            AppMethodBeat.o(17930);
            return true;
        }
        AppMethodBeat.o(17930);
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        AppMethodBeat.i(17931);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(17931);
            return true;
        }
        AppMethodBeat.o(17931);
        return false;
    }

    public static String coerceValueIfNullOrEmpty(String str, String str2) {
        AppMethodBeat.i(17932);
        if (isNullOrEmpty(str)) {
            AppMethodBeat.o(17932);
            return str2;
        }
        AppMethodBeat.o(17932);
        return str;
    }

    public static <T> Collection<T> unmodifiableCollection(T... tArr) {
        AppMethodBeat.i(17933);
        Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(tArr));
        AppMethodBeat.o(17933);
        return unmodifiableCollection;
    }

    public static <T> ArrayList<T> arrayList(T... tArr) {
        AppMethodBeat.i(17934);
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        AppMethodBeat.o(17934);
        return arrayList;
    }

    public static <T> HashSet<T> hashSet(T... tArr) {
        AppMethodBeat.i(17935);
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T t : tArr) {
            hashSet.add(t);
        }
        AppMethodBeat.o(17935);
        return hashSet;
    }

    public static String md5hash(String str) {
        AppMethodBeat.i(17936);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
        AppMethodBeat.o(17936);
        return hashWithAlgorithm;
    }

    public static String sha1hash(String str) {
        AppMethodBeat.i(17937);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
        AppMethodBeat.o(17937);
        return hashWithAlgorithm;
    }

    public static String sha1hash(byte[] bArr) {
        AppMethodBeat.i(17938);
        String hashWithAlgorithm = hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
        AppMethodBeat.o(17938);
        return hashWithAlgorithm;
    }

    private static String hashWithAlgorithm(String str, String str2) {
        AppMethodBeat.i(17939);
        String hashWithAlgorithm = hashWithAlgorithm(str, str2.getBytes());
        AppMethodBeat.o(17939);
        return hashWithAlgorithm;
    }

    private static String hashWithAlgorithm(String str, byte[] bArr) {
        AppMethodBeat.i(17940);
        try {
            String hashBytes = hashBytes(MessageDigest.getInstance(str), bArr);
            AppMethodBeat.o(17940);
            return hashBytes;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(17940);
            return null;
        }
    }

    private static String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        AppMethodBeat.i(17941);
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b2 : digest) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(17941);
        return sb2;
    }

    public static Uri buildUri(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(17942);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(URL_SCHEME);
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        AppMethodBeat.o(17942);
        return build;
    }

    public static Bundle parseUrlQueryString(String str) {
        AppMethodBeat.i(17943);
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    logd(LOG_TAG, e2);
                }
            }
        }
        AppMethodBeat.o(17943);
        return bundle;
    }

    public static void putNonEmptyString(Bundle bundle, String str, String str2) {
        AppMethodBeat.i(17944);
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
        AppMethodBeat.o(17944);
    }

    public static void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        AppMethodBeat.i(17945);
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : list) {
                sb.append(str2);
                sb.append(",");
            }
            String str3 = "";
            if (sb.length() > 0) {
                str3 = sb.substring(0, sb.length() - 1);
            }
            bundle.putString(str, str3);
        }
        AppMethodBeat.o(17945);
    }

    public static void putUri(Bundle bundle, String str, Uri uri) {
        AppMethodBeat.i(17946);
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
        AppMethodBeat.o(17946);
    }

    public static boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        AppMethodBeat.i(17947);
        if (obj == null) {
            bundle.remove(str);
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, obj.toString());
        } else {
            AppMethodBeat.o(17947);
            return false;
        }
        AppMethodBeat.o(17947);
        return true;
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(17948);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(17948);
                return;
            }
        }
        AppMethodBeat.o(17948);
    }

    public static void disconnectQuietly(URLConnection uRLConnection) {
        AppMethodBeat.i(17949);
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
        AppMethodBeat.o(17949);
    }

    public static String getMetadataApplicationId(Context context) {
        AppMethodBeat.i(17950);
        Validate.notNull(context, "context");
        FacebookSdk.sdkInitialize(context);
        String applicationId = FacebookSdk.getApplicationId();
        AppMethodBeat.o(17950);
        return applicationId;
    }

    static Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        AppMethodBeat.i(17951);
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        for (int i2 = 0; i2 < names.length(); i2++) {
            try {
                String string = names.getString(i2);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                hashMap.put(string, obj);
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(17951);
        return hashMap;
    }

    public static Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) {
        Object obj;
        AppMethodBeat.i(17952);
        Object opt = jSONObject.opt(str);
        if (opt == null || !(opt instanceof String)) {
            obj = opt;
        } else {
            obj = new JSONTokener((String) opt).nextValue();
        }
        if (obj == null || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            AppMethodBeat.o(17952);
            return obj;
        } else if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, obj);
            AppMethodBeat.o(17952);
            return jSONObject2;
        } else {
            FacebookException facebookException = new FacebookException("Got an unexpected non-JSON object.");
            AppMethodBeat.o(17952);
            throw facebookException;
        }
    }

    public static String readStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(17953);
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                AppMethodBeat.o(17953);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        String sb2 = sb.toString();
                        closeQuietly(bufferedInputStream);
                        closeQuietly(inputStreamReader);
                        AppMethodBeat.o(17953);
                        return sb2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                AppMethodBeat.o(17953);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            bufferedInputStream = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            AppMethodBeat.o(17953);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) {
        /*
            r0 = 0
            r5 = 17954(0x4622, float:2.5159E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            r2 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0029 }
            r1.<init>(r6)     // Catch:{ all -> 0x0029 }
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0039 }
        L_0x0010:
            int r3 = r1.read(r2)     // Catch:{ all -> 0x0039 }
            r4 = -1
            if (r3 == r4) goto L_0x001d
            r4 = 0
            r7.write(r2, r4, r3)     // Catch:{ all -> 0x0039 }
            int r0 = r0 + r3
            goto L_0x0010
        L_0x001d:
            r1.close()
            if (r6 == 0) goto L_0x0025
            r6.close()
        L_0x0025:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x0029:
            r0 = move-exception
            r1 = r2
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            if (r6 == 0) goto L_0x0035
            r6.close()
        L_0x0035:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0039:
            r0 = move-exception
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    public static boolean stringsEqualOrEmpty(String str, String str2) {
        AppMethodBeat.i(17955);
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            AppMethodBeat.o(17955);
            return true;
        } else if (isEmpty || isEmpty2) {
            AppMethodBeat.o(17955);
            return false;
        } else {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(17955);
            return equals;
        }
    }

    private static void clearCookiesForDomain(Context context, String str) {
        AppMethodBeat.i(17956);
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie == null) {
            AppMethodBeat.o(17956);
            return;
        }
        String[] split = cookie.split(";");
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length > 0) {
                instance.setCookie(str, split2[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        instance.removeExpiredCookie();
        AppMethodBeat.o(17956);
    }

    public static void clearFacebookCookies(Context context) {
        AppMethodBeat.i(17957);
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
        AppMethodBeat.o(17957);
    }

    public static void logd(String str, Exception exc) {
        AppMethodBeat.i(17958);
        if (!(!FacebookSdk.isDebugEnabled() || str == null || exc == null)) {
            new StringBuilder().append(exc.getClass().getSimpleName()).append(": ").append(exc.getMessage());
        }
        AppMethodBeat.o(17958);
    }

    public static void logd(String str, String str2) {
        AppMethodBeat.i(17959);
        FacebookSdk.isDebugEnabled();
        AppMethodBeat.o(17959);
    }

    public static void logd(String str, String str2, Throwable th) {
        AppMethodBeat.i(17960);
        if (FacebookSdk.isDebugEnabled()) {
            isNullOrEmpty(str);
        }
        AppMethodBeat.o(17960);
    }

    public static <T> boolean areObjectsEqual(T t, T t2) {
        AppMethodBeat.i(17961);
        if (t != null) {
            boolean equals = t.equals(t2);
            AppMethodBeat.o(17961);
            return equals;
        } else if (t2 == null) {
            AppMethodBeat.o(17961);
            return true;
        } else {
            AppMethodBeat.o(17961);
            return false;
        }
    }

    public static boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        AppMethodBeat.i(17962);
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has("id") || !jSONObject2.has("id")) {
            AppMethodBeat.o(17962);
            return false;
        } else if (jSONObject.equals(jSONObject2)) {
            AppMethodBeat.o(17962);
            return true;
        } else {
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject2.optString("id");
            if (optString == null || optString2 == null) {
                AppMethodBeat.o(17962);
                return false;
            }
            boolean equals = optString.equals(optString2);
            AppMethodBeat.o(17962);
            return equals;
        }
    }

    public static String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.i(17963);
        if (jSONObject != null) {
            String optString = jSONObject.optString(str, "");
            AppMethodBeat.o(17963);
            return optString;
        }
        AppMethodBeat.o(17963);
        return "";
    }

    public static JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.i(17964);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            AppMethodBeat.o(17964);
            return optJSONObject;
        }
        AppMethodBeat.o(17964);
        return null;
    }

    public static JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        AppMethodBeat.i(17965);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            AppMethodBeat.o(17965);
            return optJSONArray;
        }
        AppMethodBeat.o(17965);
        return null;
    }

    public static void clearCaches(Context context) {
        AppMethodBeat.i(17966);
        ImageDownloader.clearCache(context);
        AppMethodBeat.o(17966);
    }

    public static void deleteDirectory(File file) {
        File[] listFiles;
        AppMethodBeat.i(17967);
        if (!file.exists()) {
            AppMethodBeat.o(17967);
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDirectory(file2);
            }
        }
        file.delete();
        AppMethodBeat.o(17967);
    }

    public static <T> List<T> asListNoNulls(T... tArr) {
        AppMethodBeat.i(17968);
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(17968);
        return arrayList;
    }

    public static List<String> jsonArrayToStringList(JSONArray jSONArray) {
        AppMethodBeat.i(17969);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        AppMethodBeat.o(17969);
        return arrayList;
    }

    public static Set<String> jsonArrayToSet(JSONArray jSONArray) {
        AppMethodBeat.i(17970);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.getString(i2));
        }
        AppMethodBeat.o(17970);
        return hashSet;
    }

    public static void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(17971);
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAttributionId() == null)) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
        }
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidInstallerPackage() == null)) {
            jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
        }
        jSONObject.put("anon_id", str);
        if (z) {
            z2 = false;
        }
        jSONObject.put("application_tracking_enabled", z2);
        AppMethodBeat.o(17971);
    }

    public static void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) {
        Locale locale;
        int i2;
        int i3;
        double d2;
        AppMethodBeat.i(17972);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i4 = -1;
        String str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i4 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception e3) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                try {
                    i3 = displayMetrics.heightPixels;
                } catch (Exception e4) {
                    i3 = 0;
                    d2 = 0.0d;
                    jSONArray.put(i2);
                    jSONArray.put(i3);
                    jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
                    jSONArray.put(refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put(deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                    AppMethodBeat.o(17972);
                }
                try {
                    d2 = (double) displayMetrics.density;
                } catch (Exception e5) {
                    d2 = 0.0d;
                    jSONArray.put(i2);
                    jSONArray.put(i3);
                    jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
                    jSONArray.put(refreshBestGuessNumberOfCPUCores());
                    jSONArray.put(totalExternalStorageGB);
                    jSONArray.put(availableExternalStorageGB);
                    jSONArray.put(deviceTimeZoneName);
                    jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                    AppMethodBeat.o(17972);
                }
            } else {
                d2 = 0.0d;
                i3 = 0;
                i2 = 0;
            }
        } catch (Exception e6) {
            i3 = 0;
            i2 = 0;
            d2 = 0.0d;
            jSONArray.put(i2);
            jSONArray.put(i3);
            jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
            jSONArray.put(refreshBestGuessNumberOfCPUCores());
            jSONArray.put(totalExternalStorageGB);
            jSONArray.put(availableExternalStorageGB);
            jSONArray.put(deviceTimeZoneName);
            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
            AppMethodBeat.o(17972);
        }
        jSONArray.put(i2);
        jSONArray.put(i3);
        jSONArray.put(String.format("%.2f", Double.valueOf(d2)));
        jSONArray.put(refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put(Constants.EXTINFO, jSONArray.toString());
        AppMethodBeat.o(17972);
    }

    public static Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(17973);
        try {
            Method method = cls.getMethod(str, clsArr);
            AppMethodBeat.o(17973);
            return method;
        } catch (NoSuchMethodException e2) {
            AppMethodBeat.o(17973);
            return null;
        }
    }

    public static Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        AppMethodBeat.i(17974);
        try {
            Method methodQuietly = getMethodQuietly(Class.forName(str), str2, clsArr);
            AppMethodBeat.o(17974);
            return methodQuietly;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(17974);
            return null;
        }
    }

    public static Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Object obj2 = null;
        AppMethodBeat.i(17975);
        try {
            obj2 = method.invoke(obj, objArr);
            AppMethodBeat.o(17975);
        } catch (IllegalAccessException e2) {
            AppMethodBeat.o(17975);
        } catch (InvocationTargetException e3) {
            AppMethodBeat.o(17975);
        }
        return obj2;
    }

    public static String getActivityName(Context context) {
        AppMethodBeat.i(17976);
        if (context == null) {
            AppMethodBeat.o(17976);
            return BuildConfig.COMMAND;
        } else if (context == context.getApplicationContext()) {
            AppMethodBeat.o(17976);
            return "unknown";
        } else {
            String simpleName = context.getClass().getSimpleName();
            AppMethodBeat.o(17976);
            return simpleName;
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        AppMethodBeat.i(17977);
        if (list == null) {
            AppMethodBeat.o(17977);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (predicate.apply(t)) {
                arrayList.add(t);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(17977);
            return null;
        }
        AppMethodBeat.o(17977);
        return arrayList;
    }

    public static <T, K> List<K> map(List<T> list, Mapper<T, K> mapper) {
        AppMethodBeat.i(17978);
        if (list == null) {
            AppMethodBeat.o(17978);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            K apply = mapper.apply(t);
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(17978);
            return null;
        }
        AppMethodBeat.o(17978);
        return arrayList;
    }

    public static String getUriString(Uri uri) {
        AppMethodBeat.i(17979);
        if (uri == null) {
            AppMethodBeat.o(17979);
            return null;
        }
        String uri2 = uri.toString();
        AppMethodBeat.o(17979);
        return uri2;
    }

    public static boolean isWebUri(Uri uri) {
        AppMethodBeat.i(17980);
        if (uri == null || (!"http".equalsIgnoreCase(uri.getScheme()) && !URL_SCHEME.equalsIgnoreCase(uri.getScheme()) && !"fbstaging".equalsIgnoreCase(uri.getScheme()))) {
            AppMethodBeat.o(17980);
            return false;
        }
        AppMethodBeat.o(17980);
        return true;
    }

    public static boolean isContentUri(Uri uri) {
        AppMethodBeat.i(17981);
        if (uri == null || !"content".equalsIgnoreCase(uri.getScheme())) {
            AppMethodBeat.o(17981);
            return false;
        }
        AppMethodBeat.o(17981);
        return true;
    }

    public static boolean isFileUri(Uri uri) {
        AppMethodBeat.i(17982);
        if (uri == null || !"file".equalsIgnoreCase(uri.getScheme())) {
            AppMethodBeat.o(17982);
            return false;
        }
        AppMethodBeat.o(17982);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getContentSize(android.net.Uri r8) {
        /*
            r7 = 17983(0x463f, float:2.52E-41)
            r6 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x002e }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x002e }
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r1 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "_size"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ all -> 0x0039 }
            r1.moveToFirst()     // Catch:{ all -> 0x0039 }
            long r2 = r1.getLong(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x002a
            r1.close()
        L_0x002a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return r2
        L_0x002e:
            r0 = move-exception
            r1 = r6
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()
        L_0x0035:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r0
        L_0x0039:
            r0 = move-exception
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.getContentSize(android.net.Uri):long");
    }

    public static Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long parseLong;
        AppMethodBeat.i(17984);
        if (bundle == null) {
            AppMethodBeat.o(17984);
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Long) obj).longValue();
        } else if (obj instanceof String) {
            try {
                parseLong = Long.parseLong((String) obj);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(17984);
                return null;
            }
        } else {
            AppMethodBeat.o(17984);
            return null;
        }
        if (parseLong == 0) {
            Date date2 = new Date((long) MAlarmHandler.NEXT_FIRE_INTERVAL);
            AppMethodBeat.o(17984);
            return date2;
        }
        Date date3 = new Date((parseLong * 1000) + date.getTime());
        AppMethodBeat.o(17984);
        return date3;
    }

    public static void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        AppMethodBeat.i(17985);
        if (map == null) {
            parcel.writeInt(-1);
            AppMethodBeat.o(17985);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        AppMethodBeat.o(17985);
    }

    public static Map<String, String> readStringMapFromParcel(Parcel parcel) {
        AppMethodBeat.i(17986);
        int readInt = parcel.readInt();
        if (readInt < 0) {
            AppMethodBeat.o(17986);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        AppMethodBeat.o(17986);
        return hashMap;
    }

    public static boolean isCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(17987);
        if (accessToken == null || !accessToken.equals(AccessToken.getCurrentAccessToken())) {
            AppMethodBeat.o(17987);
            return false;
        }
        AppMethodBeat.o(17987);
        return true;
    }

    public static void getGraphMeRequestWithCacheAsync(final String str, final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        AppMethodBeat.i(17988);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            AppMethodBeat.o(17988);
            return;
        }
        AnonymousClass1 r0 = new GraphRequest.Callback() {
            /* class com.facebook.internal.Utility.AnonymousClass1 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(17926);
                if (graphResponse.getError() != null) {
                    graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
                    AppMethodBeat.o(17926);
                    return;
                }
                ProfileInformationCache.putProfileInformation(str, graphResponse.getJSONObject());
                graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJSONObject());
                AppMethodBeat.o(17926);
            }
        };
        GraphRequest graphMeRequestWithCache = getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(r0);
        graphMeRequestWithCache.executeAsync();
        AppMethodBeat.o(17988);
    }

    public static JSONObject awaitGetGraphMeRequestWithCache(String str) {
        AppMethodBeat.i(17989);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            AppMethodBeat.o(17989);
            return profileInformation;
        }
        GraphResponse executeAndWait = getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            AppMethodBeat.o(17989);
            return null;
        }
        JSONObject jSONObject = executeAndWait.getJSONObject();
        AppMethodBeat.o(17989);
        return jSONObject;
    }

    private static GraphRequest getGraphMeRequestWithCache(String str) {
        AppMethodBeat.i(17990);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name,link");
        bundle.putString("access_token", str);
        GraphRequest graphRequest = new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
        AppMethodBeat.o(17990);
        return graphRequest;
    }

    private static int refreshBestGuessNumberOfCPUCores() {
        AppMethodBeat.i(17991);
        if (numCPUCores > 0) {
            int i2 = numCPUCores;
            AppMethodBeat.o(17991);
            return i2;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() {
                /* class com.facebook.internal.Utility.AnonymousClass2 */

                public final boolean accept(File file, String str) {
                    AppMethodBeat.i(17927);
                    boolean matches = Pattern.matches("cpu[0-9]+", str);
                    AppMethodBeat.o(17927);
                    return matches;
                }
            });
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception e2) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        int i3 = numCPUCores;
        AppMethodBeat.o(17991);
        return i3;
    }

    private static void refreshPeriodicExtendedDeviceInfo(Context context) {
        AppMethodBeat.i(17992);
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
        AppMethodBeat.o(17992);
    }

    private static void refreshTimezone() {
        AppMethodBeat.i(17993);
        try {
            TimeZone timeZone = TimeZone.getDefault();
            deviceTimezoneAbbreviation = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            deviceTimeZoneName = timeZone.getID();
            AppMethodBeat.o(17993);
        } catch (AssertionError e2) {
            AppMethodBeat.o(17993);
        } catch (Exception e3) {
            AppMethodBeat.o(17993);
        }
    }

    private static void refreshCarrierName(Context context) {
        AppMethodBeat.i(17994);
        if (carrierName.equals(noCarrierConstant)) {
            try {
                carrierName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
                AppMethodBeat.o(17994);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(17994);
    }

    private static boolean externalStorageExists() {
        AppMethodBeat.i(17995);
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        AppMethodBeat.o(17995);
        return equals;
    }

    private static void refreshAvailableExternalStorage() {
        AppMethodBeat.i(17996);
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
            AppMethodBeat.o(17996);
        } catch (Exception e2) {
            AppMethodBeat.o(17996);
        }
    }

    private static void refreshTotalExternalStorage() {
        AppMethodBeat.i(17997);
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
            AppMethodBeat.o(17997);
        } catch (Exception e2) {
            AppMethodBeat.o(17997);
        }
    }

    private static long convertBytesToGB(double d2) {
        AppMethodBeat.i(17998);
        long round = Math.round(d2 / 1.073741824E9d);
        AppMethodBeat.o(17998);
        return round;
    }

    public static class PermissionsPair {
        List<String> declinedPermissions;
        List<String> grantedPermissions;

        public PermissionsPair(List<String> list, List<String> list2) {
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
        }

        public List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }
    }

    public static PermissionsPair handlePermissionResponse(JSONObject jSONObject) {
        String optString;
        AppMethodBeat.i(17999);
        JSONArray jSONArray = jSONObject.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS).getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString2 = optJSONObject.optString("permission");
            if (!(optString2 == null || optString2.equals("installed") || (optString = optJSONObject.optString("status")) == null)) {
                if (optString.equals("granted")) {
                    arrayList.add(optString2);
                } else if (optString.equals("declined")) {
                    arrayList2.add(optString2);
                }
            }
        }
        PermissionsPair permissionsPair = new PermissionsPair(arrayList, arrayList2);
        AppMethodBeat.o(17999);
        return permissionsPair;
    }

    public static String generateRandomString(int i2) {
        AppMethodBeat.i(18000);
        String bigInteger = new BigInteger(i2 * 5, new Random()).toString(32);
        AppMethodBeat.o(18000);
        return bigInteger;
    }

    public static boolean mustFixWindowParamsForAutofill(Context context) {
        AppMethodBeat.i(18001);
        boolean isAutofillAvailable = isAutofillAvailable(context);
        AppMethodBeat.o(18001);
        return isAutofillAvailable;
    }

    public static boolean isAutofillAvailable(Context context) {
        AppMethodBeat.i(18002);
        if (Build.VERSION.SDK_INT < 26) {
            AppMethodBeat.o(18002);
            return false;
        }
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager == null || !autofillManager.isAutofillSupported() || !autofillManager.isEnabled()) {
            AppMethodBeat.o(18002);
            return false;
        }
        AppMethodBeat.o(18002);
        return true;
    }

    public static boolean isChromeOS(Context context) {
        AppMethodBeat.i(18003);
        if (Build.VERSION.SDK_INT >= 27) {
            boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            AppMethodBeat.o(18003);
            return hasSystemFeature;
        } else if (Build.DEVICE == null || !Build.DEVICE.matches(ARC_DEVICE_PATTERN)) {
            AppMethodBeat.o(18003);
            return false;
        } else {
            AppMethodBeat.o(18003);
            return true;
        }
    }

    public static Locale getCurrentLocale() {
        Locale locale;
        AppMethodBeat.i(18004);
        try {
            locale = FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception e2) {
            locale = Locale.getDefault();
        }
        AppMethodBeat.o(18004);
        return locale;
    }
}
