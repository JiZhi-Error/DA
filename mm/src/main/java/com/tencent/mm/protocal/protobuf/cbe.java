package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbe extends a {
    public int KTQ;
    public String Lot;
    public long Mbx;
    public String MgB;
    public cbf MgC;
    public String MgD;
    public int MgE;
    public int MgF;
    public long MgG;
    public String MgH;
    public String MgI;
    public int MgJ;
    public String MgK;
    public String MgL;
    public String MgM;
    public String MgN;
    public String MgO;
    public int MgP;
    public String MgQ;
    public String MgR;
    public String MgS;
    public int dfT;
    public int iwy;
    public int subType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91520);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MgB != null) {
                aVar.e(1, this.MgB);
            }
            aVar.aM(2, this.subType);
            if (this.Lot != null) {
                aVar.e(3, this.Lot);
            }
            if (this.MgC != null) {
                aVar.ni(4, this.MgC.computeSize());
                this.MgC.writeFields(aVar);
            }
            if (this.MgD != null) {
                aVar.e(5, this.MgD);
            }
            aVar.aM(6, this.MgE);
            aVar.aM(7, this.MgF);
            aVar.bb(8, this.MgG);
            aVar.aM(9, this.iwy);
            aVar.aM(10, this.KTQ);
            if (this.MgH != null) {
                aVar.e(11, this.MgH);
            }
            if (this.MgI != null) {
                aVar.e(12, this.MgI);
            }
            aVar.aM(13, this.MgJ);
            if (this.MgK != null) {
                aVar.e(14, this.MgK);
            }
            if (this.MgL != null) {
                aVar.e(15, this.MgL);
            }
            if (this.MgM != null) {
                aVar.e(16, this.MgM);
            }
            if (this.MgN != null) {
                aVar.e(17, this.MgN);
            }
            if (this.MgO != null) {
                aVar.e(18, this.MgO);
            }
            aVar.aM(19, this.MgP);
            aVar.bb(20, this.Mbx);
            aVar.aM(21, this.dfT);
            if (this.MgQ != null) {
                aVar.e(22, this.MgQ);
            }
            if (this.MgR != null) {
                aVar.e(23, this.MgR);
            }
            if (this.MgS != null) {
                aVar.e(24, this.MgS);
            }
            AppMethodBeat.o(91520);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MgB != null ? g.a.a.b.b.a.f(1, this.MgB) + 0 : 0) + g.a.a.b.b.a.bu(2, this.subType);
            if (this.Lot != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lot);
            }
            if (this.MgC != null) {
                f2 += g.a.a.a.nh(4, this.MgC.computeSize());
            }
            if (this.MgD != null) {
                f2 += g.a.a.b.b.a.f(5, this.MgD);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.MgE) + g.a.a.b.b.a.bu(7, this.MgF) + g.a.a.b.b.a.r(8, this.MgG) + g.a.a.b.b.a.bu(9, this.iwy) + g.a.a.b.b.a.bu(10, this.KTQ);
            if (this.MgH != null) {
                bu += g.a.a.b.b.a.f(11, this.MgH);
            }
            if (this.MgI != null) {
                bu += g.a.a.b.b.a.f(12, this.MgI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(13, this.MgJ);
            if (this.MgK != null) {
                bu2 += g.a.a.b.b.a.f(14, this.MgK);
            }
            if (this.MgL != null) {
                bu2 += g.a.a.b.b.a.f(15, this.MgL);
            }
            if (this.MgM != null) {
                bu2 += g.a.a.b.b.a.f(16, this.MgM);
            }
            if (this.MgN != null) {
                bu2 += g.a.a.b.b.a.f(17, this.MgN);
            }
            if (this.MgO != null) {
                bu2 += g.a.a.b.b.a.f(18, this.MgO);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(19, this.MgP) + g.a.a.b.b.a.r(20, this.Mbx) + g.a.a.b.b.a.bu(21, this.dfT);
            if (this.MgQ != null) {
                bu3 += g.a.a.b.b.a.f(22, this.MgQ);
            }
            if (this.MgR != null) {
                bu3 += g.a.a.b.b.a.f(23, this.MgR);
            }
            if (this.MgS != null) {
                bu3 += g.a.a.b.b.a.f(24, this.MgS);
            }
            AppMethodBeat.o(91520);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91520);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbe cbe = (cbe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbe.MgB = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 2:
                    cbe.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 3:
                    cbe.Lot = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbf cbf = new cbf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbf.populateBuilderWithField(aVar4, cbf, a.getNextFieldNumber(aVar4))) {
                        }
                        cbe.MgC = cbf;
                    }
                    AppMethodBeat.o(91520);
                    return 0;
                case 5:
                    cbe.MgD = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 6:
                    cbe.MgE = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 7:
                    cbe.MgF = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 8:
                    cbe.MgG = aVar3.UbS.zl();
                    AppMethodBeat.o(91520);
                    return 0;
                case 9:
                    cbe.iwy = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 10:
                    cbe.KTQ = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 11:
                    cbe.MgH = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 12:
                    cbe.MgI = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 13:
                    cbe.MgJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 14:
                    cbe.MgK = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 15:
                    cbe.MgL = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 16:
                    cbe.MgM = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 17:
                    cbe.MgN = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 18:
                    cbe.MgO = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 19:
                    cbe.MgP = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 20:
                    cbe.Mbx = aVar3.UbS.zl();
                    AppMethodBeat.o(91520);
                    return 0;
                case 21:
                    cbe.dfT = aVar3.UbS.zi();
                    AppMethodBeat.o(91520);
                    return 0;
                case 22:
                    cbe.MgQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 23:
                    cbe.MgR = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                case 24:
                    cbe.MgS = aVar3.UbS.readString();
                    AppMethodBeat.o(91520);
                    return 0;
                default:
                    AppMethodBeat.o(91520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91520);
            return -1;
        }
    }
}
