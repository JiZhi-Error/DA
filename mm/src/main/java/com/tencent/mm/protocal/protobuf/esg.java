package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class esg extends a {
    public int KKA;
    public int KKB;
    public int KKC;
    public int KKD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32498);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KKA);
            aVar.aM(2, this.KKB);
            aVar.aM(3, this.KKC);
            aVar.aM(4, this.KKD);
            AppMethodBeat.o(32498);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KKA) + 0 + g.a.a.b.b.a.bu(2, this.KKB) + g.a.a.b.b.a.bu(3, this.KKC) + g.a.a.b.b.a.bu(4, this.KKD);
            AppMethodBeat.o(32498);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32498);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esg esg = (esg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    esg.KKA = aVar3.UbS.zi();
                    AppMethodBeat.o(32498);
                    return 0;
                case 2:
                    esg.KKB = aVar3.UbS.zi();
                    AppMethodBeat.o(32498);
                    return 0;
                case 3:
                    esg.KKC = aVar3.UbS.zi();
                    AppMethodBeat.o(32498);
                    return 0;
                case 4:
                    esg.KKD = aVar3.UbS.zi();
                    AppMethodBeat.o(32498);
                    return 0;
                default:
                    AppMethodBeat.o(32498);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32498);
            return -1;
        }
    }
}
