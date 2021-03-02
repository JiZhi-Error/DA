package com.tencent.midas.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class APPluginUtils {
    private static final int BUFFER_LENGTH = 8192;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String TAG = "PluginUtils";
    private static Object copyFileObject = new Object();
    private static ArrayList<String> emptyResList = null;
    private static String[] fileList = null;
    static String installErrMsg = null;

    static {
        AppMethodBeat.i(193162);
        AppMethodBeat.o(193162);
    }

    public static String getInitErrorMsg() {
        return installErrMsg;
    }

    static void readSingInfoItems(HashMap<String, APSignIniItem> hashMap, File file) {
        AppMethodBeat.i(193123);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getCanonicalPath()));
            APMidasRSATools aPMidasRSATools = new APMidasRSATools();
            String readLine = bufferedReader.readLine();
            while (readLine != null && !TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split("\\:");
                String str = split[0];
                String deCodeKey = aPMidasRSATools.deCodeKey(split[1]);
                String substring = deCodeKey.substring(deCodeKey.length() - 32);
                String str2 = str.split("\\_")[0];
                APSignIniItem aPSignIniItem = new APSignIniItem();
                aPSignIniItem.name = str2;
                aPSignIniItem.md5 = substring;
                aPSignIniItem.fullName = split[0];
                hashMap.put(str2, aPSignIniItem);
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            AppMethodBeat.o(193123);
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(193123);
        } catch (IOException e3) {
            AppMethodBeat.o(193123);
        }
    }

    static void readSingInfo(HashMap<String, String> hashMap, File file) {
        AppMethodBeat.i(193124);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getCanonicalPath()));
            APMidasRSATools aPMidasRSATools = new APMidasRSATools();
            String readLine = bufferedReader.readLine();
            while (readLine != null && !TextUtils.isEmpty(readLine)) {
                String[] split = readLine.split("\\:");
                String str = split[0];
                String deCodeKey = aPMidasRSATools.deCodeKey(split[1]);
                hashMap.put(str.split("\\_")[0], deCodeKey.substring(deCodeKey.length() - 32));
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            AppMethodBeat.o(193124);
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(193124);
        } catch (IOException e3) {
            AppMethodBeat.o(193124);
        }
    }

    public static String getInstallPathString(Context context, String str) {
        AppMethodBeat.i(193125);
        String installPathString = APPluginInstallerAndUpdater.getInstallPathString(context, str);
        AppMethodBeat.o(193125);
        return installPathString;
    }

    public static File getLibPath(Context context) {
        AppMethodBeat.i(193126);
        File libPath = APPluginConfig.getLibPath(context);
        AppMethodBeat.o(193126);
        return libPath;
    }

    public static void unInstallPlugin(Context context) {
        AppMethodBeat.i(193127);
        APLog.d(TAG, "unInstallPlugin " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginInstallerAndUpdater.unInstallPlugin(context);
        AppMethodBeat.o(193127);
    }

    public static File getInstallPath(Context context, String str) {
        AppMethodBeat.i(193128);
        File installPath = APPluginInstallerAndUpdater.getInstallPath(context, str);
        AppMethodBeat.o(193128);
        return installPath;
    }

    public static void clearDirContent(File file) {
        AppMethodBeat.i(193129);
        if (file == null || (!file.exists() || !file.isDirectory())) {
            APLog.e(TAG, "call clear dir content, but parameter error!");
            AppMethodBeat.o(193129);
            return;
        }
        APLog.d(TAG, "About to clear dir, path = " + file.getAbsolutePath());
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            AppMethodBeat.o(193129);
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
        }
        AppMethodBeat.o(193129);
    }

    public static void deleteFiles(File file) {
        AppMethodBeat.i(193130);
        if (file == null) {
            AppMethodBeat.o(193130);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(193130);
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
            }
            file.delete();
            AppMethodBeat.o(193130);
        } else {
            file.delete();
            AppMethodBeat.o(193130);
        }
    }

    static void deleteBKPlugin(Context context) {
        AppMethodBeat.i(193131);
        APLog.i("APPluginUtils", "deleteUpdatePlugin");
        deleteFiles(APPluginConfig.getPluginBackUpPath(context));
        AppMethodBeat.o(193131);
    }

    public static void deleteUpdatePlugin(Context context) {
        AppMethodBeat.i(193132);
        APLog.d(TAG, "Calling into deleteUpdatePlugin " + Thread.currentThread().getStackTrace()[3].toString());
        deleteFiles(APPluginConfig.getPluginUpdatePath(context));
        AppMethodBeat.o(193132);
    }

    public static void deletePlugin(Context context) {
        AppMethodBeat.i(193133);
        APLog.i("APPluginUtils", "deletePlugin");
        deleteFiles(APPluginConfig.getPluginPath(context));
        AppMethodBeat.o(193133);
    }

    public static void deleteDex(Context context) {
        AppMethodBeat.i(193134);
        APLog.i("APPluginUtils", "deleteDex");
        deleteFiles(APPluginConfig.getOptimizedDexPath(context));
        AppMethodBeat.o(193134);
    }

    public static void deleteLibs(Context context) {
        AppMethodBeat.i(193135);
        APLog.i("APPluginUtils", "deleteLibs");
        deleteFiles(APPluginConfig.getLibPath(context));
        AppMethodBeat.o(193135);
    }

    public static void release() {
        AppMethodBeat.i(193136);
        APPluginInstallerAndUpdater.sInstallPathMap.clear();
        APPluginInstallerAndUpdater.sPackageInfoMap.clear();
        AppMethodBeat.o(193136);
    }

    public static File getDataZipFile(Context context) {
        AppMethodBeat.i(193137);
        String path = APMidasPayAPI.getPath();
        if (!TextUtils.isEmpty(path)) {
            APLog.i("APPluginUtils", "getDataZipFile sPath:".concat(String.valueOf(path)));
            File file = new File(path);
            if (file.getName().startsWith("MidasPay") && file.getName().endsWith(".zip")) {
                AppMethodBeat.o(193137);
                return file;
            }
        }
        AppMethodBeat.o(193137);
        return null;
    }

    static int getAssetsVersionCode(Context context) {
        AppMethodBeat.i(193138);
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("MidasPay.zip");
            int zipVersionCodeWtihStream = getZipVersionCodeWtihStream(context, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(193138);
            return zipVersionCodeWtihStream;
        } catch (Exception e3) {
            installErrMsg = getFullExceptionStacktrace(e3);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            APLog.i("assets 目录下内核版本号：", "versionCode:0");
            AppMethodBeat.o(193138);
            return 0;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(193138);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0 A[SYNTHETIC, Splitter:B:26:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[SYNTHETIC, Splitter:B:32:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getZipVersionCodeWtihStream(android.content.Context r8, java.io.InputStream r9) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.getZipVersionCodeWtihStream(android.content.Context, java.io.InputStream):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[SYNTHETIC, Splitter:B:13:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047 A[SYNTHETIC, Splitter:B:19:0x0047] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int getZipVersionCodeWtihFileName(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = 193140(0x2f274, float:2.70647E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.lang.String r0 = "getAssetsVersionCodeWtihFileName"
            java.lang.String r1 = "sUnzipMidasPayFile:"
            java.lang.String r2 = java.lang.String.valueOf(r5)
            java.lang.String r1 = r1.concat(r2)
            com.tencent.midas.comm.APLog.i(r0, r1)
            r2 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0028, all -> 0x0043 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0028, all -> 0x0043 }
            int r0 = getZipVersionCodeWtihStream(r4, r1)     // Catch:{ Exception -> 0x0056 }
            r1.close()     // Catch:{ IOException -> 0x004e }
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0027:
            return r0
        L_0x0028:
            r0 = move-exception
            r1 = r2
        L_0x002a:
            java.lang.String r0 = getFullExceptionStacktrace(r0)     // Catch:{ all -> 0x0054 }
            com.tencent.midas.plugin.APPluginUtils.installErrMsg = r0     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0035:
            java.lang.String r0 = "special data direct"
            java.lang.String r1 = "versionCode:0"
            com.tencent.midas.comm.APLog.i(r0, r1)
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0027
        L_0x0043:
            r0 = move-exception
            r1 = r2
        L_0x0045:
            if (r1 == 0) goto L_0x004a
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x004a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x004e:
            r1 = move-exception
            goto L_0x0024
        L_0x0050:
            r0 = move-exception
            goto L_0x0035
        L_0x0052:
            r1 = move-exception
            goto L_0x004a
        L_0x0054:
            r0 = move-exception
            goto L_0x0045
        L_0x0056:
            r0 = move-exception
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.getZipVersionCodeWtihFileName(android.content.Context, java.lang.String):int");
    }

    private static String[] getAssetFileList(Context context) {
        AppMethodBeat.i(193141);
        try {
            if (fileList == null) {
                long currentTimeMillis = System.currentTimeMillis();
                fileList = context.getAssets().list("");
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS, currentTimeMillis);
            }
        } catch (IOException e2) {
            APLog.w("APPLuginUtils", "getPluginNameFromAssets e:" + e2.getMessage());
        }
        String[] strArr = fileList;
        AppMethodBeat.o(193141);
        return strArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0134 A[SYNTHETIC, Splitter:B:44:0x0134] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0139 A[Catch:{ IOException -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0180 A[SYNTHETIC, Splitter:B:69:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0185 A[Catch:{ IOException -> 0x0198 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0140 A[EDGE_INSN: B:88:0x0140->B:50:0x0140 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int extractLibs(java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.extractLibs(java.lang.String, java.lang.String):int");
    }

    public static String getMidasCoreVersionName(Context context) {
        String str;
        String str2;
        AppMethodBeat.i(193143);
        File pluginPath = APPluginConfig.getPluginPath(context);
        if (pluginPath != null) {
            File[] listFiles = pluginPath.listFiles();
            int i2 = 0;
            while (true) {
                if (i2 >= listFiles.length) {
                    break;
                }
                File file = listFiles[i2];
                if (file.getName().startsWith("MidasCore")) {
                    try {
                        str = file.getCanonicalPath();
                        break;
                    } catch (IOException e2) {
                        str = "";
                    }
                } else {
                    i2++;
                }
            }
        }
        str = "";
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
        } else {
            str2 = "";
        }
        AppMethodBeat.o(193143);
        return str2;
    }

    public static ArrayList<String> getMidasEmptyPaht(Context context) {
        AppMethodBeat.i(193144);
        if (emptyResList == null) {
            emptyResList = new ArrayList<>();
            File pluginEmptyResPath = APPluginConfig.getPluginEmptyResPath(context);
            if (pluginEmptyResPath != null) {
                File[] listFiles = pluginEmptyResPath.listFiles();
                for (File file : listFiles) {
                    if (file.getName().startsWith("MidasEmptyRes") && file.getName().endsWith(".apk")) {
                        try {
                            emptyResList.add(file.getCanonicalPath());
                        } catch (IOException e2) {
                        }
                    }
                }
            }
        }
        ArrayList<String> arrayList = emptyResList;
        AppMethodBeat.o(193144);
        return arrayList;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.i(193145);
        PackageManager packageManager = context.getPackageManager();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(193145);
            return null;
        }
        PackageInfo packageInfo = APPluginInstallerAndUpdater.sPackageInfoMap.get(str);
        if (packageInfo == null && (packageInfo = packageManager.getPackageArchiveInfo(str, 128)) != null) {
            APPluginInstallerAndUpdater.sPackageInfoMap.put(str, packageInfo);
        }
        AppMethodBeat.o(193145);
        return packageInfo;
    }

    public static String getExceptionInfo(Throwable th) {
        AppMethodBeat.i(193146);
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        String stringBuffer = stringWriter.getBuffer().toString();
        AppMethodBeat.o(193146);
        return stringBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[SYNTHETIC, Splitter:B:14:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[Catch:{ IOException -> 0x0033 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFullExceptionStacktrace(java.lang.Throwable r5) {
        /*
            r2 = 0
            r4 = 193147(0x2f27b, float:2.70657E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.io.StringWriter r3 = new java.io.StringWriter     // Catch:{ all -> 0x0022 }
            r3.<init>()     // Catch:{ all -> 0x0022 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x0035 }
            r1.<init>(r3)     // Catch:{ all -> 0x0035 }
            r5.printStackTrace(r1)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0038 }
            r3.close()     // Catch:{ IOException -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x001e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        L_0x0022:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x0025:
            if (r3 == 0) goto L_0x002a
            r3.close()     // Catch:{ IOException -> 0x0033 }
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x002f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0033:
            r1 = move-exception
            goto L_0x002f
        L_0x0035:
            r0 = move-exception
            r1 = r2
            goto L_0x0025
        L_0x0038:
            r0 = move-exception
            goto L_0x0025
        L_0x003a:
            r1 = move-exception
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(java.lang.Throwable):java.lang.String");
    }

    private static boolean isHasBSL() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(193148);
        try {
            Class.forName("com.tencent.theme.SkinEngine").getMethod("getInstances", new Class[0]);
            z = true;
        } catch (Exception e2) {
            APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e2.toString());
            z = false;
        }
        if (!z) {
            try {
                Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
            } catch (Exception e3) {
                APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e3.toString());
                z2 = false;
            }
        } else {
            z2 = z;
        }
        AppMethodBeat.o(193148);
        return z2;
    }

    static void copyEmtpyResAPKFromAssets(Context context) {
        AppMethodBeat.i(193149);
        if (!isHasBSL()) {
            AppMethodBeat.o(193149);
            return;
        }
        String[] assetFileList = getAssetFileList(context);
        if (assetFileList == null) {
            AppMethodBeat.o(193149);
            return;
        }
        for (String str : assetFileList) {
            if (str.startsWith("MidasEmptyRes") && str.endsWith(".apk")) {
                String str2 = APPluginConfig.getPluginEmptyResPath(context).getAbsolutePath() + File.separator + str;
                APLog.i("APPluginUtils", "copyEmtpyResAPKFromAssets meptyResPath:".concat(String.valueOf(str2)));
                try {
                    InputStream open = context.getAssets().open(str);
                    File file = new File(str2);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                } catch (IOException e2) {
                }
            }
        }
        AppMethodBeat.o(193149);
    }

    static void backUp(final boolean z, final String str, final String str2, final String str3) {
        AppMethodBeat.i(193150);
        String str4 = null;
        try {
            str4 = Environment.getExternalStorageDirectory().getCanonicalPath();
        } catch (IOException e2) {
        }
        if (TextUtils.isEmpty(str4)) {
            AppMethodBeat.o(193150);
            return;
        }
        final String str5 = str4 + "/Tencent/MidasPay/";
        new Thread(new Runnable() {
            /* class com.tencent.midas.plugin.APPluginUtils.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(193120);
                synchronized (APPluginUtils.copyFileObject) {
                    try {
                        if (z) {
                            String str = str;
                            if (str.endsWith(ShareConstants.JAR_SUFFIX)) {
                                str = str.replace(ShareConstants.JAR_SUFFIX, ".apk");
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            APPluginUtils.copyFile(str3, str5, str, str2);
                            APLog.i("Times", "File" + str + "backup times:" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    } finally {
                        AppMethodBeat.o(193120);
                    }
                }
            }
        }).start();
        AppMethodBeat.o(193150);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[SYNTHETIC, Splitter:B:15:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkFileMD5(java.lang.String r8, java.lang.String r9) {
        /*
            r1 = 0
            r7 = 193151(0x2f27f, float:2.70662E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            java.lang.String r0 = ""
            r3 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x005c }
            if (r2 != 0) goto L_0x0017
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x005c }
            if (r2 == 0) goto L_0x001c
        L_0x0017:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r1
        L_0x001b:
            return r0
        L_0x001c:
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r8)
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Exception -> 0x0038 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0038 }
        L_0x002c:
            int r5 = r2.read(r4)     // Catch:{ Exception -> 0x0038 }
            r6 = -1
            if (r5 == r6) goto L_0x0049
            r6 = 0
            r3.update(r4, r6, r5)     // Catch:{ Exception -> 0x0038 }
            goto L_0x002c
        L_0x0038:
            r3 = move-exception
        L_0x0039:
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x005a }
        L_0x003e:
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x0055
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            goto L_0x001b
        L_0x0049:
            r2.close()
            byte[] r3 = r3.digest()
            java.lang.String r0 = toHexString(r3)
            goto L_0x003e
        L_0x0055:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r1
            goto L_0x001b
        L_0x005a:
            r2 = move-exception
            goto L_0x003e
        L_0x005c:
            r2 = move-exception
            r2 = r3
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.checkFileMD5(java.lang.String, java.lang.String):boolean");
    }

    public static String toHexString(byte[] bArr) {
        AppMethodBeat.i(193152);
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(HEX_DIGITS[(bArr[i2] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i2] & 15]);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(193152);
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[SYNTHETIC, Splitter:B:29:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085 A[Catch:{ IOException -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd A[SYNTHETIC, Splitter:B:48:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2 A[Catch:{ IOException -> 0x00dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.copyFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[SYNTHETIC, Splitter:B:20:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[Catch:{ IOException -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC, Splitter:B:32:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069 A[Catch:{ IOException -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.plugin.APPluginUtils.copyFile(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    static void copyDirect(Context context, File file, File file2) {
        AppMethodBeat.i(193155);
        if (!(file == null || file2 == null)) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(193155);
                return;
            }
            for (File file3 : listFiles) {
                copyFile(file3.getAbsolutePath(), file2.getAbsolutePath(), file3.getName());
            }
        }
        AppMethodBeat.o(193155);
    }

    public static String getMD5FromPath(String str) {
        AppMethodBeat.i(193156);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(".apk");
            int lastIndexOf2 = str.lastIndexOf("_");
            if (!(lastIndexOf == -1 || lastIndexOf2 == -1)) {
                try {
                    str2 = str.substring(lastIndexOf2 + 1, lastIndexOf);
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(193156);
        return str2;
    }

    public static void updateLibExtendNum() {
        AppMethodBeat.i(193157);
        APPluginConfig.libExtend++;
        APLog.i("APPluginUtils", "updateLibExtendNum libExtend:" + APPluginConfig.libExtend);
        AppMethodBeat.o(193157);
    }

    static void showLaunchPluginFail(Context context, String str, boolean z) {
        AppMethodBeat.i(193158);
        APLog.d(TAG, "Calling into showLaunchPluginFail, needToPureH5Pay = " + z + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if (!TextUtils.isEmpty(str)) {
            APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_NAME_LAUNCH_ERROR, str);
        }
        if (z) {
            if (APWebJSBridgeActivity.startPureH5Pay(context, str, "showLaunchPluginFail")) {
                AppMethodBeat.o(193158);
                return;
            }
            if (str != null && (str.contains("空间") || str.contains("Space"))) {
                Toast.makeText(context, "系统可用内存不足，请退出重试", 0).show();
            } else if (TextUtils.isEmpty(str) || (!str.contains("webview") && !str.contains("Webview"))) {
                Toast.makeText(context, "系统繁忙，请退出重试", 0).show();
            } else {
                Toast.makeText(context, "系统组件缺失，请退出重试", 0).show();
            }
            callbackInMidasPluginWithoutCaringAboutNewProcess(context, 100, "Unexpected error!");
        }
        AppMethodBeat.o(193158);
    }

    public static void callbackInMidasPluginWithoutCaringAboutNewProcess(Context context, int i2, String str) {
        AppMethodBeat.i(193159);
        if (context == null) {
            APLog.e(TAG, "Call back in plugin without caring process fail, null context!");
            AppMethodBeat.o(193159);
            return;
        }
        APLog.d(TAG, "Call back in plugin without caring process, context ok!");
        if (APMidasPayHelper.isNewProcess(context)) {
            APLog.d(TAG, "Call back in plugin without caring process, is new process!");
            callbackInMidasPluginWhenRunningInNewProcess(context, i2, str);
            AppMethodBeat.o(193159);
            return;
        }
        APLog.d(TAG, "Call back in plugin without caring process, not new process!");
        APMidasResponse aPMidasResponse = new APMidasResponse();
        aPMidasResponse.resultCode = i2;
        aPMidasResponse.resultMsg = str;
        APMidasPayHelper.midasCallBack(aPMidasResponse);
        AppMethodBeat.o(193159);
    }

    private static void callbackInMidasPluginWhenRunningInNewProcess(Context context, int i2, String str) {
        AppMethodBeat.i(193160);
        try {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_CALLBACK_RESULT_CODE", i2);
            intent.putExtra("EXTRA_CALLBACK_RESULT_MSG", str);
            APPluginInterfaceManager.initPluginInterface(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY, new Object[]{context, intent});
            AppMethodBeat.o(193160);
        } catch (Exception e2) {
            APLog.e("PluginProxyActivity", "openPlugin error:" + e2.toString());
            AppMethodBeat.o(193160);
        }
    }

    public static HashMap<String, String> url2Map(String str) {
        AppMethodBeat.i(193161);
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split("\\?");
        if (split == null) {
            AppMethodBeat.o(193161);
            return null;
        }
        if (split.length == 1) {
            str = split[0];
        } else if (split.length == 2) {
            str = split[1];
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split2 = str.split("\\&");
                String str2 = "";
                String str3 = "";
                for (int i2 = 0; i2 < split2.length; i2++) {
                    try {
                        str2 = split2[i2].split("\\=")[0];
                        str3 = split2[i2].split("\\=")[1];
                    } catch (Exception e2) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put(str2, str3);
                    }
                }
            } else {
                APLog.i("url2Map", "url后参数为空");
            }
        } catch (Exception e3) {
            APLog.w("url2Map", e3.toString());
        }
        AppMethodBeat.o(193161);
        return hashMap;
    }
}
