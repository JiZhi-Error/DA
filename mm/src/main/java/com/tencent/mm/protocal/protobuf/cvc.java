package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cvc extends a {
    public b MAz;
    public int dMO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(121105);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dMO);
            if (this.MAz != null) {
                aVar.c(2, this.MAz);
            }
            AppMethodBeat.o(121105);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dMO) + 0;
            if (this.MAz != null) {
                bu += g.a.a.b.b.a.b(2, this.MAz);
            }
            AppMethodBeat.o(121105);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(121105);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvc cvc = (cvc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvc.dMO = aVar3.UbS.zi();
                    AppMethodBeat.o(121105);
                    return 0;
                case 2:
                    cvc.MAz = aVar3.UbS.hPo();
                    AppMethodBeat.o(121105);
                    return 0;
                default:
                    AppMethodBeat.o(121105);
                    return -1;
            }
        } else {
            AppMethodBeat.o(121105);
            return -1;
        }
    }
}
