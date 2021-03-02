package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class d extends a {
    public boolean Cyc;
    public String Cyk;
    public boolean Cyl;
    public boolean Cym;
    public int hii;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143831);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Cyk == null) {
                b bVar = new b("Not all required fields were included: Value");
                AppMethodBeat.o(143831);
                throw bVar;
            }
            aVar.aM(1, this.hii);
            if (this.Cyk != null) {
                aVar.e(2, this.Cyk);
            }
            aVar.cc(3, this.Cyl);
            aVar.cc(4, this.Cyc);
            aVar.aM(5, this.oUv);
            aVar.cc(6, this.Cym);
            AppMethodBeat.o(143831);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.hii) + 0;
            if (this.Cyk != null) {
                bu += g.a.a.b.b.a.f(2, this.Cyk);
            }
            int fS = bu + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.oUv) + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(143831);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Cyk == null) {
                b bVar2 = new b("Not all required fields were included: Value");
                AppMethodBeat.o(143831);
                throw bVar2;
            }
            AppMethodBeat.o(143831);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.hii = aVar3.UbS.zi();
                    AppMethodBeat.o(143831);
                    return 0;
                case 2:
                    dVar.Cyk = aVar3.UbS.readString();
                    AppMethodBeat.o(143831);
                    return 0;
                case 3:
                    dVar.Cyl = aVar3.UbS.yZ();
                    AppMethodBeat.o(143831);
                    return 0;
                case 4:
                    dVar.Cyc = aVar3.UbS.yZ();
                    AppMethodBeat.o(143831);
                    return 0;
                case 5:
                    dVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(143831);
                    return 0;
                case 6:
                    dVar.Cym = aVar3.UbS.yZ();
                    AppMethodBeat.o(143831);
                    return 0;
                default:
                    AppMethodBeat.o(143831);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143831);
            return -1;
        }
    }
}
