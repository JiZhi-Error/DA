package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public String Gal;
    public String Gam;
    public String Gan;
    public String Gao;
    public String Gap;
    public String dST;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222819);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Gal != null) {
                aVar.e(1, this.Gal);
            }
            if (this.Gam != null) {
                aVar.e(2, this.Gam);
            }
            if (this.Gan != null) {
                aVar.e(3, this.Gan);
            }
            if (this.dST != null) {
                aVar.e(4, this.dST);
            }
            if (this.Gao != null) {
                aVar.e(5, this.Gao);
            }
            if (this.Gap != null) {
                aVar.e(6, this.Gap);
            }
            AppMethodBeat.o(222819);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Gal != null ? g.a.a.b.b.a.f(1, this.Gal) + 0 : 0;
            if (this.Gam != null) {
                f2 += g.a.a.b.b.a.f(2, this.Gam);
            }
            if (this.Gan != null) {
                f2 += g.a.a.b.b.a.f(3, this.Gan);
            }
            if (this.dST != null) {
                f2 += g.a.a.b.b.a.f(4, this.dST);
            }
            if (this.Gao != null) {
                f2 += g.a.a.b.b.a.f(5, this.Gao);
            }
            if (this.Gap != null) {
                f2 += g.a.a.b.b.a.f(6, this.Gap);
            }
            AppMethodBeat.o(222819);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222819);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.Gal = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                case 2:
                    bVar.Gam = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                case 3:
                    bVar.Gan = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                case 4:
                    bVar.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                case 5:
                    bVar.Gao = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                case 6:
                    bVar.Gap = aVar3.UbS.readString();
                    AppMethodBeat.o(222819);
                    return 0;
                default:
                    AppMethodBeat.o(222819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222819);
            return -1;
        }
    }
}
