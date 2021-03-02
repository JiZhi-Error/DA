package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dbf extends a {
    public String MGh;
    public String MGi;
    public String MGj;
    public String MGk;
    public boolean MGl;
    public String MGm;
    public String dDj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72547);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MGh != null) {
                aVar.e(1, this.MGh);
            }
            if (this.MGi != null) {
                aVar.e(2, this.MGi);
            }
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            if (this.MGj != null) {
                aVar.e(4, this.MGj);
            }
            if (this.MGk != null) {
                aVar.e(5, this.MGk);
            }
            aVar.cc(6, this.MGl);
            if (this.MGm != null) {
                aVar.e(7, this.MGm);
            }
            AppMethodBeat.o(72547);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MGh != null ? g.a.a.b.b.a.f(1, this.MGh) + 0 : 0;
            if (this.MGi != null) {
                f2 += g.a.a.b.b.a.f(2, this.MGi);
            }
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(3, this.dDj);
            }
            if (this.MGj != null) {
                f2 += g.a.a.b.b.a.f(4, this.MGj);
            }
            if (this.MGk != null) {
                f2 += g.a.a.b.b.a.f(5, this.MGk);
            }
            int fS = f2 + g.a.a.b.b.a.fS(6) + 1;
            if (this.MGm != null) {
                fS += g.a.a.b.b.a.f(7, this.MGm);
            }
            AppMethodBeat.o(72547);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72547);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbf dbf = (dbf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbf.MGh = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                case 2:
                    dbf.MGi = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                case 3:
                    dbf.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                case 4:
                    dbf.MGj = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                case 5:
                    dbf.MGk = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                case 6:
                    dbf.MGl = aVar3.UbS.yZ();
                    AppMethodBeat.o(72547);
                    return 0;
                case 7:
                    dbf.MGm = aVar3.UbS.readString();
                    AppMethodBeat.o(72547);
                    return 0;
                default:
                    AppMethodBeat.o(72547);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72547);
            return -1;
        }
    }
}
