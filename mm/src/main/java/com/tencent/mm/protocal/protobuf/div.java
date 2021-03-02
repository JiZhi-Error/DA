package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class div extends a {
    public String MNa;
    public String MNb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133191);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MNa != null) {
                aVar.e(1, this.MNa);
            }
            if (this.MNb != null) {
                aVar.e(2, this.MNb);
            }
            AppMethodBeat.o(133191);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MNa != null ? g.a.a.b.b.a.f(1, this.MNa) + 0 : 0;
            if (this.MNb != null) {
                f2 += g.a.a.b.b.a.f(2, this.MNb);
            }
            AppMethodBeat.o(133191);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133191);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            div div = (div) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    div.MNa = aVar3.UbS.readString();
                    AppMethodBeat.o(133191);
                    return 0;
                case 2:
                    div.MNb = aVar3.UbS.readString();
                    AppMethodBeat.o(133191);
                    return 0;
                default:
                    AppMethodBeat.o(133191);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133191);
            return -1;
        }
    }
}
