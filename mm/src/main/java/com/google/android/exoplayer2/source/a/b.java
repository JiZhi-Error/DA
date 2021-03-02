package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.h.s;

public final class b {
    public static boolean f(Exception exc) {
        if (!(exc instanceof s.e)) {
            return false;
        }
        int i2 = ((s.e) exc).responseCode;
        if (i2 == 404 || i2 == 410) {
            return true;
        }
        return false;
    }
}
