package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cct extends a {
    public int MiA;
    public int MiB;
    public int MiC;
    public int MiD;
    public int MiE;
    public int MiF;
    public int MiG;
    public int dDH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143981);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MiA);
            aVar.aM(2, this.dDH);
            aVar.aM(3, this.MiB);
            aVar.aM(4, this.MiC);
            aVar.aM(5, this.MiD);
            aVar.aM(6, this.MiE);
            aVar.aM(7, this.MiF);
            aVar.aM(8, this.MiG);
            AppMethodBeat.o(143981);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MiA) + 0 + g.a.a.b.b.a.bu(2, this.dDH) + g.a.a.b.b.a.bu(3, this.MiB) + g.a.a.b.b.a.bu(4, this.MiC) + g.a.a.b.b.a.bu(5, this.MiD) + g.a.a.b.b.a.bu(6, this.MiE) + g.a.a.b.b.a.bu(7, this.MiF) + g.a.a.b.b.a.bu(8, this.MiG);
            AppMethodBeat.o(143981);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143981);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cct cct = (cct) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cct.MiA = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 2:
                    cct.dDH = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 3:
                    cct.MiB = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 4:
                    cct.MiC = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 5:
                    cct.MiD = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 6:
                    cct.MiE = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 7:
                    cct.MiF = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                case 8:
                    cct.MiG = aVar3.UbS.zi();
                    AppMethodBeat.o(143981);
                    return 0;
                default:
                    AppMethodBeat.o(143981);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143981);
            return -1;
        }
    }
}
