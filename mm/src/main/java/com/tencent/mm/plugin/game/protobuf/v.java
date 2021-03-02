package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class v extends a {
    public String xJI;
    public String xJJ;
    public String xJK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41720);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJI != null) {
                aVar.e(1, this.xJI);
            }
            if (this.xJJ != null) {
                aVar.e(2, this.xJJ);
            }
            if (this.xJK != null) {
                aVar.e(3, this.xJK);
            }
            AppMethodBeat.o(41720);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xJI != null ? g.a.a.b.b.a.f(1, this.xJI) + 0 : 0;
            if (this.xJJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.xJJ);
            }
            if (this.xJK != null) {
                f2 += g.a.a.b.b.a.f(3, this.xJK);
            }
            AppMethodBeat.o(41720);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41720);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vVar.xJI = aVar3.UbS.readString();
                    AppMethodBeat.o(41720);
                    return 0;
                case 2:
                    vVar.xJJ = aVar3.UbS.readString();
                    AppMethodBeat.o(41720);
                    return 0;
                case 3:
                    vVar.xJK = aVar3.UbS.readString();
                    AppMethodBeat.o(41720);
                    return 0;
                default:
                    AppMethodBeat.o(41720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41720);
            return -1;
        }
    }
}
