package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cg extends a {
    public int KGy;
    public b KGz;
    public long xvg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125702);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KGy);
            if (this.KGz != null) {
                aVar.c(2, this.KGz);
            }
            aVar.bb(3, this.xvg);
            AppMethodBeat.o(125702);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KGy) + 0;
            if (this.KGz != null) {
                bu += g.a.a.b.b.a.b(2, this.KGz);
            }
            int r = bu + g.a.a.b.b.a.r(3, this.xvg);
            AppMethodBeat.o(125702);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125702);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cg cgVar = (cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgVar.KGy = aVar3.UbS.zi();
                    AppMethodBeat.o(125702);
                    return 0;
                case 2:
                    cgVar.KGz = aVar3.UbS.hPo();
                    AppMethodBeat.o(125702);
                    return 0;
                case 3:
                    cgVar.xvg = aVar3.UbS.zl();
                    AppMethodBeat.o(125702);
                    return 0;
                default:
                    AppMethodBeat.o(125702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125702);
            return -1;
        }
    }
}
