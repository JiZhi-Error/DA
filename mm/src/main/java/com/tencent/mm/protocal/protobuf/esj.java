package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class esj extends a {
    public int KIB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32500);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).aM(1, this.KIB);
            AppMethodBeat.o(32500);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KIB) + 0;
            AppMethodBeat.o(32500);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(32500);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            esj esj = (esj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    esj.KIB = aVar2.UbS.zi();
                    AppMethodBeat.o(32500);
                    return 0;
                default:
                    AppMethodBeat.o(32500);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32500);
            return -1;
        }
    }
}
