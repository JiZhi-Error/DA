package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eis extends a {
    public String name;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153005);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.bb(2, this.timestamp);
            AppMethodBeat.o(153005);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.b.b.a.r(2, this.timestamp);
            AppMethodBeat.o(153005);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153005);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eis eis = (eis) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eis.name = aVar3.UbS.readString();
                    AppMethodBeat.o(153005);
                    return 0;
                case 2:
                    eis.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(153005);
                    return 0;
                default:
                    AppMethodBeat.o(153005);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153005);
            return -1;
        }
    }
}
