package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class mn extends a {
    public b KQI;
    public b KQJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104358);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KQI != null) {
                aVar.c(1, this.KQI);
            }
            if (this.KQJ != null) {
                aVar.c(2, this.KQJ);
            }
            AppMethodBeat.o(104358);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.KQI != null ? g.a.a.b.b.a.b(1, this.KQI) + 0 : 0;
            if (this.KQJ != null) {
                b2 += g.a.a.b.b.a.b(2, this.KQJ);
            }
            AppMethodBeat.o(104358);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104358);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            mn mnVar = (mn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mnVar.KQI = aVar3.UbS.hPo();
                    AppMethodBeat.o(104358);
                    return 0;
                case 2:
                    mnVar.KQJ = aVar3.UbS.hPo();
                    AppMethodBeat.o(104358);
                    return 0;
                default:
                    AppMethodBeat.o(104358);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104358);
            return -1;
        }
    }
}
