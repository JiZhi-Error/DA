package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class x extends a {
    public int GaE;
    public String GaI;
    public String Gbg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222846);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.GaI != null) {
                aVar.e(1, this.GaI);
            }
            if (this.Gbg != null) {
                aVar.e(2, this.Gbg);
            }
            aVar.aM(3, this.GaE);
            AppMethodBeat.o(222846);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.GaI != null ? g.a.a.b.b.a.f(1, this.GaI) + 0 : 0;
            if (this.Gbg != null) {
                f2 += g.a.a.b.b.a.f(2, this.Gbg);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.GaE);
            AppMethodBeat.o(222846);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222846);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.GaI = aVar3.UbS.readString();
                    AppMethodBeat.o(222846);
                    return 0;
                case 2:
                    xVar.Gbg = aVar3.UbS.readString();
                    AppMethodBeat.o(222846);
                    return 0;
                case 3:
                    xVar.GaE = aVar3.UbS.zi();
                    AppMethodBeat.o(222846);
                    return 0;
                default:
                    AppMethodBeat.o(222846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222846);
            return -1;
        }
    }
}
