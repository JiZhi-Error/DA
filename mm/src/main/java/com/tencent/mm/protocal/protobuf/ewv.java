package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ewv extends a {
    public String AOv;
    public String pTL;
    public String qGB;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212318);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.AOv != null) {
                aVar.e(2, this.AOv);
            }
            if (this.qGB != null) {
                aVar.e(3, this.qGB);
            }
            if (this.pTL != null) {
                aVar.e(4, this.pTL);
            }
            AppMethodBeat.o(212318);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.AOv != null) {
                bu += g.a.a.b.b.a.f(2, this.AOv);
            }
            if (this.qGB != null) {
                bu += g.a.a.b.b.a.f(3, this.qGB);
            }
            if (this.pTL != null) {
                bu += g.a.a.b.b.a.f(4, this.pTL);
            }
            AppMethodBeat.o(212318);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212318);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewv ewv = (ewv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewv.type = aVar3.UbS.zi();
                    AppMethodBeat.o(212318);
                    return 0;
                case 2:
                    ewv.AOv = aVar3.UbS.readString();
                    AppMethodBeat.o(212318);
                    return 0;
                case 3:
                    ewv.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(212318);
                    return 0;
                case 4:
                    ewv.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(212318);
                    return 0;
                default:
                    AppMethodBeat.o(212318);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212318);
            return -1;
        }
    }
}
