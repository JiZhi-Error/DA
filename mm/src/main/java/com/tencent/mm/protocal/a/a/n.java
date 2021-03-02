package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class n extends a {
    public int KAy;
    public int KBh;
    public int KBi;
    public int KBj;
    public int KBk;
    public int KBl;
    public int KBm;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143958);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KAy);
            aVar.aM(2, this.KBh);
            aVar.aM(3, this.KBi);
            aVar.aM(4, this.KBj);
            aVar.aM(5, this.KBk);
            aVar.aM(6, this.KBl);
            aVar.aM(7, this.KBm);
            aVar.aM(8, this.type);
            AppMethodBeat.o(143958);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAy) + 0 + g.a.a.b.b.a.bu(2, this.KBh) + g.a.a.b.b.a.bu(3, this.KBi) + g.a.a.b.b.a.bu(4, this.KBj) + g.a.a.b.b.a.bu(5, this.KBk) + g.a.a.b.b.a.bu(6, this.KBl) + g.a.a.b.b.a.bu(7, this.KBm) + g.a.a.b.b.a.bu(8, this.type);
            AppMethodBeat.o(143958);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143958);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.KAy = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 2:
                    nVar.KBh = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 3:
                    nVar.KBi = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 4:
                    nVar.KBj = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 5:
                    nVar.KBk = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 6:
                    nVar.KBl = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 7:
                    nVar.KBm = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                case 8:
                    nVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(143958);
                    return 0;
                default:
                    AppMethodBeat.o(143958);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143958);
            return -1;
        }
    }
}
