package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class drp extends a {
    public int MUj;
    public int Timestamp;
    public int him;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117906);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MUj);
            aVar.aM(2, this.Timestamp);
            aVar.aM(3, this.him);
            AppMethodBeat.o(117906);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MUj) + 0 + g.a.a.b.b.a.bu(2, this.Timestamp) + g.a.a.b.b.a.bu(3, this.him);
            AppMethodBeat.o(117906);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117906);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drp drp = (drp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drp.MUj = aVar3.UbS.zi();
                    AppMethodBeat.o(117906);
                    return 0;
                case 2:
                    drp.Timestamp = aVar3.UbS.zi();
                    AppMethodBeat.o(117906);
                    return 0;
                case 3:
                    drp.him = aVar3.UbS.zi();
                    AppMethodBeat.o(117906);
                    return 0;
                default:
                    AppMethodBeat.o(117906);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117906);
            return -1;
        }
    }
}
