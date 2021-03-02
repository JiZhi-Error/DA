package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.e;

public final class n extends e {
    public n(String str, String str2) {
        super(str, "");
        AppMethodBeat.i(158901);
        a(e.a.UNSUBSCRIBE);
        cV("SID", str2);
        AppMethodBeat.o(158901);
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.e
    public final String bBg() {
        return "UNSUBSCRIBE";
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        return "";
    }
}
