package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends JceStruct {
    public String Sqg = "";
    public String Sqh = "";

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214751);
        jceOutputStream.write(this.Sqg, 0);
        if (this.Sqh != null) {
            jceOutputStream.write(this.Sqh, 1);
        }
        AppMethodBeat.o(214751);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214752);
        this.Sqg = jceInputStream.readString(0, true);
        this.Sqh = jceInputStream.readString(1, false);
        AppMethodBeat.o(214752);
    }
}
