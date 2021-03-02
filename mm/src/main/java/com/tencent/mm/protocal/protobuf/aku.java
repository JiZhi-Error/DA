package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aku extends a {
    public int LtB;
    public String LtC;
    public String LtD;
    public String LtE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32200);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LtB);
            if (this.LtC != null) {
                aVar.e(2, this.LtC);
            }
            if (this.LtE != null) {
                aVar.e(3, this.LtE);
            }
            if (this.LtD != null) {
                aVar.e(4, this.LtD);
            }
            AppMethodBeat.o(32200);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LtB) + 0;
            if (this.LtC != null) {
                bu += g.a.a.b.b.a.f(2, this.LtC);
            }
            if (this.LtE != null) {
                bu += g.a.a.b.b.a.f(3, this.LtE);
            }
            if (this.LtD != null) {
                bu += g.a.a.b.b.a.f(4, this.LtD);
            }
            AppMethodBeat.o(32200);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32200);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aku aku = (aku) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aku.LtB = aVar3.UbS.zi();
                    AppMethodBeat.o(32200);
                    return 0;
                case 2:
                    aku.LtC = aVar3.UbS.readString();
                    AppMethodBeat.o(32200);
                    return 0;
                case 3:
                    aku.LtE = aVar3.UbS.readString();
                    AppMethodBeat.o(32200);
                    return 0;
                case 4:
                    aku.LtD = aVar3.UbS.readString();
                    AppMethodBeat.o(32200);
                    return 0;
                default:
                    AppMethodBeat.o(32200);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32200);
            return -1;
        }
    }
}
