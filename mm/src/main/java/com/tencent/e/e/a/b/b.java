package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends JceStruct {
    public int RNs = 0;
    public float RNt = 0.0f;
    public String dGL = "";
    public String dUb = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138417);
        jceOutputStream.write(this.dUb, 0);
        jceOutputStream.write(this.RNs, 1);
        jceOutputStream.write(this.RNt, 2);
        if (this.dGL != null) {
            jceOutputStream.write(this.dGL, 3);
        }
        AppMethodBeat.o(138417);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138418);
        this.dUb = jceInputStream.readString(0, true);
        this.RNs = jceInputStream.read(this.RNs, 1, true);
        this.RNt = jceInputStream.read(this.RNt, 2, true);
        this.dGL = jceInputStream.readString(3, false);
        AppMethodBeat.o(138418);
    }
}
