package com.tencent.mm.appbrand.commonjni.buffer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.c;
import java.nio.ByteBuffer;

public class BufferURLManager {
    private volatile long doL;

    private static native void nativeBindTo(long j2, long j3, long j4);

    private static native long nativeCreate();

    private static native String nativeCreateBufferURLWithDirectBuffer(long j2, ByteBuffer byteBuffer);

    private static native String nativeCreateBufferURLWithLegacyArrayBuffer(long j2, byte[] bArr, int i2);

    private static native void nativeDestroy(long j2);

    private static native ByteBuffer nativeGetBuffer(long j2, String str);

    private static native void nativeRevokeBufferURL(long j2, String str);

    public BufferURLManager() {
        AppMethodBeat.i(201237);
        this.doL = 0;
        this.doL = nativeCreate();
        c.C0267c.i("BufferURLManager", "BufferURLManager created %d", Long.valueOf(this.doL));
        AppMethodBeat.o(201237);
    }

    public final void destroy() {
        AppMethodBeat.i(201238);
        c.C0267c.i("BufferURLManager", "BufferURLManager destroying %d", Long.valueOf(this.doL));
        nativeDestroy(this.doL);
        this.doL = 0;
        c.C0267c.i("BufferURLManager", "BufferURLManager destroyed %d", Long.valueOf(this.doL));
        AppMethodBeat.o(201238);
    }

    public final void bindTo(long j2, long j3) {
        AppMethodBeat.i(201239);
        c.C0267c.i("BufferURLManager", "BufferURLManager %d %d %d", Long.valueOf(this.doL), Long.valueOf(j2), Long.valueOf(j3));
        nativeBindTo(this.doL, j2, j3);
        AppMethodBeat.o(201239);
    }

    public final ByteBuffer dI(String str) {
        AppMethodBeat.i(201240);
        if (str == null) {
            c.C0267c.e("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
            AppMethodBeat.o(201240);
            return null;
        }
        ByteBuffer nativeGetBuffer = nativeGetBuffer(this.doL, str);
        new Object[1][0] = nativeGetBuffer;
        AppMethodBeat.o(201240);
        return nativeGetBuffer;
    }
}
