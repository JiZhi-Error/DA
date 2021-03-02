package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log {
    private static ILog logImpl;

    public static void d(String str, String str2) {
        AppMethodBeat.i(3751);
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.d(str, str2);
        }
        AppMethodBeat.o(3751);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(3754);
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.e(str, str2);
        }
        AppMethodBeat.o(3754);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(3752);
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.i(str, str2);
        }
        AppMethodBeat.o(3752);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(3750);
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.v(str, str2);
        }
        AppMethodBeat.o(3750);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(3753);
        ILog iLog = logImpl;
        if (iLog != null) {
            iLog.w(str, str2);
        }
        AppMethodBeat.o(3753);
    }
}
