package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dhx extends a {
    public int him;
    public String sTh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134251);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sTh == null) {
                b bVar = new b("Not all required fields were included: jsonData");
                AppMethodBeat.o(134251);
                throw bVar;
            }
            aVar.aM(1, this.him);
            if (this.sTh != null) {
                aVar.e(2, this.sTh);
            }
            AppMethodBeat.o(134251);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.him) + 0;
            if (this.sTh != null) {
                bu += g.a.a.b.b.a.f(2, this.sTh);
            }
            AppMethodBeat.o(134251);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.sTh == null) {
                b bVar2 = new b("Not all required fields were included: jsonData");
                AppMethodBeat.o(134251);
                throw bVar2;
            }
            AppMethodBeat.o(134251);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhx dhx = (dhx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dhx.him = aVar3.UbS.zi();
                    AppMethodBeat.o(134251);
                    return 0;
                case 2:
                    dhx.sTh = aVar3.UbS.readString();
                    AppMethodBeat.o(134251);
                    return 0;
                default:
                    AppMethodBeat.o(134251);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134251);
            return -1;
        }
    }
}
