package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<c> xum = new LinkedList<>();

    public d() {
        AppMethodBeat.i(204099);
        AppMethodBeat.o(204099);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(204100);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.xum);
            AppMethodBeat.o(204100);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xum) + 0;
            AppMethodBeat.o(204100);
            return c2;
        } else if (i2 == 2) {
            this.xum.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(204100);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar3, cVar, a.getNextFieldNumber(aVar3))) {
                        }
                        dVar.xum.add(cVar);
                    }
                    AppMethodBeat.o(204100);
                    return 0;
                default:
                    AppMethodBeat.o(204100);
                    return -1;
            }
        } else {
            AppMethodBeat.o(204100);
            return -1;
        }
    }
}