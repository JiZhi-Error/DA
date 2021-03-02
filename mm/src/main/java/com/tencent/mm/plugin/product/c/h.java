package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class h extends a {
    public boolean iJ;
    public String id;
    public String name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91274);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.cc(3, this.iJ);
            AppMethodBeat.o(91274);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(91274);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91274);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.id = aVar3.UbS.readString();
                    AppMethodBeat.o(91274);
                    return 0;
                case 2:
                    hVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91274);
                    return 0;
                case 3:
                    hVar.iJ = aVar3.UbS.yZ();
                    AppMethodBeat.o(91274);
                    return 0;
                default:
                    AppMethodBeat.o(91274);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91274);
            return -1;
        }
    }
}
