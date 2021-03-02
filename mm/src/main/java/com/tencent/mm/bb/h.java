package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class h extends a {
    public int dYn;
    public int jgU;
    public int jgV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150799);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dYn);
            aVar.aM(2, this.jgU);
            aVar.aM(3, this.jgV);
            AppMethodBeat.o(150799);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dYn) + 0 + g.a.a.b.b.a.bu(2, this.jgU) + g.a.a.b.b.a.bu(3, this.jgV);
            AppMethodBeat.o(150799);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.dYn = aVar3.UbS.zi();
                    AppMethodBeat.o(150799);
                    return 0;
                case 2:
                    hVar.jgU = aVar3.UbS.zi();
                    AppMethodBeat.o(150799);
                    return 0;
                case 3:
                    hVar.jgV = aVar3.UbS.zi();
                    AppMethodBeat.o(150799);
                    return 0;
                default:
                    AppMethodBeat.o(150799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(150799);
            return -1;
        }
    }
}
