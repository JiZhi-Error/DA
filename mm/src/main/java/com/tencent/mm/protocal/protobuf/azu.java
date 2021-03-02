package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class azu extends a {
    public String LJA;
    public String LJB;
    public String LJC;
    public String LJD;
    public String LJE;
    public String LJF;
    public String LJG;
    public String LJH;
    public String LJI;
    public String LJJ;
    public String LJK;
    public String LJL;
    public String LJy;
    public String LJz;
    public int objectType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209619);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.objectType);
            if (this.LJy != null) {
                aVar.e(2, this.LJy);
            }
            if (this.LJz != null) {
                aVar.e(3, this.LJz);
            }
            if (this.LJA != null) {
                aVar.e(4, this.LJA);
            }
            if (this.LJB != null) {
                aVar.e(5, this.LJB);
            }
            if (this.LJC != null) {
                aVar.e(6, this.LJC);
            }
            if (this.LJD != null) {
                aVar.e(7, this.LJD);
            }
            if (this.LJE != null) {
                aVar.e(8, this.LJE);
            }
            if (this.LJF != null) {
                aVar.e(9, this.LJF);
            }
            if (this.LJG != null) {
                aVar.e(10, this.LJG);
            }
            if (this.LJH != null) {
                aVar.e(11, this.LJH);
            }
            if (this.LJI != null) {
                aVar.e(12, this.LJI);
            }
            if (this.LJJ != null) {
                aVar.e(13, this.LJJ);
            }
            if (this.LJK != null) {
                aVar.e(14, this.LJK);
            }
            if (this.LJL != null) {
                aVar.e(15, this.LJL);
            }
            AppMethodBeat.o(209619);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.objectType) + 0;
            if (this.LJy != null) {
                bu += g.a.a.b.b.a.f(2, this.LJy);
            }
            if (this.LJz != null) {
                bu += g.a.a.b.b.a.f(3, this.LJz);
            }
            if (this.LJA != null) {
                bu += g.a.a.b.b.a.f(4, this.LJA);
            }
            if (this.LJB != null) {
                bu += g.a.a.b.b.a.f(5, this.LJB);
            }
            if (this.LJC != null) {
                bu += g.a.a.b.b.a.f(6, this.LJC);
            }
            if (this.LJD != null) {
                bu += g.a.a.b.b.a.f(7, this.LJD);
            }
            if (this.LJE != null) {
                bu += g.a.a.b.b.a.f(8, this.LJE);
            }
            if (this.LJF != null) {
                bu += g.a.a.b.b.a.f(9, this.LJF);
            }
            if (this.LJG != null) {
                bu += g.a.a.b.b.a.f(10, this.LJG);
            }
            if (this.LJH != null) {
                bu += g.a.a.b.b.a.f(11, this.LJH);
            }
            if (this.LJI != null) {
                bu += g.a.a.b.b.a.f(12, this.LJI);
            }
            if (this.LJJ != null) {
                bu += g.a.a.b.b.a.f(13, this.LJJ);
            }
            if (this.LJK != null) {
                bu += g.a.a.b.b.a.f(14, this.LJK);
            }
            if (this.LJL != null) {
                bu += g.a.a.b.b.a.f(15, this.LJL);
            }
            AppMethodBeat.o(209619);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209619);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azu azu = (azu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azu.objectType = aVar3.UbS.zi();
                    AppMethodBeat.o(209619);
                    return 0;
                case 2:
                    azu.LJy = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 3:
                    azu.LJz = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 4:
                    azu.LJA = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 5:
                    azu.LJB = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 6:
                    azu.LJC = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 7:
                    azu.LJD = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 8:
                    azu.LJE = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 9:
                    azu.LJF = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 10:
                    azu.LJG = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 11:
                    azu.LJH = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 12:
                    azu.LJI = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 13:
                    azu.LJJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 14:
                    azu.LJK = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                case 15:
                    azu.LJL = aVar3.UbS.readString();
                    AppMethodBeat.o(209619);
                    return 0;
                default:
                    AppMethodBeat.o(209619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209619);
            return -1;
        }
    }
}
