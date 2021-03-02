package com.tencent.sqlitelint.util;

import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SLog {
    private static final String TAG = "SQLiteLint.SLog";
    private static volatile SLog mInstance = null;

    public static native void nativeSetLogger(int i2);

    public static SLog getInstance() {
        AppMethodBeat.i(52952);
        if (mInstance == null) {
            synchronized (SLog.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SLog();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(52952);
                    throw th;
                }
            }
        }
        SLog sLog = mInstance;
        AppMethodBeat.o(52952);
        return sLog;
    }

    public void printLog(int i2, String str, String str2) {
        AppMethodBeat.i(52953);
        switch (i2) {
            case 2:
                c.v(str, str2, new Object[0]);
                AppMethodBeat.o(52953);
                return;
            case 3:
                c.d(str, str2, new Object[0]);
                AppMethodBeat.o(52953);
                return;
            case 4:
                c.i(str, str2, new Object[0]);
                AppMethodBeat.o(52953);
                return;
            case 5:
                c.w(str, str2, new Object[0]);
                AppMethodBeat.o(52953);
                return;
            case 6:
            case 7:
                c.e(str, str2, new Object[0]);
                AppMethodBeat.o(52953);
                return;
            default:
                try {
                    c.i(str, str2, new Object[0]);
                    AppMethodBeat.o(52953);
                    return;
                } catch (Throwable th) {
                    new StringBuilder("printLog ex ").append(th.getMessage());
                    AppMethodBeat.o(52953);
                    return;
                }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52954);
        getInstance().printLog(6, str, String.format(str2, objArr));
        AppMethodBeat.o(52954);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52955);
        getInstance().printLog(5, str, String.format(str2, objArr));
        AppMethodBeat.o(52955);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52956);
        getInstance().printLog(4, str, String.format(str2, objArr));
        AppMethodBeat.o(52956);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52957);
        getInstance().printLog(3, str, String.format(str2, objArr));
        AppMethodBeat.o(52957);
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(52958);
        getInstance().printLog(2, str, String.format(str2, objArr));
        AppMethodBeat.o(52958);
    }
}
