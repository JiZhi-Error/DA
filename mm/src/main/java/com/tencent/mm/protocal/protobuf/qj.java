package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class qj extends a {
    public b KXl;
    public b KXm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212266);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXl != null) {
                aVar.c(1, this.KXl);
            }
            if (this.KXm != null) {
                aVar.c(2, this.KXm);
            }
            AppMethodBeat.o(212266);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.KXl != null ? g.a.a.b.b.a.b(1, this.KXl) + 0 : 0;
            if (this.KXm != null) {
                b2 += g.a.a.b.b.a.b(2, this.KXm);
            }
            AppMethodBeat.o(212266);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212266);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qj qjVar = (qj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qjVar.KXl = aVar3.UbS.hPo();
                    AppMethodBeat.o(212266);
                    return 0;
                case 2:
                    qjVar.KXm = aVar3.UbS.hPo();
                    AppMethodBeat.o(212266);
                    return 0;
                default:
                    AppMethodBeat.o(212266);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212266);
            return -1;
        }
    }
}