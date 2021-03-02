package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dux extends a {
    public LinkedList<dea> qGN = new LinkedList<>();

    public dux() {
        AppMethodBeat.i(153297);
        AppMethodBeat.o(153297);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153298);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.qGN);
            AppMethodBeat.o(153298);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.qGN) + 0;
            AppMethodBeat.o(153298);
            return c2;
        } else if (i2 == 2) {
            this.qGN.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(153298);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            dux dux = (dux) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dea dea = new dea();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dea.populateBuilderWithField(aVar3, dea, a.getNextFieldNumber(aVar3))) {
                        }
                        dux.qGN.add(dea);
                    }
                    AppMethodBeat.o(153298);
                    return 0;
                default:
                    AppMethodBeat.o(153298);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153298);
            return -1;
        }
    }
}
