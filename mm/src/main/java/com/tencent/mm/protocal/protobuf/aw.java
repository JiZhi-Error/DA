package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aw extends a {
    public String pTd;
    public String pTe;
    public String pTf;
    public String pTg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113931);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.pTd != null) {
                aVar.e(1, this.pTd);
            }
            if (this.pTe != null) {
                aVar.e(2, this.pTe);
            }
            if (this.pTf != null) {
                aVar.e(3, this.pTf);
            }
            if (this.pTg != null) {
                aVar.e(4, this.pTg);
            }
            AppMethodBeat.o(113931);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.pTd != null ? g.a.a.b.b.a.f(1, this.pTd) + 0 : 0;
            if (this.pTe != null) {
                f2 += g.a.a.b.b.a.f(2, this.pTe);
            }
            if (this.pTf != null) {
                f2 += g.a.a.b.b.a.f(3, this.pTf);
            }
            if (this.pTg != null) {
                f2 += g.a.a.b.b.a.f(4, this.pTg);
            }
            AppMethodBeat.o(113931);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113931);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awVar.pTd = aVar3.UbS.readString();
                    AppMethodBeat.o(113931);
                    return 0;
                case 2:
                    awVar.pTe = aVar3.UbS.readString();
                    AppMethodBeat.o(113931);
                    return 0;
                case 3:
                    awVar.pTf = aVar3.UbS.readString();
                    AppMethodBeat.o(113931);
                    return 0;
                case 4:
                    awVar.pTg = aVar3.UbS.readString();
                    AppMethodBeat.o(113931);
                    return 0;
                default:
                    AppMethodBeat.o(113931);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113931);
            return -1;
        }
    }
}
