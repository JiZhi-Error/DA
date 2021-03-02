package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;
import com.tencent.tinker.a.a.b.b;

public final class l {
    public static void a(b bVar, int i2, long j2) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j2 >> 63) ^ j2)) + 7) >> 3;
        bVar.writeByte(((numberOfLeadingZeros - 1) << 5) | i2);
        while (numberOfLeadingZeros > 0) {
            bVar.writeByte((byte) ((int) j2));
            j2 >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void b(b bVar, int i2, long j2) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j2);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i3 = (numberOfLeadingZeros + 7) >> 3;
        bVar.writeByte(((i3 - 1) << 5) | i2);
        while (i3 > 0) {
            bVar.writeByte((byte) ((int) j2));
            j2 >>= 8;
            i3--;
        }
    }

    public static void c(b bVar, int i2, long j2) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j2);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i3 = (numberOfTrailingZeros + 7) >> 3;
        long j3 = j2 >> (64 - (i3 * 8));
        bVar.writeByte(((i3 - 1) << 5) | i2);
        while (i3 > 0) {
            bVar.writeByte((byte) ((int) j3));
            j3 >>= 8;
            i3--;
        }
    }

    public static int a(a aVar, int i2) {
        int i3 = 0;
        for (int i4 = i2; i4 >= 0; i4--) {
            i3 = (i3 >>> 8) | ((aVar.readByte() & 255) << 24);
        }
        return i3 >> ((3 - i2) * 8);
    }

    public static int a(a aVar, int i2, boolean z) {
        int i3 = 0;
        if (!z) {
            for (int i4 = i2; i4 >= 0; i4--) {
                i3 = (i3 >>> 8) | ((aVar.readByte() & 255) << 24);
            }
            return i3 >>> ((3 - i2) * 8);
        }
        while (i2 >= 0) {
            i3 = (i3 >>> 8) | ((aVar.readByte() & 255) << 24);
            i2--;
        }
        return i3;
    }
}
