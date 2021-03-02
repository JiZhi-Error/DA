package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbn extends a {
    public int KXC;
    public int NxK;
    public String md5;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123680);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NxK);
            aVar.aM(2, this.KXC);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.md5 != null) {
                aVar.e(4, this.md5);
            }
            AppMethodBeat.o(123680);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NxK) + 0 + g.a.a.b.b.a.bu(2, this.KXC);
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(4, this.md5);
            }
            AppMethodBeat.o(123680);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123680);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbn fbn = (fbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbn.NxK = aVar3.UbS.zi();
                    AppMethodBeat.o(123680);
                    return 0;
                case 2:
                    fbn.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(123680);
                    return 0;
                case 3:
                    fbn.url = aVar3.UbS.readString();
                    AppMethodBeat.o(123680);
                    return 0;
                case 4:
                    fbn.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(123680);
                    return 0;
                default:
                    AppMethodBeat.o(123680);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123680);
            return -1;
        }
    }
}
