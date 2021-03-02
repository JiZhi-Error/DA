package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class k extends a {
    public LinkedList<h> xJi = new LinkedList<>();
    public LinkedList<du> xJj = new LinkedList<>();

    public k() {
        AppMethodBeat.i(256626);
        AppMethodBeat.o(256626);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256627);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xJi);
            aVar.e(2, 8, this.xJj);
            AppMethodBeat.o(256627);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xJi) + 0 + g.a.a.a.c(2, 8, this.xJj);
            AppMethodBeat.o(256627);
            return c2;
        } else if (i2 == 2) {
            this.xJi.clear();
            this.xJj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256627);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
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
                        kVar.xJi.add(hVar);
                    }
                    AppMethodBeat.o(256627);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        du duVar = new du();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = duVar.populateBuilderWithField(aVar5, duVar, a.getNextFieldNumber(aVar5))) {
                        }
                        kVar.xJj.add(duVar);
                    }
                    AppMethodBeat.o(256627);
                    return 0;
                default:
                    AppMethodBeat.o(256627);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256627);
            return -1;
        }
    }
}
