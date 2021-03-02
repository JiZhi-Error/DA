package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cdc extends a {
    public long MiS;
    public int MiT;
    public int key;
    public int length;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(111786);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.key);
            aVar.bb(2, this.MiS);
            aVar.aM(3, this.length);
            aVar.aM(4, this.MiT);
            AppMethodBeat.o(111786);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.key) + 0 + g.a.a.b.b.a.r(2, this.MiS) + g.a.a.b.b.a.bu(3, this.length) + g.a.a.b.b.a.bu(4, this.MiT);
            AppMethodBeat.o(111786);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(111786);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdc cdc = (cdc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdc.key = aVar3.UbS.zi();
                    AppMethodBeat.o(111786);
                    return 0;
                case 2:
                    cdc.MiS = aVar3.UbS.zl();
                    AppMethodBeat.o(111786);
                    return 0;
                case 3:
                    cdc.length = aVar3.UbS.zi();
                    AppMethodBeat.o(111786);
                    return 0;
                case 4:
                    cdc.MiT = aVar3.UbS.zi();
                    AppMethodBeat.o(111786);
                    return 0;
                default:
                    AppMethodBeat.o(111786);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111786);
            return -1;
        }
    }
}
