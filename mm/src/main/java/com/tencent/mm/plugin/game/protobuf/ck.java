package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ck extends a {
    public String xMs;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256642);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMs != null) {
                aVar.e(1, this.xMs);
            }
            AppMethodBeat.o(256642);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMs != null ? g.a.a.b.b.a.f(1, this.xMs) + 0 : 0;
            AppMethodBeat.o(256642);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256642);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ck ckVar = (ck) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckVar.xMs = aVar3.UbS.readString();
                    AppMethodBeat.o(256642);
                    return 0;
                default:
                    AppMethodBeat.o(256642);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256642);
            return -1;
        }
    }
}