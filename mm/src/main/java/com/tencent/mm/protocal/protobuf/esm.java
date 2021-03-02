package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class esm extends a {
    public int NpA;
    public String NpE;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32501);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NpA);
            aVar.aM(2, this.jeU);
            if (this.NpE != null) {
                aVar.e(3, this.NpE);
            }
            AppMethodBeat.o(32501);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NpA) + 0 + g.a.a.b.b.a.bu(2, this.jeU);
            if (this.NpE != null) {
                bu += g.a.a.b.b.a.f(3, this.NpE);
            }
            AppMethodBeat.o(32501);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32501);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esm esm = (esm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    esm.NpA = aVar3.UbS.zi();
                    AppMethodBeat.o(32501);
                    return 0;
                case 2:
                    esm.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(32501);
                    return 0;
                case 3:
                    esm.NpE = aVar3.UbS.readString();
                    AppMethodBeat.o(32501);
                    return 0;
                default:
                    AppMethodBeat.o(32501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32501);
            return -1;
        }
    }
}
