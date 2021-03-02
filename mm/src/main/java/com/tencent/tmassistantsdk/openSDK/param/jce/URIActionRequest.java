package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URIActionRequest extends JceStruct {
    public String uri = "";

    public URIActionRequest() {
    }

    public URIActionRequest(String str) {
        this.uri = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102258);
        jceOutputStream.write(this.uri, 0);
        AppMethodBeat.o(102258);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102259);
        this.uri = jceInputStream.readString(0, true);
        AppMethodBeat.o(102259);
    }
}
