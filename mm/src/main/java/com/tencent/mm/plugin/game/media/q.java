package com.tencent.mm.plugin.game.media;

public final class q {
    public static int c(boolean z, boolean z2, boolean z3, boolean z4) {
        int i2 = 0;
        if (z) {
            i2 = 1;
        }
        if (z2) {
            i2 |= 2;
        }
        if (z3) {
            i2 |= 4;
        }
        if (z4) {
            return i2 | 8;
        }
        return i2;
    }
}
