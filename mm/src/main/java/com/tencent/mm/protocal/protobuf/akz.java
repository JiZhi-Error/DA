package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class akz extends a {
    public int LtB;
    public String LtC;
    public String LtD;
    public String LtP;
    public String LtQ;
    public int LtR;
    public int LtS;
    public String LtT;
    public String LtU;
    public String LtV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32206);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LtB);
            if (this.LtC != null) {
                aVar.e(2, this.LtC);
            }
            if (this.LtP != null) {
                aVar.e(3, this.LtP);
            }
            if (this.LtQ != null) {
                aVar.e(4, this.LtQ);
            }
            aVar.aM(5, this.LtR);
            aVar.aM(6, this.LtS);
            if (this.LtT != null) {
                aVar.e(7, this.LtT);
            }
            if (this.LtD != null) {
                aVar.e(8, this.LtD);
            }
            if (this.LtU != null) {
                aVar.e(9, this.LtU);
            }
            if (this.LtV != null) {
                aVar.e(10, this.LtV);
            }
            AppMethodBeat.o(32206);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LtB) + 0;
            if (this.LtC != null) {
                bu += g.a.a.b.b.a.f(2, this.LtC);
            }
            if (this.LtP != null) {
                bu += g.a.a.b.b.a.f(3, this.LtP);
            }
            if (this.LtQ != null) {
                bu += g.a.a.b.b.a.f(4, this.LtQ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LtR) + g.a.a.b.b.a.bu(6, this.LtS);
            if (this.LtT != null) {
                bu2 += g.a.a.b.b.a.f(7, this.LtT);
            }
            if (this.LtD != null) {
                bu2 += g.a.a.b.b.a.f(8, this.LtD);
            }
            if (this.LtU != null) {
                bu2 += g.a.a.b.b.a.f(9, this.LtU);
            }
            if (this.LtV != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LtV);
            }
            AppMethodBeat.o(32206);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32206);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akz akz = (akz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akz.LtB = aVar3.UbS.zi();
                    AppMethodBeat.o(32206);
                    return 0;
                case 2:
                    akz.LtC = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 3:
                    akz.LtP = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 4:
                    akz.LtQ = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 5:
                    akz.LtR = aVar3.UbS.zi();
                    AppMethodBeat.o(32206);
                    return 0;
                case 6:
                    akz.LtS = aVar3.UbS.zi();
                    AppMethodBeat.o(32206);
                    return 0;
                case 7:
                    akz.LtT = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 8:
                    akz.LtD = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 9:
                    akz.LtU = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                case 10:
                    akz.LtV = aVar3.UbS.readString();
                    AppMethodBeat.o(32206);
                    return 0;
                default:
                    AppMethodBeat.o(32206);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32206);
            return -1;
        }
    }
}
