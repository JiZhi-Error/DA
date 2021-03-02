package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bgc extends a {
    public boolean LPO;
    public boolean LPP;
    public boolean LPQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116470);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.LPO);
            aVar.cc(2, this.LPP);
            aVar.cc(3, this.LPQ);
            AppMethodBeat.o(116470);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(116470);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116470);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgc bgc = (bgc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgc.LPO = aVar3.UbS.yZ();
                    AppMethodBeat.o(116470);
                    return 0;
                case 2:
                    bgc.LPP = aVar3.UbS.yZ();
                    AppMethodBeat.o(116470);
                    return 0;
                case 3:
                    bgc.LPQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(116470);
                    return 0;
                default:
                    AppMethodBeat.o(116470);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116470);
            return -1;
        }
    }
}
