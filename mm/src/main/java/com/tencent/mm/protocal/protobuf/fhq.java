package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class fhq extends a {
    public int Vjn;
    public b ybi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259375);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Vjn);
            if (this.ybi != null) {
                aVar.c(2, this.ybi);
            }
            AppMethodBeat.o(259375);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Vjn) + 0;
            if (this.ybi != null) {
                bu += g.a.a.b.b.a.b(2, this.ybi);
            }
            AppMethodBeat.o(259375);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259375);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhq fhq = (fhq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fhq.Vjn = aVar3.UbS.zi();
                    AppMethodBeat.o(259375);
                    return 0;
                case 2:
                    fhq.ybi = aVar3.UbS.hPo();
                    AppMethodBeat.o(259375);
                    return 0;
                default:
                    AppMethodBeat.o(259375);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259375);
            return -1;
        }
    }
}
