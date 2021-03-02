package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bdi extends a {
    public int LNf;
    public b LNg;
    public b LNh;
    public String dQx;
    public int position;
    public long twp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209696);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LNf);
            aVar.bb(2, this.twp);
            aVar.aM(3, this.position);
            if (this.dQx != null) {
                aVar.e(4, this.dQx);
            }
            if (this.LNg != null) {
                aVar.c(5, this.LNg);
            }
            if (this.LNh != null) {
                aVar.c(6, this.LNh);
            }
            AppMethodBeat.o(209696);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LNf) + 0 + g.a.a.b.b.a.r(2, this.twp) + g.a.a.b.b.a.bu(3, this.position);
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(4, this.dQx);
            }
            if (this.LNg != null) {
                bu += g.a.a.b.b.a.b(5, this.LNg);
            }
            if (this.LNh != null) {
                bu += g.a.a.b.b.a.b(6, this.LNh);
            }
            AppMethodBeat.o(209696);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209696);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdi bdi = (bdi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdi.LNf = aVar3.UbS.zi();
                    AppMethodBeat.o(209696);
                    return 0;
                case 2:
                    bdi.twp = aVar3.UbS.zl();
                    AppMethodBeat.o(209696);
                    return 0;
                case 3:
                    bdi.position = aVar3.UbS.zi();
                    AppMethodBeat.o(209696);
                    return 0;
                case 4:
                    bdi.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(209696);
                    return 0;
                case 5:
                    bdi.LNg = aVar3.UbS.hPo();
                    AppMethodBeat.o(209696);
                    return 0;
                case 6:
                    bdi.LNh = aVar3.UbS.hPo();
                    AppMethodBeat.o(209696);
                    return 0;
                default:
                    AppMethodBeat.o(209696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209696);
            return -1;
        }
    }
}
