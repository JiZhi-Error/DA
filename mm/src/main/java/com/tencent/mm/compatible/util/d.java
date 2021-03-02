package com.tencent.mm.compatible.util;

import android.os.Build;

public final class d {
    public static boolean oD(int i2) {
        return Build.VERSION.SDK_INT >= i2;
    }

    public static boolean oE(int i2) {
        return Build.VERSION.SDK_INT < i2;
    }

    public static boolean oF(int i2) {
        return Build.VERSION.SDK_INT > i2;
    }
}
