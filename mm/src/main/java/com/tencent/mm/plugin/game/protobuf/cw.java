package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cw extends a {
    public LinkedList<c> xME = new LinkedList<>();
    public df xMF;
    public LinkedList<q> xMG = new LinkedList<>();
    public db xMH;
    public LinkedList<dt> xMI = new LinkedList<>();

    public cw() {
        AppMethodBeat.i(41809);
        AppMethodBeat.o(41809);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41810);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xME);
            if (this.xMF != null) {
                aVar.ni(2, this.xMF.computeSize());
                this.xMF.writeFields(aVar);
            }
            aVar.e(3, 8, this.xMG);
            if (this.xMH != null) {
                aVar.ni(4, this.xMH.computeSize());
                this.xMH.writeFields(aVar);
            }
            aVar.e(5, 8, this.xMI);
            AppMethodBeat.o(41810);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xME) + 0;
            if (this.xMF != null) {
                c2 += g.a.a.a.nh(2, this.xMF.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(3, 8, this.xMG);
            if (this.xMH != null) {
                c3 += g.a.a.a.nh(4, this.xMH.computeSize());
            }
            int c4 = c3 + g.a.a.a.c(5, 8, this.xMI);
            AppMethodBeat.o(41810);
            return c4;
        } else if (i2 == 2) {
            this.xME.clear();
            this.xMG.clear();
            this.xMI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41810);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cw cwVar = (cw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cwVar.xME.add(cVar);
                    }
                    AppMethodBeat.o(41810);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        df dfVar = new df();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dfVar.populateBuilderWithField(aVar5, dfVar, a.getNextFieldNumber(aVar5))) {
                        }
                        cwVar.xMF = dfVar;
                    }
                    AppMethodBeat.o(41810);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        q qVar = new q();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = qVar.populateBuilderWithField(aVar6, qVar, a.getNextFieldNumber(aVar6))) {
                        }
                        cwVar.xMG.add(qVar);
                    }
                    AppMethodBeat.o(41810);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        db dbVar = new db();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dbVar.populateBuilderWithField(aVar7, dbVar, a.getNextFieldNumber(aVar7))) {
                        }
                        cwVar.xMH = dbVar;
                    }
                    AppMethodBeat.o(41810);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dt dtVar = new dt();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dtVar.populateBuilderWithField(aVar8, dtVar, a.getNextFieldNumber(aVar8))) {
                        }
                        cwVar.xMI.add(dtVar);
                    }
                    AppMethodBeat.o(41810);
                    return 0;
                default:
                    AppMethodBeat.o(41810);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41810);
            return -1;
        }
    }
}
