package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    private static boolean ROd;
    private static g ROe;

    static {
        AppMethodBeat.i(138483);
        ROd = false;
        ROe = new k();
        ROd = false;
        ROe = new k();
        AppMethodBeat.o(138483);
    }

    public static void w(Throwable th) {
        AppMethodBeat.i(138480);
        ez(th);
        AppMethodBeat.o(138480);
    }

    public static void ez(Object obj) {
        AppMethodBeat.i(138481);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.o(138481);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.o(138481);
    }

    public static void eA(Object obj) {
        AppMethodBeat.i(138482);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.o(138482);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.o(138482);
    }

    public static void hkR() {
    }

    public static void gGd() {
    }

    public static void hkS() {
    }
}
