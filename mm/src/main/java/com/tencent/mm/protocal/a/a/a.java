package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends com.tencent.mm.bw.a {
    public int KAy;
    public int count;
    public int value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143939);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KAy);
            aVar.aM(2, this.value);
            aVar.aM(3, this.count);
            AppMethodBeat.o(143939);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAy) + 0 + g.a.a.b.b.a.bu(2, this.value) + g.a.a.b.b.a.bu(3, this.count);
            AppMethodBeat.o(143939);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143939);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.KAy = aVar3.UbS.zi();
                    AppMethodBeat.o(143939);
                    return 0;
                case 2:
                    aVar4.value = aVar3.UbS.zi();
                    AppMethodBeat.o(143939);
                    return 0;
                case 3:
                    aVar4.count = aVar3.UbS.zi();
                    AppMethodBeat.o(143939);
                    return 0;
                default:
                    AppMethodBeat.o(143939);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143939);
            return -1;
        }
    }
}
