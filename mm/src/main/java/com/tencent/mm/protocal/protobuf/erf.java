package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class erf extends a {
    public int bottom;
    public int left;
    public int right;
    public int top;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169093);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.left);
            aVar.aM(2, this.top);
            aVar.aM(3, this.right);
            aVar.aM(4, this.bottom);
            AppMethodBeat.o(169093);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.left) + 0 + g.a.a.b.b.a.bu(2, this.top) + g.a.a.b.b.a.bu(3, this.right) + g.a.a.b.b.a.bu(4, this.bottom);
            AppMethodBeat.o(169093);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169093);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erf erf = (erf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    erf.left = aVar3.UbS.zi();
                    AppMethodBeat.o(169093);
                    return 0;
                case 2:
                    erf.top = aVar3.UbS.zi();
                    AppMethodBeat.o(169093);
                    return 0;
                case 3:
                    erf.right = aVar3.UbS.zi();
                    AppMethodBeat.o(169093);
                    return 0;
                case 4:
                    erf.bottom = aVar3.UbS.zi();
                    AppMethodBeat.o(169093);
                    return 0;
                default:
                    AppMethodBeat.o(169093);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169093);
            return -1;
        }
    }
}
