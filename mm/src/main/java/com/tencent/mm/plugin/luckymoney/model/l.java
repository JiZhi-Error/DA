package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public String dQx;
    public int pTI;
    public boolean pTt;
    public String qGB;
    public String yUK;
    public String yUL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200184);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.pTt);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.qGB != null) {
                aVar.e(3, this.qGB);
            }
            aVar.aM(4, this.pTI);
            if (this.yUK != null) {
                aVar.e(5, this.yUK);
            }
            if (this.yUL != null) {
                aVar.e(6, this.yUL);
            }
            AppMethodBeat.o(200184);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.dQx != null) {
                fS += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.qGB != null) {
                fS += g.a.a.b.b.a.f(3, this.qGB);
            }
            int bu = fS + g.a.a.b.b.a.bu(4, this.pTI);
            if (this.yUK != null) {
                bu += g.a.a.b.b.a.f(5, this.yUK);
            }
            if (this.yUL != null) {
                bu += g.a.a.b.b.a.f(6, this.yUL);
            }
            AppMethodBeat.o(200184);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200184);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.pTt = aVar3.UbS.yZ();
                    AppMethodBeat.o(200184);
                    return 0;
                case 2:
                    lVar.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(200184);
                    return 0;
                case 3:
                    lVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(200184);
                    return 0;
                case 4:
                    lVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(200184);
                    return 0;
                case 5:
                    lVar.yUK = aVar3.UbS.readString();
                    AppMethodBeat.o(200184);
                    return 0;
                case 6:
                    lVar.yUL = aVar3.UbS.readString();
                    AppMethodBeat.o(200184);
                    return 0;
                default:
                    AppMethodBeat.o(200184);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200184);
            return -1;
        }
    }
}
