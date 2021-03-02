package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class i {
    f lKb;
    int lqe;

    public i(f fVar, int i2) {
        this.lKb = fVar;
        this.lqe = i2;
    }

    public final void ZA(String str) {
        AppMethodBeat.i(140655);
        this.lKb.i(this.lqe, str);
        AppMethodBeat.o(140655);
    }
}
