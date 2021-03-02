package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public class d extends a {
    protected boolean mEnableXMirror = false;
    protected JSONArray mEncFmt = null;
    protected h mEncodeFilter;
    private boolean mEncodeFirstGOP = false;
    protected Object mGLContextExternal = null;
    protected boolean mInit;
    protected h mInputFilter;
    protected int mInputHeight = 0;
    protected int mInputTextureID = -1;
    protected int mInputWidth = 0;
    protected e mListener = null;
    protected int mOutputHeight = 0;
    protected int mOutputWidth = 0;
    protected int mRotation = 0;
    protected int mStreamType = 2;
    private long mVideoGOPEncode = 0;

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        if (tXSVideoEncoderParam != null) {
            this.mOutputWidth = tXSVideoEncoderParam.width;
            this.mOutputHeight = tXSVideoEncoderParam.height;
            this.mInputWidth = tXSVideoEncoderParam.width;
            this.mInputHeight = tXSVideoEncoderParam.height;
            this.mGLContextExternal = tXSVideoEncoderParam.glContext;
            this.mStreamType = tXSVideoEncoderParam.streamType;
            this.mEncFmt = tXSVideoEncoderParam.encFmt;
        }
        this.mVideoGOPEncode = 0;
        this.mEncodeFirstGOP = false;
        return 10000002;
    }

    public void stop() {
    }

    public void setListener(e eVar) {
        this.mListener = eVar;
    }

    public void setFPS(int i2) {
    }

    public void setBitrate(int i2) {
    }

    public void setBitrateFromQos(int i2, int i3) {
    }

    public void setRotation(int i2) {
        this.mRotation = i2;
    }

    public void setEncodeIdrFpsFromQos(int i2) {
    }

    public void setRPSRefBitmap(int i2, int i3, long j2) {
    }

    public void restartIDR() {
    }

    public void enableNearestRPS(int i2) {
    }

    public boolean isHevcEncoder() {
        return false;
    }

    public double getRealFPS() {
        return 0.0d;
    }

    public long getRealBitrate() {
        return 0;
    }

    public int getVideoWidth() {
        return this.mOutputWidth;
    }

    public int getVideoHeight() {
        return this.mOutputHeight;
    }

    public int getEncodeCost() {
        return 0;
    }

    public long pushVideoFrame(int i2, int i3, int i4, long j2) {
        return 10000002;
    }

    public long pushVideoFrameSync(int i2, int i3, int i4, long j2) {
        return 10000002;
    }

    public long pushVideoFrameAsync(int i2, int i3, int i4, long j2) {
        return 10000002;
    }

    public void signalEOSAndFlush() {
    }

    /* access modifiers changed from: protected */
    public void callDelegate(int i2) {
        AppMethodBeat.i(259845);
        callDelegate(new TXSNALPacket(), i2);
        AppMethodBeat.o(259845);
    }

    /* access modifiers changed from: protected */
    public void callDelegate(TXSNALPacket tXSNALPacket, int i2) {
        AppMethodBeat.i(259846);
        e eVar = this.mListener;
        if (eVar != null) {
            tXSNALPacket.streamType = this.mStreamType;
            eVar.a(tXSNALPacket, i2);
            if (tXSNALPacket.nalType == 0) {
                if (this.mVideoGOPEncode != 0) {
                    this.mEncodeFirstGOP = true;
                    setStatusValue(WearableStatusCodes.DUPLICATE_CAPABILITY, Long.valueOf(this.mVideoGOPEncode));
                }
                this.mVideoGOPEncode = 1;
                AppMethodBeat.o(259846);
                return;
            }
            this.mVideoGOPEncode++;
            if (!this.mEncodeFirstGOP) {
                setStatusValue(WearableStatusCodes.DUPLICATE_CAPABILITY, Long.valueOf(this.mVideoGOPEncode));
            }
        }
        AppMethodBeat.o(259846);
    }

    /* access modifiers changed from: protected */
    public void callDelegate(MediaFormat mediaFormat) {
        AppMethodBeat.i(259847);
        if (this.mListener != null) {
            this.mListener.a(mediaFormat);
        }
        AppMethodBeat.o(259847);
    }

    /* access modifiers changed from: protected */
    public void onEncodeFinished(int i2, long j2, long j3) {
        AppMethodBeat.i(259848);
        if (this.mListener != null) {
            this.mListener.a(i2, j2, j3);
        }
        AppMethodBeat.o(259848);
    }

    public void setXMirror(boolean z) {
        this.mEnableXMirror = z;
    }
}
