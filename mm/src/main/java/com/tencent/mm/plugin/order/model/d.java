package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public String AON;
    public int month;
    public int year;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91260);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.year);
            aVar.aM(2, this.month);
            if (this.AON != null) {
                aVar.e(3, this.AON);
            }
            AppMethodBeat.o(91260);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.year) + 0 + g.a.a.b.b.a.bu(2, this.month);
            if (this.AON != null) {
                bu += g.a.a.b.b.a.f(3, this.AON);
            }
            AppMethodBeat.o(91260);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91260);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.year = aVar3.UbS.zi();
                    AppMethodBeat.o(91260);
                    return 0;
                case 2:
                    dVar.month = aVar3.UbS.zi();
                    AppMethodBeat.o(91260);
                    return 0;
                case 3:
                    dVar.AON = aVar3.UbS.readString();
                    AppMethodBeat.o(91260);
                    return 0;
                default:
                    AppMethodBeat.o(91260);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91260);
            return -1;
        }
    }
}
