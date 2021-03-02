package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctz extends a {
    public int Mzm;
    public long Mzn;
    public long Mzo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117883);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mzm);
            aVar.bb(2, this.Mzn);
            aVar.bb(3, this.Mzo);
            AppMethodBeat.o(117883);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mzm) + 0 + g.a.a.b.b.a.r(2, this.Mzn) + g.a.a.b.b.a.r(3, this.Mzo);
            AppMethodBeat.o(117883);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117883);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctz ctz = (ctz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctz.Mzm = aVar3.UbS.zi();
                    AppMethodBeat.o(117883);
                    return 0;
                case 2:
                    ctz.Mzn = aVar3.UbS.zl();
                    AppMethodBeat.o(117883);
                    return 0;
                case 3:
                    ctz.Mzo = aVar3.UbS.zl();
                    AppMethodBeat.o(117883);
                    return 0;
                default:
                    AppMethodBeat.o(117883);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117883);
            return -1;
        }
    }
}
