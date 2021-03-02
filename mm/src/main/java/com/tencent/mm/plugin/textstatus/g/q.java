package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class q extends a {
    public String GaI;
    public int GaJ;
    public String GaN;
    public String Gas;
    public int Gaz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222839);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Gas != null) {
                aVar.e(1, this.Gas);
            }
            if (this.GaI != null) {
                aVar.e(2, this.GaI);
            }
            if (this.GaN != null) {
                aVar.e(3, this.GaN);
            }
            aVar.aM(4, this.GaJ);
            aVar.aM(5, this.Gaz);
            AppMethodBeat.o(222839);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Gas != null ? g.a.a.b.b.a.f(1, this.Gas) + 0 : 0;
            if (this.GaI != null) {
                f2 += g.a.a.b.b.a.f(2, this.GaI);
            }
            if (this.GaN != null) {
                f2 += g.a.a.b.b.a.f(3, this.GaN);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.GaJ) + g.a.a.b.b.a.bu(5, this.Gaz);
            AppMethodBeat.o(222839);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222839);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.Gas = aVar3.UbS.readString();
                    AppMethodBeat.o(222839);
                    return 0;
                case 2:
                    qVar.GaI = aVar3.UbS.readString();
                    AppMethodBeat.o(222839);
                    return 0;
                case 3:
                    qVar.GaN = aVar3.UbS.readString();
                    AppMethodBeat.o(222839);
                    return 0;
                case 4:
                    qVar.GaJ = aVar3.UbS.zi();
                    AppMethodBeat.o(222839);
                    return 0;
                case 5:
                    qVar.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(222839);
                    return 0;
                default:
                    AppMethodBeat.o(222839);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222839);
            return -1;
        }
    }
}
