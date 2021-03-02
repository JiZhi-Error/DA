package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.downloader.c;
import java.io.File;
import org.xwalk.core.XWalkUpdater;

public class XWalkLibraryLoader {
    private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
    private static final int DOWNLOAD_TYPE_CDN = 2;
    private static final int DOWNLOAD_TYPE_HTTP = 1;
    private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
    private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
    private static final int ERROR_CODE_EXCEPTION = -101;
    private static final int ERROR_CODE_FAILED = -1;
    private static final int ERROR_CODE_SUCCESS = 0;
    private static final int ERROR_TYPE_DOWNLOADER = 1;
    private static final int ERROR_TYPE_NONE = 0;
    private static final int ERROR_TYPE_USER = 2;
    private static final String TAG = "XWalkLib";
    private static AsyncTask<Void, Integer, Integer> sActiveTask;

    public interface ActivateListener {
        void onActivateCompleted();

        void onActivateFailed();

        void onActivateStarted();
    }

    public interface DecompressListener {
        void onDecompressCancelled();

        void onDecompressCompleted();

        void onDecompressStarted();
    }

    public static class DownloadInfo {
        public int mBizType = 0;
        public int mDownloadType = 1;
        public int mErrorCode = 0;
        public int mErrorType = 0;
        public long mFileTotalSize = 0;
        public boolean mIsDownloadResume = false;
        public boolean mIsRuntime = false;
        public int mNetWorkType = 0;
        public int mRetryTimes = 0;
        public String mSavePath = "";
        public long mStartTimestamp = 0;
        public String mUrl = "";
    }

    public interface DownloadListener {
        void onDownloadCancelled();

        void onDownloadCompleted(DownloadInfo downloadInfo);

        void onDownloadFailed(DownloadInfo downloadInfo);

        void onDownloadStarted(int i2);

        void onDownloadUpdated(int i2);
    }

    public static boolean isInitializing() {
        return false;
    }

    public static boolean isDownloading() {
        return sActiveTask != null && (sActiveTask instanceof HttpDownloadTask);
    }

    public static boolean isSharedLibrary() {
        AppMethodBeat.i(154790);
        boolean isSharedMode = XWalkCoreWrapper.getInstance().isSharedMode();
        AppMethodBeat.o(154790);
        return isSharedMode;
    }

    public static boolean isLibraryReady() {
        AppMethodBeat.i(154791);
        if (XWalkCoreWrapper.getInstance() != null) {
            AppMethodBeat.o(154791);
            return true;
        }
        AppMethodBeat.o(154791);
        return false;
    }

    public static int getLibraryStatus() {
        AppMethodBeat.i(154792);
        int coreStatus = XWalkCoreWrapper.getCoreStatus();
        AppMethodBeat.o(154792);
        return coreStatus;
    }

    public static void prepareToInit(Context context) {
        AppMethodBeat.i(154793);
        XWalkEnvironment.init(context);
        XWalkCoreWrapper.handlePreInit(context.getClass().getName());
        AppMethodBeat.o(154793);
    }

    public static void finishInit(Context context) {
        AppMethodBeat.i(154794);
        XWalkCoreWrapper.handlePostInit(context.getClass().getName());
        AppMethodBeat.o(154794);
    }

    public static void startHttpDownload(DownloadListener downloadListener, Context context, XWalkUpdater.UpdateConfig updateConfig) {
        AppMethodBeat.i(154795);
        WXFileDownloaderTask wXFileDownloaderTask = new WXFileDownloaderTask(true, downloadListener, updateConfig.downUrl, updateConfig.getDownloadPath(), updateConfig.getUpdateBizType());
        if (!updateConfig.bUseCdn || !wXFileDownloaderTask.isValid()) {
            Log.i(TAG, "use default file downloader");
            new HttpDownloadTask(true, downloadListener, updateConfig.downUrl, updateConfig.getDownloadPath()).execute(new Void[0]);
            AppMethodBeat.o(154795);
            return;
        }
        Log.i(TAG, "use wx file downloader");
        wXFileDownloaderTask.execute(new Void[0]);
        AppMethodBeat.o(154795);
    }

    public static boolean cancelHttpDownload() {
        AppMethodBeat.i(154796);
        if (sActiveTask == null || !(sActiveTask instanceof HttpDownloadTask) || !sActiveTask.cancel(true)) {
            AppMethodBeat.o(154796);
            return false;
        }
        AppMethodBeat.o(154796);
        return true;
    }

    public static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
        private DownloadInfo mDownloadInfo = new DownloadInfo();
        private File mDownloadedFile;
        private DownloadListener mListener;
        private long mProgressUpdateTime;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Integer doInBackground(Void[] voidArr) {
            AppMethodBeat.i(154775);
            Integer doInBackground = doInBackground(voidArr);
            AppMethodBeat.o(154775);
            return doInBackground;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Integer num) {
            AppMethodBeat.i(154772);
            onCancelled(num);
            AppMethodBeat.o(154772);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Integer num) {
            AppMethodBeat.i(154774);
            onPostExecute(num);
            AppMethodBeat.o(154774);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] numArr) {
            AppMethodBeat.i(154773);
            onProgressUpdate(numArr);
            AppMethodBeat.o(154773);
        }

        public HttpDownloadTask(boolean z, DownloadListener downloadListener, String str, String str2) {
            AppMethodBeat.i(154766);
            this.mListener = downloadListener;
            this.mDownloadInfo.mErrorType = 0;
            this.mDownloadInfo.mErrorCode = 0;
            this.mDownloadInfo.mDownloadType = 1;
            this.mDownloadInfo.mUrl = str;
            this.mDownloadInfo.mSavePath = str2;
            this.mDownloadInfo.mIsRuntime = z;
            AppMethodBeat.o(154766);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            AppMethodBeat.i(154767);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
            }
            this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
            AppMethodBeat.o(154767);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0239, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x023a, code lost:
            r7 = r2;
            r8 = null;
            r6 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x026b, code lost:
            r6 = null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01f9 A[SYNTHETIC, Splitter:B:61:0x01f9] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x01fe A[Catch:{ IOException -> 0x0268 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0203  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x023f A[SYNTHETIC, Splitter:B:79:0x023f] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0244 A[Catch:{ IOException -> 0x0253 }] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0249  */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x026a A[ExcHandler: Exception (e java.lang.Exception), PHI: r3 
          PHI: (r3v4 java.net.HttpURLConnection) = (r3v3 java.net.HttpURLConnection), (r3v3 java.net.HttpURLConnection), (r3v16 java.net.HttpURLConnection), (r3v16 java.net.HttpURLConnection) binds: [B:1:0x0030, B:2:?, B:33:0x017e, B:34:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0030] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Integer doInBackground(java.lang.Void... r19) {
            /*
            // Method dump skipped, instructions count: 637
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... numArr) {
            int i2 = 0;
            AppMethodBeat.i(154769);
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask updated: " + numArr[0] + FilePathGenerator.ANDROID_DIR_SEP + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i2 = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i2);
            AppMethodBeat.o(154769);
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Integer num) {
            AppMethodBeat.i(154770);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onCancelled: " + this.mDownloadInfo.mSavePath);
            }
            this.mListener.onDownloadCancelled();
            AppMethodBeat.o(154770);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            AppMethodBeat.i(154771);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask runtime onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            } else {
                Log.i(XWalkLibraryLoader.TAG, "HttpDownloadTask other onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            }
            if (num.intValue() == 0) {
                this.mDownloadInfo.mErrorCode = 0;
                this.mListener.onDownloadCompleted(this.mDownloadInfo);
                AppMethodBeat.o(154771);
                return;
            }
            this.mDownloadInfo.mErrorCode = -1;
            this.mListener.onDownloadFailed(this.mDownloadInfo);
            AppMethodBeat.o(154771);
        }
    }

    public static class WXFileDownloaderTask extends AsyncTask<Void, Integer, Integer> implements c {
        private static final int DOWNLOAD_FAILED = -1;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int UPDATE_INTERVAL_MS = 500;
        private final Object lockObj = new Object();
        private DownloadInfo mDownloadInfo;
        private DownloadListener mListener;
        private long mProgressUpdateTime = 0;
        private WXFileDownloaderBridge mWXFileDownloaderBridge = null;
        private boolean mWaitTimeout = false;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Integer doInBackground(Void[] voidArr) {
            AppMethodBeat.i(154789);
            Integer doInBackground = doInBackground(voidArr);
            AppMethodBeat.o(154789);
            return doInBackground;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Integer num) {
            AppMethodBeat.i(154786);
            onCancelled(num);
            AppMethodBeat.o(154786);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Integer num) {
            AppMethodBeat.i(154788);
            onPostExecute(num);
            AppMethodBeat.o(154788);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onProgressUpdate(Integer[] numArr) {
            AppMethodBeat.i(154787);
            onProgressUpdate(numArr);
            AppMethodBeat.o(154787);
        }

        public boolean isValid() {
            AppMethodBeat.i(154776);
            if (this.mWXFileDownloaderBridge == null) {
                AppMethodBeat.o(154776);
                return false;
            }
            boolean isValid = WXFileDownloaderBridge.isValid();
            AppMethodBeat.o(154776);
            return isValid;
        }

        public WXFileDownloaderTask(boolean z, DownloadListener downloadListener, String str, String str2, int i2) {
            AppMethodBeat.i(154777);
            this.mListener = downloadListener;
            this.mDownloadInfo = new DownloadInfo();
            this.mDownloadInfo.mErrorType = 0;
            this.mDownloadInfo.mErrorCode = 0;
            this.mDownloadInfo.mDownloadType = 2;
            this.mDownloadInfo.mUrl = str;
            this.mDownloadInfo.mSavePath = str2;
            this.mDownloadInfo.mIsRuntime = z;
            this.mDownloadInfo.mBizType = i2;
            this.mWXFileDownloaderBridge = new WXFileDownloaderBridge();
            this.mWXFileDownloaderBridge.SAY = this;
            AppMethodBeat.o(154777);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            AppMethodBeat.i(154778);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
                Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
                AppMethodBeat.o(154778);
                return;
            }
            Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
            AppMethodBeat.o(154778);
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            int i2;
            AppMethodBeat.i(154779);
            this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
            this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
            this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
            if (this.mWXFileDownloaderBridge == null || !WXFileDownloaderBridge.isValid()) {
                this.mDownloadInfo.mErrorType = 2;
                this.mDownloadInfo.mErrorCode = -1;
                AppMethodBeat.o(154779);
                return -1;
            }
            WXFileDownloaderBridge wXFileDownloaderBridge = this.mWXFileDownloaderBridge;
            String str = this.mDownloadInfo.mUrl;
            String str2 = this.mDownloadInfo.mSavePath;
            if (WXFileDownloaderBridge.SAX != null) {
                i2 = WXFileDownloaderBridge.SAX.a(str, str2, wXFileDownloaderBridge);
            } else {
                i2 = -1;
            }
            if (i2 != 0) {
                this.mDownloadInfo.mErrorType = 1;
                this.mDownloadInfo.mErrorCode = -1;
                AppMethodBeat.o(154779);
                return -1;
            }
            synchronized (this.lockObj) {
                try {
                    this.mWaitTimeout = true;
                    this.lockObj.wait(600000);
                } catch (InterruptedException e2) {
                    this.mWaitTimeout = false;
                    this.mDownloadInfo.mErrorType = 2;
                    this.mDownloadInfo.mErrorCode = -101;
                }
                try {
                    if (this.mWaitTimeout) {
                        this.mDownloadInfo.mErrorType = 1;
                        this.mDownloadInfo.mErrorCode = -100;
                    }
                    if (this.mDownloadInfo.mErrorType == 0 && this.mDownloadInfo.mErrorCode == 0) {
                        return 0;
                    }
                    Log.e(XWalkLibraryLoader.TAG, "download errortype:" + this.mDownloadInfo.mErrorType + ", errorcode:" + this.mDownloadInfo.mErrorCode + ", waitTimeout:" + this.mWaitTimeout);
                    AppMethodBeat.o(154779);
                    return -1;
                } finally {
                    AppMethodBeat.o(154779);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... numArr) {
            int i2 = 0;
            AppMethodBeat.i(154780);
            Log.d(XWalkLibraryLoader.TAG, "WXFileDownloaderTask updated: " + numArr[0] + FilePathGenerator.ANDROID_DIR_SEP + numArr[1]);
            if (numArr[1].intValue() > 0) {
                i2 = (int) ((((double) numArr[0].intValue()) * 100.0d) / ((double) numArr[1].intValue()));
            }
            this.mListener.onDownloadUpdated(i2);
            AppMethodBeat.o(154780);
        }

        /* access modifiers changed from: protected */
        public void onCancelled(Integer num) {
            AppMethodBeat.i(154781);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
                Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
            } else {
                Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onCancelled: " + this.mDownloadInfo.mSavePath);
            }
            this.mListener.onDownloadCancelled();
            AppMethodBeat.o(154781);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            AppMethodBeat.i(154782);
            if (this.mDownloadInfo.mIsRuntime) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
                Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask runtime onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            } else {
                Log.i(XWalkLibraryLoader.TAG, "WXFileDownloaderTask other onPostExecute result " + num + " " + this.mDownloadInfo.mSavePath);
            }
            if (num.intValue() == 0) {
                this.mListener.onDownloadCompleted(this.mDownloadInfo);
                AppMethodBeat.o(154782);
                return;
            }
            this.mListener.onDownloadFailed(this.mDownloadInfo);
            AppMethodBeat.o(154782);
        }

        @Override // com.tencent.xweb.downloader.c
        public void onProgressChange(String str, long j2, long j3) {
            AppMethodBeat.i(154783);
            Log.d(XWalkLibraryLoader.TAG, "url:" + str + ", cur_size:" + j2 + ", total_size:" + j3);
            if (this.mDownloadInfo.mFileTotalSize != j3) {
                this.mDownloadInfo.mFileTotalSize = j3;
            }
            publishProgress(Integer.valueOf((int) j2), Integer.valueOf((int) j3));
            AppMethodBeat.o(154783);
        }

        @Override // com.tencent.xweb.downloader.c
        public void onTaskSucc(String str, String str2, boolean z) {
            AppMethodBeat.i(154784);
            synchronized (this.lockObj) {
                try {
                    this.mDownloadInfo.mIsDownloadResume = z;
                    this.mWaitTimeout = false;
                    this.lockObj.notify();
                } finally {
                    AppMethodBeat.o(154784);
                }
            }
        }

        @Override // com.tencent.xweb.downloader.c
        public void onTaskFail(String str, int i2, boolean z) {
            AppMethodBeat.i(154785);
            synchronized (this.lockObj) {
                try {
                    this.mDownloadInfo.mErrorType = 1;
                    this.mDownloadInfo.mErrorCode = i2;
                    this.mDownloadInfo.mIsDownloadResume = z;
                    this.mWaitTimeout = false;
                    this.lockObj.notify();
                } finally {
                    AppMethodBeat.o(154785);
                }
            }
        }
    }
}
