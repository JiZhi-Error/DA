package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ab extends a {
    public int KCl;
    public String lHA;
    public String lHB;
    public String yXJ;
    public String yXK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91339);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KCl);
            if (this.yXJ != null) {
                aVar.e(2, this.yXJ);
            }
            if (this.lHA != null) {
                aVar.e(3, this.lHA);
            }
            if (this.lHB != null) {
                aVar.e(4, this.lHB);
            }
            if (this.yXK != null) {
                aVar.e(5, this.yXK);
            }
            AppMethodBeat.o(91339);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KCl) + 0;
            if (this.yXJ != null) {
                bu += g.a.a.b.b.a.f(2, this.yXJ);
            }
            if (this.lHA != null) {
                bu += g.a.a.b.b.a.f(3, this.lHA);
            }
            if (this.lHB != null) {
                bu += g.a.a.b.b.a.f(4, this.lHB);
            }
            if (this.yXK != null) {
                bu += g.a.a.b.b.a.f(5, this.yXK);
            }
            AppMethodBeat.o(91339);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91339);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.KCl = aVar3.UbS.zi();
                    AppMethodBeat.o(91339);
                    return 0;
                case 2:
                    abVar.yXJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91339);
                    return 0;
                case 3:
                    abVar.lHA = aVar3.UbS.readString();
                    AppMethodBeat.o(91339);
                    return 0;
                case 4:
                    abVar.lHB = aVar3.UbS.readString();
                    AppMethodBeat.o(91339);
                    return 0;
                case 5:
                    abVar.yXK = aVar3.UbS.readString();
                    AppMethodBeat.o(91339);
                    return 0;
                default:
                    AppMethodBeat.o(91339);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91339);
            return -1;
        }
    }
}