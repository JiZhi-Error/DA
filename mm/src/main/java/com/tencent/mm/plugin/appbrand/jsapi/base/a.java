package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.HashMap;

public final class a {
    private HashMap<String, o> lJS = new HashMap<>(5);

    public a() {
        AppMethodBeat.i(221222);
        AppMethodBeat.o(221222);
    }

    public final void a(String str, o oVar) {
        AppMethodBeat.i(221223);
        this.lJS.put(str, oVar);
        AppMethodBeat.o(221223);
    }

    public final o Zz(String str) {
        AppMethodBeat.i(221224);
        o oVar = this.lJS.get(str);
        AppMethodBeat.o(221224);
        return oVar;
    }

    public final void remove(String str) {
        AppMethodBeat.i(221225);
        this.lJS.remove(str);
        AppMethodBeat.o(221225);
    }
}
