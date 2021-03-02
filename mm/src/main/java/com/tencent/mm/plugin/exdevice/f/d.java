package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public String rBK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23488);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rBK != null) {
                aVar.e(1, this.rBK);
            }
            AppMethodBeat.o(23488);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.rBK != null ? g.a.a.b.b.a.f(1, this.rBK) + 0 : 0;
            AppMethodBeat.o(23488);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(23488);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.rBK = aVar3.UbS.readString();
                    AppMethodBeat.o(23488);
                    return 0;
                default:
                    AppMethodBeat.o(23488);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23488);
            return -1;
        }
    }
}
