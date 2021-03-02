package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log {
    public static final int LOGGER_DEFAULT = 1;
    public static final int LOGGER_NONE = 0;
    private static LogCallback mCallback = null;

    public interface LogCallback {
        void println(int i2, String str, String str2);
    }

    private static native void nativePrintLn(int i2, String str, String str2);

    private static native void nativeSetLogger(int i2, LogCallback logCallback);

    private Log() {
    }

    public static void setLogger(int i2) {
        AppMethodBeat.i(3395);
        mCallback = null;
        nativeSetLogger(i2, null);
        AppMethodBeat.o(3395);
    }

    public static void setLogger(LogCallback logCallback) {
        AppMethodBeat.i(3396);
        mCallback = logCallback;
        nativeSetLogger(-1, logCallback);
        AppMethodBeat.o(3396);
    }

    public static void println(int i2, String str, String str2) {
        AppMethodBeat.i(3397);
        if (mCallback != null) {
            mCallback.println(i2, str, str2);
            AppMethodBeat.o(3397);
            return;
        }
        nativePrintLn(i2, str, str2);
        AppMethodBeat.o(3397);
    }

    public static void f(String str, String str2) {
        AppMethodBeat.i(3398);
        println(7, str, str2);
        AppMethodBeat.o(3398);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(3399);
        println(6, str, str2);
        AppMethodBeat.o(3399);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(3400);
        println(5, str, str2);
        AppMethodBeat.o(3400);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(3401);
        println(4, str, str2);
        AppMethodBeat.o(3401);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(3402);
        println(3, str, str2);
        AppMethodBeat.o(3402);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(3403);
        println(2, str, str2);
        AppMethodBeat.o(3403);
    }

    public static void f(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3404);
        println(7, str, String.format(str2, objArr));
        AppMethodBeat.o(3404);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3405);
        println(6, str, String.format(str2, objArr));
        AppMethodBeat.o(3405);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3406);
        println(5, str, String.format(str2, objArr));
        AppMethodBeat.o(3406);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3407);
        println(4, str, String.format(str2, objArr));
        AppMethodBeat.o(3407);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3408);
        println(3, str, String.format(str2, objArr));
        AppMethodBeat.o(3408);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(3409);
        println(2, str, String.format(str2, objArr));
        AppMethodBeat.o(3409);
    }
}
