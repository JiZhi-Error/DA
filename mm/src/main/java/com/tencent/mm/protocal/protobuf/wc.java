package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class wc extends a {
    public int KWR;
    public String Lhr;
    public String eaO;
    public int pSb;
    public String pWh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113981);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            if (this.pWh != null) {
                aVar.e(2, this.pWh);
            }
            aVar.aM(3, this.pSb);
            aVar.aM(4, this.KWR);
            if (this.Lhr != null) {
                aVar.e(5, this.Lhr);
            }
            AppMethodBeat.o(113981);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0;
            if (this.pWh != null) {
                f2 += g.a.a.b.b.a.f(2, this.pWh);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.pSb) + g.a.a.b.b.a.bu(4, this.KWR);
            if (this.Lhr != null) {
                bu += g.a.a.b.b.a.f(5, this.Lhr);
            }
            AppMethodBeat.o(113981);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113981);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wc wcVar = (wc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wcVar.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(113981);
                    return 0;
                case 2:
                    wcVar.pWh = aVar3.UbS.readString();
                    AppMethodBeat.o(113981);
                    return 0;
                case 3:
                    wcVar.pSb = aVar3.UbS.zi();
                    AppMethodBeat.o(113981);
                    return 0;
                case 4:
                    wcVar.KWR = aVar3.UbS.zi();
                    AppMethodBeat.o(113981);
                    return 0;
                case 5:
                    wcVar.Lhr = aVar3.UbS.readString();
                    AppMethodBeat.o(113981);
                    return 0;
                default:
                    AppMethodBeat.o(113981);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113981);
            return -1;
        }
    }
}
