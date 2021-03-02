package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static final int NETWORK_TYPE_2G = 4;
    static final int NETWORK_TYPE_3G = 3;
    static final int NETWORK_TYPE_4G = 2;
    static final int NETWORK_TYPE_UNKNOWN = 255;
    static final int NETWORK_TYPE_WIFI = 1;
    private static final String TAG = "TXCDRApi";
    private static String g_simulate_idfa = "";
    static boolean initRpt = false;
    private static String mAppName = "";
    private static String mDevId = "";
    private static String mDevType = "";
    private static String mDevUUID = "";
    private static String mNetType = "";
    private static String mSysVersion = "";

    public static native int nativeGetStatusReportInterval();

    private static native void nativeInitDataReport();

    private static native void nativeInitEventInternal(String str, int i2, int i3, TXCDRExtInfo tXCDRExtInfo);

    public static native void nativeReportAVRoomEvent(int i2, long j2, String str, int i3, int i4, String str2, String str3);

    private static native void nativeReportDAUInterval(int i2, int i3, String str);

    public static native void nativeReportEvent(String str, int i2);

    public static native void nativeReportEvent40003(String str, int i2, int i3, String str2, String str3);

    public static native void nativeSetCommonValue(String str, String str2);

    private static native void nativeSetEventValueInterval(String str, int i2, String str2, String str3);

    private static native void nativeUninitDataReport();

    static {
        AppMethodBeat.i(14636);
        f.f();
        nativeInitDataReport();
        AppMethodBeat.o(14636);
    }

    public static void InitEvent(Context context, String str, int i2, int i3, TXCDRExtInfo tXCDRExtInfo) {
        AppMethodBeat.i(14613);
        setCommonInfo(context);
        if (str == null) {
            AppMethodBeat.o(14613);
            return;
        }
        nativeInitEventInternal(str, i2, i3, tXCDRExtInfo);
        AppMethodBeat.o(14613);
    }

    public static void txSetEventValue(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(14614);
        nativeSetEventValueInterval(str, i2, str2, str3);
        AppMethodBeat.o(14614);
    }

    public static void txSetEventIntValue(String str, int i2, String str2, long j2) {
        AppMethodBeat.i(14615);
        nativeSetEventValueInterval(str, i2, str2, String.valueOf(j2));
        AppMethodBeat.o(14615);
    }

    public static void txReportDAU(Context context, int i2) {
        AppMethodBeat.i(14616);
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i2, 0, "");
        AppMethodBeat.o(14616);
    }

    public static void txReportDAU(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(14617);
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i2, i3, str);
        AppMethodBeat.o(14617);
    }

    public static void reportEvent40003(String str, int i2, int i3, String str2, String str3) {
        AppMethodBeat.i(14618);
        nativeReportEvent40003(str, i2, i3, str2, str3);
        AppMethodBeat.o(14618);
    }

    public static void reportAVRoomEvent(int i2, long j2, String str, int i3, int i4, String str2, String str3) {
        AppMethodBeat.i(14619);
        nativeReportAVRoomEvent(i2, j2, str, i3, i4, str2, str3);
        AppMethodBeat.o(14619);
    }

    public static int getStatusReportInterval() {
        AppMethodBeat.i(14620);
        int nativeGetStatusReportInterval = nativeGetStatusReportInterval();
        AppMethodBeat.o(14620);
        return nativeGetStatusReportInterval;
    }

    public static void setCommonInfo(Context context) {
        AppMethodBeat.i(14621);
        mDevType = Build.MODEL;
        mNetType = Integer.toString(getNetworkType(context));
        if (mDevId.isEmpty()) {
            mDevId = getSimulateIDFA(context);
        }
        if (mDevUUID.isEmpty()) {
            mDevUUID = getDevUUID(context, mDevId);
        }
        String packageName = getPackageName(context);
        mAppName = getApplicationNameByPackageName(context, packageName) + ":" + packageName;
        mSysVersion = String.valueOf(Build.VERSION.SDK_INT);
        txSetCommonInfo();
        AppMethodBeat.o(14621);
    }

    public static void txSetCommonInfo() {
        AppMethodBeat.i(14622);
        if (mDevType != null) {
            nativeSetCommonValue(a.f375f, mDevType);
        }
        if (mNetType != null) {
            nativeSetCommonValue(a.f376g, mNetType);
        }
        if (mDevId != null) {
            nativeSetCommonValue(a.f377h, mDevId);
        }
        if (mDevUUID != null) {
            nativeSetCommonValue(a.f378i, mDevUUID);
        }
        if (mAppName != null) {
            nativeSetCommonValue(a.f379j, mAppName);
        }
        if (mSysVersion != null) {
            nativeSetCommonValue(a.l, mSysVersion);
        }
        AppMethodBeat.o(14622);
    }

    public static void txSetAppVersion(String str) {
        AppMethodBeat.i(14623);
        if (str != null) {
            nativeSetCommonValue(a.k, str);
        }
        AppMethodBeat.o(14623);
    }

    public static String txCreateToken() {
        AppMethodBeat.i(14624);
        String uuid = UUID.randomUUID().toString();
        AppMethodBeat.o(14624);
        return uuid;
    }

    private static String byteArrayToHexString(byte[] bArr) {
        AppMethodBeat.i(14625);
        char[] cArr = new char[(bArr.length << 1)];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = i2 + 1;
            cArr[i2] = DIGITS_LOWER[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = DIGITS_LOWER[bArr[i3] & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(14625);
        return str;
    }

    public static String string2Md5(String str) {
        AppMethodBeat.i(14626);
        String str2 = "";
        if (str == null) {
            AppMethodBeat.o(14626);
        } else {
            try {
                str2 = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
            } catch (Exception e2) {
                TXCLog.e(TAG, "string2Md5 failed.", e2);
            }
            if (str2 == null) {
                str2 = "";
            }
            AppMethodBeat.o(14626);
        }
        return str2;
    }

    public static String getOrigAndroidID(Context context) {
        AppMethodBeat.i(14628);
        String str = "";
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
        }
        String string2Md5 = string2Md5(str);
        AppMethodBeat.o(14628);
        return string2Md5;
    }

    public static String getSimulateIDFA(Context context) {
        String str;
        String str2;
        AppMethodBeat.i(14630);
        if (g_simulate_idfa == null || g_simulate_idfa.length() <= 0) {
            String str3 = null;
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                TXCLog.e(TAG, "getSimulateIDFA sdcardDir is null");
                String str4 = g_simulate_idfa;
                AppMethodBeat.o(14630);
                return str4;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.liteav.dev_uuid", 0);
            String string = sharedPreferences.getString("com.tencent.liteav.key_dev_uuid", "");
            try {
                File file = new File(externalFilesDir.getAbsolutePath() + "/txrtmp/spuid");
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    int available = fileInputStream.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        fileInputStream.read(bArr);
                        str3 = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    }
                    fileInputStream.close();
                }
                str = str3;
            } catch (Exception e2) {
                TXCLog.e(TAG, "read UUID from file failed! reason: " + e2.getMessage());
                str = null;
            }
            if (string != null && string.length() > 0) {
                str2 = string;
            } else if (str == null || str.length() <= 0) {
                str2 = null;
            } else {
                str2 = str;
            }
            if (str2 == null || str2.length() == 0) {
                String str5 = "";
                long currentTimeMillis = System.currentTimeMillis();
                long timeTick = TXCTimeUtil.getTimeTick();
                String c2 = f.c(context);
                for (int i2 = 5; i2 >= 0; i2--) {
                    str5 = str5 + String.format("%02x", Byte.valueOf((byte) ((int) ((currentTimeMillis >> (i2 * 8)) & 255))));
                }
                for (int i3 = 3; i3 >= 0; i3--) {
                    str5 = str5 + String.format("%02x", Byte.valueOf((byte) ((int) ((timeTick >> (i3 * 8)) & 255))));
                }
                str2 = str5 + string2Md5(c2 + UUID.randomUUID().toString());
            }
            g_simulate_idfa = str2;
            TXCLog.i(TAG, "UUID:" + g_simulate_idfa);
            if (str == null || !str.equals(str2)) {
                try {
                    File file2 = new File(externalFilesDir.getAbsolutePath() + "/txrtmp");
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    File file3 = new File(externalFilesDir.getAbsolutePath() + "/txrtmp/spuid");
                    if (!file3.exists()) {
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    fileOutputStream.write(str2.getBytes());
                    fileOutputStream.close();
                } catch (Exception e3) {
                    TXCLog.e(TAG, "write UUID to file failed! reason: " + e3.getMessage());
                }
            }
            if (string == null || !string.equals(str2)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("com.tencent.liteav.key_dev_uuid", str2);
                edit.commit();
            }
            String str6 = g_simulate_idfa;
            AppMethodBeat.o(14630);
            return str6;
        }
        String str7 = g_simulate_idfa;
        AppMethodBeat.o(14630);
        return str7;
    }

    public static String getDevUUID(Context context, String str) {
        AppMethodBeat.i(14631);
        String simulateIDFA = getSimulateIDFA(context);
        AppMethodBeat.o(14631);
        return simulateIDFA;
    }

    public static int getNetworkType(Context context) {
        AppMethodBeat.i(14632);
        if (context == null) {
            AppMethodBeat.o(14632);
            return 255;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(14632);
                return 255;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(14632);
                return 1;
            } else if (activeNetworkInfo.getType() == 0) {
                try {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            AppMethodBeat.o(14632);
                            return 4;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            AppMethodBeat.o(14632);
                            return 3;
                        case 13:
                            AppMethodBeat.o(14632);
                            return 2;
                        default:
                            AppMethodBeat.o(14632);
                            return 2;
                    }
                } catch (Exception e2) {
                    TXCLog.e(TAG, "TXCDRApi: get network type fail, exception occurred.", e2);
                    AppMethodBeat.o(14632);
                    return 2;
                }
            } else {
                AppMethodBeat.o(14632);
                return 255;
            }
        } catch (Exception e3) {
            TXCLog.e(TAG, "getActiveNetworkInfo exception:", e3);
            AppMethodBeat.o(14632);
            return 255;
        }
    }

    private static String getPackageName(Context context) {
        AppMethodBeat.i(14633);
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e2) {
            TXCLog.e(TAG, "get package name failed.", e2);
        }
        AppMethodBeat.o(14633);
        return str;
    }

    public static String getApplicationNameByPackageName(Context context, String str) {
        String str2;
        AppMethodBeat.i(14634);
        PackageManager packageManager = context.getPackageManager();
        try {
            str2 = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (Exception e2) {
            str2 = "";
        }
        AppMethodBeat.o(14634);
        return str2;
    }

    public static void initCrashReport(Context context) {
        String sDKVersionStr;
        AppMethodBeat.i(14635);
        try {
            synchronized (TXCDRApi.class) {
                try {
                    if (!(initRpt || context == null || (sDKVersionStr = TXCCommonUtil.getSDKVersionStr()) == null)) {
                        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
                        edit.putString("8e50744bf0", sDKVersionStr);
                        edit.commit();
                        initRpt = true;
                    }
                } finally {
                    AppMethodBeat.o(14635);
                }
            }
        } catch (Exception e2) {
            TXCLog.e(TAG, "init crash report failed.", e2);
            AppMethodBeat.o(14635);
        }
    }
}
