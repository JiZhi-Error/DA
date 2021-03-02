package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbt extends a {
    public int NxR;
    public int NxS;
    public int NxT;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196218);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.version);
            aVar.aM(2, this.NxR);
            aVar.aM(3, this.NxS);
            aVar.aM(4, this.NxT);
            AppMethodBeat.o(196218);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.version) + 0 + g.a.a.b.b.a.bu(2, this.NxR) + g.a.a.b.b.a.bu(3, this.NxS) + g.a.a.b.b.a.bu(4, this.NxT);
            AppMethodBeat.o(196218);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196218);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbt fbt = (fbt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbt.version = aVar3.UbS.zi();
                    AppMethodBeat.o(196218);
                    return 0;
                case 2:
                    fbt.NxR = aVar3.UbS.zi();
                    AppMethodBeat.o(196218);
                    return 0;
                case 3:
                    fbt.NxS = aVar3.UbS.zi();
                    AppMethodBeat.o(196218);
                    return 0;
                case 4:
                    fbt.NxT = aVar3.UbS.zi();
                    AppMethodBeat.o(196218);
                    return 0;
                default:
                    AppMethodBeat.o(196218);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196218);
            return -1;
        }
    }
}
