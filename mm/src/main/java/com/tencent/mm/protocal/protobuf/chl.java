package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class chl extends a {
    public float LbC;
    public float LbD;
    public int LuT;
    public String LuU;
    public String LuV;
    public int LuW;
    public String MmX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117875);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.LbC);
            aVar.E(2, this.LbD);
            aVar.aM(3, this.LuT);
            if (this.LuU != null) {
                aVar.e(4, this.LuU);
            }
            if (this.LuV != null) {
                aVar.e(5, this.LuV);
            }
            aVar.aM(6, this.LuW);
            if (this.MmX != null) {
                aVar.e(7, this.MmX);
            }
            AppMethodBeat.o(117875);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.bu(3, this.LuT);
            if (this.LuU != null) {
                fS += g.a.a.b.b.a.f(4, this.LuU);
            }
            if (this.LuV != null) {
                fS += g.a.a.b.b.a.f(5, this.LuV);
            }
            int bu = fS + g.a.a.b.b.a.bu(6, this.LuW);
            if (this.MmX != null) {
                bu += g.a.a.b.b.a.f(7, this.MmX);
            }
            AppMethodBeat.o(117875);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117875);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chl chl = (chl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chl.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117875);
                    return 0;
                case 2:
                    chl.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117875);
                    return 0;
                case 3:
                    chl.LuT = aVar3.UbS.zi();
                    AppMethodBeat.o(117875);
                    return 0;
                case 4:
                    chl.LuU = aVar3.UbS.readString();
                    AppMethodBeat.o(117875);
                    return 0;
                case 5:
                    chl.LuV = aVar3.UbS.readString();
                    AppMethodBeat.o(117875);
                    return 0;
                case 6:
                    chl.LuW = aVar3.UbS.zi();
                    AppMethodBeat.o(117875);
                    return 0;
                case 7:
                    chl.MmX = aVar3.UbS.readString();
                    AppMethodBeat.o(117875);
                    return 0;
                default:
                    AppMethodBeat.o(117875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117875);
            return -1;
        }
    }
}
