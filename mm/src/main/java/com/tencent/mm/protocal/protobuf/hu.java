package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class hu extends a {
    public String KLH;
    public String KLI;
    public String dDj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KLH != null) {
                aVar.e(1, this.KLH);
            }
            if (this.KLI != null) {
                aVar.e(2, this.KLI);
            }
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            AppMethodBeat.o(123549);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KLH != null ? g.a.a.b.b.a.f(1, this.KLH) + 0 : 0;
            if (this.KLI != null) {
                f2 += g.a.a.b.b.a.f(2, this.KLI);
            }
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(3, this.dDj);
            }
            AppMethodBeat.o(123549);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hu huVar = (hu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    huVar.KLH = aVar3.UbS.readString();
                    AppMethodBeat.o(123549);
                    return 0;
                case 2:
                    huVar.KLI = aVar3.UbS.readString();
                    AppMethodBeat.o(123549);
                    return 0;
                case 3:
                    huVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(123549);
                    return 0;
                default:
                    AppMethodBeat.o(123549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123549);
            return -1;
        }
    }
}
