package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ffb extends a {
    public int NAq;
    public boolean NAr;
    public boolean NAs;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123713);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NAq);
            aVar.cc(2, this.NAr);
            aVar.cc(3, this.NAs);
            AppMethodBeat.o(123713);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NAq) + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(123713);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123713);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffb ffb = (ffb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffb.NAq = aVar3.UbS.zi();
                    AppMethodBeat.o(123713);
                    return 0;
                case 2:
                    ffb.NAr = aVar3.UbS.yZ();
                    AppMethodBeat.o(123713);
                    return 0;
                case 3:
                    ffb.NAs = aVar3.UbS.yZ();
                    AppMethodBeat.o(123713);
                    return 0;
                default:
                    AppMethodBeat.o(123713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123713);
            return -1;
        }
    }
}
