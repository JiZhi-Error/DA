package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cu extends a {
    public String jfi;
    public int xMC;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256644);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(256644);
                throw bVar;
            }
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.xut != null) {
                aVar.e(2, this.xut);
            }
            aVar.aM(3, this.xMC);
            AppMethodBeat.o(256644);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(2, this.xut);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.xMC);
            AppMethodBeat.o(256644);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar2 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(256644);
                throw bVar2;
            }
            AppMethodBeat.o(256644);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cu cuVar = (cu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(256644);
                    return 0;
                case 2:
                    cuVar.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(256644);
                    return 0;
                case 3:
                    cuVar.xMC = aVar3.UbS.zi();
                    AppMethodBeat.o(256644);
                    return 0;
                default:
                    AppMethodBeat.o(256644);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256644);
            return -1;
        }
    }
}
