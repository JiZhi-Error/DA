package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class pf extends a {
    public b KVZ;
    public int KWa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124442);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KVZ != null) {
                aVar.c(1, this.KVZ);
            }
            aVar.aM(2, this.KWa);
            AppMethodBeat.o(124442);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.KVZ != null ? g.a.a.b.b.a.b(1, this.KVZ) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KWa);
            AppMethodBeat.o(124442);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124442);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pf pfVar = (pf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pfVar.KVZ = aVar3.UbS.hPo();
                    AppMethodBeat.o(124442);
                    return 0;
                case 2:
                    pfVar.KWa = aVar3.UbS.zi();
                    AppMethodBeat.o(124442);
                    return 0;
                default:
                    AppMethodBeat.o(124442);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124442);
            return -1;
        }
    }
}
