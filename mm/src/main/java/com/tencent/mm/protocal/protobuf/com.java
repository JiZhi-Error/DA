package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class com extends a {
    public int LOf;
    public int percent;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209770);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            aVar.aM(2, this.percent);
            aVar.aM(3, this.LOf);
            AppMethodBeat.o(209770);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.percent) + g.a.a.b.b.a.bu(3, this.LOf);
            AppMethodBeat.o(209770);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209770);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            com com2 = (com) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com2.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209770);
                    return 0;
                case 2:
                    com2.percent = aVar3.UbS.zi();
                    AppMethodBeat.o(209770);
                    return 0;
                case 3:
                    com2.LOf = aVar3.UbS.zi();
                    AppMethodBeat.o(209770);
                    return 0;
                default:
                    AppMethodBeat.o(209770);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209770);
            return -1;
        }
    }
}