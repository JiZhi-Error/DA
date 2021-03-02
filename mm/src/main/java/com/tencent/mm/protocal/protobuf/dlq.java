package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dlq extends a {
    public String dQx;
    public int number;
    public String type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72576);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.type != null) {
                aVar.e(1, this.type);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            aVar.aM(3, this.number);
            AppMethodBeat.o(72576);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.type != null ? g.a.a.b.b.a.f(1, this.type) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.number);
            AppMethodBeat.o(72576);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72576);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlq dlq = (dlq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlq.type = aVar3.UbS.readString();
                    AppMethodBeat.o(72576);
                    return 0;
                case 2:
                    dlq.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72576);
                    return 0;
                case 3:
                    dlq.number = aVar3.UbS.zi();
                    AppMethodBeat.o(72576);
                    return 0;
                default:
                    AppMethodBeat.o(72576);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72576);
            return -1;
        }
    }
}
