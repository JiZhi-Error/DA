package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.nio.ByteBuffer;

public class NativeBufferJNI implements e {
    private long nativeInst = nativeCreate();

    private native void nativeBindTo(long j2, long j3, long j4);

    private native long nativeCreate();

    private native void nativeDestroy(long j2);

    private native int nativeGenerateId(long j2);

    private native byte[] nativeGetBuffer(long j2, int i2);

    private native ByteBuffer nativeGetDirectBuffer(long j2, int i2);

    private native void nativeReleaseDirectBuffer(ByteBuffer byteBuffer);

    private native void nativeSetBuffer(long j2, int i2, ByteBuffer byteBuffer);

    private native void nativeSetBufferForLegacyArray(long j2, int i2, byte[] bArr, int i3);

    static {
        AppMethodBeat.i(144016);
        h.class.getClassLoader();
        j.Ed("mmv8");
        h.class.getClassLoader();
        j.Ed("mmnode");
        h.class.getClassLoader();
        j.Ed("mmj2v8");
        AppMethodBeat.o(144016);
    }

    public NativeBufferJNI() {
        AppMethodBeat.i(144009);
        AppMethodBeat.o(144009);
    }

    public void bindTo(long j2, long j3) {
        AppMethodBeat.i(144010);
        nativeBindTo(this.nativeInst, j2, j3);
        AppMethodBeat.o(144010);
    }

    public void destroy() {
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(144011);
        super.finalize();
        if (this.nativeInst != 0) {
            nativeDestroy(this.nativeInst);
            this.nativeInst = 0;
        }
        AppMethodBeat.o(144011);
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public int generateId() {
        AppMethodBeat.i(144012);
        int nativeGenerateId = nativeGenerateId(this.nativeInst);
        AppMethodBeat.o(144012);
        return nativeGenerateId;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public ByteBuffer getBuffer(int i2, boolean z) {
        AppMethodBeat.i(216879);
        if (z) {
            ByteBuffer nativeGetDirectBuffer = nativeGetDirectBuffer(this.nativeInst, i2);
            AppMethodBeat.o(216879);
            return nativeGetDirectBuffer;
        }
        byte[] nativeGetBuffer = nativeGetBuffer(this.nativeInst, i2);
        if (nativeGetBuffer == null) {
            AppMethodBeat.o(216879);
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(nativeGetBuffer);
        AppMethodBeat.o(216879);
        return wrap;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public boolean supportBufferStoreBindTo() {
        return true;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public void bufferStoreBindTo(long j2, long j3) {
        AppMethodBeat.i(144014);
        bindTo(j2, j3);
        AppMethodBeat.o(144014);
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
        AppMethodBeat.i(216880);
        if (byteBuffer != null && byteBuffer.isDirect()) {
            nativeReleaseDirectBuffer(byteBuffer);
            AppMethodBeat.o(216880);
        } else if (BuildInfo.DEBUG) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("buffer is null or is not direct!");
            AppMethodBeat.o(216880);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.o(216880);
        }
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public void setBuffer(int i2, ByteBuffer byteBuffer) {
        AppMethodBeat.i(144015);
        if (byteBuffer == null) {
            AppMethodBeat.o(144015);
        } else if (byteBuffer.capacity() == 0) {
            AppMethodBeat.o(144015);
        } else if (byteBuffer.isDirect()) {
            nativeSetBuffer(this.nativeInst, i2, byteBuffer);
            AppMethodBeat.o(144015);
        } else {
            byte[] array = byteBuffer.array();
            nativeSetBufferForLegacyArray(this.nativeInst, i2, array, array.length);
            AppMethodBeat.o(144015);
        }
    }
}
