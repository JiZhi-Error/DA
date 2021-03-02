package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.d;
import com.tencent.liteav.network.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader extends com.tencent.liteav.basic.module.a implements b, TXIStreamDownloader.a, d.a, f {
    public static final String TAG = "TXCStreamDownloader";
    private g mAccUrlFetcher;
    private Context mApplicationContext;
    private int mChannelType = 0;
    private long mCurrentNalTs = 0;
    private int mDownloadFormat = 1;
    private TXIStreamDownloader mDownloader = null;
    private boolean mDownloaderRunning = false;
    private boolean mEnableMessage = false;
    private boolean mEnableMetaData = false;
    private boolean mEnableNearestIP = false;
    private String mFlvSessionKey = "";
    private Handler mHandler = null;
    protected Map<String, String> mHeaders;
    private DownloadStats mLastDownloadStats = null;
    private long mLastIFramelTs = 0;
    private long mLastTimeStamp = 0;
    private f mListener = null;
    private byte[] mListenerLock = new byte[0];
    private b mNotifyListener = null;
    private String mOriginPlayUrl = "";
    private boolean mRecvFirstNal = false;
    private Runnable mReportNetStatusRunnalbe = new Runnable() {
        /* class com.tencent.liteav.network.TXCStreamDownloader.AnonymousClass3 */

        public void run() {
            AppMethodBeat.i(15407);
            TXCStreamDownloader.access$1200(TXCStreamDownloader.this);
            AppMethodBeat.o(15407);
        }
    };
    private d mStreamSwitcher = null;
    private long mSwitchStartTime = 0;

    public static class DownloadStats {
        public long afterParseAudioBytes;
        public long afterParseVideoBytes;
        public long beforeParseAudioBytes;
        public long beforeParseVideoBytes;
        public long connTS;
        public long dnsTS;
        public int errorCode;
        public String errorInfo;
        public long firstAudioTS;
        public long firstVideoTS;
        public String flvSessionKey;
        public String serverIP;
        public long startTS;
        public long videoGop;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f870a;

        /* renamed from: b  reason: collision with root package name */
        public String f871b;

        /* renamed from: c  reason: collision with root package name */
        public String f872c;

        /* renamed from: d  reason: collision with root package name */
        public int f873d;

        /* renamed from: e  reason: collision with root package name */
        public String f874e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f875f;
    }

    private native String nativeGetRTMPProxyUserId();

    static /* synthetic */ void access$1100(TXCStreamDownloader tXCStreamDownloader, String str, boolean z) {
        AppMethodBeat.i(15305);
        tXCStreamDownloader.playStreamWithRawUrl(str, z);
        AppMethodBeat.o(15305);
    }

    static /* synthetic */ void access$1200(TXCStreamDownloader tXCStreamDownloader) {
        AppMethodBeat.i(15306);
        tXCStreamDownloader.reportNetStatus();
        AppMethodBeat.o(15306);
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(15286);
        b bVar = this.mNotifyListener;
        if (bVar != null) {
            Bundle bundle2 = new Bundle();
            switch (i2) {
                case TXLiteAVCode.ERR_PLAY_LIVE_STREAM_SERVER_REFUSE:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "The server rejected the connection request");
                    break;
                case -2302:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "Failed to get accelerated pull address");
                    break;
                case -2301:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "failed to connect server for several times, abort connection");
                    break;
                case 2001:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "connection SUCCESS");
                    break;
                case 2002:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "begine receiving stream");
                    break;
                case 2012:
                    byte[] byteArray = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
                    if (byteArray != null && byteArray.length > 0) {
                        bundle2.putByteArray(TXLiveConstants.EVT_GET_MSG, byteArray);
                        break;
                    }
                case 2028:
                case 2031:
                    bundle2 = bundle;
                    break;
                case 2103:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "retry connecting stream server");
                    break;
                case 3002:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "Failed to connect server");
                    break;
                case 3003:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP handshake failed");
                    break;
                case 3006:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "Write data error");
                    break;
                case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "Read data error");
                    break;
                case TXLiteAVCode.WARNING_NO_STEAM_SOURCE_FAIL:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "No video at this stream address");
                    break;
                default:
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN event = ".concat(String.valueOf(i2)));
                    break;
            }
            String str = "";
            if (bundle != null) {
                str = bundle.getString(TXLiveConstants.EVT_DESCRIPTION, "");
            }
            if (str != null && !str.isEmpty()) {
                bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            }
            bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bVar.onNotifyEvent(i2, bundle2);
            if (i2 == 3001 || i2 == 3002 || i2 == 3003 || i2 == 3004 || i2 == 3005 || i2 == 3006 || i2 == 3007 || i2 == 3008 || i2 == 3009 || i2 == 3010 || i2 == 2101 || i2 == 2102 || i2 == 2109 || i2 == 2110 || i2 == -2301 || i2 == -2304 || i2 == -2308 || i2 == -2309) {
                setStatusValue(7105, Integer.valueOf(i2));
                if (bundle2 != null) {
                    setStatusValue(7106, bundle2.getString(TXLiveConstants.EVT_DESCRIPTION));
                }
            }
        }
        if (i2 == 2001) {
            reportNetStatusInternal();
        }
        AppMethodBeat.o(15286);
    }

    private void tryResetRetryCount() {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryTimes = 0;
        }
    }

    @Override // com.tencent.liteav.network.f
    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
        AppMethodBeat.i(15287);
        tryResetRetryCount();
        synchronized (this.mListenerLock) {
            try {
                if (this.mListener != null) {
                    this.mListener.onPullAudio(aVar);
                }
                if (this.mDownloader != null) {
                    this.mDownloader.PushAudioFrame(aVar.f425f, aVar.f427h, aVar.f424e, aVar.f426g);
                }
            } finally {
                AppMethodBeat.o(15287);
            }
        }
    }

    @Override // com.tencent.liteav.network.f
    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(15288);
        tryResetRetryCount();
        if (!this.mRecvFirstNal) {
            reportNetStatusInternal();
            this.mRecvFirstNal = true;
        }
        synchronized (this.mListenerLock) {
            try {
                this.mCurrentNalTs = tXSNALPacket.pts;
                if (tXSNALPacket.nalType == 0) {
                    this.mLastIFramelTs = tXSNALPacket.pts;
                }
                if (this.mListener != null) {
                    this.mListener.onPullNAL(tXSNALPacket);
                }
                if (this.mDownloader != null) {
                    this.mDownloader.PushVideoFrame(tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.dts, tXSNALPacket.pts, tXSNALPacket.codecId);
                }
            } finally {
                AppMethodBeat.o(15288);
            }
        }
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader.a
    public void onRestartDownloader() {
        AppMethodBeat.i(15289);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.liteav.network.TXCStreamDownloader.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(15421);
                    TXCStreamDownloader.this.stop();
                    TXCStreamDownloader.this.start(TXCStreamDownloader.this.mOriginPlayUrl, TXCStreamDownloader.this.mEnableNearestIP, TXCStreamDownloader.this.mChannelType, TXCStreamDownloader.this.mEnableMessage, TXCStreamDownloader.this.mEnableMetaData);
                    AppMethodBeat.o(15421);
                }
            });
        }
        AppMethodBeat.o(15289);
    }

    @Override // com.tencent.liteav.network.TXIStreamDownloader.a
    public void onOldStreamStop() {
        AppMethodBeat.i(15290);
        synchronized (this.mListenerLock) {
            try {
                if (this.mStreamSwitcher != null) {
                    this.mStreamSwitcher.b();
                }
            } finally {
                AppMethodBeat.o(15290);
            }
        }
    }

    public void setListener(f fVar) {
        synchronized (this.mListenerLock) {
            this.mListener = fVar;
        }
    }

    public void setNotifyListener(b bVar) {
        synchronized (this.mListenerLock) {
            this.mNotifyListener = bVar;
        }
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(15291);
        super.setID(str);
        if (this.mDownloader != null) {
            this.mDownloader.setUserID(str);
        }
        AppMethodBeat.o(15291);
    }

    @Override // com.tencent.liteav.network.d.a
    public void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        AppMethodBeat.i(15292);
        synchronized (this.mListenerLock) {
            try {
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.mSwitchStartTime);
                this.mSwitchStartTime = 0;
                Bundle bundle = new Bundle();
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                if (z) {
                    this.mDownloader = tXIStreamDownloader;
                    this.mDownloader.setListener(this);
                    this.mDownloader.setNotifyListener(this);
                    this.mDownloader.setRestartListener(this);
                    bundle.putInt("EVT_ID", 2015);
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Switched resolution successfully");
                    if (this.mNotifyListener != null) {
                        this.mNotifyListener.onNotifyEvent(2015, bundle);
                    }
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bw, currentTimeMillis, "");
                } else {
                    bundle.putInt("EVT_ID", -2307);
                    bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Failed to switch resolution");
                    if (this.mNotifyListener != null) {
                        this.mNotifyListener.onNotifyEvent(-2307, bundle);
                    }
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bx);
                }
                this.mStreamSwitcher = null;
            } finally {
                AppMethodBeat.o(15292);
            }
        }
    }

    static {
        AppMethodBeat.i(15307);
        f.f();
        AppMethodBeat.o(15307);
    }

    public TXCStreamDownloader(Context context, int i2) {
        AppMethodBeat.i(15293);
        if (i2 == 0) {
            this.mDownloader = new TXCFLVDownloader(context);
            this.mDownloader.setFlvSessionKey(this.mFlvSessionKey);
        } else if (i2 == 1 || i2 == 4) {
            this.mDownloader = new TXCRTMPDownloader(context);
        }
        if (this.mDownloader != null) {
            this.mDownloader.setListener(this);
            this.mDownloader.setNotifyListener(this);
            this.mDownloader.setRestartListener(this);
        }
        this.mDownloadFormat = i2;
        this.mAccUrlFetcher = new g(context);
        this.mApplicationContext = context;
        if (this.mApplicationContext != null) {
            this.mHandler = new Handler(this.mApplicationContext.getMainLooper());
        }
        AppMethodBeat.o(15293);
    }

    public void setRetryTimes(int i2) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryLimit = i2;
        }
    }

    public void setRetryInterval(int i2) {
        if (this.mDownloader != null) {
            this.mDownloader.connectRetryInterval = i2;
        }
    }

    public int start(final String str, boolean z, int i2, final boolean z2, final boolean z3) {
        AppMethodBeat.i(15294);
        this.mDownloaderRunning = true;
        this.mRecvFirstNal = false;
        this.mOriginPlayUrl = str;
        this.mEnableNearestIP = z;
        this.mChannelType = i2;
        this.mEnableMessage = z2;
        this.mEnableMetaData = z3;
        setStatusValue(7113, 0L);
        setStatusValue(7114, 0L);
        setStatusValue(7115, 0L);
        if (str.startsWith("room")) {
            setStatusValue(7113, 1L);
            setStatusValue(7112, 2L);
            setStatusValue(7116, str);
            if (this.mDownloader != null) {
                Vector<e> vector = new Vector<>();
                vector.add(new e(str, true));
                this.mDownloader.setOriginUrl(str);
                this.mDownloader.setUserID(getID());
                this.mDownloader.startDownload(vector, false, false, z2, z3);
            }
            if (this.mHandler != null) {
                this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
            }
            AppMethodBeat.o(15294);
            return 0;
        } else if (!z || this.mDownloadFormat != 4) {
            if (this.mDownloader != null) {
                setStatusValue(7112, 1L);
                Vector<e> vector2 = new Vector<>();
                vector2.add(new e(str, false));
                this.mDownloader.setOriginUrl(str);
                this.mDownloader.startDownload(vector2, this.mDownloadFormat == 4, z, z2, z3);
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
                }
            }
            AppMethodBeat.o(15294);
            return 0;
        } else {
            int a2 = this.mAccUrlFetcher.a(str, i2, new g.a() {
                /* class com.tencent.liteav.network.TXCStreamDownloader.AnonymousClass2 */

                @Override // com.tencent.liteav.network.g.a
                public void a(int i2, String str, Vector<e> vector) {
                    int i3;
                    AppMethodBeat.i(15467);
                    if (i2 != 0 || vector == null || vector.isEmpty()) {
                        TXCStreamDownloader.this.onNotifyEvent(-2302, null);
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, i2, str);
                        TXCLog.e(TXCStreamDownloader.TAG, "getAccelerateStreamPlayUrl failed, play stream with raw url");
                        if (TXCStreamDownloader.this.mDownloaderRunning) {
                            TXCStreamDownloader.access$1100(TXCStreamDownloader.this, str, z2);
                            if (TXCStreamDownloader.this.mHandler != null) {
                                TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, 2000);
                            }
                        }
                        AppMethodBeat.o(15467);
                    } else if (TXCStreamDownloader.this.mDownloaderRunning) {
                        if (TXCStreamDownloader.this.mDownloader != null) {
                            int i4 = 0;
                            Iterator<e> it = vector.iterator();
                            while (true) {
                                i3 = i4;
                                if (!it.hasNext()) {
                                    break;
                                }
                                e next = it.next();
                                if (next != null && next.f952b && next.f951a != null && next.f951a.length() > 0) {
                                    i3++;
                                }
                                i4 = i3;
                            }
                            TXCStreamDownloader.this.setStatusValue(7113, Long.valueOf((long) i3));
                            TXCStreamDownloader.this.setStatusValue(7112, 2L);
                            TXCStreamDownloader.this.mDownloader.setOriginUrl(str);
                            TXCStreamDownloader.this.mDownloader.startDownload(vector, true, true, z2, z3);
                        }
                        if (TXCStreamDownloader.this.mHandler != null) {
                            TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, 2000);
                        }
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, i2, TXCStreamDownloader.this.mAccUrlFetcher.b());
                        AppMethodBeat.o(15467);
                    } else {
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, -4, "livePlayer have been stopped");
                        AppMethodBeat.o(15467);
                    }
                }
            });
            if (a2 != 0) {
                if (a2 == -1) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid playUrl");
                } else if (a2 == -2) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid streamID");
                } else if (a2 == -3) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid signature");
                }
                TXCLog.e(TAG, "getAccelerateStreamPlayUrl failed, result = " + a2 + ", play stream with raw url");
                onNotifyEvent(-2302, null);
                playStreamWithRawUrl(str, z2);
                if (this.mHandler != null) {
                    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
                }
            }
            AppMethodBeat.o(15294);
            return 0;
        }
    }

    private void playStreamWithRawUrl(String str, boolean z) {
        AppMethodBeat.i(15295);
        if (this.mDownloader != null) {
            if (str != null && ((str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) && str.contains(".flv"))) {
                int i2 = this.mDownloader.connectRetryLimit;
                int i3 = this.mDownloader.connectRetryInterval;
                this.mDownloader = null;
                this.mDownloader = new TXCFLVDownloader(this.mApplicationContext);
                this.mDownloader.setFlvSessionKey(this.mFlvSessionKey);
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.setRestartListener(this);
                this.mDownloader.connectRetryLimit = i2;
                this.mDownloader.connectRetryInterval = i3;
                this.mDownloader.setHeaders(this.mHeaders);
                this.mDownloader.setUserID(getID());
            }
            setStatusValue(7112, 1L);
            Vector<e> vector = new Vector<>();
            vector.add(new e(str, false));
            this.mDownloader.setOriginUrl(str);
            this.mDownloader.startDownload(vector, false, false, z, z);
        }
        AppMethodBeat.o(15295);
    }

    public void stop() {
        AppMethodBeat.i(15296);
        this.mDownloaderRunning = false;
        this.mRecvFirstNal = false;
        if (this.mDownloader != null) {
            this.mDownloader.stopDownload();
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mReportNetStatusRunnalbe);
        }
        synchronized (this.mListenerLock) {
            try {
                if (this.mStreamSwitcher != null) {
                    this.mStreamSwitcher.a((f) null);
                    this.mStreamSwitcher.a();
                    this.mStreamSwitcher = null;
                }
            } finally {
                AppMethodBeat.o(15296);
            }
        }
    }

    public boolean switchStream(String str) {
        AppMethodBeat.i(15297);
        synchronized (this.mListenerLock) {
            try {
                if (this.mStreamSwitcher != null || this.mDownloader == null || !(this.mDownloader instanceof TXCFLVDownloader)) {
                    TXCLog.w(TAG, "stream_switch stream is changing ignore this change");
                    return false;
                }
                TXCFLVDownloader tXCFLVDownloader = new TXCFLVDownloader(this.mApplicationContext, (TXCFLVDownloader) this.mDownloader);
                tXCFLVDownloader.connectRetryLimit = this.mDownloader.connectRetryLimit;
                tXCFLVDownloader.connectRetryInterval = this.mDownloader.connectRetryInterval;
                tXCFLVDownloader.setHeaders(this.mHeaders);
                tXCFLVDownloader.setUserID(getID());
                tXCFLVDownloader.setFlvSessionKey(this.mFlvSessionKey);
                this.mStreamSwitcher = new d(this);
                this.mStreamSwitcher.a(this);
                this.mStreamSwitcher.a(this.mDownloader, tXCFLVDownloader, this.mCurrentNalTs, this.mLastIFramelTs, str);
                this.mSwitchStartTime = System.currentTimeMillis();
                AppMethodBeat.o(15297);
                return true;
            } finally {
                AppMethodBeat.o(15297);
            }
        }
    }

    public void requestKeyFrame(String str) {
        AppMethodBeat.i(15298);
        if (this.mDownloaderRunning && str != null && str.startsWith("room") && this.mDownloader != null) {
            this.mDownloader.requestKeyFrame(str);
        }
        AppMethodBeat.o(15298);
    }

    private DownloadStats getDownloadStats() {
        AppMethodBeat.i(15299);
        if (this.mDownloader != null) {
            DownloadStats downloadStats = this.mDownloader.getDownloadStats();
            AppMethodBeat.o(15299);
            return downloadStats;
        }
        AppMethodBeat.o(15299);
        return null;
    }

    private a getRealTimeStreamInfo() {
        AppMethodBeat.i(15300);
        a aVar = null;
        if (this.mAccUrlFetcher != null && !TextUtils.isEmpty(this.mAccUrlFetcher.a())) {
            aVar = new a();
            aVar.f871b = this.mAccUrlFetcher.a();
            aVar.f872c = this.mAccUrlFetcher.b();
            aVar.f873d = this.mAccUrlFetcher.c();
            aVar.f874e = this.mAccUrlFetcher.d();
        }
        if (!(this.mDownloader == null || aVar == null)) {
            aVar.f870a = this.mDownloader.getCurrentStreamUrl();
            aVar.f875f = this.mDownloader.isQuicChannel();
        }
        AppMethodBeat.o(15300);
        return aVar;
    }

    private void reportNetStatus() {
        AppMethodBeat.i(15301);
        reportNetStatusInternal();
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
        AppMethodBeat.o(15301);
    }

    private void reportNetStatusInternal() {
        AppMethodBeat.i(15302);
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = timeTick - this.mLastTimeStamp;
        DownloadStats downloadStats = getDownloadStats();
        a realTimeStreamInfo = getRealTimeStreamInfo();
        long j3 = 0;
        long j4 = 0;
        if (downloadStats != null) {
            if (this.mLastDownloadStats != null) {
                long longValue = getSpeed(this.mLastDownloadStats.afterParseVideoBytes, downloadStats.afterParseVideoBytes, j2).longValue();
                j4 = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, downloadStats.afterParseAudioBytes, j2).longValue();
                j3 = longValue;
            }
            if (j3 > 0 || j4 > 0) {
                this.mDownloader.connectRetryTimes = 0;
            }
            setStatusValue(7101, Long.valueOf(j3));
            setStatusValue(7102, Long.valueOf(j4));
            setStatusValue(7103, Long.valueOf(downloadStats.firstVideoTS));
            setStatusValue(7104, Long.valueOf(downloadStats.firstAudioTS));
            setStatusValue(7120, Long.valueOf(downloadStats.videoGop));
            if (realTimeStreamInfo != null) {
                setStatusValue(7105, Long.valueOf((long) realTimeStreamInfo.f873d));
                setStatusValue(7106, realTimeStreamInfo.f874e);
                setStatusValue(7111, Long.valueOf(realTimeStreamInfo.f875f ? 2 : 1));
                setStatusValue(7116, realTimeStreamInfo.f870a);
                setStatusValue(7117, realTimeStreamInfo.f871b);
                setStatusValue(7118, realTimeStreamInfo.f872c);
            } else {
                setStatusValue(7105, Long.valueOf((long) downloadStats.errorCode));
                setStatusValue(7106, downloadStats.errorInfo);
                setStatusValue(7111, 1L);
            }
            setStatusValue(7107, Long.valueOf(downloadStats.startTS));
            setStatusValue(7108, Long.valueOf(downloadStats.dnsTS));
            setStatusValue(7109, Long.valueOf(downloadStats.connTS));
            setStatusValue(7110, String.valueOf(downloadStats.serverIP));
        }
        if (this.mDownloader != null) {
            int connectCountQuic = this.mDownloader.getConnectCountQuic();
            int connectCountTcp = this.mDownloader.getConnectCountTcp();
            setStatusValue(7114, Long.valueOf((long) (connectCountQuic + 1)));
            setStatusValue(7115, Long.valueOf((long) (connectCountTcp + 1)));
            setStatusValue(7119, this.mDownloader.getRealStreamUrl());
            setStatusValue(7121, String.valueOf(this.mDownloader.getFlvSessionKey()));
        }
        this.mLastTimeStamp = timeTick;
        this.mLastDownloadStats = downloadStats;
        AppMethodBeat.o(15302);
    }

    private Long getSpeed(long j2, long j3, long j4) {
        long j5 = 0;
        AppMethodBeat.i(15303);
        if (j2 <= j3) {
            j3 -= j2;
        }
        if (j4 > 0) {
            j5 = ((8 * j3) * 1000) / (1024 * j4);
        }
        Long valueOf = Long.valueOf(j5);
        AppMethodBeat.o(15303);
        return valueOf;
    }

    public void setHeaders(Map<String, String> map) {
        AppMethodBeat.i(15304);
        this.mHeaders = map;
        if (this.mDownloader != null) {
            this.mDownloader.setHeaders(this.mHeaders);
        }
        AppMethodBeat.o(15304);
    }

    public void setFlvSessionKey(String str) {
        AppMethodBeat.i(222372);
        this.mFlvSessionKey = str;
        if (this.mDownloader != null) {
            this.mDownloader.setFlvSessionKey(str);
        }
        AppMethodBeat.o(222372);
    }

    public String getRTMPProxyUserId() {
        AppMethodBeat.i(222373);
        String nativeGetRTMPProxyUserId = nativeGetRTMPProxyUserId();
        AppMethodBeat.o(222373);
        return nativeGetRTMPProxyUserId;
    }
}
