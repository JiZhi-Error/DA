package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader extends com.tencent.liteav.basic.module.a implements b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
    private final int MSG_EVENT = 102;
    private final int MSG_RECONNECT = 101;
    private final int MSG_REPORT_STATUS = 103;
    private final int MSG_RTMPPROXY_HEARTBEAT = 104;
    private boolean mAudioMuted = false;
    private int mChannelType = 0;
    private int mConnectCountQuic = 0;
    private int mConnectCountTcp = 0;
    private long mConnectSuccessTimeStamps = 0;
    private Context mContext = null;
    private int mCurrentRecordIdx = 0;
    private boolean mEnableNearestIP = true;
    private long mGoodPushTime = 30000;
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private c mIntelligentRoute = null;
    private ArrayList<a> mIpList = null;
    private boolean mIsPushing = false;
    private int mLastNetworkType = 0;
    private long mLastTimeStamp = 0;
    private UploadStats mLastUploadStats = null;
    HashMap<String, String> mMetaData;
    private WeakReference<com.tencent.liteav.basic.b.b> mNotifyListener = null;
    private h mParam = null;
    private boolean mQuicChannel = false;
    private int mRetryCount = 0;
    private long mRtmpMsgRecvThreadInstance = 0;
    private Object mRtmpMsgRecvThreadLock = new Object();
    private boolean mRtmpProxyEnable = false;
    private int mRtmpProxyIPIndex = 0;
    private Vector<String> mRtmpProxyIPList = new Vector<>();
    private long mRtmpProxyInstance = 0;
    private Object mRtmpProxyLock = new Object();
    private a mRtmpProxyParam = new a();
    private String mRtmpUrl = "";
    private Thread mThread = null;
    private Object mThreadLock = null;
    private j mUploadQualityReport = null;
    private long mUploaderInstance = 0;
    private Vector<TXSNALPacket> mVecPendingNAL = new Vector<>();

    private native void nativeCacheJNIParams();

    private native void nativeEnableDrop(long j2, boolean z);

    private native UploadStats nativeGetStats(long j2);

    private native long nativeInitRtmpMsgRecvThreadInstance(long j2, long j3);

    private native long nativeInitRtmpProxyInstance(long j2, long j3, String str, long j4, String str2, long j5, long j6, String str3, boolean z, String str4);

    private native long nativeInitUploader(String str, String str2, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, HashMap<String, String> hashMap);

    private native void nativeOnThreadRun(long j2);

    private native void nativePushAAC(long j2, byte[] bArr, long j3);

    private native void nativePushNAL(long j2, byte[] bArr, int i2, long j3, long j4, long j5);

    private native void nativeReleaseJNIParams();

    private native void nativeRtmpMsgRecvThreadStart(long j2);

    private native void nativeRtmpMsgRecvThreadStop(long j2);

    private native void nativeRtmpProxyEnterRoom(long j2);

    private native void nativeRtmpProxyLeaveRoom(long j2);

    private native void nativeRtmpProxySendHeartBeat(long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12);

    private native void nativeSendRtmpProxyMsg(long j2, byte[] bArr);

    private native void nativeSetSendStrategy(long j2, int i2, boolean z);

    private native void nativeSetVideoDropParams(long j2, boolean z, int i2, int i3);

    private native void nativeStopPush(long j2);

    private native void nativeUninitRtmpMsgRecvThreadInstance(long j2);

    private native void nativeUninitRtmpProxyInstance(long j2);

    private native void nativeUninitUploader(long j2);

    static /* synthetic */ void access$000(TXCStreamUploader tXCStreamUploader, String str, boolean z, int i2) {
        AppMethodBeat.i(15370);
        tXCStreamUploader.startPushTask(str, z, i2);
        AppMethodBeat.o(15370);
    }

    static /* synthetic */ void access$100(TXCStreamUploader tXCStreamUploader) {
        AppMethodBeat.i(15371);
        tXCStreamUploader.reportNetStatus();
        AppMethodBeat.o(15371);
    }

    static /* synthetic */ long access$1400(TXCStreamUploader tXCStreamUploader, String str, String str2, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, HashMap hashMap) {
        AppMethodBeat.i(15374);
        long nativeInitUploader = tXCStreamUploader.nativeInitUploader(str, str2, z, i2, i3, i4, i5, i6, i7, i8, z2, i9, hashMap);
        AppMethodBeat.o(15374);
        return nativeInitUploader;
    }

    static /* synthetic */ void access$1500(TXCStreamUploader tXCStreamUploader, long j2, boolean z, int i2, int i3) {
        AppMethodBeat.i(15375);
        tXCStreamUploader.nativeSetVideoDropParams(j2, z, i2, i3);
        AppMethodBeat.o(15375);
    }

    static /* synthetic */ void access$1700(TXCStreamUploader tXCStreamUploader, long j2, byte[] bArr, int i2, long j3, long j4, long j5) {
        AppMethodBeat.i(15376);
        tXCStreamUploader.nativePushNAL(j2, bArr, i2, j3, j4, j5);
        AppMethodBeat.o(15376);
    }

    static /* synthetic */ void access$200(TXCStreamUploader tXCStreamUploader) {
        AppMethodBeat.i(15372);
        tXCStreamUploader.rtmpProxySendHeartBeat();
        AppMethodBeat.o(15372);
    }

    static /* synthetic */ long access$2100(TXCStreamUploader tXCStreamUploader, long j2, long j3, String str, long j4, String str2, long j5, long j6, String str3, boolean z, String str4) {
        AppMethodBeat.i(15377);
        long nativeInitRtmpProxyInstance = tXCStreamUploader.nativeInitRtmpProxyInstance(j2, j3, str, j4, str2, j5, j6, str3, z, str4);
        AppMethodBeat.o(15377);
        return nativeInitRtmpProxyInstance;
    }

    static /* synthetic */ long access$2400(TXCStreamUploader tXCStreamUploader, long j2, long j3) {
        AppMethodBeat.i(15378);
        long nativeInitRtmpMsgRecvThreadInstance = tXCStreamUploader.nativeInitRtmpMsgRecvThreadInstance(j2, j3);
        AppMethodBeat.o(15378);
        return nativeInitRtmpMsgRecvThreadInstance;
    }

    static /* synthetic */ void access$2500(TXCStreamUploader tXCStreamUploader, long j2) {
        AppMethodBeat.i(15379);
        tXCStreamUploader.nativeOnThreadRun(j2);
        AppMethodBeat.o(15379);
    }

    static /* synthetic */ void access$2600(TXCStreamUploader tXCStreamUploader, long j2) {
        AppMethodBeat.i(15380);
        tXCStreamUploader.nativeRtmpMsgRecvThreadStop(j2);
        AppMethodBeat.o(15380);
    }

    static /* synthetic */ void access$2700(TXCStreamUploader tXCStreamUploader, long j2) {
        AppMethodBeat.i(15381);
        tXCStreamUploader.nativeUninitRtmpMsgRecvThreadInstance(j2);
        AppMethodBeat.o(15381);
    }

    static /* synthetic */ void access$2800(TXCStreamUploader tXCStreamUploader, long j2) {
        AppMethodBeat.i(15382);
        tXCStreamUploader.nativeUninitRtmpProxyInstance(j2);
        AppMethodBeat.o(15382);
    }

    static /* synthetic */ void access$2900(TXCStreamUploader tXCStreamUploader, long j2) {
        AppMethodBeat.i(15383);
        tXCStreamUploader.nativeUninitUploader(j2);
        AppMethodBeat.o(15383);
    }

    static /* synthetic */ void access$3000(TXCStreamUploader tXCStreamUploader, boolean z) {
        AppMethodBeat.i(15384);
        tXCStreamUploader.internalReconnect(z);
        AppMethodBeat.o(15384);
    }

    static /* synthetic */ String access$800(TXCStreamUploader tXCStreamUploader, String str) {
        AppMethodBeat.i(15373);
        String addressFromUrl = tXCStreamUploader.getAddressFromUrl(str);
        AppMethodBeat.o(15373);
        return addressFromUrl;
    }

    /* access modifiers changed from: package-private */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f892a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f893b = false;

        public b(String str, boolean z) {
            this.f892a = str;
            this.f893b = z;
        }
    }

    public class UploadStats {
        public long audioCacheLen;
        public long audioDropCount;
        public long bandwidthEst;
        public long channelType;
        public long connTS;
        public long connectTimeCost;
        public String connectionID;
        public String connectionStats;
        public long dnsTS;
        public long dnsparseTimeCost;
        public long handshakeTimeCost;
        public long inAudioBytes;
        public long inVideoBytes;
        public long outAudioBytes;
        public long outVideoBytes;
        public String serverIP;
        public long startTS;
        public long videoCacheLen;
        public long videoDropCount;

        public UploadStats() {
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f882a;

        /* renamed from: b  reason: collision with root package name */
        public long f883b;

        /* renamed from: c  reason: collision with root package name */
        public String f884c;

        /* renamed from: d  reason: collision with root package name */
        public long f885d;

        /* renamed from: e  reason: collision with root package name */
        public String f886e;

        /* renamed from: f  reason: collision with root package name */
        public long f887f;

        /* renamed from: g  reason: collision with root package name */
        public long f888g;

        /* renamed from: h  reason: collision with root package name */
        public String f889h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f890i;

        /* renamed from: j  reason: collision with root package name */
        public String f891j;

        public a() {
        }

        public void a() {
            this.f882a = 0;
            this.f883b = 0;
            this.f884c = "";
            this.f885d = 0;
            this.f886e = "";
            this.f887f = 0;
            this.f888g = 0;
            this.f890i = false;
            this.f891j = "";
        }
    }

    public class RtmpProxyUserInfo {
        public String account = "";
        public String playUrl = "";
        public int stmType = 0;

        public RtmpProxyUserInfo() {
        }
    }

    static {
        AppMethodBeat.i(15385);
        f.f();
        AppMethodBeat.o(15385);
    }

    public void setNotifyListener(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(222380);
        this.mNotifyListener = new WeakReference<>(bVar);
        AppMethodBeat.o(222380);
    }

    public TXCStreamUploader(Context context, h hVar) {
        AppMethodBeat.i(15337);
        this.mContext = context;
        if (hVar == null) {
            hVar = new h();
            hVar.f982a = 0;
            hVar.f988g = 3;
            hVar.f987f = 3;
            hVar.f989h = 40;
            hVar.f990i = 1000;
            hVar.f991j = true;
        }
        this.mParam = hVar;
        this.mThreadLock = new Object();
        this.mIntelligentRoute = new c();
        this.mIntelligentRoute.f920a = this;
        this.mUploaderInstance = 0;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 0;
        this.mHandlerThread = null;
        this.mUploadQualityReport = new j(context);
        i.a().a(context);
        AppMethodBeat.o(15337);
    }

    public void setRetryInterval(int i2) {
        if (this.mParam != null) {
            this.mParam.f988g = i2;
        }
    }

    public void setAudioInfo(int i2, int i3) {
        if (this.mParam != null) {
            this.mParam.f985d = i3;
            this.mParam.f986e = i2;
        }
    }

    public void setRetryTimes(int i2) {
        if (this.mParam != null) {
            this.mParam.f987f = i2;
        }
    }

    public void setMode(int i2) {
        if (this.mParam != null) {
            this.mParam.f982a = i2;
        }
    }

    private void postReconnectMsg(String str, boolean z, int i2) {
        AppMethodBeat.i(15338);
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        message.arg1 = z ? 2 : 1;
        if (this.mHandler != null) {
            this.mHandler.sendMessageDelayed(message, (long) i2);
        }
        AppMethodBeat.o(15338);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0041  */
    @Override // com.tencent.liteav.network.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFetchDone(int r8, java.util.ArrayList<com.tencent.liteav.network.a> r9) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.TXCStreamUploader.onFetchDone(int, java.util.ArrayList):void");
    }

    public String getConfusionIP(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        AppMethodBeat.i(15340);
        if (str == null || (indexOf = str.indexOf(".")) == -1 || (indexOf2 = (substring = str.substring(indexOf + 1)).indexOf(".")) == -1) {
            AppMethodBeat.o(15340);
            return str;
        }
        String concat = "A.B.".concat(String.valueOf(substring.substring(indexOf2 + 1)));
        AppMethodBeat.o(15340);
        return concat;
    }

    public int init() {
        return 0;
    }

    public String start(String str, boolean z, int i2) {
        AppMethodBeat.i(15341);
        if (this.mIsPushing) {
            String str2 = this.mRtmpUrl;
            AppMethodBeat.o(15341);
            return str2;
        }
        this.mIsPushing = true;
        this.mConnectSuccessTimeStamps = 0;
        this.mRetryCount = 0;
        this.mRtmpUrl = str;
        this.mChannelType = i2;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRtmpProxyEnable = false;
        this.mRtmpProxyParam.a();
        this.mRtmpProxyIPList.clear();
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = 0;
        this.mRtmpMsgRecvThreadInstance = 0;
        setStatusValue(7016, 0L);
        setStatusValue(7017, 0L);
        setStatusValue(7018, 0L);
        this.mUploadQualityReport.a();
        TXCLog.i(TAG, "start push with url:" + this.mRtmpUrl + " enable nearest ip:" + (z ? "yes" : "no") + "channel type:" + i2);
        if (f.e(this.mContext) == 0) {
            sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK);
            String str3 = this.mRtmpUrl;
            AppMethodBeat.o(15341);
            return str3;
        }
        this.mEnableNearestIP = z;
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("RTMP_PUSH");
            this.mHandlerThread.start();
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            /* class com.tencent.liteav.network.TXCStreamUploader.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public void handleMessage(Message message) {
                boolean z;
                AppMethodBeat.i(15408);
                switch (message.what) {
                    case 101:
                        TXCStreamUploader tXCStreamUploader = TXCStreamUploader.this;
                        String str = (String) message.obj;
                        if (message.arg1 == 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        TXCStreamUploader.access$000(tXCStreamUploader, str, z, 0);
                        AppMethodBeat.o(15408);
                        return;
                    case 103:
                        TXCStreamUploader.access$100(TXCStreamUploader.this);
                        AppMethodBeat.o(15408);
                        return;
                    case 104:
                        TXCStreamUploader.access$200(TXCStreamUploader.this);
                        if (TXCStreamUploader.this.mHandler != null) {
                            TXCStreamUploader.this.mHandler.sendEmptyMessageDelayed(104, 2000);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(15408);
            }
        };
        parseProxyInfo(str);
        if (this.mRtmpProxyEnable) {
            this.mLastNetworkType = f.e(this.mContext);
            nativeCacheJNIParams();
        } else if (this.mEnableNearestIP && this.mLastNetworkType != f.e(this.mContext)) {
            TXCLog.i(TAG, "fetching nearest ip list");
            this.mLastNetworkType = f.e(this.mContext);
            this.mIntelligentRoute.a(str, i2);
            this.mHandler.sendEmptyMessageDelayed(103, 2000);
            String str4 = this.mRtmpUrl;
            AppMethodBeat.o(15341);
            return str4;
        }
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        this.mHandler.sendEmptyMessageDelayed(103, 2000);
        String str42 = this.mRtmpUrl;
        AppMethodBeat.o(15341);
        return str42;
    }

    public void stop() {
        AppMethodBeat.i(15342);
        if (!this.mIsPushing) {
            AppMethodBeat.o(15342);
            return;
        }
        this.mIsPushing = false;
        TXCLog.i(TAG, "stop push");
        if (this.mRtmpProxyEnable) {
            synchronized (this.mRtmpProxyLock) {
                try {
                    nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
                } catch (Throwable th) {
                    AppMethodBeat.o(15342);
                    throw th;
                }
            }
        }
        synchronized (this.mThreadLock) {
            try {
                nativeStopPush(this.mUploaderInstance);
            } catch (Throwable th2) {
                AppMethodBeat.o(15342);
                throw th2;
            }
        }
        if (this.mHandlerThread != null) {
            this.mHandlerThread.getLooper().quit();
            this.mHandlerThread = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
        if (this.mRtmpProxyEnable) {
            nativeReleaseJNIParams();
        }
        this.mUploadQualityReport.c();
        this.mUploadQualityReport.a();
        AppMethodBeat.o(15342);
    }

    private void tryResetRetryCount() {
        AppMethodBeat.i(15343);
        if (this.mConnectSuccessTimeStamps != 0 && TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > ((long) (this.mParam.f987f * (this.mParam.f988g + 13) * 1000))) {
            this.mRetryCount = 0;
            this.mConnectSuccessTimeStamps = 0;
            TXCLog.i(TAG, "reset retry count");
        }
        AppMethodBeat.o(15343);
    }

    public void setMetaData(HashMap<String, String> hashMap) {
        this.mMetaData = hashMap;
    }

    public void pushAAC(byte[] bArr, long j2) {
        AppMethodBeat.i(15344);
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            try {
                if (!this.mAudioMuted || !this.mRtmpProxyEnable) {
                    nativePushAAC(this.mUploaderInstance, bArr, j2);
                }
            } finally {
                AppMethodBeat.o(15344);
            }
        }
    }

    public void pushNAL(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(15345);
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance == 0) {
                    if (tXSNALPacket.nalType == 0) {
                        this.mVecPendingNAL.removeAllElements();
                    }
                    this.mVecPendingNAL.add(tXSNALPacket);
                } else if (!(tXSNALPacket == null || tXSNALPacket.nalData == null || tXSNALPacket.nalData.length <= 0)) {
                    nativePushNAL(this.mUploaderInstance, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.frameIndex, tXSNALPacket.pts, tXSNALPacket.dts);
                }
            } finally {
                AppMethodBeat.o(15345);
            }
        }
    }

    public void setAudioMute(boolean z) {
        AppMethodBeat.i(15346);
        synchronized (this.mThreadLock) {
            try {
                this.mAudioMuted = z;
                if (this.mRtmpProxyEnable && this.mUploaderInstance != 0) {
                    nativeSetSendStrategy(this.mUploaderInstance, this.mParam.m ? this.mQuicChannel ? 3 : 2 : 1, false);
                }
            } finally {
                AppMethodBeat.o(15346);
            }
        }
    }

    public void setDropEanble(boolean z) {
        AppMethodBeat.i(15347);
        TXCLog.i(TAG, "drop enable " + (z ? "yes" : "no"));
        synchronized (this.mThreadLock) {
            try {
                nativeEnableDrop(this.mUploaderInstance, z);
            } finally {
                AppMethodBeat.o(15347);
            }
        }
    }

    public void setVideoDropParams(boolean z, int i2, int i3) {
        AppMethodBeat.i(15348);
        TXCLog.i(TAG, "drop params wait i frame:" + (z ? "yes" : "no") + " max video count:" + i2 + " max video cache time: " + i3 + " ms");
        synchronized (this.mThreadLock) {
            try {
                this.mParam.f991j = z;
                this.mParam.f989h = i2;
                this.mParam.f990i = i3;
                if (this.mUploaderInstance != 0) {
                    nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.f991j, this.mParam.f989h, this.mParam.f990i);
                }
            } finally {
                AppMethodBeat.o(15348);
            }
        }
    }

    public void setSendStrategy(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(15349);
        this.mParam.m = z;
        this.mParam.n = z2;
        this.mUploadQualityReport.a(z);
        if (z) {
            i2 = this.mQuicChannel ? 3 : 2;
        } else {
            i2 = 1;
        }
        if (!this.mRtmpProxyEnable && (this.mIpList == null || this.mIpList.size() == 0)) {
            i2 = 1;
        }
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance != 0) {
                    nativeSetSendStrategy(this.mUploaderInstance, i2, z2);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(15349);
                throw th;
            }
        }
        setStatusValue(7020, Long.valueOf((long) i2));
        AppMethodBeat.o(15349);
    }

    public UploadStats getUploadStats() {
        UploadStats nativeGetStats;
        AppMethodBeat.i(15350);
        synchronized (this.mThreadLock) {
            try {
                nativeGetStats = nativeGetStats(this.mUploaderInstance);
                if (nativeGetStats != null) {
                    nativeGetStats.channelType = this.mQuicChannel ? 2 : 1;
                }
            } finally {
                AppMethodBeat.o(15350);
            }
        }
        return nativeGetStats;
    }

    private void startPushTask(final String str, final boolean z, int i2) {
        AppMethodBeat.i(15351);
        TXCLog.i(TAG, "start push task");
        if (this.mQuicChannel != z && this.mQuicChannel) {
            Monitor.a(2, String.format("Network: switch push channel from quic to tcp.[retryCount:%d][retryLimit:%d]", Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f987f)), "", 0);
        }
        if (z) {
            int i3 = this.mConnectCountQuic + 1;
            this.mConnectCountQuic = i3;
            setStatusValue(7017, Long.valueOf((long) i3));
        } else {
            int i4 = this.mConnectCountTcp + 1;
            this.mConnectCountTcp = i4;
            setStatusValue(7018, Long.valueOf((long) i4));
        }
        this.mThread = new Thread("RTMPUpload") {
            /* class com.tencent.liteav.network.TXCStreamUploader.AnonymousClass2 */

            public void run() {
                boolean z;
                AppMethodBeat.i(15489);
                while (TXCStreamUploader.this.mUploaderInstance != 0) {
                    try {
                        sleep(100, 0);
                    } catch (InterruptedException e2) {
                    }
                }
                TXCStreamUploader.this.mUploadQualityReport.b();
                TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mParam.m);
                TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mRtmpUrl);
                TXCStreamUploader.this.mUploadQualityReport.a(z, TXCStreamUploader.access$800(TXCStreamUploader.this, str));
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    try {
                        TXCStreamUploader.this.mQuicChannel = z;
                        int i2 = TXCStreamUploader.this.mParam.m ? TXCStreamUploader.this.mQuicChannel ? 3 : 2 : 1;
                        if (!TXCStreamUploader.this.mRtmpProxyEnable) {
                            if (TXCStreamUploader.this.mIpList == null || TXCStreamUploader.this.mIpList.size() == 0) {
                                i2 = 1;
                            }
                        } else if (TXCStreamUploader.this.mAudioMuted) {
                            TXCStreamUploader.this.mParam.n = false;
                        }
                        TXCStreamUploader.this.setStatusValue(7020, Long.valueOf((long) i2));
                        TXCStreamUploader.this.mUploaderInstance = TXCStreamUploader.access$1400(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpUrl, str, z, TXCStreamUploader.this.mParam.f986e, TXCStreamUploader.this.mParam.f985d, TXCStreamUploader.this.mParam.f982a, TXCStreamUploader.this.mParam.f984c, TXCStreamUploader.this.mParam.f989h, 16, i2, TXCStreamUploader.this.mParam.n, TXCStreamUploader.this.mParam.o, TXCStreamUploader.this.mMetaData);
                        if (TXCStreamUploader.this.mUploaderInstance != 0) {
                            TXCStreamUploader.access$1500(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, TXCStreamUploader.this.mParam.f991j, TXCStreamUploader.this.mParam.f989h, TXCStreamUploader.this.mParam.f990i);
                            boolean z2 = false;
                            Iterator it = TXCStreamUploader.this.mVecPendingNAL.iterator();
                            while (it.hasNext()) {
                                TXSNALPacket tXSNALPacket = (TXSNALPacket) it.next();
                                if (z2 || tXSNALPacket.nalType != 0) {
                                    z = z2;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    TXCStreamUploader.access$1700(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.frameIndex, tXSNALPacket.pts, tXSNALPacket.dts);
                                }
                                z2 = z;
                            }
                            TXCStreamUploader.this.mVecPendingNAL.removeAllElements();
                        }
                    } finally {
                        AppMethodBeat.o(15489);
                    }
                }
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        try {
                            TXCStreamUploader.this.mRtmpProxyInstance = TXCStreamUploader.access$2100(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyParam.f882a, TXCStreamUploader.this.mRtmpProxyParam.f883b, TXCStreamUploader.this.mRtmpProxyParam.f884c, TXCStreamUploader.this.mRtmpProxyParam.f885d, TXCStreamUploader.this.mRtmpProxyParam.f886e, TXCStreamUploader.this.mRtmpProxyParam.f887f, TXCStreamUploader.this.mRtmpProxyParam.f888g, TXCStreamUploader.this.mRtmpProxyParam.f889h, TXCStreamUploader.this.mRtmpProxyParam.f890i, TXCStreamUploader.this.mRtmpProxyParam.f891j);
                        } finally {
                            AppMethodBeat.o(15489);
                        }
                    }
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        try {
                            TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = TXCStreamUploader.access$2400(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance, TXCStreamUploader.this.mUploaderInstance);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                TXCStreamUploader.access$2500(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        try {
                            TXCStreamUploader.access$2600(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                            TXCStreamUploader.access$2700(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                            TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = 0;
                        } finally {
                            AppMethodBeat.o(15489);
                        }
                    }
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        try {
                            TXCStreamUploader.access$2800(TXCStreamUploader.this, TXCStreamUploader.this.mRtmpProxyInstance);
                            TXCStreamUploader.this.mRtmpProxyInstance = 0;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    try {
                        TXCStreamUploader.access$2900(TXCStreamUploader.this, TXCStreamUploader.this.mUploaderInstance);
                        TXCStreamUploader.this.mUploaderInstance = 0;
                    } finally {
                        AppMethodBeat.o(15489);
                    }
                }
            }
        };
        this.mThread.start();
        AppMethodBeat.o(15351);
    }

    private void stopPushTask() {
        AppMethodBeat.i(15352);
        TXCLog.i(TAG, "stop push task");
        synchronized (this.mThreadLock) {
            try {
                this.mVecPendingNAL.removeAllElements();
                nativeStopPush(this.mUploaderInstance);
            } finally {
                AppMethodBeat.o(15352);
            }
        }
    }

    private b getRtmpRealConnectInfo() {
        AppMethodBeat.i(15353);
        if (!this.mEnableNearestIP) {
            b bVar = new b(this.mRtmpUrl, false);
            AppMethodBeat.o(15353);
            return bVar;
        } else if (this.mIpList == null) {
            b bVar2 = new b(this.mRtmpUrl, false);
            AppMethodBeat.o(15353);
            return bVar2;
        } else if (this.mCurrentRecordIdx >= this.mIpList.size() || this.mCurrentRecordIdx < 0) {
            b bVar3 = new b(this.mRtmpUrl, false);
            AppMethodBeat.o(15353);
            return bVar3;
        } else {
            a aVar = this.mIpList.get(this.mCurrentRecordIdx);
            String[] split = this.mRtmpUrl.split("://");
            if (split.length < 2) {
                b bVar4 = new b(this.mRtmpUrl, false);
                AppMethodBeat.o(15353);
                return bVar4;
            }
            String[] split2 = split[1].split(FilePathGenerator.ANDROID_DIR_SEP);
            if (aVar.f895a.split(":").length <= 1 || aVar.f895a.startsWith("[")) {
                split2[0] = aVar.f895a + ":" + aVar.f896b;
            } else {
                split2[0] = "[" + aVar.f895a + "]:" + aVar.f896b;
            }
            StringBuilder sb = new StringBuilder(split2[0]);
            for (int i2 = 1; i2 < split2.length; i2++) {
                sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                sb.append(split2[i2]);
            }
            b bVar5 = new b(split[0] + "://" + sb.toString(), aVar.f897c);
            AppMethodBeat.o(15353);
            return bVar5;
        }
    }

    private boolean nextRecordIdx(boolean z) {
        AppMethodBeat.i(15354);
        if (this.mIpList == null || this.mIpList.size() == 0) {
            AppMethodBeat.o(15354);
            return false;
        }
        if (z) {
            this.mIpList.get(this.mCurrentRecordIdx).f899e++;
        }
        if (this.mCurrentRecordIdx + 1 < this.mIpList.size()) {
            this.mCurrentRecordIdx++;
            AppMethodBeat.o(15354);
            return true;
        }
        AppMethodBeat.o(15354);
        return false;
    }

    private String getAddressFromUrl(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        AppMethodBeat.i(15355);
        if (str == null || (indexOf = str.indexOf("://")) == -1 || (indexOf2 = (substring = str.substring(indexOf + 3)).indexOf(FilePathGenerator.ANDROID_DIR_SEP)) == -1) {
            AppMethodBeat.o(15355);
            return "";
        }
        String substring2 = substring.substring(0, indexOf2);
        AppMethodBeat.o(15355);
        return substring2;
    }

    private void reconnect(final boolean z) {
        AppMethodBeat.i(15356);
        stopPushTask();
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.liteav.network.TXCStreamUploader.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(15335);
                    TXCStreamUploader.access$3000(TXCStreamUploader.this, z);
                    AppMethodBeat.o(15335);
                }
            }, (long) (this.mParam.f988g * 1000));
        }
        AppMethodBeat.o(15356);
    }

    private void internalReconnect(boolean z) {
        AppMethodBeat.i(15357);
        if (!this.mIsPushing) {
            AppMethodBeat.o(15357);
        } else if (!this.mRtmpProxyEnable) {
            this.mUploadQualityReport.c();
            if (!this.mEnableNearestIP || this.mLastNetworkType == f.e(this.mContext)) {
                if (!this.mEnableNearestIP) {
                    z = false;
                }
                if (this.mQuicChannel) {
                    z = true;
                }
                if (z && !nextRecordIdx(true)) {
                    TXCLog.e(TAG, "reconnect: try all addresses failed");
                    TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect upload server failed(try all addresses failed)", 0);
                }
                b rtmpRealConnectInfo = getRtmpRealConnectInfo();
                String addressFromUrl = getAddressFromUrl(rtmpRealConnectInfo.f892a);
                TXCLog.e(TAG, "reconnect change ip: " + addressFromUrl + " enableNearestIP: " + this.mEnableNearestIP + " last channel type: " + (this.mQuicChannel ? "Q Channel" : "TCP"));
                if (this.mQuicChannel) {
                    TXCLog.e(TAG, "reconnect last channel type is Q Channel，ignore retry limit");
                    Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s]", addressFromUrl), "", 0);
                    startPushTask(rtmpRealConnectInfo.f892a, rtmpRealConnectInfo.f893b, 0);
                    sendNotifyEvent(1102);
                    AppMethodBeat.o(15357);
                    return;
                }
                TXCLog.e(TAG, "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f987f);
                if (this.mRetryCount < this.mParam.f987f) {
                    this.mRetryCount++;
                    Monitor.a(2, String.format("Network: reconnecting to upload server with tcp.[addr:%s][retryCount:%d][retryLimit:%d]", addressFromUrl, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f987f)), "", 0);
                    TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect upload server:(retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f987f + ")", 0);
                    startPushTask(rtmpRealConnectInfo.f892a, rtmpRealConnectInfo.f893b, 0);
                    sendNotifyEvent(1102);
                    AppMethodBeat.o(15357);
                    return;
                }
                TXCLog.e(TAG, "reconnect: try all times failed");
                TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect upload server failed(try all times failed)", 0);
                sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL);
                AppMethodBeat.o(15357);
                return;
            }
            TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + f.e(this.mContext));
            this.mLastNetworkType = f.e(this.mContext);
            this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
            this.mRetryCount = 0;
            AppMethodBeat.o(15357);
        } else if (this.mLastNetworkType != f.e(this.mContext)) {
            TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + f.e(this.mContext));
            this.mLastNetworkType = f.e(this.mContext);
            this.mRetryCount = 0;
            Monitor.a(2, "WebrtcRoom: need enter again by user", "", 0);
            sendNotifyEvent(1021, String.format("Network type has changed. Need to re-enter the room", new Object[0]));
            AppMethodBeat.o(15357);
        } else if (this.mRetryCount < this.mParam.f987f) {
            this.mRetryCount++;
            Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", this.mRtmpProxyParam.f889h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f987f)), "", 0);
            TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect rtmp-proxy server(econnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f987f + ")", 0);
            sendNotifyEvent(1102);
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            AppMethodBeat.o(15357);
        } else if (getNextRtmpProxyIP()) {
            this.mRetryCount = 0;
            Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", this.mRtmpProxyParam.f889h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f987f)), "", 0);
            sendNotifyEvent(1102);
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            AppMethodBeat.o(15357);
        } else {
            TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect rtmp-proxy server failed(try all addresses)", 0);
            sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL);
            AppMethodBeat.o(15357);
        }
    }

    private void sendNotifyEvent(int i2, String str) {
        AppMethodBeat.i(15358);
        if (str == null || str.isEmpty()) {
            sendNotifyEvent(i2);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            f.a(this.mNotifyListener, i2, bundle);
        }
        if (i2 == 1002) {
            UploadStats uploadStats = getUploadStats();
            if (uploadStats != null) {
                this.mUploadQualityReport.a(uploadStats.dnsparseTimeCost, uploadStats.connectTimeCost, uploadStats.handshakeTimeCost);
            }
            AppMethodBeat.o(15358);
            return;
        }
        if (i2 == 1101) {
            this.mUploadQualityReport.d();
        }
        AppMethodBeat.o(15358);
    }

    private void sendNotifyEvent(int i2) {
        AppMethodBeat.i(15359);
        if (i2 == 0) {
            reconnect(false);
            AppMethodBeat.o(15359);
        } else if (i2 == 1) {
            reconnect(true);
            AppMethodBeat.o(15359);
        } else {
            if (i2 == 1001) {
                this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
            }
            if (i2 == 1026) {
                if (this.mRtmpProxyEnable) {
                    synchronized (this.mRtmpMsgRecvThreadLock) {
                        try {
                            nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                        } finally {
                            AppMethodBeat.o(15359);
                        }
                    }
                    synchronized (this.mRtmpProxyLock) {
                        try {
                            nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                        } finally {
                            AppMethodBeat.o(15359);
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(104, 2000);
                    }
                }
                return;
            }
            if (this.mNotifyListener != null) {
                Bundle bundle = new Bundle();
                switch (i2) {
                    case TXLiteAVCode.ERR_PLAY_LIVE_STREAM_SERVER_REFUSE:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "The server rejects the connection request. It may be that the push URL has been occupied or expired, or the anti-leech link is wrong.");
                        break;
                    case TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "No internet. Please check if WiFi or mobile data is turned on");
                        break;
                    case TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Failed to connect all IPs, abort connection.");
                        break;
                    case -1307:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "failed to connect server for several times, abort connection");
                        break;
                    case 1001:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Already connected to rtmp server");
                        break;
                    case 1002:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "rtmp start push stream");
                        break;
                    case TXLiteAVCode.EVT_RTMP_PUSH_PUBLISH_START:
                        if (this.mRtmpProxyEnable) {
                            synchronized (this.mRtmpMsgRecvThreadLock) {
                                try {
                                    nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                                } finally {
                                    AppMethodBeat.o(15359);
                                }
                            }
                            synchronized (this.mRtmpProxyLock) {
                                try {
                                    nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                                } finally {
                                    AppMethodBeat.o(15359);
                                }
                            }
                            if (this.mHandler != null) {
                                this.mHandler.sendEmptyMessageDelayed(104, 2000);
                            }
                        }
                        return;
                    case 1101:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Insufficient upstream bandwidth. Data transmission is not timely");
                        break;
                    case 1102:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Enables network reconnection");
                        break;
                    case 3003:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP servers handshake failed");
                        break;
                    case TXLiteAVCode.WARNING_RTMP_NO_DATA:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "No data is sent for more than 30s. Actively disconnect");
                        break;
                    case TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Failed to connect server");
                        break;
                    default:
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN");
                        break;
                }
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                f.a(this.mNotifyListener, i2, bundle);
            }
            AppMethodBeat.o(15359);
        }
    }

    private void reportNetStatus() {
        long j2;
        AppMethodBeat.i(15360);
        long timeTick = TXCTimeUtil.getTimeTick();
        long j3 = timeTick - this.mLastTimeStamp;
        UploadStats uploadStats = getUploadStats();
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        if (uploadStats != null) {
            if (this.mLastUploadStats != null) {
                long longValue = getSpeed(this.mLastUploadStats.inVideoBytes, uploadStats.inVideoBytes, j3).longValue();
                long longValue2 = getSpeed(this.mLastUploadStats.inAudioBytes, uploadStats.inAudioBytes, j3).longValue();
                long longValue3 = getSpeed(this.mLastUploadStats.outVideoBytes, uploadStats.outVideoBytes, j3).longValue();
                j6 = getSpeed(this.mLastUploadStats.outAudioBytes, uploadStats.outAudioBytes, j3).longValue();
                j5 = longValue3;
                j4 = longValue2;
                j2 = longValue;
            } else {
                j2 = 0;
            }
            setStatusValue(7005, Long.valueOf(uploadStats.videoCacheLen));
            setStatusValue(7006, Long.valueOf(uploadStats.audioCacheLen));
            setStatusValue(7007, Long.valueOf(uploadStats.videoDropCount));
            setStatusValue(7008, Long.valueOf(uploadStats.audioDropCount));
            setStatusValue(7021, Long.valueOf(uploadStats.bandwidthEst));
            setStatusValue(7009, Long.valueOf(uploadStats.startTS));
            setStatusValue(7010, Long.valueOf(uploadStats.dnsTS));
            setStatusValue(7011, Long.valueOf(uploadStats.connTS));
            setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            setStatusValue(7013, Long.valueOf(this.mQuicChannel ? 2 : 1));
            setStatusValue(7014, uploadStats.connectionID);
            setStatusValue(7015, uploadStats.connectionStats);
            this.mUploadQualityReport.a(uploadStats.videoDropCount, uploadStats.audioDropCount);
            this.mUploadQualityReport.b(uploadStats.videoCacheLen, uploadStats.audioCacheLen);
        } else {
            setStatusValue(7005, 0L);
            setStatusValue(7006, 0L);
            setStatusValue(7007, 0L);
            setStatusValue(7008, 0L);
            j2 = 0;
        }
        setStatusValue(TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL, Long.valueOf(j2));
        setStatusValue(7002, Long.valueOf(j4));
        setStatusValue(7003, Long.valueOf(j5));
        setStatusValue(7004, Long.valueOf(j6));
        this.mLastTimeStamp = timeTick;
        this.mLastUploadStats = uploadStats;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(103, 2000);
        }
        AppMethodBeat.o(15360);
    }

    private Long getSpeed(long j2, long j3, long j4) {
        long j5 = 0;
        AppMethodBeat.i(15361);
        if (j2 <= j3) {
            j3 -= j2;
        }
        if (j4 > 0) {
            j5 = ((8 * j3) * 1000) / (1024 * j4);
        }
        Long valueOf = Long.valueOf(j5);
        AppMethodBeat.o(15361);
        return valueOf;
    }

    private boolean isQCloudStreamUrl(String str) {
        String substring;
        AppMethodBeat.i(15362);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(15362);
            return false;
        }
        int indexOf = str.indexOf("://");
        if (indexOf == -1 || (substring = str.substring("://".length() + indexOf)) == null || !substring.startsWith("cloud.tencent.com")) {
            AppMethodBeat.o(15362);
            return false;
        }
        AppMethodBeat.o(15362);
        return true;
    }

    private void parseProxyInfo(String str) {
        AppMethodBeat.i(15363);
        if (str == null || str.length() == 0 || !str.startsWith("room")) {
            AppMethodBeat.o(15363);
            return;
        }
        this.mRtmpProxyParam.f890i = isQCloudStreamUrl(str);
        HashMap paramsFromUrl = getParamsFromUrl(str);
        if (paramsFromUrl == null) {
            AppMethodBeat.o(15363);
            return;
        }
        if (paramsFromUrl.containsKey("sdkappid")) {
            this.mRtmpProxyParam.f882a = Long.valueOf((String) paramsFromUrl.get("sdkappid")).longValue();
        }
        if (!paramsFromUrl.containsKey("roomid") || !paramsFromUrl.containsKey("userid") || !paramsFromUrl.containsKey("roomsig")) {
            AppMethodBeat.o(15363);
            return;
        }
        this.mRtmpProxyParam.f885d = Long.valueOf((String) paramsFromUrl.get("roomid")).longValue();
        this.mRtmpProxyParam.f884c = (String) paramsFromUrl.get("userid");
        if (paramsFromUrl.containsKey("bizbuf")) {
            try {
                this.mRtmpProxyParam.f891j = URLDecoder.decode((String) paramsFromUrl.get("bizbuf"), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (Exception e2) {
                TXCLog.e(TAG, "decode bizbuf failed.", e2);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(URLDecoder.decode((String) paramsFromUrl.get("roomsig"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            this.mRtmpProxyParam.f883b = 0;
            if (!jSONObject.has("Key")) {
                AppMethodBeat.o(15363);
                return;
            }
            this.mRtmpProxyParam.f886e = jSONObject.optString("Key");
            JSONObject optJSONObject = jSONObject.optJSONObject("RtmpProxy");
            if (optJSONObject == null || (optJSONObject.has("Ip") && optJSONObject.has("Port") && optJSONObject.has("Type"))) {
                JSONArray optJSONArray = jSONObject.optJSONArray("AccessList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        if (jSONObject2 != null && jSONObject2.has("Ip") && jSONObject2.has("Port") && jSONObject2.has("Type")) {
                            String optString = jSONObject2.optString("Ip");
                            long optLong = jSONObject2.optLong("Port");
                            if (jSONObject2.optLong("Type") == 2) {
                                this.mRtmpProxyIPList.add(optString + ":" + optLong);
                            }
                        }
                    }
                }
                if (!this.mRtmpProxyParam.f890i) {
                    this.mRtmpUrl = str;
                    this.mQuicChannel = false;
                } else if (optJSONObject == null) {
                    AppMethodBeat.o(15363);
                    return;
                } else {
                    this.mRtmpUrl = str.substring(0, str.indexOf("?")) + "/webrtc/" + (this.mRtmpProxyParam.f882a + "_" + this.mRtmpProxyParam.f885d + "_" + this.mRtmpProxyParam.f884c) + "?real_rtmp_ip=" + optJSONObject.optString("Ip") + "&real_rtmp_port=" + optJSONObject.optLong("Port") + "&tinyid=" + this.mRtmpProxyParam.f883b + "&srctinyid=0";
                    getNextRtmpProxyIP();
                }
                this.mRtmpProxyEnable = true;
                AppMethodBeat.o(15363);
                return;
            }
            AppMethodBeat.o(15363);
        } catch (Exception e3) {
            TXCLog.e(TAG, "parse proxy info failed.", e3);
            AppMethodBeat.o(15363);
        }
    }

    private HashMap getParamsFromUrl(String str) {
        AppMethodBeat.i(15364);
        HashMap hashMap = new HashMap();
        String[] split = str.split("[?]");
        if (split == null || split.length < 2 || split[1] == null || split[1].length() == 0) {
            AppMethodBeat.o(15364);
        } else {
            String[] split2 = split[1].split("[&]");
            for (String str2 : split2) {
                if (str2.indexOf("=") != -1) {
                    String[] split3 = str2.split("[=]");
                    if (split3.length == 2) {
                        hashMap.put(split3[0], split3[1]);
                    }
                }
            }
            AppMethodBeat.o(15364);
        }
        return hashMap;
    }

    private boolean getNextRtmpProxyIP() {
        AppMethodBeat.i(15365);
        this.mRtmpProxyParam.f887f = 234;
        this.mRtmpProxyParam.f888g = 80;
        if (this.mRtmpProxyIPList == null || this.mRtmpProxyIPList.size() <= 0) {
            AppMethodBeat.o(15365);
            return false;
        } else if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size()) {
            this.mRtmpProxyIPIndex = 0;
            AppMethodBeat.o(15365);
            return false;
        } else {
            String[] split = this.mRtmpUrl.split("://");
            if (split.length < 2) {
                AppMethodBeat.o(15365);
                return false;
            }
            String substring = split[1].substring(split[1].indexOf(FilePathGenerator.ANDROID_DIR_SEP));
            String str = this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
            this.mRtmpProxyParam.f889h = str;
            this.mRtmpUrl = "room://" + str + substring;
            this.mQuicChannel = true;
            this.mRtmpProxyIPIndex++;
            AppMethodBeat.o(15365);
            return true;
        }
    }

    private void rtmpProxySendHeartBeat() {
        AppMethodBeat.i(15366);
        int[] a2 = f.a();
        long j2 = (long) (a2[0] / 10);
        long j3 = (long) (a2[1] / 10);
        long c2 = (long) TXCStatus.c(getID(), 7004);
        long c3 = (long) TXCStatus.c(getID(), 7003);
        long c4 = (long) TXCStatus.c(getID(), 1001);
        long c5 = (long) TXCStatus.c(getID(), 4001);
        long c6 = (long) TXCStatus.c(getID(), 7006);
        long c7 = (long) TXCStatus.c(getID(), 7005);
        long c8 = (long) TXCStatus.c(getID(), 7008);
        long c9 = (long) TXCStatus.c(getID(), 7007);
        synchronized (this.mRtmpProxyLock) {
            try {
                nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, j2, j3, c2, c3, c4, c5, c6, c7, c8, c9);
            } finally {
                AppMethodBeat.o(15366);
            }
        }
    }

    private void onSendRtmpProxyMsg(byte[] bArr) {
        AppMethodBeat.i(15367);
        synchronized (this.mThreadLock) {
            try {
                if (this.mUploaderInstance != 0) {
                    nativeSendRtmpProxyMsg(this.mUploaderInstance, bArr);
                }
            } finally {
                AppMethodBeat.o(15367);
            }
        }
    }

    private void onRtmpProxyUserListPushed(RtmpProxyUserInfo[] rtmpProxyUserInfoArr) {
        AppMethodBeat.i(15368);
        if (rtmpProxyUserInfoArr == null) {
            AppMethodBeat.o(15368);
        } else if (!this.mIsPushing) {
            AppMethodBeat.o(15368);
        } else if (!this.mRtmpProxyEnable || this.mRtmpProxyParam == null) {
            AppMethodBeat.o(15368);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < rtmpProxyUserInfoArr.length; i2++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", rtmpProxyUserInfoArr[i2].account);
                    jSONObject.put("playurl", rtmpProxyUserInfoArr[i2].playUrl);
                    if (rtmpProxyUserInfoArr[i2].stmType == 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        jSONArray2.put(jSONObject);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userlist", jSONArray);
                jSONObject2.put("userlist_aux", jSONArray2);
                sendNotifyEvent(1020, jSONObject2.toString());
                AppMethodBeat.o(15368);
            } catch (Exception e2) {
                TXCLog.e(TAG, "build json object failed.", e2);
                AppMethodBeat.o(15368);
            }
        }
    }

    private void onRtmpProxyRoomEvent(int i2, int i3) {
        AppMethodBeat.i(15369);
        if (i2 == 1) {
            sendNotifyEvent(1018, String.format("Already in room，[%d]", Integer.valueOf(i3)));
            AppMethodBeat.o(15369);
            return;
        }
        if (i2 == 2) {
            sendNotifyEvent(1019, String.format("Not in the room，[%d]", Integer.valueOf(i3)));
        }
        AppMethodBeat.o(15369);
    }
}
