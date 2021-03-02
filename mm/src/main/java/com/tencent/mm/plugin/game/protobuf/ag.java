package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ag extends a {
    public String Name;
    public String xJE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41726);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJE != null) {
                aVar.e(1, this.xJE);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            AppMethodBeat.o(41726);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJE != null ? g.a.a.b.b.a.f(1, this.xJE) + 0 : 0;
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(2, this.Name);
            }
            AppMethodBeat.o(41726);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41726);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(41726);
                    return 0;
                case 2:
                    agVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(41726);
                    return 0;
                default:
                    AppMethodBeat.o(41726);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41726);
            return -1;
        }
    }
}
