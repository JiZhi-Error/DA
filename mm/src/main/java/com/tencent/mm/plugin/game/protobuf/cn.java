package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cn extends a {
    public String Title;
    public String iAc;
    public LinkedList<String> xMw = new LinkedList<>();

    public cn() {
        AppMethodBeat.i(41799);
        AppMethodBeat.o(41799);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41800);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.iAc != null) {
                aVar.e(2, this.iAc);
            }
            aVar.e(3, 1, this.xMw);
            AppMethodBeat.o(41800);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(2, this.iAc);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.xMw);
            AppMethodBeat.o(41800);
            return c2;
        } else if (i2 == 2) {
            this.xMw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41800);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cn cnVar = (cn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cnVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41800);
                    return 0;
                case 2:
                    cnVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(41800);
                    return 0;
                case 3:
                    cnVar.xMw.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41800);
                    return 0;
                default:
                    AppMethodBeat.o(41800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41800);
            return -1;
        }
    }
}
