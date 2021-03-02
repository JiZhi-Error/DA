package com.tencent.mm.plugin.ipcall.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class i {
    public static void am(int i2, int i3, int i4) {
        AppMethodBeat.i(25509);
        h.INSTANCE.a(13254, 0, Integer.valueOf(i2), 0, Integer.valueOf(i3), Integer.valueOf(i4), -1);
        AppMethodBeat.o(25509);
    }
}
