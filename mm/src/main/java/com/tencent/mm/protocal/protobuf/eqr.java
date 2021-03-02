package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eqr extends a {
    public String KUC;
    public String Mzk;
    public int Mzl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176156);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mzl);
            if (this.KUC != null) {
                aVar.e(2, this.KUC);
            }
            if (this.Mzk != null) {
                aVar.e(3, this.Mzk);
            }
            AppMethodBeat.o(176156);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mzl) + 0;
            if (this.KUC != null) {
                bu += g.a.a.b.b.a.f(2, this.KUC);
            }
            if (this.Mzk != null) {
                bu += g.a.a.b.b.a.f(3, this.Mzk);
            }
            AppMethodBeat.o(176156);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176156);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqr eqr = (eqr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqr.Mzl = aVar3.UbS.zi();
                    AppMethodBeat.o(176156);
                    return 0;
                case 2:
                    eqr.KUC = aVar3.UbS.readString();
                    AppMethodBeat.o(176156);
                    return 0;
                case 3:
                    eqr.Mzk = aVar3.UbS.readString();
                    AppMethodBeat.o(176156);
                    return 0;
                default:
                    AppMethodBeat.o(176156);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176156);
            return -1;
        }
    }
}
