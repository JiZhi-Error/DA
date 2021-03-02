package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class th extends a {
    public int LbS;
    public int LbT;
    public String LbU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91386);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LbS);
            aVar.aM(2, this.LbT);
            if (this.LbU != null) {
                aVar.e(3, this.LbU);
            }
            AppMethodBeat.o(91386);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LbS) + 0 + g.a.a.b.b.a.bu(2, this.LbT);
            if (this.LbU != null) {
                bu += g.a.a.b.b.a.f(3, this.LbU);
            }
            AppMethodBeat.o(91386);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91386);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            th thVar = (th) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    thVar.LbS = aVar3.UbS.zi();
                    AppMethodBeat.o(91386);
                    return 0;
                case 2:
                    thVar.LbT = aVar3.UbS.zi();
                    AppMethodBeat.o(91386);
                    return 0;
                case 3:
                    thVar.LbU = aVar3.UbS.readString();
                    AppMethodBeat.o(91386);
                    return 0;
                default:
                    AppMethodBeat.o(91386);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91386);
            return -1;
        }
    }
}
