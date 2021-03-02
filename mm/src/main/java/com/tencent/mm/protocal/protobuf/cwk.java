package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cwk extends a {
    public b MBx;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43115);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MBx == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: buf");
                AppMethodBeat.o(43115);
                throw bVar;
            }
            aVar.aM(1, this.type);
            if (this.MBx != null) {
                aVar.c(2, this.MBx);
            }
            AppMethodBeat.o(43115);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.MBx != null) {
                bu += g.a.a.b.b.a.b(2, this.MBx);
            }
            AppMethodBeat.o(43115);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MBx == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: buf");
                AppMethodBeat.o(43115);
                throw bVar2;
            }
            AppMethodBeat.o(43115);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cwk cwk = (cwk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwk.type = aVar3.UbS.zi();
                    AppMethodBeat.o(43115);
                    return 0;
                case 2:
                    cwk.MBx = aVar3.UbS.hPo();
                    AppMethodBeat.o(43115);
                    return 0;
                default:
                    AppMethodBeat.o(43115);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43115);
            return -1;
        }
    }
}
