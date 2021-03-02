package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cjb extends a {
    public String MnL;
    public int Moj;
    public int Mok;
    public int Mol;
    public b Mom;
    public b Mon;
    public b Moo;
    public String Mop;
    public long Moq;
    public long Mor;
    public String Mos;
    public long hyH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196382);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Moj);
            if (this.MnL != null) {
                aVar.e(2, this.MnL);
            }
            aVar.aM(3, this.Mok);
            aVar.aM(4, this.Mol);
            if (this.Mom != null) {
                aVar.c(5, this.Mom);
            }
            if (this.Mon != null) {
                aVar.c(6, this.Mon);
            }
            if (this.Moo != null) {
                aVar.c(7, this.Moo);
            }
            if (this.Mop != null) {
                aVar.e(8, this.Mop);
            }
            aVar.bb(9, this.Moq);
            aVar.bb(10, this.Mor);
            aVar.bb(11, this.hyH);
            if (this.Mos != null) {
                aVar.e(12, this.Mos);
            }
            AppMethodBeat.o(196382);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Moj) + 0;
            if (this.MnL != null) {
                bu += g.a.a.b.b.a.f(2, this.MnL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Mok) + g.a.a.b.b.a.bu(4, this.Mol);
            if (this.Mom != null) {
                bu2 += g.a.a.b.b.a.b(5, this.Mom);
            }
            if (this.Mon != null) {
                bu2 += g.a.a.b.b.a.b(6, this.Mon);
            }
            if (this.Moo != null) {
                bu2 += g.a.a.b.b.a.b(7, this.Moo);
            }
            if (this.Mop != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Mop);
            }
            int r = bu2 + g.a.a.b.b.a.r(9, this.Moq) + g.a.a.b.b.a.r(10, this.Mor) + g.a.a.b.b.a.r(11, this.hyH);
            if (this.Mos != null) {
                r += g.a.a.b.b.a.f(12, this.Mos);
            }
            AppMethodBeat.o(196382);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196382);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjb cjb = (cjb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjb.Moj = aVar3.UbS.zi();
                    AppMethodBeat.o(196382);
                    return 0;
                case 2:
                    cjb.MnL = aVar3.UbS.readString();
                    AppMethodBeat.o(196382);
                    return 0;
                case 3:
                    cjb.Mok = aVar3.UbS.zi();
                    AppMethodBeat.o(196382);
                    return 0;
                case 4:
                    cjb.Mol = aVar3.UbS.zi();
                    AppMethodBeat.o(196382);
                    return 0;
                case 5:
                    cjb.Mom = aVar3.UbS.hPo();
                    AppMethodBeat.o(196382);
                    return 0;
                case 6:
                    cjb.Mon = aVar3.UbS.hPo();
                    AppMethodBeat.o(196382);
                    return 0;
                case 7:
                    cjb.Moo = aVar3.UbS.hPo();
                    AppMethodBeat.o(196382);
                    return 0;
                case 8:
                    cjb.Mop = aVar3.UbS.readString();
                    AppMethodBeat.o(196382);
                    return 0;
                case 9:
                    cjb.Moq = aVar3.UbS.zl();
                    AppMethodBeat.o(196382);
                    return 0;
                case 10:
                    cjb.Mor = aVar3.UbS.zl();
                    AppMethodBeat.o(196382);
                    return 0;
                case 11:
                    cjb.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(196382);
                    return 0;
                case 12:
                    cjb.Mos = aVar3.UbS.readString();
                    AppMethodBeat.o(196382);
                    return 0;
                default:
                    AppMethodBeat.o(196382);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196382);
            return -1;
        }
    }
}
