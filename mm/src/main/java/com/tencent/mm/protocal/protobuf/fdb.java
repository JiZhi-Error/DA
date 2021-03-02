package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdb extends a {
    public int KHb;
    public int MqF;
    public int NyM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123703);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MqF);
            aVar.aM(2, this.KHb);
            aVar.aM(3, this.NyM);
            AppMethodBeat.o(123703);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MqF) + 0 + g.a.a.b.b.a.bu(2, this.KHb) + g.a.a.b.b.a.bu(3, this.NyM);
            AppMethodBeat.o(123703);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123703);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdb fdb = (fdb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdb.MqF = aVar3.UbS.zi();
                    AppMethodBeat.o(123703);
                    return 0;
                case 2:
                    fdb.KHb = aVar3.UbS.zi();
                    AppMethodBeat.o(123703);
                    return 0;
                case 3:
                    fdb.NyM = aVar3.UbS.zi();
                    AppMethodBeat.o(123703);
                    return 0;
                default:
                    AppMethodBeat.o(123703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123703);
            return -1;
        }
    }
}
