package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> yFr = new LinkedList<>();
    public String yFs;

    public b() {
        AppMethodBeat.i(55670);
        AppMethodBeat.o(55670);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(55671);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.yFr);
            if (this.yFs != null) {
                aVar.e(2, this.yFs);
            }
            AppMethodBeat.o(55671);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.yFr) + 0;
            if (this.yFs != null) {
                c2 += g.a.a.b.b.a.f(2, this.yFs);
            }
            AppMethodBeat.o(55671);
            return c2;
        } else if (i2 == 2) {
            this.yFr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(55671);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar4 = new a();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.yFr.add(aVar4);
                    }
                    AppMethodBeat.o(55671);
                    return 0;
                case 2:
                    bVar.yFs = aVar3.UbS.readString();
                    AppMethodBeat.o(55671);
                    return 0;
                default:
                    AppMethodBeat.o(55671);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55671);
            return -1;
        }
    }
}
