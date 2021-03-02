package com.tencent.luggage.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.x;

public final class g {
    public static final g cCM = new g();

    static {
        AppMethodBeat.i(147861);
        AppMethodBeat.o(147861);
    }

    private g() {
    }

    public static /* synthetic */ void a(AppBrandRuntime appBrandRuntime, b<? super d, x> bVar) {
        AppMethodBeat.i(147860);
        p.h(appBrandRuntime, "$this$lifecycle");
        p.h(bVar, "function");
        c brl = appBrandRuntime.brl();
        d dVar = new d();
        bVar.invoke(dVar);
        brl.a(dVar);
        AppMethodBeat.o(147860);
    }
}
