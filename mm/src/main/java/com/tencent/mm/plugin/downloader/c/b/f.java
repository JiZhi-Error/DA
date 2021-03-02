package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class f extends a {
    public LinkedList<p> qGN = new LinkedList<>();
    public int qGO;

    public f() {
        AppMethodBeat.i(153065);
        AppMethodBeat.o(153065);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153066);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(4, 8, this.qGN);
            aVar.aM(5, this.qGO);
            AppMethodBeat.o(153066);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(4, 8, this.qGN) + 0 + g.a.a.b.b.a.bu(5, this.qGO);
            AppMethodBeat.o(153066);
            return c2;
        } else if (i2 == 2) {
            this.qGN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153066);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        p pVar = new p();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pVar.populateBuilderWithField(aVar4, pVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.qGN.add(pVar);
                    }
                    AppMethodBeat.o(153066);
                    return 0;
                case 5:
                    fVar.qGO = aVar3.UbS.zi();
                    AppMethodBeat.o(153066);
                    return 0;
                default:
                    AppMethodBeat.o(153066);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153066);
            return -1;
        }
    }
}
