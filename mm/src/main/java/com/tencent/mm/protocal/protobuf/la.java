package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class la extends a {
    public String KOR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82387);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KOR != null) {
                aVar.e(1, this.KOR);
            }
            AppMethodBeat.o(82387);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KOR != null ? g.a.a.b.b.a.f(1, this.KOR) + 0 : 0;
            AppMethodBeat.o(82387);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82387);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            la laVar = (la) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    laVar.KOR = aVar3.UbS.readString();
                    AppMethodBeat.o(82387);
                    return 0;
                default:
                    AppMethodBeat.o(82387);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82387);
            return -1;
        }
    }
}
