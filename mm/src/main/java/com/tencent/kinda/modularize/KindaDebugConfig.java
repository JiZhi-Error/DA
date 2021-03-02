package com.tencent.kinda.modularize;

public class KindaDebugConfig {
    private static volatile boolean sLibReloading = false;

    public static boolean isLibReloading() {
        return sLibReloading;
    }

    public static void markLibReloading() {
    }

    public static void resetLibReloading() {
        sLibReloading = false;
    }
}
