package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public int qGD;
    public String xuH;
    public String xuI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40867);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xuH != null) {
                aVar.e(1, this.xuH);
            }
            if (this.xuI != null) {
                aVar.e(2, this.xuI);
            }
            aVar.aM(3, this.qGD);
            AppMethodBeat.o(40867);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xuH != null ? g.a.a.b.b.a.f(1, this.xuH) + 0 : 0;
            if (this.xuI != null) {
                f2 += g.a.a.b.b.a.f(2, this.xuI);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.qGD);
            AppMethodBeat.o(40867);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40867);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.xuH = aVar3.UbS.readString();
                    AppMethodBeat.o(40867);
                    return 0;
                case 2:
                    dVar.xuI = aVar3.UbS.readString();
                    AppMethodBeat.o(40867);
                    return 0;
                case 3:
                    dVar.qGD = aVar3.UbS.zi();
                    AppMethodBeat.o(40867);
                    return 0;
                default:
                    AppMethodBeat.o(40867);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40867);
            return -1;
        }
    }
}