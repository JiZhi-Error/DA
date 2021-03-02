package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public int Cya;
    public int Cyb;
    public boolean Cyc;
    public int ID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143818);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.ID);
            aVar.aM(2, this.Cya);
            aVar.aM(3, this.Cyb);
            aVar.cc(4, this.Cyc);
            AppMethodBeat.o(143818);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ID) + 0 + g.a.a.b.b.a.bu(2, this.Cya) + g.a.a.b.b.a.bu(3, this.Cyb) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(143818);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143818);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.ID = aVar3.UbS.zi();
                    AppMethodBeat.o(143818);
                    return 0;
                case 2:
                    bVar.Cya = aVar3.UbS.zi();
                    AppMethodBeat.o(143818);
                    return 0;
                case 3:
                    bVar.Cyb = aVar3.UbS.zi();
                    AppMethodBeat.o(143818);
                    return 0;
                case 4:
                    bVar.Cyc = aVar3.UbS.yZ();
                    AppMethodBeat.o(143818);
                    return 0;
                default:
                    AppMethodBeat.o(143818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143818);
            return -1;
        }
    }
}
