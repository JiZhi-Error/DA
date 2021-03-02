package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class amu extends a {
    public int height;
    public int left;
    public int top;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127468);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.left);
            aVar.aM(2, this.top);
            aVar.aM(3, this.width);
            aVar.aM(4, this.height);
            AppMethodBeat.o(127468);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.left) + 0 + g.a.a.b.b.a.bu(2, this.top) + g.a.a.b.b.a.bu(3, this.width) + g.a.a.b.b.a.bu(4, this.height);
            AppMethodBeat.o(127468);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127468);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amu amu = (amu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amu.left = aVar3.UbS.zi();
                    AppMethodBeat.o(127468);
                    return 0;
                case 2:
                    amu.top = aVar3.UbS.zi();
                    AppMethodBeat.o(127468);
                    return 0;
                case 3:
                    amu.width = aVar3.UbS.zi();
                    AppMethodBeat.o(127468);
                    return 0;
                case 4:
                    amu.height = aVar3.UbS.zi();
                    AppMethodBeat.o(127468);
                    return 0;
                default:
                    AppMethodBeat.o(127468);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127468);
            return -1;
        }
    }
}
