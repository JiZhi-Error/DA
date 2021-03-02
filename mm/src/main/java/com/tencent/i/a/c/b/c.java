package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class c extends JceStruct {
    static ArrayList<g> Sse = new ArrayList<>();
    static int Ssf = 0;
    static int Ssg = 0;
    public long RNB = 0;
    public int RNi = 0;
    public int RNj = 0;
    public ArrayList<g> Ssd = null;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214753);
        jceOutputStream.write(this.RNB, 0);
        jceOutputStream.write((Collection) this.Ssd, 1);
        jceOutputStream.write(this.RNi, 2);
        jceOutputStream.write(this.RNj, 3);
        AppMethodBeat.o(214753);
    }

    static {
        AppMethodBeat.i(214755);
        Sse.add(new g());
        AppMethodBeat.o(214755);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214754);
        this.RNB = jceInputStream.read(this.RNB, 0, true);
        this.Ssd = (ArrayList) jceInputStream.read((Object) Sse, 1, true);
        this.RNi = jceInputStream.read(this.RNi, 2, false);
        this.RNj = jceInputStream.read(this.RNj, 3, false);
        AppMethodBeat.o(214754);
    }
}
