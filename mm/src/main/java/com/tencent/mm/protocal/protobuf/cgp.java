package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cgp extends a {
    public String LtA;
    public String oTI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LtA != null) {
                aVar.e(1, this.LtA);
            }
            if (this.oTI != null) {
                aVar.e(2, this.oTI);
            }
            AppMethodBeat.o(256412);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LtA != null ? g.a.a.b.b.a.f(1, this.LtA) + 0 : 0;
            if (this.oTI != null) {
                f2 += g.a.a.b.b.a.f(2, this.oTI);
            }
            AppMethodBeat.o(256412);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgp cgp = (cgp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgp.LtA = aVar3.UbS.readString();
                    AppMethodBeat.o(256412);
                    return 0;
                case 2:
                    cgp.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(256412);
                    return 0;
                default:
                    AppMethodBeat.o(256412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256412);
            return -1;
        }
    }
}
