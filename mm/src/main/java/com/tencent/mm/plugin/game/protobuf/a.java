package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<dl> xIw = new LinkedList<>();

    public a() {
        AppMethodBeat.i(182778);
        AppMethodBeat.o(182778);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(182779);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.xIw);
            AppMethodBeat.o(182779);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xIw) + 0;
            AppMethodBeat.o(182779);
            return c2;
        } else if (i2 == 2) {
            this.xIw.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(182779);
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
                        dl dlVar = new dl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlVar.populateBuilderWithField(aVar4, dlVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar4))) {
                        }
                        aVar3.xIw.add(dlVar);
                    }
                    AppMethodBeat.o(182779);
                    return 0;
                default:
                    AppMethodBeat.o(182779);
                    return -1;
            }
        } else {
            AppMethodBeat.o(182779);
            return -1;
        }
    }
}
