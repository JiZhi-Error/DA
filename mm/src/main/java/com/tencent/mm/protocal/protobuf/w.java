package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class w extends a {
    public long KBF;
    public String KBL;
    public String KBN;
    public long KBO;
    public int KBP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91332);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KBN != null) {
                aVar.e(1, this.KBN);
            }
            aVar.bb(2, this.KBF);
            aVar.bb(3, this.KBO);
            aVar.aM(4, this.KBP);
            if (this.KBL != null) {
                aVar.e(5, this.KBL);
            }
            AppMethodBeat.o(91332);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KBN != null ? g.a.a.b.b.a.f(1, this.KBN) + 0 : 0) + g.a.a.b.b.a.r(2, this.KBF) + g.a.a.b.b.a.r(3, this.KBO) + g.a.a.b.b.a.bu(4, this.KBP);
            if (this.KBL != null) {
                f2 += g.a.a.b.b.a.f(5, this.KBL);
            }
            AppMethodBeat.o(91332);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91332);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.KBN = aVar3.UbS.readString();
                    AppMethodBeat.o(91332);
                    return 0;
                case 2:
                    wVar.KBF = aVar3.UbS.zl();
                    AppMethodBeat.o(91332);
                    return 0;
                case 3:
                    wVar.KBO = aVar3.UbS.zl();
                    AppMethodBeat.o(91332);
                    return 0;
                case 4:
                    wVar.KBP = aVar3.UbS.zi();
                    AppMethodBeat.o(91332);
                    return 0;
                case 5:
                    wVar.KBL = aVar3.UbS.readString();
                    AppMethodBeat.o(91332);
                    return 0;
                default:
                    AppMethodBeat.o(91332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91332);
            return -1;
        }
    }
}
