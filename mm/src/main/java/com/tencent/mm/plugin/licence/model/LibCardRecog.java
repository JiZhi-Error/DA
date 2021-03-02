package com.tencent.mm.plugin.licence.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LibCardRecog {
    public static native int recognizeBankCardGetVersion();

    public static native int recognizeBankCardInit(int i2, int i3, boolean z);

    public static native int recognizeBankCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, BankCardInfo bankCardInfo, boolean[] zArr);

    public static native int recognizeBankCardRelease();

    public static native String recognizeBankCardSegmentNumber(String str, int i2, int[] iArr);

    public static native int recognizeCardInit(int i2, int i3, int i4);

    public static native int recognizeCardProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, CardInfo cardInfo, boolean[] zArr);

    public static native int recognizeCardRelease();

    static {
        AppMethodBeat.i(40586);
        System.loadLibrary("IDCardRecog");
        AppMethodBeat.o(40586);
    }
}
