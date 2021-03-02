package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class acz extends a {
    public int Lnt;
    public String openid;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90961);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lnt);
            if (this.openid != null) {
                aVar.e(2, this.openid);
            }
            aVar.aM(3, this.status);
            AppMethodBeat.o(90961);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lnt) + 0;
            if (this.openid != null) {
                bu += g.a.a.b.b.a.f(2, this.openid);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.status);
            AppMethodBeat.o(90961);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90961);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acz acz = (acz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acz.Lnt = aVar3.UbS.zi();
                    AppMethodBeat.o(90961);
                    return 0;
                case 2:
                    acz.openid = aVar3.UbS.readString();
                    AppMethodBeat.o(90961);
                    return 0;
                case 3:
                    acz.status = aVar3.UbS.zi();
                    AppMethodBeat.o(90961);
                    return 0;
                default:
                    AppMethodBeat.o(90961);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90961);
            return -1;
        }
    }
}
