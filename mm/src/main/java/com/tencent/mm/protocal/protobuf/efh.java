package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class efh extends a {
    public String NfC;
    public String NfD;
    public String jyH;
    public String jyI;
    public String jyJ;
    public String jyK;
    public String jyL;
    public String jyM;
    public String jyN;
    public String jyO;
    public String jyP;
    public String jyQ;
    public String jyR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152710);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jyH != null) {
                aVar.e(1, this.jyH);
            }
            if (this.jyI != null) {
                aVar.e(2, this.jyI);
            }
            if (this.jyJ != null) {
                aVar.e(3, this.jyJ);
            }
            if (this.jyK != null) {
                aVar.e(4, this.jyK);
            }
            if (this.jyL != null) {
                aVar.e(5, this.jyL);
            }
            if (this.jyM != null) {
                aVar.e(6, this.jyM);
            }
            if (this.jyN != null) {
                aVar.e(7, this.jyN);
            }
            if (this.jyO != null) {
                aVar.e(8, this.jyO);
            }
            if (this.jyP != null) {
                aVar.e(9, this.jyP);
            }
            if (this.jyQ != null) {
                aVar.e(10, this.jyQ);
            }
            if (this.jyR != null) {
                aVar.e(11, this.jyR);
            }
            if (this.NfC != null) {
                aVar.e(12, this.NfC);
            }
            if (this.NfD != null) {
                aVar.e(13, this.NfD);
            }
            AppMethodBeat.o(152710);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jyH != null ? g.a.a.b.b.a.f(1, this.jyH) + 0 : 0;
            if (this.jyI != null) {
                f2 += g.a.a.b.b.a.f(2, this.jyI);
            }
            if (this.jyJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.jyJ);
            }
            if (this.jyK != null) {
                f2 += g.a.a.b.b.a.f(4, this.jyK);
            }
            if (this.jyL != null) {
                f2 += g.a.a.b.b.a.f(5, this.jyL);
            }
            if (this.jyM != null) {
                f2 += g.a.a.b.b.a.f(6, this.jyM);
            }
            if (this.jyN != null) {
                f2 += g.a.a.b.b.a.f(7, this.jyN);
            }
            if (this.jyO != null) {
                f2 += g.a.a.b.b.a.f(8, this.jyO);
            }
            if (this.jyP != null) {
                f2 += g.a.a.b.b.a.f(9, this.jyP);
            }
            if (this.jyQ != null) {
                f2 += g.a.a.b.b.a.f(10, this.jyQ);
            }
            if (this.jyR != null) {
                f2 += g.a.a.b.b.a.f(11, this.jyR);
            }
            if (this.NfC != null) {
                f2 += g.a.a.b.b.a.f(12, this.NfC);
            }
            if (this.NfD != null) {
                f2 += g.a.a.b.b.a.f(13, this.NfD);
            }
            AppMethodBeat.o(152710);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152710);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efh efh = (efh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    efh.jyH = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 2:
                    efh.jyI = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 3:
                    efh.jyJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 4:
                    efh.jyK = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 5:
                    efh.jyL = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 6:
                    efh.jyM = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 7:
                    efh.jyN = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 8:
                    efh.jyO = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 9:
                    efh.jyP = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 10:
                    efh.jyQ = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 11:
                    efh.jyR = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 12:
                    efh.NfC = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                case 13:
                    efh.NfD = aVar3.UbS.readString();
                    AppMethodBeat.o(152710);
                    return 0;
                default:
                    AppMethodBeat.o(152710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152710);
            return -1;
        }
    }
}
