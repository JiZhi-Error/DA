package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader extends TXIStreamDownloader {
    private final int CONNECT_TIMEOUT;
    private final int FLV_HEAD_SIZE;
    private final int MAX_FRAME_SIZE;
    private final int MSG_CONNECT;
    private final int MSG_DISCONNECT;
    private final int MSG_QUIT;
    private final int MSG_RECONNECT;
    private final int MSG_RECV_DATA;
    private final int MSG_RESUME;
    private final int MSG_SEEK;
    private final int READ_STREAM_SIZE;
    public final String TAG;
    private HttpURLConnection mConnection;
    private long mContentLength;
    private long mCurrentNalTs;
    private long mDownloadedSize;
    private long mFLVParser;
    private Handler mFlvHandler;
    private HandlerThread mFlvThread;
    private boolean mHandleDataInJava;
    private boolean mHasReceivedFirstAudio;
    private boolean mHasReceivedFirstVideo;
    private InputStream mInputStream;
    private long mLastIFramelTs;
    private byte[] mPacketBytes;
    private String mPlayUrl;
    private boolean mRecvData;
    private WeakReference<TXCFLVDownloader> mRefFLVDownloader;
    private TXCStreamDownloader.DownloadStats mStats;
    private boolean mStopJitter;

    private native void nativeCleanData(long j2);

    private native int nativeGetAudioBytes(long j2);

    private native int nativeGetVideoBytes(long j2);

    private native int nativeGetVideoGop(long j2);

    private native long nativeInitFlvHander(String str, int i2, boolean z, boolean z2);

    private native long nativeInitFlvHanderByRef(long j2);

    private native int nativeParseData(long j2, byte[] bArr, int i2);

    private native void nativeUninitFlvhander(long j2, boolean z);

    public native void nativePushAudioFrame(long j2, byte[] bArr, int i2, long j3, int i3);

    public native void nativePushVideoFrame(long j2, byte[] bArr, int i2, long j3, long j4, int i3);

    static /* synthetic */ void access$000(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.i(15331);
        tXCFLVDownloader.processMsgConnect();
        AppMethodBeat.o(15331);
    }

    static /* synthetic */ void access$100(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.i(15332);
        tXCFLVDownloader.processMsgRecvData();
        AppMethodBeat.o(15332);
    }

    static /* synthetic */ void access$200(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.i(15333);
        tXCFLVDownloader.processMsgDisConnect();
        AppMethodBeat.o(15333);
    }

    static /* synthetic */ void access$300(TXCFLVDownloader tXCFLVDownloader) {
        AppMethodBeat.i(15334);
        tXCFLVDownloader.processMsgReconnect();
        AppMethodBeat.o(15334);
    }

    public TXCFLVDownloader(Context context) {
        super(context);
        AppMethodBeat.i(15310);
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 1048576;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mHandleDataInJava = false;
        this.mFLVParser = 0;
        this.mCurrentNalTs = 0;
        this.mLastIFramelTs = 0;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mHasReceivedFirstVideo = false;
        this.mHasReceivedFirstAudio = false;
        this.mStats = null;
        this.mRefFLVDownloader = null;
        this.mStats = new TXCStreamDownloader.DownloadStats();
        this.mStats.afterParseAudioBytes = 0;
        this.mStats.dnsTS = 0;
        this.mStats.startTS = TXCTimeUtil.getTimeTick();
        TXCLog.i("network.TXCFLVDownloader", "new flv download ".concat(String.valueOf(this)));
        AppMethodBeat.o(15310);
    }

    public TXCFLVDownloader(Context context, TXCFLVDownloader tXCFLVDownloader) {
        super(context);
        AppMethodBeat.i(15311);
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = 1048576;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mHandleDataInJava = false;
        this.mFLVParser = 0;
        this.mCurrentNalTs = 0;
        this.mLastIFramelTs = 0;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mHasReceivedFirstVideo = false;
        this.mHasReceivedFirstAudio = false;
        this.mStats = null;
        this.mRefFLVDownloader = null;
        this.mStats = new TXCStreamDownloader.DownloadStats();
        this.mStats.afterParseAudioBytes = 0;
        this.mStats.dnsTS = 0;
        this.mStats.startTS = TXCTimeUtil.getTimeTick();
        this.mRefFLVDownloader = new WeakReference<>(tXCFLVDownloader);
        TXCLog.i("network.TXCFLVDownloader", "new multi flv download ".concat(String.valueOf(this)));
        AppMethodBeat.o(15311);
    }

    public void recvData(boolean z) {
        this.mHandleDataInJava = z;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void PushVideoFrame(byte[] bArr, int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(15312);
        nativePushVideoFrame(this.mFLVParser, bArr, i2, j2, j3, i3);
        AppMethodBeat.o(15312);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void PushAudioFrame(byte[] bArr, int i2, long j2, int i3) {
        AppMethodBeat.i(15313);
        nativePushAudioFrame(this.mFLVParser, bArr, i2, j2, i3);
        AppMethodBeat.o(15313);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public long getCurrentTS() {
        return this.mCurrentNalTs;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public long getLastIFrameTS() {
        return this.mLastIFramelTs;
    }

    private void processMsgConnect() {
        long j2;
        AppMethodBeat.i(15314);
        try {
            connect();
            if (this.mFLVParser == 0) {
                if (this.mRefFLVDownloader != null) {
                    TXCFLVDownloader tXCFLVDownloader = this.mRefFLVDownloader.get();
                    if (tXCFLVDownloader != null) {
                        if (tXCFLVDownloader.mIsRunning) {
                            TXCLog.i("network.TXCFLVDownloader", "[Network]init flv parser with old downloader:" + tXCFLVDownloader.hashCode());
                            tXCFLVDownloader.mStopJitter = false;
                            j2 = tXCFLVDownloader.mFLVParser;
                            this.mRefFLVDownloader = null;
                        } else {
                            TXCLog.e("network.TXCFLVDownloader", "[Network]old downloader:" + tXCFLVDownloader.hashCode() + " isn't running now. just create new parser.");
                        }
                    }
                    j2 = 0;
                    this.mRefFLVDownloader = null;
                } else {
                    j2 = 0;
                }
                if (j2 != 0) {
                    TXCLog.i("network.TXCFLVDownloader", "[Network]init flv parser with reference parse:".concat(String.valueOf(j2)));
                    this.mFLVParser = nativeInitFlvHanderByRef(j2);
                } else {
                    TXCLog.i("network.TXCFLVDownloader", "[Network]init flv parser.");
                    this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage, this.mEnableMetaData);
                }
            }
            if (this.mFlvHandler != null) {
                this.mFlvHandler.sendEmptyMessage(101);
            }
            AppMethodBeat.o(15314);
        } catch (SocketTimeoutException e2) {
            TXCLog.e("network.TXCFLVDownloader", "[Network]socket timeout, reconnect");
            postReconnectMsg();
            AppMethodBeat.o(15314);
        } catch (FileNotFoundException e3) {
            TXCLog.e("network.TXCFLVDownloader", "[Network]file not found, reconnect");
            postReconnectMsg();
            AppMethodBeat.o(15314);
        } catch (Exception e4) {
            TXCLog.e("network.TXCFLVDownloader", "[Network]exception, reconnect");
            postReconnectMsg();
            AppMethodBeat.o(15314);
        } catch (Error e5) {
            TXCLog.e("network.TXCFLVDownloader", "[Network]error, reconnect");
            postReconnectMsg();
            AppMethodBeat.o(15314);
        }
    }

    private void processMsgRecvData() {
        int i2 = 0;
        AppMethodBeat.i(15315);
        if (this.mInputStream != null) {
            try {
                int read = this.mInputStream.read(this.mPacketBytes, 0, 1388);
                if (read > 0) {
                    this.mDownloadedSize += (long) read;
                    if (!this.mRecvData) {
                        this.mRecvData = true;
                        TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network] TXCFLVDownloader: recv first data packet. instance:" + hashCode());
                    }
                    if (this.mFLVParser != 0) {
                        this.mStats.beforeParseVideoBytes += (long) read;
                        i2 = nativeParseData(this.mFLVParser, this.mPacketBytes, read);
                        this.mStats.afterParseVideoBytes = (long) nativeGetVideoBytes(this.mFLVParser);
                        this.mStats.afterParseAudioBytes = (long) nativeGetAudioBytes(this.mFLVParser);
                        this.mStats.videoGop = (long) nativeGetVideoGop(this.mFLVParser);
                    }
                    if (i2 > 1048576) {
                        TXCLog.e("network.TXCFLVDownloader", "[Network]flv play parse frame: " + i2 + " > 1048576,start reconnect");
                        postReconnectMsg();
                        AppMethodBeat.o(15315);
                        return;
                    }
                } else if (read < 0) {
                    TXCLog.e("network.TXCFLVDownloader", "[Network]http read: " + read + " < 0, start reconnect");
                    postReconnectMsg();
                    AppMethodBeat.o(15315);
                    return;
                }
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.sendEmptyMessage(101);
                }
                AppMethodBeat.o(15315);
                return;
            } catch (SocketTimeoutException e2) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]socket timeout start reconnect");
                postReconnectMsg();
                AppMethodBeat.o(15315);
                return;
            } catch (SocketException e3) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]socket exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.o(15315);
                return;
            } catch (SSLException e4) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]ssl exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.o(15315);
                return;
            } catch (EOFException e5) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]eof exception start reconnect");
                postReconnectMsg();
                AppMethodBeat.o(15315);
                return;
            } catch (Exception e6) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]exception");
                this.mInputStream = null;
                this.mConnection = null;
                AppMethodBeat.o(15315);
                return;
            } catch (Error e7) {
                TXCLog.e("network.TXCFLVDownloader", "[Network]error");
                this.mInputStream = null;
                this.mConnection = null;
            }
        }
        AppMethodBeat.o(15315);
    }

    private void processMsgDisConnect() {
        AppMethodBeat.i(15316);
        try {
            disconnect();
        } catch (Exception e2) {
            TXCLog.e("network.TXCFLVDownloader", "disconnect failed.", e2);
        }
        if (this.mFLVParser != 0) {
            nativeUninitFlvhander(this.mFLVParser, this.mStopJitter);
            this.mFLVParser = 0;
        }
        AppMethodBeat.o(15316);
    }

    private void processMsgReconnect() {
        AppMethodBeat.i(15317);
        if (this.mStopJitter) {
            reconnect();
            AppMethodBeat.o(15317);
            return;
        }
        TXCLog.i("network.TXCFLVDownloader", "ignore processMsgReconnect when start multi stream switch".concat(String.valueOf(this)));
        if (this.mRestartListener != null) {
            this.mRestartListener.onOldStreamStop();
        }
        AppMethodBeat.o(15317);
    }

    private void startInternal() {
        AppMethodBeat.i(15318);
        if (this.mFlvThread == null) {
            this.mFlvThread = new HandlerThread("FlvThread");
            this.mFlvThread.start();
            TXCLog.i("network.TXCFLVDownloader", "[Network] flv downloader thread id:" + this.mFlvThread.getId() + " instance:" + hashCode());
        }
        if (this.mFlvHandler == null) {
            this.mFlvHandler = new Handler(this.mFlvThread.getLooper()) {
                /* class com.tencent.liteav.network.TXCFLVDownloader.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public void handleMessage(Message message) {
                    AppMethodBeat.i(15468);
                    switch (message.what) {
                        case 100:
                            TXCFLVDownloader.access$000(TXCFLVDownloader.this);
                            AppMethodBeat.o(15468);
                            return;
                        case 101:
                            TXCFLVDownloader.access$100(TXCFLVDownloader.this);
                            AppMethodBeat.o(15468);
                            return;
                        case 102:
                            TXCFLVDownloader.access$200(TXCFLVDownloader.this);
                            AppMethodBeat.o(15468);
                            return;
                        case 103:
                            TXCFLVDownloader.access$300(TXCFLVDownloader.this);
                            AppMethodBeat.o(15468);
                            return;
                        case 106:
                            try {
                                Looper.myLooper().quit();
                                AppMethodBeat.o(15468);
                                return;
                            } catch (Exception e2) {
                                break;
                            }
                    }
                    AppMethodBeat.o(15468);
                }
            };
        }
        postConnectMsg();
        AppMethodBeat.o(15318);
    }

    private void reconnect() {
        AppMethodBeat.i(15319);
        processMsgDisConnect();
        if (this.connectRetryTimes < this.connectRetryLimit) {
            this.connectRetryTimes++;
            TXCLog.i("network.TXCFLVDownloader", "[Network] start reconnect, times:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
            processMsgConnect();
            sendNotifyEvent(2103);
            AppMethodBeat.o(15319);
            return;
        }
        TXCLog.i("network.TXCFLVDownloader", "[Network] reconnect fail. all times retried. limit:" + this.connectRetryLimit);
        sendNotifyEvent(-2301);
        AppMethodBeat.o(15319);
    }

    private void postReconnectMsg() {
        AppMethodBeat.i(15320);
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessageDelayed(103, (long) (this.connectRetryInterval * 1000));
        }
        AppMethodBeat.o(15320);
    }

    private void postDisconnectMsg() {
        AppMethodBeat.i(15321);
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendEmptyMessage(102);
        }
        AppMethodBeat.o(15321);
    }

    private void postConnectMsg() {
        AppMethodBeat.i(15322);
        this.mInputStream = null;
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        Message message = new Message();
        message.what = 100;
        message.arg1 = 0;
        if (this.mFlvHandler != null) {
            this.mFlvHandler.sendMessage(message);
        }
        AppMethodBeat.o(15322);
    }

    private void connect() {
        String headerField;
        AppMethodBeat.i(15323);
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network] TXCFLVDownloader: start network connect. instance:" + hashCode() + " url:" + this.mPlayUrl);
        long currentTimeMillis = System.currentTimeMillis();
        this.mConnection = (HttpURLConnection) new URL(this.mPlayUrl).openConnection();
        this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
        this.mConnection.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setRequestProperty("Accept-Encoding", "identity");
        this.mConnection.setInstanceFollowRedirects(true);
        if (this.mHeaders != null) {
            for (Map.Entry entry : this.mHeaders.entrySet()) {
                this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.mConnection.connect();
        if (200 == this.mConnection.getResponseCode()) {
            this.mStats.connTS = TXCTimeUtil.getTimeTick();
        } else {
            this.mStats.errorCode = this.mConnection.getResponseCode();
        }
        this.mInputStream = this.mConnection.getInputStream();
        this.mPacketBytes = new byte[1388];
        this.mRecvData = false;
        this.mContentLength = (long) this.mConnection.getContentLength();
        this.mDownloadedSize = 0;
        this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
        TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network] TXCFLVDownloader: connect server success. instance:" + hashCode() + " ip:" + this.mStats.serverIP + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + " rspCode:" + this.mStats.errorCode);
        sendNotifyEvent(2001);
        this.mStats.flvSessionKey = this.mConnection.getHeaderField("X-Tlive-SpanId");
        if (!TextUtils.isEmpty(this.mFlvSessionKey) && (headerField = this.mConnection.getHeaderField(this.mFlvSessionKey)) != null) {
            TXCLog.i("network.TXCFLVDownloader", "receive flvSessionKey ".concat(String.valueOf(headerField)));
            sendNotifyEvent(2031, headerField);
        }
        AppMethodBeat.o(15323);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public String getRealStreamUrl() {
        AppMethodBeat.i(15324);
        if (this.mConnection != null) {
            String url = this.mConnection.getURL().toString();
            AppMethodBeat.o(15324);
            return url;
        }
        AppMethodBeat.o(15324);
        return null;
    }

    private void disconnect() {
        AppMethodBeat.i(15325);
        TXCLog.i("network.TXCFLVDownloader", "[Network]FLVDownloader disconnect.");
        if (this.mConnection != null) {
            this.mConnection.disconnect();
            this.mConnection = null;
        }
        if (this.mInputStream != null) {
            this.mInputStream.close();
            this.mInputStream = null;
        }
        AppMethodBeat.o(15325);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        AppMethodBeat.i(15326);
        TXCStreamDownloader.DownloadStats downloadStats = new TXCStreamDownloader.DownloadStats();
        downloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
        downloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
        downloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
        downloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
        downloadStats.videoGop = this.mStats.videoGop;
        downloadStats.startTS = this.mStats.startTS;
        downloadStats.dnsTS = this.mStats.dnsTS;
        downloadStats.connTS = this.mStats.connTS;
        downloadStats.firstAudioTS = this.mStats.firstAudioTS;
        downloadStats.firstVideoTS = this.mStats.firstVideoTS;
        downloadStats.serverIP = this.mStats.serverIP;
        downloadStats.flvSessionKey = this.mStats.flvSessionKey;
        downloadStats.errorCode = this.mStats.errorCode;
        downloadStats.errorInfo = this.mStats.errorInfo;
        AppMethodBeat.o(15326);
        return downloadStats;
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(15327);
        if (this.mIsRunning) {
            AppMethodBeat.o(15327);
        } else if (vector == null || vector.isEmpty()) {
            AppMethodBeat.o(15327);
        } else {
            this.mEnableMessage = z3;
            this.mEnableMetaData = z4;
            this.mIsRunning = true;
            this.mPlayUrl = vector.get(0).f951a;
            TXCLog.i("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
            startInternal();
            AppMethodBeat.o(15327);
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void stopDownload() {
        AppMethodBeat.i(15328);
        if (!this.mIsRunning) {
            AppMethodBeat.o(15328);
            return;
        }
        this.mIsRunning = false;
        TXCLog.i("network.TXCFLVDownloader", "stop pull");
        try {
            if (this.mFlvHandler != null) {
                this.mFlvHandler.removeCallbacksAndMessages(null);
                this.mFlvHandler.sendEmptyMessage(102);
                this.mFlvHandler.sendEmptyMessage(106);
                this.mFlvHandler = null;
            }
            AppMethodBeat.o(15328);
        } catch (Exception e2) {
            TXCLog.e("network.TXCFLVDownloader", "stop download failed.", e2);
            AppMethodBeat.o(15328);
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void onRecvVideoData(byte[] bArr, int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(15329);
        if (!this.mHasReceivedFirstVideo) {
            this.mHasReceivedFirstVideo = true;
            this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
            TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:" + hashCode());
        }
        this.mStats.afterParseVideoBytes += (long) bArr.length;
        super.onRecvVideoData(bArr, i2, j2, j3, i3);
        AppMethodBeat.o(15329);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader
    public void onRecvAudioData(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(15330);
        if (!this.mHasReceivedFirstAudio) {
            this.mHasReceivedFirstAudio = true;
            this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
            TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:" + hashCode());
        }
        this.mStats.afterParseAudioBytes += (long) bArr.length;
        super.onRecvAudioData(bArr, i2, i3, i4);
        AppMethodBeat.o(15330);
    }

    private void onRecvFirstVideoData() {
        AppMethodBeat.i(222378);
        if (!this.mHasReceivedFirstVideo) {
            this.mHasReceivedFirstVideo = true;
            this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
            TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:" + hashCode());
        }
        AppMethodBeat.o(222378);
    }

    private void onRecvFirstAudioData() {
        AppMethodBeat.i(222379);
        if (!this.mHasReceivedFirstAudio) {
            this.mHasReceivedFirstAudio = true;
            this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
            TXCLog.i("network.TXCFLVDownloader", "[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:" + hashCode());
        }
        AppMethodBeat.o(222379);
    }
}
