package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bal extends a {
    public float LKc;
    public float LKd;
    public int LKe;
    public float dTj;
    public float latitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169035);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(8, this.dTj);
            aVar.E(9, this.latitude);
            aVar.E(10, this.LKc);
            aVar.E(11, this.LKd);
            aVar.aM(12, this.LKe);
            AppMethodBeat.o(169035);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(8) + 4 + 0 + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.fS(10) + 4 + g.a.a.b.b.a.fS(11) + 4 + g.a.a.b.b.a.bu(12, this.LKe);
            AppMethodBeat.o(169035);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169035);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bal bal = (bal) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 8:
                    bal.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169035);
                    return 0;
                case 9:
                    bal.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169035);
                    return 0;
                case 10:
                    bal.LKc = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169035);
                    return 0;
                case 11:
                    bal.LKd = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169035);
                    return 0;
                case 12:
                    bal.LKe = aVar3.UbS.zi();
                    AppMethodBeat.o(169035);
                    return 0;
                default:
                    AppMethodBeat.o(169035);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169035);
            return -1;
        }
    }
}
