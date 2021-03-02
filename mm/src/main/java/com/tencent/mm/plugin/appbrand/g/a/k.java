package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends e {
    private int hBI;

    public k(String str, String str2, int i2) {
        super(str, str2);
        AppMethodBeat.i(158896);
        this.hBI = i2;
        cV("SOAPACTION", "\"" + str2 + "#" + this.ljw + "\"");
        AppMethodBeat.o(158896);
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.e
    public final String bBg() {
        return "SetVolume";
    }

    @Override // com.tencent.mm.plugin.appbrand.g.a.d
    public final String bBh() {
        AppMethodBeat.i(158897);
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><s:Envelope s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body>" + ("<u:" + this.ljw + " xmlns:u=\"" + this.ljx + "\">\n<InstanceID>0</InstanceID>\n<Channel>" + "Master" + "</Channel>\n<DesiredVolume>" + this.hBI + "</DesiredVolume>\n</u:" + this.ljw + ">\n") + "</s:Body></s:Envelope>";
        AppMethodBeat.o(158897);
        return str;
    }
}
