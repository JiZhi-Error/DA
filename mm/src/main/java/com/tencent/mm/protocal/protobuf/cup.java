package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cup extends a {
    public String KUC;
    public int MzQ;
    public int MzR;
    public String MzS;
    public int MzT;
    public int MzU;
    public long MzV;
    public String iwv;
    public int type;
    public int xHb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KUC != null) {
                aVar.e(1, this.KUC);
            }
            aVar.aM(2, this.MzQ);
            aVar.aM(3, this.xHb);
            aVar.aM(4, this.MzR);
            aVar.aM(5, this.type);
            if (this.iwv != null) {
                aVar.e(6, this.iwv);
            }
            if (this.MzS != null) {
                aVar.e(7, this.MzS);
            }
            aVar.aM(8, this.MzT);
            aVar.aM(9, this.MzU);
            aVar.bb(10, this.MzV);
            AppMethodBeat.o(6412);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KUC != null ? g.a.a.b.b.a.f(1, this.KUC) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MzQ) + g.a.a.b.b.a.bu(3, this.xHb) + g.a.a.b.b.a.bu(4, this.MzR) + g.a.a.b.b.a.bu(5, this.type);
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(6, this.iwv);
            }
            if (this.MzS != null) {
                f2 += g.a.a.b.b.a.f(7, this.MzS);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.MzT) + g.a.a.b.b.a.bu(9, this.MzU) + g.a.a.b.b.a.r(10, this.MzV);
            AppMethodBeat.o(6412);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cup cup = (cup) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cup.KUC = aVar3.UbS.readString();
                    AppMethodBeat.o(6412);
                    return 0;
                case 2:
                    cup.MzQ = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 3:
                    cup.xHb = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 4:
                    cup.MzR = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 5:
                    cup.type = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 6:
                    cup.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(6412);
                    return 0;
                case 7:
                    cup.MzS = aVar3.UbS.readString();
                    AppMethodBeat.o(6412);
                    return 0;
                case 8:
                    cup.MzT = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 9:
                    cup.MzU = aVar3.UbS.zi();
                    AppMethodBeat.o(6412);
                    return 0;
                case 10:
                    cup.MzV = aVar3.UbS.zl();
                    AppMethodBeat.o(6412);
                    return 0;
                default:
                    AppMethodBeat.o(6412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6412);
            return -1;
        }
    }
}
