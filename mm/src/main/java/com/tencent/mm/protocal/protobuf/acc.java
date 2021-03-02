package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acc extends a {
    public boolean LmF;
    public int LmG;
    public int dUS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225289);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dUS);
            aVar.cc(2, this.LmF);
            aVar.aM(3, this.LmG);
            AppMethodBeat.o(225289);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dUS) + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.LmG);
            AppMethodBeat.o(225289);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225289);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acc acc = (acc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acc.dUS = aVar3.UbS.zi();
                    AppMethodBeat.o(225289);
                    return 0;
                case 2:
                    acc.LmF = aVar3.UbS.yZ();
                    AppMethodBeat.o(225289);
                    return 0;
                case 3:
                    acc.LmG = aVar3.UbS.zi();
                    AppMethodBeat.o(225289);
                    return 0;
                default:
                    AppMethodBeat.o(225289);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225289);
            return -1;
        }
    }
}
