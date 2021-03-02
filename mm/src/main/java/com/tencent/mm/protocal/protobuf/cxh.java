package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cxh extends a {
    public int MBP;
    public int MBQ;
    public String eaO;
    public String pTM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114046);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            if (this.pTM != null) {
                aVar.e(2, this.pTM);
            }
            aVar.aM(3, this.MBP);
            aVar.aM(4, this.MBQ);
            AppMethodBeat.o(114046);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0;
            if (this.pTM != null) {
                f2 += g.a.a.b.b.a.f(2, this.pTM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MBP) + g.a.a.b.b.a.bu(4, this.MBQ);
            AppMethodBeat.o(114046);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114046);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxh cxh = (cxh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxh.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114046);
                    return 0;
                case 2:
                    cxh.pTM = aVar3.UbS.readString();
                    AppMethodBeat.o(114046);
                    return 0;
                case 3:
                    cxh.MBP = aVar3.UbS.zi();
                    AppMethodBeat.o(114046);
                    return 0;
                case 4:
                    cxh.MBQ = aVar3.UbS.zi();
                    AppMethodBeat.o(114046);
                    return 0;
                default:
                    AppMethodBeat.o(114046);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114046);
            return -1;
        }
    }
}
