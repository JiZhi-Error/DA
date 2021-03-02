package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dak extends a {
    public String AOl;
    public String CpP;
    public int MFG;
    public String MFH;
    public int MFI;
    public String MFJ;
    public int MFK;
    public String MFL;
    public long MFM;
    public LinkedList<czz> MFN = new LinkedList<>();
    public String MiL;
    public String iZU;

    public dak() {
        AppMethodBeat.i(91593);
        AppMethodBeat.o(91593);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91594);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MFG);
            if (this.MFH != null) {
                aVar.e(2, this.MFH);
            }
            if (this.MiL != null) {
                aVar.e(3, this.MiL);
            }
            aVar.aM(4, this.MFI);
            if (this.AOl != null) {
                aVar.e(5, this.AOl);
            }
            if (this.MFJ != null) {
                aVar.e(6, this.MFJ);
            }
            if (this.CpP != null) {
                aVar.e(7, this.CpP);
            }
            aVar.aM(8, this.MFK);
            if (this.iZU != null) {
                aVar.e(9, this.iZU);
            }
            if (this.MFL != null) {
                aVar.e(10, this.MFL);
            }
            aVar.bb(11, this.MFM);
            aVar.e(12, 8, this.MFN);
            AppMethodBeat.o(91594);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MFG) + 0;
            if (this.MFH != null) {
                bu += g.a.a.b.b.a.f(2, this.MFH);
            }
            if (this.MiL != null) {
                bu += g.a.a.b.b.a.f(3, this.MiL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.MFI);
            if (this.AOl != null) {
                bu2 += g.a.a.b.b.a.f(5, this.AOl);
            }
            if (this.MFJ != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MFJ);
            }
            if (this.CpP != null) {
                bu2 += g.a.a.b.b.a.f(7, this.CpP);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.MFK);
            if (this.iZU != null) {
                bu3 += g.a.a.b.b.a.f(9, this.iZU);
            }
            if (this.MFL != null) {
                bu3 += g.a.a.b.b.a.f(10, this.MFL);
            }
            int r = bu3 + g.a.a.b.b.a.r(11, this.MFM) + g.a.a.a.c(12, 8, this.MFN);
            AppMethodBeat.o(91594);
            return r;
        } else if (i2 == 2) {
            this.MFN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91594);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dak dak = (dak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dak.MFG = aVar3.UbS.zi();
                    AppMethodBeat.o(91594);
                    return 0;
                case 2:
                    dak.MFH = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 3:
                    dak.MiL = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 4:
                    dak.MFI = aVar3.UbS.zi();
                    AppMethodBeat.o(91594);
                    return 0;
                case 5:
                    dak.AOl = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 6:
                    dak.MFJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 7:
                    dak.CpP = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 8:
                    dak.MFK = aVar3.UbS.zi();
                    AppMethodBeat.o(91594);
                    return 0;
                case 9:
                    dak.iZU = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 10:
                    dak.MFL = aVar3.UbS.readString();
                    AppMethodBeat.o(91594);
                    return 0;
                case 11:
                    dak.MFM = aVar3.UbS.zl();
                    AppMethodBeat.o(91594);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        czz czz = new czz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = czz.populateBuilderWithField(aVar4, czz, a.getNextFieldNumber(aVar4))) {
                        }
                        dak.MFN.add(czz);
                    }
                    AppMethodBeat.o(91594);
                    return 0;
                default:
                    AppMethodBeat.o(91594);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91594);
            return -1;
        }
    }
}
