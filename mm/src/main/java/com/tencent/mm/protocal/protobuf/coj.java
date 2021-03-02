package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class coj extends a {
    public long MuD;
    public float MuE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209769);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.MuD);
            aVar.E(2, this.MuE);
            AppMethodBeat.o(209769);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.MuD) + 0 + g.a.a.b.b.a.fS(2) + 4;
            AppMethodBeat.o(209769);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209769);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coj coj = (coj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coj.MuD = aVar3.UbS.zl();
                    AppMethodBeat.o(209769);
                    return 0;
                case 2:
                    coj.MuE = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209769);
                    return 0;
                default:
                    AppMethodBeat.o(209769);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209769);
            return -1;
        }
    }
}
