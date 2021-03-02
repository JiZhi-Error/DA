package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends JceStruct {
    static b RNv;
    public b RNu = null;
    public int errorCode = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138421);
        jceOutputStream.write(this.errorCode, 0);
        if (this.RNu != null) {
            jceOutputStream.write((JceStruct) this.RNu, 1);
        }
        AppMethodBeat.o(138421);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138422);
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (RNv == null) {
            RNv = new b();
        }
        this.RNu = (b) jceInputStream.read((JceStruct) RNv, 1, false);
        AppMethodBeat.o(138422);
    }
}
