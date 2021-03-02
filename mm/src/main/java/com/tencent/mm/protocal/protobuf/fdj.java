package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdj extends a {
    public boolean NyU;
    public boolean NyV;
    public int NyW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50120);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.NyU);
            aVar.cc(2, this.NyV);
            aVar.aM(3, this.NyW);
            AppMethodBeat.o(50120);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.NyW);
            AppMethodBeat.o(50120);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50120);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdj fdj = (fdj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdj.NyU = aVar3.UbS.yZ();
                    AppMethodBeat.o(50120);
                    return 0;
                case 2:
                    fdj.NyV = aVar3.UbS.yZ();
                    AppMethodBeat.o(50120);
                    return 0;
                case 3:
                    fdj.NyW = aVar3.UbS.zi();
                    AppMethodBeat.o(50120);
                    return 0;
                default:
                    AppMethodBeat.o(50120);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50120);
            return -1;
        }
    }
}
