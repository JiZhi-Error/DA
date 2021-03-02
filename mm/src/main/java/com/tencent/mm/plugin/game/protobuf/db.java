package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class db extends a {
    public String xIB;
    public String xMN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41815);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMN != null) {
                aVar.e(1, this.xMN);
            }
            if (this.xIB != null) {
                aVar.e(2, this.xIB);
            }
            AppMethodBeat.o(41815);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMN != null ? g.a.a.b.b.a.f(1, this.xMN) + 0 : 0;
            if (this.xIB != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIB);
            }
            AppMethodBeat.o(41815);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41815);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            db dbVar = (db) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbVar.xMN = aVar3.UbS.readString();
                    AppMethodBeat.o(41815);
                    return 0;
                case 2:
                    dbVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41815);
                    return 0;
                default:
                    AppMethodBeat.o(41815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41815);
            return -1;
        }
    }
}
