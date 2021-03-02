package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class eyg extends a {
    public long Nvn;
    public b oTm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32516);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Nvn);
            if (this.oTm != null) {
                aVar.c(2, this.oTm);
            }
            AppMethodBeat.o(32516);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nvn) + 0;
            if (this.oTm != null) {
                r += g.a.a.b.b.a.b(2, this.oTm);
            }
            AppMethodBeat.o(32516);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32516);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyg eyg = (eyg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyg.Nvn = aVar3.UbS.zl();
                    AppMethodBeat.o(32516);
                    return 0;
                case 2:
                    eyg.oTm = aVar3.UbS.hPo();
                    AppMethodBeat.o(32516);
                    return 0;
                default:
                    AppMethodBeat.o(32516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32516);
            return -1;
        }
    }
}
