package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class sy extends a {
    public b LaS;
    public long LaT;
    public long LaU;
    public boolean LaV;
    public long id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(218974);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LaS != null) {
                aVar.c(1, this.LaS);
            }
            aVar.bb(2, this.LaT);
            aVar.bb(3, this.LaU);
            aVar.cc(4, this.LaV);
            aVar.bb(5, this.id);
            AppMethodBeat.o(218974);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.LaS != null ? g.a.a.b.b.a.b(1, this.LaS) + 0 : 0) + g.a.a.b.b.a.r(2, this.LaT) + g.a.a.b.b.a.r(3, this.LaU) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.r(5, this.id);
            AppMethodBeat.o(218974);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(218974);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sy syVar = (sy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    syVar.LaS = aVar3.UbS.hPo();
                    AppMethodBeat.o(218974);
                    return 0;
                case 2:
                    syVar.LaT = aVar3.UbS.zl();
                    AppMethodBeat.o(218974);
                    return 0;
                case 3:
                    syVar.LaU = aVar3.UbS.zl();
                    AppMethodBeat.o(218974);
                    return 0;
                case 4:
                    syVar.LaV = aVar3.UbS.yZ();
                    AppMethodBeat.o(218974);
                    return 0;
                case 5:
                    syVar.id = aVar3.UbS.zl();
                    AppMethodBeat.o(218974);
                    return 0;
                default:
                    AppMethodBeat.o(218974);
                    return -1;
            }
        } else {
            AppMethodBeat.o(218974);
            return -1;
        }
    }
}
