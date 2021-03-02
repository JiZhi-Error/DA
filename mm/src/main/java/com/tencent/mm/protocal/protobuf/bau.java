package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bau extends a {
    public int LKq;
    public int LKr;
    public int LKs;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184204);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LKq);
            aVar.aM(2, this.LKr);
            aVar.aM(3, this.LKs);
            AppMethodBeat.o(184204);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LKq) + 0 + g.a.a.b.b.a.bu(2, this.LKr) + g.a.a.b.b.a.bu(3, this.LKs);
            AppMethodBeat.o(184204);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184204);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bau bau = (bau) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bau.LKq = aVar3.UbS.zi();
                    AppMethodBeat.o(184204);
                    return 0;
                case 2:
                    bau.LKr = aVar3.UbS.zi();
                    AppMethodBeat.o(184204);
                    return 0;
                case 3:
                    bau.LKs = aVar3.UbS.zi();
                    AppMethodBeat.o(184204);
                    return 0;
                default:
                    AppMethodBeat.o(184204);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184204);
            return -1;
        }
    }
}
