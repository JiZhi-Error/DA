package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cih extends a {
    public String KPG;
    public String KPH;
    public String KPI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43103);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KPH != null) {
                aVar.e(1, this.KPH);
            }
            if (this.KPG != null) {
                aVar.e(2, this.KPG);
            }
            if (this.KPI != null) {
                aVar.e(3, this.KPI);
            }
            AppMethodBeat.o(43103);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KPH != null ? g.a.a.b.b.a.f(1, this.KPH) + 0 : 0;
            if (this.KPG != null) {
                f2 += g.a.a.b.b.a.f(2, this.KPG);
            }
            if (this.KPI != null) {
                f2 += g.a.a.b.b.a.f(3, this.KPI);
            }
            AppMethodBeat.o(43103);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43103);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cih cih = (cih) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cih.KPH = aVar3.UbS.readString();
                    AppMethodBeat.o(43103);
                    return 0;
                case 2:
                    cih.KPG = aVar3.UbS.readString();
                    AppMethodBeat.o(43103);
                    return 0;
                case 3:
                    cih.KPI = aVar3.UbS.readString();
                    AppMethodBeat.o(43103);
                    return 0;
                default:
                    AppMethodBeat.o(43103);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43103);
            return -1;
        }
    }
}
