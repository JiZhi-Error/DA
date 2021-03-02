package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cbd extends a {
    public b MgA;
    public long eht;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116328);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.eht);
            if (this.MgA != null) {
                aVar.c(2, this.MgA);
            }
            AppMethodBeat.o(116328);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.eht) + 0;
            if (this.MgA != null) {
                r += g.a.a.b.b.a.b(2, this.MgA);
            }
            AppMethodBeat.o(116328);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116328);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbd cbd = (cbd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbd.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(116328);
                    return 0;
                case 2:
                    cbd.MgA = aVar3.UbS.hPo();
                    AppMethodBeat.o(116328);
                    return 0;
                default:
                    AppMethodBeat.o(116328);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116328);
            return -1;
        }
    }
}
