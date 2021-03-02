package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class QueryLoginInfoRequest extends JceStruct {
    public String addtion = "";

    public QueryLoginInfoRequest() {
    }

    public QueryLoginInfoRequest(String str) {
        this.addtion = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102254);
        if (this.addtion != null) {
            jceOutputStream.write(this.addtion, 0);
        }
        AppMethodBeat.o(102254);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102255);
        this.addtion = jceInputStream.readString(0, false);
        AppMethodBeat.o(102255);
    }
}
