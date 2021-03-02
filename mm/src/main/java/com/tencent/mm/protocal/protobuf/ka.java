package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ka extends a {
    public LinkedList<String> KOo = new LinkedList<>();
    public int ReqType;
    public int xIY;
    public int xuA;

    public ka() {
        AppMethodBeat.i(104755);
        AppMethodBeat.o(104755);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104756);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xuA);
            aVar.aM(2, this.ReqType);
            aVar.e(3, 1, this.KOo);
            aVar.aM(4, this.xIY);
            AppMethodBeat.o(104756);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xuA) + 0 + g.a.a.b.b.a.bu(2, this.ReqType) + g.a.a.a.c(3, 1, this.KOo) + g.a.a.b.b.a.bu(4, this.xIY);
            AppMethodBeat.o(104756);
            return bu;
        } else if (i2 == 2) {
            this.KOo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104756);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ka kaVar = (ka) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kaVar.xuA = aVar3.UbS.zi();
                    AppMethodBeat.o(104756);
                    return 0;
                case 2:
                    kaVar.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(104756);
                    return 0;
                case 3:
                    kaVar.KOo.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104756);
                    return 0;
                case 4:
                    kaVar.xIY = aVar3.UbS.zi();
                    AppMethodBeat.o(104756);
                    return 0;
                default:
                    AppMethodBeat.o(104756);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104756);
            return -1;
        }
    }
}
