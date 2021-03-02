package com.tencent.mm.plugin.festival.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class h extends a {
    public int AKh;
    public b Lqh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261974);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.AKh);
            if (this.Lqh != null) {
                aVar.c(2, this.Lqh);
            }
            AppMethodBeat.o(261974);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.AKh) + 0;
            if (this.Lqh != null) {
                bu += g.a.a.b.b.a.b(2, this.Lqh);
            }
            AppMethodBeat.o(261974);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261974);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.AKh = aVar3.UbS.zi();
                    AppMethodBeat.o(261974);
                    return 0;
                case 2:
                    hVar.Lqh = aVar3.UbS.hPo();
                    AppMethodBeat.o(261974);
                    return 0;
                default:
                    AppMethodBeat.o(261974);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261974);
            return -1;
        }
    }
}
