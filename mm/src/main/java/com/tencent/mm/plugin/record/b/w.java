package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class w extends a {
    public b AqP;
    public String BHr;
    public String brand;
    public int eeA;
    public int id;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(27828);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            aVar.aM(2, this.status);
            if (this.BHr != null) {
                aVar.e(3, this.BHr);
            }
            if (this.brand != null) {
                aVar.e(4, this.brand);
            }
            if (this.AqP != null) {
                aVar.c(5, this.AqP);
            }
            aVar.aM(6, this.eeA);
            AppMethodBeat.o(27828);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.status);
            if (this.BHr != null) {
                bu += g.a.a.b.b.a.f(3, this.BHr);
            }
            if (this.brand != null) {
                bu += g.a.a.b.b.a.f(4, this.brand);
            }
            if (this.AqP != null) {
                bu += g.a.a.b.b.a.b(5, this.AqP);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.eeA);
            AppMethodBeat.o(27828);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(27828);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(27828);
                    return 0;
                case 2:
                    wVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(27828);
                    return 0;
                case 3:
                    wVar.BHr = aVar3.UbS.readString();
                    AppMethodBeat.o(27828);
                    return 0;
                case 4:
                    wVar.brand = aVar3.UbS.readString();
                    AppMethodBeat.o(27828);
                    return 0;
                case 5:
                    wVar.AqP = aVar3.UbS.hPo();
                    AppMethodBeat.o(27828);
                    return 0;
                case 6:
                    wVar.eeA = aVar3.UbS.zi();
                    AppMethodBeat.o(27828);
                    return 0;
                default:
                    AppMethodBeat.o(27828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(27828);
            return -1;
        }
    }
}
