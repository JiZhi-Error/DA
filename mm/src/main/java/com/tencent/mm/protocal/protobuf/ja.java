package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ja extends a {
    public String AOk;
    public String KNw;
    public String dDj;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91356);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNw != null) {
                aVar.e(1, this.KNw);
            }
            if (this.dDj != null) {
                aVar.e(2, this.dDj);
            }
            if (this.ynT != null) {
                aVar.e(3, this.ynT);
            }
            if (this.AOk != null) {
                aVar.e(4, this.AOk);
            }
            AppMethodBeat.o(91356);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KNw != null ? g.a.a.b.b.a.f(1, this.KNw) + 0 : 0;
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(2, this.dDj);
            }
            if (this.ynT != null) {
                f2 += g.a.a.b.b.a.f(3, this.ynT);
            }
            if (this.AOk != null) {
                f2 += g.a.a.b.b.a.f(4, this.AOk);
            }
            AppMethodBeat.o(91356);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91356);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ja jaVar = (ja) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jaVar.KNw = aVar3.UbS.readString();
                    AppMethodBeat.o(91356);
                    return 0;
                case 2:
                    jaVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91356);
                    return 0;
                case 3:
                    jaVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(91356);
                    return 0;
                case 4:
                    jaVar.AOk = aVar3.UbS.readString();
                    AppMethodBeat.o(91356);
                    return 0;
                default:
                    AppMethodBeat.o(91356);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91356);
            return -1;
        }
    }
}
