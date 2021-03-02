package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ai extends a {
    public String KCU;
    public int KCV;
    public int KCW;
    public int KCX;
    public int KCY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143961);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KCU != null) {
                aVar.e(1, this.KCU);
            }
            aVar.aM(2, this.KCV);
            aVar.aM(3, this.KCW);
            aVar.aM(4, this.KCX);
            aVar.aM(5, this.KCY);
            AppMethodBeat.o(143961);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KCU != null ? g.a.a.b.b.a.f(1, this.KCU) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KCV) + g.a.a.b.b.a.bu(3, this.KCW) + g.a.a.b.b.a.bu(4, this.KCX) + g.a.a.b.b.a.bu(5, this.KCY);
            AppMethodBeat.o(143961);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143961);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ai aiVar = (ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aiVar.KCU = aVar3.UbS.readString();
                    AppMethodBeat.o(143961);
                    return 0;
                case 2:
                    aiVar.KCV = aVar3.UbS.zi();
                    AppMethodBeat.o(143961);
                    return 0;
                case 3:
                    aiVar.KCW = aVar3.UbS.zi();
                    AppMethodBeat.o(143961);
                    return 0;
                case 4:
                    aiVar.KCX = aVar3.UbS.zi();
                    AppMethodBeat.o(143961);
                    return 0;
                case 5:
                    aiVar.KCY = aVar3.UbS.zi();
                    AppMethodBeat.o(143961);
                    return 0;
                default:
                    AppMethodBeat.o(143961);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143961);
            return -1;
        }
    }
}
