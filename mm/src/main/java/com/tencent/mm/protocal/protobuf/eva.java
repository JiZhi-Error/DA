package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eva extends a {
    public boolean NsZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147783);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).cc(1, this.NsZ);
            AppMethodBeat.o(147783);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            AppMethodBeat.o(147783);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(147783);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            eva eva = (eva) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eva.NsZ = aVar2.UbS.yZ();
                    AppMethodBeat.o(147783);
                    return 0;
                default:
                    AppMethodBeat.o(147783);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147783);
            return -1;
        }
    }
}
