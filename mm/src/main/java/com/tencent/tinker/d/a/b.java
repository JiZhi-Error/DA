package com.tencent.tinker.d.a;

public final class b {
    public static void checkOffsetAndCount(int i2, int i3, int i4) {
        if ((i3 | i4) < 0 || i3 > i2 || i2 - i3 < i4) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
    }
}
