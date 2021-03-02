package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class agg extends a {
    public String ClZ;
    public int code;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72468);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ClZ != null) {
                aVar.e(1, this.ClZ);
            }
            aVar.aM(2, this.code);
            AppMethodBeat.o(72468);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ClZ != null ? g.a.a.b.b.a.f(1, this.ClZ) + 0 : 0) + g.a.a.b.b.a.bu(2, this.code);
            AppMethodBeat.o(72468);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72468);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            agg agg = (agg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agg.ClZ = aVar3.UbS.readString();
                    AppMethodBeat.o(72468);
                    return 0;
                case 2:
                    agg.code = aVar3.UbS.zi();
                    AppMethodBeat.o(72468);
                    return 0;
                default:
                    AppMethodBeat.o(72468);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72468);
            return -1;
        }
    }
}
