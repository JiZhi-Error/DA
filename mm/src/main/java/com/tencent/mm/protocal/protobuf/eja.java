package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class eja extends a {
    public b KYF;
    public int KYG;
    public int NiN;
    public int NiO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91718);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(7, this.NiN);
            if (this.KYF != null) {
                aVar.c(8, this.KYF);
            }
            aVar.aM(9, this.KYG);
            aVar.aM(10, this.NiO);
            AppMethodBeat.o(91718);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(7, this.NiN) + 0;
            if (this.KYF != null) {
                bu += g.a.a.b.b.a.b(8, this.KYF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.KYG) + g.a.a.b.b.a.bu(10, this.NiO);
            AppMethodBeat.o(91718);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91718);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eja eja = (eja) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    eja.NiN = aVar3.UbS.zi();
                    AppMethodBeat.o(91718);
                    return 0;
                case 8:
                    eja.KYF = aVar3.UbS.hPo();
                    AppMethodBeat.o(91718);
                    return 0;
                case 9:
                    eja.KYG = aVar3.UbS.zi();
                    AppMethodBeat.o(91718);
                    return 0;
                case 10:
                    eja.NiO = aVar3.UbS.zi();
                    AppMethodBeat.o(91718);
                    return 0;
                default:
                    AppMethodBeat.o(91718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91718);
            return -1;
        }
    }
}
