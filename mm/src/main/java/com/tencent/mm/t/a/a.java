package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bw.a {
    public long gTg;
    public String gTh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194673);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.gTg);
            if (this.gTh != null) {
                aVar.e(2, this.gTh);
            }
            AppMethodBeat.o(194673);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.gTg) + 0;
            if (this.gTh != null) {
                r += g.a.a.b.b.a.f(2, this.gTh);
            }
            AppMethodBeat.o(194673);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194673);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.gTg = aVar3.UbS.zl();
                    AppMethodBeat.o(194673);
                    return 0;
                case 2:
                    aVar4.gTh = aVar3.UbS.readString();
                    AppMethodBeat.o(194673);
                    return 0;
                default:
                    AppMethodBeat.o(194673);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194673);
            return -1;
        }
    }
}
