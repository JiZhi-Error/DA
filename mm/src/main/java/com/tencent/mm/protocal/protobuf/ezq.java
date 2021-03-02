package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ezq extends a {
    public int CreateTime;
    public String KHq;
    public int MuU;
    public int NvO;
    public int oTz;
    public int oUv;
    public String xNG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32560);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNG != null) {
                aVar.e(1, this.xNG);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.oTz);
            aVar.aM(4, this.CreateTime);
            aVar.aM(5, this.MuU);
            if (this.KHq != null) {
                aVar.e(6, this.KHq);
            }
            aVar.aM(7, this.NvO);
            AppMethodBeat.o(32560);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xNG != null ? g.a.a.b.b.a.f(1, this.xNG) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.oTz) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MuU);
            if (this.KHq != null) {
                f2 += g.a.a.b.b.a.f(6, this.KHq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.NvO);
            AppMethodBeat.o(32560);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32560);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezq ezq = (ezq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezq.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(32560);
                    return 0;
                case 2:
                    ezq.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32560);
                    return 0;
                case 3:
                    ezq.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(32560);
                    return 0;
                case 4:
                    ezq.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(32560);
                    return 0;
                case 5:
                    ezq.MuU = aVar3.UbS.zi();
                    AppMethodBeat.o(32560);
                    return 0;
                case 6:
                    ezq.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(32560);
                    return 0;
                case 7:
                    ezq.NvO = aVar3.UbS.zi();
                    AppMethodBeat.o(32560);
                    return 0;
                default:
                    AppMethodBeat.o(32560);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32560);
            return -1;
        }
    }
}
