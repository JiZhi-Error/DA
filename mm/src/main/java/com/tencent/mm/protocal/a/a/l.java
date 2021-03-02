package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public int KAX;
    public int KAY;
    public int KAZ;
    public int KBa;
    public int KBb;
    public int KBc;
    public int KBd;
    public int action;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143955);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KAX);
            aVar.aM(2, this.action);
            aVar.aM(3, this.KAY);
            aVar.aM(4, this.KAZ);
            aVar.aM(5, this.KBa);
            aVar.aM(6, this.KBb);
            aVar.aM(7, this.KBc);
            aVar.aM(8, this.KBd);
            AppMethodBeat.o(143955);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAX) + 0 + g.a.a.b.b.a.bu(2, this.action) + g.a.a.b.b.a.bu(3, this.KAY) + g.a.a.b.b.a.bu(4, this.KAZ) + g.a.a.b.b.a.bu(5, this.KBa) + g.a.a.b.b.a.bu(6, this.KBb) + g.a.a.b.b.a.bu(7, this.KBc) + g.a.a.b.b.a.bu(8, this.KBd);
            AppMethodBeat.o(143955);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143955);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.KAX = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 2:
                    lVar.action = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 3:
                    lVar.KAY = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 4:
                    lVar.KAZ = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 5:
                    lVar.KBa = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 6:
                    lVar.KBb = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 7:
                    lVar.KBc = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                case 8:
                    lVar.KBd = aVar3.UbS.zi();
                    AppMethodBeat.o(143955);
                    return 0;
                default:
                    AppMethodBeat.o(143955);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143955);
            return -1;
        }
    }
}
