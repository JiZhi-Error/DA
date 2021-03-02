package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class b {
    public static void a(String str, int i2, long j2, int i3, String str2) {
        AppMethodBeat.i(226444);
        h.INSTANCE.a(16742, str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str2, 0);
        AppMethodBeat.o(226444);
    }
}
