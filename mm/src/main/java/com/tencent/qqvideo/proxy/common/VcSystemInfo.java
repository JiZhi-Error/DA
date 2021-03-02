package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class VcSystemInfo {
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int NETWORK_AP_3G = 2;
    public static final int NETWORK_AP_GPRS = 3;
    public static final int NETWORK_AP_LINE = 4;
    public static final int NETWORK_AP_WIFI = 1;
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_NONE = 0;
    private static final int NETWORK_TYPE_1xRTT = 7;
    private static final int NETWORK_TYPE_CDMA = 4;
    private static final int NETWORK_TYPE_EDGE = 2;
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_0 = 5;
    private static final int NETWORK_TYPE_EVDO_A = 6;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_GPRS = 1;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final int NETWORK_TYPE_UMTS = 3;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "VcSystemInfo";
    public static final int TYPE_CMNET = 2;
    public static final int TYPE_CMWAP = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OTHER = 4;
    public static final int TYPE_WIFI = 1;
    private static int appVersionCode = 0;
    private static String appVersionName;
    private static String deviceID = "";
    private static String deviceIMEI;
    private static String deviceIMSI;
    private static String deviceMacAddr;
    public static int mCpuArchitecture = 0;
    public static String mCpuHardware = "";
    private static int mDeviceLevel = 0;
    public static String mFeature = "";
    private static int mMCC = 0;
    private static int mMNC = 0;
    public static String mProcessorName = "N/A";
    public static int mScreenHeight;
    public static int mScreenWidth;
    public int mCoreNumber = 1;
    public long mCurrCpuFreq = 0;
    private long mLastCpu;
    private long mLastIdle;
    public long mMaxCpuFreq = 0;
    public int mdispHeight;
    public int mdispWidth;

    public VcSystemInfo() {
        mScreenWidth = 320;
        mScreenHeight = 480;
        this.mdispWidth = 320;
        this.mdispHeight = 240;
        this.mLastCpu = 0;
        this.mLastIdle = 0;
    }

    public static String getDeviceIMEI(Context context) {
        AppMethodBeat.i(89703);
        if (!TextUtils.isEmpty(deviceIMEI)) {
            String str = deviceIMEI;
            AppMethodBeat.o(89703);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(89703);
            return "";
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    deviceIMEI = deviceId;
                    if (deviceId == null) {
                        deviceIMEI = "";
                    }
                    String str2 = deviceIMEI;
                    AppMethodBeat.o(89703);
                    return str2;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(89703);
            return "";
        }
    }

    public static String getDeviceIMSI(Context context) {
        AppMethodBeat.i(89704);
        if (!TextUtils.isEmpty(deviceIMSI)) {
            String str = deviceIMSI;
            AppMethodBeat.o(89704);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(89704);
            return "";
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String subscriberId = telephonyManager.getSubscriberId();
                    deviceIMSI = subscriberId;
                    if (subscriberId == null) {
                        deviceIMSI = "";
                    }
                    String str2 = deviceIMSI;
                    AppMethodBeat.o(89704);
                    return str2;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(89704);
            return "";
        }
    }

    public static String getDeviceID(Context context) {
        AppMethodBeat.i(89705);
        if (!TextUtils.isEmpty(deviceID)) {
            String str = deviceID;
            AppMethodBeat.o(89705);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(89705);
            return "";
        } else {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "android_id");
                deviceID = string;
                if (string == null) {
                    deviceID = "";
                }
            } catch (Throwable th) {
                deviceID = "";
            }
            String str2 = deviceID;
            AppMethodBeat.o(89705);
            return str2;
        }
    }

    public static String getDeviceMacAddr(Context context) {
        WifiInfo connectionInfo;
        AppMethodBeat.i(89706);
        if (!TextUtils.isEmpty(deviceMacAddr)) {
            String str = deviceMacAddr;
            AppMethodBeat.o(89706);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(89706);
            return "";
        } else {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                    String macAddress = connectionInfo.getMacAddress();
                    deviceMacAddr = macAddress;
                    if (macAddress == null) {
                        deviceMacAddr = "";
                    }
                    String str2 = deviceMacAddr;
                    AppMethodBeat.o(89706);
                    return str2;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(89706);
            return "";
        }
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getOsVerIntFromVerStr() {
        AppMethodBeat.i(89707);
        String osVersion = getOsVersion();
        int osVerInt = getOsVerInt();
        if (osVersion.length() >= 3) {
            try {
                int parseInt = Integer.parseInt(osVersion.substring(0, 1));
                int parseInt2 = Integer.parseInt(osVersion.substring(2, 3));
                if (parseInt != 2) {
                    if (parseInt == 4) {
                        switch (parseInt2) {
                            case 0:
                                osVerInt = 14;
                                break;
                            case 1:
                                osVerInt = 16;
                                break;
                            case 2:
                                osVerInt = 17;
                                break;
                            case 3:
                                osVerInt = 18;
                                break;
                            case 4:
                                osVerInt = 19;
                                break;
                        }
                    }
                } else if (parseInt2 == 3) {
                    osVerInt = 9;
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(89707);
        return osVerInt;
    }

    public static int getOsVerInt() {
        switch (Build.VERSION.SDK_INT) {
            case 9:
            case 10:
                return 9;
            case 11:
            case 12:
            case 13:
            default:
                return 0;
            case 14:
            case 15:
                return 14;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
            case 20:
                return 19;
        }
    }

    public static String getRomInfo() {
        return Build.VERSION.INCREMENTAL;
    }

    public static int GetNetAP(Context context) {
        AppMethodBeat.i(89708);
        if (context == null) {
            AppMethodBeat.o(89708);
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(89708);
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(89708);
            return 0;
        } else if ("wifi".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
            AppMethodBeat.o(89708);
            return 1;
        } else {
            AppMethodBeat.o(89708);
            return 2;
        }
    }

    public static String getAppName(Context context, String str) {
        AppMethodBeat.i(89709);
        if (context == null) {
            AppMethodBeat.o(89709);
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String charSequence = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
            AppMethodBeat.o(89709);
            return charSequence;
        } catch (Throwable th) {
            AppMethodBeat.o(89709);
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        AppMethodBeat.i(89710);
        if (!TextUtils.isEmpty(appVersionName)) {
            String str = appVersionName;
            AppMethodBeat.o(89710);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(89710);
            return "";
        } else {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                appVersionName = str2;
                if (str2 == null) {
                    str2 = "";
                }
                AppMethodBeat.o(89710);
                return str2;
            } catch (Throwable th) {
                AppMethodBeat.o(89710);
                return "";
            }
        }
    }

    public static int getAppVersionCode(Context context, String str) {
        AppMethodBeat.i(89711);
        if (appVersionCode != 0) {
            int i2 = appVersionCode;
            AppMethodBeat.o(89711);
            return i2;
        } else if (context == null) {
            AppMethodBeat.o(89711);
            return 0;
        } else {
            try {
                int i3 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
                appVersionCode = i3;
                AppMethodBeat.o(89711);
                return i3;
            } catch (Throwable th) {
                AppMethodBeat.o(89711);
                return 0;
            }
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.i(89712);
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(89712);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                AppMethodBeat.o(89712);
                return false;
            } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                AppMethodBeat.o(89712);
                return true;
            } else {
                AppMethodBeat.o(89712);
                return false;
            }
        } else {
            AppMethodBeat.o(89712);
            return false;
        }
    }

    public static int getNetWorkType(Context context) {
        int i2;
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(89713);
        if (context == null) {
            AppMethodBeat.o(89713);
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                i2 = 0;
                AppMethodBeat.o(89713);
                return i2;
            }
            switch (activeNetworkInfo.getType()) {
                case 0:
                    i2 = 2;
                    try {
                        if (activeNetworkInfo.getExtraInfo() != null && !"cmnet".equalsIgnoreCase(activeNetworkInfo.getExtraInfo())) {
                            i2 = 3;
                            break;
                        }
                    } catch (Exception e2) {
                        break;
                    }
                case 1:
                    i2 = 1;
                    break;
                default:
                    i2 = 4;
                    break;
            }
            AppMethodBeat.o(89713);
            return i2;
        } catch (Exception e3) {
            i2 = 0;
        }
    }

    public static int getWifiNetStrength(Context context) {
        AppMethodBeat.i(89714);
        if (context == null) {
            AppMethodBeat.o(89714);
            return 0;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                AppMethodBeat.o(89714);
                return 0;
            }
            int rssi = connectionInfo.getRssi();
            if (Build.VERSION.SDK_INT >= 14) {
                int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 101);
                AppMethodBeat.o(89714);
                return calculateSignalLevel;
            } else if (rssi <= -100) {
                AppMethodBeat.o(89714);
                return 0;
            } else if (rssi >= -55) {
                AppMethodBeat.o(89714);
                return 100;
            } else {
                int i2 = (int) ((((float) (rssi + 100)) * 100.0f) / 45.0f);
                AppMethodBeat.o(89714);
                return i2;
            }
        } catch (Throwable th) {
            AppMethodBeat.o(89714);
            return 0;
        }
    }

    public static long getRxBytesFromNetwork(Context context) {
        long j2 = -1;
        AppMethodBeat.i(89715);
        if (context == null) {
            AppMethodBeat.o(89715);
            return -1;
        }
        try {
            context.getClassLoader().loadClass("android.net.TrafficStats");
            if (-1 == -1) {
                j2 = TrafficStats.getTotalRxBytes();
            }
            AppMethodBeat.o(89715);
            return j2;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(89715);
            return 0;
        } catch (Throwable th) {
            AppMethodBeat.o(89715);
            return 0;
        }
    }

    public static long getAppInstallTime(Context context) {
        long j2 = 0;
        AppMethodBeat.i(89716);
        if (context == null) {
            AppMethodBeat.o(89716);
        } else {
            try {
                j2 = new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000;
                AppMethodBeat.o(89716);
            } catch (PackageManager.NameNotFoundException e2) {
                AppMethodBeat.o(89716);
            } catch (Throwable th) {
                AppMethodBeat.o(89716);
            }
        }
        return j2;
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(89717);
        if (context == null) {
            AppMethodBeat.o(89717);
            return 0;
        } else if (mScreenWidth != 0) {
            int i2 = mScreenWidth;
            AppMethodBeat.o(89717);
            return i2;
        } else {
            try {
                mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
            } catch (Throwable th) {
            }
            int i3 = mScreenWidth;
            AppMethodBeat.o(89717);
            return i3;
        }
    }

    public static int getScreenHeight(Context context) {
        AppMethodBeat.i(89718);
        if (context == null) {
            AppMethodBeat.o(89718);
            return 0;
        } else if (mScreenHeight != 0) {
            int i2 = mScreenHeight;
            AppMethodBeat.o(89718);
            return i2;
        } else {
            try {
                mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
            } catch (Throwable th) {
            }
            int i3 = mScreenHeight;
            AppMethodBeat.o(89718);
            return i3;
        }
    }

    public static boolean isNetworkTypeMobile(Context context) {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(89719);
        if (context == null) {
            AppMethodBeat.o(89719);
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            AppMethodBeat.o(89719);
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                AppMethodBeat.o(89719);
                return true;
            case 1:
            default:
                AppMethodBeat.o(89719);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A[SYNTHETIC, Splitter:B:24:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A[Catch:{ Throwable -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A[SYNTHETIC, Splitter:B:32:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[Catch:{ Throwable -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getMarketId(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.common.VcSystemInfo.getMarketId(android.content.Context):int");
    }

    public static int getMCC(Context context) {
        AppMethodBeat.i(89721);
        if (mMCC != 0) {
            int i2 = mMCC;
            AppMethodBeat.o(89721);
            return i2;
        } else if (context == null) {
            AppMethodBeat.o(89721);
            return 0;
        } else {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (configuration != null) {
                    mMCC = configuration.mcc;
                }
                int i3 = mMCC;
                AppMethodBeat.o(89721);
                return i3;
            } catch (Throwable th) {
                AppMethodBeat.o(89721);
                return 0;
            }
        }
    }

    public static int getMNC(Context context) {
        AppMethodBeat.i(89722);
        if (mMNC != 0) {
            int i2 = mMNC;
            AppMethodBeat.o(89722);
            return i2;
        } else if (context == null) {
            AppMethodBeat.o(89722);
            return 0;
        } else {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                if (configuration != null) {
                    mMNC = configuration.mnc;
                }
                int i3 = mMNC;
                AppMethodBeat.o(89722);
                return i3;
            } catch (Throwable th) {
                AppMethodBeat.o(89722);
                return 0;
            }
        }
    }

    public static String PrintStack(Throwable th) {
        AppMethodBeat.i(89723);
        if (th == null) {
            AppMethodBeat.o(89723);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            AppMethodBeat.o(89723);
            return byteArrayOutputStream2;
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            AppMethodBeat.o(89723);
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021 A[SYNTHETIC, Splitter:B:12:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[SYNTHETIC, Splitter:B:18:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readSystemStat() {
        /*
            r0 = 0
            r4 = 89724(0x15e7c, float:1.2573E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x001d, all -> 0x0027 }
            java.lang.String r2 = "/proc/stat"
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x001d, all -> 0x0027 }
            java.lang.String r0 = r1.readLine()     // Catch:{ Throwable -> 0x003b, all -> 0x0037 }
            r1.close()     // Catch:{ Throwable -> 0x0035 }
        L_0x0019:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x001d:
            r1 = move-exception
            r1 = r0
        L_0x001f:
            if (r1 == 0) goto L_0x0019
            r1.close()     // Catch:{ Throwable -> 0x0025 }
            goto L_0x0019
        L_0x0025:
            r1 = move-exception
            goto L_0x0019
        L_0x0027:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x002a:
            if (r3 == 0) goto L_0x002f
            r3.close()     // Catch:{ Throwable -> 0x0033 }
        L_0x002f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x0033:
            r0 = move-exception
            goto L_0x002f
        L_0x0035:
            r1 = move-exception
            goto L_0x0019
        L_0x0037:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x002a
        L_0x003b:
            r2 = move-exception
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqvideo.proxy.common.VcSystemInfo.readSystemStat():java.lang.String");
    }

    public static int getSystemCpuUsage(String str, String str2) {
        AppMethodBeat.i(89725);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(89725);
            return -1;
        }
        float f2 = -1.0f;
        try {
            String[] split = str.trim().split("\\s+");
            long systemIdleTime = getSystemIdleTime(split);
            long systemUptime = getSystemUptime(split);
            String[] split2 = str2.trim().split("\\s+");
            long systemIdleTime2 = getSystemIdleTime(split2);
            long systemUptime2 = getSystemUptime(split2);
            if (systemIdleTime >= 0 && systemUptime >= 0 && systemIdleTime2 >= 0 && systemUptime2 >= 0 && systemUptime2 + systemIdleTime2 > systemUptime + systemIdleTime && systemUptime2 >= systemUptime) {
                f2 = (((float) (systemUptime2 - systemUptime)) / ((float) ((systemIdleTime2 + systemUptime2) - (systemIdleTime + systemUptime)))) * 100.0f;
            }
        } catch (Throwable th) {
            f2 = -1.0f;
        }
        int i2 = (int) f2;
        AppMethodBeat.o(89725);
        return i2;
    }

    public static long getSystemUptime(String[] strArr) {
        AppMethodBeat.i(89726);
        long j2 = 0;
        for (int i2 = 1; i2 < strArr.length; i2++) {
            if (4 != i2) {
                try {
                    j2 += Long.parseLong(strArr[i2]);
                } catch (Throwable th) {
                    AppMethodBeat.o(89726);
                    return -1;
                }
            }
        }
        AppMethodBeat.o(89726);
        return j2;
    }

    public static long getSystemIdleTime(String[] strArr) {
        AppMethodBeat.i(89727);
        try {
            long parseLong = Long.parseLong(strArr[4]);
            AppMethodBeat.o(89727);
            return parseLong;
        } catch (Throwable th) {
            AppMethodBeat.o(89727);
            return -1;
        }
    }

    public static int getNetworkClass(Context context) {
        int i2;
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(89728);
        if (context == null) {
            AppMethodBeat.o(89728);
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    i2 = getNetworkClass(activeNetworkInfo.getSubtype());
                    break;
                default:
                    i2 = 0;
                    break;
            }
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(89728);
        return i2;
    }

    private static int getNetworkClass(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static String getWiFiMacAddress(Context context) {
        String str;
        AppMethodBeat.i(89729);
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Throwable th) {
            str = "";
        }
        AppMethodBeat.o(89729);
        return str;
    }
}
