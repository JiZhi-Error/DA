package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends JceStruct {
    static int Ssl = 0;
    public float Ssj = 0.0f;
    public float Ssk = 0.0f;
    public int screenOrientation = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214758);
        jceOutputStream.write(this.screenOrientation, 0);
        jceOutputStream.write(this.Ssj, 1);
        jceOutputStream.write(this.Ssk, 2);
        AppMethodBeat.o(214758);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214759);
        this.screenOrientation = jceInputStream.read(this.screenOrientation, 0, false);
        this.Ssj = jceInputStream.read(this.Ssj, 1, false);
        this.Ssk = jceInputStream.read(this.Ssk, 2, false);
        AppMethodBeat.o(214759);
    }
}
