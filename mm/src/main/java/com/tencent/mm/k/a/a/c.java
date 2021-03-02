package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class c extends a {
    public long gCA;
    public long gCB;
    public long gCy;
    public long gCz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42663);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.gCy);
            aVar.bb(2, this.gCz);
            aVar.bb(3, this.gCA);
            aVar.bb(4, this.gCB);
            AppMethodBeat.o(42663);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.gCy) + 0 + g.a.a.b.b.a.r(2, this.gCz) + g.a.a.b.b.a.r(3, this.gCA) + g.a.a.b.b.a.r(4, this.gCB);
            AppMethodBeat.o(42663);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42663);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.gCy = aVar3.UbS.zl();
                    AppMethodBeat.o(42663);
                    return 0;
                case 2:
                    cVar.gCz = aVar3.UbS.zl();
                    AppMethodBeat.o(42663);
                    return 0;
                case 3:
                    cVar.gCA = aVar3.UbS.zl();
                    AppMethodBeat.o(42663);
                    return 0;
                case 4:
                    cVar.gCB = aVar3.UbS.zl();
                    AppMethodBeat.o(42663);
                    return 0;
                default:
                    AppMethodBeat.o(42663);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42663);
            return -1;
        }
    }
}
