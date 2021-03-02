package com.tencent.tmassistantsdk.downloadservice;

import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DownloadTask {
    public static final String TAG = "_DownloadTask";
    protected DownloadInfo mDownloadInfo = null;
    HttpClient mHttpClient = null;
    HttpGet mHttpGet = null;
    private boolean mIsRedirect = false;
    protected final byte[] mRecvBuf = new byte[4096];
    private String mRequestUrl;
    TMAssistantFile mSaveFile;
    protected boolean mStopTask = false;
    protected final int mTaskId = GlobalUtil.getMemUUID();
    private String startDownloadNetType = "wifi";

    static /* synthetic */ void access$000(DownloadTask downloadTask) {
        AppMethodBeat.i(102002);
        downloadTask.cancelInWorkThread();
        AppMethodBeat.o(102002);
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        AppMethodBeat.i(101990);
        this.mDownloadInfo = downloadInfo;
        AppMethodBeat.o(101990);
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void cancel() {
        AppMethodBeat.i(101991);
        TMLog.i(TAG, "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            p.post(new Runnable() {
                /* class com.tencent.tmassistantsdk.downloadservice.DownloadTask.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(101989);
                    DownloadTask.access$000(DownloadTask.this);
                    AppMethodBeat.o(101989);
                }
            });
            AppMethodBeat.o(101991);
            return;
        }
        cancelInWorkThread();
        AppMethodBeat.o(101991);
    }

    private void cancelInWorkThread() {
        AppMethodBeat.i(101992);
        this.mStopTask = true;
        if (this.mHttpGet != null && !this.mHttpGet.isAborted()) {
            this.mHttpGet.abort();
        }
        AppMethodBeat.o(101992);
    }

    public String getDownloadURI() {
        return this.mDownloadInfo.mURL;
    }

    public int getPriority() {
        return this.mDownloadInfo.mPriority;
    }

    public void exec(String str) {
        boolean z;
        boolean z2;
        String str2;
        AppMethodBeat.i(101993);
        this.startDownloadNetType = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mTaskIsRunning = true;
        this.mDownloadInfo.updateStatus(2, false);
        boolean z3 = false;
        boolean z4 = true;
        while (z4) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 0);
            createNewChunkLogInfo.UUID = this.mDownloadInfo.mUUID;
            createNewChunkLogInfo.currentRetryCnt = (byte) this.mDownloadInfo.mRetryCnt;
            createNewChunkLogInfo.requestUrl = getDownloadURI();
            if (this.mStopTask) {
                break;
            }
            try {
                if (!this.mIsRedirect || this.mRequestUrl == null || this.mRequestUrl.length() == 0) {
                    if (z3) {
                        str2 = c.akX(this.mDownloadInfo.mSecondaryUrl);
                    } else {
                        str2 = c.akX(this.mDownloadInfo.mRequestURL);
                    }
                    this.mRequestUrl = str2;
                } else {
                    str2 = this.mRequestUrl;
                }
                TMLog.i(TAG, "is redirect request: " + this.mIsRedirect);
                TMLog.i(TAG, "changeUrl = ".concat(String.valueOf(z3)));
                TMLog.i(TAG, "url = ".concat(String.valueOf(str2)));
                this.mIsRedirect = false;
                this.mHttpClient = HttpClientUtil.createHttpClient();
                HttpClientUtil.setProxy(this.mHttpClient);
                this.mHttpGet = new HttpGet();
                URI uri = new URI(str2);
                this.mHttpGet.setURI(uri);
                setExtraHeaderParam(this.mHttpGet, this.mDownloadInfo.getHeaderParams());
                setRangeHeader(this.mHttpGet, createNewChunkLogInfo);
                if (uri.getScheme().equals("https")) {
                    SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                    socketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                    this.mHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, (int) JsApiPauseDownloadTask.CTRL_INDEX));
                }
                TMLog.i(TAG, "start httpGet " + Thread.currentThread().getName());
                HttpResponse execute = this.mHttpClient.execute(this.mHttpGet);
                if (execute == null) {
                    StopRequestException stopRequestException = new StopRequestException(701, "response is null! " + Thread.currentThread().getName());
                    AppMethodBeat.o(101993);
                    throw stopRequestException;
                }
                handleResponseCode(execute, createNewChunkLogInfo);
                if (!this.mDownloadInfo.hasReceivedAllDataBytes()) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = z;
                }
                z4 = z;
            } catch (ConnectTimeoutException e2) {
                if (this.mStopTask) {
                    z = false;
                } else {
                    TMLog.i(TAG, "ConnectTimeoutException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    z = shouldRetryConnect();
                    if (!z) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 601;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = z;
                }
            } catch (SocketTimeoutException e3) {
                if (this.mStopTask) {
                    z = false;
                } else {
                    TMLog.i(TAG, "SocketTimeoutException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                    z = shouldRetryConnect();
                    if (!z) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 602;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = z;
                }
            } catch (UnknownHostException e4) {
                if (this.mStopTask) {
                    z = false;
                } else {
                    TMLog.i(TAG, "UnknownHostException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e4, "", new Object[0]);
                    z = shouldRetryConnect();
                    if (!z) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 603;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = z;
                }
            } catch (InterruptedException e5) {
                if (!this.mStopTask) {
                    TMLog.i(TAG, "InterruptedException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e5, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = 600;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = false;
                }
                z4 = false;
            } catch (SSLHandshakeException e6) {
                if (!this.mStopTask) {
                    TMLog.i(TAG, "SSLHandshakeException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e6, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = 607;
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = false;
                }
                z4 = false;
            } catch (IOException e7) {
                if (this.mStopTask) {
                    z = false;
                } else {
                    TMLog.i(TAG, "IOException " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e7, "", new Object[0]);
                    z = shouldRetryConnect();
                    if (!z) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 606;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z4 = z;
                }
            } catch (StopRequestException e8) {
                if (this.mStopTask) {
                    z2 = z3;
                    z4 = false;
                } else {
                    TMLog.i(TAG, "StopRequestException, errCode = " + e8.mFinalErrCode + " " + Thread.currentThread().getName());
                    Log.printErrStackTrace(TAG, e8, "", new Object[0]);
                    this.mDownloadInfo.mDownloadFailedErrCode = e8.mFinalErrCode;
                    if (e8.mFinalErrCode == 703 || e8.mFinalErrCode == 710 || e8.mFinalErrCode == 711) {
                        z2 = z3;
                        z4 = false;
                    } else if (704 == e8.mFinalErrCode) {
                        this.mDownloadInfo.setTotalSize(0);
                        new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName).deleteTempFile();
                        z2 = z3;
                        z4 = false;
                    } else if (705 != e8.mFinalErrCode) {
                        z4 = shouldRetryConnect();
                        z2 = z3;
                    } else if (z3 || !this.mDownloadInfo.hasRetryChance() || TextUtils.isEmpty(this.mDownloadInfo.mSecondaryUrl)) {
                        z2 = z3;
                        z4 = false;
                    } else {
                        z2 = true;
                        z4 = true;
                    }
                }
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                    z3 = z2;
                } else {
                    z3 = z2;
                }
            } catch (Throwable th) {
                if (this.mHttpGet != null) {
                    if (!this.mHttpGet.isAborted()) {
                        this.mHttpGet.abort();
                    }
                    this.mHttpGet = null;
                }
                if (this.mHttpClient != null) {
                    this.mHttpClient.getConnectionManager().shutdown();
                    this.mHttpClient = null;
                }
                if (this.mSaveFile != null) {
                    this.mSaveFile.close();
                    this.mSaveFile = null;
                }
                AppMethodBeat.o(101993);
                throw th;
            }
        }
        TMLog.i(TAG, "mStopTask = " + this.mStopTask + " " + Thread.currentThread().getName());
        if (!this.mStopTask) {
            TMLog.i(TAG, "download finished, " + Thread.currentThread().getName() + ",finalstatus: " + this.mDownloadInfo.mStatus + " errCode: " + this.mDownloadInfo.mDownloadFailedErrCode);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                this.mDownloadInfo.updateStatus(4, z3);
            } else {
                this.mDownloadInfo.updateStatus(5, z3);
            }
        } else {
            this.mDownloadInfo.mDownloadFailedErrCode = 0;
        }
        this.mDownloadInfo.mTaskIsRunning = false;
        AppMethodBeat.o(101993);
    }

    private boolean shouldRetryConnect() {
        boolean z = false;
        AppMethodBeat.i(101994);
        if (this.mStopTask) {
            TMLog.i(TAG, "mStopTask = " + this.mStopTask);
            AppMethodBeat.o(101994);
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e2) {
            }
            if (!DownloadHelper.isNetworkConncted()) {
                int i2 = 0;
                while (!DownloadHelper.isNetworkConncted() && i2 < 5) {
                    i2++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
            }
            if (!DownloadHelper.isNetworkConncted()) {
                TMLog.i(TAG, "network unconnected");
                AppMethodBeat.o(101994);
            } else if (DownloadHelper.getNetStatus().equalsIgnoreCase("wifi") || DownloadHelper.getNetStatus().equalsIgnoreCase(this.startDownloadNetType)) {
                if (this.mDownloadInfo.hasRetryChance()) {
                    this.mDownloadInfo.mRetryCnt++;
                    this.mDownloadInfo.mRedirectCnt = 0;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e4) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
                TMLog.i(TAG, "shouldRetryConnect(" + z + "), retryCnt = " + this.mDownloadInfo.mRetryCnt);
                AppMethodBeat.o(101994);
            } else {
                TMLog.i(TAG, "not equal netType, current: " + DownloadHelper.getNetStatus() + ", startNetType: " + this.startDownloadNetType);
                AppMethodBeat.o(101994);
            }
        }
        return z;
    }

    private void onDownloadError(Throwable th) {
        AppMethodBeat.i(101995);
        if (th != null) {
            Log.printErrStackTrace(TAG, th, "", new Object[0]);
        }
        AppMethodBeat.o(101995);
    }

    private void handleResponseCode(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        AppMethodBeat.i(101996);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        TMLog.i(TAG, "httpResponseCode = " + statusCode + " " + Thread.currentThread().getName());
        downloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
        downloadChunkLogInfo.responseHttpCode = statusCode;
        if (statusCode == 200 || statusCode == 206) {
            this.mDownloadInfo.mRetryCnt = 0;
        }
        switch (statusCode) {
            case 200:
                Header[] headers = httpResponse.getHeaders("Content-Type");
                if (headers != null && headers.length > 0) {
                    if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                    } else {
                        String value = headers[0].getValue();
                        if (TextUtils.isEmpty(value) || !value.startsWith("text")) {
                            renameApkFileName(httpResponse);
                        } else {
                            StopRequestException stopRequestException = new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
                            AppMethodBeat.o(101996);
                            throw stopRequestException;
                        }
                    }
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                AppMethodBeat.o(101996);
                return;
            case 206:
                if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                } else {
                    renameApkFileName(httpResponse);
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                AppMethodBeat.o(101996);
                return;
            case 301:
            case 302:
            case 303:
            case TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE:
                if (this.mDownloadInfo.mRedirectCnt > 5) {
                    TMLog.i(TAG, "mRedirectCnt = " + this.mDownloadInfo.mRedirectCnt + ",MAX_REDIRESTS = 5");
                    StopRequestException stopRequestException2 = new StopRequestException(709, "Redirect cnt many times.");
                    AppMethodBeat.o(101996);
                    throw stopRequestException2;
                }
                Header firstHeader = httpResponse.getFirstHeader(FirebaseAnalytics.b.LOCATION);
                if (firstHeader != null) {
                    String value2 = firstHeader.getValue();
                    TMLog.i(TAG, "jumpURL = ".concat(String.valueOf(value2)));
                    if (DownloadHelper.isValidURL(value2)) {
                        this.mRequestUrl = DownloadHelper.correctURL(value2);
                        this.mIsRedirect = true;
                        this.mDownloadInfo.mRedirectCnt++;
                        AppMethodBeat.o(101996);
                        return;
                    }
                    StopRequestException stopRequestException3 = new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + statusCode + " url: " + value2);
                    AppMethodBeat.o(101996);
                    throw stopRequestException3;
                }
                TMLog.e(TAG, "location header is null. httpResponseCode = ".concat(String.valueOf(statusCode)));
                StopRequestException stopRequestException4 = new StopRequestException(702, "location header is null. httpResponseCode = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(101996);
                throw stopRequestException4;
            case 416:
                StopRequestException stopRequestException5 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(101996);
                throw stopRequestException5;
            case 500:
                StopRequestException stopRequestException6 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(101996);
                throw stopRequestException6;
            case 503:
                StopRequestException stopRequestException7 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(101996);
                throw stopRequestException7;
            default:
                StopRequestException stopRequestException8 = new StopRequestException(statusCode, "HTTP response code error, code = ".concat(String.valueOf(statusCode)));
                AppMethodBeat.o(101996);
                throw stopRequestException8;
        }
    }

    private boolean verifyTotalLen(HttpResponse httpResponse, HttpEntity httpEntity) {
        AppMethodBeat.i(101997);
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            long contentLength = httpEntity.getContentLength();
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1 || (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue())) {
                AppMethodBeat.o(101997);
                return false;
            }
        } else if (httpResponse.getStatusLine().getStatusCode() == 206) {
            long totalSize = ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue());
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + totalSize + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (totalSize == -1 || (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && totalSize != this.mDownloadInfo.mRequestFileSize.longValue())) {
                AppMethodBeat.o(101997);
                return false;
            }
        }
        AppMethodBeat.o(101997);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x033f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReceivedResponseData(org.apache.http.HttpResponse r11, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo r12) {
        /*
        // Method dump skipped, instructions count: 1110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadservice.DownloadTask.onReceivedResponseData(org.apache.http.HttpResponse, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo):void");
    }

    private void setRangeHeader(HttpGet httpGet, DownloadChunkLogInfo downloadChunkLogInfo) {
        long j2;
        AppMethodBeat.i(101999);
        String netStatus = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mNetType = netStatus;
        if (TextUtils.isEmpty(netStatus) || (!netStatus.contains("wap") && (!netStatus.contains("net") || this.mDownloadInfo.mRetryCnt <= 0))) {
            String str = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
            httpGet.addHeader("range", str);
            TMLog.d(TAG, "set range header: ".concat(String.valueOf(str)));
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
            downloadChunkLogInfo.requestRanageSize = 0;
            AppMethodBeat.o(101999);
            return;
        }
        try {
            int splitSizeInBytes = DownloadSetting.getSplitSizeInBytes(netStatus);
            long j3 = this.mDownloadInfo.mReceivedBytes;
            if (this.mDownloadInfo.getTotalSize() > 0) {
                j2 = (this.mDownloadInfo.mReceivedBytes + ((long) splitSizeInBytes)) - 1;
                if (j2 >= this.mDownloadInfo.getTotalSize()) {
                    j2 = this.mDownloadInfo.getTotalSize() - 1;
                }
            } else {
                j2 = (long) (splitSizeInBytes - 1);
            }
            String str2 = "bytes=" + j3 + "-" + j2;
            httpGet.addHeader("range", str2);
            TMLog.d(TAG, "set range header: ".concat(String.valueOf(str2)));
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = j3;
            downloadChunkLogInfo.requestRanageSize = (long) splitSizeInBytes;
            AppMethodBeat.o(101999);
        } catch (UnsupportedOperationException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(101999);
        }
    }

    private void renameApkFileName(HttpResponse httpResponse) {
        AppMethodBeat.i(102000);
        if (httpResponse == null) {
            AppMethodBeat.o(102000);
            return;
        }
        if (this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive")) {
            String str = null;
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            if (headers == null || headers.length <= 0) {
                str = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
            } else {
                String value = headers[0].getValue();
                TMLog.i(TAG, "headerFileName = ".concat(String.valueOf(value)));
                if (TextUtils.isEmpty(value) || !value.contains("filename=\"")) {
                    str = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
                } else {
                    String substring = value.substring(value.indexOf("filename=\"") + 10);
                    if (!TextUtils.isEmpty(substring)) {
                        str = substring.substring(0, substring.indexOf("\""));
                        TMLog.i(TAG, "header file Name =".concat(String.valueOf(str)));
                    }
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.mDownloadInfo.mFileName = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(str));
            }
        }
        AppMethodBeat.o(102000);
    }

    private void setExtraHeaderParam(HttpGet httpGet, Map<String, String> map) {
        AppMethodBeat.i(102001);
        if (!(httpGet == null || map == null || map.size() <= 0)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        AppMethodBeat.o(102001);
    }
}
