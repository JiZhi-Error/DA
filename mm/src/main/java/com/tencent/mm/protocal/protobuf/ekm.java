package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ekm extends a {
    public int NjD;
    public b NjE;
    public b NjF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(197138);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NjD);
            if (this.NjE != null) {
                aVar.c(2, this.NjE);
            }
            if (this.NjF != null) {
                aVar.c(3, this.NjF);
            }
            AppMethodBeat.o(197138);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NjD) + 0;
            if (this.NjE != null) {
                bu += g.a.a.b.b.a.b(2, this.NjE);
            }
            if (this.NjF != null) {
                bu += g.a.a.b.b.a.b(3, this.NjF);
            }
            AppMethodBeat.o(197138);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(197138);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekm ekm = (ekm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekm.NjD = aVar3.UbS.zi();
                    AppMethodBeat.o(197138);
                    return 0;
                case 2:
                    ekm.NjE = aVar3.UbS.hPo();
                    AppMethodBeat.o(197138);
                    return 0;
                case 3:
                    ekm.NjF = aVar3.UbS.hPo();
                    AppMethodBeat.o(197138);
                    return 0;
                default:
                    AppMethodBeat.o(197138);
                    return -1;
            }
        } else {
            AppMethodBeat.o(197138);
            return -1;
        }
    }
}