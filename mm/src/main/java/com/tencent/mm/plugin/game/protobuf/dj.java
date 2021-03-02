package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dj extends a {
    public String xJD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149417);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJD == null) {
                b bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(149417);
                throw bVar;
            }
            if (this.xJD != null) {
                aVar.e(1, this.xJD);
            }
            AppMethodBeat.o(149417);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJD != null ? g.a.a.b.b.a.f(1, this.xJD) + 0 : 0;
            AppMethodBeat.o(149417);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xJD == null) {
                b bVar2 = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(149417);
                throw bVar2;
            }
            AppMethodBeat.o(149417);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dj djVar = (dj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    djVar.xJD = aVar3.UbS.readString();
                    AppMethodBeat.o(149417);
                    return 0;
                default:
                    AppMethodBeat.o(149417);
                    return -1;
            }
        } else {
            AppMethodBeat.o(149417);
            return -1;
        }
    }
}
