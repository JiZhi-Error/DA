package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ek extends a {
    public String xNJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149419);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNJ != null) {
                aVar.e(1, this.xNJ);
            }
            AppMethodBeat.o(149419);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNJ != null ? g.a.a.b.b.a.f(1, this.xNJ) + 0 : 0;
            AppMethodBeat.o(149419);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149419);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ek ekVar = (ek) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekVar.xNJ = aVar3.UbS.readString();
                    AppMethodBeat.o(149419);
                    return 0;
                default:
                    AppMethodBeat.o(149419);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149419);
            return -1;
        }
    }
}
