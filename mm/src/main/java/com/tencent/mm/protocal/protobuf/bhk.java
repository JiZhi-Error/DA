package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bhk extends a {
    public String LRU;
    public long LRV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152555);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LRU != null) {
                aVar.e(1, this.LRU);
            }
            aVar.bb(2, this.LRV);
            AppMethodBeat.o(152555);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LRU != null ? g.a.a.b.b.a.f(1, this.LRU) + 0 : 0) + g.a.a.b.b.a.r(2, this.LRV);
            AppMethodBeat.o(152555);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152555);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhk bhk = (bhk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhk.LRU = aVar3.UbS.readString();
                    AppMethodBeat.o(152555);
                    return 0;
                case 2:
                    bhk.LRV = aVar3.UbS.zl();
                    AppMethodBeat.o(152555);
                    return 0;
                default:
                    AppMethodBeat.o(152555);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152555);
            return -1;
        }
    }
}
