package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class t extends s {
    c.a lXA;
    r lXi;

    t(f fVar) {
        super(fVar);
    }

    public final void X(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(138214);
        if (this.lXi != null) {
            this.lXi.bGH();
        }
        if (!(appBrandRuntime == null || this.lXA == null)) {
            appBrandRuntime.kAH.b(this.lXA);
        }
        this.lXi = null;
        this.lXA = null;
        this.lXv = null;
        AppMethodBeat.o(138214);
    }
}
