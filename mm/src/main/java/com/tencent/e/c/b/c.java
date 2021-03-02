package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    static byte[] RMi;
    static byte[] RMj;
    public int RLZ = 0;
    public int RLr = 0;
    public int RMa = 0;
    public int RMb = 0;
    public byte[] RMc = null;
    public int RMd = 0;
    public long RMe = 0;
    public byte[] RMf = null;
    public int RMg = 0;
    public int RMh = 0;
    public int iSY = 0;
    public int requestType = 0;

    @Override // com.qq.taf.jce.JceStruct
    public final JceStruct newInit() {
        AppMethodBeat.i(138336);
        c cVar = new c();
        AppMethodBeat.o(138336);
        return cVar;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(138337);
        if (this.RLZ != 0) {
            jceOutputStream.write(this.RLZ, 0);
        }
        jceOutputStream.write(this.RLr, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.RMa != 0) {
            jceOutputStream.write(this.RMa, 3);
        }
        if (this.RMb != 0) {
            jceOutputStream.write(this.RMb, 4);
        }
        if (this.RMc != null) {
            jceOutputStream.write(this.RMc, 5);
        }
        if (this.RMd != 0) {
            jceOutputStream.write(this.RMd, 6);
        }
        if (this.iSY != 0) {
            jceOutputStream.write(this.iSY, 7);
        }
        if (this.RMe != 0) {
            jceOutputStream.write(this.RMe, 8);
        }
        if (this.RMf != null) {
            jceOutputStream.write(this.RMf, 9);
        }
        if (this.RMg != 0) {
            jceOutputStream.write(this.RMg, 10);
        }
        if (this.RMh != 0) {
            jceOutputStream.write(this.RMh, 11);
        }
        AppMethodBeat.o(138337);
    }

    static {
        byte[] bArr = new byte[1];
        RMi = bArr;
        bArr[0] = 0;
        byte[] bArr2 = new byte[1];
        RMj = bArr2;
        bArr2[0] = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(138338);
        this.RLZ = jceInputStream.read(this.RLZ, 0, false);
        this.RLr = jceInputStream.read(this.RLr, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.RMa = jceInputStream.read(this.RMa, 3, false);
        this.RMb = jceInputStream.read(this.RMb, 4, false);
        this.RMc = jceInputStream.read(RMi, 5, false);
        this.RMd = jceInputStream.read(this.RMd, 6, false);
        this.iSY = jceInputStream.read(this.iSY, 7, false);
        this.RMe = jceInputStream.read(this.RMe, 8, false);
        this.RMf = jceInputStream.read(RMj, 9, false);
        this.RMg = jceInputStream.read(this.RMg, 10, false);
        this.RMh = jceInputStream.read(this.RMh, 11, false);
        AppMethodBeat.o(138338);
    }
}
