package com.tencent.mm.audio.mix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.m;

public class AudioFFmpegDecodeJni {
    protected long dwa = 0;
    protected long dwb = 0;

    public static native int decode(int i2, int i3, int i4, String str, m mVar);

    public native int clearResample(String str, Object obj);

    public native int initResample(String str, int i2, int i3, int i4, int i5, Object obj);

    public native int resamplePcm(String str, int i2, int i3, byte[] bArr, int i4, byte[] bArr2, int i5, Object obj);

    static {
        AppMethodBeat.i(136832);
        System.loadLibrary("FFmpeg");
        AppMethodBeat.o(136832);
    }
}
