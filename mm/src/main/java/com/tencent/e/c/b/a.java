package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class a extends JceStruct {
    static ArrayList<b> RLA = new ArrayList<>();
    static d RLB = new d();
    static c RLz = new c();
    public c RLw = null;
    public ArrayList<b> RLx = null;
    public d RLy = null;

    @Override // com.qq.taf.jce.JceStruct
    public final JceStruct newInit() {
        AppMethodBeat.i(138328);
        a aVar = new a();
        AppMethodBeat.o(138328);
        return aVar;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138329);
        if (this.RLw != null) {
            jceOutputStream.write((JceStruct) this.RLw, 0);
        }
        if (this.RLx != null) {
            jceOutputStream.write((Collection) this.RLx, 1);
        }
        if (this.RLy != null) {
            jceOutputStream.write((JceStruct) this.RLy, 2);
        }
        AppMethodBeat.o(138329);
    }

    static {
        AppMethodBeat.i(138331);
        RLA.add(new b());
        AppMethodBeat.o(138331);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138330);
        this.RLw = (c) jceInputStream.read((JceStruct) RLz, 0, false);
        this.RLx = (ArrayList) jceInputStream.read((Object) RLA, 1, false);
        this.RLy = (d) jceInputStream.read((JceStruct) RLB, 2, false);
        AppMethodBeat.o(138330);
    }
}
