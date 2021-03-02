package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dt extends a {
    public String Name;
    public int xLX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41835);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name == null) {
                b bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(41835);
                throw bVar;
            }
            aVar.aM(1, this.xLX);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            AppMethodBeat.o(41835);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xLX) + 0;
            if (this.Name != null) {
                bu += g.a.a.b.b.a.f(2, this.Name);
            }
            AppMethodBeat.o(41835);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Name == null) {
                b bVar2 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(41835);
                throw bVar2;
            }
            AppMethodBeat.o(41835);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dt dtVar = (dt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dtVar.xLX = aVar3.UbS.zi();
                    AppMethodBeat.o(41835);
                    return 0;
                case 2:
                    dtVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(41835);
                    return 0;
                default:
                    AppMethodBeat.o(41835);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41835);
            return -1;
        }
    }
}
