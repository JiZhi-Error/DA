package com.tencent.tinker.a.b.b;

public final class a {
    public static String OI(long j2) {
        char[] cArr = new char[16];
        for (int i2 = 0; i2 < 16; i2++) {
            cArr[15 - i2] = Character.forDigit(((int) j2) & 15, 16);
            j2 >>= 4;
        }
        return new String(cArr);
    }

    public static String arZ(int i2) {
        char[] cArr = new char[8];
        for (int i3 = 0; i3 < 8; i3++) {
            cArr[7 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        return new String(cArr);
    }

    public static String asa(int i2) {
        char[] cArr = new char[4];
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[3 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        return new String(cArr);
    }

    public static String asb(int i2) {
        if (i2 == ((char) i2)) {
            return asa(i2);
        }
        return arZ(i2);
    }

    public static String asc(int i2) {
        char[] cArr = new char[9];
        if (i2 < 0) {
            cArr[0] = '-';
            i2 = -i2;
        } else {
            cArr[0] = '+';
        }
        for (int i3 = 0; i3 < 8; i3++) {
            cArr[8 - i3] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
        }
        return new String(cArr);
    }
}
