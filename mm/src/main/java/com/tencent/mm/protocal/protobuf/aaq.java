package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class aaq extends a {
    public b LlW;
    public b LlX;
    public int dataType;
    public int status;
    public long timestamp;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(145667);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LlW == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: version");
                AppMethodBeat.o(145667);
                throw bVar;
            } else if (this.LlX == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: clientcheckdata");
                AppMethodBeat.o(145667);
                throw bVar2;
            } else {
                if (this.LlW != null) {
                    aVar.c(1, this.LlW);
                }
                aVar.aM(2, this.type);
                if (this.LlX != null) {
                    aVar.c(3, this.LlX);
                }
                aVar.bb(4, this.timestamp);
                aVar.aM(5, this.dataType);
                aVar.aM(6, this.status);
                AppMethodBeat.o(145667);
                return 0;
            }
        } else if (i2 == 1) {
            int b2 = (this.LlW != null ? g.a.a.b.b.a.b(1, this.LlW) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type);
            if (this.LlX != null) {
                b2 += g.a.a.b.b.a.b(3, this.LlX);
            }
            int r = b2 + g.a.a.b.b.a.r(4, this.timestamp) + g.a.a.b.b.a.bu(5, this.dataType) + g.a.a.b.b.a.bu(6, this.status);
            AppMethodBeat.o(145667);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LlW == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: version");
                AppMethodBeat.o(145667);
                throw bVar3;
            } else if (this.LlX == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: clientcheckdata");
                AppMethodBeat.o(145667);
                throw bVar4;
            } else {
                AppMethodBeat.o(145667);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aaq aaq = (aaq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaq.LlW = aVar3.UbS.hPo();
                    AppMethodBeat.o(145667);
                    return 0;
                case 2:
                    aaq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(145667);
                    return 0;
                case 3:
                    aaq.LlX = aVar3.UbS.hPo();
                    AppMethodBeat.o(145667);
                    return 0;
                case 4:
                    aaq.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(145667);
                    return 0;
                case 5:
                    aaq.dataType = aVar3.UbS.zi();
                    AppMethodBeat.o(145667);
                    return 0;
                case 6:
                    aaq.status = aVar3.UbS.zi();
                    AppMethodBeat.o(145667);
                    return 0;
                default:
                    AppMethodBeat.o(145667);
                    return -1;
            }
        } else {
            AppMethodBeat.o(145667);
            return -1;
        }
    }
}
