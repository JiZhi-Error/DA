package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Util;

public final class p extends Number {
    private int uin = 0;

    public p(int i2) {
        this.uin = i2;
    }

    public p(long j2) {
        this.uin = (int) (-1 & j2);
    }

    public static int fd(String str) {
        try {
            return new p(Long.valueOf(str).longValue()).intValue();
        } catch (Exception e2) {
            return 0;
        }
    }

    public final double doubleValue() {
        return ((double) (((long) this.uin) | 0)) + 0.0d;
    }

    public final float floatValue() {
        return (float) (((double) (((long) this.uin) | 0)) + 0.0d);
    }

    public final int intValue() {
        return this.uin;
    }

    public final long longValue() {
        return ((long) this.uin) & Util.MAX_32BIT_VALUE;
    }

    public final String toString() {
        return String.valueOf(((long) this.uin) & Util.MAX_32BIT_VALUE);
    }

    public static String getString(int i2) {
        return new p(i2).toString();
    }
}
