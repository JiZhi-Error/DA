package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public boolean qHd;
    public String qHe;
    public String qHf;
    public String qHg;
    public int qHh;
    public boolean qHi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153072);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.qHd);
            if (this.qHe != null) {
                aVar.e(2, this.qHe);
            }
            if (this.qHf != null) {
                aVar.e(3, this.qHf);
            }
            if (this.qHg != null) {
                aVar.e(4, this.qHg);
            }
            aVar.aM(5, this.qHh);
            aVar.cc(6, this.qHi);
            AppMethodBeat.o(153072);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.qHe != null) {
                fS += g.a.a.b.b.a.f(2, this.qHe);
            }
            if (this.qHf != null) {
                fS += g.a.a.b.b.a.f(3, this.qHf);
            }
            if (this.qHg != null) {
                fS += g.a.a.b.b.a.f(4, this.qHg);
            }
            int bu = fS + g.a.a.b.b.a.bu(5, this.qHh) + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(153072);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153072);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.qHd = aVar3.UbS.yZ();
                    AppMethodBeat.o(153072);
                    return 0;
                case 2:
                    lVar.qHe = aVar3.UbS.readString();
                    AppMethodBeat.o(153072);
                    return 0;
                case 3:
                    lVar.qHf = aVar3.UbS.readString();
                    AppMethodBeat.o(153072);
                    return 0;
                case 4:
                    lVar.qHg = aVar3.UbS.readString();
                    AppMethodBeat.o(153072);
                    return 0;
                case 5:
                    lVar.qHh = aVar3.UbS.zi();
                    AppMethodBeat.o(153072);
                    return 0;
                case 6:
                    lVar.qHi = aVar3.UbS.yZ();
                    AppMethodBeat.o(153072);
                    return 0;
                default:
                    AppMethodBeat.o(153072);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153072);
            return -1;
        }
    }
}
