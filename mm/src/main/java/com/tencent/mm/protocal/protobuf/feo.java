package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class feo extends a {
    public feq NzS;
    public fep NzT;
    public fer NzU;
    public fet NzV;
    public fes NzW;
    public fev NzX;
    public fen NzY;
    public feu NzZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153340);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzS != null) {
                aVar.ni(1, this.NzS.computeSize());
                this.NzS.writeFields(aVar);
            }
            if (this.NzT != null) {
                aVar.ni(2, this.NzT.computeSize());
                this.NzT.writeFields(aVar);
            }
            if (this.NzU != null) {
                aVar.ni(3, this.NzU.computeSize());
                this.NzU.writeFields(aVar);
            }
            if (this.NzV != null) {
                aVar.ni(4, this.NzV.computeSize());
                this.NzV.writeFields(aVar);
            }
            if (this.NzW != null) {
                aVar.ni(5, this.NzW.computeSize());
                this.NzW.writeFields(aVar);
            }
            if (this.NzX != null) {
                aVar.ni(6, this.NzX.computeSize());
                this.NzX.writeFields(aVar);
            }
            if (this.NzY != null) {
                aVar.ni(7, this.NzY.computeSize());
                this.NzY.writeFields(aVar);
            }
            if (this.NzZ != null) {
                aVar.ni(8, this.NzZ.computeSize());
                this.NzZ.writeFields(aVar);
            }
            AppMethodBeat.o(153340);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NzS != null ? g.a.a.a.nh(1, this.NzS.computeSize()) + 0 : 0;
            if (this.NzT != null) {
                nh += g.a.a.a.nh(2, this.NzT.computeSize());
            }
            if (this.NzU != null) {
                nh += g.a.a.a.nh(3, this.NzU.computeSize());
            }
            if (this.NzV != null) {
                nh += g.a.a.a.nh(4, this.NzV.computeSize());
            }
            if (this.NzW != null) {
                nh += g.a.a.a.nh(5, this.NzW.computeSize());
            }
            if (this.NzX != null) {
                nh += g.a.a.a.nh(6, this.NzX.computeSize());
            }
            if (this.NzY != null) {
                nh += g.a.a.a.nh(7, this.NzY.computeSize());
            }
            if (this.NzZ != null) {
                nh += g.a.a.a.nh(8, this.NzZ.computeSize());
            }
            AppMethodBeat.o(153340);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153340);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            feo feo = (feo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        feq feq = new feq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = feq.populateBuilderWithField(aVar4, feq, a.getNextFieldNumber(aVar4))) {
                        }
                        feo.NzS = feq;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fep fep = new fep();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fep.populateBuilderWithField(aVar5, fep, a.getNextFieldNumber(aVar5))) {
                        }
                        feo.NzT = fep;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fer fer = new fer();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fer.populateBuilderWithField(aVar6, fer, a.getNextFieldNumber(aVar6))) {
                        }
                        feo.NzU = fer;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fet fet = new fet();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fet.populateBuilderWithField(aVar7, fet, a.getNextFieldNumber(aVar7))) {
                        }
                        feo.NzV = fet;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        fes fes = new fes();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fes.populateBuilderWithField(aVar8, fes, a.getNextFieldNumber(aVar8))) {
                        }
                        feo.NzW = fes;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        fev fev = new fev();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fev.populateBuilderWithField(aVar9, fev, a.getNextFieldNumber(aVar9))) {
                        }
                        feo.NzX = fev;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        fen fen = new fen();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = fen.populateBuilderWithField(aVar10, fen, a.getNextFieldNumber(aVar10))) {
                        }
                        feo.NzY = fen;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        feu feu = new feu();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = feu.populateBuilderWithField(aVar11, feu, a.getNextFieldNumber(aVar11))) {
                        }
                        feo.NzZ = feu;
                    }
                    AppMethodBeat.o(153340);
                    return 0;
                default:
                    AppMethodBeat.o(153340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153340);
            return -1;
        }
    }
}
