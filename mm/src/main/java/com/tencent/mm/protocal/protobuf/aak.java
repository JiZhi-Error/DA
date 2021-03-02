package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aak extends a {
    public int LlA;
    public LinkedList<aaj> LlB = new LinkedList<>();
    public b LlC;
    public cbh LlD;
    public int Lly;
    public int Llz;

    public aak() {
        AppMethodBeat.i(143967);
        AppMethodBeat.o(143967);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143968);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lly);
            aVar.aM(2, this.Llz);
            aVar.aM(3, this.LlA);
            aVar.e(4, 8, this.LlB);
            if (this.LlC != null) {
                aVar.c(5, this.LlC);
            }
            if (this.LlD != null) {
                aVar.ni(6, this.LlD.computeSize());
                this.LlD.writeFields(aVar);
            }
            AppMethodBeat.o(143968);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lly) + 0 + g.a.a.b.b.a.bu(2, this.Llz) + g.a.a.b.b.a.bu(3, this.LlA) + g.a.a.a.c(4, 8, this.LlB);
            if (this.LlC != null) {
                bu += g.a.a.b.b.a.b(5, this.LlC);
            }
            if (this.LlD != null) {
                bu += g.a.a.a.nh(6, this.LlD.computeSize());
            }
            AppMethodBeat.o(143968);
            return bu;
        } else if (i2 == 2) {
            this.LlB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143968);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aak aak = (aak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aak.Lly = aVar3.UbS.zi();
                    AppMethodBeat.o(143968);
                    return 0;
                case 2:
                    aak.Llz = aVar3.UbS.zi();
                    AppMethodBeat.o(143968);
                    return 0;
                case 3:
                    aak.LlA = aVar3.UbS.zi();
                    AppMethodBeat.o(143968);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aaj aaj = new aaj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aaj.populateBuilderWithField(aVar4, aaj, a.getNextFieldNumber(aVar4))) {
                        }
                        aak.LlB.add(aaj);
                    }
                    AppMethodBeat.o(143968);
                    return 0;
                case 5:
                    aak.LlC = aVar3.UbS.hPo();
                    AppMethodBeat.o(143968);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbh cbh = new cbh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbh.populateBuilderWithField(aVar5, cbh, a.getNextFieldNumber(aVar5))) {
                        }
                        aak.LlD = cbh;
                    }
                    AppMethodBeat.o(143968);
                    return 0;
                default:
                    AppMethodBeat.o(143968);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143968);
            return -1;
        }
    }
}
