package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aha extends a {
    public int LnA;
    public int LqF;
    public int LqG;
    public int LqH;
    public int LqI;
    public int LqJ;
    public int LqK;
    public int channels;
    public int qsU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90964);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LqF);
            aVar.aM(2, this.LqG);
            aVar.aM(3, this.channels);
            aVar.aM(4, this.LqH);
            aVar.aM(5, this.LnA);
            aVar.aM(6, this.qsU);
            aVar.aM(7, this.LqI);
            aVar.aM(8, this.LqJ);
            aVar.aM(9, this.LqK);
            AppMethodBeat.o(90964);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LqF) + 0 + g.a.a.b.b.a.bu(2, this.LqG) + g.a.a.b.b.a.bu(3, this.channels) + g.a.a.b.b.a.bu(4, this.LqH) + g.a.a.b.b.a.bu(5, this.LnA) + g.a.a.b.b.a.bu(6, this.qsU) + g.a.a.b.b.a.bu(7, this.LqI) + g.a.a.b.b.a.bu(8, this.LqJ) + g.a.a.b.b.a.bu(9, this.LqK);
            AppMethodBeat.o(90964);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90964);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aha aha = (aha) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aha.LqF = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 2:
                    aha.LqG = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 3:
                    aha.channels = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 4:
                    aha.LqH = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 5:
                    aha.LnA = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 6:
                    aha.qsU = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 7:
                    aha.LqI = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 8:
                    aha.LqJ = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                case 9:
                    aha.LqK = aVar3.UbS.zi();
                    AppMethodBeat.o(90964);
                    return 0;
                default:
                    AppMethodBeat.o(90964);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90964);
            return -1;
        }
    }
}
