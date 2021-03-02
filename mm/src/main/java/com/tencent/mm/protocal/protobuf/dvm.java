package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dvm extends a {
    public int MWA;
    public int MWB;
    public int MWC;
    public int MWD;
    public int MWE;
    public int MWy;
    public int MWz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MWy);
            aVar.aM(2, this.MWz);
            aVar.aM(3, this.MWA);
            aVar.aM(4, this.MWB);
            aVar.aM(5, this.MWC);
            aVar.aM(6, this.MWD);
            aVar.aM(7, this.MWE);
            AppMethodBeat.o(124550);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MWy) + 0 + g.a.a.b.b.a.bu(2, this.MWz) + g.a.a.b.b.a.bu(3, this.MWA) + g.a.a.b.b.a.bu(4, this.MWB) + g.a.a.b.b.a.bu(5, this.MWC) + g.a.a.b.b.a.bu(6, this.MWD) + g.a.a.b.b.a.bu(7, this.MWE);
            AppMethodBeat.o(124550);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvm dvm = (dvm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dvm.MWy = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 2:
                    dvm.MWz = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 3:
                    dvm.MWA = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 4:
                    dvm.MWB = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 5:
                    dvm.MWC = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 6:
                    dvm.MWD = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                case 7:
                    dvm.MWE = aVar3.UbS.zi();
                    AppMethodBeat.o(124550);
                    return 0;
                default:
                    AppMethodBeat.o(124550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124550);
            return -1;
        }
    }
}
