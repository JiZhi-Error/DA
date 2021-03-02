package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends JceStruct {
    static int SsA = 0;
    public int Ssv = 0;
    public long Ssw = 0;
    public float Ssx = 0.0f;
    public float Ssy = 0.0f;
    public int Ssz = 0;
    public float gZZ = 0.0f;
    public float haa = 0.0f;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214768);
        jceOutputStream.write(this.Ssv, 0);
        jceOutputStream.write(this.gZZ, 1);
        jceOutputStream.write(this.haa, 2);
        jceOutputStream.write(this.Ssw, 3);
        jceOutputStream.write(this.Ssx, 4);
        jceOutputStream.write(this.Ssy, 5);
        jceOutputStream.write(this.Ssz, 6);
        AppMethodBeat.o(214768);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214769);
        this.Ssv = jceInputStream.read(this.Ssv, 0, true);
        this.gZZ = jceInputStream.read(this.gZZ, 1, true);
        this.haa = jceInputStream.read(this.haa, 2, true);
        this.Ssw = jceInputStream.read(this.Ssw, 3, true);
        this.Ssx = jceInputStream.read(this.Ssx, 4, false);
        this.Ssy = jceInputStream.read(this.Ssy, 5, false);
        this.Ssz = jceInputStream.read(this.Ssz, 6, false);
        AppMethodBeat.o(214769);
    }
}
