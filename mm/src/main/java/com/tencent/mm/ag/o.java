package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class o extends a {
    public int izU;
    public int izV;
    public String izW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116410);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.izU);
            aVar.aM(2, this.izV);
            if (this.izW != null) {
                aVar.e(3, this.izW);
            }
            AppMethodBeat.o(116410);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.izU) + 0 + g.a.a.b.b.a.bu(2, this.izV);
            if (this.izW != null) {
                bu += g.a.a.b.b.a.f(3, this.izW);
            }
            AppMethodBeat.o(116410);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116410);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.izU = aVar3.UbS.zi();
                    AppMethodBeat.o(116410);
                    return 0;
                case 2:
                    oVar.izV = aVar3.UbS.zi();
                    AppMethodBeat.o(116410);
                    return 0;
                case 3:
                    oVar.izW = aVar3.UbS.readString();
                    AppMethodBeat.o(116410);
                    return 0;
                default:
                    AppMethodBeat.o(116410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116410);
            return -1;
        }
    }
}