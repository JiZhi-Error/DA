package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dy extends a {
    public boolean KHU;
    public String KHV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123538);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KHU);
            if (this.KHV != null) {
                aVar.e(2, this.KHV);
            }
            AppMethodBeat.o(123538);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.KHV != null) {
                fS += g.a.a.b.b.a.f(2, this.KHV);
            }
            AppMethodBeat.o(123538);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123538);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dy dyVar = (dy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyVar.KHU = aVar3.UbS.yZ();
                    AppMethodBeat.o(123538);
                    return 0;
                case 2:
                    dyVar.KHV = aVar3.UbS.readString();
                    AppMethodBeat.o(123538);
                    return 0;
                default:
                    AppMethodBeat.o(123538);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123538);
            return -1;
        }
    }
}
