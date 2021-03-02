package com.tencent.thumbplayer.c;

/* access modifiers changed from: package-private */
public final class c {
    public static String RYP = "base_video";
    private static int RYQ = 0;
    private static int RYR = 0;
    private static int RYS = 0;

    static int arm(int i2) {
        if (i2 == 1) {
            int i3 = RYS;
            RYS = i3 + 1;
            return i3;
        } else if (i2 == 2) {
            int i4 = RYQ;
            RYQ = i4 + 1;
            return i4;
        } else if (i2 != 3) {
            return -1;
        } else {
            int i5 = RYR;
            RYR = i5 + 1;
            return i5;
        }
    }
}
