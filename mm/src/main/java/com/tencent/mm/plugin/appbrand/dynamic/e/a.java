package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.u;

public final class a extends c implements d {
    public a(Object obj) {
        AppMethodBeat.i(121382);
        addJavascriptInterface(obj, "WeixinJSCore");
        AppMethodBeat.o(121382);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.aa.b.d, com.tencent.mm.plugin.appbrand.m.a, com.tencent.mm.plugin.appbrand.m.d
    public final void pause() {
        AppMethodBeat.i(121383);
        if (ayP()) {
            ((u) R(u.class)).pause();
        }
        AppMethodBeat.o(121383);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.u, com.tencent.mm.aa.b.d, com.tencent.mm.plugin.appbrand.m.a, com.tencent.mm.plugin.appbrand.m.d
    public final void resume() {
        AppMethodBeat.i(121384);
        if (ayP()) {
            ((u) R(u.class)).resume();
        }
        AppMethodBeat.o(121384);
    }

    @Override // com.tencent.mm.aa.b.d
    public final boolean ayP() {
        AppMethodBeat.i(121385);
        if (R(u.class) != null) {
            AppMethodBeat.o(121385);
            return true;
        }
        AppMethodBeat.o(121385);
        return false;
    }
}
