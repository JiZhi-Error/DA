package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2encoder;

public final class i {
    public static int ch(int i2, int i3) {
        if (i3 < 0 || i3 >= Integer.MAX_VALUE) {
            return 0;
        }
        byte[] bArr = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr[i4] = (byte) ((i2 >> (i4 * 8)) & 255);
        }
        return (int) ((((long) u(bArr, 4)) & Util.MAX_32BIT_VALUE) % ((long) i3));
    }

    public static int u(byte[] bArr, int i2) {
        int i3 = i2 ^ 0;
        int i4 = i2 >> 2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 << 2) + 0;
            int i7 = ((bArr[i6 + 0] & 255) | (((((bArr[i6 + 3] << 8) | (bArr[i6 + 2] & 255)) << 8) | (bArr[i6 + 1] & 255)) << 8)) * 1540483477;
            i3 = (i3 * 1540483477) ^ ((i7 ^ (i7 >>> 24)) * 1540483477);
        }
        int i8 = i2 - (i4 << 2);
        if (i8 != 0) {
            if (i8 >= 3) {
                i3 ^= bArr[(i2 + 0) - 3] << v2encoder.enumCODEC_vcodec2;
            }
            if (i8 >= 2) {
                i3 ^= bArr[(i2 + 0) - 2] << 8;
            }
            if (i8 > 0) {
                i3 ^= bArr[(i2 + 0) - 1];
            }
            i3 *= 1540483477;
        }
        int i9 = (i3 ^ (i3 >>> 13)) * 1540483477;
        return i9 ^ (i9 >>> 15);
    }
}
