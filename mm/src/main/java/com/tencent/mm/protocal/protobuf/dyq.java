package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dyq extends a {
    public boolean MYd = false;
    public boolean MYe = false;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147779);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.MYd);
            aVar.cc(2, this.MYe);
            AppMethodBeat.o(147779);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1;
            AppMethodBeat.o(147779);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147779);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyq dyq = (dyq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyq.MYd = aVar3.UbS.yZ();
                    AppMethodBeat.o(147779);
                    return 0;
                case 2:
                    dyq.MYe = aVar3.UbS.yZ();
                    AppMethodBeat.o(147779);
                    return 0;
                default:
                    AppMethodBeat.o(147779);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147779);
            return -1;
        }
    }
}
