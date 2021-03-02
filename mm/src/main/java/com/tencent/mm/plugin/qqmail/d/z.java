package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class z extends a {
    public LinkedList<y> zns = new LinkedList<>();

    public z() {
        AppMethodBeat.i(122758);
        AppMethodBeat.o(122758);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122759);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.zns);
            AppMethodBeat.o(122759);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.zns) + 0;
            AppMethodBeat.o(122759);
            return c2;
        } else if (i2 == 2) {
            this.zns.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(122759);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        y yVar = new y();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = yVar.populateBuilderWithField(aVar3, yVar, a.getNextFieldNumber(aVar3))) {
                        }
                        zVar.zns.add(yVar);
                    }
                    AppMethodBeat.o(122759);
                    return 0;
                default:
                    AppMethodBeat.o(122759);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122759);
            return -1;
        }
    }
}
