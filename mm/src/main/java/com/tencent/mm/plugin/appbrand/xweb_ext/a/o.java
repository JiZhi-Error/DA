package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o {
    INSTANCE;

    public static o valueOf(String str) {
        AppMethodBeat.i(227867);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(227867);
        return oVar;
    }

    static {
        AppMethodBeat.i(227869);
        AppMethodBeat.o(227869);
    }

    public static l cdK() {
        AppMethodBeat.i(227868);
        n nVar = new n();
        AppMethodBeat.o(227868);
        return nVar;
    }
}
