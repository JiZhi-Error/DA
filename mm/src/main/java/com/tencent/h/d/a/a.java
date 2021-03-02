package com.tencent.h.d.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends JceStruct {
    public int RLd = 0;
    public int RLe = 0;
    public int RLf = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214657);
        jceOutputStream.write(this.RLd, 1);
        jceOutputStream.write(this.RLe, 2);
        jceOutputStream.write(this.RLf, 3);
        AppMethodBeat.o(214657);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214658);
        this.RLd = jceInputStream.read(this.RLd, 1, true);
        this.RLe = jceInputStream.read(this.RLe, 2, true);
        this.RLf = jceInputStream.read(this.RLf, 3, true);
        AppMethodBeat.o(214658);
    }
}
