package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class apx extends a {
    public int LBF;
    public int LBG;
    public int LBH;
    public int LBI;
    public int LBJ;
    public int LBK;
    public int LBL;
    public int count;
    public int fans_count;
    public int jhQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168947);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.count);
            aVar.aM(2, this.LBF);
            aVar.aM(3, this.LBG);
            aVar.aM(4, this.LBH);
            aVar.aM(5, this.LBI);
            aVar.aM(7, this.fans_count);
            aVar.aM(8, this.LBJ);
            aVar.aM(9, this.jhQ);
            aVar.aM(10, this.LBK);
            aVar.aM(11, this.LBL);
            AppMethodBeat.o(168947);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.count) + 0 + g.a.a.b.b.a.bu(2, this.LBF) + g.a.a.b.b.a.bu(3, this.LBG) + g.a.a.b.b.a.bu(4, this.LBH) + g.a.a.b.b.a.bu(5, this.LBI) + g.a.a.b.b.a.bu(7, this.fans_count) + g.a.a.b.b.a.bu(8, this.LBJ) + g.a.a.b.b.a.bu(9, this.jhQ) + g.a.a.b.b.a.bu(10, this.LBK) + g.a.a.b.b.a.bu(11, this.LBL);
            AppMethodBeat.o(168947);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168947);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apx apx = (apx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apx.count = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 2:
                    apx.LBF = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 3:
                    apx.LBG = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 4:
                    apx.LBH = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 5:
                    apx.LBI = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 6:
                default:
                    AppMethodBeat.o(168947);
                    return -1;
                case 7:
                    apx.fans_count = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 8:
                    apx.LBJ = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 9:
                    apx.jhQ = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 10:
                    apx.LBK = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
                case 11:
                    apx.LBL = aVar3.UbS.zi();
                    AppMethodBeat.o(168947);
                    return 0;
            }
        } else {
            AppMethodBeat.o(168947);
            return -1;
        }
    }
}
