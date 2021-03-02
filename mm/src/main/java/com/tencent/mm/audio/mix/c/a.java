package com.tencent.mm.audio.mix.c;

public final class a {
    public static byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            bArr[1] = (byte) (s & 255);
            bArr[0] = (byte) (((short) (s >> 8)) & 255);
        } else {
            bArr[0] = (byte) (s & 255);
            bArr[1] = (byte) (((short) (s >> 8)) & 255);
        }
        return bArr;
    }

    public static short a(byte b2, byte b3, boolean z) {
        if (z) {
            return (short) (((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255));
        }
        return (short) (((short) (((short) ((b3 & 255) | 0)) << 8)) | (b2 & 255));
    }

    public static byte[] a(byte[] bArr, double d2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((int) (((double) bArr[i2]) * d2));
        }
        return bArr;
    }
}
