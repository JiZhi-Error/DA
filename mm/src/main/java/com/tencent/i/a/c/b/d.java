package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends JceStruct {
    public String Ssh = "";
    public String Ssi = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214756);
        jceOutputStream.write(this.Ssh, 0);
        jceOutputStream.write(this.Ssi, 1);
        AppMethodBeat.o(214756);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214757);
        this.Ssh = jceInputStream.readString(0, true);
        this.Ssi = jceInputStream.readString(1, true);
        AppMethodBeat.o(214757);
    }
}
