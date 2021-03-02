package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class c {
    public static void Pe(int i2) {
        AppMethodBeat.i(25500);
        h.INSTANCE.a(13779, 0, Integer.valueOf(i2));
        AppMethodBeat.o(25500);
    }
}
