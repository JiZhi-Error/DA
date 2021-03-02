package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLog {
    public static void d(String str, String str2) {
        AppMethodBeat.i(13999);
        wrietLogMessage(1, str, str2);
        AppMethodBeat.o(13999);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(14000);
        wrietLogMessage(2, str, str2);
        AppMethodBeat.o(14000);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(14001);
        wrietLogMessage(3, str, str2);
        AppMethodBeat.o(14001);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(14002);
        wrietLogMessage(4, str, str2);
        AppMethodBeat.o(14002);
    }

    private static void wrietLogMessage(int i2, String str, String str2) {
        AppMethodBeat.i(14003);
        TXCLog.log(i2, str, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + str2);
        AppMethodBeat.o(14003);
    }
}
