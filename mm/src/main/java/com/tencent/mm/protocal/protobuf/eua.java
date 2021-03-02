package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eua extends a {
    public LinkedList<etz> Nru = new LinkedList<>();

    public eua() {
        AppMethodBeat.i(115894);
        AppMethodBeat.o(115894);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115895);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.Nru);
            AppMethodBeat.o(115895);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Nru) + 0;
            AppMethodBeat.o(115895);
            return c2;
        } else if (i2 == 2) {
            this.Nru.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(115895);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            eua eua = (eua) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        etz etz = new etz();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = etz.populateBuilderWithField(aVar3, etz, a.getNextFieldNumber(aVar3))) {
                        }
                        eua.Nru.add(etz);
                    }
                    AppMethodBeat.o(115895);
                    return 0;
                default:
                    AppMethodBeat.o(115895);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115895);
            return -1;
        }
    }
}
