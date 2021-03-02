package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class acu extends a {
    public String LnD;
    public String LnE;
    public String LnF;
    public String LnG;
    public int LnH;
    public String LnI;
    public int LnJ;
    public int LnK;
    public int LnL;
    public int LnM;
    public int LnN;
    public int LnO;
    public int LnP;
    public int LnQ;
    public int LnR;
    public int LnS;
    public int LnT;
    public int LnU;
    public String LnV;
    public String LnW;
    public String LnX;
    public String LnY;
    public String LnZ;
    public b Loa;
    public String Lob;
    public String Loc;
    public int Lod;
    public String app_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90960);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.app_id != null) {
                aVar.e(1, this.app_id);
            }
            if (this.LnD != null) {
                aVar.e(2, this.LnD);
            }
            if (this.LnE != null) {
                aVar.e(3, this.LnE);
            }
            if (this.LnF != null) {
                aVar.e(4, this.LnF);
            }
            if (this.LnG != null) {
                aVar.e(5, this.LnG);
            }
            aVar.aM(6, this.LnH);
            if (this.LnI != null) {
                aVar.e(7, this.LnI);
            }
            aVar.aM(8, this.LnJ);
            aVar.aM(9, this.LnK);
            aVar.aM(10, this.LnL);
            aVar.aM(11, this.LnM);
            aVar.aM(12, this.LnN);
            aVar.aM(13, this.LnO);
            aVar.aM(14, this.LnP);
            aVar.aM(15, this.LnQ);
            aVar.aM(16, this.LnR);
            aVar.aM(20, this.LnS);
            aVar.aM(21, this.LnT);
            aVar.aM(22, this.LnU);
            if (this.LnV != null) {
                aVar.e(25, this.LnV);
            }
            if (this.LnW != null) {
                aVar.e(26, this.LnW);
            }
            if (this.LnX != null) {
                aVar.e(27, this.LnX);
            }
            if (this.LnY != null) {
                aVar.e(28, this.LnY);
            }
            if (this.LnZ != null) {
                aVar.e(29, this.LnZ);
            }
            if (this.Loa != null) {
                aVar.c(30, this.Loa);
            }
            if (this.Lob != null) {
                aVar.e(31, this.Lob);
            }
            if (this.Loc != null) {
                aVar.e(32, this.Loc);
            }
            aVar.aM(33, this.Lod);
            AppMethodBeat.o(90960);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.app_id != null ? g.a.a.b.b.a.f(1, this.app_id) + 0 : 0;
            if (this.LnD != null) {
                f2 += g.a.a.b.b.a.f(2, this.LnD);
            }
            if (this.LnE != null) {
                f2 += g.a.a.b.b.a.f(3, this.LnE);
            }
            if (this.LnF != null) {
                f2 += g.a.a.b.b.a.f(4, this.LnF);
            }
            if (this.LnG != null) {
                f2 += g.a.a.b.b.a.f(5, this.LnG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.LnH);
            if (this.LnI != null) {
                bu += g.a.a.b.b.a.f(7, this.LnI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LnJ) + g.a.a.b.b.a.bu(9, this.LnK) + g.a.a.b.b.a.bu(10, this.LnL) + g.a.a.b.b.a.bu(11, this.LnM) + g.a.a.b.b.a.bu(12, this.LnN) + g.a.a.b.b.a.bu(13, this.LnO) + g.a.a.b.b.a.bu(14, this.LnP) + g.a.a.b.b.a.bu(15, this.LnQ) + g.a.a.b.b.a.bu(16, this.LnR) + g.a.a.b.b.a.bu(20, this.LnS) + g.a.a.b.b.a.bu(21, this.LnT) + g.a.a.b.b.a.bu(22, this.LnU);
            if (this.LnV != null) {
                bu2 += g.a.a.b.b.a.f(25, this.LnV);
            }
            if (this.LnW != null) {
                bu2 += g.a.a.b.b.a.f(26, this.LnW);
            }
            if (this.LnX != null) {
                bu2 += g.a.a.b.b.a.f(27, this.LnX);
            }
            if (this.LnY != null) {
                bu2 += g.a.a.b.b.a.f(28, this.LnY);
            }
            if (this.LnZ != null) {
                bu2 += g.a.a.b.b.a.f(29, this.LnZ);
            }
            if (this.Loa != null) {
                bu2 += g.a.a.b.b.a.b(30, this.Loa);
            }
            if (this.Lob != null) {
                bu2 += g.a.a.b.b.a.f(31, this.Lob);
            }
            if (this.Loc != null) {
                bu2 += g.a.a.b.b.a.f(32, this.Loc);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(33, this.Lod);
            AppMethodBeat.o(90960);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90960);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acu acu = (acu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acu.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 2:
                    acu.LnD = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 3:
                    acu.LnE = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 4:
                    acu.LnF = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 5:
                    acu.LnG = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 6:
                    acu.LnH = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 7:
                    acu.LnI = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 8:
                    acu.LnJ = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 9:
                    acu.LnK = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 10:
                    acu.LnL = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 11:
                    acu.LnM = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 12:
                    acu.LnN = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 13:
                    acu.LnO = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 14:
                    acu.LnP = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 15:
                    acu.LnQ = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 16:
                    acu.LnR = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 17:
                case 18:
                case 19:
                case 23:
                case 24:
                default:
                    AppMethodBeat.o(90960);
                    return -1;
                case 20:
                    acu.LnS = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 21:
                    acu.LnT = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 22:
                    acu.LnU = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
                case 25:
                    acu.LnV = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 26:
                    acu.LnW = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 27:
                    acu.LnX = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 28:
                    acu.LnY = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 29:
                    acu.LnZ = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 30:
                    acu.Loa = aVar3.UbS.hPo();
                    AppMethodBeat.o(90960);
                    return 0;
                case 31:
                    acu.Lob = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 32:
                    acu.Loc = aVar3.UbS.readString();
                    AppMethodBeat.o(90960);
                    return 0;
                case 33:
                    acu.Lod = aVar3.UbS.zi();
                    AppMethodBeat.o(90960);
                    return 0;
            }
        } else {
            AppMethodBeat.o(90960);
            return -1;
        }
    }
}
