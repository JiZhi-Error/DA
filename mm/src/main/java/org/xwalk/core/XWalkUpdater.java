package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.s;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.u;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import com.tencent.xweb.xwalk.updater.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xwalk.core.XWalkLibraryLoader;

public class XWalkUpdater {
    private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
    public static final int ERROR_DOPATCH_FAILED = -3;
    public static final int ERROR_DOPATCH_MD5_FAILED = -4;
    public static final int ERROR_DOWNLOAD_FAILED = -1;
    public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
    public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
    public static final int ERROR_EXTRACT_RESOURCE_FAILED_FOR_RETRY = -12;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_SET_VERNUM = -101;
    public static final int ERROR_SHARED_MODE_EXCEED_MAX_COUNT = -7;
    public static final int ERROR_SHARED_MODE_FORCE_DOWNLOAD = -6;
    public static final int ERROR_SHARED_MODE_NO_CONTENT_RESOLVER = -8;
    public static final int ERROR_SHARED_MODE_NO_PROVIDER = -9;
    public static final int ERROR_SHARED_MODE_OTHER = -11;
    public static final int ERROR_SHARED_MODE_TRY_AGAIN = -10;
    private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
    static final String INSTALLED_EMBED_VERSION = "INSTALLED_EMBED_VERSION";
    private static final int RES_EXTRACTOR_MAXTIMES = 1;
    private static final String TAG = "XWalkLib";
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
    private static int mCurrentTimeForRetryRes = 0;
    static boolean sBTryedInstallFromEmbed = false;
    private XWalkBackgroundUpdateListener mBackgroundUpdateListener;
    private Runnable mCancelCommand;
    private Context mContext;
    private XWalkDialogManager mDialogManager;
    private Runnable mDownloadCommand;
    private XWalkUpdateListener mUpdateListener;

    public static class ErrorInfo {
        public int copyFailedCount = 0;
        public int errorCode = -11;
        public int extractFailedCount = 0;
        public int extractRetryFailedCount = 0;
        public int md5FailedCount = 0;
        public int noMatchedVersionCount = 0;
        public int readFileListFailedCount = 0;
        public int setVersionFailedCount = 0;
        public int targetVer = -1;
    }

    public interface XWalkBackgroundUpdateListener {
        void onXWalkUpdateCancelled();

        void onXWalkUpdateCompleted(Scheduler scheduler);

        void onXWalkUpdateFailed(int i2, Scheduler scheduler);

        void onXWalkUpdateProgress(int i2);

        void onXWalkUpdateStarted();
    }

    public interface XWalkUpdateListener {
        void onXWalkUpdateCancelled();
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context) {
        AppMethodBeat.i(155020);
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = new XWalkDialogManager(context);
        AppMethodBeat.o(155020);
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context, XWalkDialogManager xWalkDialogManager) {
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = xWalkDialogManager;
    }

    public XWalkUpdater(XWalkBackgroundUpdateListener xWalkBackgroundUpdateListener, Context context) {
        this.mBackgroundUpdateListener = xWalkBackgroundUpdateListener;
        this.mContext = context;
    }

    public boolean updateXWalkRuntime(UpdateConfig updateConfig) {
        AppMethodBeat.i(155021);
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "Other initialization or download is proceeding");
            AppMethodBeat.o(155021);
            return false;
        } else if (this.mBackgroundUpdateListener == null) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "Update listener is null");
            AppMethodBeat.o(155021);
            return false;
        } else if (updateConfig == null || !updateConfig.checkValid()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
            h.huo();
            AppMethodBeat.o(155021);
            return false;
        } else {
            XWalkInitializer.addXWalkInitializeLog(TAG, "start download apk");
            XWalkLibraryLoader.startHttpDownload(new BackgroundListener(updateConfig), this.mContext, updateConfig);
            AppMethodBeat.o(155021);
            return true;
        }
    }

    public synchronized ErrorInfo updateRuntimeFromProvider(XWebCoreScheduler xWebCoreScheduler) {
        ErrorInfo errorInfo;
        int i2;
        String[] split;
        AppMethodBeat.i(207400);
        c hvJ = xWebCoreScheduler.hvJ();
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + hvJ.version);
        ErrorInfo errorInfo2 = new ErrorInfo();
        errorInfo2.targetVer = hvJ.version;
        if (!hvJ.bTryUseSharedCore) {
            XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
            errorInfo2.errorCode = -6;
            AppMethodBeat.o(207400);
            errorInfo = errorInfo2;
        } else if (hvJ.SJi >= 2) {
            XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
            errorInfo2.errorCode = -7;
            AppMethodBeat.o(207400);
            errorInfo = errorInfo2;
        } else {
            ContentResolver contentResolver = XWalkEnvironment.getContentResolver();
            if (contentResolver == null) {
                XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
                errorInfo2.errorCode = -8;
                AppMethodBeat.o(207400);
                errorInfo = errorInfo2;
            } else {
                UpdateConfig f2 = xWebCoreScheduler.f(hvJ);
                boolean z = false;
                String[] strArr = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        String str = strArr[i3];
                        if (isProviderExist(contentResolver, str)) {
                            XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
                            String nS = a.nS("SHARE_CORE_LIST", "tools");
                            Log.i(TAG, "dump SHARE_CORE_LIST: ".concat(String.valueOf(nS)));
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(Integer.valueOf(f2.apkVer));
                            if (!TextUtils.isEmpty(nS) && !XWalkEnvironment.hasInstalledAvailableVersion() && (split = nS.split(";")) != null) {
                                for (String str2 : split) {
                                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2.trim())) {
                                        try {
                                            int parseInt = Integer.parseInt(str2);
                                            if (f2.apkVer != parseInt) {
                                                arrayList.add(Integer.valueOf(parseInt));
                                            }
                                        } catch (Exception e2) {
                                            Log.e(TAG, "parse SHARE_CORE_LIST failed " + e2.getMessage());
                                        }
                                    }
                                }
                            }
                            Map<String, String> map = null;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= arrayList.size()) {
                                    i2 = -1;
                                    break;
                                }
                                i2 = ((Integer) arrayList.get(i4)).intValue();
                                map = tryGetFileList(contentResolver, str, i2);
                                if (map != null) {
                                    if (map.size() != 0) {
                                        break;
                                    }
                                    XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version ver = ".concat(String.valueOf(i2)));
                                } else {
                                    XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed ver = ".concat(String.valueOf(i2)));
                                    errorInfo2.readFileListFailedCount++;
                                }
                                i4++;
                            }
                            if (i2 < 0) {
                                errorInfo2.noMatchedVersionCount++;
                                z = true;
                            } else {
                                XWalkInitializer.addXWalkInitializeLog("find share available ver = ".concat(String.valueOf(i2)));
                                if (tryCopyVersion(contentResolver, str, i2, map, errorInfo2)) {
                                    int intValue = extractResource(i2, f2.abi, i2 + "_install_from_share_mode").intValue();
                                    if (intValue == 0) {
                                        errorInfo2.errorCode = 0;
                                        AppMethodBeat.o(207400);
                                        errorInfo = errorInfo2;
                                        break;
                                    } else if (intValue == -5) {
                                        errorInfo2.extractFailedCount++;
                                        z = true;
                                    } else if (intValue == -12) {
                                        errorInfo2.extractRetryFailedCount++;
                                        z = true;
                                    } else if (intValue == -101) {
                                        errorInfo2.setVersionFailedCount++;
                                    }
                                }
                                z = true;
                            }
                        }
                        i3++;
                    } else if (!z) {
                        XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
                        errorInfo2.errorCode = -9;
                        AppMethodBeat.o(207400);
                        errorInfo = errorInfo2;
                    } else {
                        if (!XWalkEnvironment.hasAvailableVersion() || hvJ.SJi + 1 >= 2) {
                            XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
                            errorInfo2.errorCode = -11;
                        } else {
                            XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
                            errorInfo2.errorCode = -10;
                        }
                        AppMethodBeat.o(207400);
                        errorInfo = errorInfo2;
                    }
                }
            }
        }
        return errorInfo;
    }

    private static boolean isProviderExist(ContentResolver contentResolver, String str) {
        boolean z = true;
        AppMethodBeat.i(155023);
        if (contentResolver == null || str == null || str.isEmpty()) {
            AppMethodBeat.o(155023);
            return false;
        }
        try {
            com.tencent.xweb.util.c.a(contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.d(str, XWalkEnvironment.getPackageName(), 1, 0, ""), ""));
        } catch (Exception e2) {
            com.tencent.xweb.util.c.a(null);
            z = false;
        } catch (Throwable th) {
            com.tencent.xweb.util.c.a(null);
            AppMethodBeat.o(155023);
            throw th;
        }
        AppMethodBeat.o(155023);
        return z;
    }

    private static Map<String, String> tryGetFileList(ContentResolver contentResolver, String str, int i2) {
        PrintWriter printWriter;
        BufferedReader bufferedReader;
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        AppMethodBeat.i(155024);
        HashMap hashMap = new HashMap();
        try {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.d(str, XWalkEnvironment.getPackageName(), 2, i2, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME), "");
            if (assetFileDescriptor == null) {
                try {
                    XWalkInitializer.addXWalkInitializeLog("tryGetFileList no file list");
                    com.tencent.xweb.util.c.tryClose(null);
                    com.tencent.xweb.util.c.tryClose(null);
                    com.tencent.xweb.util.c.a(assetFileDescriptor);
                    AppMethodBeat.o(155024);
                    return hashMap;
                } catch (Exception e2) {
                    e = e2;
                    printWriter = null;
                    bufferedReader = null;
                    try {
                        XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                        com.tencent.xweb.util.c.tryClose(printWriter);
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        com.tencent.xweb.util.c.a(assetFileDescriptor);
                        AppMethodBeat.o(155024);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.xweb.util.c.tryClose(printWriter);
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        com.tencent.xweb.util.c.a(assetFileDescriptor);
                        AppMethodBeat.o(155024);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = null;
                    bufferedReader = null;
                    com.tencent.xweb.util.c.tryClose(printWriter);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    com.tencent.xweb.util.c.a(assetFileDescriptor);
                    AppMethodBeat.o(155024);
                    throw th;
                }
            } else {
                File file = new File(XWalkEnvironment.getExtractedCoreFile(i2, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME));
                if (file.exists()) {
                    file.delete();
                }
                printWriter = new PrintWriter(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(assetFileDescriptor.createInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                printWriter.println(readLine);
                                if (!readLine.isEmpty()) {
                                    String[] split = readLine.split(":");
                                    if (split.length == 2 && split[0] != null && !split[0].isEmpty() && split[1] != null && !split[1].isEmpty()) {
                                        hashMap.put(split[0], split[1]);
                                    }
                                }
                            } else {
                                printWriter.flush();
                                com.tencent.xweb.util.c.tryClose(printWriter);
                                com.tencent.xweb.util.c.tryClose(bufferedReader);
                                com.tencent.xweb.util.c.a(assetFileDescriptor);
                                AppMethodBeat.o(155024);
                                return hashMap;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                            com.tencent.xweb.util.c.tryClose(printWriter);
                            com.tencent.xweb.util.c.tryClose(bufferedReader);
                            com.tencent.xweb.util.c.a(assetFileDescriptor);
                            AppMethodBeat.o(155024);
                            return null;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedReader = null;
                    XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
                    com.tencent.xweb.util.c.tryClose(printWriter);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    com.tencent.xweb.util.c.a(assetFileDescriptor);
                    AppMethodBeat.o(155024);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    com.tencent.xweb.util.c.tryClose(printWriter);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    com.tencent.xweb.util.c.a(assetFileDescriptor);
                    AppMethodBeat.o(155024);
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            printWriter = null;
            bufferedReader = null;
            assetFileDescriptor = null;
            XWalkInitializer.addXWalkInitializeLog("tryGetFileList error: " + e.getMessage());
            com.tencent.xweb.util.c.tryClose(printWriter);
            com.tencent.xweb.util.c.tryClose(bufferedReader);
            com.tencent.xweb.util.c.a(assetFileDescriptor);
            AppMethodBeat.o(155024);
            return null;
        } catch (Throwable th5) {
            th = th5;
            printWriter = null;
            bufferedReader = null;
            assetFileDescriptor = null;
            com.tencent.xweb.util.c.tryClose(printWriter);
            com.tencent.xweb.util.c.tryClose(bufferedReader);
            com.tencent.xweb.util.c.a(assetFileDescriptor);
            AppMethodBeat.o(155024);
            throw th;
        }
    }

    private static boolean tryCopyVersion(ContentResolver contentResolver, String str, int i2, Map<String, String> map, ErrorInfo errorInfo) {
        File file;
        AppMethodBeat.i(155025);
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(XWebCoreContentProvider.d(str, XWalkEnvironment.getPackageName(), 2, i2, key), "");
                if (openAssetFileDescriptor == null) {
                    errorInfo.copyFailedCount++;
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file ".concat(String.valueOf(key)));
                    AppMethodBeat.o(155025);
                    return false;
                }
                if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(key)) {
                    file = new File(XWalkEnvironment.getDownloadApkPath(i2));
                } else {
                    file = new File(XWalkEnvironment.getExtractedCoreFile(i2, key));
                }
                if (!com.tencent.xweb.util.c.a(openAssetFileDescriptor, file)) {
                    errorInfo.copyFailedCount++;
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
                    AppMethodBeat.o(155025);
                    return false;
                } else if (!d.oi(file.getAbsolutePath(), value)) {
                    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error ".concat(String.valueOf(key)));
                    errorInfo.md5FailedCount++;
                    if (file.exists()) {
                        file.delete();
                    }
                    AppMethodBeat.o(155025);
                    return false;
                }
            }
            AppMethodBeat.o(155025);
            return true;
        } catch (Exception e2) {
            XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + e2.getMessage());
            errorInfo.copyFailedCount++;
            AppMethodBeat.o(155025);
            return false;
        }
    }

    public static void updateLocalXWalkRuntime() {
        AppMethodBeat.i(155026);
        onHandleFile(new UpdateConfig(XWalkEnvironment.LOCAL_TEST_ZIP_NAME, false, XWalkEnvironment.TEST_APK_START_VERSION, XWalkEnvironment.getRuntimeAbi(), 0));
        AppMethodBeat.o(155026);
    }

    public void cancelXWalkRuntimeDownload() {
        AppMethodBeat.i(155027);
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "canceled download apk");
            XWalkLibraryLoader.cancelHttpDownload();
        }
        AppMethodBeat.o(155027);
    }

    public boolean dismissDialog() {
        AppMethodBeat.i(155028);
        if (this.mDialogManager == null || !this.mDialogManager.isShowingDialog()) {
            AppMethodBeat.o(155028);
            return false;
        }
        this.mDialogManager.dismissDialog();
        AppMethodBeat.o(155028);
        return true;
    }

    public boolean cancelBackgroundDownload() {
        AppMethodBeat.i(155029);
        boolean cancelHttpDownload = XWalkLibraryLoader.cancelHttpDownload();
        AppMethodBeat.o(155029);
        return cancelHttpDownload;
    }

    /* access modifiers changed from: package-private */
    public class BackgroundListener implements XWalkLibraryLoader.DownloadListener {
        private UpdateConfig mConfig;

        public BackgroundListener(UpdateConfig updateConfig) {
            this.mConfig = updateConfig;
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public void onDownloadStarted(int i2) {
            AppMethodBeat.i(155004);
            Log.d(XWalkUpdater.TAG, "DownloadTask started, type:" + i2 + " config:" + this.mConfig.getLogSelf());
            if (this.mConfig.isPatchUpdate) {
                h.hur();
            } else {
                h.hum();
            }
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateStarted();
            AppMethodBeat.o(155004);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public void onDownloadUpdated(int i2) {
            AppMethodBeat.i(155005);
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateProgress(i2);
            AppMethodBeat.o(155005);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public void onDownloadCancelled() {
            AppMethodBeat.i(155006);
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCancelled();
            AppMethodBeat.o(155006);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo downloadInfo) {
            AppMethodBeat.i(155007);
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk failed");
            if (this.mConfig.isPatchUpdate) {
                h.hus();
            } else {
                h.hun();
            }
            reportKV(downloadInfo);
            if (!(this.mConfig == null || this.mConfig.scheduler == null)) {
                this.mConfig.scheduler.atj(-1);
            }
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(-1, this.mConfig.scheduler);
            AppMethodBeat.o(155007);
        }

        @Override // org.xwalk.core.XWalkLibraryLoader.DownloadListener
        public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo downloadInfo) {
            AppMethodBeat.i(155008);
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk completed, apkver = " + this.mConfig.apkVer);
            if (this.mConfig.isPatchUpdate) {
                h.OW(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
            } else {
                h.OU(System.currentTimeMillis() - downloadInfo.mStartTimestamp);
            }
            reportKV(downloadInfo);
            new AsyncTask<Void, Void, Integer>() {
                /* class org.xwalk.core.XWalkUpdater.BackgroundListener.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public /* bridge */ /* synthetic */ Integer doInBackground(Void[] voidArr) {
                    AppMethodBeat.i(155003);
                    Integer doInBackground = doInBackground(voidArr);
                    AppMethodBeat.o(155003);
                    return doInBackground;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public /* bridge */ /* synthetic */ void onPostExecute(Integer num) {
                    AppMethodBeat.i(155002);
                    onPostExecute(num);
                    AppMethodBeat.o(155002);
                }

                /* access modifiers changed from: protected */
                public Integer doInBackground(Void... voidArr) {
                    AppMethodBeat.i(155000);
                    Integer onHandleFile = XWalkUpdater.onHandleFile(BackgroundListener.this.mConfig);
                    AppMethodBeat.o(155000);
                    return onHandleFile;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Integer num) {
                    AppMethodBeat.i(155001);
                    if (num.intValue() != 0) {
                        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(num.intValue(), BackgroundListener.this.mConfig.scheduler);
                        AppMethodBeat.o(155001);
                        return;
                    }
                    XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCompleted(BackgroundListener.this.mConfig.scheduler);
                    AppMethodBeat.o(155001);
                }
            }.execute(new Void[0]);
            AppMethodBeat.o(155008);
        }

        private void reportKV(XWalkLibraryLoader.DownloadInfo downloadInfo) {
            int i2 = 1;
            AppMethodBeat.i(155009);
            int i3 = this.mConfig.isPatchUpdate ? 2 : 1;
            int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
            int i4 = this.mConfig.apkVer;
            long currentTimeMillis = System.currentTimeMillis() - downloadInfo.mStartTimestamp;
            if (!downloadInfo.mIsDownloadResume) {
                i2 = 0;
            }
            h.dz(15124, i3 + "," + installedNewstVersionForCurAbi + "," + i4 + ",201201," + downloadInfo.mErrorCode + "," + downloadInfo.mNetWorkType + "," + downloadInfo.mRetryTimes + "," + currentTimeMillis + "," + downloadInfo.mFileTotalSize + "," + downloadInfo.mDownloadType + "," + i2);
            AppMethodBeat.o(155009);
        }
    }

    public static void tryInstallFromEmebed() {
    }

    public static void clearLastTryEmebedVersion() {
        AppMethodBeat.i(207401);
        getSpForEmbedInstall(XWalkEnvironment.RUNTIME_ABI_ARM32_STR).edit().putInt(INSTALLED_EMBED_VERSION, -1).commit();
        getSpForEmbedInstall(XWalkEnvironment.RUNTIME_ABI_ARM64_STR).edit().putInt(INSTALLED_EMBED_VERSION, -1).commit();
        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "do clearLastTryEmebedVersion");
        AppMethodBeat.o(207401);
    }

    static SharedPreferences getSpForEmbedInstall(String str) {
        AppMethodBeat.i(207402);
        SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB_EMBED_INSTALL_".concat(String.valueOf(str)));
        AppMethodBeat.o(207402);
        return mMKVSharedPreferences;
    }

    public static int getLastTryInstallVer(String str) {
        AppMethodBeat.i(207403);
        int i2 = getSpForEmbedInstall(str).getInt(INSTALLED_EMBED_VERSION, -1);
        AppMethodBeat.o(207403);
        return i2;
    }

    public static void doInstallFromEmebed() {
        EmbededUpdateConfig hybridUpdateConfig;
        int i2 = -1;
        AppMethodBeat.i(207404);
        int lastTryInstallVer = getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi());
        SharedPreferences spForEmbedInstall = getSpForEmbedInstall(XWalkEnvironment.getRuntimeAbi());
        try {
            XWalkEnvironment.is64BitRuntime();
            try {
                if (XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.getRuntimeAbi()) >= 0) {
                    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install stopped this version too old ");
                    spForEmbedInstall.edit().putInt(INSTALLED_EMBED_VERSION, 0).commit();
                    AppMethodBeat.o(207404);
                } else if (lastTryInstallVer == 0) {
                    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install skip ,this version was tried");
                    AppMethodBeat.o(207404);
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "type:LIBabi:LIBversion:0verstion des:" + "1.0.0_from_lib" + "filename:" + "libxwebfullpack.so");
                    switch (BuildConfig.INSTALL_TYPE.hashCode()) {
                        case 75365:
                            if (BuildConfig.INSTALL_TYPE.equals(BuildConfig.INSTALL_TYPE)) {
                                i2 = 0;
                                break;
                            }
                            break;
                        case 62583504:
                            if (BuildConfig.INSTALL_TYPE.equals("ASSET")) {
                                i2 = 1;
                                break;
                            }
                            break;
                        case 2145539580:
                            if (BuildConfig.INSTALL_TYPE.equals("HYBRID")) {
                                i2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (i2) {
                        case 0:
                            hybridUpdateConfig = new LibUpdateConfig(0, "libxwebfullpack.so", "1");
                            break;
                        case 1:
                            hybridUpdateConfig = new AssetsUpdateConfig(0, "libxwebfullpack.so", "1");
                            break;
                        case 2:
                            hybridUpdateConfig = new HybridUpdateConfig(0, "libxwebfullpack.so", "1");
                            break;
                        default:
                            hybridUpdateConfig = null;
                            break;
                    }
                    if (hybridUpdateConfig == null) {
                        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "not recongniezed install type");
                        AppMethodBeat.o(207404);
                    } else if (!hybridUpdateConfig.copySuc()) {
                        h.s(903, 126, 1);
                        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "copy failed");
                        AppMethodBeat.o(207404);
                    } else {
                        hybridUpdateConfig.getDownloadPath();
                        hybridUpdateConfig.versionDetail = "1.0.0_from_lib";
                        Integer onHandleFile = onHandleFile(hybridUpdateConfig);
                        if (onHandleFile.intValue() == 0) {
                            h.s(903, 127, 1);
                            s.init();
                            p.hQ("finished", 0);
                            XWalkEnvironment.refreshAvailableVersion();
                        }
                        XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install from embed ret code =  ".concat(String.valueOf(onHandleFile)));
                        i2 = 0;
                        spForEmbedInstall.edit().putInt(INSTALLED_EMBED_VERSION, i2).commit();
                        AppMethodBeat.o(207404);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                h.s(903, 128, 1);
                XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install failed " + e.getMessage());
                spForEmbedInstall.edit().putInt(INSTALLED_EMBED_VERSION, i2).commit();
                AppMethodBeat.o(207404);
            }
        } catch (Exception e3) {
            e = e3;
            h.s(903, 128, 1);
            XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install failed " + e.getMessage());
            spForEmbedInstall.edit().putInt(INSTALLED_EMBED_VERSION, i2).commit();
            AppMethodBeat.o(207404);
        }
    }

    public static Integer onHandleFile(UpdateConfig updateConfig) {
        AppMethodBeat.i(155030);
        String downloadPath = updateConfig.getDownloadPath();
        Log.d(TAG, "Download mode extract dir: ".concat(String.valueOf(XWalkEnvironment.getExtractedCoreDir(updateConfig.apkVer))));
        if (!updateConfig.isMatchMd5 || d.oi(downloadPath, updateConfig.downloadFileMd5)) {
            if (updateConfig.isPatchUpdate) {
                if (!onDoPatch(downloadPath, updateConfig.nPatchTargetVersion, updateConfig.apkVer)) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode ,but patch error");
                    AppMethodBeat.o(155030);
                    return -3;
                } else if (!updateConfig.isMatchMd5 || FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(updateConfig.apkVer))) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "do patch sucsess");
                } else {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                    h.OQ(36);
                    AppMethodBeat.o(155030);
                    return -4;
                }
            } else if (!XWalkDecompressor.decompressDownloadFullZip(downloadPath, updateConfig.apkVer)) {
                h.OQ(32);
                AppMethodBeat.o(155030);
                return -5;
            } else if (updateConfig.isMatchMd5 && !FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(updateConfig.apkVer))) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                h.OQ(33);
                AppMethodBeat.o(155030);
                return -4;
            }
            Integer extractResource = extractResource(updateConfig);
            AppMethodBeat.o(155030);
            return extractResource;
        }
        XWalkInitializer.addXWalkInitializeLog(TAG, "downloaded apk md5 check failed");
        AppMethodBeat.o(155030);
        return -2;
    }

    public static void try_generate_jar_for_dex_in_dir(String str, boolean z) {
        AppMethodBeat.i(207405);
        if (Build.VERSION.SDK_INT < 29 || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.nS("NOT_USE_JAR_REPLACE_DEX", "tools"))) {
            AppMethodBeat.o(207405);
            return;
        }
        generate_jar_for_dex_in_dir(str, z);
        AppMethodBeat.o(207405);
    }

    static void generate_jar_for_dex_in_dir(String str, boolean z) {
        AppMethodBeat.i(207406);
        File file = new File(str);
        if (!file.isDirectory()) {
            AppMethodBeat.o(207406);
            return;
        }
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (file2.isDirectory()) {
                    generate_jar_for_dex_in_dir(file2.getAbsolutePath(), z);
                } else if (file2.getName().endsWith(ShareConstants.DEX_SUFFIX)) {
                    generate_jar_for_dex(file2, z);
                }
            }
        }
        AppMethodBeat.o(207406);
    }

    static void generate_jar_for_dex(File file, boolean z) {
        AppMethodBeat.i(207407);
        String name = file.getName();
        try {
            String str = file.getAbsolutePath() + ShareConstants.JAR_SUFFIX;
            File file2 = new File(str);
            if (file2.exists()) {
                Log.i(TAG, "generate .jar from " + name + " , but jar file exists , need remove =  " + z);
                if (!z) {
                    AppMethodBeat.o(207407);
                    return;
                }
                file2.delete();
            }
            Log.i(TAG, "generate .jar from " + name + " ret =  " + u.j(file, str));
            AppMethodBeat.o(207407);
        } catch (Exception e2) {
            Log.e(TAG, "generate .jar from " + name + " failed. error is " + e2.getMessage());
            AppMethodBeat.o(207407);
        }
    }

    private static Integer extractResource(UpdateConfig updateConfig) {
        AppMethodBeat.i(155031);
        Integer extractResource = extractResource(updateConfig.apkVer, updateConfig.abi, updateConfig.versionDetail);
        AppMethodBeat.o(155031);
        return extractResource;
    }

    private static Integer extractResource(int i2, String str, String str2) {
        AppMethodBeat.i(207408);
        while (true) {
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(i2);
            if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(i2), extractedCoreDir, getResFileList(i2))) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "extract faield");
                AppMethodBeat.o(207408);
                return -5;
            } else if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(i2), extractedCoreDir, i2)) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkExtractResFileLengtgAndMd5 success!!!!");
                try_generate_jar_for_dex_in_dir(extractedCoreDir, true);
                if (!generateOptDex(i2)) {
                    h.OQ(251);
                    if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(a.nS("update_need_check_dex", "tools"))) {
                        AppMethodBeat.o(207408);
                        return -101;
                    }
                }
                boolean versionForAbi = XWebCoreInfo.setVersionForAbi(i2, str2, str);
                XWalkInitializer.addXWalkInitializeLog(TAG, "do update sucsess");
                h.htW();
                com.tencent.xweb.internal.c.bsw("CHECK_FILES_MD5_TIME_KEY");
                if (!versionForAbi) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "set version failed");
                    AppMethodBeat.o(207408);
                    return -101;
                }
                AppMethodBeat.o(207408);
                return 0;
            } else if (mCurrentTimeForRetryRes <= 0) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkExtractResFileLengtgAndMd5 failed retry extractResource");
                mCurrentTimeForRetryRes++;
            } else {
                XWalkInitializer.addXWalkInitializeLog(TAG, "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
                AppMethodBeat.o(207408);
                return -12;
            }
        }
    }

    private static boolean generateOptDex(int i2) {
        AppMethodBeat.i(155032);
        try {
            i.asW(i2);
            AppMethodBeat.o(155032);
            return true;
        } catch (Exception e2) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "dex output error");
            AppMethodBeat.o(155032);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b9 A[SYNTHETIC, Splitter:B:35:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be A[SYNTHETIC, Splitter:B:38:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[SYNTHETIC, Splitter:B:41:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0165 A[SYNTHETIC, Splitter:B:82:0x0165] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016a A[SYNTHETIC, Splitter:B:85:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016f A[SYNTHETIC, Splitter:B:88:0x016f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] getResFileList(int r9) {
        /*
        // Method dump skipped, instructions count: 431
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkUpdater.getResFileList(int):java.lang.String[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0182 A[SYNTHETIC, Splitter:B:75:0x0182] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0187 A[SYNTHETIC, Splitter:B:78:0x0187] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018c A[SYNTHETIC, Splitter:B:81:0x018c] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bc A[SYNTHETIC, Splitter:B:93:0x01bc] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01c1 A[SYNTHETIC, Splitter:B:96:0x01c1] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c6 A[SYNTHETIC, Splitter:B:99:0x01c6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkExtractResFileLengtgAndMd5(java.lang.String r11, java.lang.String r12, int r13) {
        /*
        // Method dump skipped, instructions count: 515
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkUpdater.checkExtractResFileLengtgAndMd5(java.lang.String, java.lang.String, int):boolean");
    }

    public static boolean onDoPatch(String str, int i2, int i3) {
        AppMethodBeat.i(155034);
        Log.i(TAG, "onDoPatch:" + str + ",currentVersion:" + i2 + ",newVersion:" + i3);
        if (!new File(str).exists()) {
            Log.e(TAG, "onDoPatch no patch zip file");
            AppMethodBeat.o(155034);
            return false;
        } else if (!XWalkDecompressor.decompressDownloadPatchZip(str, XWalkEnvironment.getPatchZipTempDecompressPath(i3))) {
            Log.e(TAG, "onDoPatch decompress zip error");
            h.OQ(37);
            AppMethodBeat.o(155034);
            return false;
        } else {
            ArrayList<PatchFileConfig> patchFileConfigList = PatchFileConfigParser.getPatchFileConfigList(i3);
            if (patchFileConfigList == null) {
                Log.e(TAG, "onDoPatch patchFileConfigList = null");
                h.OQ(38);
                AppMethodBeat.o(155034);
                return false;
            } else if (!com.tencent.xweb.util.c.og(XWalkEnvironment.getExtractedCoreDir(i2), XWalkEnvironment.getExtractedCoreDir(i3))) {
                Log.e(TAG, "onDoPatch copy all extraced file error");
                h.OQ(39);
                AppMethodBeat.o(155034);
                return false;
            } else {
                Log.i(TAG, "onDoPatch copy all extraced file finished");
                ArrayList arrayList = new ArrayList();
                Iterator<PatchFileConfig> it = patchFileConfigList.iterator();
                while (it.hasNext()) {
                    PatchFileConfig next = it.next();
                    if (next.isTypeAdd()) {
                        arrayList.add(next);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    PatchFileConfig patchFileConfig = (PatchFileConfig) it2.next();
                    if (!com.tencent.xweb.util.c.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(i3, patchFileConfig.originalFileName), XWalkEnvironment.getExtractedCoreFile(i3, patchFileConfig.originalFileName))) {
                        Log.e(TAG, "onDoPatch add file error:".concat(String.valueOf(patchFileConfig)));
                        h.OQ(40);
                        AppMethodBeat.o(155034);
                        return false;
                    }
                    Log.i(TAG, "onDoPatch add file:".concat(String.valueOf(patchFileConfig)));
                }
                Log.i(TAG, "onDoPatch add file finished");
                ArrayList arrayList2 = new ArrayList();
                Iterator<PatchFileConfig> it3 = patchFileConfigList.iterator();
                while (it3.hasNext()) {
                    PatchFileConfig next2 = it3.next();
                    if (next2.isTypeRemove()) {
                        arrayList2.add(next2);
                    }
                }
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    PatchFileConfig patchFileConfig2 = (PatchFileConfig) it4.next();
                    if (!com.tencent.xweb.util.c.deleteFile(XWalkEnvironment.getExtractedCoreFile(i3, patchFileConfig2.originalFileName))) {
                        Log.e(TAG, "onDoPatch delete file error:".concat(String.valueOf(patchFileConfig2)));
                        h.OQ(41);
                    } else {
                        Log.i(TAG, "onDoPatch delete file:".concat(String.valueOf(patchFileConfig2)));
                    }
                }
                Log.i(TAG, "onDoPatch remove file finished");
                ArrayList arrayList3 = new ArrayList();
                Iterator<PatchFileConfig> it5 = patchFileConfigList.iterator();
                while (it5.hasNext()) {
                    PatchFileConfig next3 = it5.next();
                    if (next3.isTypeModify()) {
                        arrayList3.add(next3);
                    }
                }
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    PatchFileConfig patchFileConfig3 = (PatchFileConfig) it6.next();
                    if (patchFileConfig3.isExtractedFile()) {
                        if (BSpatch.bv(XWalkEnvironment.getExtractedCoreFile(i3, patchFileConfig3.originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(i3, patchFileConfig3.patchFileName), XWalkEnvironment.getExtractedCoreFile(i3, patchFileConfig3.originalFileName)) < 0) {
                            Log.e(TAG, "onDoPatch patch error file:".concat(String.valueOf(patchFileConfig3)));
                            AppMethodBeat.o(155034);
                            return false;
                        }
                        Log.i(TAG, "onDoPatch patch file finished");
                    }
                }
                Log.i(TAG, "onDoPatch patch file finished");
                Iterator it7 = arrayList3.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        break;
                    }
                    PatchFileConfig patchFileConfig4 = (PatchFileConfig) it7.next();
                    if (patchFileConfig4.isOriginalFileTypeApk()) {
                        if (BSpatch.bv(XWalkEnvironment.getDownloadApkPath(i2), XWalkEnvironment.getPatchZipTempDecompressFilePath(i3, patchFileConfig4.patchFileName), XWalkEnvironment.getDownloadApkPath(i3)) < 0) {
                            Log.e(TAG, "onDoPatch apk patch error file:".concat(String.valueOf(patchFileConfig4)));
                            AppMethodBeat.o(155034);
                            return false;
                        }
                    }
                }
                Log.i(TAG, "onDoPatch apk patch finished");
                AppMethodBeat.o(155034);
                return true;
            }
        }
    }

    private boolean verifyDownloadedXWalkRuntime(String str) {
        AppMethodBeat.i(155035);
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            Log.e(TAG, "The downloaded XWalkRuntimeLib.apk is invalid!");
            AppMethodBeat.o(155035);
            return false;
        }
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
            if (packageArchiveInfo.signatures == null || packageInfo.signatures == null) {
                Log.e(TAG, "No signature in package info");
                AppMethodBeat.o(155035);
                return false;
            } else if (packageArchiveInfo.signatures.length != packageInfo.signatures.length) {
                Log.e(TAG, "signatures length not equal");
                AppMethodBeat.o(155035);
                return false;
            } else {
                for (int i2 = 0; i2 < packageArchiveInfo.signatures.length; i2++) {
                    Log.d(TAG, "Checking signature ".concat(String.valueOf(i2)));
                    if (!packageInfo.signatures[i2].equals(packageArchiveInfo.signatures[i2])) {
                        Log.e(TAG, "signatures do not match");
                        AppMethodBeat.o(155035);
                        return false;
                    }
                }
                Log.d(TAG, "Signature check passed");
                AppMethodBeat.o(155035);
                return true;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(155035);
            return false;
        }
    }

    public static class PatchFileConfig {
        public String originalFileName;
        public int originalFileType;
        public String patchEndFileMd5;
        public String patchFileName;
        public int type;

        public boolean isTypeAdd() {
            return this.type == 1;
        }

        public boolean isTypeModify() {
            return this.type == 2;
        }

        public boolean isTypeRemove() {
            return this.type == 3;
        }

        public boolean isOriginalFileTypeApk() {
            return this.originalFileType == 1;
        }

        public boolean isExtractedFile() {
            return this.originalFileType == 2;
        }

        public String toString() {
            AppMethodBeat.i(155013);
            String str = "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
            AppMethodBeat.o(155013);
            return str;
        }
    }

    public static class UpdateConfig {
        public String abi;
        public boolean alreadyUnZiped;
        public int apkVer;
        public boolean bTryUseSharedCore;
        public boolean bUseCdn;
        public String downUrl;
        public String downloadFileMd5;
        public boolean isMatchMd5;
        public boolean isPatchUpdate;
        public int nPatchTargetVersion;
        public String patchEndFileMd5;
        public Scheduler scheduler;
        public String versionDetail;

        private UpdateConfig(int i2, String str, String str2) {
            this.apkVer = -1;
            this.apkVer = i2;
            this.abi = str;
            this.versionDetail = str2;
        }

        public static UpdateConfig createTempConfig(int i2, String str, String str2) {
            AppMethodBeat.i(207397);
            UpdateConfig updateConfig = new UpdateConfig(i2, str, str2);
            AppMethodBeat.o(207397);
            return updateConfig;
        }

        public UpdateConfig(String str, boolean z, int i2, String str2, int i3) {
            AppMethodBeat.i(207398);
            this.apkVer = -1;
            this.isMatchMd5 = false;
            this.isPatchUpdate = z;
            this.downUrl = str;
            this.apkVer = i2;
            this.abi = str2;
            this.nPatchTargetVersion = i3;
            if (!checkValid()) {
                RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
                AppMethodBeat.o(207398);
                throw runtimeException;
            }
            AppMethodBeat.o(207398);
        }

        public UpdateConfig(String str, boolean z, String str2, String str3, int i2, String str4, int i3) {
            AppMethodBeat.i(207399);
            this.apkVer = -1;
            this.isMatchMd5 = true;
            this.downloadFileMd5 = str;
            this.isPatchUpdate = z;
            this.patchEndFileMd5 = str2;
            this.downUrl = str3;
            this.apkVer = i2;
            this.abi = str4;
            this.nPatchTargetVersion = i3;
            if (!checkValid()) {
                RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
                AppMethodBeat.o(207399);
                throw runtimeException;
            }
            AppMethodBeat.o(207399);
        }

        public String getDownloadPath() {
            AppMethodBeat.i(155017);
            if (!checkValid()) {
                RuntimeException runtimeException = new RuntimeException("royle:UpdateConfig is not valid");
                AppMethodBeat.o(155017);
                throw runtimeException;
            } else if (this.isPatchUpdate) {
                String downloadPatchPath = XWalkEnvironment.getDownloadPatchPath(this.apkVer);
                AppMethodBeat.o(155017);
                return downloadPatchPath;
            } else {
                String downloadZipDir = XWalkEnvironment.getDownloadZipDir(this.apkVer);
                AppMethodBeat.o(155017);
                return downloadZipDir;
            }
        }

        public int getUpdateBizType() {
            if (this.isPatchUpdate) {
                return 2;
            }
            return 1;
        }

        public boolean checkValid() {
            AppMethodBeat.i(155018);
            if (this.isMatchMd5 && (this.downloadFileMd5 == null || this.downloadFileMd5.isEmpty())) {
                AppMethodBeat.o(155018);
                return false;
            } else if (this.downUrl == null || this.downUrl.isEmpty()) {
                AppMethodBeat.o(155018);
                return false;
            } else if (this.apkVer == -1) {
                AppMethodBeat.o(155018);
                return false;
            } else if (!this.isMatchMd5 || !this.isPatchUpdate || (this.patchEndFileMd5 != null && !this.patchEndFileMd5.isEmpty())) {
                AppMethodBeat.o(155018);
                return true;
            } else {
                AppMethodBeat.o(155018);
                return false;
            }
        }

        public String getLogSelf() {
            AppMethodBeat.i(155019);
            if (checkValid()) {
                String str = "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",useCDN:" + this.bUseCdn + ",downloadPath:" + getDownloadPath() + ".";
                AppMethodBeat.o(155019);
                return str;
            }
            AppMethodBeat.o(155019);
            return "UpdateConfig is not valid";
        }
    }

    public static abstract class EmbededUpdateConfig extends UpdateConfig {
        boolean isCopySuc = false;

        public abstract boolean copyPackageToLocal(String str, String str2);

        public boolean copySuc() {
            return this.isCopySuc;
        }

        public EmbededUpdateConfig(int i2, String str, String str2) {
            super("", false, i2, XWalkEnvironment.getRuntimeAbi(), 0);
            this.isCopySuc = copyPackageToLocal(str, str2);
        }

        @Override // org.xwalk.core.XWalkUpdater.UpdateConfig
        public boolean checkValid() {
            return this.apkVer > 0;
        }

        @Override // org.xwalk.core.XWalkUpdater.UpdateConfig
        public String getDownloadPath() {
            return super.getDownloadPath();
        }
    }

    public static class AssetsUpdateConfig extends EmbededUpdateConfig {
        public AssetsUpdateConfig(int i2, String str, String str2) {
            super(i2, str, str2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[SYNTHETIC, Splitter:B:16:0x004a] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[SYNTHETIC, Splitter:B:19:0x004f] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC, Splitter:B:32:0x006b] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[SYNTHETIC, Splitter:B:35:0x0070] */
        @Override // org.xwalk.core.XWalkUpdater.EmbededUpdateConfig
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean copyPackageToLocal(java.lang.String r9, java.lang.String r10) {
            /*
            // Method dump skipped, instructions count: 143
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkUpdater.AssetsUpdateConfig.copyPackageToLocal(java.lang.String, java.lang.String):boolean");
        }
    }

    public static class HybridUpdateConfig extends EmbededUpdateConfig {
        public HybridUpdateConfig(int i2, String str, String str2) {
            super(i2, str, str2);
            this.alreadyUnZiped = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A[SYNTHETIC, Splitter:B:17:0x0066] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[SYNTHETIC, Splitter:B:20:0x006b] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6 A[SYNTHETIC, Splitter:B:35:0x00d6] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00db A[SYNTHETIC, Splitter:B:38:0x00db] */
        @Override // org.xwalk.core.XWalkUpdater.EmbededUpdateConfig
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean copyPackageToLocal(java.lang.String r14, java.lang.String r15) {
            /*
            // Method dump skipped, instructions count: 613
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkUpdater.HybridUpdateConfig.copyPackageToLocal(java.lang.String, java.lang.String):boolean");
        }
    }

    public static class LibUpdateConfig extends EmbededUpdateConfig {
        public LibUpdateConfig(int i2, String str, String str2) {
            super(i2, str, str2);
        }

        @Override // org.xwalk.core.XWalkUpdater.EmbededUpdateConfig
        public boolean copyPackageToLocal(String str, String str2) {
            AppMethodBeat.i(207396);
            String str3 = ai.hti() + File.separator + str;
            File file = new File(str3);
            File file2 = new File(getDownloadPath());
            if (file2.exists()) {
                if (d.oi(file2.getAbsolutePath(), str2)) {
                    XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file and md5 matched");
                    AppMethodBeat.o(207396);
                    return true;
                }
                XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file but md5 not matched");
                file2.delete();
            }
            if (!file.exists()) {
                h.s(903, 129, 1);
                XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file not find:".concat(String.valueOf(str3)));
                AppMethodBeat.o(207396);
                return false;
            }
            if (!d.oi(file.getAbsolutePath(), str2)) {
                h.s(903, 130, 1);
                XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file MD5 not match");
            }
            if (!com.tencent.xweb.util.c.g(file, file2)) {
                h.s(903, 131, 1);
                XWalkEnvironment.addXWalkInitializeLog("lib_installer", " copy file failed");
                AppMethodBeat.o(207396);
                return false;
            }
            AppMethodBeat.o(207396);
            return true;
        }
    }

    public static class PatchFileConfigParser {
        private static final String ADD_FLAG = "ADD:";
        private static final int ADD_TYPE = 1;
        private static final int APK_FILE_TYPE = 1;
        private static final String DEL_FLAG = "DEL:";
        private static final int DEL_TYPE = 3;
        private static final int EXTRACTED_FILE_TYPE = 2;
        private static final String MOD_FLAG = "MOD:";
        private static final int MOD_TYPE = 2;
        private static final String PATCH_SUFFIX = ".patch";

        public static ArrayList<PatchFileConfig> getPatchFileConfigList(int i2) {
            BufferedReader bufferedReader;
            InputStreamReader inputStreamReader;
            FileInputStream fileInputStream;
            Throwable th;
            int i3;
            AppMethodBeat.i(155014);
            try {
                fileInputStream = new FileInputStream(new File(XWalkEnvironment.getPatchConfig(i2)));
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    inputStreamReader = null;
                    try {
                        Log.e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                        com.tencent.xweb.util.c.tryClose(fileInputStream);
                        com.tencent.xweb.util.c.tryClose(inputStreamReader);
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        AppMethodBeat.o(155014);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.tencent.xweb.util.c.tryClose(fileInputStream);
                        com.tencent.xweb.util.c.tryClose(inputStreamReader);
                        com.tencent.xweb.util.c.tryClose(bufferedReader);
                        AppMethodBeat.o(155014);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    inputStreamReader = null;
                    com.tencent.xweb.util.c.tryClose(fileInputStream);
                    com.tencent.xweb.util.c.tryClose(inputStreamReader);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    AppMethodBeat.o(155014);
                    throw th;
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    Log.e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                    com.tencent.xweb.util.c.tryClose(fileInputStream);
                    com.tencent.xweb.util.c.tryClose(inputStreamReader);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    AppMethodBeat.o(155014);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    com.tencent.xweb.util.c.tryClose(fileInputStream);
                    com.tencent.xweb.util.c.tryClose(inputStreamReader);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    AppMethodBeat.o(155014);
                    throw th;
                }
                try {
                    ArrayList<PatchFileConfig> arrayList = new ArrayList<>();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            com.tencent.xweb.util.c.tryClose(fileInputStream);
                            com.tencent.xweb.util.c.tryClose(inputStreamReader);
                            com.tencent.xweb.util.c.tryClose(bufferedReader);
                            AppMethodBeat.o(155014);
                            return arrayList;
                        } else if (readLine != null && !readLine.isEmpty()) {
                            if (readLine.startsWith(ADD_FLAG)) {
                                readLine = readLine.substring(4);
                                i3 = 1;
                            } else if (readLine.startsWith(MOD_FLAG)) {
                                readLine = readLine.substring(4);
                                i3 = 2;
                            } else if (readLine.startsWith(DEL_FLAG)) {
                                readLine = readLine.substring(4);
                                i3 = 3;
                            } else {
                                i3 = 0;
                            }
                            String[] split = readLine.split(",");
                            for (String str : split) {
                                if (str != null && !str.isEmpty()) {
                                    PatchFileConfig patchFileConfig = new PatchFileConfig();
                                    patchFileConfig.originalFileName = str;
                                    patchFileConfig.type = i3;
                                    if (i3 == 2) {
                                        patchFileConfig.patchFileName = patchFileConfig.originalFileName + PATCH_SUFFIX;
                                    }
                                    if (i3 != 2 || !patchFileConfig.originalFileName.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                                        patchFileConfig.originalFileType = 2;
                                    } else {
                                        patchFileConfig.originalFileType = 1;
                                    }
                                    Log.d(XWalkUpdater.TAG, "getPatchFileConfigList config:" + patchFileConfig.toString());
                                    arrayList.add(patchFileConfig);
                                }
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                    com.tencent.xweb.util.c.tryClose(fileInputStream);
                    com.tencent.xweb.util.c.tryClose(inputStreamReader);
                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                    AppMethodBeat.o(155014);
                    return null;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
                Log.e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                com.tencent.xweb.util.c.tryClose(fileInputStream);
                com.tencent.xweb.util.c.tryClose(inputStreamReader);
                com.tencent.xweb.util.c.tryClose(bufferedReader);
                AppMethodBeat.o(155014);
                return null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.xweb.util.c.tryClose(fileInputStream);
                com.tencent.xweb.util.c.tryClose(inputStreamReader);
                com.tencent.xweb.util.c.tryClose(bufferedReader);
                AppMethodBeat.o(155014);
                throw th;
            }
        }
    }

    public static class FileListMD5Checker {
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0107 A[SYNTHETIC, Splitter:B:62:0x0107] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x010c A[SYNTHETIC, Splitter:B:65:0x010c] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0111 A[SYNTHETIC, Splitter:B:68:0x0111] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0140 A[SYNTHETIC, Splitter:B:80:0x0140] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0145 A[SYNTHETIC, Splitter:B:83:0x0145] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x014a A[SYNTHETIC, Splitter:B:86:0x014a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean checkFileListMd5(int r9, java.io.File r10) {
            /*
            // Method dump skipped, instructions count: 391
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkUpdater.FileListMD5Checker.checkFileListMd5(int, java.io.File):boolean");
        }

        public static boolean checkFileListMd5(int i2, String str) {
            AppMethodBeat.i(155011);
            try {
                boolean checkFileListMd5 = checkFileListMd5(i2, new File(str));
                AppMethodBeat.o(155011);
                return checkFileListMd5;
            } catch (Exception e2) {
                Log.e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e2.getMessage());
                AppMethodBeat.o(155011);
                return false;
            }
        }

        private static boolean checkFileMd5(int i2, String str, String str2) {
            String extractedCoreFile;
            AppMethodBeat.i(155012);
            if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(str)) {
                extractedCoreFile = XWalkEnvironment.getDownloadApkPath(i2);
            } else {
                extractedCoreFile = XWalkEnvironment.getExtractedCoreFile(i2, str);
            }
            if (d.oi(extractedCoreFile, str2)) {
                Log.i(XWalkUpdater.TAG, "checkFileMd5 successful path:".concat(String.valueOf(extractedCoreFile)));
                AppMethodBeat.o(155012);
                return true;
            }
            Log.e(XWalkUpdater.TAG, "checkFileMd5 error path:".concat(String.valueOf(extractedCoreFile)));
            AppMethodBeat.o(155012);
            return false;
        }
    }
}
