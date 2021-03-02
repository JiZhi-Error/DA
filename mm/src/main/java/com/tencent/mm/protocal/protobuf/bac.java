package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bac extends a {
    public int LJQ;
    public int LJR;
    public int LJS;
    public int LJT;
    public int LJU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209626);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LJQ);
            aVar.aM(2, this.LJR);
            aVar.aM(3, this.LJS);
            aVar.aM(4, this.LJT);
            aVar.aM(5, this.LJU);
            AppMethodBeat.o(209626);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LJQ) + 0 + g.a.a.b.b.a.bu(2, this.LJR) + g.a.a.b.b.a.bu(3, this.LJS) + g.a.a.b.b.a.bu(4, this.LJT) + g.a.a.b.b.a.bu(5, this.LJU);
            AppMethodBeat.o(209626);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209626);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bac bac = (bac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bac.LJQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209626);
                    return 0;
                case 2:
                    bac.LJR = aVar3.UbS.zi();
                    AppMethodBeat.o(209626);
                    return 0;
                case 3:
                    bac.LJS = aVar3.UbS.zi();
                    AppMethodBeat.o(209626);
                    return 0;
                case 4:
                    bac.LJT = aVar3.UbS.zi();
                    AppMethodBeat.o(209626);
                    return 0;
                case 5:
                    bac.LJU = aVar3.UbS.zi();
                    AppMethodBeat.o(209626);
                    return 0;
                default:
                    AppMethodBeat.o(209626);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209626);
            return -1;
        }
    }
}
