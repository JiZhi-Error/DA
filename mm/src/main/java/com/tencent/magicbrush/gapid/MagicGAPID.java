package com.tencent.magicbrush.gapid;

import android.support.annotation.Keep;

public class MagicGAPID {
    private static boolean cMI = false;
    public static int cMJ = 25;
    public static String cMK = "/sdcard/tencent/MicroMsg/appbrand/trace";

    @Keep
    private static native int nativeAttach(String str, String str2, int i2);

    @Keep
    private static native void nativeDetach();

    @Keep
    private static native int nativeSnapshotCapture();
}
