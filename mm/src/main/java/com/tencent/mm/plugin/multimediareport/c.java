package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class c extends a {
    public int type;
    public int zGB;
    public int zGC;
    public long zGD;
    public long zGE;
    public double zGF;
    public String zGG;
    public b zGH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194273);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            aVar.aM(2, this.zGB);
            aVar.aM(3, this.zGC);
            aVar.bb(4, this.zGD);
            aVar.bb(5, this.zGE);
            aVar.e(6, this.zGF);
            if (this.zGG != null) {
                aVar.e(7, this.zGG);
            }
            if (this.zGH != null) {
                aVar.c(8, this.zGH);
            }
            AppMethodBeat.o(194273);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.zGB) + g.a.a.b.b.a.bu(3, this.zGC) + g.a.a.b.b.a.r(4, this.zGD) + g.a.a.b.b.a.r(5, this.zGE) + g.a.a.b.b.a.fS(6) + 8;
            if (this.zGG != null) {
                bu += g.a.a.b.b.a.f(7, this.zGG);
            }
            if (this.zGH != null) {
                bu += g.a.a.b.b.a.b(8, this.zGH);
            }
            AppMethodBeat.o(194273);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194273);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(194273);
                    return 0;
                case 2:
                    cVar.zGB = aVar3.UbS.zi();
                    AppMethodBeat.o(194273);
                    return 0;
                case 3:
                    cVar.zGC = aVar3.UbS.zi();
                    AppMethodBeat.o(194273);
                    return 0;
                case 4:
                    cVar.zGD = aVar3.UbS.zl();
                    AppMethodBeat.o(194273);
                    return 0;
                case 5:
                    cVar.zGE = aVar3.UbS.zl();
                    AppMethodBeat.o(194273);
                    return 0;
                case 6:
                    cVar.zGF = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(194273);
                    return 0;
                case 7:
                    cVar.zGG = aVar3.UbS.readString();
                    AppMethodBeat.o(194273);
                    return 0;
                case 8:
                    cVar.zGH = aVar3.UbS.hPo();
                    AppMethodBeat.o(194273);
                    return 0;
                default:
                    AppMethodBeat.o(194273);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194273);
            return -1;
        }
    }
}
