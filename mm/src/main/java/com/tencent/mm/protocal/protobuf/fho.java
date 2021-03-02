package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fho extends a {
    public long VjX;
    public boolean VjY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(261901);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.VjX);
            aVar.cc(2, this.VjY);
            AppMethodBeat.o(261901);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.VjX) + 0 + g.a.a.b.b.a.fS(2) + 1;
            AppMethodBeat.o(261901);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(261901);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fho fho = (fho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fho.VjX = aVar3.UbS.zl();
                    AppMethodBeat.o(261901);
                    return 0;
                case 2:
                    fho.VjY = aVar3.UbS.yZ();
                    AppMethodBeat.o(261901);
                    return 0;
                default:
                    AppMethodBeat.o(261901);
                    return -1;
            }
        } else {
            AppMethodBeat.o(261901);
            return -1;
        }
    }
}
