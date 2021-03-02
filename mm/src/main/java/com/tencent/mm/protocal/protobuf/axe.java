package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axe extends a {
    public int hzl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209557);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).aM(1, this.hzl);
            AppMethodBeat.o(209557);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.hzl) + 0;
            AppMethodBeat.o(209557);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(209557);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            axe axe = (axe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axe.hzl = aVar2.UbS.zi();
                    AppMethodBeat.o(209557);
                    return 0;
                default:
                    AppMethodBeat.o(209557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209557);
            return -1;
        }
    }
}
