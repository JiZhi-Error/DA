package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dd extends a {
    public String KHi;
    public int KHj;
    public String KHk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149137);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHi != null) {
                aVar.e(1, this.KHi);
            }
            aVar.aM(2, this.KHj);
            if (this.KHk != null) {
                aVar.e(3, this.KHk);
            }
            AppMethodBeat.o(149137);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KHi != null ? g.a.a.b.b.a.f(1, this.KHi) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KHj);
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(3, this.KHk);
            }
            AppMethodBeat.o(149137);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149137);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dd ddVar = (dd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddVar.KHi = aVar3.UbS.readString();
                    AppMethodBeat.o(149137);
                    return 0;
                case 2:
                    ddVar.KHj = aVar3.UbS.zi();
                    AppMethodBeat.o(149137);
                    return 0;
                case 3:
                    ddVar.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(149137);
                    return 0;
                default:
                    AppMethodBeat.o(149137);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149137);
            return -1;
        }
    }
}
