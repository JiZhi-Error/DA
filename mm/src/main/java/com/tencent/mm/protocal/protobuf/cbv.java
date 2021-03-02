package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbv extends a {
    public String LWD;
    public String LjD;
    public long LpD;
    public int MhI;
    public long MhJ;
    public long MhK;
    public String icon;
    public int nHh;
    public String pTn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72504);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LjD != null) {
                aVar.e(1, this.LjD);
            }
            aVar.bb(2, this.LpD);
            aVar.aM(3, this.MhI);
            aVar.bb(4, this.MhJ);
            aVar.bb(5, this.MhK);
            if (this.LWD != null) {
                aVar.e(6, this.LWD);
            }
            if (this.pTn != null) {
                aVar.e(7, this.pTn);
            }
            aVar.aM(8, this.nHh);
            if (this.icon != null) {
                aVar.e(9, this.icon);
            }
            AppMethodBeat.o(72504);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LjD != null ? g.a.a.b.b.a.f(1, this.LjD) + 0 : 0) + g.a.a.b.b.a.r(2, this.LpD) + g.a.a.b.b.a.bu(3, this.MhI) + g.a.a.b.b.a.r(4, this.MhJ) + g.a.a.b.b.a.r(5, this.MhK);
            if (this.LWD != null) {
                f2 += g.a.a.b.b.a.f(6, this.LWD);
            }
            if (this.pTn != null) {
                f2 += g.a.a.b.b.a.f(7, this.pTn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.nHh);
            if (this.icon != null) {
                bu += g.a.a.b.b.a.f(9, this.icon);
            }
            AppMethodBeat.o(72504);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72504);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbv cbv = (cbv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbv.LjD = aVar3.UbS.readString();
                    AppMethodBeat.o(72504);
                    return 0;
                case 2:
                    cbv.LpD = aVar3.UbS.zl();
                    AppMethodBeat.o(72504);
                    return 0;
                case 3:
                    cbv.MhI = aVar3.UbS.zi();
                    AppMethodBeat.o(72504);
                    return 0;
                case 4:
                    cbv.MhJ = aVar3.UbS.zl();
                    AppMethodBeat.o(72504);
                    return 0;
                case 5:
                    cbv.MhK = aVar3.UbS.zl();
                    AppMethodBeat.o(72504);
                    return 0;
                case 6:
                    cbv.LWD = aVar3.UbS.readString();
                    AppMethodBeat.o(72504);
                    return 0;
                case 7:
                    cbv.pTn = aVar3.UbS.readString();
                    AppMethodBeat.o(72504);
                    return 0;
                case 8:
                    cbv.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(72504);
                    return 0;
                case 9:
                    cbv.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(72504);
                    return 0;
                default:
                    AppMethodBeat.o(72504);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72504);
            return -1;
        }
    }
}
