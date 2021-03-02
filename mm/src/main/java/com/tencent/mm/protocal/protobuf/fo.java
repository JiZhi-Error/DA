package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fo extends a {
    public boolean KJa;
    public boolean KJb;
    public int KJc;
    public int KJd;
    public int KJe;
    public int KJf;
    public int KJg;
    public boolean KJh;
    public boolean KJi;
    public boolean KJj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124386);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KJa);
            aVar.cc(2, this.KJb);
            aVar.aM(3, this.KJc);
            aVar.aM(4, this.KJd);
            aVar.aM(5, this.KJe);
            aVar.aM(6, this.KJf);
            aVar.aM(7, this.KJg);
            aVar.cc(8, this.KJh);
            aVar.cc(9, this.KJi);
            aVar.cc(10, this.KJj);
            AppMethodBeat.o(124386);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.KJc) + g.a.a.b.b.a.bu(4, this.KJd) + g.a.a.b.b.a.bu(5, this.KJe) + g.a.a.b.b.a.bu(6, this.KJf) + g.a.a.b.b.a.bu(7, this.KJg) + g.a.a.b.b.a.fS(8) + 1 + g.a.a.b.b.a.fS(9) + 1 + g.a.a.b.b.a.fS(10) + 1;
            AppMethodBeat.o(124386);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124386);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fo foVar = (fo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    foVar.KJa = aVar3.UbS.yZ();
                    AppMethodBeat.o(124386);
                    return 0;
                case 2:
                    foVar.KJb = aVar3.UbS.yZ();
                    AppMethodBeat.o(124386);
                    return 0;
                case 3:
                    foVar.KJc = aVar3.UbS.zi();
                    AppMethodBeat.o(124386);
                    return 0;
                case 4:
                    foVar.KJd = aVar3.UbS.zi();
                    AppMethodBeat.o(124386);
                    return 0;
                case 5:
                    foVar.KJe = aVar3.UbS.zi();
                    AppMethodBeat.o(124386);
                    return 0;
                case 6:
                    foVar.KJf = aVar3.UbS.zi();
                    AppMethodBeat.o(124386);
                    return 0;
                case 7:
                    foVar.KJg = aVar3.UbS.zi();
                    AppMethodBeat.o(124386);
                    return 0;
                case 8:
                    foVar.KJh = aVar3.UbS.yZ();
                    AppMethodBeat.o(124386);
                    return 0;
                case 9:
                    foVar.KJi = aVar3.UbS.yZ();
                    AppMethodBeat.o(124386);
                    return 0;
                case 10:
                    foVar.KJj = aVar3.UbS.yZ();
                    AppMethodBeat.o(124386);
                    return 0;
                default:
                    AppMethodBeat.o(124386);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124386);
            return -1;
        }
    }
}
