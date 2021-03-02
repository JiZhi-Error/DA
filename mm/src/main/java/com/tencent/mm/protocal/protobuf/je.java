package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class je extends a {
    public String HQc;
    public String KNH;
    public String KNI;
    public String KNJ;
    public boolean KNK;
    public String KNL;
    public String dDj;
    public String qcN;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72419);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ynT != null) {
                aVar.e(1, this.ynT);
            }
            if (this.dDj != null) {
                aVar.e(2, this.dDj);
            }
            if (this.qcN != null) {
                aVar.e(3, this.qcN);
            }
            if (this.HQc != null) {
                aVar.e(4, this.HQc);
            }
            if (this.KNH != null) {
                aVar.e(5, this.KNH);
            }
            if (this.KNI != null) {
                aVar.e(6, this.KNI);
            }
            if (this.KNJ != null) {
                aVar.e(8, this.KNJ);
            }
            aVar.cc(9, this.KNK);
            if (this.KNL != null) {
                aVar.e(10, this.KNL);
            }
            AppMethodBeat.o(72419);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ynT != null ? g.a.a.b.b.a.f(1, this.ynT) + 0 : 0;
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(2, this.dDj);
            }
            if (this.qcN != null) {
                f2 += g.a.a.b.b.a.f(3, this.qcN);
            }
            if (this.HQc != null) {
                f2 += g.a.a.b.b.a.f(4, this.HQc);
            }
            if (this.KNH != null) {
                f2 += g.a.a.b.b.a.f(5, this.KNH);
            }
            if (this.KNI != null) {
                f2 += g.a.a.b.b.a.f(6, this.KNI);
            }
            if (this.KNJ != null) {
                f2 += g.a.a.b.b.a.f(8, this.KNJ);
            }
            int fS = f2 + g.a.a.b.b.a.fS(9) + 1;
            if (this.KNL != null) {
                fS += g.a.a.b.b.a.f(10, this.KNL);
            }
            AppMethodBeat.o(72419);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72419);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            je jeVar = (je) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jeVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 2:
                    jeVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 3:
                    jeVar.qcN = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 4:
                    jeVar.HQc = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 5:
                    jeVar.KNH = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 6:
                    jeVar.KNI = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 7:
                default:
                    AppMethodBeat.o(72419);
                    return -1;
                case 8:
                    jeVar.KNJ = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
                case 9:
                    jeVar.KNK = aVar3.UbS.yZ();
                    AppMethodBeat.o(72419);
                    return 0;
                case 10:
                    jeVar.KNL = aVar3.UbS.readString();
                    AppMethodBeat.o(72419);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72419);
            return -1;
        }
    }
}
