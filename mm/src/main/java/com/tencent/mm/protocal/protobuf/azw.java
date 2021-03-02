package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class azw extends a {
    public int LJN;
    public int LJO;
    public b LJP;
    public String riB;
    public long twp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209622);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.twp);
            if (this.riB != null) {
                aVar.e(2, this.riB);
            }
            aVar.aM(3, this.LJN);
            aVar.aM(4, this.LJO);
            if (this.LJP != null) {
                aVar.c(5, this.LJP);
            }
            AppMethodBeat.o(209622);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.twp) + 0;
            if (this.riB != null) {
                r += g.a.a.b.b.a.f(2, this.riB);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.LJN) + g.a.a.b.b.a.bu(4, this.LJO);
            if (this.LJP != null) {
                bu += g.a.a.b.b.a.b(5, this.LJP);
            }
            AppMethodBeat.o(209622);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209622);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azw azw = (azw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azw.twp = aVar3.UbS.zl();
                    AppMethodBeat.o(209622);
                    return 0;
                case 2:
                    azw.riB = aVar3.UbS.readString();
                    AppMethodBeat.o(209622);
                    return 0;
                case 3:
                    azw.LJN = aVar3.UbS.zi();
                    AppMethodBeat.o(209622);
                    return 0;
                case 4:
                    azw.LJO = aVar3.UbS.zi();
                    AppMethodBeat.o(209622);
                    return 0;
                case 5:
                    azw.LJP = aVar3.UbS.hPo();
                    AppMethodBeat.o(209622);
                    return 0;
                default:
                    AppMethodBeat.o(209622);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209622);
            return -1;
        }
    }
}
