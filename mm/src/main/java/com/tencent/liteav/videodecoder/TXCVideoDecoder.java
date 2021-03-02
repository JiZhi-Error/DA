package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class TXCVideoDecoder implements b, g {
    private static final boolean NEW_DECODER = true;
    private static final String TAG = "TXCVideoDecoder";
    private static long mDecodeFirstFrameTS = 0;
    private JSONArray mDecFormat = null;
    private int mDecoderCacheNum;
    private a mDecoderHandler;
    g mDecoderListener;
    private boolean mEnableDecoderChange = false;
    private boolean mEnableLimitDecCache = false;
    private boolean mEnableRestartDecoder = false;
    boolean mHWDec = true;
    boolean mHevc = false;
    private ArrayList<TXSNALPacket> mNALList = new ArrayList<>();
    private long mNativeContext;
    boolean mNeedSortFrame = true;
    private WeakReference<b> mNotifyListener;
    private ByteBuffer mPps;
    boolean mRecvFirstFrame = false;
    private boolean mRestarting = false;
    private ByteBuffer mSps;
    private int mStreamType = 0;
    Surface mSurface;
    private String mUserId;
    b mVideoDecoder;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    private native long nativeCreateContext(boolean z, Object obj);

    private native void nativeDecCache(long j2);

    private native void nativeDecodeFrame(long j2, byte[] bArr, int i2, long j3, long j4, int i3, int i4);

    private native void nativeDestroyContext(long j2);

    private native void nativeEnableDecodeChange(long j2, boolean z);

    private native void nativeEnableRestartDecoder(long j2, boolean z);

    private native void nativeNotifyHWDecoderError(long j2);

    private native void nativeNotifyPts(long j2, long j3, int i2, int i3);

    private native void nativeReStart(long j2, boolean z);

    private native void nativeSetID(long j2, String str);

    private native void nativeSetStreamType(long j2, int i2);

    static {
        AppMethodBeat.i(16641);
        f.f();
        AppMethodBeat.o(16641);
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(16615);
        if (i2 == -2304) {
            nativeNotifyHWDecoderError(this.mNativeContext);
        }
        f.a(this.mNotifyListener, this.mUserId, i2, bundle);
        AppMethodBeat.o(16615);
    }

    public void setUserId(String str) {
        AppMethodBeat.i(16616);
        this.mUserId = str;
        synchronized (this) {
            try {
                nativeSetID(this.mNativeContext, this.mUserId);
            } finally {
                AppMethodBeat.o(16616);
            }
        }
    }

    public void setStreamType(int i2) {
        AppMethodBeat.i(16617);
        this.mStreamType = i2;
        synchronized (this) {
            try {
                nativeSetStreamType(this.mNativeContext, this.mStreamType);
            } finally {
                AppMethodBeat.o(16617);
            }
        }
    }

    public void enableChange(boolean z) {
        AppMethodBeat.i(16618);
        this.mEnableDecoderChange = z;
        synchronized (this) {
            try {
                nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
            } finally {
                AppMethodBeat.o(16618);
            }
        }
    }

    public void enableLimitDecCache(boolean z) {
        AppMethodBeat.i(222610);
        this.mEnableLimitDecCache = z;
        b bVar = this.mVideoDecoder;
        if (bVar != null) {
            bVar.enableLimitDecCache(this.mEnableLimitDecCache);
        }
        AppMethodBeat.o(222610);
    }

    public void config(JSONArray jSONArray) {
        this.mDecFormat = jSONArray;
    }

    public void enableRestart(boolean z) {
        this.mEnableRestartDecoder = z;
    }

    public TXCVideoDecoder() {
        AppMethodBeat.i(16619);
        mDecodeFirstFrameTS = 0;
        AppMethodBeat.o(16619);
    }

    public void setListener(g gVar) {
        this.mDecoderListener = gVar;
    }

    public boolean isHardwareDecode() {
        return this.mVideoDecoder != null;
    }

    public void setNotifyListener(b bVar) {
        AppMethodBeat.i(222611);
        this.mNotifyListener = new WeakReference<>(bVar);
        AppMethodBeat.o(222611);
    }

    public int setup(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        AppMethodBeat.i(16621);
        synchronized (this) {
            try {
                if (this.mSurface != null) {
                    this.mSurface.release();
                    this.mSurface = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(16621);
                throw th;
            }
        }
        int upVar = setup(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z);
        AppMethodBeat.o(16621);
        return upVar;
    }

    public int setup(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        synchronized (this) {
            this.mSurface = surface;
        }
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mNeedSortFrame = z;
        return 0;
    }

    public void enableHWDec(boolean z) {
        this.mHWDec = z;
    }

    private void addOneNalToDecoder(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(16622);
        boolean z = tXSNALPacket.nalType == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", tXSNALPacket.nalData);
        bundle.putLong("pts", tXSNALPacket.pts);
        bundle.putLong("dts", tXSNALPacket.dts);
        bundle.putInt("codecId", tXSNALPacket.codecId);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        a aVar = this.mDecoderHandler;
        if (aVar != null) {
            aVar.sendMessage(message);
        }
        this.mDecoderCacheNum++;
        AppMethodBeat.o(16622);
    }

    private void decNALByNewWay(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(16623);
        if (this.mHWDec) {
            decodeFrame(tXSNALPacket.nalData, tXSNALPacket.pts, tXSNALPacket.dts, tXSNALPacket.rotation, tXSNALPacket.codecId, 0, 0, tXSNALPacket.nalType);
            AppMethodBeat.o(16623);
            return;
        }
        synchronized (this) {
            try {
                nativeDecodeFrame(this.mNativeContext, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.pts, tXSNALPacket.dts, tXSNALPacket.rotation, tXSNALPacket.codecId);
            } finally {
                AppMethodBeat.o(16623);
            }
        }
    }

    private void decNALByOldWay(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(16624);
        try {
            boolean z = tXSNALPacket.nalType == 0;
            if (this.mRecvFirstFrame || z) {
                if (!this.mRecvFirstFrame && z) {
                    TXCLog.w(TAG, "play:decode: push first i frame");
                    this.mRecvFirstFrame = true;
                }
                if (!this.mRestarting && tXSNALPacket.codecId == 1 && !this.mHWDec) {
                    TXCLog.w(TAG, "play:decode: hevc decode error  ");
                    f.a(this.mNotifyListener, -2304, "h265 Decoding failed");
                    this.mRestarting = true;
                }
                if (this.mDecoderHandler != null) {
                    if (!this.mNALList.isEmpty()) {
                        Iterator<TXSNALPacket> it = this.mNALList.iterator();
                        while (it.hasNext()) {
                            addOneNalToDecoder(it.next());
                        }
                    }
                    this.mNALList.clear();
                    addOneNalToDecoder(tXSNALPacket);
                    AppMethodBeat.o(16624);
                    return;
                }
                if (z && !this.mNALList.isEmpty()) {
                    this.mNALList.clear();
                }
                this.mNALList.add(tXSNALPacket);
                if (!this.mRestarting) {
                    start();
                }
                AppMethodBeat.o(16624);
                return;
            }
            TXCLog.i(TAG, "play:decode: push nal ignore p frame when not got i frame");
            AppMethodBeat.o(16624);
        } catch (Exception e2) {
            TXCLog.e(TAG, "decode NAL By Old way failed.", e2);
            AppMethodBeat.o(16624);
        }
    }

    public void pushNAL(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(16625);
        decNALByNewWay(tXSNALPacket);
        AppMethodBeat.o(16625);
    }

    public synchronized int start() {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(16626);
            if (this.mHWDec && this.mSurface == null) {
                TXCLog.i(TAG, "play:decode: start decoder error when not setup surface, id " + this.mUserId + "_" + this.mStreamType);
                AppMethodBeat.o(16626);
            } else if (this.mNativeContext != 0) {
                TXCLog.w(TAG, "play:decode: start decoder error when decoder is started, id " + this.mUserId + "_" + this.mStreamType);
                AppMethodBeat.o(16626);
            } else {
                TXCLog.i(TAG, "[FirstFramePath][Video][Decoder] TXCVideoDecoder: start decode. instance:" + this + " userId:" + this.mUserId + " type:" + this.mStreamType);
                this.mNativeContext = nativeCreateContext(this.mHWDec, com.tencent.liteav.basic.a.b());
                nativeSetID(this.mNativeContext, this.mUserId);
                nativeSetStreamType(this.mNativeContext, this.mStreamType);
                nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
                nativeEnableRestartDecoder(this.mNativeContext, this.mEnableRestartDecoder);
                i2 = 0;
                AppMethodBeat.o(16626);
            }
        }
        return i2;
    }

    public synchronized void stop() {
        AppMethodBeat.i(16627);
        if (this.mNativeContext == 0) {
            TXCLog.w(TAG, "play:decode: stop decoder ignore when decoder is stopped, id " + this.mUserId + "_" + this.mStreamType);
            AppMethodBeat.o(16627);
        } else {
            TXCLog.w(TAG, "play:decode: stop decoder java id " + this.mUserId + "_" + this.mStreamType + " " + hashCode());
            nativeDestroyContext(this.mNativeContext);
            this.mNativeContext = 0;
            this.mNALList.clear();
            this.mRecvFirstFrame = false;
            this.mDecoderCacheNum = 0;
            mDecodeFirstFrameTS = 0;
            synchronized (this) {
                try {
                    if (this.mVideoDecoder != null) {
                        this.mVideoDecoder.stop();
                        this.mVideoDecoder.setListener(null);
                        this.mVideoDecoder.setNotifyListener(null);
                        this.mVideoDecoder = null;
                    }
                    if (this.mSurface != null) {
                        this.mSurface.release();
                        this.mSurface = null;
                    }
                } finally {
                    AppMethodBeat.o(16627);
                }
            }
        }
    }

    public void restart(boolean z) {
        AppMethodBeat.i(16628);
        synchronized (this) {
            try {
                this.mHWDec = z;
                nativeReStart(this.mNativeContext, this.mHWDec);
            } finally {
                AppMethodBeat.o(16628);
            }
        }
    }

    public int getDecoderCacheNum() {
        AppMethodBeat.i(16629);
        int size = this.mDecoderCacheNum + this.mNALList.size();
        AppMethodBeat.o(16629);
        return size;
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i2, int i3, long j2, long j3, int i4) {
        AppMethodBeat.i(16630);
        if (mDecodeFirstFrameTS == 0) {
            mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
            TXCLog.i(TAG, "[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:" + hashCode() + " isHWAcc:true isHEVC:" + this.mHevc + " userId:" + this.mUserId + " type:" + this.mStreamType);
            TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
            TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(this.mHevc ? 3 : 1));
        }
        if (this.mDecoderListener != null) {
            this.mDecoderListener.onDecodeFrame(tXSVideoFrame, i2, i3, j2, j3, i4);
        }
        if (this.mDecoderCacheNum > 0) {
            this.mDecoderCacheNum--;
        }
        if (tXSVideoFrame == null) {
            synchronized (this) {
                try {
                    nativeNotifyPts(this.mNativeContext, j2, i2, i3);
                } catch (Throwable th) {
                    AppMethodBeat.o(16630);
                    throw th;
                }
            }
        }
        int GetDecodeCost = this.mVideoDecoder.GetDecodeCost();
        if (this.mHWDec) {
            TXCStatus.a(this.mUserId, 8004, this.mStreamType, Integer.valueOf(GetDecodeCost));
            AppMethodBeat.o(16630);
            return;
        }
        TXCStatus.a(this.mUserId, TXLiteAVCode.EVT_ROOM_REQUEST_AVSEAT_SUCC, this.mStreamType, Integer.valueOf(GetDecodeCost));
        AppMethodBeat.o(16630);
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onVideoSizeChange(int i2, int i3) {
        AppMethodBeat.i(16631);
        g gVar = this.mDecoderListener;
        if (!(gVar == null || (this.mVideoWidth == i2 && this.mVideoHeight == i3))) {
            this.mVideoWidth = i2;
            this.mVideoHeight = i3;
            gVar.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
        }
        AppMethodBeat.o(16631);
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecoderChange(String str, boolean z) {
        AppMethodBeat.i(259964);
        this.mHevc = z;
        TXCLog.i(TAG, "onDecoderChange " + str + " , isHevc = " + z);
        reportDecoderEvent(this.mHWDec, z);
        AppMethodBeat.o(259964);
    }

    @Override // com.tencent.liteav.videodecoder.g
    public void onDecodeFailed(int i2) {
        AppMethodBeat.i(16632);
        TXCStatus.a(this.mUserId, 9007, this.mStreamType, Integer.valueOf(i2));
        if (this.mDecoderListener != null) {
            this.mDecoderListener.onDecodeFailed(i2);
        }
        synchronized (this) {
            try {
                nativeDecCache(this.mNativeContext);
            } finally {
                AppMethodBeat.o(16632);
            }
        }
    }

    public boolean isHevc() {
        AppMethodBeat.i(16633);
        boolean z = this.mHevc;
        AppMethodBeat.o(16633);
        return z;
    }

    public long GetDecodeFirstFrameTS() {
        return mDecodeFirstFrameTS;
    }

    private int startDecodeThread() {
        AppMethodBeat.i(16634);
        synchronized (this) {
            try {
                if (this.mDecoderHandler != null) {
                    TXCLog.e(TAG, "play:decode: start decoder error when decoder is started");
                    return -1;
                }
                this.mDecoderCacheNum = 0;
                this.mRestarting = false;
                HandlerThread handlerThread = new HandlerThread("VDecoder");
                handlerThread.start();
                if (this.mHWDec) {
                    handlerThread.setName("VideoWDec" + handlerThread.getId());
                } else {
                    handlerThread.setName("VideoSWDec" + handlerThread.getId());
                }
                a aVar = new a(handlerThread.getLooper());
                aVar.a(this.mHevc, this.mHWDec, this.mSurface, this.mSps, this.mPps, this, this);
                TXCLog.w(TAG, "play:decode: start decode thread");
                Message obtain = Message.obtain();
                obtain.what = 100;
                obtain.obj = Boolean.valueOf(this.mNeedSortFrame);
                aVar.sendMessage(obtain);
                this.mDecoderHandler = aVar;
                AppMethodBeat.o(16634);
                return 0;
            } finally {
                AppMethodBeat.o(16634);
            }
        }
    }

    private void stopDecodeThread() {
        AppMethodBeat.i(16635);
        synchronized (this) {
            try {
                if (this.mDecoderHandler != null) {
                    this.mDecoderHandler.sendEmptyMessage(102);
                }
                this.mDecoderHandler = null;
            } finally {
                AppMethodBeat.o(16635);
            }
        }
    }

    private void notifyDecoderStartEvent(boolean z, boolean z2) {
        long j2 = 1;
        AppMethodBeat.i(259965);
        TXCEventRecorderProxy.a(this.mUserId, WearableStatusCodes.ASSET_UNAVAILABLE, z ? 1 : 0, -1, "", this.mStreamType);
        reportDecoderEvent(z, z2);
        String str = this.mUserId;
        if (!z) {
            j2 = 2;
        }
        TXCKeyPointReportProxy.a(str, 40026, j2, this.mStreamType);
        AppMethodBeat.o(259965);
    }

    private void reportDecoderEvent(boolean z, boolean z2) {
        AppMethodBeat.i(259966);
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", 2008);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        StringBuilder sb = new StringBuilder("Enables ");
        if (z2) {
            sb.append("HEVC ");
        } else {
            sb.append("H264 ");
        }
        if (z) {
            sb.append("hardware ");
        } else {
            sb.append("software ");
        }
        sb.append("decoding");
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, sb.toString());
        bundle.putInt("EVT_PARAM1", z ? 1 : 2);
        f.a(this.mNotifyListener, this.mUserId, 2008, bundle);
        TXCLog.i(TAG, "start video decoder:" + sb.toString());
        AppMethodBeat.o(259966);
    }

    private boolean hasSurface() {
        return this.mSurface != null;
    }

    private void onDecodeDone(TXSVideoFrame tXSVideoFrame, int i2, int i3, long j2, long j3, int i4, int i5) {
        AppMethodBeat.i(16637);
        if (mDecodeFirstFrameTS == 0) {
            mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
            TXCLog.i(TAG, "[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:" + hashCode() + " isHWAcc:false isHEVC:" + this.mHevc + " userId:" + this.mUserId + " type:" + this.mStreamType);
            TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
            TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(this.mHevc ? 2 : 0));
        }
        g gVar = this.mDecoderListener;
        if (gVar != null) {
            tXSVideoFrame.width = i2;
            tXSVideoFrame.height = i3;
            tXSVideoFrame.rotation = i4;
            tXSVideoFrame.pts = j2;
            tXSVideoFrame.frameType = i5;
            gVar.onDecodeFrame(tXSVideoFrame, i2, i3, j2, j3, i4);
            if (!(this.mVideoWidth == i2 && this.mVideoHeight == i3)) {
                this.mVideoWidth = i2;
                this.mVideoHeight = i3;
                gVar.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
            }
        }
        AppMethodBeat.o(16637);
    }

    private void decodeFrame(byte[] bArr, long j2, long j3, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(222612);
        TXSNALPacket tXSNALPacket = new TXSNALPacket();
        tXSNALPacket.nalData = bArr;
        tXSNALPacket.pts = j2;
        tXSNALPacket.dts = j3;
        tXSNALPacket.rotation = i2;
        tXSNALPacket.codecId = i3;
        tXSNALPacket.nalType = i6;
        synchronized (this) {
            try {
                if (this.mNativeContext != 0 && this.mVideoDecoder == null) {
                    if (i3 == 1) {
                        this.mHevc = true;
                    } else {
                        this.mHevc = false;
                    }
                    f fVar = new f();
                    fVar.a(i4, i5);
                    fVar.setListener(this);
                    fVar.setNotifyListener(new WeakReference<>(this));
                    fVar.a(this.mDecFormat);
                    fVar.config(this.mSurface);
                    fVar.enableLimitDecCache(this.mEnableLimitDecCache);
                    fVar.start(this.mSps, this.mPps, this.mNeedSortFrame, this.mHevc);
                    notifyDecoderStartEvent(true, this.mHevc);
                    this.mVideoDecoder = fVar;
                }
                if (this.mVideoDecoder != null) {
                    this.mVideoDecoder.decode(tXSNALPacket);
                }
            } finally {
                AppMethodBeat.o(222612);
            }
        }
    }

    private synchronized void stopHWDecoder() {
        AppMethodBeat.i(16639);
        if (this.mVideoDecoder != null) {
            this.mVideoDecoder.stop();
            this.mVideoDecoder.setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            this.mVideoDecoder = null;
        }
        AppMethodBeat.o(16639);
    }

    private void onStartDecoder(boolean z, boolean z2) {
        AppMethodBeat.i(259967);
        this.mHevc = z2;
        notifyDecoderStartEvent(z, this.mHevc);
        AppMethodBeat.o(259967);
    }

    /* access modifiers changed from: package-private */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        b f1206a;

        /* renamed from: b  reason: collision with root package name */
        g f1207b;

        /* renamed from: c  reason: collision with root package name */
        WeakReference<b> f1208c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1209d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1210e;

        /* renamed from: f  reason: collision with root package name */
        Surface f1211f;

        /* renamed from: g  reason: collision with root package name */
        private ByteBuffer f1212g;

        /* renamed from: h  reason: collision with root package name */
        private ByteBuffer f1213h;

        public a(Looper looper) {
            super(looper);
        }

        public void a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, g gVar, b bVar) {
            AppMethodBeat.i(259962);
            this.f1210e = z;
            this.f1209d = z2;
            this.f1211f = surface;
            this.f1212g = byteBuffer;
            this.f1213h = byteBuffer2;
            this.f1207b = gVar;
            this.f1208c = new WeakReference<>(bVar);
            AppMethodBeat.o(259962);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(16663);
            switch (message.what) {
                case 100:
                    a(((Boolean) message.obj).booleanValue());
                    AppMethodBeat.o(16663);
                    return;
                case 101:
                    try {
                        Bundle data = message.getData();
                        a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                        AppMethodBeat.o(16663);
                        return;
                    } catch (Exception e2) {
                        TXCLog.e(TXCVideoDecoder.TAG, "decode frame failed." + e2.getMessage());
                        AppMethodBeat.o(16663);
                        return;
                    }
                case 102:
                    a();
                    AppMethodBeat.o(16663);
                    return;
                case 103:
                    boolean z2 = message.arg1 == 1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    a(z2, z);
                    break;
            }
            AppMethodBeat.o(16663);
        }

        private void a(byte[] bArr, long j2, long j3, int i2) {
            AppMethodBeat.i(16665);
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.pts = j2;
            tXSNALPacket.dts = j3;
            tXSNALPacket.codecId = i2;
            if (this.f1206a != null) {
                this.f1206a.decode(tXSNALPacket);
            }
            AppMethodBeat.o(16665);
        }

        private void a() {
            AppMethodBeat.i(259963);
            if (this.f1206a != null) {
                this.f1206a.stop();
                this.f1206a.setListener(null);
                this.f1206a.setNotifyListener(null);
                this.f1206a = null;
            }
            Looper.myLooper().quit();
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: stop decode hwdec: " + this.f1209d);
            AppMethodBeat.o(259963);
        }

        private void a(boolean z, boolean z2) {
            AppMethodBeat.i(16667);
            this.f1209d = z;
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: restart decode hwdec: " + this.f1209d);
            if (this.f1206a != null) {
                this.f1206a.stop();
                this.f1206a.setListener(null);
                this.f1206a.setNotifyListener(null);
                this.f1206a = null;
            }
            a(z2);
            AppMethodBeat.o(16667);
        }

        private void a(boolean z) {
            AppMethodBeat.i(16668);
            if (this.f1206a != null) {
                TXCLog.i(TXCVideoDecoder.TAG, "play:decode: start decode ignore hwdec: " + this.f1209d);
                AppMethodBeat.o(16668);
                return;
            }
            if (this.f1209d) {
                this.f1206a = new f();
            } else {
                this.f1206a = new TXCVideoFfmpegDecoder();
            }
            this.f1206a.setListener(this.f1207b);
            this.f1206a.setNotifyListener(this.f1208c);
            this.f1206a.config(this.f1211f);
            this.f1206a.start(this.f1212g, this.f1213h, z, this.f1210e);
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: start decode hwdec: " + this.f1209d + ", hevc: " + this.f1210e);
            AppMethodBeat.o(16668);
        }
    }
}
