package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eim extends a {
    public int KJS;
    public String MEq;
    public String MRt;
    public String Mba;
    public String Mbb;
    public String NhH;
    public int Scene;
    public int him;
    public String iAc;
    public String pLq;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117936);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEq != null) {
                aVar.e(1, this.MEq);
            }
            if (this.NhH != null) {
                aVar.e(2, this.NhH);
            }
            aVar.aM(3, this.him);
            if (this.Mba != null) {
                aVar.e(4, this.Mba);
            }
            if (this.iAc != null) {
                aVar.e(5, this.iAc);
            }
            aVar.aM(6, this.Scene);
            if (this.Mbb != null) {
                aVar.e(7, this.Mbb);
            }
            aVar.aM(8, this.KJS);
            if (this.pLq != null) {
                aVar.e(9, this.pLq);
            }
            if (this.MRt != null) {
                aVar.e(10, this.MRt);
            }
            aVar.aM(11, this.xub);
            AppMethodBeat.o(117936);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MEq != null ? g.a.a.b.b.a.f(1, this.MEq) + 0 : 0;
            if (this.NhH != null) {
                f2 += g.a.a.b.b.a.f(2, this.NhH);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.him);
            if (this.Mba != null) {
                bu += g.a.a.b.b.a.f(4, this.Mba);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(5, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Scene);
            if (this.Mbb != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Mbb);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.KJS);
            if (this.pLq != null) {
                bu3 += g.a.a.b.b.a.f(9, this.pLq);
            }
            if (this.MRt != null) {
                bu3 += g.a.a.b.b.a.f(10, this.MRt);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.xub);
            AppMethodBeat.o(117936);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117936);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eim eim = (eim) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eim.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 2:
                    eim.NhH = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 3:
                    eim.him = aVar3.UbS.zi();
                    AppMethodBeat.o(117936);
                    return 0;
                case 4:
                    eim.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 5:
                    eim.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 6:
                    eim.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117936);
                    return 0;
                case 7:
                    eim.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 8:
                    eim.KJS = aVar3.UbS.zi();
                    AppMethodBeat.o(117936);
                    return 0;
                case 9:
                    eim.pLq = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 10:
                    eim.MRt = aVar3.UbS.readString();
                    AppMethodBeat.o(117936);
                    return 0;
                case 11:
                    eim.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(117936);
                    return 0;
                default:
                    AppMethodBeat.o(117936);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117936);
            return -1;
        }
    }
}
