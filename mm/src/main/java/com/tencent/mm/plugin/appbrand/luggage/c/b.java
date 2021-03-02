package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class b implements com.tencent.mm.plugin.appbrand.w.b {
    @Override // com.tencent.mm.plugin.appbrand.w.b
    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(47580);
        h.INSTANCE.a(i2, objArr);
        AppMethodBeat.o(47580);
    }

    @Override // com.tencent.mm.plugin.appbrand.w.b
    public final void kvStat(int i2, String str) {
        AppMethodBeat.i(47581);
        h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(47581);
    }
}
