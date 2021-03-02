package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class i extends a {
    public int gGn;
    public String yUG;
    public String yUH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91251);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.gGn);
            if (this.yUG != null) {
                aVar.e(2, this.yUG);
            }
            if (this.yUH != null) {
                aVar.e(3, this.yUH);
            }
            AppMethodBeat.o(91251);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.gGn) + 0;
            if (this.yUG != null) {
                bu += g.a.a.b.b.a.f(2, this.yUG);
            }
            if (this.yUH != null) {
                bu += g.a.a.b.b.a.f(3, this.yUH);
            }
            AppMethodBeat.o(91251);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91251);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.gGn = aVar3.UbS.zi();
                    AppMethodBeat.o(91251);
                    return 0;
                case 2:
                    iVar.yUG = aVar3.UbS.readString();
                    AppMethodBeat.o(91251);
                    return 0;
                case 3:
                    iVar.yUH = aVar3.UbS.readString();
                    AppMethodBeat.o(91251);
                    return 0;
                default:
                    AppMethodBeat.o(91251);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91251);
            return -1;
        }
    }
}
