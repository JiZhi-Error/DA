package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class gn extends a {
    public b KKm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32117);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKm == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Cookies");
                AppMethodBeat.o(32117);
                throw bVar;
            }
            if (this.KKm != null) {
                aVar.c(1, this.KKm);
            }
            AppMethodBeat.o(32117);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.KKm != null ? g.a.a.b.b.a.b(1, this.KKm) + 0 : 0;
            AppMethodBeat.o(32117);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKm == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Cookies");
                AppMethodBeat.o(32117);
                throw bVar2;
            }
            AppMethodBeat.o(32117);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gn gnVar = (gn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gnVar.KKm = aVar3.UbS.hPo();
                    AppMethodBeat.o(32117);
                    return 0;
                default:
                    AppMethodBeat.o(32117);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32117);
            return -1;
        }
    }
}
