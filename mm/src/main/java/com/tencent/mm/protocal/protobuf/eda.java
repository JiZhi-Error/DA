package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eda extends a {
    public LinkedList<edj> DRL = new LinkedList<>();
    public LinkedList<edj> DRM = new LinkedList<>();
    public LinkedList<edj> DRN = new LinkedList<>();
    public LinkedList<edj> DRO = new LinkedList<>();
    public LinkedList<edz> DRP = new LinkedList<>();
    public LinkedList<edz> DRQ = new LinkedList<>();

    public eda() {
        AppMethodBeat.i(118432);
        AppMethodBeat.o(118432);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118433);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.DRL);
            aVar.e(2, 8, this.DRM);
            aVar.e(3, 8, this.DRN);
            aVar.e(4, 8, this.DRO);
            aVar.e(5, 8, this.DRP);
            aVar.e(6, 8, this.DRQ);
            AppMethodBeat.o(118433);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.DRL) + 0 + g.a.a.a.c(2, 8, this.DRM) + g.a.a.a.c(3, 8, this.DRN) + g.a.a.a.c(4, 8, this.DRO) + g.a.a.a.c(5, 8, this.DRP) + g.a.a.a.c(6, 8, this.DRQ);
            AppMethodBeat.o(118433);
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
            AppMethodBeat.o(118433);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eda eda = (eda) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        edj edj = new edj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = edj.populateBuilderWithField(aVar4, edj, a.getNextFieldNumber(aVar4))) {
                        }
                        eda.DRL.add(edj);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edj edj2 = new edj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edj2.populateBuilderWithField(aVar5, edj2, a.getNextFieldNumber(aVar5))) {
                        }
                        eda.DRM.add(edj2);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        edj edj3 = new edj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = edj3.populateBuilderWithField(aVar6, edj3, a.getNextFieldNumber(aVar6))) {
                        }
                        eda.DRN.add(edj3);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        edj edj4 = new edj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = edj4.populateBuilderWithField(aVar7, edj4, a.getNextFieldNumber(aVar7))) {
                        }
                        eda.DRO.add(edj4);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        edz edz = new edz();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = edz.populateBuilderWithField(aVar8, edz, a.getNextFieldNumber(aVar8))) {
                        }
                        eda.DRP.add(edz);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        edz edz2 = new edz();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = edz2.populateBuilderWithField(aVar9, edz2, a.getNextFieldNumber(aVar9))) {
                        }
                        eda.DRQ.add(edz2);
                    }
                    AppMethodBeat.o(118433);
                    return 0;
                default:
                    AppMethodBeat.o(118433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118433);
            return -1;
        }
    }
}
