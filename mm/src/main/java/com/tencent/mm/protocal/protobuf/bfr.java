package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfr extends a {
    public int KCz;
    public String KGX;
    public String KPJ;
    public String LPm;
    public String LPn;
    public String LPo;
    public String Lkr;
    public String UserName;
    public String oUJ;
    public String xJE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32218);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KGX != null) {
                aVar.e(1, this.KGX);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            if (this.xJE != null) {
                aVar.e(4, this.xJE);
            }
            if (this.LPm != null) {
                aVar.e(5, this.LPm);
            }
            if (this.LPn != null) {
                aVar.e(6, this.LPn);
            }
            if (this.KPJ != null) {
                aVar.e(7, this.KPJ);
            }
            if (this.Lkr != null) {
                aVar.e(8, this.Lkr);
            }
            if (this.LPo != null) {
                aVar.e(9, this.LPo);
            }
            aVar.aM(10, this.KCz);
            AppMethodBeat.o(32218);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KGX != null ? g.a.a.b.b.a.f(1, this.KGX) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(3, this.UserName);
            }
            if (this.xJE != null) {
                f2 += g.a.a.b.b.a.f(4, this.xJE);
            }
            if (this.LPm != null) {
                f2 += g.a.a.b.b.a.f(5, this.LPm);
            }
            if (this.LPn != null) {
                f2 += g.a.a.b.b.a.f(6, this.LPn);
            }
            if (this.KPJ != null) {
                f2 += g.a.a.b.b.a.f(7, this.KPJ);
            }
            if (this.Lkr != null) {
                f2 += g.a.a.b.b.a.f(8, this.Lkr);
            }
            if (this.LPo != null) {
                f2 += g.a.a.b.b.a.f(9, this.LPo);
            }
            int bu = f2 + g.a.a.b.b.a.bu(10, this.KCz);
            AppMethodBeat.o(32218);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32218);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfr bfr = (bfr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfr.KGX = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 2:
                    bfr.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 3:
                    bfr.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 4:
                    bfr.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 5:
                    bfr.LPm = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 6:
                    bfr.LPn = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 7:
                    bfr.KPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 8:
                    bfr.Lkr = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 9:
                    bfr.LPo = aVar3.UbS.readString();
                    AppMethodBeat.o(32218);
                    return 0;
                case 10:
                    bfr.KCz = aVar3.UbS.zi();
                    AppMethodBeat.o(32218);
                    return 0;
                default:
                    AppMethodBeat.o(32218);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32218);
            return -1;
        }
    }
}
