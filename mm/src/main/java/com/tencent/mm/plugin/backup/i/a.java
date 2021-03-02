package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a extends com.tencent.mm.bw.a {
    public String ID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22101);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                b bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22101);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            AppMethodBeat.o(22101);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0;
            AppMethodBeat.o(22101);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                b bVar2 = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22101);
                throw bVar2;
            }
            AppMethodBeat.o(22101);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22101);
                    return 0;
                default:
                    AppMethodBeat.o(22101);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22101);
            return -1;
        }
    }
}
