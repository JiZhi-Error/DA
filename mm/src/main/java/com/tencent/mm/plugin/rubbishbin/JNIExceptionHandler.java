package com.tencent.mm.plugin.rubbishbin;

public abstract class JNIExceptionHandler {
    public static JNIExceptionHandler INSTANCE = null;
    private static boolean libLoaded = false;

    public static native void initSigHandler();

    public static native String testCrashAA();

    public abstract void onException(int i2, String str);

    public abstract void setReportExecutionTag(String str);

    public static void init() {
        if (!libLoaded) {
            System.loadLibrary("rubbishbin");
            libLoaded = true;
        }
        initSigHandler();
    }

    public static void invoke_crash() {
        if (!libLoaded) {
            System.loadLibrary("rubbishbin");
            libLoaded = true;
        }
        testCrashAA();
    }
}
