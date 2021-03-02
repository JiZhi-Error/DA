package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class g extends a {
    public String oTx;
    public int oTy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22107);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oTx == null) {
                b bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22107);
                throw bVar;
            }
            if (this.oTx != null) {
                aVar.e(1, this.oTx);
            }
            aVar.aM(2, this.oTy);
            AppMethodBeat.o(22107);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.oTx != null ? g.a.a.b.b.a.f(1, this.oTx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTy);
            AppMethodBeat.o(22107);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTx == null) {
                b bVar2 = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22107);
                throw bVar2;
            }
            AppMethodBeat.o(22107);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.oTx = aVar3.UbS.readString();
                    AppMethodBeat.o(22107);
                    return 0;
                case 2:
                    gVar.oTy = aVar3.UbS.zi();
                    AppMethodBeat.o(22107);
                    return 0;
                default:
                    AppMethodBeat.o(22107);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22107);
            return -1;
        }
    }
}
