package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.LinkedList;
import java.util.List;

public final class l implements b {
    private final List<b> naf = new LinkedList();

    public l(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(219341);
        this.naf.add(new p(appBrandRuntime));
        this.naf.add(new i());
        this.naf.add(new j(appBrandRuntime));
        this.naf.add(new h(appBrandRuntime));
        AppMethodBeat.o(219341);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final boolean a(f fVar, String str) {
        AppMethodBeat.i(219342);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(219342);
            return false;
        }
        for (b bVar : this.naf) {
            if (bVar.a(fVar, str)) {
                AppMethodBeat.o(219342);
                return true;
            }
        }
        AppMethodBeat.o(219342);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final String b(f fVar, String str) {
        AppMethodBeat.i(219343);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(219343);
            return str;
        }
        for (b bVar : this.naf) {
            if (bVar.a(fVar, str)) {
                String b2 = bVar.b(fVar, str);
                AppMethodBeat.o(219343);
                return b2;
            }
        }
        AppMethodBeat.o(219343);
        return str;
    }
}
