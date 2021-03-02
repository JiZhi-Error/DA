package com.tencent.qafpapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

public class QAFPNative {
    public static native int QAFPGetAudioFingerPrint(byte[] bArr);

    public static native int QAFPGetAudioFingerPrintTV(byte[] bArr);

    public static native int QAFPGetVersion();

    public static native int QAFPInit();

    public static native int QAFPProcess(byte[] bArr, int i2);

    public static native int QAFPProcessTV(byte[] bArr, int i2);

    public static native int QAFPRelease();

    public static native int QAFPReset();

    static {
        AppMethodBeat.i(39594);
        QAFPNative.class.getClassLoader();
        j.Ed("wechatQAFP");
        AppMethodBeat.o(39594);
    }
}
