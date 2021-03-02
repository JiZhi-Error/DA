package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class s extends a {
    public long oTS;
    public long oUo;
    public long oUp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22124);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.oTS);
            aVar.bb(2, this.oUo);
            aVar.bb(3, this.oUp);
            AppMethodBeat.o(22124);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.oTS) + 0 + g.a.a.b.b.a.r(2, this.oUo) + g.a.a.b.b.a.r(3, this.oUp);
            AppMethodBeat.o(22124);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22124);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sVar.oTS = aVar3.UbS.zl();
                    AppMethodBeat.o(22124);
                    return 0;
                case 2:
                    sVar.oUo = aVar3.UbS.zl();
                    AppMethodBeat.o(22124);
                    return 0;
                case 3:
                    sVar.oUp = aVar3.UbS.zl();
                    AppMethodBeat.o(22124);
                    return 0;
                default:
                    AppMethodBeat.o(22124);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22124);
            return -1;
        }
    }
}
