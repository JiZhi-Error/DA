package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class d extends a {
    public int DhD;
    public b KAH;
    public int KAI;
    public int KAy;
    public int count;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143943);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KAH == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: value");
                AppMethodBeat.o(143943);
                throw bVar;
            }
            aVar.aM(1, this.KAy);
            if (this.KAH != null) {
                aVar.c(2, this.KAH);
            }
            aVar.aM(3, this.KAI);
            aVar.aM(4, this.DhD);
            aVar.aM(5, this.count);
            AppMethodBeat.o(143943);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAy) + 0;
            if (this.KAH != null) {
                bu += g.a.a.b.b.a.b(2, this.KAH);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KAI) + g.a.a.b.b.a.bu(4, this.DhD) + g.a.a.b.b.a.bu(5, this.count);
            AppMethodBeat.o(143943);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KAH == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: value");
                AppMethodBeat.o(143943);
                throw bVar2;
            }
            AppMethodBeat.o(143943);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.KAy = aVar3.UbS.zi();
                    AppMethodBeat.o(143943);
                    return 0;
                case 2:
                    dVar.KAH = aVar3.UbS.hPo();
                    AppMethodBeat.o(143943);
                    return 0;
                case 3:
                    dVar.KAI = aVar3.UbS.zi();
                    AppMethodBeat.o(143943);
                    return 0;
                case 4:
                    dVar.DhD = aVar3.UbS.zi();
                    AppMethodBeat.o(143943);
                    return 0;
                case 5:
                    dVar.count = aVar3.UbS.zi();
                    AppMethodBeat.o(143943);
                    return 0;
                default:
                    AppMethodBeat.o(143943);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143943);
            return -1;
        }
    }
}
