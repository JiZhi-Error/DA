package com.tencent.mm.danmaku.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import com.tencent.mm.danmaku.c.l;

public final class e {
    private static l.a gQU;
    public static final int gQV = (c.gNA ? 4 : 3);
    private static final StringBuilder gQW = new StringBuilder();

    public static void a(l.a aVar) {
        gQU = aVar;
    }

    public static void v(String str, Object... objArr) {
        AppMethodBeat.i(241767);
        if (gQV >= 5 && gQU != null) {
            gQW.setLength(0);
            for (Object obj : objArr) {
                gQW.append(obj);
            }
            gQU.v(str, gQW.toString());
        }
        AppMethodBeat.o(241767);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(241768);
        if (gQV >= 5 && gQU != null) {
            gQU.v(str, str2);
        }
        AppMethodBeat.o(241768);
    }

    public static void d(String str, Object... objArr) {
        AppMethodBeat.i(241769);
        if (gQV >= 4 && gQU != null) {
            gQW.setLength(0);
            for (Object obj : objArr) {
                gQW.append(obj);
            }
            gQU.d(str, gQW.toString());
        }
        AppMethodBeat.o(241769);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(241770);
        if (gQV >= 4 && gQU != null) {
            gQU.d(str, str2);
        }
        AppMethodBeat.o(241770);
    }

    public static void i(String str, Object... objArr) {
        AppMethodBeat.i(241771);
        if (gQV >= 3 && gQU != null) {
            gQW.setLength(0);
            for (int i2 = 0; i2 < 2; i2++) {
                gQW.append(objArr[i2]);
            }
            gQU.i(str, gQW.toString());
        }
        AppMethodBeat.o(241771);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(241772);
        if (gQV >= 3 && gQU != null) {
            gQU.i(str, str2);
        }
        AppMethodBeat.o(241772);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(241773);
        if (gQV >= 2 && gQU != null) {
            gQU.w(str, str2);
        }
        AppMethodBeat.o(241773);
    }

    public static void e(String str, Object... objArr) {
        AppMethodBeat.i(241774);
        if (gQV > 0 && gQU != null) {
            gQW.setLength(0);
            for (int i2 = 0; i2 <= 0; i2++) {
                gQW.append(objArr[0]);
            }
            gQU.e(str, gQW.toString());
        }
        AppMethodBeat.o(241774);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(241775);
        if (gQV > 0 && gQU != null) {
            gQU.e(str, str2);
        }
        AppMethodBeat.o(241775);
    }

    public static void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(241776);
        if (gQV > 0 && gQU != null) {
            gQU.e(str, str2, th);
        }
        AppMethodBeat.o(241776);
    }

    static {
        AppMethodBeat.i(241777);
        AppMethodBeat.o(241777);
    }
}
