package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class k extends a {
    public String APy;
    public String ThumbUrl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91263);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ThumbUrl != null) {
                aVar.e(1, this.ThumbUrl);
            }
            if (this.APy != null) {
                aVar.e(2, this.APy);
            }
            AppMethodBeat.o(91263);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ThumbUrl != null ? g.a.a.b.b.a.f(1, this.ThumbUrl) + 0 : 0;
            if (this.APy != null) {
                f2 += g.a.a.b.b.a.f(2, this.APy);
            }
            AppMethodBeat.o(91263);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91263);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(91263);
                    return 0;
                case 2:
                    kVar.APy = aVar3.UbS.readString();
                    AppMethodBeat.o(91263);
                    return 0;
                default:
                    AppMethodBeat.o(91263);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91263);
            return -1;
        }
    }
}
