package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<String> UAp = new LinkedList<>();

    public a() {
        AppMethodBeat.i(261964);
        AppMethodBeat.o(261964);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261965);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 1, this.UAp);
            AppMethodBeat.o(261965);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.UAp) + 0;
            AppMethodBeat.o(261965);
            return c2;
        } else if (i2 == 2) {
            this.UAp.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(261965);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            a aVar3 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar3.UAp.add(aVar2.UbS.readString());
                    AppMethodBeat.o(261965);
                    return 0;
                default:
                    AppMethodBeat.o(261965);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261965);
            return -1;
        }
    }
}
