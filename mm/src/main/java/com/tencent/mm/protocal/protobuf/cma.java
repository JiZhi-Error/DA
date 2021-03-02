package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cma extends a {
    public String dQx;
    public String lHA;
    public String lHB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72513);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dQx != null) {
                aVar.e(1, this.dQx);
            }
            if (this.lHA != null) {
                aVar.e(2, this.lHA);
            }
            if (this.lHB != null) {
                aVar.e(4, this.lHB);
            }
            AppMethodBeat.o(72513);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dQx != null ? g.a.a.b.b.a.f(1, this.dQx) + 0 : 0;
            if (this.lHA != null) {
                f2 += g.a.a.b.b.a.f(2, this.lHA);
            }
            if (this.lHB != null) {
                f2 += g.a.a.b.b.a.f(4, this.lHB);
            }
            AppMethodBeat.o(72513);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72513);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cma cma = (cma) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cma.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72513);
                    return 0;
                case 2:
                    cma.lHA = aVar3.UbS.readString();
                    AppMethodBeat.o(72513);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(72513);
                    return -1;
                case 4:
                    cma.lHB = aVar3.UbS.readString();
                    AppMethodBeat.o(72513);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72513);
            return -1;
        }
    }
}
