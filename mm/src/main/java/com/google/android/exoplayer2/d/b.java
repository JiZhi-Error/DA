package com.google.android.exoplayer2.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean DEBUG = true;
    private static a bsW = null;

    public static void a(a aVar) {
        bsW = aVar;
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92349);
        if (bsW != null) {
            bsW.i(str, str2, objArr);
        }
        AppMethodBeat.o(92349);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92350);
        if (bsW != null) {
            bsW.w(str, str2, objArr);
        }
        AppMethodBeat.o(92350);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(92351);
        if (bsW != null) {
            bsW.e(str, str2, objArr);
        }
        AppMethodBeat.o(92351);
    }
}
