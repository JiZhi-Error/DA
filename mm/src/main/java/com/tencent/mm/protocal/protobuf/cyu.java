package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cyu extends a {
    public String Lso;
    public int MDN;
    public int MDO;
    public int MDP;
    public long MDQ;
    public int MDR;
    public int MDS;
    public String xNU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104825);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MDN);
            aVar.aM(2, this.MDO);
            aVar.aM(3, this.MDP);
            if (this.xNU != null) {
                aVar.e(4, this.xNU);
            }
            aVar.bb(5, this.MDQ);
            aVar.aM(6, this.MDR);
            if (this.Lso != null) {
                aVar.e(7, this.Lso);
            }
            aVar.aM(8, this.MDS);
            AppMethodBeat.o(104825);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MDN) + 0 + g.a.a.b.b.a.bu(2, this.MDO) + g.a.a.b.b.a.bu(3, this.MDP);
            if (this.xNU != null) {
                bu += g.a.a.b.b.a.f(4, this.xNU);
            }
            int r = bu + g.a.a.b.b.a.r(5, this.MDQ) + g.a.a.b.b.a.bu(6, this.MDR);
            if (this.Lso != null) {
                r += g.a.a.b.b.a.f(7, this.Lso);
            }
            int bu2 = r + g.a.a.b.b.a.bu(8, this.MDS);
            AppMethodBeat.o(104825);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104825);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyu cyu = (cyu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyu.MDN = aVar3.UbS.zi();
                    AppMethodBeat.o(104825);
                    return 0;
                case 2:
                    cyu.MDO = aVar3.UbS.zi();
                    AppMethodBeat.o(104825);
                    return 0;
                case 3:
                    cyu.MDP = aVar3.UbS.zi();
                    AppMethodBeat.o(104825);
                    return 0;
                case 4:
                    cyu.xNU = aVar3.UbS.readString();
                    AppMethodBeat.o(104825);
                    return 0;
                case 5:
                    cyu.MDQ = aVar3.UbS.zl();
                    AppMethodBeat.o(104825);
                    return 0;
                case 6:
                    cyu.MDR = aVar3.UbS.zi();
                    AppMethodBeat.o(104825);
                    return 0;
                case 7:
                    cyu.Lso = aVar3.UbS.readString();
                    AppMethodBeat.o(104825);
                    return 0;
                case 8:
                    cyu.MDS = aVar3.UbS.zi();
                    AppMethodBeat.o(104825);
                    return 0;
                default:
                    AppMethodBeat.o(104825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104825);
            return -1;
        }
    }
}
