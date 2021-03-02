package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> DRL = new LinkedList<>();
    public LinkedList<e> DRM = new LinkedList<>();
    public LinkedList<e> DRN = new LinkedList<>();
    public LinkedList<e> DRO = new LinkedList<>();
    public LinkedList<f> DRP = new LinkedList<>();
    public LinkedList<f> DRQ = new LinkedList<>();

    public d() {
        AppMethodBeat.i(96154);
        AppMethodBeat.o(96154);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96155);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.DRL);
            aVar.e(2, 8, this.DRM);
            aVar.e(3, 8, this.DRN);
            aVar.e(4, 8, this.DRO);
            aVar.e(5, 8, this.DRP);
            aVar.e(6, 8, this.DRQ);
            AppMethodBeat.o(96155);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.DRL) + 0 + g.a.a.a.c(2, 8, this.DRM) + g.a.a.a.c(3, 8, this.DRN) + g.a.a.a.c(4, 8, this.DRO) + g.a.a.a.c(5, 8, this.DRP) + g.a.a.a.c(6, 8, this.DRQ);
            AppMethodBeat.o(96155);
            return c2;
        } else if (i2 == 2) {
            this.DRL.clear();
            this.DRM.clear();
            this.DRN.clear();
            this.DRO.clear();
            this.DRP.clear();
            this.DRQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(96155);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.DRL.add(eVar);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        e eVar2 = new e();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eVar2.populateBuilderWithField(aVar5, eVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        dVar.DRM.add(eVar2);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        e eVar3 = new e();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eVar3.populateBuilderWithField(aVar6, eVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        dVar.DRN.add(eVar3);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        e eVar4 = new e();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eVar4.populateBuilderWithField(aVar7, eVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        dVar.DRO.add(eVar4);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        f fVar = new f();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fVar.populateBuilderWithField(aVar8, fVar, a.getNextFieldNumber(aVar8))) {
                        }
                        dVar.DRP.add(fVar);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        f fVar2 = new f();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fVar2.populateBuilderWithField(aVar9, fVar2, a.getNextFieldNumber(aVar9))) {
                        }
                        dVar.DRQ.add(fVar2);
                    }
                    AppMethodBeat.o(96155);
                    return 0;
                default:
                    AppMethodBeat.o(96155);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96155);
            return -1;
        }
    }
}
