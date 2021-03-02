package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cjd extends a {
    public int MoA;
    public int MoB;
    public int MoC;
    public int MoD;
    public int MoE;
    public int MoF;
    public int Mow;
    public int Mox;
    public int Moy;
    public int Moz;
    public int VjP;
    public int VjQ;
    public int VjR;
    public int VjS;
    public int VjT;
    public int VjU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196384);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mow);
            aVar.aM(2, this.Mox);
            aVar.aM(3, this.Moy);
            aVar.aM(4, this.Moz);
            aVar.aM(5, this.MoA);
            aVar.aM(6, this.MoB);
            aVar.aM(7, this.MoC);
            aVar.aM(8, this.MoD);
            aVar.aM(9, this.MoE);
            aVar.aM(10, this.MoF);
            aVar.aM(11, this.VjP);
            aVar.aM(12, this.VjQ);
            aVar.aM(13, this.VjR);
            aVar.aM(14, this.VjS);
            aVar.aM(15, this.VjT);
            aVar.aM(16, this.VjU);
            AppMethodBeat.o(196384);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mow) + 0 + g.a.a.b.b.a.bu(2, this.Mox) + g.a.a.b.b.a.bu(3, this.Moy) + g.a.a.b.b.a.bu(4, this.Moz) + g.a.a.b.b.a.bu(5, this.MoA) + g.a.a.b.b.a.bu(6, this.MoB) + g.a.a.b.b.a.bu(7, this.MoC) + g.a.a.b.b.a.bu(8, this.MoD) + g.a.a.b.b.a.bu(9, this.MoE) + g.a.a.b.b.a.bu(10, this.MoF) + g.a.a.b.b.a.bu(11, this.VjP) + g.a.a.b.b.a.bu(12, this.VjQ) + g.a.a.b.b.a.bu(13, this.VjR) + g.a.a.b.b.a.bu(14, this.VjS) + g.a.a.b.b.a.bu(15, this.VjT) + g.a.a.b.b.a.bu(16, this.VjU);
            AppMethodBeat.o(196384);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196384);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjd cjd = (cjd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjd.Mow = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 2:
                    cjd.Mox = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 3:
                    cjd.Moy = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 4:
                    cjd.Moz = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 5:
                    cjd.MoA = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 6:
                    cjd.MoB = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 7:
                    cjd.MoC = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 8:
                    cjd.MoD = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 9:
                    cjd.MoE = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 10:
                    cjd.MoF = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 11:
                    cjd.VjP = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 12:
                    cjd.VjQ = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 13:
                    cjd.VjR = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 14:
                    cjd.VjS = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 15:
                    cjd.VjT = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                case 16:
                    cjd.VjU = aVar3.UbS.zi();
                    AppMethodBeat.o(196384);
                    return 0;
                default:
                    AppMethodBeat.o(196384);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196384);
            return -1;
        }
    }
}
