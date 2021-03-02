package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class chk extends a {
    public float LbC;
    public float LbD;
    public int LuT;
    public String LuU;
    public String LuV;
    public int LuW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152619);
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
            AppMethodBeat.o(152619);
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
            AppMethodBeat.o(152619);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152619);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chk chk = (chk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chk.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152619);
                    return 0;
                case 2:
                    chk.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(152619);
                    return 0;
                case 3:
                    chk.LuT = aVar3.UbS.zi();
                    AppMethodBeat.o(152619);
                    return 0;
                case 4:
                    chk.LuU = aVar3.UbS.readString();
                    AppMethodBeat.o(152619);
                    return 0;
                case 5:
                    chk.LuV = aVar3.UbS.readString();
                    AppMethodBeat.o(152619);
                    return 0;
                case 6:
                    chk.LuW = aVar3.UbS.zi();
                    AppMethodBeat.o(152619);
                    return 0;
                default:
                    AppMethodBeat.o(152619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152619);
            return -1;
        }
    }
}
