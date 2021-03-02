package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static a Ovk = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        Ovk = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(148762);
        if (Ovk != null) {
            Ovk.e(str, str2, objArr);
        }
        AppMethodBeat.o(148762);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(148763);
        if (Ovk != null) {
            Ovk.w(str, str2, objArr);
        }
        AppMethodBeat.o(148763);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(148764);
        if (Ovk != null) {
            Ovk.i(str, str2, objArr);
        }
        AppMethodBeat.o(148764);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(148765);
        if (Ovk != null) {
            Ovk.d(str, str2, objArr);
        }
        AppMethodBeat.o(148765);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(148766);
        if (Ovk != null) {
            Ovk.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(148766);
    }
}
