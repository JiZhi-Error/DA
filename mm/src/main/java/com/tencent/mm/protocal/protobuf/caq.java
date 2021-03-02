package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class caq extends a {
    public long MfO;
    public int MfP;
    public long MfQ;
    public int MfR;
    public long MfS;
    public int MfT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115845);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.MfO);
            aVar.aM(2, this.MfP);
            aVar.bb(3, this.MfQ);
            aVar.aM(4, this.MfR);
            aVar.bb(5, this.MfS);
            aVar.aM(6, this.MfT);
            AppMethodBeat.o(115845);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.MfO) + 0 + g.a.a.b.b.a.bu(2, this.MfP) + g.a.a.b.b.a.r(3, this.MfQ) + g.a.a.b.b.a.bu(4, this.MfR) + g.a.a.b.b.a.r(5, this.MfS) + g.a.a.b.b.a.bu(6, this.MfT);
            AppMethodBeat.o(115845);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115845);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            caq caq = (caq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    caq.MfO = aVar3.UbS.zl();
                    AppMethodBeat.o(115845);
                    return 0;
                case 2:
                    caq.MfP = aVar3.UbS.zi();
                    AppMethodBeat.o(115845);
                    return 0;
                case 3:
                    caq.MfQ = aVar3.UbS.zl();
                    AppMethodBeat.o(115845);
                    return 0;
                case 4:
                    caq.MfR = aVar3.UbS.zi();
                    AppMethodBeat.o(115845);
                    return 0;
                case 5:
                    caq.MfS = aVar3.UbS.zl();
                    AppMethodBeat.o(115845);
                    return 0;
                case 6:
                    caq.MfT = aVar3.UbS.zi();
                    AppMethodBeat.o(115845);
                    return 0;
                default:
                    AppMethodBeat.o(115845);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115845);
            return -1;
        }
    }
}
