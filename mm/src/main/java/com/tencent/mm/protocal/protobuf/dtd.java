package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dtd extends a {
    public b LoA;
    public int MVj;
    public int MVk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149128);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MVj);
            aVar.aM(2, this.MVk);
            if (this.LoA != null) {
                aVar.c(3, this.LoA);
            }
            AppMethodBeat.o(149128);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MVj) + 0 + g.a.a.b.b.a.bu(2, this.MVk);
            if (this.LoA != null) {
                bu += g.a.a.b.b.a.b(3, this.LoA);
            }
            AppMethodBeat.o(149128);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149128);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtd dtd = (dtd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtd.MVj = aVar3.UbS.zi();
                    AppMethodBeat.o(149128);
                    return 0;
                case 2:
                    dtd.MVk = aVar3.UbS.zi();
                    AppMethodBeat.o(149128);
                    return 0;
                case 3:
                    dtd.LoA = aVar3.UbS.hPo();
                    AppMethodBeat.o(149128);
                    return 0;
                default:
                    AppMethodBeat.o(149128);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149128);
            return -1;
        }
    }
}
