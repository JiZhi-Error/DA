package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends JceStruct {
    public String RMk = "";
    public String RMl = "";
    public int RMm = 0;
    public String RMn = "";
    public int RMo = 0;
    public String brand = "";
    public String model = "";
    public String platform = "";

    @Override // com.qq.taf.jce.JceStruct
    public final JceStruct newInit() {
        AppMethodBeat.i(138339);
        d dVar = new d();
        AppMethodBeat.o(138339);
        return dVar;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138340);
        if (this.RMk != null) {
            jceOutputStream.write(this.RMk, 0);
        }
        if (this.RMl != null) {
            jceOutputStream.write(this.RMl, 1);
        }
        if (this.brand != null) {
            jceOutputStream.write(this.brand, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.RMm != 0) {
            jceOutputStream.write(this.RMm, 4);
        }
        if (this.RMn != null) {
            jceOutputStream.write(this.RMn, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.RMo != 0) {
            jceOutputStream.write(this.RMo, 7);
        }
        AppMethodBeat.o(138340);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138341);
        this.RMk = jceInputStream.readString(0, false);
        this.RMl = jceInputStream.readString(1, false);
        this.brand = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.RMm = jceInputStream.read(this.RMm, 4, false);
        this.RMn = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.RMo = jceInputStream.read(this.RMo, 7, false);
        AppMethodBeat.o(138341);
    }
}
