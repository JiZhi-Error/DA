package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cis extends a {
    public b MnG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207497);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MnG != null) {
                aVar.c(1, this.MnG);
            }
            AppMethodBeat.o(207497);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.MnG != null ? g.a.a.b.b.a.b(1, this.MnG) + 0 : 0;
            AppMethodBeat.o(207497);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207497);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cis cis = (cis) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cis.MnG = aVar3.UbS.hPo();
                    AppMethodBeat.o(207497);
                    return 0;
                default:
                    AppMethodBeat.o(207497);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207497);
            return -1;
        }
    }
}
