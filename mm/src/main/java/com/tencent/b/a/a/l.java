package com.tencent.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class l {
    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(87663);
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length <= 0 || length > 256) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("key must be between 1 and 256 bytes");
            AppMethodBeat.o(87663);
            throw illegalArgumentException;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = (i3 + iArr[i4] + iArr2[i4]) & 255;
            int i5 = iArr[i4];
            iArr[i4] = iArr[i3];
            iArr[i3] = i5;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < bArr.length) {
            int i9 = (i7 + 1) & 255;
            i8 = (iArr[i9] + i8) & 255;
            int i10 = iArr[i9];
            iArr[i9] = iArr[i8];
            iArr[i8] = i10;
            bArr3[i6] = (byte) (iArr[(iArr[i9] + iArr[i8]) & 255] ^ bArr[i6]);
            i6++;
            i7 = i9;
        }
        AppMethodBeat.o(87663);
        return bArr3;
    }
}
