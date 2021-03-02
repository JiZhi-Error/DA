package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class am extends a {
    public String Bru;
    public String BsL;
    public al BsM;
    public LinkedList<al> BsN = new LinkedList<>();
    public LinkedList<al> BsO = new LinkedList<>();
    public LinkedList<al> BsP = new LinkedList<>();
    public String BsQ;
    public String BsR;
    public LinkedList<ak> BsS = new LinkedList<>();
    public LinkedList<ak> BsT = new LinkedList<>();
    public av BsU;
    public String charset;
    public String content;
    public int size;

    public am() {
        AppMethodBeat.i(198629);
        AppMethodBeat.o(198629);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198630);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.size);
            if (this.charset != null) {
                aVar.e(2, this.charset);
            }
            if (this.BsL != null) {
                aVar.e(3, this.BsL);
            }
            if (this.BsM != null) {
                aVar.ni(4, this.BsM.computeSize());
                this.BsM.writeFields(aVar);
            }
            aVar.e(5, 8, this.BsN);
            aVar.e(6, 8, this.BsO);
            aVar.e(7, 8, this.BsP);
            if (this.BsQ != null) {
                aVar.e(8, this.BsQ);
            }
            if (this.Bru != null) {
                aVar.e(9, this.Bru);
            }
            if (this.BsR != null) {
                aVar.e(10, this.BsR);
            }
            if (this.content != null) {
                aVar.e(11, this.content);
            }
            aVar.e(12, 8, this.BsS);
            aVar.e(13, 8, this.BsT);
            if (this.BsU != null) {
                aVar.ni(14, this.BsU.computeSize());
                this.BsU.writeFields(aVar);
            }
            AppMethodBeat.o(198630);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.size) + 0;
            if (this.charset != null) {
                bu += g.a.a.b.b.a.f(2, this.charset);
            }
            if (this.BsL != null) {
                bu += g.a.a.b.b.a.f(3, this.BsL);
            }
            if (this.BsM != null) {
                bu += g.a.a.a.nh(4, this.BsM.computeSize());
            }
            int c2 = bu + g.a.a.a.c(5, 8, this.BsN) + g.a.a.a.c(6, 8, this.BsO) + g.a.a.a.c(7, 8, this.BsP);
            if (this.BsQ != null) {
                c2 += g.a.a.b.b.a.f(8, this.BsQ);
            }
            if (this.Bru != null) {
                c2 += g.a.a.b.b.a.f(9, this.Bru);
            }
            if (this.BsR != null) {
                c2 += g.a.a.b.b.a.f(10, this.BsR);
            }
            if (this.content != null) {
                c2 += g.a.a.b.b.a.f(11, this.content);
            }
            int c3 = c2 + g.a.a.a.c(12, 8, this.BsS) + g.a.a.a.c(13, 8, this.BsT);
            if (this.BsU != null) {
                c3 += g.a.a.a.nh(14, this.BsU.computeSize());
            }
            AppMethodBeat.o(198630);
            return c3;
        } else if (i2 == 2) {
            this.BsN.clear();
            this.BsO.clear();
            this.BsP.clear();
            this.BsS.clear();
            this.BsT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198630);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    amVar.size = aVar3.UbS.zi();
                    AppMethodBeat.o(198630);
                    return 0;
                case 2:
                    amVar.charset = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 3:
                    amVar.BsL = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size2 = awh.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        al alVar = new al();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = alVar.populateBuilderWithField(aVar4, alVar, a.getNextFieldNumber(aVar4))) {
                        }
                        amVar.BsM = alVar;
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size3 = awh2.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        al alVar2 = new al();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = alVar2.populateBuilderWithField(aVar5, alVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        amVar.BsN.add(alVar2);
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size4 = awh3.size();
                    for (int i5 = 0; i5 < size4; i5++) {
                        al alVar3 = new al();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = alVar3.populateBuilderWithField(aVar6, alVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        amVar.BsO.add(alVar3);
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size5 = awh4.size();
                    for (int i6 = 0; i6 < size5; i6++) {
                        al alVar4 = new al();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = alVar4.populateBuilderWithField(aVar7, alVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        amVar.BsP.add(alVar4);
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 8:
                    amVar.BsQ = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 9:
                    amVar.Bru = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 10:
                    amVar.BsR = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 11:
                    amVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(198630);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size6 = awh5.size();
                    for (int i7 = 0; i7 < size6; i7++) {
                        ak akVar = new ak();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = akVar.populateBuilderWithField(aVar8, akVar, a.getNextFieldNumber(aVar8))) {
                        }
                        amVar.BsS.add(akVar);
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size7 = awh6.size();
                    for (int i8 = 0; i8 < size7; i8++) {
                        ak akVar2 = new ak();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = akVar2.populateBuilderWithField(aVar9, akVar2, a.getNextFieldNumber(aVar9))) {
                        }
                        amVar.BsT.add(akVar2);
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size8 = awh7.size();
                    for (int i9 = 0; i9 < size8; i9++) {
                        av avVar = new av();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = avVar.populateBuilderWithField(aVar10, avVar, a.getNextFieldNumber(aVar10))) {
                        }
                        amVar.BsU = avVar;
                    }
                    AppMethodBeat.o(198630);
                    return 0;
                default:
                    AppMethodBeat.o(198630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198630);
            return -1;
        }
    }
}
