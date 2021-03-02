package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cd extends a {
    public long addTime;
    public long lDC;
    public long msgId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43276);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.msgId);
            aVar.bb(2, this.lDC);
            aVar.bb(3, this.addTime);
            AppMethodBeat.o(43276);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.msgId) + 0 + g.a.a.b.b.a.r(2, this.lDC) + g.a.a.b.b.a.r(3, this.addTime);
            AppMethodBeat.o(43276);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43276);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdVar.msgId = aVar3.UbS.zl();
                    AppMethodBeat.o(43276);
                    return 0;
                case 2:
                    cdVar.lDC = aVar3.UbS.zl();
                    AppMethodBeat.o(43276);
                    return 0;
                case 3:
                    cdVar.addTime = aVar3.UbS.zl();
                    AppMethodBeat.o(43276);
                    return 0;
                default:
                    AppMethodBeat.o(43276);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43276);
            return -1;
        }
    }
}
