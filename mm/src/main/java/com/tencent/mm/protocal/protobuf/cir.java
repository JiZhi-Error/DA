package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cir extends a {
    public int MnF;
    public int hDc;
    public int hDd;
    public int hDe;
    public int hDf;
    public int hDg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209723);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MnF);
            aVar.aM(2, this.hDc);
            aVar.aM(3, this.hDd);
            aVar.aM(4, this.hDf);
            aVar.aM(5, this.hDe);
            aVar.aM(6, this.hDg);
            AppMethodBeat.o(209723);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MnF) + 0 + g.a.a.b.b.a.bu(2, this.hDc) + g.a.a.b.b.a.bu(3, this.hDd) + g.a.a.b.b.a.bu(4, this.hDf) + g.a.a.b.b.a.bu(5, this.hDe) + g.a.a.b.b.a.bu(6, this.hDg);
            AppMethodBeat.o(209723);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209723);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cir cir = (cir) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cir.MnF = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                case 2:
                    cir.hDc = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                case 3:
                    cir.hDd = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                case 4:
                    cir.hDf = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                case 5:
                    cir.hDe = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                case 6:
                    cir.hDg = aVar3.UbS.zi();
                    AppMethodBeat.o(209723);
                    return 0;
                default:
                    AppMethodBeat.o(209723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209723);
            return -1;
        }
    }
}
