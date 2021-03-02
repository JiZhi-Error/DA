package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends e {
    public b(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(158880);
        cV("SOAPACTION", "\"" + str2 + "#" + this.ljw + "\"");
        bBi();
        AppMethodBeat.o(158880);
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.e
    public final String bBg() {
        return "GetPositionInfo";
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        AppMethodBeat.i(158881);
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + ("<u:" + this.ljw + " xmlns:u=\"" + this.ljx + "\">\n<InstanceID>0</InstanceID>\n</u:" + this.ljw + ">\n") + "</s:Body></s:Envelope>";
        AppMethodBeat.o(158881);
        return str;
    }
}
