package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static int a(byte[] bArr, int[] iArr, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(88403);
        if (bArr2 == null) {
            AppMethodBeat.o(88403);
            return -1;
        }
        int nativeGrayRotateCropSub = QbarNative.nativeGrayRotateCropSub(bArr2, i2, i3, i4, i5, i6, i7, bArr, iArr, i8, 0);
        AppMethodBeat.o(88403);
        return nativeGrayRotateCropSub;
    }

    public static int a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(88404);
        if (bArr2 == null) {
            AppMethodBeat.o(88404);
            return -1;
        }
        int nativeYUVrotate = QbarNative.nativeYUVrotate(bArr, bArr2, i2, i3);
        AppMethodBeat.o(88404);
        return nativeYUVrotate;
    }

    public static int a(int[] iArr, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88405);
        if (iArr == null) {
            AppMethodBeat.o(88405);
            return -1;
        }
        int nativeTransBytes = QbarNative.nativeTransBytes(iArr, bArr, i2, i3);
        AppMethodBeat.o(88405);
        return nativeTransBytes;
    }
}
