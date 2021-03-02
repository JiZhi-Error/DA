package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class civ extends a {
    public int Gaz;
    public boolean KNv;
    public int LIa;
    public int LXG;
    public boolean Lml;
    public String LpF;
    public int MnH;
    public String MnI;
    public LinkedList<String> MnJ = new LinkedList<>();
    public boolean MnK;
    public String MnL;
    public String MnM;
    public String MnN;
    public String MnO;
    public int MnP;
    public xf MnQ;
    public long hyH;
    public int pSb;
    public int status;

    public civ() {
        AppMethodBeat.i(207498);
        AppMethodBeat.o(207498);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207499);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hyH);
            if (this.LpF != null) {
                aVar.e(2, this.LpF);
            }
            aVar.aM(3, this.Gaz);
            aVar.aM(4, this.pSb);
            aVar.aM(5, this.status);
            aVar.aM(6, this.LIa);
            aVar.aM(7, this.MnH);
            aVar.aM(8, this.LXG);
            if (this.MnI != null) {
                aVar.e(9, this.MnI);
            }
            aVar.e(10, 1, this.MnJ);
            aVar.cc(11, this.KNv);
            aVar.cc(12, this.Lml);
            aVar.cc(13, this.MnK);
            if (this.MnL != null) {
                aVar.e(14, this.MnL);
            }
            if (this.MnM != null) {
                aVar.e(15, this.MnM);
            }
            if (this.MnN != null) {
                aVar.e(16, this.MnN);
            }
            if (this.MnO != null) {
                aVar.e(17, this.MnO);
            }
            aVar.aM(18, this.MnP);
            if (this.MnQ != null) {
                aVar.ni(19, this.MnQ.computeSize());
                this.MnQ.writeFields(aVar);
            }
            AppMethodBeat.o(207499);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hyH) + 0;
            if (this.LpF != null) {
                r += g.a.a.b.b.a.f(2, this.LpF);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.Gaz) + g.a.a.b.b.a.bu(4, this.pSb) + g.a.a.b.b.a.bu(5, this.status) + g.a.a.b.b.a.bu(6, this.LIa) + g.a.a.b.b.a.bu(7, this.MnH) + g.a.a.b.b.a.bu(8, this.LXG);
            if (this.MnI != null) {
                bu += g.a.a.b.b.a.f(9, this.MnI);
            }
            int c2 = bu + g.a.a.a.c(10, 1, this.MnJ) + g.a.a.b.b.a.fS(11) + 1 + g.a.a.b.b.a.fS(12) + 1 + g.a.a.b.b.a.fS(13) + 1;
            if (this.MnL != null) {
                c2 += g.a.a.b.b.a.f(14, this.MnL);
            }
            if (this.MnM != null) {
                c2 += g.a.a.b.b.a.f(15, this.MnM);
            }
            if (this.MnN != null) {
                c2 += g.a.a.b.b.a.f(16, this.MnN);
            }
            if (this.MnO != null) {
                c2 += g.a.a.b.b.a.f(17, this.MnO);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(18, this.MnP);
            if (this.MnQ != null) {
                bu2 += g.a.a.a.nh(19, this.MnQ.computeSize());
            }
            AppMethodBeat.o(207499);
            return bu2;
        } else if (i2 == 2) {
            this.MnJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207499);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            civ civ = (civ) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    civ.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(207499);
                    return 0;
                case 2:
                    civ.LpF = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 3:
                    civ.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 4:
                    civ.pSb = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 5:
                    civ.status = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 6:
                    civ.LIa = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 7:
                    civ.MnH = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 8:
                    civ.LXG = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 9:
                    civ.MnI = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 10:
                    civ.MnJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(207499);
                    return 0;
                case 11:
                    civ.KNv = aVar3.UbS.yZ();
                    AppMethodBeat.o(207499);
                    return 0;
                case 12:
                    civ.Lml = aVar3.UbS.yZ();
                    AppMethodBeat.o(207499);
                    return 0;
                case 13:
                    civ.MnK = aVar3.UbS.yZ();
                    AppMethodBeat.o(207499);
                    return 0;
                case 14:
                    civ.MnL = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 15:
                    civ.MnM = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 16:
                    civ.MnN = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 17:
                    civ.MnO = aVar3.UbS.readString();
                    AppMethodBeat.o(207499);
                    return 0;
                case 18:
                    civ.MnP = aVar3.UbS.zi();
                    AppMethodBeat.o(207499);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        xf xfVar = new xf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = xfVar.populateBuilderWithField(aVar4, xfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        civ.MnQ = xfVar;
                    }
                    AppMethodBeat.o(207499);
                    return 0;
                default:
                    AppMethodBeat.o(207499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207499);
            return -1;
        }
    }
}
