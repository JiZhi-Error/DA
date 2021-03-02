package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class crv extends a {
    public String MwU;
    public String MwV;
    public String MwW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(63277);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwU != null) {
                aVar.e(1, this.MwU);
            }
            if (this.MwV != null) {
                aVar.e(2, this.MwV);
            }
            if (this.MwW != null) {
                aVar.e(3, this.MwW);
            }
            AppMethodBeat.o(63277);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwU != null ? g.a.a.b.b.a.f(1, this.MwU) + 0 : 0;
            if (this.MwV != null) {
                f2 += g.a.a.b.b.a.f(2, this.MwV);
            }
            if (this.MwW != null) {
                f2 += g.a.a.b.b.a.f(3, this.MwW);
            }
            AppMethodBeat.o(63277);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(63277);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crv crv = (crv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crv.MwU = aVar3.UbS.readString();
                    AppMethodBeat.o(63277);
                    return 0;
                case 2:
                    crv.MwV = aVar3.UbS.readString();
                    AppMethodBeat.o(63277);
                    return 0;
                case 3:
                    crv.MwW = aVar3.UbS.readString();
                    AppMethodBeat.o(63277);
                    return 0;
                default:
                    AppMethodBeat.o(63277);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63277);
            return -1;
        }
    }
}
