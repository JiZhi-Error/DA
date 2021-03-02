package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cql extends a {
    public String Lir;
    public String Lis;
    public int Mwb;
    public int Mwc;
    public b Mwd;
    public String Mwe;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32353);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mwb);
            aVar.aM(2, this.Mwc);
            if (this.Mwd != null) {
                aVar.c(3, this.Mwd);
            }
            if (this.Mwe != null) {
                aVar.e(4, this.Mwe);
            }
            if (this.Lir != null) {
                aVar.e(5, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(6, this.Lis);
            }
            AppMethodBeat.o(32353);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mwb) + 0 + g.a.a.b.b.a.bu(2, this.Mwc);
            if (this.Mwd != null) {
                bu += g.a.a.b.b.a.b(3, this.Mwd);
            }
            if (this.Mwe != null) {
                bu += g.a.a.b.b.a.f(4, this.Mwe);
            }
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(5, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(6, this.Lis);
            }
            AppMethodBeat.o(32353);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32353);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cql cql = (cql) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cql.Mwb = aVar3.UbS.zi();
                    AppMethodBeat.o(32353);
                    return 0;
                case 2:
                    cql.Mwc = aVar3.UbS.zi();
                    AppMethodBeat.o(32353);
                    return 0;
                case 3:
                    cql.Mwd = aVar3.UbS.hPo();
                    AppMethodBeat.o(32353);
                    return 0;
                case 4:
                    cql.Mwe = aVar3.UbS.readString();
                    AppMethodBeat.o(32353);
                    return 0;
                case 5:
                    cql.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(32353);
                    return 0;
                case 6:
                    cql.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(32353);
                    return 0;
                default:
                    AppMethodBeat.o(32353);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32353);
            return -1;
        }
    }
}
