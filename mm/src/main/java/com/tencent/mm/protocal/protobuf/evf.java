package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class evf extends a {
    public int EX;
    public b LrK;
    public String uuid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147789);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.EX);
            if (this.uuid != null) {
                aVar.e(2, this.uuid);
            }
            if (this.LrK != null) {
                aVar.c(3, this.LrK);
            }
            AppMethodBeat.o(147789);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.EX) + 0;
            if (this.uuid != null) {
                bu += g.a.a.b.b.a.f(2, this.uuid);
            }
            if (this.LrK != null) {
                bu += g.a.a.b.b.a.b(3, this.LrK);
            }
            AppMethodBeat.o(147789);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147789);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evf evf = (evf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evf.EX = aVar3.UbS.zi();
                    AppMethodBeat.o(147789);
                    return 0;
                case 2:
                    evf.uuid = aVar3.UbS.readString();
                    AppMethodBeat.o(147789);
                    return 0;
                case 3:
                    evf.LrK = aVar3.UbS.hPo();
                    AppMethodBeat.o(147789);
                    return 0;
                default:
                    AppMethodBeat.o(147789);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147789);
            return -1;
        }
    }
}
