package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<b> ktf = new LinkedList<>();

    public a() {
        AppMethodBeat.i(20825);
        AppMethodBeat.o(20825);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(20826);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.ktf);
            AppMethodBeat.o(20826);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.ktf) + 0;
            AppMethodBeat.o(20826);
            return c2;
        } else if (i2 == 2) {
            this.ktf.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(20826);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            a aVar3 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        b bVar = new b();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar4))) {
                        }
                        aVar3.ktf.add(bVar);
                    }
                    AppMethodBeat.o(20826);
                    return 0;
                default:
                    AppMethodBeat.o(20826);
                    return -1;
            }
        } else {
            AppMethodBeat.o(20826);
            return -1;
        }
    }
}
