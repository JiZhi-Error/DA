package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class act extends a {
    public int LnA;
    public int LnB;
    public int LnC;
    public int Lnz;
    public int qsR;
    public int qsS;
    public int qsT;
    public int qsU;
    public int qsV;
    public int qsW;
    public int qsX;
    public int qsY;
    public int qsZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90959);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.qsR);
            aVar.aM(2, this.Lnz);
            aVar.aM(3, this.qsS);
            aVar.aM(4, this.qsT);
            aVar.aM(5, this.qsU);
            aVar.aM(6, this.LnA);
            aVar.aM(7, this.qsV);
            aVar.aM(8, this.qsW);
            aVar.aM(9, this.LnB);
            aVar.aM(10, this.LnC);
            aVar.aM(11, this.qsX);
            aVar.aM(12, this.qsY);
            aVar.aM(13, this.qsZ);
            AppMethodBeat.o(90959);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.qsR) + 0 + g.a.a.b.b.a.bu(2, this.Lnz) + g.a.a.b.b.a.bu(3, this.qsS) + g.a.a.b.b.a.bu(4, this.qsT) + g.a.a.b.b.a.bu(5, this.qsU) + g.a.a.b.b.a.bu(6, this.LnA) + g.a.a.b.b.a.bu(7, this.qsV) + g.a.a.b.b.a.bu(8, this.qsW) + g.a.a.b.b.a.bu(9, this.LnB) + g.a.a.b.b.a.bu(10, this.LnC) + g.a.a.b.b.a.bu(11, this.qsX) + g.a.a.b.b.a.bu(12, this.qsY) + g.a.a.b.b.a.bu(13, this.qsZ);
            AppMethodBeat.o(90959);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90959);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            act act = (act) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    act.qsR = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 2:
                    act.Lnz = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 3:
                    act.qsS = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 4:
                    act.qsT = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 5:
                    act.qsU = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 6:
                    act.LnA = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 7:
                    act.qsV = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 8:
                    act.qsW = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 9:
                    act.LnB = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 10:
                    act.LnC = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 11:
                    act.qsX = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 12:
                    act.qsY = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                case 13:
                    act.qsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(90959);
                    return 0;
                default:
                    AppMethodBeat.o(90959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90959);
            return -1;
        }
    }
}
