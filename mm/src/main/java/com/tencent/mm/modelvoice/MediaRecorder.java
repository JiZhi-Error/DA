package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.pointers.PByteArray;

public class MediaRecorder {
    public static long juf = 0;
    public static long jug = 0;
    public static final int[] juh = {13, 14, 16, 18, 20, 21, 27, 32};

    public static native int SetVoiceSilkControl(int i2, int i3, long j2);

    public static native int SetVoiceSilkDecControl(int i2, byte[] bArr, int i3, long j2);

    public static native long SilkDecInit(int i2, byte[] bArr, int i3, long j2);

    public static native int SilkDecUnInit(long j2);

    public static native int SilkDoDec(byte[] bArr, short s, long j2);

    public static native int SilkDoEnc(byte[] bArr, short s, byte[] bArr2, short[] sArr, boolean z, long j2);

    public static native long SilkEncInit(int i2, int i3, int i4, long j2);

    public static native int SilkEncUnInit(long j2);

    public static native int SilkGetEncSampleRate(byte[] bArr, long j2);

    public static native boolean native_init();

    public static native boolean native_pcm2amr(int i2, byte[] bArr, int i3, PByteArray pByteArray, int i4);

    public static native boolean native_pcmresamp(byte[] bArr, int i2, PByteArray pByteArray);

    public static native boolean native_release();

    static {
        AppMethodBeat.i(177009);
        g.b.init();
        AppMethodBeat.o(177009);
    }
}
