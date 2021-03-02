package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ezi extends a {
    public long KMm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32551);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).bb(1, this.KMm);
            AppMethodBeat.o(32551);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KMm) + 0;
            AppMethodBeat.o(32551);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(32551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            ezi ezi = (ezi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezi.KMm = aVar2.UbS.zl();
                    AppMethodBeat.o(32551);
                    return 0;
                default:
                    AppMethodBeat.o(32551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32551);
            return -1;
        }
    }
}
