package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class APPluginInstallerAndUpdater {
    private static final int BUFFER_LENGTH = 8192;
    private static final int INSTALL_ERR_LOSTZIPFILE = -2;
    private static final int INSTALL_ERR_MD5CHECKFAIL = -3;
    static final int INSTALL_ERR_SYSTEM = -1;
    static final int INSTALL_FROM_ASSETS = 1;
    static final int INSTALL_FROM_LOCAL = 2;
    private static final int INSTALL_SUCC = 0;
    private static final String TAG = "APPluginInstallerAndUpdater";
    static Map<String, File> sInstallPathMap = new ConcurrentHashMap();
    static Map<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(193119);
        AppMethodBeat.o(193119);
    }

    public static int installFromLocal(Context context) {
        int i2;
        AppMethodBeat.i(193108);
        APLog.d(TAG, "Calling into installFromLocal " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginUtils.deleteBKPlugin(context);
        APPluginUtils.copyDirect(context, APPluginConfig.getPluginUpdatePath(context), APPluginConfig.getPluginBackUpPath(context));
        try {
            File pluginUpdatePath = APPluginConfig.getPluginUpdatePath(context);
            i2 = installFromLocalByPath(context, pluginUpdatePath);
            APLog.d(TAG, "Calling into installFromLocal, installFromLocalByPath result state = " + i2 + " install src = " + pluginUpdatePath);
        } catch (Exception e2) {
            i2 = -1;
        }
        if (i2 != 0) {
            unInstallPlugin(context);
            i2 = installFromLocalByPath(context, APPluginConfig.getPluginBackUpPath(context));
            if (i2 != 0) {
                unInstallPlugin(context);
            }
        } else {
            APPluginUtils.deleteUpdatePlugin(context);
        }
        APLog.i("APPluginUtils", "installFromLocal state:".concat(String.valueOf(i2)));
        AppMethodBeat.o(193108);
        return i2;
    }

    public static String getInstallPathString(Context context, String str) {
        AppMethodBeat.i(193109);
        String str2 = "";
        try {
            File installPath = getInstallPath(context, str);
            if (installPath != null) {
                str2 = installPath.getCanonicalPath();
            }
        } catch (IOException e2) {
        }
        AppMethodBeat.o(193109);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x010c A[SYNTHETIC, Splitter:B:47:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111 A[Catch:{ IOException -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0116 A[Catch:{ IOException -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0139 A[SYNTHETIC, Splitter:B:63:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013e A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0143 A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0063 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int installFromLocalByPath(android.content.Context r18, java.io.File r19) {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginInstallerAndUpdater.installFromLocalByPath(android.content.Context, java.io.File):int");
    }

    public static boolean isNeedUpdateFromLocal(Context context) {
        AppMethodBeat.i(193111);
        APLog.d(TAG, "isNeedUpdateFromLocal");
        File pluginUpdatePath = APPluginConfig.getPluginUpdatePath(context);
        try {
            File file = new File(pluginUpdatePath, APPluginConfig.SIGN_FILE_NAME);
            if (!file.exists()) {
                APLog.d(TAG, "isNeedUpdateFromLocal, sign file not exist, return false!");
                AppMethodBeat.o(193111);
                return false;
            }
            APLog.d(TAG, "isNeedUpdateFromLocal, sign file exist!");
            HashMap hashMap = new HashMap();
            APPluginUtils.readSingInfoItems(hashMap, file);
            File[] listFiles = pluginUpdatePath.listFiles();
            if (listFiles == null) {
                APLog.d(TAG, "isNeedUpdateFromLocal, cannot get local file list, return false!");
                AppMethodBeat.o(193111);
                return false;
            } else if (listFiles.length == 0) {
                APLog.d(TAG, "isNeedUpdateFromLocal, empty local file list, return false!");
                AppMethodBeat.o(193111);
                return false;
            } else {
                boolean z = false;
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = ".concat(String.valueOf(name)));
                    if (name.startsWith("MidasCore")) {
                        z = true;
                    }
                    if (!name.endsWith(".apk")) {
                        APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + ", not apk file, continue!");
                    } else {
                        boolean checkFileMD5 = APPluginUtils.checkFileMD5(file2.getCanonicalPath(), ((APSignIniItem) hashMap.get(name.split("\\_")[0])).md5);
                        APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + " valid = " + checkFileMD5);
                        if (!checkFileMD5) {
                            APPluginUtils.clearDirContent(pluginUpdatePath);
                            AppMethodBeat.o(193111);
                            return false;
                        }
                        hashMap.remove(name.split("\\_")[0]);
                    }
                }
                if (hashMap.size() > 0) {
                    APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size = " + hashMap.size());
                    File pluginPath = APPluginConfig.getPluginPath(context);
                    for (APSignIniItem aPSignIniItem : hashMap.values()) {
                        APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName);
                        if (!new File(pluginPath, aPSignIniItem.fullName).exists()) {
                            APLog.e(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " missing in midasplugins!");
                            APPluginUtils.clearDirContent(pluginUpdatePath);
                            AppMethodBeat.o(193111);
                            return false;
                        }
                        APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " exist in midasplugins!");
                    }
                } else {
                    APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size is 0");
                }
                if (!z) {
                    APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == false!");
                    AppMethodBeat.o(193111);
                    return false;
                }
                APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == true!");
                APLog.e(TAG, "isNeedUpdateFromLocal, return true!");
                AppMethodBeat.o(193111);
                return true;
            }
        } catch (Exception e2) {
            APLog.e(TAG, "isNeedUpdateFromLocal, got exception = ".concat(String.valueOf(e2)));
            AppMethodBeat.o(193111);
            return false;
        }
    }

    public static File getInstallPath(Context context, String str) {
        AppMethodBeat.i(193112);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(193112);
            return null;
        }
        File file = sInstallPathMap.get(str);
        if (file == null) {
            File pluginPath = APPluginConfig.getPluginPath(context);
            if (pluginPath == null) {
                AppMethodBeat.o(193112);
                return null;
            }
            File[] listFiles = pluginPath.listFiles();
            for (File file2 : listFiles) {
                if (file2.getName().startsWith(str)) {
                    sInstallPathMap.put(str, file2);
                    AppMethodBeat.o(193112);
                    return file2;
                }
            }
        }
        AppMethodBeat.o(193112);
        return file;
    }

    public static int installPlugin(Context context, int i2) {
        AppMethodBeat.i(193113);
        int i3 = 0;
        APLog.d(TAG, "installPlugin from = ".concat(String.valueOf(i2)));
        try {
            unInstallPlugin(context);
            if (i2 == 1) {
                i3 = installFromAssets(context);
            } else if (i2 == 2) {
                i3 = installFromData(context);
            }
            if (i3 != 0) {
                unInstallPlugin(context);
            }
        } catch (Exception e2) {
            APLog.w("APPluginUtils", "installPlugin Exception:" + e2.toString());
            APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(e2);
        } catch (Throwable th) {
            AppMethodBeat.o(193113);
            throw th;
        }
        AppMethodBeat.o(193113);
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[SYNTHETIC, Splitter:B:14:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC, Splitter:B:20:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int installFromData(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginInstallerAndUpdater.installFromData(android.content.Context):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0 A[SYNTHETIC, Splitter:B:37:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5 A[Catch:{ IOException -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fc A[SYNTHETIC, Splitter:B:52:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0101 A[Catch:{ IOException -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0115 A[SYNTHETIC, Splitter:B:63:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0131 A[SYNTHETIC, Splitter:B:72:0x0131] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int installFromZipStream(android.content.Context r11, java.io.InputStream r12) {
        /*
        // Method dump skipped, instructions count: 351
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginInstallerAndUpdater.installFromZipStream(android.content.Context, java.io.InputStream):int");
    }

    private static int installFromAssets(Context context) {
        AppMethodBeat.i(193116);
        APPluginUtils.copyEmtpyResAPKFromAssets(context);
        if (TextUtils.isEmpty("MidasPay.zip")) {
            AppMethodBeat.o(193116);
            return -2;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("MidasPay.zip");
            installFromZipStream(context, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(193116);
            return 0;
        } catch (IOException e3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(193116);
            return -1;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(193116);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isNeedUpdateFromAssets(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginInstallerAndUpdater.isNeedUpdateFromAssets(android.content.Context):int");
    }

    public static void unInstallPlugin(Context context) {
        AppMethodBeat.i(193118);
        APLog.d(TAG, "unInstallPlugin " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginUtils.deletePlugin(context);
        APPluginUtils.deleteDex(context);
        APPluginUtils.deleteLibs(context);
        sInstallPathMap.clear();
        sPackageInfoMap.clear();
        APPluginStatic.release();
        APPluginConfig.libExtend++;
        AppMethodBeat.o(193118);
    }
}
