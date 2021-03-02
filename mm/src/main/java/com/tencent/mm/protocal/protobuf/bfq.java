package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfq extends a {
    public int LPh = 7;
    public long LPi = 0;
    public int LPj = 0;
    public String LPk = "";
    public boolean LPl = false;
    public int aHK = 0;
    public int jlm = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122494);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LPh);
            aVar.bb(2, this.LPi);
            aVar.aM(3, this.LPj);
            if (this.LPk != null) {
                aVar.e(4, this.LPk);
            }
            aVar.aM(5, this.aHK);
            aVar.aM(6, this.jlm);
            aVar.cc(7, this.LPl);
            AppMethodBeat.o(122494);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LPh) + 0 + g.a.a.b.b.a.r(2, this.LPi) + g.a.a.b.b.a.bu(3, this.LPj);
            if (this.LPk != null) {
                bu += g.a.a.b.b.a.f(4, this.LPk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.aHK) + g.a.a.b.b.a.bu(6, this.jlm) + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(122494);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122494);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfq bfq = (bfq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfq.LPh = aVar3.UbS.zi();
                    AppMethodBeat.o(122494);
                    return 0;
                case 2:
                    bfq.LPi = aVar3.UbS.zl();
                    AppMethodBeat.o(122494);
                    return 0;
                case 3:
                    bfq.LPj = aVar3.UbS.zi();
                    AppMethodBeat.o(122494);
                    return 0;
                case 4:
                    bfq.LPk = aVar3.UbS.readString();
                    AppMethodBeat.o(122494);
                    return 0;
                case 5:
                    bfq.aHK = aVar3.UbS.zi();
                    AppMethodBeat.o(122494);
                    return 0;
                case 6:
                    bfq.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(122494);
                    return 0;
                case 7:
                    bfq.LPl = aVar3.UbS.yZ();
                    AppMethodBeat.o(122494);
                    return 0;
                default:
                    AppMethodBeat.o(122494);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122494);
            return -1;
        }
    }
}
