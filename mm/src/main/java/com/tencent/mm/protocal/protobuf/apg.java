package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class apg extends a {
    public b LBp;
    public int cmdId;
    public String qwG;
    public int retCode;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168939);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.cmdId);
            aVar.aM(2, this.retCode);
            if (this.qwG != null) {
                aVar.e(3, this.qwG);
            }
            if (this.LBp != null) {
                aVar.c(4, this.LBp);
            }
            AppMethodBeat.o(168939);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.cmdId) + 0 + g.a.a.b.b.a.bu(2, this.retCode);
            if (this.qwG != null) {
                bu += g.a.a.b.b.a.f(3, this.qwG);
            }
            if (this.LBp != null) {
                bu += g.a.a.b.b.a.b(4, this.LBp);
            }
            AppMethodBeat.o(168939);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168939);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apg apg = (apg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apg.cmdId = aVar3.UbS.zi();
                    AppMethodBeat.o(168939);
                    return 0;
                case 2:
                    apg.retCode = aVar3.UbS.zi();
                    AppMethodBeat.o(168939);
                    return 0;
                case 3:
                    apg.qwG = aVar3.UbS.readString();
                    AppMethodBeat.o(168939);
                    return 0;
                case 4:
                    apg.LBp = aVar3.UbS.hPo();
                    AppMethodBeat.o(168939);
                    return 0;
                default:
                    AppMethodBeat.o(168939);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168939);
            return -1;
        }
    }
}
