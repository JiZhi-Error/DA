package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    public int errCode = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138419);
        if (this.errCode != 0) {
            jceOutputStream.write(this.errCode, 0);
        }
        AppMethodBeat.o(138419);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138420);
        this.errCode = jceInputStream.read(this.errCode, 0, false);
        AppMethodBeat.o(138420);
    }
}
