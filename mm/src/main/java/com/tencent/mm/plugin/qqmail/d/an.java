package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class an extends a {
    public String Bru;
    public LinkedList<al> BsN = new LinkedList<>();
    public LinkedList<al> BsO = new LinkedList<>();
    public LinkedList<al> BsP = new LinkedList<>();
    public int BsV;
    public al BsW;
    public LinkedList<ak> BsX = new LinkedList<>();
    public LinkedList<ak> BsY = new LinkedList<>();
    public String BsZ;
    public boolean Bta;
    public String content;

    public an() {
        AppMethodBeat.i(198631);
        AppMethodBeat.o(198631);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.BsV);
            if (this.BsW != null) {
                aVar.ni(2, this.BsW.computeSize());
                this.BsW.writeFields(aVar);
            }
            aVar.e(3, 8, this.BsN);
            aVar.e(4, 8, this.BsO);
            aVar.e(5, 8, this.BsP);
            if (this.Bru != null) {
                aVar.e(6, this.Bru);
            }
            if (this.content != null) {
                aVar.e(7, this.content);
            }
            aVar.e(8, 8, this.BsX);
            aVar.e(9, 8, this.BsY);
            if (this.BsZ != null) {
                aVar.e(10, this.BsZ);
            }
            aVar.cc(11, this.Bta);
            AppMethodBeat.o(198632);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.BsV) + 0;
            if (this.BsW != null) {
                bu += g.a.a.a.nh(2, this.BsW.computeSize());
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.BsN) + g.a.a.a.c(4, 8, this.BsO) + g.a.a.a.c(5, 8, this.BsP);
            if (this.Bru != null) {
                c2 += g.a.a.b.b.a.f(6, this.Bru);
            }
            if (this.content != null) {
                c2 += g.a.a.b.b.a.f(7, this.content);
            }
            int c3 = c2 + g.a.a.a.c(8, 8, this.BsX) + g.a.a.a.c(9, 8, this.BsY);
            if (this.BsZ != null) {
                c3 += g.a.a.b.b.a.f(10, this.BsZ);
            }
            int fS = c3 + g.a.a.b.b.a.fS(11) + 1;
            AppMethodBeat.o(198632);
            return fS;
        } else if (i2 == 2) {
            this.BsN.clear();
            this.BsO.clear();
            this.BsP.clear();
            this.BsX.clear();
            this.BsY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198632);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            an anVar = (an) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anVar.BsV = aVar3.UbS.zi();
                    AppMethodBeat.o(198632);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        al alVar = new al();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = alVar.populateBuilderWithField(aVar4, alVar, a.getNextFieldNumber(aVar4))) {
                        }
                        anVar.BsW = alVar;
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        al alVar2 = new al();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = alVar2.populateBuilderWithField(aVar5, alVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        anVar.BsN.add(alVar2);
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        al alVar3 = new al();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = alVar3.populateBuilderWithField(aVar6, alVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        anVar.BsO.add(alVar3);
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        al alVar4 = new al();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = alVar4.populateBuilderWithField(aVar7, alVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        anVar.BsP.add(alVar4);
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 6:
                    anVar.Bru = aVar3.UbS.readString();
                    AppMethodBeat.o(198632);
                    return 0;
                case 7:
                    anVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(198632);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ak akVar = new ak();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = akVar.populateBuilderWithField(aVar8, akVar, a.getNextFieldNumber(aVar8))) {
                        }
                        anVar.BsX.add(akVar);
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ak akVar2 = new ak();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = akVar2.populateBuilderWithField(aVar9, akVar2, a.getNextFieldNumber(aVar9))) {
                        }
                        anVar.BsY.add(akVar2);
                    }
                    AppMethodBeat.o(198632);
                    return 0;
                case 10:
                    anVar.BsZ = aVar3.UbS.readString();
                    AppMethodBeat.o(198632);
                    return 0;
                case 11:
                    anVar.Bta = aVar3.UbS.yZ();
                    AppMethodBeat.o(198632);
                    return 0;
                default:
                    AppMethodBeat.o(198632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198632);
            return -1;
        }
    }
}
