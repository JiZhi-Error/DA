package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eiz extends a {
    public LinkedList<Long> NiM = new LinkedList<>();

    public eiz() {
        AppMethodBeat.i(209820);
        AppMethodBeat.o(209820);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209821);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 3, this.NiM);
            AppMethodBeat.o(209821);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 3, this.NiM) + 0;
            AppMethodBeat.o(209821);
            return c2;
        } else if (i2 == 2) {
            this.NiM.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(209821);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            eiz eiz = (eiz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eiz.NiM.add(Long.valueOf(aVar2.UbS.zl()));
                    AppMethodBeat.o(209821);
                    return 0;
                default:
                    AppMethodBeat.o(209821);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209821);
            return -1;
        }
    }
}
