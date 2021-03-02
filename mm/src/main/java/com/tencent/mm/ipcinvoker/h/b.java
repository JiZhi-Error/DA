package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;

public final class b {
    private static a hnD = new a();

    static {
        AppMethodBeat.i(158839);
        AppMethodBeat.o(158839);
    }

    public static boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        hnD = aVar;
        return true;
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158835);
        hnD.printLog(4, str, str2, objArr);
        AppMethodBeat.o(158835);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158836);
        hnD.printLog(6, str, str2, objArr);
        AppMethodBeat.o(158836);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158837);
        hnD.printLog(5, str, str2, objArr);
        AppMethodBeat.o(158837);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158838);
        hnD.printLog(3, str, str2, objArr);
        AppMethodBeat.o(158838);
    }
}
