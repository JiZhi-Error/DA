package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcn extends a {
    public float AAH;
    public String MHF;
    public String MHH;
    public String MHI;
    public String MHJ;
    public String MHK;
    public String MHL;
    public String MHM;
    public String MHN;
    public String MHO;
    public float MHP;
    public int MHQ;
    public String MHR;
    public LinkedList<String> MHS = new LinkedList<>();
    public String MHT;

    public dcn() {
        AppMethodBeat.i(209790);
        AppMethodBeat.o(209790);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209791);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MHH != null) {
                aVar.e(1, this.MHH);
            }
            aVar.E(2, this.AAH);
            if (this.MHI != null) {
                aVar.e(3, this.MHI);
            }
            if (this.MHJ != null) {
                aVar.e(4, this.MHJ);
            }
            if (this.MHF != null) {
                aVar.e(5, this.MHF);
            }
            if (this.MHK != null) {
                aVar.e(6, this.MHK);
            }
            if (this.MHL != null) {
                aVar.e(7, this.MHL);
            }
            if (this.MHM != null) {
                aVar.e(8, this.MHM);
            }
            if (this.MHN != null) {
                aVar.e(9, this.MHN);
            }
            if (this.MHO != null) {
                aVar.e(10, this.MHO);
            }
            aVar.E(11, this.MHP);
            aVar.aM(12, this.MHQ);
            if (this.MHR != null) {
                aVar.e(13, this.MHR);
            }
            aVar.e(14, 1, this.MHS);
            if (this.MHT != null) {
                aVar.e(101, this.MHT);
            }
            AppMethodBeat.o(209791);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MHH != null ? g.a.a.b.b.a.f(1, this.MHH) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4;
            if (this.MHI != null) {
                f2 += g.a.a.b.b.a.f(3, this.MHI);
            }
            if (this.MHJ != null) {
                f2 += g.a.a.b.b.a.f(4, this.MHJ);
            }
            if (this.MHF != null) {
                f2 += g.a.a.b.b.a.f(5, this.MHF);
            }
            if (this.MHK != null) {
                f2 += g.a.a.b.b.a.f(6, this.MHK);
            }
            if (this.MHL != null) {
                f2 += g.a.a.b.b.a.f(7, this.MHL);
            }
            if (this.MHM != null) {
                f2 += g.a.a.b.b.a.f(8, this.MHM);
            }
            if (this.MHN != null) {
                f2 += g.a.a.b.b.a.f(9, this.MHN);
            }
            if (this.MHO != null) {
                f2 += g.a.a.b.b.a.f(10, this.MHO);
            }
            int fS = f2 + g.a.a.b.b.a.fS(11) + 4 + g.a.a.b.b.a.bu(12, this.MHQ);
            if (this.MHR != null) {
                fS += g.a.a.b.b.a.f(13, this.MHR);
            }
            int c2 = fS + g.a.a.a.c(14, 1, this.MHS);
            if (this.MHT != null) {
                c2 += g.a.a.b.b.a.f(101, this.MHT);
            }
            AppMethodBeat.o(209791);
            return c2;
        } else if (i2 == 2) {
            this.MHS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209791);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcn dcn = (dcn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcn.MHH = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 2:
                    dcn.AAH = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209791);
                    return 0;
                case 3:
                    dcn.MHI = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 4:
                    dcn.MHJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 5:
                    dcn.MHF = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 6:
                    dcn.MHK = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 7:
                    dcn.MHL = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 8:
                    dcn.MHM = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 9:
                    dcn.MHN = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 10:
                    dcn.MHO = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 11:
                    dcn.MHP = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209791);
                    return 0;
                case 12:
                    dcn.MHQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209791);
                    return 0;
                case 13:
                    dcn.MHR = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                case 14:
                    dcn.MHS.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209791);
                    return 0;
                case 101:
                    dcn.MHT = aVar3.UbS.readString();
                    AppMethodBeat.o(209791);
                    return 0;
                default:
                    AppMethodBeat.o(209791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209791);
            return -1;
        }
    }
}
