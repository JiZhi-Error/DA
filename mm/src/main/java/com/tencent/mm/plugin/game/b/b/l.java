package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public String qHk;
    public int width;
    public String xve;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40879);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.qHk != null) {
                aVar.e(1, this.qHk);
            }
            if (this.xve != null) {
                aVar.e(2, this.xve);
            }
            aVar.aM(3, this.width);
            AppMethodBeat.o(40879);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.qHk != null ? g.a.a.b.b.a.f(1, this.qHk) + 0 : 0;
            if (this.xve != null) {
                f2 += g.a.a.b.b.a.f(2, this.xve);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.width);
            AppMethodBeat.o(40879);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40879);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.qHk = aVar3.UbS.readString();
                    AppMethodBeat.o(40879);
                    return 0;
                case 2:
                    lVar.xve = aVar3.UbS.readString();
                    AppMethodBeat.o(40879);
                    return 0;
                case 3:
                    lVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(40879);
                    return 0;
                default:
                    AppMethodBeat.o(40879);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40879);
            return -1;
        }
    }
}
