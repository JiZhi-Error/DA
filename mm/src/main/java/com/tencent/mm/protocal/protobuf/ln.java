package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ln extends a {
    public int DYl;
    public long KPe = 0;
    public long KPf = 0;
    public long KPg = 0;
    public long KPh = 0;
    public int KPi;
    public int dNP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110886);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KPe);
            aVar.bb(2, this.KPf);
            aVar.bb(3, this.KPg);
            aVar.bb(4, this.KPh);
            aVar.aM(5, this.DYl);
            aVar.aM(6, this.dNP);
            aVar.aM(7, this.KPi);
            AppMethodBeat.o(110886);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KPe) + 0 + g.a.a.b.b.a.r(2, this.KPf) + g.a.a.b.b.a.r(3, this.KPg) + g.a.a.b.b.a.r(4, this.KPh) + g.a.a.b.b.a.bu(5, this.DYl) + g.a.a.b.b.a.bu(6, this.dNP) + g.a.a.b.b.a.bu(7, this.KPi);
            AppMethodBeat.o(110886);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110886);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ln lnVar = (ln) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lnVar.KPe = aVar3.UbS.zl();
                    AppMethodBeat.o(110886);
                    return 0;
                case 2:
                    lnVar.KPf = aVar3.UbS.zl();
                    AppMethodBeat.o(110886);
                    return 0;
                case 3:
                    lnVar.KPg = aVar3.UbS.zl();
                    AppMethodBeat.o(110886);
                    return 0;
                case 4:
                    lnVar.KPh = aVar3.UbS.zl();
                    AppMethodBeat.o(110886);
                    return 0;
                case 5:
                    lnVar.DYl = aVar3.UbS.zi();
                    AppMethodBeat.o(110886);
                    return 0;
                case 6:
                    lnVar.dNP = aVar3.UbS.zi();
                    AppMethodBeat.o(110886);
                    return 0;
                case 7:
                    lnVar.KPi = aVar3.UbS.zi();
                    AppMethodBeat.o(110886);
                    return 0;
                default:
                    AppMethodBeat.o(110886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110886);
            return -1;
        }
    }
}
