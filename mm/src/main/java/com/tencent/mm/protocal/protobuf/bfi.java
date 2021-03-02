package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfi extends a {
    public String LOU;
    public String LOV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169383);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LOU != null) {
                aVar.e(1, this.LOU);
            }
            if (this.LOV != null) {
                aVar.e(2, this.LOV);
            }
            AppMethodBeat.o(169383);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LOU != null ? g.a.a.b.b.a.f(1, this.LOU) + 0 : 0;
            if (this.LOV != null) {
                f2 += g.a.a.b.b.a.f(2, this.LOV);
            }
            AppMethodBeat.o(169383);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169383);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfi bfi = (bfi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfi.LOU = aVar3.UbS.readString();
                    AppMethodBeat.o(169383);
                    return 0;
                case 2:
                    bfi.LOV = aVar3.UbS.readString();
                    AppMethodBeat.o(169383);
                    return 0;
                default:
                    AppMethodBeat.o(169383);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169383);
            return -1;
        }
    }
}
