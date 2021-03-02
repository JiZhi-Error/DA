package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class mq extends a {
    public int KQU;
    public String KQV;
    public int KQW;
    public int KQX;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124393);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.aM(2, this.KQU);
            if (this.KQV != null) {
                aVar.e(3, this.KQV);
            }
            aVar.aM(4, this.KQW);
            aVar.aM(5, this.KQX);
            AppMethodBeat.o(124393);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KQU);
            if (this.KQV != null) {
                f2 += g.a.a.b.b.a.f(3, this.KQV);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KQW) + g.a.a.b.b.a.bu(5, this.KQX);
            AppMethodBeat.o(124393);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124393);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mq mqVar = (mq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mqVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(124393);
                    return 0;
                case 2:
                    mqVar.KQU = aVar3.UbS.zi();
                    AppMethodBeat.o(124393);
                    return 0;
                case 3:
                    mqVar.KQV = aVar3.UbS.readString();
                    AppMethodBeat.o(124393);
                    return 0;
                case 4:
                    mqVar.KQW = aVar3.UbS.zi();
                    AppMethodBeat.o(124393);
                    return 0;
                case 5:
                    mqVar.KQX = aVar3.UbS.zi();
                    AppMethodBeat.o(124393);
                    return 0;
                default:
                    AppMethodBeat.o(124393);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124393);
            return -1;
        }
    }
}
