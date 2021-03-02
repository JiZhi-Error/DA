package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class deu extends a {
    public long KVb;
    public long MJN;
    public int pVV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104829);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.pVV);
            aVar.bb(2, this.KVb);
            aVar.bb(3, this.MJN);
            AppMethodBeat.o(104829);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.pVV) + 0 + g.a.a.b.b.a.r(2, this.KVb) + g.a.a.b.b.a.r(3, this.MJN);
            AppMethodBeat.o(104829);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104829);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            deu deu = (deu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    deu.pVV = aVar3.UbS.zi();
                    AppMethodBeat.o(104829);
                    return 0;
                case 2:
                    deu.KVb = aVar3.UbS.zl();
                    AppMethodBeat.o(104829);
                    return 0;
                case 3:
                    deu.MJN = aVar3.UbS.zl();
                    AppMethodBeat.o(104829);
                    return 0;
                default:
                    AppMethodBeat.o(104829);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104829);
            return -1;
        }
    }
}
