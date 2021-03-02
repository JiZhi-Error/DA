package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dnn extends a {
    public int MJT;
    public int MQH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117899);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MQH);
            aVar.aM(2, this.MJT);
            AppMethodBeat.o(117899);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MQH) + 0 + g.a.a.b.b.a.bu(2, this.MJT);
            AppMethodBeat.o(117899);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117899);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnn dnn = (dnn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnn.MQH = aVar3.UbS.zi();
                    AppMethodBeat.o(117899);
                    return 0;
                case 2:
                    dnn.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(117899);
                    return 0;
                default:
                    AppMethodBeat.o(117899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117899);
            return -1;
        }
    }
}
