package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ezr extends a {
    public int KLp;
    public long KMm;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32561);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            aVar.aM(2, this.KLp);
            aVar.bb(3, this.KMm);
            AppMethodBeat.o(32561);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.KLp) + g.a.a.b.b.a.r(3, this.KMm);
            AppMethodBeat.o(32561);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32561);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezr ezr = (ezr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezr.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(32561);
                    return 0;
                case 2:
                    ezr.KLp = aVar3.UbS.zi();
                    AppMethodBeat.o(32561);
                    return 0;
                case 3:
                    ezr.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(32561);
                    return 0;
                default:
                    AppMethodBeat.o(32561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32561);
            return -1;
        }
    }
}
