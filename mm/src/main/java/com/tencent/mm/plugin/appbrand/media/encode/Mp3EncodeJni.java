package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.h;

public class Mp3EncodeJni {
    public static native void close();

    public static native int encode(short[] sArr, short[] sArr2, int i2, byte[] bArr);

    public static native int encodeBufferInterleaved(short[] sArr, int i2, byte[] bArr);

    public static native int flush(byte[] bArr);

    public static native int getVersion();

    public static native int init(int i2, int i3, int i4, int i5, int i6);

    public static native void setMode(int i2);

    static {
        AppMethodBeat.i(146314);
        Mp3EncodeJni.class.getClassLoader();
        h.bPg().ef("mp3lame");
        AppMethodBeat.o(146314);
    }
}
