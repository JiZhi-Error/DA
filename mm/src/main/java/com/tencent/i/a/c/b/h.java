package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class h extends JceStruct {
    static ArrayList<Double> Ssq = new ArrayList<>();
    public long RNB = 0;
    public ArrayList<Double> kgc = null;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214765);
        jceOutputStream.write(this.RNB, 0);
        jceOutputStream.write((Collection) this.kgc, 1);
        AppMethodBeat.o(214765);
    }

    static {
        AppMethodBeat.i(214767);
        Ssq.add(Double.valueOf(0.0d));
        AppMethodBeat.o(214767);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214766);
        this.RNB = jceInputStream.read(this.RNB, 0, true);
        this.kgc = (ArrayList) jceInputStream.read((Object) Ssq, 1, true);
        AppMethodBeat.o(214766);
    }
}
