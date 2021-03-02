package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class g extends a {
    public String country;
    public String fuJ;
    public String fuK;
    public String iUO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91273);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.country != null) {
                aVar.e(1, this.country);
            }
            if (this.fuJ != null) {
                aVar.e(2, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(3, this.fuK);
            }
            if (this.iUO != null) {
                aVar.e(4, this.iUO);
            }
            AppMethodBeat.o(91273);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.country != null ? g.a.a.b.b.a.f(1, this.country) + 0 : 0;
            if (this.fuJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.fuJ);
            }
            if (this.fuK != null) {
                f2 += g.a.a.b.b.a.f(3, this.fuK);
            }
            if (this.iUO != null) {
                f2 += g.a.a.b.b.a.f(4, this.iUO);
            }
            AppMethodBeat.o(91273);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91273);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.country = aVar3.UbS.readString();
                    AppMethodBeat.o(91273);
                    return 0;
                case 2:
                    gVar.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91273);
                    return 0;
                case 3:
                    gVar.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(91273);
                    return 0;
                case 4:
                    gVar.iUO = aVar3.UbS.readString();
                    AppMethodBeat.o(91273);
                    return 0;
                default:
                    AppMethodBeat.o(91273);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91273);
            return -1;
        }
    }
}
