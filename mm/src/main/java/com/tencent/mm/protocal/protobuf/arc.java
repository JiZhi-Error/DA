package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class arc extends a {
    public int LCO;
    public int LCP;
    public int LCQ;
    public int LCR;
    public int LCS;
    public int LCT;
    public int LCU;
    public b LCV;
    public int pullType;
    public int scene;
    public int vff;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209388);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            aVar.aM(2, this.LCO);
            aVar.aM(3, this.pullType);
            aVar.aM(4, this.vff);
            aVar.aM(5, this.LCP);
            aVar.aM(6, this.LCQ);
            aVar.aM(7, this.LCR);
            aVar.aM(8, this.LCS);
            aVar.aM(9, this.LCT);
            aVar.aM(10, this.LCU);
            if (this.LCV != null) {
                aVar.c(11, this.LCV);
            }
            AppMethodBeat.o(209388);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0 + g.a.a.b.b.a.bu(2, this.LCO) + g.a.a.b.b.a.bu(3, this.pullType) + g.a.a.b.b.a.bu(4, this.vff) + g.a.a.b.b.a.bu(5, this.LCP) + g.a.a.b.b.a.bu(6, this.LCQ) + g.a.a.b.b.a.bu(7, this.LCR) + g.a.a.b.b.a.bu(8, this.LCS) + g.a.a.b.b.a.bu(9, this.LCT) + g.a.a.b.b.a.bu(10, this.LCU);
            if (this.LCV != null) {
                bu += g.a.a.b.b.a.b(11, this.LCV);
            }
            AppMethodBeat.o(209388);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209388);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            arc arc = (arc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arc.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 2:
                    arc.LCO = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 3:
                    arc.pullType = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 4:
                    arc.vff = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 5:
                    arc.LCP = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 6:
                    arc.LCQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 7:
                    arc.LCR = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 8:
                    arc.LCS = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 9:
                    arc.LCT = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 10:
                    arc.LCU = aVar3.UbS.zi();
                    AppMethodBeat.o(209388);
                    return 0;
                case 11:
                    arc.LCV = aVar3.UbS.hPo();
                    AppMethodBeat.o(209388);
                    return 0;
                default:
                    AppMethodBeat.o(209388);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209388);
            return -1;
        }
    }
}
