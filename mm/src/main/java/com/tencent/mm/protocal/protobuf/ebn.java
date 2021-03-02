package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ebn extends a {
    public LinkedList<Long> Nbk = new LinkedList<>();
    public String Nbl;

    public ebn() {
        AppMethodBeat.i(192790);
        AppMethodBeat.o(192790);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192791);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 3, this.Nbk);
            if (this.Nbl != null) {
                aVar.e(2, this.Nbl);
            }
            AppMethodBeat.o(192791);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 3, this.Nbk) + 0;
            if (this.Nbl != null) {
                c2 += g.a.a.b.b.a.f(2, this.Nbl);
            }
            AppMethodBeat.o(192791);
            return c2;
        } else if (i2 == 2) {
            this.Nbk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192791);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebn ebn = (ebn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebn.Nbk.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(192791);
                    return 0;
                case 2:
                    ebn.Nbl = aVar3.UbS.readString();
                    AppMethodBeat.o(192791);
                    return 0;
                default:
                    AppMethodBeat.o(192791);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192791);
            return -1;
        }
    }
}
