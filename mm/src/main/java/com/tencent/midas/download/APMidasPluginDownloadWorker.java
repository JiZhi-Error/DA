package com.tencent.midas.download;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginConfig;
import com.tencent.midas.plugin.APPluginUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

class APMidasPluginDownloadWorker implements Runnable {
    private static final String TAG = "PluginDownloadWorker";
    private final Context context;
    private final ArrayList<APMidasPluginDownInfo> downInfos;
    private final IAPMidasPluginDownListener downListener;
    private final File saveDir;

    APMidasPluginDownloadWorker(Context context2, ArrayList<APMidasPluginDownInfo> arrayList, File file, IAPMidasPluginDownListener iAPMidasPluginDownListener) {
        this.downInfos = arrayList;
        this.saveDir = file;
        this.downListener = iAPMidasPluginDownListener;
        this.context = context2;
    }

    public void run() {
        AppMethodBeat.i(193240);
        APLog.d(TAG, "About to enter critical region！");
        synchronized (APMidasPluginDownloadWorker.class) {
            try {
                APLog.d(TAG, "Enter critical region！");
                if (this.downListener == null) {
                    APLog.e(TAG, "Cannot start plugin down worker, null downListener!");
                } else if (this.downInfos == null || this.downInfos.isEmpty()) {
                    APLog.e(TAG, "Cannot start plugin down worker, empty down list!");
                    this.downListener.onDownloadFail(-5);
                    AppMethodBeat.o(193240);
                } else if (this.context == null) {
                    APLog.e(TAG, "Cannot start plugin down worker, null context!");
                    this.downListener.onDownloadFail(-8);
                    AppMethodBeat.o(193240);
                } else if (this.saveDir == null) {
                    APLog.e(TAG, "Cannot start plugin down worker, null save dir!");
                    this.downListener.onDownloadFail(-6);
                    AppMethodBeat.o(193240);
                } else if (!this.saveDir.isDirectory()) {
                    APLog.e(TAG, "Cannot start plugin down worker, save dir not directory!");
                    this.downListener.onDownloadFail(-7);
                    AppMethodBeat.o(193240);
                } else if (APMidasPluginDownloadUtils.checkIniFileExist(this.saveDir)) {
                    APLog.d(TAG, "MidasSign.ini already exists, no need to download again!");
                    this.downListener.onDownloadFail(-2);
                    AppMethodBeat.o(193240);
                } else {
                    APLog.d(TAG, "MidasSign.ini not exists, start to download again!");
                    APPluginUtils.clearDirContent(this.saveDir);
                    if (this.saveDir.exists() || this.saveDir.mkdirs()) {
                        Iterator<APMidasPluginDownInfo> it = this.downInfos.iterator();
                        while (it.hasNext()) {
                            APMidasPluginDownInfo next = it.next();
                            if (!downloadSingleDownInfo(next)) {
                                this.downListener.onDownloadFail(-4);
                                APLog.d(TAG, "File name = " + next.name + " download fail, about to clear download dir!");
                                APPluginUtils.clearDirContent(this.saveDir);
                                AppMethodBeat.o(193240);
                                return;
                            }
                        }
                        this.downListener.onDownloadSuccess();
                        APLog.d(TAG, "About to leave critical region");
                        APLog.d(TAG, "Leave critical region");
                        AppMethodBeat.o(193240);
                        return;
                    }
                    APLog.e(TAG, "Cannot start plugin down worker, save dir not exist and cannot create it!");
                    this.downListener.onDownloadFail(-3);
                    AppMethodBeat.o(193240);
                }
            } finally {
                AppMethodBeat.o(193240);
            }
        }
    }

    private boolean downloadSingleDownInfo(APMidasPluginDownInfo aPMidasPluginDownInfo) {
        String str;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.i(193241);
        if (aPMidasPluginDownInfo == null) {
            APLog.e(TAG, "Cannot download down info, info is null!");
            AppMethodBeat.o(193241);
            return false;
        } else if (TextUtils.isEmpty(aPMidasPluginDownInfo.full_url)) {
            APLog.e(TAG, "Cannot download down info, info's url is empty!");
            AppMethodBeat.o(193241);
            return false;
        } else if (TextUtils.isEmpty(aPMidasPluginDownInfo.name)) {
            APLog.e(TAG, "Cannot download down info, info's name is empty!");
            AppMethodBeat.o(193241);
            return false;
        } else {
            if (aPMidasPluginDownInfo.name.endsWith(".apk") || aPMidasPluginDownInfo.name.endsWith(".Apk") || aPMidasPluginDownInfo.name.endsWith(".APK")) {
                str = aPMidasPluginDownInfo.name;
            } else {
                str = aPMidasPluginDownInfo.name + ".apk";
            }
            if (isPluginAlreadyExist(this.context, str, aPMidasPluginDownInfo.new_md5_decode, this.saveDir.getAbsolutePath())) {
                APLog.d(TAG, "plugin already test, no need to download! name = ".concat(String.valueOf(str)));
                AppMethodBeat.o(193241);
                return true;
            }
            try {
                File file = new File(Environment.getExternalStorageDirectory().getCanonicalPath() + "/Tencent/MidasPay/", str);
                if (file.exists()) {
                    APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, but need to check md5!");
                    if (APPluginUtils.checkFileMD5(file.getAbsolutePath(), aPMidasPluginDownInfo.new_md5_decode)) {
                        APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, md5 ok too!");
                        if (APPluginUtils.copyFile(file.getAbsolutePath(), this.saveDir.getAbsolutePath(), str)) {
                            APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, md5 ok too! Copy success!");
                            AppMethodBeat.o(193241);
                            return true;
                        }
                        APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, md5 ok too! Copy fail!");
                    } else {
                        APLog.d(TAG, "File name = " + str + " already exist in sdcard! We can copy from it, no need to download, but md5 not ok!");
                    }
                } else {
                    APLog.d(TAG, "File name = " + str + " not exist in sdcard! Cannot copy from it, we need to download!");
                }
            } catch (Exception e2) {
                APLog.d(TAG, "File name = " + str + " copy from sdcard got exception " + e2);
            }
            String str2 = aPMidasPluginDownInfo.full_url;
            APLog.d(TAG, "download single down info! Start to down url = ".concat(String.valueOf(str2)));
            APLog.d(TAG, "download single down info! Start to down file name = ".concat(String.valueOf(str)));
            File file2 = new File(this.saveDir, str);
            if (file2.exists()) {
                if (!file2.delete()) {
                    APLog.e(TAG, "File already exist test, cannot delete old file, file = " + file2.getAbsolutePath());
                    AppMethodBeat.o(193241);
                    return false;
                }
                APLog.w(TAG, "download single down info! file name already exist, delete it successfully = " + file2.getAbsolutePath());
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setConnectTimeout(45000);
                httpURLConnection.setReadTimeout(45000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    APLog.e(TAG, "Cannot download file, http code not 200! Code = ".concat(String.valueOf(responseCode)));
                    closeQuietly(null);
                    closeQuietly(null);
                    AppMethodBeat.o(193241);
                    return false;
                } else if (!file2.createNewFile()) {
                    APLog.e(TAG, "Cannot download file, fail to create file! File = " + file2.getAbsolutePath());
                    closeQuietly(null);
                    closeQuietly(null);
                    AppMethodBeat.o(193241);
                    return false;
                } else {
                    fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        inputStream2 = httpURLConnection.getInputStream();
                    } catch (Exception e3) {
                        fileOutputStream = fileOutputStream2;
                        inputStream = null;
                        try {
                            APLog.e(TAG, "download single down info fail! File name = ".concat(String.valueOf(str)));
                            closeQuietly(inputStream);
                            closeQuietly(fileOutputStream);
                            AppMethodBeat.o(193241);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            closeQuietly(inputStream);
                            closeQuietly(fileOutputStream2);
                            AppMethodBeat.o(193241);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        closeQuietly(inputStream);
                        closeQuietly(fileOutputStream2);
                        AppMethodBeat.o(193241);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        fileOutputStream2.flush();
                        closeQuietly(inputStream2);
                        closeQuietly(fileOutputStream2);
                        APLog.d(TAG, "download single down info success! File name = " + str + " About to copy to sdcard!");
                        try {
                            String str3 = Environment.getExternalStorageDirectory().getCanonicalPath() + "/Tencent/MidasPay/";
                            if (new File(str3, str).exists()) {
                                APLog.d(TAG, "File name = " + str + " already exist in sdcard! No need to copy!");
                                AppMethodBeat.o(193241);
                                return true;
                            }
                            APLog.d(TAG, "File name = " + str + " not exist in sdcard! Need to copy!");
                            APPluginUtils.copyFile(file2.getAbsolutePath(), str3, str);
                            AppMethodBeat.o(193241);
                            return true;
                        } catch (Exception e4) {
                            APLog.d(TAG, "File name = " + str + " copy to sdcard got exception " + e4);
                        }
                    } catch (Exception e5) {
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        APLog.e(TAG, "download single down info fail! File name = ".concat(String.valueOf(str)));
                        closeQuietly(inputStream);
                        closeQuietly(fileOutputStream);
                        AppMethodBeat.o(193241);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = inputStream2;
                        closeQuietly(inputStream);
                        closeQuietly(fileOutputStream2);
                        AppMethodBeat.o(193241);
                        throw th;
                    }
                }
            } catch (Exception e6) {
                fileOutputStream = null;
                inputStream = null;
                APLog.e(TAG, "download single down info fail! File name = ".concat(String.valueOf(str)));
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                AppMethodBeat.o(193241);
                return false;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream2 = null;
                inputStream = null;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream2);
                AppMethodBeat.o(193241);
                throw th;
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(193242);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                AppMethodBeat.o(193242);
                return;
            }
        }
        AppMethodBeat.o(193242);
    }

    private static boolean isPluginAlreadyExist(Context context2, String str, String str2, String str3) {
        AppMethodBeat.i(193243);
        APLog.d(TAG, "plugin already exist in midasplugins test, file name = ".concat(String.valueOf(str)));
        APLog.d(TAG, "plugin already exist in midasplugins test, md5 = ".concat(String.valueOf(str2)));
        if (TextUtils.isEmpty(str)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty file name!");
            AppMethodBeat.o(193243);
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty md5!");
            AppMethodBeat.o(193243);
            return false;
        } else if (context2 == null) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, null context!");
            AppMethodBeat.o(193243);
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            APLog.e(TAG, "plugin already exist in midasplugins test error, empty saveDir!");
            AppMethodBeat.o(193243);
            return false;
        } else {
            File pluginPath = APPluginConfig.getPluginPath(context2);
            if (pluginPath == null) {
                APLog.e(TAG, "plugin already exist in midasplugins error, cannot get plugin path!");
                AppMethodBeat.o(193243);
                return false;
            }
            File file = new File(pluginPath, str);
            if (!file.exists()) {
                APLog.d(TAG, "plugin already exist in midasplugins test, plugin not exist! Name = ".concat(String.valueOf(str)));
                AppMethodBeat.o(193243);
                return false;
            }
            try {
                if (APPluginUtils.checkFileMD5(file.getCanonicalPath(), str2)) {
                    APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct!");
                    if (APPluginUtils.copyFile(file.getCanonicalPath(), str3, str)) {
                        APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy success!");
                        AppMethodBeat.o(193243);
                        return true;
                    }
                    APLog.e(TAG, "plugin already exist in midasplugins test, plugin exist & md5 correct & copy fail!");
                } else {
                    APLog.d(TAG, "plugin already exist in midasplugins test, plugin exist & md5 not correct!");
                }
            } catch (IOException e2) {
                APLog.d(TAG, "plugin already exist in midasplugins test error, exception = ".concat(String.valueOf(e2)));
            }
            APLog.e(TAG, "plugin already exist in midasplugins test, final false!");
            AppMethodBeat.o(193243);
            return false;
        }
    }
}
