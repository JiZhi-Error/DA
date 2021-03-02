package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<d> NKr = new LinkedList<>();
    public LinkedList<c> NKs = new LinkedList<>();

    public a() {
        AppMethodBeat.i(104894);
        AppMethodBeat.o(104894);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104895);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(3, 8, this.NKr);
            aVar.e(4, 8, this.NKs);
            AppMethodBeat.o(104895);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(3, 8, this.NKr) + 0 + g.a.a.a.c(4, 8, this.NKs);
            AppMethodBeat.o(104895);
            return c2;
        } else if (i2 == 2) {
            this.NKr.clear();
            this.NKs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104895);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar5, dVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.NKr.add(dVar);
                    }
                    AppMethodBeat.o(104895);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar6, cVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar6))) {
                        }
                        aVar4.NKs.add(cVar);
                    }
                    AppMethodBeat.o(104895);
                    return 0;
                default:
                    AppMethodBeat.o(104895);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104895);
            return -1;
        }
    }
}
