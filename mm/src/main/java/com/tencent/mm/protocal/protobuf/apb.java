package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class apb extends a {
    public int LBb;
    public int LBc;
    public int LBd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209346);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LBb);
            aVar.aM(2, this.LBc);
            aVar.aM(3, this.LBd);
            AppMethodBeat.o(209346);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LBb) + 0 + g.a.a.b.b.a.bu(2, this.LBc) + g.a.a.b.b.a.bu(3, this.LBd);
            AppMethodBeat.o(209346);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209346);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apb apb = (apb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apb.LBb = aVar3.UbS.zi();
                    AppMethodBeat.o(209346);
                    return 0;
                case 2:
                    apb.LBc = aVar3.UbS.zi();
                    AppMethodBeat.o(209346);
                    return 0;
                case 3:
                    apb.LBd = aVar3.UbS.zi();
                    AppMethodBeat.o(209346);
                    return 0;
                default:
                    AppMethodBeat.o(209346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209346);
            return -1;
        }
    }
}
