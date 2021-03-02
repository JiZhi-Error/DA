package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class evd extends a {
    public String MiI;
    public long Nte;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147787);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Nte);
            if (this.MiI != null) {
                aVar.e(2, this.MiI);
            }
            AppMethodBeat.o(147787);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nte) + 0;
            if (this.MiI != null) {
                r += g.a.a.b.b.a.f(2, this.MiI);
            }
            AppMethodBeat.o(147787);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147787);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evd evd = (evd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evd.Nte = aVar3.UbS.zl();
                    AppMethodBeat.o(147787);
                    return 0;
                case 2:
                    evd.MiI = aVar3.UbS.readString();
                    AppMethodBeat.o(147787);
                    return 0;
                default:
                    AppMethodBeat.o(147787);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147787);
            return -1;
        }
    }
}
