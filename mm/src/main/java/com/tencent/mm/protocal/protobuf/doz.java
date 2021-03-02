package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class doz extends a {
    public int JZb;
    public int MJT;
    public int MSs;
    public int MSu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152672);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MJT);
            aVar.aM(2, this.MSu);
            aVar.aM(3, this.MSs);
            aVar.aM(4, this.JZb);
            AppMethodBeat.o(152672);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MJT) + 0 + g.a.a.b.b.a.bu(2, this.MSu) + g.a.a.b.b.a.bu(3, this.MSs) + g.a.a.b.b.a.bu(4, this.JZb);
            AppMethodBeat.o(152672);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152672);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doz doz = (doz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doz.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(152672);
                    return 0;
                case 2:
                    doz.MSu = aVar3.UbS.zi();
                    AppMethodBeat.o(152672);
                    return 0;
                case 3:
                    doz.MSs = aVar3.UbS.zi();
                    AppMethodBeat.o(152672);
                    return 0;
                case 4:
                    doz.JZb = aVar3.UbS.zi();
                    AppMethodBeat.o(152672);
                    return 0;
                default:
                    AppMethodBeat.o(152672);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152672);
            return -1;
        }
    }
}
