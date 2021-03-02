package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class d {
    public static void a(int i2, int i3, int i4, String str, int i5, int i6, int i7, int i8, long j2) {
        AppMethodBeat.i(25501);
        h.INSTANCE.a(13710, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Long.valueOf(j2));
        AppMethodBeat.o(25501);
    }
}
