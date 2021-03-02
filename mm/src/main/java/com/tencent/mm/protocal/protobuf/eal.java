package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eal extends a {
    public int KHa;
    public int MZQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125803);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KHa);
            aVar.aM(2, this.MZQ);
            AppMethodBeat.o(125803);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KHa) + 0 + g.a.a.b.b.a.bu(2, this.MZQ);
            AppMethodBeat.o(125803);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125803);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eal eal = (eal) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eal.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(125803);
                    return 0;
                case 2:
                    eal.MZQ = aVar3.UbS.zi();
                    AppMethodBeat.o(125803);
                    return 0;
                default:
                    AppMethodBeat.o(125803);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125803);
            return -1;
        }
    }
}
