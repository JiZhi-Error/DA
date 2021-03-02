package com.tencent.e.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends JceStruct {
    public int RLb = 0;
    public int RLc = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138320);
        jceOutputStream.write(this.RLb, 0);
        jceOutputStream.write(this.RLc, 1);
        AppMethodBeat.o(138320);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138321);
        this.RLb = jceInputStream.read(this.RLb, 0, true);
        this.RLc = jceInputStream.read(this.RLc, 1, false);
        AppMethodBeat.o(138321);
    }
}
