package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static a hlz = null;

    public interface a {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        hlz = aVar;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(62474);
        if (hlz != null) {
            hlz.i(str, str2);
        }
        AppMethodBeat.o(62474);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(62475);
        if (HardCoderJNI.isHcDebug() && hlz != null) {
            hlz.d(str, str2);
        }
        AppMethodBeat.o(62475);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(62476);
        if (hlz != null) {
            hlz.e(str, str2);
        }
        AppMethodBeat.o(62476);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(62477);
        if (hlz != null) {
            hlz.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(62477);
    }
}
