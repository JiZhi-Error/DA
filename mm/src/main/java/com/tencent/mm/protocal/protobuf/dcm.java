package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dcm extends a {
    public float LbC;
    public float LbD;
    public int LuT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209789);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.LbC);
            aVar.E(2, this.LbD);
            aVar.aM(3, this.LuT);
            AppMethodBeat.o(209789);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.bu(3, this.LuT);
            AppMethodBeat.o(209789);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209789);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcm dcm = (dcm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcm.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209789);
                    return 0;
                case 2:
                    dcm.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209789);
                    return 0;
                case 3:
                    dcm.LuT = aVar3.UbS.zi();
                    AppMethodBeat.o(209789);
                    return 0;
                default:
                    AppMethodBeat.o(209789);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209789);
            return -1;
        }
    }
}
