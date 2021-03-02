package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a extends com.tencent.mm.bw.a {
    public String username;
    public boolean yaY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225884);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(225884);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.cc(2, this.yaY);
            AppMethodBeat.o(225884);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            AppMethodBeat.o(225884);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar2 = new b("Not all required fields were included: username");
                AppMethodBeat.o(225884);
                throw bVar2;
            }
            AppMethodBeat.o(225884);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.UbS.readString();
                    AppMethodBeat.o(225884);
                    return 0;
                case 2:
                    aVar4.yaY = aVar3.UbS.yZ();
                    AppMethodBeat.o(225884);
                    return 0;
                default:
                    AppMethodBeat.o(225884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225884);
            return -1;
        }
    }
}
