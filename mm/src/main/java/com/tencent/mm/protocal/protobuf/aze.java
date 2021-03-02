package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aze extends a {
    public long LIV;
    public int dYx;
    public String objectNonceId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209611);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LIV);
            aVar.aM(2, this.dYx);
            if (this.objectNonceId != null) {
                aVar.e(3, this.objectNonceId);
            }
            AppMethodBeat.o(209611);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LIV) + 0 + g.a.a.b.b.a.bu(2, this.dYx);
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(3, this.objectNonceId);
            }
            AppMethodBeat.o(209611);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209611);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aze aze = (aze) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aze.LIV = aVar3.UbS.zl();
                    AppMethodBeat.o(209611);
                    return 0;
                case 2:
                    aze.dYx = aVar3.UbS.zi();
                    AppMethodBeat.o(209611);
                    return 0;
                case 3:
                    aze.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209611);
                    return 0;
                default:
                    AppMethodBeat.o(209611);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209611);
            return -1;
        }
    }
}
