package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class axk extends a {
    public int LHS;
    public LinkedList<axk> LHT = new LinkedList<>();
    public axk LHU;
    public int LHV;
    public String qHk;

    public axk() {
        AppMethodBeat.i(209563);
        AppMethodBeat.o(209563);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209564);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LHS);
            if (this.qHk != null) {
                aVar.e(2, this.qHk);
            }
            aVar.e(3, 8, this.LHT);
            if (this.LHU != null) {
                aVar.ni(4, this.LHU.computeSize());
                this.LHU.writeFields(aVar);
            }
            aVar.aM(5, this.LHV);
            AppMethodBeat.o(209564);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LHS) + 0;
            if (this.qHk != null) {
                bu += g.a.a.b.b.a.f(2, this.qHk);
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.LHT);
            if (this.LHU != null) {
                c2 += g.a.a.a.nh(4, this.LHU.computeSize());
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(5, this.LHV);
            AppMethodBeat.o(209564);
            return bu2;
        } else if (i2 == 2) {
            this.LHT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209564);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axk axk = (axk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axk.LHS = aVar3.UbS.zi();
                    AppMethodBeat.o(209564);
                    return 0;
                case 2:
                    axk.qHk = aVar3.UbS.readString();
                    AppMethodBeat.o(209564);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axk axk2 = new axk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axk2.populateBuilderWithField(aVar4, axk2, a.getNextFieldNumber(aVar4))) {
                        }
                        axk.LHT.add(axk2);
                    }
                    AppMethodBeat.o(209564);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axk axk3 = new axk();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axk3.populateBuilderWithField(aVar5, axk3, a.getNextFieldNumber(aVar5))) {
                        }
                        axk.LHU = axk3;
                    }
                    AppMethodBeat.o(209564);
                    return 0;
                case 5:
                    axk.LHV = aVar3.UbS.zi();
                    AppMethodBeat.o(209564);
                    return 0;
                default:
                    AppMethodBeat.o(209564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209564);
            return -1;
        }
    }
}
