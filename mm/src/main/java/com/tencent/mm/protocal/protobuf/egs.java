package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class egs extends a {
    public int NgD;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152711);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NgD);
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            AppMethodBeat.o(152711);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NgD) + 0;
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(2, this.UserName);
            }
            AppMethodBeat.o(152711);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152711);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egs egs = (egs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egs.NgD = aVar3.UbS.zi();
                    AppMethodBeat.o(152711);
                    return 0;
                case 2:
                    egs.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152711);
                    return 0;
                default:
                    AppMethodBeat.o(152711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152711);
            return -1;
        }
    }
}