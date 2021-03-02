package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cc extends a {
    public LinkedList<cd> Oru = new LinkedList<>();

    public cc() {
        AppMethodBeat.i(43274);
        AppMethodBeat.o(43274);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43275);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.Oru);
            AppMethodBeat.o(43275);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Oru) + 0;
            AppMethodBeat.o(43275);
            return c2;
        } else if (i2 == 2) {
            this.Oru.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(43275);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cd cdVar = new cd();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cdVar.populateBuilderWithField(aVar3, cdVar, a.getNextFieldNumber(aVar3))) {
                        }
                        ccVar.Oru.add(cdVar);
                    }
                    AppMethodBeat.o(43275);
                    return 0;
                default:
                    AppMethodBeat.o(43275);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43275);
            return -1;
        }
    }
}
