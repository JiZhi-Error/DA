package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class l {
    public static void Q(String str, String str2, int i2) {
        AppMethodBeat.i(24694);
        h.INSTANCE.a(12651, 1, str, 0, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
        AppMethodBeat.o(24694);
    }

    public static void R(String str, String str2, int i2) {
        AppMethodBeat.i(24695);
        h.INSTANCE.a(12651, 2, str, 0, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
        AppMethodBeat.o(24695);
    }

    public static void S(String str, String str2, int i2) {
        AppMethodBeat.i(24696);
        h.INSTANCE.a(12651, 3, str, 0, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
        AppMethodBeat.o(24696);
    }

    public static void b(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(24697);
        if (z) {
            h.INSTANCE.a(12651, 4, str, 1, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
            AppMethodBeat.o(24697);
            return;
        }
        h.INSTANCE.a(12651, 4, str, 0, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
        AppMethodBeat.o(24697);
    }

    public static void c(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(24698);
        if (z) {
            h.INSTANCE.a(12651, 5, str, 1, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
            AppMethodBeat.o(24698);
            return;
        }
        h.INSTANCE.a(12651, 5, str, 0, str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2));
        AppMethodBeat.o(24698);
    }
}
