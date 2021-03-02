package com.tencent.mm.plugin.appbrand.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;

public final class d implements k {
    public static final d kGH = new d();

    static {
        AppMethodBeat.i(44024);
        AppMethodBeat.o(44024);
    }

    private d() {
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.k
    public final q btJ() {
        AppMethodBeat.i(174692);
        q btJ = e.btJ();
        AppMethodBeat.o(174692);
        return btJ;
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.k
    public final boolean Ux(String str) {
        AppMethodBeat.i(44021);
        boolean Ux = e.Ux(str);
        AppMethodBeat.o(44021);
        return Ux;
    }

    @Override // com.tencent.mm.plugin.appbrand.ad.k
    public final boolean H(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(44022);
        boolean H = e.H(appBrandRuntime);
        AppMethodBeat.o(44022);
        return H;
    }
}
