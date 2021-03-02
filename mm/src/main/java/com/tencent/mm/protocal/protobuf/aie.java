package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aie extends a {
    public boolean LrL;
    public boolean LrM;
    public String LrN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113998);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.LrL);
            aVar.cc(2, this.LrM);
            if (this.LrN != null) {
                aVar.e(3, this.LrN);
            }
            AppMethodBeat.o(113998);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1;
            if (this.LrN != null) {
                fS += g.a.a.b.b.a.f(3, this.LrN);
            }
            AppMethodBeat.o(113998);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113998);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aie aie = (aie) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aie.LrL = aVar3.UbS.yZ();
                    AppMethodBeat.o(113998);
                    return 0;
                case 2:
                    aie.LrM = aVar3.UbS.yZ();
                    AppMethodBeat.o(113998);
                    return 0;
                case 3:
                    aie.LrN = aVar3.UbS.readString();
                    AppMethodBeat.o(113998);
                    return 0;
                default:
                    AppMethodBeat.o(113998);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113998);
            return -1;
        }
    }
}
