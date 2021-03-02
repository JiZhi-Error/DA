package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class xa extends a {
    public String KFI;
    public int LhW;
    public String LhX;
    public int LhY;
    public String LhZ;
    public int Lia;
    public String Lib;
    public String Lic;
    public String Lid;
    public String Lie;
    public int Lif;
    public String Lig;
    public String qGA;
    public String qGB;
    public int qGt;
    public String qGu;
    public String qHn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125715);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LhW);
            if (this.qHn != null) {
                aVar.e(2, this.qHn);
            }
            if (this.LhX != null) {
                aVar.e(3, this.LhX);
            }
            if (this.qGA != null) {
                aVar.e(4, this.qGA);
            }
            aVar.aM(5, this.LhY);
            if (this.LhZ != null) {
                aVar.e(6, this.LhZ);
            }
            aVar.aM(7, this.Lia);
            if (this.qGB != null) {
                aVar.e(8, this.qGB);
            }
            if (this.KFI != null) {
                aVar.e(9, this.KFI);
            }
            aVar.aM(10, this.qGt);
            if (this.qGu != null) {
                aVar.e(11, this.qGu);
            }
            if (this.Lib != null) {
                aVar.e(12, this.Lib);
            }
            if (this.Lic != null) {
                aVar.e(13, this.Lic);
            }
            if (this.Lid != null) {
                aVar.e(14, this.Lid);
            }
            if (this.Lie != null) {
                aVar.e(15, this.Lie);
            }
            aVar.aM(16, this.Lif);
            if (this.Lig != null) {
                aVar.e(17, this.Lig);
            }
            AppMethodBeat.o(125715);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LhW) + 0;
            if (this.qHn != null) {
                bu += g.a.a.b.b.a.f(2, this.qHn);
            }
            if (this.LhX != null) {
                bu += g.a.a.b.b.a.f(3, this.LhX);
            }
            if (this.qGA != null) {
                bu += g.a.a.b.b.a.f(4, this.qGA);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LhY);
            if (this.LhZ != null) {
                bu2 += g.a.a.b.b.a.f(6, this.LhZ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.Lia);
            if (this.qGB != null) {
                bu3 += g.a.a.b.b.a.f(8, this.qGB);
            }
            if (this.KFI != null) {
                bu3 += g.a.a.b.b.a.f(9, this.KFI);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(10, this.qGt);
            if (this.qGu != null) {
                bu4 += g.a.a.b.b.a.f(11, this.qGu);
            }
            if (this.Lib != null) {
                bu4 += g.a.a.b.b.a.f(12, this.Lib);
            }
            if (this.Lic != null) {
                bu4 += g.a.a.b.b.a.f(13, this.Lic);
            }
            if (this.Lid != null) {
                bu4 += g.a.a.b.b.a.f(14, this.Lid);
            }
            if (this.Lie != null) {
                bu4 += g.a.a.b.b.a.f(15, this.Lie);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(16, this.Lif);
            if (this.Lig != null) {
                bu5 += g.a.a.b.b.a.f(17, this.Lig);
            }
            AppMethodBeat.o(125715);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125715);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xa xaVar = (xa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xaVar.LhW = aVar3.UbS.zi();
                    AppMethodBeat.o(125715);
                    return 0;
                case 2:
                    xaVar.qHn = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 3:
                    xaVar.LhX = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 4:
                    xaVar.qGA = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 5:
                    xaVar.LhY = aVar3.UbS.zi();
                    AppMethodBeat.o(125715);
                    return 0;
                case 6:
                    xaVar.LhZ = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 7:
                    xaVar.Lia = aVar3.UbS.zi();
                    AppMethodBeat.o(125715);
                    return 0;
                case 8:
                    xaVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 9:
                    xaVar.KFI = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 10:
                    xaVar.qGt = aVar3.UbS.zi();
                    AppMethodBeat.o(125715);
                    return 0;
                case 11:
                    xaVar.qGu = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 12:
                    xaVar.Lib = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 13:
                    xaVar.Lic = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 14:
                    xaVar.Lid = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 15:
                    xaVar.Lie = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                case 16:
                    xaVar.Lif = aVar3.UbS.zi();
                    AppMethodBeat.o(125715);
                    return 0;
                case 17:
                    xaVar.Lig = aVar3.UbS.readString();
                    AppMethodBeat.o(125715);
                    return 0;
                default:
                    AppMethodBeat.o(125715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125715);
            return -1;
        }
    }
}
