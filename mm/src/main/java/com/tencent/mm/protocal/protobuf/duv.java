package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class duv extends a {
    public b MWa;
    public b MlG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117924);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MWa == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Name");
                AppMethodBeat.o(117924);
                throw bVar;
            } else if (this.MlG == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Value");
                AppMethodBeat.o(117924);
                throw bVar2;
            } else {
                if (this.MWa != null) {
                    aVar.c(1, this.MWa);
                }
                if (this.MlG != null) {
                    aVar.c(2, this.MlG);
                }
                AppMethodBeat.o(117924);
                return 0;
            }
        } else if (i2 == 1) {
            int b2 = this.MWa != null ? g.a.a.b.b.a.b(1, this.MWa) + 0 : 0;
            if (this.MlG != null) {
                b2 += g.a.a.b.b.a.b(2, this.MlG);
            }
            AppMethodBeat.o(117924);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MWa == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Name");
                AppMethodBeat.o(117924);
                throw bVar3;
            } else if (this.MlG == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: Value");
                AppMethodBeat.o(117924);
                throw bVar4;
            } else {
                AppMethodBeat.o(117924);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duv duv = (duv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    duv.MWa = aVar3.UbS.hPo();
                    AppMethodBeat.o(117924);
                    return 0;
                case 2:
                    duv.MlG = aVar3.UbS.hPo();
                    AppMethodBeat.o(117924);
                    return 0;
                default:
                    AppMethodBeat.o(117924);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117924);
            return -1;
        }
    }
}
