package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cay extends a {
    public b KOi;
    public b KOk;
    public b Mgr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32321);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KOk != null) {
                aVar.c(1, this.KOk);
            }
            if (this.KOi != null) {
                aVar.c(2, this.KOi);
            }
            if (this.Mgr != null) {
                aVar.c(3, this.Mgr);
            }
            AppMethodBeat.o(32321);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.KOk != null ? g.a.a.b.b.a.b(1, this.KOk) + 0 : 0;
            if (this.KOi != null) {
                b2 += g.a.a.b.b.a.b(2, this.KOi);
            }
            if (this.Mgr != null) {
                b2 += g.a.a.b.b.a.b(3, this.Mgr);
            }
            AppMethodBeat.o(32321);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32321);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cay cay = (cay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cay.KOk = aVar3.UbS.hPo();
                    AppMethodBeat.o(32321);
                    return 0;
                case 2:
                    cay.KOi = aVar3.UbS.hPo();
                    AppMethodBeat.o(32321);
                    return 0;
                case 3:
                    cay.Mgr = aVar3.UbS.hPo();
                    AppMethodBeat.o(32321);
                    return 0;
                default:
                    AppMethodBeat.o(32321);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32321);
            return -1;
        }
    }
}
