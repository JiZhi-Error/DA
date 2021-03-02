package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class qx extends a {
    public b KXL;
    public b KXM;
    public int port;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133158);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            aVar.aM(2, this.port);
            if (this.KXL != null) {
                aVar.c(3, this.KXL);
            }
            if (this.KXM != null) {
                aVar.c(4, this.KXM);
            }
            AppMethodBeat.o(133158);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.port);
            if (this.KXL != null) {
                bu += g.a.a.b.b.a.b(3, this.KXL);
            }
            if (this.KXM != null) {
                bu += g.a.a.b.b.a.b(4, this.KXM);
            }
            AppMethodBeat.o(133158);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133158);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qx qxVar = (qx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qxVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(133158);
                    return 0;
                case 2:
                    qxVar.port = aVar3.UbS.zi();
                    AppMethodBeat.o(133158);
                    return 0;
                case 3:
                    qxVar.KXL = aVar3.UbS.hPo();
                    AppMethodBeat.o(133158);
                    return 0;
                case 4:
                    qxVar.KXM = aVar3.UbS.hPo();
                    AppMethodBeat.o(133158);
                    return 0;
                default:
                    AppMethodBeat.o(133158);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133158);
            return -1;
        }
    }
}
