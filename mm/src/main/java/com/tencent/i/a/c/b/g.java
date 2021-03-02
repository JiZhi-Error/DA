package com.tencent.i.a.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends JceStruct {
    static int Ssu = 0;
    public float Ekw = 0.0f;
    public float Ekx = 0.0f;
    public float Eky = 0.0f;
    public long RNA = 0;
    public int RNh = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(214763);
        jceOutputStream.write(this.RNh, 0);
        jceOutputStream.write(this.Ekw, 1);
        jceOutputStream.write(this.Ekx, 2);
        jceOutputStream.write(this.Eky, 3);
        jceOutputStream.write(this.RNA, 4);
        AppMethodBeat.o(214763);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(214764);
        this.RNh = jceInputStream.read(this.RNh, 0, true);
        this.Ekw = jceInputStream.read(this.Ekw, 1, false);
        this.Ekx = jceInputStream.read(this.Ekx, 2, false);
        this.Eky = jceInputStream.read(this.Eky, 3, false);
        this.RNA = jceInputStream.read(this.RNA, 4, false);
        AppMethodBeat.o(214764);
    }
}
