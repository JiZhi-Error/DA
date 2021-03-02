package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<g> qFS = new LinkedList<>();
    public long qFT;

    public e() {
        AppMethodBeat.i(153045);
        AppMethodBeat.o(153045);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153046);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.qFS);
            aVar.bb(2, this.qFT);
            AppMethodBeat.o(153046);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.qFS) + 0 + g.a.a.b.b.a.r(2, this.qFT);
            AppMethodBeat.o(153046);
            return c2;
        } else if (i2 == 2) {
            this.qFS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153046);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.qFS.add(gVar);
                    }
                    AppMethodBeat.o(153046);
                    return 0;
                case 2:
                    eVar.qFT = aVar3.UbS.zl();
                    AppMethodBeat.o(153046);
                    return 0;
                default:
                    AppMethodBeat.o(153046);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153046);
            return -1;
        }
    }
}
