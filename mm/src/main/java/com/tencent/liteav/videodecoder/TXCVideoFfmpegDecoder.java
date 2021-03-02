package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class TXCVideoFfmpegDecoder implements b {
    private boolean mFirstDec;
    private g mListener;
    private long mNativeDecoder;
    private long mNativeNotify;
    private ByteBuffer mPps;
    private byte[] mRawData;
    private ByteBuffer mSps;
    private int mVideoHeight;
    private int mVideoWidth;

    private static native void nativeClassInit();

    private native boolean nativeDecode(byte[] bArr, long j2, long j3, long j4);

    private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> weakReference, boolean z);

    private native void nativeLoadRawData(byte[] bArr, long j2, int i2);

    private native void nativeRelease();

    @Override // com.tencent.liteav.videodecoder.b
    public void setListener(g gVar) {
        this.mListener = gVar;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void setNotifyListener(WeakReference<b> weakReference) {
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int config(Surface surface) {
        return 0;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void decode(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(16642);
        if (this.mFirstDec) {
            if (!(this.mSps == null || this.mPps == null)) {
                byte[] array = this.mSps.array();
                byte[] array2 = this.mPps.array();
                byte[] bArr = new byte[(array.length + array2.length)];
                System.arraycopy(array, 0, bArr, 0, array.length);
                System.arraycopy(array2, 0, bArr, array.length, array2.length);
                if (!nativeDecode(bArr, tXSNALPacket.pts - 1, tXSNALPacket.dts - 1, (long) tXSNALPacket.rotation) && this.mListener != null) {
                    this.mListener.onDecodeFailed(-2);
                }
            }
            this.mFirstDec = false;
        }
        if (!nativeDecode(tXSNALPacket.nalData, tXSNALPacket.pts, tXSNALPacket.dts, (long) tXSNALPacket.rotation) && this.mListener != null) {
            this.mListener.onDecodeFailed(-2);
        }
        AppMethodBeat.o(16642);
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.i(16643);
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mFirstDec = true;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        nativeInit(new WeakReference<>(this), z);
        AppMethodBeat.o(16643);
        return 0;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void stop() {
        AppMethodBeat.i(16644);
        nativeRelease();
        AppMethodBeat.o(16644);
    }

    public boolean isHevc() {
        return false;
    }

    @Override // com.tencent.liteav.videodecoder.b
    public int GetDecodeCost() {
        return 0;
    }

    public void config(JSONArray jSONArray) {
    }

    @Override // com.tencent.liteav.videodecoder.b
    public void enableLimitDecCache(boolean z) {
    }

    private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> weakReference, long j2, int i2, int i3, long j3, long j4, int i4) {
    }

    public void loadNativeData(byte[] bArr, long j2, int i2) {
        AppMethodBeat.i(16645);
        nativeLoadRawData(bArr, j2, i2);
        AppMethodBeat.o(16645);
    }

    static {
        AppMethodBeat.i(16646);
        f.f();
        nativeClassInit();
        AppMethodBeat.o(16646);
    }
}
