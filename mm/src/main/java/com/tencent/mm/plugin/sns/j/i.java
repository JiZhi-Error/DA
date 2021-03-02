package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> DRW = new LinkedList<>();
    public g DRX;

    public i() {
        AppMethodBeat.i(96160);
        AppMethodBeat.o(96160);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96161);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.DRW);
            if (this.DRX != null) {
                aVar.ni(2, this.DRX.computeSize());
                this.DRX.writeFields(aVar);
            }
            AppMethodBeat.o(96161);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.DRW) + 0;
            if (this.DRX != null) {
                c2 += g.a.a.a.nh(2, this.DRX.computeSize());
            }
            AppMethodBeat.o(96161);
            return c2;
        } else if (i2 == 2) {
            this.DRW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(96161);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h hVar = new h();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.DRW.add(hVar);
                    }
                    AppMethodBeat.o(96161);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        g gVar = new g();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gVar.populateBuilderWithField(aVar5, gVar, a.getNextFieldNumber(aVar5))) {
                        }
                        iVar.DRX = gVar;
                    }
                    AppMethodBeat.o(96161);
                    return 0;
                default:
                    AppMethodBeat.o(96161);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96161);
            return -1;
        }
    }
}
