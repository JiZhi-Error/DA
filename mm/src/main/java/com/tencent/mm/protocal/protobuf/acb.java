package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acb extends a {
    public int Brl;
    public int KTf;
    public int LmE;
    public int oTW;
    public int xKb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124478);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Brl);
            aVar.aM(2, this.xKb);
            aVar.aM(3, this.LmE);
            aVar.aM(4, this.oTW);
            aVar.aM(5, this.KTf);
            AppMethodBeat.o(124478);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brl) + 0 + g.a.a.b.b.a.bu(2, this.xKb) + g.a.a.b.b.a.bu(3, this.LmE) + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.KTf);
            AppMethodBeat.o(124478);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124478);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acb acb = (acb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acb.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(124478);
                    return 0;
                case 2:
                    acb.xKb = aVar3.UbS.zi();
                    AppMethodBeat.o(124478);
                    return 0;
                case 3:
                    acb.LmE = aVar3.UbS.zi();
                    AppMethodBeat.o(124478);
                    return 0;
                case 4:
                    acb.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(124478);
                    return 0;
                case 5:
                    acb.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(124478);
                    return 0;
                default:
                    AppMethodBeat.o(124478);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124478);
            return -1;
        }
    }
}
