package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class blh extends a implements dyp {
    public int LUj;
    public int LUk;
    public int LUl;
    public LinkedList<eeo> LUm = new LinkedList<>();
    public LinkedList<eeo> LUn = new LinkedList<>();
    public LinkedList<eeo> LUo = new LinkedList<>();
    public int LlE;
    public int LlF;
    public int LlG;
    public LinkedList<eeo> LlH = new LinkedList<>();
    public LinkedList<eeo> LlI = new LinkedList<>();
    public LinkedList<eeo> LlJ = new LinkedList<>();
    public int LlK;
    public int LlL;
    public int LlM;
    public cbi LlN;
    public int Ret;

    public blh() {
        AppMethodBeat.i(143974);
        AppMethodBeat.o(143974);
    }

    @Override // com.tencent.mm.protocal.protobuf.dyp
    public final int getRet() {
        return this.Ret;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143975);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            aVar.aM(2, this.LlE);
            aVar.aM(3, this.LlF);
            aVar.aM(4, this.LlG);
            aVar.e(5, 8, this.LlH);
            aVar.e(6, 8, this.LlI);
            aVar.e(7, 8, this.LlJ);
            aVar.aM(8, this.LlK);
            aVar.aM(9, this.LlL);
            aVar.aM(10, this.LlM);
            aVar.aM(11, this.LUj);
            aVar.aM(12, this.LUk);
            aVar.aM(13, this.LUl);
            aVar.e(14, 8, this.LUm);
            aVar.e(15, 8, this.LUn);
            aVar.e(16, 8, this.LUo);
            if (this.LlN != null) {
                aVar.ni(17, this.LlN.computeSize());
                this.LlN.writeFields(aVar);
            }
            AppMethodBeat.o(143975);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.LlE) + g.a.a.b.b.a.bu(3, this.LlF) + g.a.a.b.b.a.bu(4, this.LlG) + g.a.a.a.c(5, 8, this.LlH) + g.a.a.a.c(6, 8, this.LlI) + g.a.a.a.c(7, 8, this.LlJ) + g.a.a.b.b.a.bu(8, this.LlK) + g.a.a.b.b.a.bu(9, this.LlL) + g.a.a.b.b.a.bu(10, this.LlM) + g.a.a.b.b.a.bu(11, this.LUj) + g.a.a.b.b.a.bu(12, this.LUk) + g.a.a.b.b.a.bu(13, this.LUl) + g.a.a.a.c(14, 8, this.LUm) + g.a.a.a.c(15, 8, this.LUn) + g.a.a.a.c(16, 8, this.LUo);
            if (this.LlN != null) {
                bu += g.a.a.a.nh(17, this.LlN.computeSize());
            }
            AppMethodBeat.o(143975);
            return bu;
        } else if (i2 == 2) {
            this.LlH.clear();
            this.LlI.clear();
            this.LlJ.clear();
            this.LUm.clear();
            this.LUn.clear();
            this.LUo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143975);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blh blh = (blh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    blh.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 2:
                    blh.LlE = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 3:
                    blh.LlF = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 4:
                    blh.LlG = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eeo eeo = new eeo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eeo.populateBuilderWithField(aVar4, eeo, a.getNextFieldNumber(aVar4))) {
                        }
                        blh.LlH.add(eeo);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eeo eeo2 = new eeo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eeo2.populateBuilderWithField(aVar5, eeo2, a.getNextFieldNumber(aVar5))) {
                        }
                        blh.LlI.add(eeo2);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eeo eeo3 = new eeo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eeo3.populateBuilderWithField(aVar6, eeo3, a.getNextFieldNumber(aVar6))) {
                        }
                        blh.LlJ.add(eeo3);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 8:
                    blh.LlK = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 9:
                    blh.LlL = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 10:
                    blh.LlM = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 11:
                    blh.LUj = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 12:
                    blh.LUk = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 13:
                    blh.LUl = aVar3.UbS.zi();
                    AppMethodBeat.o(143975);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eeo eeo4 = new eeo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eeo4.populateBuilderWithField(aVar7, eeo4, a.getNextFieldNumber(aVar7))) {
                        }
                        blh.LUm.add(eeo4);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eeo eeo5 = new eeo();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eeo5.populateBuilderWithField(aVar8, eeo5, a.getNextFieldNumber(aVar8))) {
                        }
                        blh.LUn.add(eeo5);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eeo eeo6 = new eeo();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eeo6.populateBuilderWithField(aVar9, eeo6, a.getNextFieldNumber(aVar9))) {
                        }
                        blh.LUo.add(eeo6);
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cbi cbi = new cbi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cbi.populateBuilderWithField(aVar10, cbi, a.getNextFieldNumber(aVar10))) {
                        }
                        blh.LlN = cbi;
                    }
                    AppMethodBeat.o(143975);
                    return 0;
                default:
                    AppMethodBeat.o(143975);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143975);
            return -1;
        }
    }
}
