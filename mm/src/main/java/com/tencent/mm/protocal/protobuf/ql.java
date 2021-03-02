package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ql extends a {
    public int KXn;
    public int KXo;
    public int KXp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103204);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KXn);
            aVar.aM(2, this.KXo);
            aVar.aM(3, this.KXp);
            AppMethodBeat.o(103204);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KXn) + 0 + g.a.a.b.b.a.bu(2, this.KXo) + g.a.a.b.b.a.bu(3, this.KXp);
            AppMethodBeat.o(103204);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103204);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ql qlVar = (ql) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qlVar.KXn = aVar3.UbS.zi();
                    AppMethodBeat.o(103204);
                    return 0;
                case 2:
                    qlVar.KXo = aVar3.UbS.zi();
                    AppMethodBeat.o(103204);
                    return 0;
                case 3:
                    qlVar.KXp = aVar3.UbS.zi();
                    AppMethodBeat.o(103204);
                    return 0;
                default:
                    AppMethodBeat.o(103204);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103204);
            return -1;
        }
    }
}
