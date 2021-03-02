package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eql extends a {
    public boolean NnQ;
    public String NnR;
    public String NnS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209826);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.NnQ);
            if (this.NnR != null) {
                aVar.e(2, this.NnR);
            }
            if (this.NnS != null) {
                aVar.e(3, this.NnS);
            }
            AppMethodBeat.o(209826);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.NnR != null) {
                fS += g.a.a.b.b.a.f(2, this.NnR);
            }
            if (this.NnS != null) {
                fS += g.a.a.b.b.a.f(3, this.NnS);
            }
            AppMethodBeat.o(209826);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209826);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eql eql = (eql) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eql.NnQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(209826);
                    return 0;
                case 2:
                    eql.NnR = aVar3.UbS.readString();
                    AppMethodBeat.o(209826);
                    return 0;
                case 3:
                    eql.NnS = aVar3.UbS.readString();
                    AppMethodBeat.o(209826);
                    return 0;
                default:
                    AppMethodBeat.o(209826);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209826);
            return -1;
        }
    }
}
