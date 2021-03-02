package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctl extends a {
    public String KPz;
    public String LoI;
    public int Ltr;
    public int Mjk;
    public String Myn;
    public String UserName;
    public String oUJ;
    public int rBx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155445);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.rBx);
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.KPz != null) {
                aVar.e(3, this.KPz);
            }
            if (this.LoI != null) {
                aVar.e(4, this.LoI);
            }
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            aVar.aM(6, this.Mjk);
            aVar.aM(7, this.Ltr);
            if (this.Myn != null) {
                aVar.e(8, this.Myn);
            }
            AppMethodBeat.o(155445);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.rBx) + 0;
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.KPz != null) {
                bu += g.a.a.b.b.a.f(3, this.KPz);
            }
            if (this.LoI != null) {
                bu += g.a.a.b.b.a.f(4, this.LoI);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Mjk) + g.a.a.b.b.a.bu(7, this.Ltr);
            if (this.Myn != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Myn);
            }
            AppMethodBeat.o(155445);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155445);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctl ctl = (ctl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctl.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(155445);
                    return 0;
                case 2:
                    ctl.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155445);
                    return 0;
                case 3:
                    ctl.KPz = aVar3.UbS.readString();
                    AppMethodBeat.o(155445);
                    return 0;
                case 4:
                    ctl.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(155445);
                    return 0;
                case 5:
                    ctl.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155445);
                    return 0;
                case 6:
                    ctl.Mjk = aVar3.UbS.zi();
                    AppMethodBeat.o(155445);
                    return 0;
                case 7:
                    ctl.Ltr = aVar3.UbS.zi();
                    AppMethodBeat.o(155445);
                    return 0;
                case 8:
                    ctl.Myn = aVar3.UbS.readString();
                    AppMethodBeat.o(155445);
                    return 0;
                default:
                    AppMethodBeat.o(155445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155445);
            return -1;
        }
    }
}
