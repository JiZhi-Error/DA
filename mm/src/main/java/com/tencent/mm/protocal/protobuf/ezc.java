package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ezc extends a {
    public LinkedList<Integer> NvD = new LinkedList<>();
    public boolean NvE;

    public ezc() {
        AppMethodBeat.i(32543);
        AppMethodBeat.o(32543);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32544);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 2, this.NvD);
            aVar.cc(2, this.NvE);
            AppMethodBeat.o(32544);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 2, this.NvD) + 0 + g.a.a.b.b.a.fS(2) + 1;
            AppMethodBeat.o(32544);
            return c2;
        } else if (i2 == 2) {
            this.NvD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32544);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezc ezc = (ezc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezc.NvD.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(32544);
                    return 0;
                case 2:
                    ezc.NvE = aVar3.UbS.yZ();
                    AppMethodBeat.o(32544);
                    return 0;
                default:
                    AppMethodBeat.o(32544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32544);
            return -1;
        }
    }
}
