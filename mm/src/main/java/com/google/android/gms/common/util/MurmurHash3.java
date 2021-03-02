package com.google.android.gms.common.util;

public class MurmurHash3 {
    private MurmurHash3() {
    }

    public static int murmurhash3_x86_32(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6 = i2 + (i3 & -4);
        int i7 = i4;
        while (i2 < i6) {
            int i8 = ((bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << 24)) * -862048943;
            int i9 = (((i8 >>> 17) | (i8 << 15)) * 461845907) ^ i7;
            i7 = -430675100 + (((i9 >>> 19) | (i9 << 13)) * 5);
            i2 += 4;
        }
        int i10 = 0;
        switch (i3 & 3) {
            case 3:
                i10 = (bArr[i6 + 2] & 255) << 16;
            case 2:
                i10 |= (bArr[i6 + 1] & 255) << 8;
            case 1:
                int i11 = (i10 | (bArr[i6] & 255)) * -862048943;
                i5 = (((i11 >>> 17) | (i11 << 15)) * 461845907) ^ i7;
                break;
            default:
                i5 = i7;
                break;
        }
        int i12 = i5 ^ i3;
        int i13 = (i12 ^ (i12 >>> 16)) * -2048144789;
        int i14 = (i13 ^ (i13 >>> 13)) * -1028477387;
        return i14 ^ (i14 >>> 16);
    }
}
