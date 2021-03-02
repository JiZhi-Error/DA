package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bw.a {
    public long qGj;
    public long qGk;
    public String qGl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153058);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.qGj);
            aVar.bb(2, this.qGk);
            if (this.qGl != null) {
                aVar.e(3, this.qGl);
            }
            AppMethodBeat.o(153058);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.qGj) + 0 + g.a.a.b.b.a.r(2, this.qGk);
            if (this.qGl != null) {
                r += g.a.a.b.b.a.f(3, this.qGl);
            }
            AppMethodBeat.o(153058);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153058);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.qGj = aVar3.UbS.zl();
                    AppMethodBeat.o(153058);
                    return 0;
                case 2:
                    aVar4.qGk = aVar3.UbS.zl();
                    AppMethodBeat.o(153058);
                    return 0;
                case 3:
                    aVar4.qGl = aVar3.UbS.readString();
                    AppMethodBeat.o(153058);
                    return 0;
                default:
                    AppMethodBeat.o(153058);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153058);
            return -1;
        }
    }
}
