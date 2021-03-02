package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ac extends a {
    public int oTW;
    public int oTl;
    public q oUN;
    public p oUO;
    public r oUP;
    public s oUQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22135);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oTl);
            aVar.aM(2, this.oTW);
            if (this.oUN != null) {
                aVar.ni(3, this.oUN.computeSize());
                this.oUN.writeFields(aVar);
            }
            if (this.oUO != null) {
                aVar.ni(4, this.oUO.computeSize());
                this.oUO.writeFields(aVar);
            }
            if (this.oUP != null) {
                aVar.ni(5, this.oUP.computeSize());
                this.oUP.writeFields(aVar);
            }
            if (this.oUQ != null) {
                aVar.ni(6, this.oUQ.computeSize());
                this.oUQ.writeFields(aVar);
            }
            AppMethodBeat.o(22135);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTl) + 0 + g.a.a.b.b.a.bu(2, this.oTW);
            if (this.oUN != null) {
                bu += g.a.a.a.nh(3, this.oUN.computeSize());
            }
            if (this.oUO != null) {
                bu += g.a.a.a.nh(4, this.oUO.computeSize());
            }
            if (this.oUP != null) {
                bu += g.a.a.a.nh(5, this.oUP.computeSize());
            }
            if (this.oUQ != null) {
                bu += g.a.a.a.nh(6, this.oUQ.computeSize());
            }
            AppMethodBeat.o(22135);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22135);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acVar.oTl = aVar3.UbS.zi();
                    AppMethodBeat.o(22135);
                    return 0;
                case 2:
                    acVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(22135);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        q qVar = new q();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = qVar.populateBuilderWithField(aVar4, qVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.oUN = qVar;
                    }
                    AppMethodBeat.o(22135);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        p pVar = new p();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = pVar.populateBuilderWithField(aVar5, pVar, a.getNextFieldNumber(aVar5))) {
                        }
                        acVar.oUO = pVar;
                    }
                    AppMethodBeat.o(22135);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        r rVar = new r();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = rVar.populateBuilderWithField(aVar6, rVar, a.getNextFieldNumber(aVar6))) {
                        }
                        acVar.oUP = rVar;
                    }
                    AppMethodBeat.o(22135);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        s sVar = new s();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sVar.populateBuilderWithField(aVar7, sVar, a.getNextFieldNumber(aVar7))) {
                        }
                        acVar.oUQ = sVar;
                    }
                    AppMethodBeat.o(22135);
                    return 0;
                default:
                    AppMethodBeat.o(22135);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22135);
            return -1;
        }
    }
}
