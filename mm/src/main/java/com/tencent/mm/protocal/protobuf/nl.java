package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class nl extends a {
    public int KJN;
    public int KSQ;
    public int KSR;
    public int KSS;
    public int KST;
    public int KSU;
    public int enabled;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103202);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.enabled);
            aVar.aM(2, this.KSQ);
            aVar.aM(3, this.KSR);
            aVar.aM(4, this.KSS);
            aVar.aM(5, this.KST);
            aVar.aM(6, this.KSU);
            aVar.aM(7, this.KJN);
            AppMethodBeat.o(103202);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.enabled) + 0 + g.a.a.b.b.a.bu(2, this.KSQ) + g.a.a.b.b.a.bu(3, this.KSR) + g.a.a.b.b.a.bu(4, this.KSS) + g.a.a.b.b.a.bu(5, this.KST) + g.a.a.b.b.a.bu(6, this.KSU) + g.a.a.b.b.a.bu(7, this.KJN);
            AppMethodBeat.o(103202);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103202);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nl nlVar = (nl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nlVar.enabled = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 2:
                    nlVar.KSQ = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 3:
                    nlVar.KSR = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 4:
                    nlVar.KSS = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 5:
                    nlVar.KST = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 6:
                    nlVar.KSU = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                case 7:
                    nlVar.KJN = aVar3.UbS.zi();
                    AppMethodBeat.o(103202);
                    return 0;
                default:
                    AppMethodBeat.o(103202);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103202);
            return -1;
        }
    }
}
