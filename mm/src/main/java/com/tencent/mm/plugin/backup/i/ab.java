package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ab extends a {
    public long oTV;
    public int oTl;
    public b oTm;
    public int oUK;
    public int oUL;
    public long oUM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22134);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oTl);
            if (this.oTm != null) {
                aVar.c(2, this.oTm);
            }
            aVar.aM(3, this.oUK);
            aVar.aM(4, this.oUL);
            aVar.bb(5, this.oUM);
            aVar.bb(6, this.oTV);
            AppMethodBeat.o(22134);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTl) + 0;
            if (this.oTm != null) {
                bu += g.a.a.b.b.a.b(2, this.oTm);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.oUK) + g.a.a.b.b.a.bu(4, this.oUL) + g.a.a.b.b.a.r(5, this.oUM) + g.a.a.b.b.a.r(6, this.oTV);
            AppMethodBeat.o(22134);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22134);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abVar.oTl = aVar3.UbS.zi();
                    AppMethodBeat.o(22134);
                    return 0;
                case 2:
                    abVar.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(22134);
                    return 0;
                case 3:
                    abVar.oUK = aVar3.UbS.zi();
                    AppMethodBeat.o(22134);
                    return 0;
                case 4:
                    abVar.oUL = aVar3.UbS.zi();
                    AppMethodBeat.o(22134);
                    return 0;
                case 5:
                    abVar.oUM = aVar3.UbS.zl();
                    AppMethodBeat.o(22134);
                    return 0;
                case 6:
                    abVar.oTV = aVar3.UbS.zl();
                    AppMethodBeat.o(22134);
                    return 0;
                default:
                    AppMethodBeat.o(22134);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22134);
            return -1;
        }
    }
}
