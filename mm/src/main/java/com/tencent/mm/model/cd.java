package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cd extends a {
    public long hwQ;
    public String iFF;
    public int key;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143730);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.key);
            if (this.iFF != null) {
                aVar.e(2, this.iFF);
            }
            aVar.bb(3, this.hwQ);
            AppMethodBeat.o(143730);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.key) + 0;
            if (this.iFF != null) {
                bu += g.a.a.b.b.a.f(2, this.iFF);
            }
            int r = bu + g.a.a.b.b.a.r(3, this.hwQ);
            AppMethodBeat.o(143730);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143730);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdVar.key = aVar3.UbS.zi();
                    AppMethodBeat.o(143730);
                    return 0;
                case 2:
                    cdVar.iFF = aVar3.UbS.readString();
                    AppMethodBeat.o(143730);
                    return 0;
                case 3:
                    cdVar.hwQ = aVar3.UbS.zl();
                    AppMethodBeat.o(143730);
                    return 0;
                default:
                    AppMethodBeat.o(143730);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143730);
            return -1;
        }
    }
}
