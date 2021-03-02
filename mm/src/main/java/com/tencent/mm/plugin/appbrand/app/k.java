package com.tencent.mm.plugin.appbrand.app;

import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.c.b;
import java.util.concurrent.Future;

public final class k implements b {
    @Override // com.tencent.mm.picker.base.c.b
    public final Future<?> h(Runnable runnable, long j2) {
        AppMethodBeat.i(226310);
        d<?> a2 = h.RTc.a(runnable, 0, j2);
        AppMethodBeat.o(226310);
        return a2;
    }
}
