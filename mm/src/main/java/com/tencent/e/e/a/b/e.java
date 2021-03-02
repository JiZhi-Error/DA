package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;

public final class e extends JceStruct {
    static ArrayList<g> RNz;
    public int RMA = 0;
    public long RNw = 0;
    public ArrayList<g> RNx = null;
    public double RNy = 0.0d;
    public int action = 0;
    public double lat = 0.0d;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138423);
        jceOutputStream.write(this.RNw, 0);
        jceOutputStream.write((Collection) this.RNx, 1);
        if (this.RMA != 0) {
            jceOutputStream.write(this.RMA, 2);
        }
        if (this.action != 0) {
            jceOutputStream.write(this.action, 3);
        }
        if (this.lat != 0.0d) {
            jceOutputStream.write(this.lat, 4);
        }
        if (this.RNy != 0.0d) {
            jceOutputStream.write(this.RNy, 5);
        }
        AppMethodBeat.o(138423);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138424);
        this.RNw = jceInputStream.read(this.RNw, 0, true);
        if (RNz == null) {
            RNz = new ArrayList<>();
            RNz.add(new g());
        }
        this.RNx = (ArrayList) jceInputStream.read((Object) RNz, 1, true);
        this.RMA = jceInputStream.read(this.RMA, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.RNy = jceInputStream.read(this.RNy, 5, false);
        AppMethodBeat.o(138424);
    }
}
