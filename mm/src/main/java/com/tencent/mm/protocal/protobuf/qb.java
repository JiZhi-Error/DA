package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qb extends a {
    public int KWU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124459);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).aM(1, this.KWU);
            AppMethodBeat.o(124459);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KWU) + 0;
            AppMethodBeat.o(124459);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(124459);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            qb qbVar = (qb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qbVar.KWU = aVar2.UbS.zi();
                    AppMethodBeat.o(124459);
                    return 0;
                default:
                    AppMethodBeat.o(124459);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124459);
            return -1;
        }
    }
}