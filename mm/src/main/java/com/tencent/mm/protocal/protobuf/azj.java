package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class azj extends a {
    public int LJe;
    public int LJf;
    public b LJg;
    public String dkV;
    public String sessionId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196090);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dkV != null) {
                aVar.e(1, this.dkV);
            }
            if (this.sessionId != null) {
                aVar.e(2, this.sessionId);
            }
            aVar.aM(3, this.LJe);
            aVar.aM(4, this.LJf);
            if (this.LJg != null) {
                aVar.c(5, this.LJg);
            }
            AppMethodBeat.o(196090);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dkV != null ? g.a.a.b.b.a.f(1, this.dkV) + 0 : 0;
            if (this.sessionId != null) {
                f2 += g.a.a.b.b.a.f(2, this.sessionId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.LJe) + g.a.a.b.b.a.bu(4, this.LJf);
            if (this.LJg != null) {
                bu += g.a.a.b.b.a.b(5, this.LJg);
            }
            AppMethodBeat.o(196090);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196090);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azj azj = (azj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azj.dkV = aVar3.UbS.readString();
                    AppMethodBeat.o(196090);
                    return 0;
                case 2:
                    azj.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(196090);
                    return 0;
                case 3:
                    azj.LJe = aVar3.UbS.zi();
                    AppMethodBeat.o(196090);
                    return 0;
                case 4:
                    azj.LJf = aVar3.UbS.zi();
                    AppMethodBeat.o(196090);
                    return 0;
                case 5:
                    azj.LJg = aVar3.UbS.hPo();
                    AppMethodBeat.o(196090);
                    return 0;
                default:
                    AppMethodBeat.o(196090);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196090);
            return -1;
        }
    }
}
