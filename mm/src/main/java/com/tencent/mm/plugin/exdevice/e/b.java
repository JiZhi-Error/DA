package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> rBA = new LinkedList<>();

    public b() {
        AppMethodBeat.i(23483);
        AppMethodBeat.o(23483);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23484);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.rBA);
            AppMethodBeat.o(23484);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.rBA) + 0;
            AppMethodBeat.o(23484);
            return c2;
        } else if (i2 == 2) {
            this.rBA.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(23484);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar3 = new a();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar3.populateBuilderWithField(aVar4, aVar3, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.rBA.add(aVar3);
                    }
                    AppMethodBeat.o(23484);
                    return 0;
                default:
                    AppMethodBeat.o(23484);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23484);
            return -1;
        }
    }
}
