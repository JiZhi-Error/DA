package com.tencent.mm.b;

public final class l {
    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return f(bArr, bArr2);
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return f(bArr, bArr2);
    }

    private static byte[] R(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) i2;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < 256) {
            int i6 = ((bArr[i5] & 255) + (bArr2[i3] & 255) + i4) & 255;
            byte b2 = bArr2[i3];
            bArr2[i3] = bArr2[i6];
            bArr2[i6] = b2;
            i5 = (i5 + 1) % bArr.length;
            i3++;
            i4 = i6;
        }
        return bArr2;
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        byte[] R = R(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < bArr.length) {
            i4 = (i4 + 1) & 255;
            int i5 = ((R[i4] & 255) + i3) & 255;
            byte b2 = R[i4];
            R[i4] = R[i5];
            R[i5] = b2;
            bArr3[i2] = (byte) (R[((R[i4] & 255) + (R[i5] & 255)) & 255] ^ bArr[i2]);
            i2++;
            i3 = i5;
        }
        return bArr3;
    }
}
