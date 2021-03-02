package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class YTLog {
    public static void e(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    public static void w(String str, String str2) {
        boolean z = Config.DEBUG;
    }

    public static void d(String str, Object obj) {
        AppMethodBeat.i(2631);
        if (!Config.DEBUG) {
            AppMethodBeat.o(2631);
            return;
        }
        String.valueOf(obj);
        AppMethodBeat.o(2631);
    }

    public static void d(String str, String str2, Throwable th) {
        if (!Config.DEBUG) {
        }
    }
}
