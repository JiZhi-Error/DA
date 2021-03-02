package com.tencent.mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class j {
    private static long hrI;
    private static long hrJ;
    private static volatile a hrK = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void r(long j2, long j3) {
        hrI = j2;
        hrJ = j3;
    }

    public static void q(String str, long j2) {
        AppMethodBeat.i(158319);
        Log.i("Blink-LOG", "since the %s : %s", str, Long.valueOf(System.nanoTime() - j2));
        AppMethodBeat.o(158319);
    }

    public static long FT(String str) {
        AppMethodBeat.i(230544);
        long elapsedRealtime = SystemClock.elapsedRealtime() - hrJ;
        Log.i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(elapsedRealtime));
        String.format("since startup %s : %s", str, Long.valueOf(elapsedRealtime));
        AppMethodBeat.o(230544);
        return elapsedRealtime;
    }

    public static void a(a aVar) {
        hrK = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158321);
        if (hrK != null) {
            hrK.e(str, str2, objArr);
        }
        AppMethodBeat.o(158321);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158322);
        if (hrK != null) {
            hrK.w(str, str2, objArr);
        }
        AppMethodBeat.o(158322);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158323);
        if (hrK != null) {
            hrK.i(str, str2, objArr);
        }
        AppMethodBeat.o(158323);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(158324);
        if (hrK != null) {
            hrK.d(str, str2, objArr);
        }
        AppMethodBeat.o(158324);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.i(158325);
        if (hrK != null) {
            hrK.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.o(158325);
    }

    public static void aAm() {
    }

    public static long aAn() {
        return hrJ;
    }
}
