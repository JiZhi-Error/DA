package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bes extends a {
    public int index;
    public int lCq;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32211);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.index);
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.aM(3, this.lCq);
            AppMethodBeat.o(32211);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.index) + 0;
            if (this.username != null) {
                bu += g.a.a.b.b.a.f(2, this.username);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.lCq);
            AppMethodBeat.o(32211);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32211);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bes bes = (bes) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bes.index = aVar3.UbS.zi();
                    AppMethodBeat.o(32211);
                    return 0;
                case 2:
                    bes.username = aVar3.UbS.readString();
                    AppMethodBeat.o(32211);
                    return 0;
                case 3:
                    bes.lCq = aVar3.UbS.zi();
                    AppMethodBeat.o(32211);
                    return 0;
                default:
                    AppMethodBeat.o(32211);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32211);
            return -1;
        }
    }
}
