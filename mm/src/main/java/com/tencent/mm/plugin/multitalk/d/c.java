package com.tencent.mm.plugin.multitalk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c {
    public static void aH(int i2, boolean z) {
        int i3;
        AppMethodBeat.i(164087);
        if (z) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        a(i2, 0, 0, 0, 0, 0, i3, 0, 0, "", 0);
        AppMethodBeat.o(164087);
    }

    public static void aI(int i2, boolean z) {
        int i3;
        AppMethodBeat.i(164088);
        if (z) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        a(i2, 0, 0, 0, 0, 0, 0, i3, 0, "", 0);
        AppMethodBeat.o(164088);
    }

    public static void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str, int i11) {
        AppMethodBeat.i(164089);
        h.INSTANCE.a(19192, true, true, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), str, Integer.valueOf(i11));
        AppMethodBeat.o(164089);
    }
}
