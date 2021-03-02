package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bcw extends a {
    public int LLE;
    public int LMd;
    public String dQx;
    public long uOx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209685);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LMd);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            aVar.aM(3, this.LLE);
            aVar.bb(4, this.uOx);
            AppMethodBeat.o(209685);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LMd) + 0;
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(2, this.dQx);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LLE) + g.a.a.b.b.a.r(4, this.uOx);
            AppMethodBeat.o(209685);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209685);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcw bcw = (bcw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcw.LMd = aVar3.UbS.zi();
                    AppMethodBeat.o(209685);
                    return 0;
                case 2:
                    bcw.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(209685);
                    return 0;
                case 3:
                    bcw.LLE = aVar3.UbS.zi();
                    AppMethodBeat.o(209685);
                    return 0;
                case 4:
                    bcw.uOx = aVar3.UbS.zl();
                    AppMethodBeat.o(209685);
                    return 0;
                default:
                    AppMethodBeat.o(209685);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209685);
            return -1;
        }
    }
}
