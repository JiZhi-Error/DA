package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bd extends a {
    public String xKd;
    public LinkedList<String> xLf = new LinkedList<>();

    public bd() {
        AppMethodBeat.i(41750);
        AppMethodBeat.o(41750);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41751);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKd == null) {
                b bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41751);
                throw bVar;
            }
            if (this.xKd != null) {
                aVar.e(2, this.xKd);
            }
            aVar.e(3, 1, this.xLf);
            AppMethodBeat.o(41751);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xKd != null ? g.a.a.b.b.a.f(2, this.xKd) + 0 : 0) + g.a.a.a.c(3, 1, this.xLf);
            AppMethodBeat.o(41751);
            return f2;
        } else if (i2 == 2) {
            this.xLf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xKd == null) {
                b bVar2 = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(41751);
                throw bVar2;
            }
            AppMethodBeat.o(41751);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bd bdVar = (bd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    bdVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(41751);
                    return 0;
                case 3:
                    bdVar.xLf.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41751);
                    return 0;
                default:
                    AppMethodBeat.o(41751);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41751);
            return -1;
        }
    }
}
