package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;

public final class h extends b {
    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b
    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(147403);
        ((j) cVar.cAJ.M(j.class)).aep(iVar.optString("apiName"));
        AppMethodBeat.o(147403);
    }
}
