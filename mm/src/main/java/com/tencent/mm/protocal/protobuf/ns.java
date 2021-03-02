package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ns extends a {
    public String KTg;
    public int KTh;
    public String KTi;
    public int KTj;
    public int KTk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124415);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTg != null) {
                aVar.e(1, this.KTg);
            }
            aVar.aM(2, this.KTh);
            if (this.KTi != null) {
                aVar.e(3, this.KTi);
            }
            aVar.aM(4, this.KTj);
            aVar.aM(5, this.KTk);
            AppMethodBeat.o(124415);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KTg != null ? g.a.a.b.b.a.f(1, this.KTg) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KTh);
            if (this.KTi != null) {
                f2 += g.a.a.b.b.a.f(3, this.KTi);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KTj) + g.a.a.b.b.a.bu(5, this.KTk);
            AppMethodBeat.o(124415);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124415);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ns nsVar = (ns) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nsVar.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(124415);
                    return 0;
                case 2:
                    nsVar.KTh = aVar3.UbS.zi();
                    AppMethodBeat.o(124415);
                    return 0;
                case 3:
                    nsVar.KTi = aVar3.UbS.readString();
                    AppMethodBeat.o(124415);
                    return 0;
                case 4:
                    nsVar.KTj = aVar3.UbS.zi();
                    AppMethodBeat.o(124415);
                    return 0;
                case 5:
                    nsVar.KTk = aVar3.UbS.zi();
                    AppMethodBeat.o(124415);
                    return 0;
                default:
                    AppMethodBeat.o(124415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124415);
            return -1;
        }
    }
}
