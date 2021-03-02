package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.b.a;
import com.tencent.mm.plugin.report.service.h;

public final class c {
    public static void axp() {
        AppMethodBeat.i(186196);
        e(1403, 19, 1);
        e(1403, 21, 1);
        AppMethodBeat.o(186196);
    }

    public static void axq() {
        AppMethodBeat.i(186197);
        e(1403, 20, 1);
        e(1403, 21, 1);
        AppMethodBeat.o(186197);
    }

    public static void e(long j2, long j3, long j4) {
        AppMethodBeat.i(186198);
        h.INSTANCE.n(j2, j3, j4);
        AppMethodBeat.o(186198);
    }

    public static void axr() {
        AppMethodBeat.i(186199);
        e(1403, 1, 1);
        e(1403, 3, 1);
        AppMethodBeat.o(186199);
    }

    public static void axs() {
        AppMethodBeat.i(186200);
        e(1403, 2, 1);
        e(1403, 3, 1);
        AppMethodBeat.o(186200);
    }

    public static int Fi(String str) {
        AppMethodBeat.i(186201);
        if (str == null || "".equals(str)) {
            AppMethodBeat.o(186201);
            return -1;
        } else if (a.hiY.equals(str)) {
            AppMethodBeat.o(186201);
            return 1406;
        } else if (str.startsWith(a.hiZ)) {
            AppMethodBeat.o(186201);
            return 1410;
        } else if (a.hja.equals(str)) {
            AppMethodBeat.o(186201);
            return 1412;
        } else if (a.hjb.equals(str)) {
            AppMethodBeat.o(186201);
            return 1413;
        } else {
            AppMethodBeat.o(186201);
            return -1;
        }
    }
}
