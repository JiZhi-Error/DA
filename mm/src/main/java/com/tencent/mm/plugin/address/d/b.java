package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public int id;
    public String ktg;
    public String kth;
    public String kti;
    public String ktj;
    public String ktk;
    public String ktl;
    public String ktm;
    public String ktn;
    public String kto;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(20827);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            if (this.ktg != null) {
                aVar.e(2, this.ktg);
            }
            if (this.kth != null) {
                aVar.e(3, this.kth);
            }
            if (this.kti != null) {
                aVar.e(4, this.kti);
            }
            if (this.ktj != null) {
                aVar.e(5, this.ktj);
            }
            if (this.ktk != null) {
                aVar.e(6, this.ktk);
            }
            if (this.ktl != null) {
                aVar.e(7, this.ktl);
            }
            if (this.ktm != null) {
                aVar.e(8, this.ktm);
            }
            if (this.ktn != null) {
                aVar.e(9, this.ktn);
            }
            if (this.kto != null) {
                aVar.e(10, this.kto);
            }
            AppMethodBeat.o(20827);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.ktg != null) {
                bu += g.a.a.b.b.a.f(2, this.ktg);
            }
            if (this.kth != null) {
                bu += g.a.a.b.b.a.f(3, this.kth);
            }
            if (this.kti != null) {
                bu += g.a.a.b.b.a.f(4, this.kti);
            }
            if (this.ktj != null) {
                bu += g.a.a.b.b.a.f(5, this.ktj);
            }
            if (this.ktk != null) {
                bu += g.a.a.b.b.a.f(6, this.ktk);
            }
            if (this.ktl != null) {
                bu += g.a.a.b.b.a.f(7, this.ktl);
            }
            if (this.ktm != null) {
                bu += g.a.a.b.b.a.f(8, this.ktm);
            }
            if (this.ktn != null) {
                bu += g.a.a.b.b.a.f(9, this.ktn);
            }
            if (this.kto != null) {
                bu += g.a.a.b.b.a.f(10, this.kto);
            }
            AppMethodBeat.o(20827);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(20827);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(20827);
                    return 0;
                case 2:
                    bVar.ktg = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 3:
                    bVar.kth = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 4:
                    bVar.kti = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 5:
                    bVar.ktj = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 6:
                    bVar.ktk = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 7:
                    bVar.ktl = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 8:
                    bVar.ktm = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 9:
                    bVar.ktn = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                case 10:
                    bVar.kto = aVar3.UbS.readString();
                    AppMethodBeat.o(20827);
                    return 0;
                default:
                    AppMethodBeat.o(20827);
                    return -1;
            }
        } else {
            AppMethodBeat.o(20827);
            return -1;
        }
    }
}
