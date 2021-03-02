package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ajr extends a {
    public int Cjg;
    public String Cjh;
    public String Cji;
    public int Cjj;
    public String ixw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72474);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Cjg);
            if (this.Cjh != null) {
                aVar.e(2, this.Cjh);
            }
            if (this.Cji != null) {
                aVar.e(3, this.Cji);
            }
            aVar.aM(4, this.Cjj);
            if (this.ixw != null) {
                aVar.e(5, this.ixw);
            }
            AppMethodBeat.o(72474);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Cjg) + 0;
            if (this.Cjh != null) {
                bu += g.a.a.b.b.a.f(2, this.Cjh);
            }
            if (this.Cji != null) {
                bu += g.a.a.b.b.a.f(3, this.Cji);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Cjj);
            if (this.ixw != null) {
                bu2 += g.a.a.b.b.a.f(5, this.ixw);
            }
            AppMethodBeat.o(72474);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72474);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajr ajr = (ajr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajr.Cjg = aVar3.UbS.zi();
                    AppMethodBeat.o(72474);
                    return 0;
                case 2:
                    ajr.Cjh = aVar3.UbS.readString();
                    AppMethodBeat.o(72474);
                    return 0;
                case 3:
                    ajr.Cji = aVar3.UbS.readString();
                    AppMethodBeat.o(72474);
                    return 0;
                case 4:
                    ajr.Cjj = aVar3.UbS.zi();
                    AppMethodBeat.o(72474);
                    return 0;
                case 5:
                    ajr.ixw = aVar3.UbS.readString();
                    AppMethodBeat.o(72474);
                    return 0;
                default:
                    AppMethodBeat.o(72474);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72474);
            return -1;
        }
    }
}
