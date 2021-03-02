package com.tencent.e.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends JceStruct {
    public long RNA = 0;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138425);
        jceOutputStream.write(this.RNA, 0);
        jceOutputStream.write(this.x, 1);
        jceOutputStream.write(this.y, 2);
        jceOutputStream.write(this.z, 3);
        AppMethodBeat.o(138425);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138426);
        this.RNA = jceInputStream.read(this.RNA, 0, true);
        this.x = jceInputStream.read(this.x, 1, true);
        this.y = jceInputStream.read(this.y, 2, true);
        this.z = jceInputStream.read(this.z, 3, true);
        AppMethodBeat.o(138426);
    }
}
