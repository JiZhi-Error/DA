package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dyf extends a {
    public String lHA;
    public String lHB;
    public String qwt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91691);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.lHA != null) {
                aVar.e(1, this.lHA);
            }
            if (this.lHB != null) {
                aVar.e(2, this.lHB);
            }
            if (this.qwt != null) {
                aVar.e(3, this.qwt);
            }
            AppMethodBeat.o(91691);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.lHA != null ? g.a.a.b.b.a.f(1, this.lHA) + 0 : 0;
            if (this.lHB != null) {
                f2 += g.a.a.b.b.a.f(2, this.lHB);
            }
            if (this.qwt != null) {
                f2 += g.a.a.b.b.a.f(3, this.qwt);
            }
            AppMethodBeat.o(91691);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91691);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dyf dyf = (dyf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dyf.lHA = aVar3.UbS.readString();
                    AppMethodBeat.o(91691);
                    return 0;
                case 2:
                    dyf.lHB = aVar3.UbS.readString();
                    AppMethodBeat.o(91691);
                    return 0;
                case 3:
                    dyf.qwt = aVar3.UbS.readString();
                    AppMethodBeat.o(91691);
                    return 0;
                default:
                    AppMethodBeat.o(91691);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91691);
            return -1;
        }
    }
}
