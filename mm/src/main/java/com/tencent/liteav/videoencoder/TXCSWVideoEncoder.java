package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.b.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder extends d {
    private static final boolean DEBUG = false;
    private static final String TAG = TXCSWVideoEncoder.class.getSimpleName();
    private int mBitrate = 0;
    private long mNativeEncoder = 0;
    private long mPTS = 0;
    private int mPopIdx = 0;
    private int mPushIdx = 0;
    private h mRawFrameFilter;
    private int mRendIdx = 0;
    private h mResizeFilter;

    private static native void nativeClassInit();

    private native void nativeEnableNearestRPS(long j2, int i2);

    private native int nativeEncode(long j2, int i2, int i3, int i4, long j3);

    private native int nativeEncodeSync(long j2, int i2, int i3, int i4, long j3);

    private static native long nativeGetAndIncreaseGopIndex();

    private static native long nativeGetAndIncreaseSeq();

    private native long nativeGetRealFPS(long j2);

    private native long nativeInit(WeakReference<TXCSWVideoEncoder> weakReference);

    private native void nativeRelease(long j2);

    private native void nativeRestartIDR(long j2);

    private native void nativeSetBitrate(long j2, int i2);

    private native void nativeSetBitrateFromQos(long j2, int i2, int i3);

    private native void nativeSetEncodeIdrFpsFromQos(long j2, int i2);

    private native void nativeSetFPS(long j2, int i2);

    private native void nativeSetID(long j2, String str);

    private native void nativeSetRPSRefBitmap(long j2, int i2, int i3, long j3);

    private native void nativeSignalEOSAndFlush(long j2);

    private native int nativeStart(long j2, TXSVideoEncoderParam tXSVideoEncoderParam);

    private native void nativeStop(long j2);

    private native long nativegetRealBitrate(long j2);

    static /* synthetic */ int access$200(TXCSWVideoEncoder tXCSWVideoEncoder, long j2, int i2, int i3, int i4, long j3) {
        AppMethodBeat.i(14847);
        int nativeEncodeSync = tXCSWVideoEncoder.nativeEncodeSync(j2, i2, i3, i4, j3);
        AppMethodBeat.o(14847);
        return nativeEncodeSync;
    }

    static /* synthetic */ int access$300(TXCSWVideoEncoder tXCSWVideoEncoder, long j2, int i2, int i3, int i4, long j3) {
        AppMethodBeat.i(14848);
        int nativeEncode = tXCSWVideoEncoder.nativeEncode(j2, i2, i3, i4, j3);
        AppMethodBeat.o(14848);
        return nativeEncode;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.i(14826);
        super.start(tXSVideoEncoderParam);
        int i2 = ((tXSVideoEncoderParam.width + 7) / 8) * 8;
        int i3 = ((tXSVideoEncoderParam.height + 1) / 2) * 2;
        if (!(i2 == tXSVideoEncoderParam.width && i3 == tXSVideoEncoderParam.height)) {
            TXCLog.w(TAG, "Encode Resolution not supportted, transforming...");
            TXCLog.w(TAG, tXSVideoEncoderParam.width + "x" + tXSVideoEncoderParam.height + "-> " + i2 + "x" + i3);
        }
        tXSVideoEncoderParam.width = i2;
        tXSVideoEncoderParam.height = i3;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
        this.mInputWidth = i2;
        this.mInputHeight = i3;
        this.mRawFrameFilter = null;
        this.mResizeFilter = null;
        synchronized (this) {
            try {
                this.mNativeEncoder = nativeInit(new WeakReference<>(this));
                nativeSetBitrate(this.mNativeEncoder, this.mBitrate);
                nativeSetID(this.mNativeEncoder, getID());
                nativeStart(this.mNativeEncoder, tXSVideoEncoderParam);
            } catch (Throwable th) {
                AppMethodBeat.o(14826);
                throw th;
            }
        }
        AppMethodBeat.o(14826);
        return 0;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void stop() {
        long j2;
        AppMethodBeat.i(14827);
        TXCLog.i(TAG, "stop->enter with mRawFrameFilter:" + this.mRawFrameFilter);
        this.mGLContextExternal = null;
        synchronized (this) {
            try {
                j2 = this.mNativeEncoder;
                this.mNativeEncoder = 0;
            } catch (Throwable th) {
                AppMethodBeat.o(14827);
                throw th;
            }
        }
        nativeStop(j2);
        nativeRelease(j2);
        if (this.mRawFrameFilter != null) {
            this.mRawFrameFilter.d();
            this.mRawFrameFilter = null;
        }
        if (this.mResizeFilter != null) {
            this.mResizeFilter.d();
            this.mResizeFilter = null;
        }
        super.stop();
        AppMethodBeat.o(14827);
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(14828);
        super.setID(str);
        synchronized (this) {
            try {
                nativeSetID(this.mNativeEncoder, str);
            } finally {
                AppMethodBeat.o(14828);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setFPS(int i2) {
        AppMethodBeat.i(14829);
        synchronized (this) {
            try {
                nativeSetFPS(this.mNativeEncoder, i2);
            } finally {
                AppMethodBeat.o(14829);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void enableNearestRPS(int i2) {
        AppMethodBeat.i(14830);
        synchronized (this) {
            try {
                nativeEnableNearestRPS(this.mNativeEncoder, i2);
            } finally {
                AppMethodBeat.o(14830);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setBitrate(int i2) {
        AppMethodBeat.i(14831);
        this.mBitrate = i2;
        synchronized (this) {
            try {
                nativeSetBitrate(this.mNativeEncoder, i2);
            } finally {
                AppMethodBeat.o(14831);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setBitrateFromQos(int i2, int i3) {
        AppMethodBeat.i(14832);
        this.mBitrate = i2;
        synchronized (this) {
            try {
                nativeSetBitrateFromQos(this.mNativeEncoder, i2, i3);
            } finally {
                AppMethodBeat.o(14832);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setEncodeIdrFpsFromQos(int i2) {
        AppMethodBeat.i(14833);
        synchronized (this) {
            try {
                nativeSetEncodeIdrFpsFromQos(this.mNativeEncoder, i2);
            } finally {
                AppMethodBeat.o(14833);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public double getRealFPS() {
        double nativeGetRealFPS;
        AppMethodBeat.i(14834);
        synchronized (this) {
            try {
                nativeGetRealFPS = (double) nativeGetRealFPS(this.mNativeEncoder);
            } finally {
                AppMethodBeat.o(14834);
            }
        }
        return nativeGetRealFPS;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long getRealBitrate() {
        long nativegetRealBitrate;
        AppMethodBeat.i(14835);
        synchronized (this) {
            try {
                nativegetRealBitrate = nativegetRealBitrate(this.mNativeEncoder);
            } finally {
                AppMethodBeat.o(14835);
            }
        }
        return nativegetRealBitrate;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrame(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14836);
        long pushVideoFrameInternal = pushVideoFrameInternal(i2, i3, i4, j2, false);
        AppMethodBeat.o(14836);
        return pushVideoFrameInternal;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrameSync(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14837);
        long pushVideoFrameInternal = pushVideoFrameInternal(i2, i3, i4, j2, true);
        AppMethodBeat.o(14837);
        return pushVideoFrameInternal;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public long pushVideoFrameAsync(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14838);
        long pushVideoFrameInternal = pushVideoFrameInternal(i2, i3, i4, j2, true);
        AppMethodBeat.o(14838);
        return pushVideoFrameInternal;
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void signalEOSAndFlush() {
        AppMethodBeat.i(14839);
        synchronized (this) {
            try {
                nativeSignalEOSAndFlush(this.mNativeEncoder);
            } finally {
                AppMethodBeat.o(14839);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void setRPSRefBitmap(int i2, int i3, long j2) {
        AppMethodBeat.i(14840);
        synchronized (this) {
            try {
                nativeSetRPSRefBitmap(this.mNativeEncoder, i2, i3, j2);
            } finally {
                AppMethodBeat.o(14840);
            }
        }
    }

    @Override // com.tencent.liteav.videoencoder.d
    public void restartIDR() {
        AppMethodBeat.i(14841);
        synchronized (this) {
            try {
                nativeRestartIDR(this.mNativeEncoder);
            } finally {
                AppMethodBeat.o(14841);
            }
        }
    }

    public static long getAndIncreateSeq() {
        AppMethodBeat.i(14842);
        long nativeGetAndIncreaseSeq = nativeGetAndIncreaseSeq();
        AppMethodBeat.o(14842);
        return nativeGetAndIncreaseSeq;
    }

    public static long getAndIncreaseGopIndex() {
        AppMethodBeat.i(14843);
        long nativeGetAndIncreaseGopIndex = nativeGetAndIncreaseGopIndex();
        AppMethodBeat.o(14843);
        return nativeGetAndIncreaseGopIndex;
    }

    private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> weakReference, byte[] bArr, int i2, long j2, long j3, long j4, long j5, long j6, long j7, int i3) {
        AppMethodBeat.i(14844);
        TXCSWVideoEncoder tXCSWVideoEncoder = weakReference.get();
        if (tXCSWVideoEncoder != null) {
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.nalType = i2;
            tXSNALPacket.gopIndex = j2;
            tXSNALPacket.gopFrameIndex = j3;
            tXSNALPacket.frameIndex = j4;
            tXSNALPacket.refFremeIndex = j5;
            tXSNALPacket.pts = j6;
            tXSNALPacket.dts = j7;
            tXCSWVideoEncoder.callDelegate(tXSNALPacket, i3);
        }
        AppMethodBeat.o(14844);
    }

    private static void onEncodeFinishedFromNative(WeakReference<TXCSWVideoEncoder> weakReference, int i2, long j2, long j3) {
        AppMethodBeat.i(221369);
        TXCSWVideoEncoder tXCSWVideoEncoder = weakReference.get();
        if (tXCSWVideoEncoder != null) {
            tXCSWVideoEncoder.onEncodeFinished(i2, j2, j3);
        }
        AppMethodBeat.o(221369);
    }

    private long pushVideoFrameInternal(final int i2, int i3, int i4, long j2, final boolean z) {
        h hVar;
        AppMethodBeat.i(14846);
        h hVar2 = this.mResizeFilter;
        h hVar3 = this.mRawFrameFilter;
        if (this.mGLContextExternal != null) {
            this.mInputWidth = i3;
            this.mInputHeight = i4;
            if (hVar2 == null) {
                hVar2 = new h();
                this.mResizeFilter = hVar2;
                hVar2.a();
                hVar2.a(true);
            }
            hVar2.a(this.mOutputWidth, this.mOutputHeight);
            GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
            if (hVar2 != null) {
                int i5 = (720 - this.mRotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
                hVar2.a(i3, i4, i5, null, ((float) ((i5 == 90 || i5 == 270) ? this.mOutputHeight : this.mOutputWidth)) / ((float) ((i5 == 90 || i5 == 270) ? this.mOutputWidth : this.mOutputHeight)), this.mEnableXMirror, false);
                hVar2.b(i2);
            }
            if (hVar2 != null) {
                i2 = hVar2.l();
            }
            int[] iArr = new int[1];
            this.mPTS = j2;
            if (hVar3 == null) {
                TXCLog.i(TAG, "pushVideoFrameInternal->create mRawFrameFilter");
                hVar = new o(1);
                this.mRawFrameFilter = hVar;
                hVar.a(true);
                if (!hVar.a()) {
                    TXCLog.i(TAG, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
                    this.mRawFrameFilter = null;
                    AppMethodBeat.o(14846);
                    return 10000004;
                }
                hVar.a(this.mOutputWidth, this.mOutputHeight);
                hVar.a(new h.a() {
                    /* class com.tencent.liteav.videoencoder.TXCSWVideoEncoder.AnonymousClass1 */

                    @Override // com.tencent.liteav.basic.c.h.a
                    public void a(int i2) {
                        AppMethodBeat.i(14825);
                        synchronized (TXCSWVideoEncoder.this) {
                            try {
                                if (TXCSWVideoEncoder.this.mListener != null) {
                                    TXCSWVideoEncoder.this.mListener.m(TXCSWVideoEncoder.this.mStreamType);
                                }
                                if (z) {
                                    TXCSWVideoEncoder.access$200(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeEncoder, i2, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                                } else {
                                    TXCSWVideoEncoder.access$300(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeEncoder, i2, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                                }
                            } finally {
                                AppMethodBeat.o(14825);
                            }
                        }
                    }
                });
            } else {
                hVar = hVar3;
            }
            if (hVar == null) {
                AppMethodBeat.o(14846);
                return 10000004;
            }
            GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
            hVar.b(i2);
            int i6 = iArr[0];
            if (i6 != 0) {
                callDelegate(i6);
            }
        }
        AppMethodBeat.o(14846);
        return 0;
    }

    static {
        AppMethodBeat.i(14849);
        f.f();
        nativeClassInit();
        AppMethodBeat.o(14849);
    }
}
