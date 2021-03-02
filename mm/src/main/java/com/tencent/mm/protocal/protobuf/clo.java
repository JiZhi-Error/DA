package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class clo extends a {
    public int MqO;
    public int MqP;
    public int MqQ;
    public int MqR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169923);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MqO);
            aVar.aM(2, this.MqP);
            aVar.aM(3, this.MqQ);
            aVar.aM(4, this.MqR);
            AppMethodBeat.o(169923);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MqO) + 0 + g.a.a.b.b.a.bu(2, this.MqP) + g.a.a.b.b.a.bu(3, this.MqQ) + g.a.a.b.b.a.bu(4, this.MqR);
            AppMethodBeat.o(169923);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169923);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clo clo = (clo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clo.MqO = aVar3.UbS.zi();
                    AppMethodBeat.o(169923);
                    return 0;
                case 2:
                    clo.MqP = aVar3.UbS.zi();
                    AppMethodBeat.o(169923);
                    return 0;
                case 3:
                    clo.MqQ = aVar3.UbS.zi();
                    AppMethodBeat.o(169923);
                    return 0;
                case 4:
                    clo.MqR = aVar3.UbS.zi();
                    AppMethodBeat.o(169923);
                    return 0;
                default:
                    AppMethodBeat.o(169923);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169923);
            return -1;
        }
    }
}
