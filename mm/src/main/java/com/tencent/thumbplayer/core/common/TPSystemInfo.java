package com.tencent.thumbplayer.core.common;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.audiofx.AudioEffect;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.b;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.regex.Pattern;

public class TPSystemInfo {
    public static final int CHIP_ARM_AARCH64 = 7;
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int CPU_HW_HISI = 2;
    public static final int CPU_HW_MTK = 1;
    public static final int CPU_HW_OTHER = -1;
    public static final int CPU_HW_QUALCOMM = 0;
    public static final int CPU_HW_SUMSUNG = 3;
    private static int cpuArch = -1;
    private static final String[][] cpuPerfList = {new String[]{"MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro", "MSM8998", "SDM845", "SM8150", "SM8250", "SM8350"}, new String[]{"MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T"}, new String[]{"K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960", "Kirin970", "Kirin980", "Kirin990"}, new String[]{"S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890"}};
    private static long currentCpuFreq = -1;
    private static String deviceID;
    private static String deviceIMEI;
    private static String deviceIMSI = "";
    private static String deviceMacAddr;
    private static Method getWlanMethod;
    private static long mAppInstallTime;
    private static int mAudioBestFramesPerBust = 0;
    private static int mAudioBestSampleRate = 0;
    private static int mCpuArchitecture = 0;
    private static int mCpuHWProductIdx = -1;
    private static int mCpuHWProducter = -1;
    private static String mCpuHardware = "";
    private static String mFeature = "";
    private static int mOpenGLVersion = 0;
    private static String mProcessorName = "N/A";
    public static int mScreenHeight;
    public static int mScreenWidth;
    private static long maxCpuFreq = -1;
    private static int numOfCores = -1;

    private static void parseCpuInfoLine(String str) {
        int indexOf;
        AppMethodBeat.i(189809);
        if (str.contains("aarch64") || str.contains("AArch64")) {
            mCpuArchitecture = 64;
        }
        if (str.startsWith("Processor")) {
            int indexOf2 = str.indexOf(58);
            if (indexOf2 > 1) {
                String substring = str.substring(indexOf2 + 1, str.length());
                mProcessorName = substring;
                mProcessorName = substring.trim();
            }
            AppMethodBeat.o(189809);
            return;
        }
        if (str.startsWith("CPU architecture")) {
            if (mCpuArchitecture == 0) {
                int indexOf3 = str.indexOf(58);
                if (indexOf3 > 1) {
                    String trim = str.substring(indexOf3 + 1, str.length()).trim();
                    if (trim.length() > 0 && trim.length() < 2) {
                        mCpuArchitecture = (int) Long.parseLong(trim);
                        AppMethodBeat.o(189809);
                        return;
                    } else if (trim.length() > 1) {
                        mCpuArchitecture = (int) Long.parseLong(trim.substring(0, 1));
                    }
                }
                AppMethodBeat.o(189809);
                return;
            }
        } else if (str.startsWith("Features")) {
            int indexOf4 = str.indexOf(58);
            if (indexOf4 > 1) {
                mFeature = str.substring(indexOf4 + 1, str.length()).trim();
            }
            AppMethodBeat.o(189809);
            return;
        } else if (str.startsWith("Hardware") && (indexOf = str.indexOf(58)) > 1) {
            mCpuHardware = str.substring(indexOf + 1, str.length()).trim().replace(" ", "");
            TPNativeLog.printLog(2, "hardware " + mCpuHardware);
            getCpuHWProductIndex(mCpuHardware);
        }
        AppMethodBeat.o(189809);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[SYNTHETIC, Splitter:B:14:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[Catch:{ IOException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC, Splitter:B:29:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[Catch:{ IOException -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getCpuInfo() {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.getCpuInfo():void");
    }

    private static int getCpuHWProducer(String str) {
        AppMethodBeat.i(189811);
        if (str.isEmpty()) {
            AppMethodBeat.o(189811);
            return -1;
        } else if (str.contains("Exynos") || str.contains("SMDK") || str.contains("S5L8900") || str.contains("S5PC100")) {
            AppMethodBeat.o(189811);
            return 3;
        } else if (str.contains("Kirin") || str.contains("K3V")) {
            AppMethodBeat.o(189811);
            return 2;
        } else if (str.contains("MSM") || str.contains("APQ") || str.contains("QSD") || str.contains("SDM") || str.contains("SM")) {
            AppMethodBeat.o(189811);
            return 0;
        } else if (str.contains("MT6")) {
            AppMethodBeat.o(189811);
            return 1;
        } else {
            AppMethodBeat.o(189811);
            return -1;
        }
    }

    public static int getCpuHWProducter(String str) {
        AppMethodBeat.i(189812);
        if (mCpuHWProducter < 0) {
            mCpuHWProducter = getCpuHWProducer(str);
        }
        int i2 = mCpuHWProducter;
        AppMethodBeat.o(189812);
        return i2;
    }

    public static int getCpuHWProductIndex(String str) {
        AppMethodBeat.i(189813);
        if (mCpuHWProducter < 0) {
            mCpuHWProducter = getCpuHWProducer(str);
        }
        if (mCpuHWProducter >= 0 && mCpuHWProductIdx < 0) {
            CharSequence[] charSequenceArr = cpuPerfList[mCpuHWProducter];
            int i2 = -1;
            for (int i3 = 0; i3 < charSequenceArr.length; i3++) {
                if (str.contains(charSequenceArr[i3])) {
                    if (-1 == i2) {
                        i2 = i3;
                    } else if (charSequenceArr[i3].length() > charSequenceArr[i2].length()) {
                        i2 = i3;
                    }
                }
            }
            mCpuHWProductIdx = i2;
        }
        int i4 = mCpuHWProductIdx;
        AppMethodBeat.o(189813);
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a A[SYNTHETIC, Splitter:B:28:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008f A[Catch:{ IOException -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1 A[SYNTHETIC, Splitter:B:37:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6 A[Catch:{ IOException -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8 A[SYNTHETIC, Splitter:B:46:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bd A[Catch:{ IOException -> 0x00c4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getMaxCpuFreq() {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.getMaxCpuFreq():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[SYNTHETIC, Splitter:B:32:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008b A[Catch:{ Throwable -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00aa A[SYNTHETIC, Splitter:B:42:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af A[Catch:{ Throwable -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce A[SYNTHETIC, Splitter:B:52:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d3 A[Catch:{ Throwable -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f2 A[SYNTHETIC, Splitter:B:62:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7 A[Catch:{ Throwable -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010f A[SYNTHETIC, Splitter:B:71:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0114 A[Catch:{ Throwable -> 0x011b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getCurrentCpuFreq() {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.getCurrentCpuFreq():long");
    }

    public static int getNumCores() {
        AppMethodBeat.i(189816);
        if (-1 != numOfCores) {
            int i2 = numOfCores;
            AppMethodBeat.o(189816);
            return i2;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                /* class com.tencent.thumbplayer.core.common.TPSystemInfo.AnonymousClass1CpuFilter */

                public boolean accept(File file) {
                    AppMethodBeat.i(189808);
                    boolean matches = Pattern.matches("cpu[0-9]", file.getName());
                    AppMethodBeat.o(189808);
                    return matches;
                }
            });
            if (listFiles == null) {
                numOfCores = 1;
                AppMethodBeat.o(189816);
                return 1;
            }
            numOfCores = listFiles.length;
            TPNativeLog.printLog(2, "core num " + numOfCores);
            int i3 = numOfCores;
            AppMethodBeat.o(189816);
            return i3;
        } catch (Exception e2) {
            TPNativeLog.printLog(4, e2.getMessage());
            numOfCores = 1;
            AppMethodBeat.o(189816);
            return 1;
        }
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public static String getCpuHarewareName() {
        AppMethodBeat.i(189817);
        if (TextUtils.isEmpty(mCpuHardware)) {
            getCpuInfo();
        }
        String str = mCpuHardware;
        AppMethodBeat.o(189817);
        return str;
    }

    public static int getCpuArchFromId(int i2) {
        switch (i2) {
            case 5:
                return 3;
            case 6:
                return 4;
            case 7:
                return 6;
            case 8:
            case 9:
            case 10:
                return 50;
            case 64:
                return 7;
            default:
                return 0;
        }
    }

    public static boolean isARMV5Whitelist() {
        AppMethodBeat.i(189818);
        if (getDeviceName().equals("XT882") || getDeviceName().equals("ME860") || getDeviceName().equals("MB860") || getDeviceName().equals("Lenovo P70") || getDeviceName().equals("Lenovo A60") || getDeviceName().equals("Lenovo A366t")) {
            AppMethodBeat.o(189818);
            return true;
        }
        AppMethodBeat.o(189818);
        return false;
    }

    public static int getCpuArchitecture() {
        AppMethodBeat.i(189819);
        if (-1 != cpuArch) {
            int i2 = cpuArch;
            AppMethodBeat.o(189819);
            return i2;
        }
        if (Build.CPU_ABI != null && (Build.CPU_ABI.contains("x86") || Build.CPU_ABI.contains("X86"))) {
            cpuArch = 1;
        } else if (Build.CPU_ABI == null || (!Build.CPU_ABI.contains("mips") && !Build.CPU_ABI.contains("Mips"))) {
            if (mCpuArchitecture == 0) {
                getCpuInfo();
            }
            TPNativeLog.printLog(2, "getCpuArchitecture mCpuArchitecture:" + mCpuArchitecture);
            if (!TextUtils.isEmpty(mCpuHardware) && mCpuHardware.contains("MSM8994")) {
                cpuArch = 7;
                AppMethodBeat.o(189819);
                return 7;
            } else if (isARMV5Whitelist()) {
                cpuArch = 3;
                AppMethodBeat.o(189819);
                return 3;
            } else if (!TextUtils.isEmpty(mProcessorName) && mProcessorName.contains("ARMv6")) {
                cpuArch = 4;
                AppMethodBeat.o(189819);
                return 4;
            } else if (!TextUtils.isEmpty(mProcessorName) && mProcessorName.contains("AArch64")) {
                cpuArch = 7;
                AppMethodBeat.o(189819);
                return 7;
            } else if (mCpuArchitecture != 7 || TextUtils.isEmpty(mFeature) || mFeature.contains("neon")) {
                cpuArch = getCpuArchFromId(mCpuArchitecture);
            } else {
                cpuArch = 4;
                AppMethodBeat.o(189819);
                return 4;
            }
        } else {
            cpuArch = 2;
        }
        int i3 = cpuArch;
        AppMethodBeat.o(189819);
        return i3;
    }

    private static boolean checkPermission(Context context, String str) {
        boolean z = true;
        AppMethodBeat.i(189820);
        if (!hasMarshmallow()) {
            AppMethodBeat.o(189820);
            return true;
        } else if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(189820);
            return false;
        } else {
            if ("android.permission.WRITE_SETTINGS".equals(str)) {
                z = Settings.System.canWrite(context);
            } else {
                try {
                    if (b.checkSelfPermission(context, str) != 0) {
                        z = false;
                    }
                } catch (Exception e2) {
                    z = false;
                }
            }
            AppMethodBeat.o(189820);
            return z;
        }
    }

    public static String getDeviceIMEI(Context context) {
        AppMethodBeat.i(189821);
        if (!TextUtils.isEmpty(deviceIMEI)) {
            String str = deviceIMEI;
            AppMethodBeat.o(189821);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(189821);
            return "";
        } else if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            deviceIMEI = "NONE";
            AppMethodBeat.o(189821);
            return "NONE";
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    deviceIMEI = deviceId;
                    if (TextUtils.isEmpty(deviceId)) {
                        deviceIMEI = "NONE";
                    }
                    String str2 = deviceIMEI;
                    AppMethodBeat.o(189821);
                    return str2;
                }
            } catch (Throwable th) {
                deviceIMEI = "NONE";
            }
            AppMethodBeat.o(189821);
            return "NONE";
        }
    }

    public static String getDeviceIMSI(Context context) {
        AppMethodBeat.i(189822);
        if (!TextUtils.isEmpty(deviceIMSI)) {
            String str = deviceIMSI;
            AppMethodBeat.o(189822);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(189822);
            return "";
        } else if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            deviceIMSI = "NONE";
            AppMethodBeat.o(189822);
            return "NONE";
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
                    AppMethodBeat.o(189822);
                    return str2;
                }
                AppMethodBeat.o(189822);
                return "";
            } catch (Throwable th) {
                AppMethodBeat.o(189822);
                return "";
            }
        }
    }

    public static String getDeviceID(Context context) {
        AppMethodBeat.i(189823);
        if (!TextUtils.isEmpty(deviceID)) {
            String str = deviceID;
            AppMethodBeat.o(189823);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(189823);
            return "";
        } else {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "android_id");
                deviceID = string;
                if (TextUtils.isEmpty(string)) {
                    deviceID = "NONE";
                }
            } catch (Throwable th) {
                deviceID = "NONE";
            }
            String str2 = deviceID;
            AppMethodBeat.o(189823);
            return str2;
        }
    }

    public static String getDeviceMacAddr(Context context) {
        AppMethodBeat.i(189824);
        if (!TextUtils.isEmpty(deviceMacAddr)) {
            String str = deviceMacAddr;
            AppMethodBeat.o(189824);
            return str;
        } else if (context == null) {
            AppMethodBeat.o(189824);
            return "";
        } else {
            String _getDeviceMacAddr = _getDeviceMacAddr(context);
            deviceMacAddr = _getDeviceMacAddr;
            if (TextUtils.isEmpty(_getDeviceMacAddr)) {
                deviceMacAddr = "NONE";
            }
            String str2 = deviceMacAddr;
            AppMethodBeat.o(189824);
            return str2;
        }
    }

    private static String _getDeviceMacAddr(Context context) {
        AppMethodBeat.i(189825);
        String str = "";
        if (hasMarshmallow()) {
            try {
                NetworkInterface byName = NetworkInterface.getByName(getWlanName());
                if (byName != null) {
                    byte[] hardwareAddress = byName.getHardwareAddress();
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                        if (hexString.length() == 1) {
                            hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
                        }
                        sb.append(hexString);
                        if (i2 != length - 1) {
                            sb.append(":");
                        }
                    }
                    str = sb.toString().toUpperCase();
                }
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
            }
        } else {
            str = getLowerMarshmallowDeviceMacAddr(context);
        }
        AppMethodBeat.o(189825);
        return str;
    }

    private static String getLowerMarshmallowDeviceMacAddr(Context context) {
        AppMethodBeat.i(189826);
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                AppMethodBeat.o(189826);
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                String macAddress = connectionInfo.getMacAddress();
                AppMethodBeat.o(189826);
                return macAddress;
            }
            AppMethodBeat.o(189826);
            return "";
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
        }
    }

    private static boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static String getWlanName() {
        String str;
        AppMethodBeat.i(189827);
        try {
            if (getWlanMethod == null) {
                getWlanMethod = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            }
            str = (String) getWlanMethod.invoke(null, "wifi.interface", "wlan0");
        } catch (Throwable th) {
            TPNativeLog.printLog(4, th.getMessage());
            str = "wlan0";
        }
        AppMethodBeat.o(189827);
        return str;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(189828);
        if (context == null) {
            AppMethodBeat.o(189828);
            return 0;
        } else if (mScreenWidth != 0) {
            int i2 = mScreenWidth;
            AppMethodBeat.o(189828);
            return i2;
        } else {
            try {
                mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
            } catch (Throwable th) {
                mScreenWidth = 0;
            }
            int i3 = mScreenWidth;
            AppMethodBeat.o(189828);
            return i3;
        }
    }

    public static int getScreenHeight(Context context) {
        AppMethodBeat.i(189829);
        if (context == null) {
            AppMethodBeat.o(189829);
            return 0;
        } else if (mScreenHeight != 0) {
            int i2 = mScreenHeight;
            AppMethodBeat.o(189829);
            return i2;
        } else {
            try {
                mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
            } catch (Throwable th) {
                mScreenHeight = 0;
            }
            int i3 = mScreenHeight;
            AppMethodBeat.o(189829);
            return i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[SYNTHETIC, Splitter:B:13:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeStringToFile(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = 189830(0x2e586, float:2.66008E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r0 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x002f }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x002f }
            boolean r1 = r2.exists()     // Catch:{ Throwable -> 0x002f }
            if (r1 != 0) goto L_0x001c
            boolean r1 = r2.createNewFile()     // Catch:{ Throwable -> 0x002f }
            if (r1 == 0) goto L_0x001c
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x001b:
            return
        L_0x001c:
            java.io.FileWriter r1 = new java.io.FileWriter
            r3 = 0
            r1.<init>(r2, r3)
            r1.write(r6)     // Catch:{ Throwable -> 0x003e }
            r1.flush()     // Catch:{ Throwable -> 0x003e }
            r1.close()     // Catch:{ Throwable -> 0x003e }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001b
        L_0x002f:
            r1 = move-exception
        L_0x0030:
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ IOException -> 0x0039 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001b
        L_0x0039:
            r0 = move-exception
        L_0x003a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x001b
        L_0x003e:
            r0 = move-exception
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.writeStringToFile(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC, Splitter:B:30:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String readStringFromFile(java.io.File r9) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.readStringFromFile(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A[SYNTHETIC, Splitter:B:14:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC, Splitter:B:21:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readSystemStat() {
        /*
            r0 = 0
            r5 = 189832(0x2e588, float:2.66011E-40)
            r4 = 4
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Throwable -> 0x0027, all -> 0x0038 }
            java.lang.String r2 = "/proc/stat"
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x0027, all -> 0x0038 }
            java.lang.String r0 = r1.readLine()     // Catch:{ Throwable -> 0x0051, all -> 0x004d }
            r1.close()     // Catch:{ Throwable -> 0x001e }
        L_0x001a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x001e:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r4, r1)
            goto L_0x001a
        L_0x0027:
            r1 = move-exception
            r1 = r0
        L_0x0029:
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ Throwable -> 0x002f }
            goto L_0x001a
        L_0x002f:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r4, r1)
            goto L_0x001a
        L_0x0038:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x003b:
            if (r3 == 0) goto L_0x0040
            r3.close()     // Catch:{ Throwable -> 0x0044 }
        L_0x0040:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r2
        L_0x0044:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.tencent.thumbplayer.core.common.TPNativeLog.printLog(r4, r0)
            goto L_0x0040
        L_0x004d:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x003b
        L_0x0051:
            r2 = move-exception
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPSystemInfo.readSystemStat():java.lang.String");
    }

    public static int getSystemCpuUsage(String str, String str2) {
        AppMethodBeat.i(189833);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(189833);
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
            TPNativeLog.printLog(4, th.getMessage());
            f2 = -1.0f;
        }
        int i2 = (int) f2;
        AppMethodBeat.o(189833);
        return i2;
    }

    public static long getSystemUptime(String[] strArr) {
        AppMethodBeat.i(189834);
        long j2 = 0;
        for (int i2 = 1; i2 < strArr.length; i2++) {
            if (4 != i2) {
                try {
                    j2 += Long.parseLong(strArr[i2]);
                } catch (Throwable th) {
                    AppMethodBeat.o(189834);
                    return -1;
                }
            }
        }
        AppMethodBeat.o(189834);
        return j2;
    }

    public static long getSystemIdleTime(String[] strArr) {
        AppMethodBeat.i(189835);
        try {
            long parseLong = Long.parseLong(strArr[4]);
            AppMethodBeat.o(189835);
            return parseLong;
        } catch (Throwable th) {
            AppMethodBeat.o(189835);
            return -1;
        }
    }

    public static int getOpenGLSupportVersion(Context context) {
        AppMethodBeat.i(189836);
        if (mOpenGLVersion == 0) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                if (activityManager == null) {
                    int i2 = mOpenGLVersion;
                    AppMethodBeat.o(189836);
                    return i2;
                }
                mOpenGLVersion = activityManager.getDeviceConfigurationInfo().reqGlEsVersion;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
            }
        }
        int i3 = mOpenGLVersion;
        AppMethodBeat.o(189836);
        return i3;
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean supportInDeviceDolbyAudioEffect() {
        boolean z;
        Exception e2;
        AppMethodBeat.i(189837);
        try {
            z = false;
            for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
                try {
                    if (descriptor.implementor.contains("Dolby Laboratories")) {
                        z = true;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    TPNativeLog.printLog(4, e2.getMessage());
                    AppMethodBeat.o(189837);
                    return z;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            TPNativeLog.printLog(4, e2.getMessage());
            AppMethodBeat.o(189837);
            return z;
        }
        AppMethodBeat.o(189837);
        return z;
    }

    public static synchronized void initAudioBestSettings(Context context) {
        synchronized (TPSystemInfo.class) {
            AppMethodBeat.i(189838);
            if (context == null || mAudioBestSampleRate > 0) {
                AppMethodBeat.o(189838);
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
                    String property2 = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
                    try {
                        mAudioBestSampleRate = Integer.parseInt(property);
                        mAudioBestFramesPerBust = Integer.parseInt(property2);
                        AppMethodBeat.o(189838);
                    } catch (NumberFormatException e2) {
                        TPNativeLog.printLog(4, e2.getMessage());
                    }
                }
                AppMethodBeat.o(189838);
            }
        }
    }

    public static int getBestAudioSampleRate() {
        return mAudioBestSampleRate;
    }

    public static int getBestAudioFramesPerBust() {
        return mAudioBestFramesPerBust;
    }
}
