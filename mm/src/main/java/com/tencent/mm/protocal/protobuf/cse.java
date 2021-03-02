package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cse extends a {
    public b AqP;
    public boolean AqQ;
    public String MwX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256718);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwX != null) {
                aVar.e(1, this.MwX);
            }
            if (this.AqP != null) {
                aVar.c(2, this.AqP);
            }
            aVar.cc(3, this.AqQ);
            AppMethodBeat.o(256718);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwX != null ? g.a.a.b.b.a.f(1, this.MwX) + 0 : 0;
            if (this.AqP != null) {
                f2 += g.a.a.b.b.a.b(2, this.AqP);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(256718);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256718);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cse cse = (cse) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cse.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256718);
                    return 0;
                case 2:
                    cse.AqP = aVar3.UbS.hPo();
                    AppMethodBeat.o(256718);
                    return 0;
                case 3:
                    cse.AqQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(256718);
                    return 0;
                default:
                    AppMethodBeat.o(256718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256718);
            return -1;
        }
    }
}
