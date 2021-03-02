package com.tencent.mm.b;

public final class o {
    public static int v(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | ((bArr[i2 + 3] & 255) << 0);
    }

    public static byte[] iC(int i2) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        byte[] bArr2 = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr2[i4] = bArr[3 - i4];
        }
        return bArr2;
    }

    public static int S(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | ((bArr[0] & 255) << 0);
    }
}
