package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class n extends a {
    public String Bah;
    public int cSx;
    public String dNI;
    public String name;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91282);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.Bah != null) {
                aVar.e(3, this.Bah);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.aM(5, this.cSx);
            AppMethodBeat.o(91282);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.Bah != null) {
                f2 += g.a.a.b.b.a.f(3, this.Bah);
            }
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(4, this.username);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.cSx);
            AppMethodBeat.o(91282);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91282);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(91282);
                    return 0;
                case 2:
                    nVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91282);
                    return 0;
                case 3:
                    nVar.Bah = aVar3.UbS.readString();
                    AppMethodBeat.o(91282);
                    return 0;
                case 4:
                    nVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(91282);
                    return 0;
                case 5:
                    nVar.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(91282);
                    return 0;
                default:
                    AppMethodBeat.o(91282);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91282);
            return -1;
        }
    }
}
