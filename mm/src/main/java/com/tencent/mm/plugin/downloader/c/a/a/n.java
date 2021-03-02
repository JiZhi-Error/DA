package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class n extends a {
    public int qGg;
    public boolean qGh;
    public long qGi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153056);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.qGg);
            aVar.cc(2, this.qGh);
            aVar.bb(3, this.qGi);
            AppMethodBeat.o(153056);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.qGg) + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.r(3, this.qGi);
            AppMethodBeat.o(153056);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153056);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.qGg = aVar3.UbS.zi();
                    AppMethodBeat.o(153056);
                    return 0;
                case 2:
                    nVar.qGh = aVar3.UbS.yZ();
                    AppMethodBeat.o(153056);
                    return 0;
                case 3:
                    nVar.qGi = aVar3.UbS.zl();
                    AppMethodBeat.o(153056);
                    return 0;
                default:
                    AppMethodBeat.o(153056);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153056);
            return -1;
        }
    }
}
