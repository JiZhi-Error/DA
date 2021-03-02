package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cgu extends a {
    public String Mmb;
    public int Mmc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32335);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mmb != null) {
                aVar.e(1, this.Mmb);
            }
            aVar.aM(2, this.Mmc);
            AppMethodBeat.o(32335);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mmb != null ? g.a.a.b.b.a.f(1, this.Mmb) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Mmc);
            AppMethodBeat.o(32335);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32335);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgu cgu = (cgu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgu.Mmb = aVar3.UbS.readString();
                    AppMethodBeat.o(32335);
                    return 0;
                case 2:
                    cgu.Mmc = aVar3.UbS.zi();
                    AppMethodBeat.o(32335);
                    return 0;
                default:
                    AppMethodBeat.o(32335);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32335);
            return -1;
        }
    }
}
