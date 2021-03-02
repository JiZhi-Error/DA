package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.e;

public final class m extends e {
    public m(String str, String str2) {
        this(str, str2, (byte) 0);
    }

    private m(String str, String str2, byte b2) {
        super(str, "");
        AppMethodBeat.i(158900);
        a(e.a.SUBSCRIBE);
        cV("Nt", "upnp:event");
        cV("Timeout", "Second-10800");
        cV("Callback", "<" + str2 + ">");
        AppMethodBeat.o(158900);
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.e
    public final String bBg() {
        return "SUBSCRIBE";
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        return "";
    }
}
