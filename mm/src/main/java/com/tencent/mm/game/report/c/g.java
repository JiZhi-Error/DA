package com.tencent.mm.game.report.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class g extends a {
    public String hiq;
    public boolean hir;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(190329);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hiq != null) {
                aVar.e(1, this.hiq);
            }
            aVar.bb(2, this.seq);
            aVar.cc(3, this.hir);
            AppMethodBeat.o(190329);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.hiq != null ? g.a.a.b.b.a.f(1, this.hiq) + 0 : 0) + g.a.a.b.b.a.r(2, this.seq) + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(190329);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(190329);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.hiq = aVar3.UbS.readString();
                    AppMethodBeat.o(190329);
                    return 0;
                case 2:
                    gVar.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(190329);
                    return 0;
                case 3:
                    gVar.hir = aVar3.UbS.yZ();
                    AppMethodBeat.o(190329);
                    return 0;
                default:
                    AppMethodBeat.o(190329);
                    return -1;
            }
        } else {
            AppMethodBeat.o(190329);
            return -1;
        }
    }
}
