package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import com.facebook.internal.ServerProtocol;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static final String PATCH_PROCESS_NAME = ":patch";
    private static final String SAFEMODE_COUNT_REC_PREFIX = "safemode_count_rec_";
    private static final String TAG = "Tinker.TinkerInternals";
    private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
    private static final boolean VM_IS_JIT = isVmJitInternal();
    private static String currentInstructionSet = null;
    private static Boolean isARKHotRunning = null;
    private static Boolean isPatchProcess = null;
    private static String processName = null;
    private static String tinkerID = null;

    public static boolean isVmArt() {
        return VM_IS_ART || Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isVmJit() {
        return VM_IS_JIT && Build.VERSION.SDK_INT < 24;
    }

    public static boolean isArkHotRuning() {
        if (isARKHotRunning != null) {
            return isARKHotRunning.booleanValue();
        }
        isARKHotRunning = Boolean.FALSE;
        try {
            Method declaredMethod = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("isRunningInArk", new Class[0]);
            declaredMethod.setAccessible(true);
            isARKHotRunning = (Boolean) declaredMethod.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e2) {
            ShareTinkerLog.i(TAG, "class not found exception", new Object[0]);
        } catch (NoSuchMethodException e3) {
            ShareTinkerLog.i(TAG, "no such method exception", new Object[0]);
        } catch (SecurityException e4) {
            ShareTinkerLog.i(TAG, "security exception", new Object[0]);
        } catch (IllegalAccessException e5) {
            ShareTinkerLog.i(TAG, "illegal access exception", new Object[0]);
        } catch (InvocationTargetException e6) {
            ShareTinkerLog.i(TAG, "invocation target exception", new Object[0]);
        } catch (IllegalArgumentException e7) {
            ShareTinkerLog.i(TAG, "illegal argument exception", new Object[0]);
        }
        return isARKHotRunning.booleanValue();
    }

    public static boolean isAfterAndroidO() {
        return Build.VERSION.SDK_INT > 25;
    }

    public static String getCurrentInstructionSet() {
        if (currentInstructionSet != null) {
            return currentInstructionSet;
        }
        currentInstructionSet = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        ShareTinkerLog.d(TAG, "getCurrentInstructionSet:" + currentInstructionSet, new Object[0]);
        return currentInstructionSet;
    }

    public static boolean isSystemOTA(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            ShareTinkerLog.d(TAG, "fingerprint empty:" + str + ",current:" + str2, new Object[0]);
            return false;
        } else if (str.equals(str2)) {
            ShareTinkerLog.d(TAG, "same fingerprint:".concat(String.valueOf(str2)), new Object[0]);
            return false;
        } else {
            ShareTinkerLog.d(TAG, "system OTA,fingerprint not equal:" + str + "," + str2, new Object[0]);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i2) {
        String str;
        if (!shareDexDiffPatchInfo.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
            return null;
        }
        if (i2 != 1) {
            str = "classes" + i2 + ShareConstants.DEX_SUFFIX;
        } else {
            str = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.destMd5InDvm, shareDexDiffPatchInfo.destMd5InArt, shareDexDiffPatchInfo.dexDiffMd5, shareDexDiffPatchInfo.oldDexCrC, shareDexDiffPatchInfo.newOrPatchedDexCrC, shareDexDiffPatchInfo.dexMode);
    }

    public static boolean isNullOrNil(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int checkTinkerPackage(Context context, int i2, File file, ShareSecurityCheck shareSecurityCheck) {
        int checkSignatureAndTinkerID = checkSignatureAndTinkerID(context, file, shareSecurityCheck);
        if (checkSignatureAndTinkerID == 0) {
            return checkPackageAndTinkerFlag(shareSecurityCheck, i2);
        }
        return checkSignatureAndTinkerID;
    }

    public static int checkSignatureAndTinkerID(Context context, File file, ShareSecurityCheck shareSecurityCheck) {
        if (!shareSecurityCheck.verifyPatchMetaSignature(file)) {
            return -1;
        }
        String manifestTinkerID = getManifestTinkerID(context);
        if (manifestTinkerID == null) {
            return -5;
        }
        HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
        if (packagePropertiesIfPresent == null) {
            return -2;
        }
        String str = packagePropertiesIfPresent.get(ShareConstants.TINKER_ID);
        if (str == null) {
            return -6;
        }
        if (manifestTinkerID.equals(str)) {
            return 0;
        }
        ShareTinkerLog.e(TAG, "tinkerId is not equal, base is " + manifestTinkerID + ", but patch is " + str, new Object[0]);
        return -7;
    }

    public static int checkPackageAndTinkerFlag(ShareSecurityCheck shareSecurityCheck, int i2) {
        if (isTinkerEnabledAll(i2)) {
            return 0;
        }
        HashMap<String, String> metaContentMap = shareSecurityCheck.getMetaContentMap();
        if (!isTinkerEnabledForDex(i2) && metaContentMap.containsKey(ShareConstants.DEX_META_FILE)) {
            return -9;
        }
        if (isTinkerEnabledForNativeLib(i2) || !metaContentMap.containsKey(ShareConstants.SO_META_FILE)) {
            return (isTinkerEnabledForResource(i2) || !metaContentMap.containsKey(ShareConstants.RES_META_FILE)) ? 0 : -9;
        }
        return -9;
    }

    public static Properties fastGetPatchPackageMeta(File file) {
        ZipFile zipFile;
        ZipFile zipFile2;
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        if (file == null || !file.isFile() || file.length() == 0) {
            ShareTinkerLog.e(TAG, "patchFile is illegal", new Object[0]);
            return null;
        }
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.PACKAGE_META_FILE);
                if (entry == null) {
                    ShareTinkerLog.e(TAG, "patch meta entry not found", new Object[0]);
                    SharePatchFileUtil.closeZip(zipFile2);
                    return null;
                }
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.closeQuietly(inputStream);
                        SharePatchFileUtil.closeZip(zipFile2);
                        return properties;
                    } catch (Throwable th3) {
                        th2 = th3;
                        SharePatchFileUtil.closeQuietly(inputStream);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    inputStream = null;
                    SharePatchFileUtil.closeQuietly(inputStream);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    ShareTinkerLog.e(TAG, "fastGetPatchPackageMeta exception:" + e.getMessage(), new Object[0]);
                    SharePatchFileUtil.closeZip(zipFile);
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile2 = zipFile;
                    SharePatchFileUtil.closeZip(zipFile2);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                SharePatchFileUtil.closeZip(zipFile2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            ShareTinkerLog.e(TAG, "fastGetPatchPackageMeta exception:" + e.getMessage(), new Object[0]);
            SharePatchFileUtil.closeZip(zipFile);
            return null;
        } catch (Throwable th7) {
            th = th7;
            zipFile2 = null;
            SharePatchFileUtil.closeZip(zipFile2);
            throw th;
        }
    }

    public static String getManifestTinkerID(Context context) {
        if (tinkerID != null) {
            return tinkerID;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(ShareConstants.TINKER_ID);
            if (obj != null) {
                tinkerID = String.valueOf(obj);
            } else {
                tinkerID = null;
            }
            return tinkerID;
        } catch (Exception e2) {
            ShareTinkerLog.e(TAG, "getManifestTinkerID exception:" + e2.getMessage(), new Object[0]);
            return null;
        }
    }

    public static boolean isTinkerEnabledForDex(int i2) {
        return (i2 & 1) != 0;
    }

    public static boolean isTinkerEnabledForNativeLib(int i2) {
        return (i2 & 2) != 0;
    }

    public static boolean isTinkerEnabledForResource(int i2) {
        return (i2 & 4) != 0;
    }

    public static boolean isTinkerEnabledForArkHot(int i2) {
        return (i2 & 8) != 0;
    }

    public static String getTypeString(int i2) {
        switch (i2) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return ShareConstants.DEX_PATH;
            case 4:
                return "dex_opt";
            case 5:
                return ShareConstants.SO_PATH;
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4);
        sharedPreferences.edit().putBoolean(getTinkerSwitchSPKey(context), false).commit();
    }

    public static boolean isTinkerEnableWithSharedPreferences(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).getBoolean(getTinkerSwitchSPKey(context), true);
    }

    private static String getTinkerSwitchSPKey(Context context) {
        String manifestTinkerID = getManifestTinkerID(context);
        if (isNullOrNil(manifestTinkerID)) {
            manifestTinkerID = "@@";
        }
        return "tinker_enable_1.9.14.10_".concat(String.valueOf(manifestTinkerID));
    }

    public static int getSafeModeCount(Context context) {
        DataInputStream dataInputStream;
        Throwable th;
        String concat = SAFEMODE_COUNT_REC_PREFIX.concat(String.valueOf(getProcessName(context)));
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(new File(SharePatchFileUtil.getPatchDirectory(context), concat)));
            try {
                String readUTF = dataInputStream.readUTF();
                if (!"safe_mode_count_1.9.14.10".equals(readUTF)) {
                    ShareTinkerLog.w(TAG, "getSafeModeCount: key is not equal, expt: %s, actul: %s, return 0 instead.", "safe_mode_count_1.9.14.10", readUTF);
                    SharePatchFileUtil.closeQuietly(dataInputStream);
                    return 0;
                }
                int readInt = dataInputStream.readInt();
                ShareTinkerLog.i(TAG, "getSafeModeCount: count: %s", Integer.valueOf(readInt));
                SharePatchFileUtil.closeQuietly(dataInputStream);
                return readInt;
            } catch (Throwable th2) {
                th = th2;
                SharePatchFileUtil.closeQuietly(dataInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            SharePatchFileUtil.closeQuietly(dataInputStream);
            throw th;
        }
    }

    public static void setSafeModeCount(Context context, int i2) {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataOutputStream dataOutputStream2;
        String concat = SAFEMODE_COUNT_REC_PREFIX.concat(String.valueOf(getProcessName(context)));
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), concat);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeUTF("safe_mode_count_1.9.14.10");
                dataOutputStream2.writeInt(i2);
                ShareTinkerLog.i(TAG, "setSafeModeCount: count: %s", Integer.valueOf(i2));
                SharePatchFileUtil.closeQuietly(dataOutputStream2);
            } catch (Throwable th2) {
                try {
                    ShareTinkerLog.w(TAG, "setSafeModeCount: recFileName:" + concat + " failed, return 0 instead.", new Object[0]);
                    SharePatchFileUtil.closeQuietly(dataOutputStream2);
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = dataOutputStream2;
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            SharePatchFileUtil.closeQuietly(dataOutputStream);
            throw th;
        }
    }

    public static boolean isTinkerEnabled(int i2) {
        return i2 != 0;
    }

    public static boolean isTinkerEnabledAll(int i2) {
        return i2 == 15;
    }

    public static boolean isInMainProcess(Context context) {
        String str = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        }
        if (isNullOrNil(str)) {
            str = context.getPackageName();
        }
        String processName2 = getProcessName(context);
        if (processName2 == null || processName2.length() == 0) {
            processName2 = "";
        }
        return str.equals(processName2);
    }

    public static boolean isInPatchProcess(Context context) {
        if (isPatchProcess != null) {
            return isPatchProcess.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(getProcessName(context).endsWith(PATCH_PROCESS_NAME));
        isPatchProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static String getCurrentOatMode(Context context, String str) {
        if (!str.equals(ShareConstants.CHANING_DEX_OPTIMIZE_PATH)) {
            return str;
        }
        if (isInMainProcess(context)) {
            return "odex";
        }
        return ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH;
    }

    public static void killAllOtherProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static void killProcessExceptMain(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.uid == Process.myUid() && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static String getProcessName(Context context) {
        if (processName != null) {
            return processName;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3 A[SYNTHETIC, Splitter:B:45:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd A[SYNTHETIC, Splitter:B:51:0x00cd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessNameInternal(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.getProcessNameInternal(android.content.Context):java.lang.String");
    }

    private static boolean isVmArt(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            return parseInt > 2 || (parseInt == 2 && Integer.parseInt(matcher.group(2)) > 0);
        } catch (NumberFormatException e2) {
            return false;
        }
    }

    private static boolean isVmJitInternal() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            String str = (String) declaredMethod.invoke(null, "dalvik.vm.usejit");
            String str2 = (String) declaredMethod.invoke(null, "dalvik.vm.usejitprofiles");
            if (!isNullOrNil(str) && isNullOrNil(str2) && str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                return true;
            }
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "isVmJitInternal ex:".concat(String.valueOf(th)), new Object[0]);
        }
        return false;
    }

    public static String getExceptionCauseString(Throwable th) {
        if (th == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                } else {
                    th.printStackTrace(printStream);
                    return toVisualString(byteArrayOutputStream.toString());
                }
            } finally {
                SharePatchFileUtil.closeQuietly(printStream);
            }
        }
    }

    public static String toVisualString(String str) {
        boolean z;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i2] > 127) {
                charArray[i2] = 0;
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return new String(charArray, 0, i2);
        }
        return str;
    }
}
