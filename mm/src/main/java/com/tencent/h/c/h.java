package com.tencent.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h {
    private static boolean SpY = false;
    private static boolean gNA = true;

    public static void hpU() {
        gNA = false;
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(214642);
        if (gNA) {
            Log.i(str, str2);
        }
        AppMethodBeat.o(214642);
    }

    public static void e(String str, Throwable th) {
        AppMethodBeat.i(214643);
        if (gNA) {
            Log.e(str, "", th);
        }
        AppMethodBeat.o(214643);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(214644);
        if (gNA) {
            Log.d(str, str2);
        }
        AppMethodBeat.o(214644);
    }

    public static void b(String str, Throwable th) {
        AppMethodBeat.i(214645);
        if (gNA) {
            Log.w(str, "", th);
        }
        AppMethodBeat.o(214645);
    }
}
