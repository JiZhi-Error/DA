package com.tencent.mm.ci;

public final class e {
    public static byte[] cL(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ 18);
        }
        return bArr;
    }
}
