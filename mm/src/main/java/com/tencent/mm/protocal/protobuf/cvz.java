package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvz extends a {
    public String jHa;
    public String pWh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152641);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jHa != null) {
                aVar.e(1, this.jHa);
            }
            if (this.pWh != null) {
                aVar.e(2, this.pWh);
            }
            AppMethodBeat.o(152641);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jHa != null ? g.a.a.b.b.a.f(1, this.jHa) + 0 : 0;
            if (this.pWh != null) {
                f2 += g.a.a.b.b.a.f(2, this.pWh);
            }
            AppMethodBeat.o(152641);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152641);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvz cvz = (cvz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvz.jHa = aVar3.UbS.readString();
                    AppMethodBeat.o(152641);
                    return 0;
                case 2:
                    cvz.pWh = aVar3.UbS.readString();
                    AppMethodBeat.o(152641);
                    return 0;
                default:
                    AppMethodBeat.o(152641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152641);
            return -1;
        }
    }
}
