package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h implements d {
    private boolean ljI;

    public h(boolean z) {
        this.ljI = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        AppMethodBeat.i(158891);
        if (this.ljI) {
            String cW = cW("ssdp:all", "[FF0x::C]");
            AppMethodBeat.o(158891);
            return cW;
        }
        String cW2 = cW("ssdp:all", "239.255.255.250");
        AppMethodBeat.o(158891);
        return cW2;
    }

    private static String cW(String str, String str2) {
        AppMethodBeat.i(222903);
        String str3 = "M-SEARCH * HTTP/1.1\r\nST:" + str + "\r\nHOST: " + str2 + ":1900\r\nMX: 3\r\nMAN: \"ssdp:discover\"\r\n\r\n";
        AppMethodBeat.o(222903);
        return str3;
    }
}
