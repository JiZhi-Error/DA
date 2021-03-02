package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class akm extends a {
    public LinkedList<akn> Ltx = new LinkedList<>();

    public akm() {
        AppMethodBeat.i(215271);
        AppMethodBeat.o(215271);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(215272);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.Ltx);
            AppMethodBeat.o(215272);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Ltx) + 0;
            AppMethodBeat.o(215272);
            return c2;
        } else if (i2 == 2) {
            this.Ltx.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(215272);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            akm akm = (akm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        akn akn = new akn();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = akn.populateBuilderWithField(aVar3, akn, a.getNextFieldNumber(aVar3))) {
                        }
                        akm.Ltx.add(akn);
                    }
                    AppMethodBeat.o(215272);
                    return 0;
                default:
                    AppMethodBeat.o(215272);
                    return -1;
            }
        } else {
            AppMethodBeat.o(215272);
            return -1;
        }
    }
}
