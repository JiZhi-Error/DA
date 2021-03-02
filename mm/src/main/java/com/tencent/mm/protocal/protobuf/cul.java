package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cul extends a {
    public int HEc;
    public String HEe;
    public String HEf;
    public String HEg;
    public String HEh;
    public String HEi;
    public String HEj;
    public int HFS;
    public String LFY;
    public cum MzF;
    public String MzG;
    public String MzH;
    public int MzI;
    public String MzJ;
    public String MzK;
    public String MzL;
    public String MzM;
    public String MzN;
    public String MzO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72526);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.HFS);
            if (this.MzF != null) {
                aVar.ni(2, this.MzF.computeSize());
                this.MzF.writeFields(aVar);
            }
            aVar.aM(3, this.HEc);
            if (this.HEe != null) {
                aVar.e(4, this.HEe);
            }
            if (this.HEf != null) {
                aVar.e(5, this.HEf);
            }
            if (this.HEg != null) {
                aVar.e(6, this.HEg);
            }
            if (this.HEh != null) {
                aVar.e(7, this.HEh);
            }
            if (this.HEi != null) {
                aVar.e(8, this.HEi);
            }
            if (this.HEj != null) {
                aVar.e(9, this.HEj);
            }
            if (this.LFY != null) {
                aVar.e(10, this.LFY);
            }
            if (this.MzG != null) {
                aVar.e(11, this.MzG);
            }
            if (this.MzH != null) {
                aVar.e(12, this.MzH);
            }
            aVar.aM(13, this.MzI);
            if (this.MzJ != null) {
                aVar.e(14, this.MzJ);
            }
            if (this.MzK != null) {
                aVar.e(15, this.MzK);
            }
            if (this.MzL != null) {
                aVar.e(16, this.MzL);
            }
            if (this.MzM != null) {
                aVar.e(17, this.MzM);
            }
            if (this.MzN != null) {
                aVar.e(18, this.MzN);
            }
            if (this.MzO != null) {
                aVar.e(19, this.MzO);
            }
            AppMethodBeat.o(72526);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.HFS) + 0;
            if (this.MzF != null) {
                bu += g.a.a.a.nh(2, this.MzF.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.HEc);
            if (this.HEe != null) {
                bu2 += g.a.a.b.b.a.f(4, this.HEe);
            }
            if (this.HEf != null) {
                bu2 += g.a.a.b.b.a.f(5, this.HEf);
            }
            if (this.HEg != null) {
                bu2 += g.a.a.b.b.a.f(6, this.HEg);
            }
            if (this.HEh != null) {
                bu2 += g.a.a.b.b.a.f(7, this.HEh);
            }
            if (this.HEi != null) {
                bu2 += g.a.a.b.b.a.f(8, this.HEi);
            }
            if (this.HEj != null) {
                bu2 += g.a.a.b.b.a.f(9, this.HEj);
            }
            if (this.LFY != null) {
                bu2 += g.a.a.b.b.a.f(10, this.LFY);
            }
            if (this.MzG != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MzG);
            }
            if (this.MzH != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MzH);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.MzI);
            if (this.MzJ != null) {
                bu3 += g.a.a.b.b.a.f(14, this.MzJ);
            }
            if (this.MzK != null) {
                bu3 += g.a.a.b.b.a.f(15, this.MzK);
            }
            if (this.MzL != null) {
                bu3 += g.a.a.b.b.a.f(16, this.MzL);
            }
            if (this.MzM != null) {
                bu3 += g.a.a.b.b.a.f(17, this.MzM);
            }
            if (this.MzN != null) {
                bu3 += g.a.a.b.b.a.f(18, this.MzN);
            }
            if (this.MzO != null) {
                bu3 += g.a.a.b.b.a.f(19, this.MzO);
            }
            AppMethodBeat.o(72526);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72526);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cul cul = (cul) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cul.HFS = aVar3.UbS.zi();
                    AppMethodBeat.o(72526);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cum cum = new cum();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cum.populateBuilderWithField(aVar4, cum, a.getNextFieldNumber(aVar4))) {
                        }
                        cul.MzF = cum;
                    }
                    AppMethodBeat.o(72526);
                    return 0;
                case 3:
                    cul.HEc = aVar3.UbS.zi();
                    AppMethodBeat.o(72526);
                    return 0;
                case 4:
                    cul.HEe = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 5:
                    cul.HEf = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 6:
                    cul.HEg = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 7:
                    cul.HEh = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 8:
                    cul.HEi = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 9:
                    cul.HEj = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 10:
                    cul.LFY = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 11:
                    cul.MzG = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 12:
                    cul.MzH = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 13:
                    cul.MzI = aVar3.UbS.zi();
                    AppMethodBeat.o(72526);
                    return 0;
                case 14:
                    cul.MzJ = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 15:
                    cul.MzK = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 16:
                    cul.MzL = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 17:
                    cul.MzM = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 18:
                    cul.MzN = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                case 19:
                    cul.MzO = aVar3.UbS.readString();
                    AppMethodBeat.o(72526);
                    return 0;
                default:
                    AppMethodBeat.o(72526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72526);
            return -1;
        }
    }
}
