package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends e {
    private String ljJ;

    public i(String str, String str2, String str3) {
        super(str, str2);
        AppMethodBeat.i(158892);
        this.ljJ = str3;
        cV("SOAPACTION", "\"" + str2 + "#" + this.ljw + "\"");
        bBi();
        AppMethodBeat.o(158892);
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.e
    public final String bBg() {
        return "Seek";
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        AppMethodBeat.i(158893);
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + ("<u:" + this.ljw + " xmlns:u=\"" + this.ljx + "\">\n <InstanceID>0</InstanceID>\n <Unit>" + "REL_TIME" + "</Unit>\n <Target>" + this.ljJ + "</Target>\n</u:" + this.ljw + ">\n") + "</s:Body></s:Envelope>";
        AppMethodBeat.o(158893);
        return str;
    }
}
