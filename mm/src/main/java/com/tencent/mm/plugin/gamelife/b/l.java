package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public String pTL;
    public int uSc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225899);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uSc);
            if (this.pTL != null) {
                aVar.e(2, this.pTL);
            }
            AppMethodBeat.o(225899);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uSc) + 0;
            if (this.pTL != null) {
                bu += g.a.a.b.b.a.f(2, this.pTL);
            }
            AppMethodBeat.o(225899);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225899);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.uSc = aVar3.UbS.zi();
                    AppMethodBeat.o(225899);
                    return 0;
                case 2:
                    lVar.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(225899);
                    return 0;
                default:
                    AppMethodBeat.o(225899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225899);
            return -1;
        }
    }
}
