package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ciu extends a {
    public int key;
    public int value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209725);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.key);
            aVar.aM(2, this.value);
            AppMethodBeat.o(209725);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.key) + 0 + g.a.a.b.b.a.bu(2, this.value);
            AppMethodBeat.o(209725);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209725);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ciu ciu = (ciu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciu.key = aVar3.UbS.zi();
                    AppMethodBeat.o(209725);
                    return 0;
                case 2:
                    ciu.value = aVar3.UbS.zi();
                    AppMethodBeat.o(209725);
                    return 0;
                default:
                    AppMethodBeat.o(209725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209725);
            return -1;
        }
    }
}