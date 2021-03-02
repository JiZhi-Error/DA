package com.tencent.mm.vending.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static AbstractC2151a QZQ = null;

    /* renamed from: com.tencent.mm.vending.f.a$a  reason: collision with other inner class name */
    public interface AbstractC2151a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(AbstractC2151a aVar) {
        QZQ = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(74935);
        if (QZQ != null) {
            QZQ.e(str, str2, objArr);
        }
        AppMethodBeat.o(74935);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(74936);
        if (QZQ != null) {
            QZQ.w(str, str2, objArr);
        }
        AppMethodBeat.o(74936);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(74937);
        if (QZQ != null) {
            QZQ.i(str, str2, objArr);
        }
        AppMethodBeat.o(74937);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(74938);
        if (QZQ != null) {
            QZQ.d(str, str2, objArr);
        }
        AppMethodBeat.o(74938);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(74939);
        if (QZQ != null) {
            QZQ.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(74939);
    }
}
