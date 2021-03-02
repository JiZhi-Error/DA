package com.tencent.liteav.basic.structs;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class TXSVideoFrame {
    public ByteBuffer buffer;
    public byte[] data;
    public Object eglContext;
    public int frameType;
    public int height;
    public long pts;
    public int rotation;
    public int textureId;
    public int width;

    private native void nativeLoadArrayFromBuffer(byte[] bArr, int i2);

    private native void nativeLoadArrayFromGL(byte[] bArr, int i2, int i3);

    private native void nativeLoadBufferFromGL(int i2, int i3);

    private native void nativeLoadNV21BufferFromI420Buffer(int i2, int i3);

    public native void nativeClone(ByteBuffer byteBuffer);

    public native void release();

    public void finalize() {
        AppMethodBeat.i(14449);
        release();
        super.finalize();
        AppMethodBeat.o(14449);
    }

    public TXSVideoFrame clone() {
        AppMethodBeat.i(14450);
        TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
        tXSVideoFrame.width = this.width;
        tXSVideoFrame.height = this.height;
        tXSVideoFrame.frameType = this.frameType;
        tXSVideoFrame.rotation = this.rotation;
        tXSVideoFrame.pts = this.pts;
        tXSVideoFrame.data = this.data;
        tXSVideoFrame.textureId = this.textureId;
        tXSVideoFrame.eglContext = this.eglContext;
        tXSVideoFrame.nativeClone(this.buffer);
        AppMethodBeat.o(14450);
        return tXSVideoFrame;
    }

    public void loadYUVArray(byte[] bArr) {
        AppMethodBeat.i(14451);
        if (bArr == null || bArr.length < ((this.width * this.height) * 3) / 2) {
            AppMethodBeat.o(14451);
        } else if (this.buffer == null) {
            GLES20.glReadPixels(0, 0, this.width, (this.height * 3) / 8, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, ByteBuffer.wrap(bArr));
            AppMethodBeat.o(14451);
        } else {
            nativeLoadArrayFromBuffer(bArr, ((this.width * this.height) * 3) / 2);
            AppMethodBeat.o(14451);
        }
    }

    public void loadYUVBufferFromGL() {
        AppMethodBeat.i(14452);
        nativeLoadBufferFromGL(this.width, this.height);
        AppMethodBeat.o(14452);
    }

    public void loadNV21BufferFromI420Buffer() {
        AppMethodBeat.i(14453);
        nativeLoadNV21BufferFromI420Buffer(this.width, this.height);
        AppMethodBeat.o(14453);
    }

    public byte[] I420toNV21(byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(14454);
        if (bArr2 == null) {
            bArr2 = new byte[bArr.length];
        }
        int i4 = i2 * i3;
        int i5 = i4 + (i4 / 4);
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        int i6 = i5;
        int i7 = i4;
        int i8 = i4;
        while (i7 < i5) {
            bArr2[i8] = bArr[i6];
            bArr2[i8 + 1] = bArr[i7];
            i7++;
            i6++;
            i8 += 2;
        }
        AppMethodBeat.o(14454);
        return bArr2;
    }
}
