package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bmd extends a {
    public double KUt;
    public double KUu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32236);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, this.KUt);
            aVar.e(2, this.KUu);
            AppMethodBeat.o(32236);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 8 + 0 + g.a.a.b.b.a.fS(2) + 8;
            AppMethodBeat.o(32236);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32236);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmd bmd = (bmd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmd.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(32236);
                    return 0;
                case 2:
                    bmd.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(32236);
                    return 0;
                default:
                    AppMethodBeat.o(32236);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32236);
            return -1;
        }
    }
}
