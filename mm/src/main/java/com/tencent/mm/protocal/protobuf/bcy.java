package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bcy extends a {
    public int LMf;
    public int LMg;
    public int LMh;
    public int LMi;
    public int LMj;
    public int LMk;
    public int LMl;
    public int LMm;
    public int LMn;
    public int LMo;
    public int LMp;
    public int LMq;
    public int LMr;
    public int LMs;
    public int LMt;
    public int LMu;
    public boolean LMv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209688);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LMf);
            aVar.aM(2, this.LMg);
            aVar.aM(3, this.LMh);
            aVar.aM(4, this.LMi);
            aVar.aM(5, this.LMj);
            aVar.aM(6, this.LMk);
            aVar.aM(7, this.LMl);
            aVar.aM(8, this.LMm);
            aVar.aM(9, this.LMn);
            aVar.aM(10, this.LMo);
            aVar.aM(11, this.LMp);
            aVar.aM(12, this.LMq);
            aVar.aM(13, this.LMr);
            aVar.aM(14, this.LMs);
            aVar.aM(15, this.LMt);
            aVar.aM(16, this.LMu);
            aVar.cc(17, this.LMv);
            AppMethodBeat.o(209688);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LMf) + 0 + g.a.a.b.b.a.bu(2, this.LMg) + g.a.a.b.b.a.bu(3, this.LMh) + g.a.a.b.b.a.bu(4, this.LMi) + g.a.a.b.b.a.bu(5, this.LMj) + g.a.a.b.b.a.bu(6, this.LMk) + g.a.a.b.b.a.bu(7, this.LMl) + g.a.a.b.b.a.bu(8, this.LMm) + g.a.a.b.b.a.bu(9, this.LMn) + g.a.a.b.b.a.bu(10, this.LMo) + g.a.a.b.b.a.bu(11, this.LMp) + g.a.a.b.b.a.bu(12, this.LMq) + g.a.a.b.b.a.bu(13, this.LMr) + g.a.a.b.b.a.bu(14, this.LMs) + g.a.a.b.b.a.bu(15, this.LMt) + g.a.a.b.b.a.bu(16, this.LMu) + g.a.a.b.b.a.fS(17) + 1;
            AppMethodBeat.o(209688);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209688);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcy bcy = (bcy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcy.LMf = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 2:
                    bcy.LMg = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 3:
                    bcy.LMh = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 4:
                    bcy.LMi = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 5:
                    bcy.LMj = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 6:
                    bcy.LMk = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 7:
                    bcy.LMl = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 8:
                    bcy.LMm = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 9:
                    bcy.LMn = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 10:
                    bcy.LMo = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 11:
                    bcy.LMp = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 12:
                    bcy.LMq = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 13:
                    bcy.LMr = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 14:
                    bcy.LMs = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 15:
                    bcy.LMt = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 16:
                    bcy.LMu = aVar3.UbS.zi();
                    AppMethodBeat.o(209688);
                    return 0;
                case 17:
                    bcy.LMv = aVar3.UbS.yZ();
                    AppMethodBeat.o(209688);
                    return 0;
                default:
                    AppMethodBeat.o(209688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209688);
            return -1;
        }
    }
}
