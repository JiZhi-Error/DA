package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvr extends a {
    public int LGU;
    public String MBe;
    public String MBf;
    public int MBg;
    public String MBh;
    public String MBi;
    public String MBj;
    public int MBk;
    public int MBl;
    public long MBm;
    public String buA;
    public String dST;
    public String pWh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.buA != null) {
                aVar.e(1, this.buA);
            }
            if (this.MBe != null) {
                aVar.e(2, this.MBe);
            }
            if (this.MBf != null) {
                aVar.e(3, this.MBf);
            }
            aVar.aM(4, this.MBg);
            if (this.dST != null) {
                aVar.e(5, this.dST);
            }
            if (this.MBh != null) {
                aVar.e(6, this.MBh);
            }
            if (this.MBi != null) {
                aVar.e(7, this.MBi);
            }
            if (this.pWh != null) {
                aVar.e(8, this.pWh);
            }
            if (this.MBj != null) {
                aVar.e(9, this.MBj);
            }
            aVar.aM(10, this.MBk);
            aVar.aM(11, this.MBl);
            aVar.aM(12, this.LGU);
            aVar.bb(13, this.MBm);
            AppMethodBeat.o(152632);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.buA != null ? g.a.a.b.b.a.f(1, this.buA) + 0 : 0;
            if (this.MBe != null) {
                f2 += g.a.a.b.b.a.f(2, this.MBe);
            }
            if (this.MBf != null) {
                f2 += g.a.a.b.b.a.f(3, this.MBf);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MBg);
            if (this.dST != null) {
                bu += g.a.a.b.b.a.f(5, this.dST);
            }
            if (this.MBh != null) {
                bu += g.a.a.b.b.a.f(6, this.MBh);
            }
            if (this.MBi != null) {
                bu += g.a.a.b.b.a.f(7, this.MBi);
            }
            if (this.pWh != null) {
                bu += g.a.a.b.b.a.f(8, this.pWh);
            }
            if (this.MBj != null) {
                bu += g.a.a.b.b.a.f(9, this.MBj);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.MBk) + g.a.a.b.b.a.bu(11, this.MBl) + g.a.a.b.b.a.bu(12, this.LGU) + g.a.a.b.b.a.r(13, this.MBm);
            AppMethodBeat.o(152632);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152632);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvr cvr = (cvr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvr.buA = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 2:
                    cvr.MBe = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 3:
                    cvr.MBf = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 4:
                    cvr.MBg = aVar3.UbS.zi();
                    AppMethodBeat.o(152632);
                    return 0;
                case 5:
                    cvr.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 6:
                    cvr.MBh = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 7:
                    cvr.MBi = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 8:
                    cvr.pWh = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 9:
                    cvr.MBj = aVar3.UbS.readString();
                    AppMethodBeat.o(152632);
                    return 0;
                case 10:
                    cvr.MBk = aVar3.UbS.zi();
                    AppMethodBeat.o(152632);
                    return 0;
                case 11:
                    cvr.MBl = aVar3.UbS.zi();
                    AppMethodBeat.o(152632);
                    return 0;
                case 12:
                    cvr.LGU = aVar3.UbS.zi();
                    AppMethodBeat.o(152632);
                    return 0;
                case 13:
                    cvr.MBm = aVar3.UbS.zl();
                    AppMethodBeat.o(152632);
                    return 0;
                default:
                    AppMethodBeat.o(152632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152632);
            return -1;
        }
    }
}
