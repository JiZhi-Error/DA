package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkq extends a {
    public String KWA;
    public LinkedList<String> KWr = new LinkedList<>();
    public long MOF;

    public dkq() {
        AppMethodBeat.i(212292);
        AppMethodBeat.o(212292);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212293);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWA != null) {
                aVar.e(1, this.KWA);
            }
            aVar.bb(2, this.MOF);
            aVar.e(3, 1, this.KWr);
            AppMethodBeat.o(212293);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KWA != null ? g.a.a.b.b.a.f(1, this.KWA) + 0 : 0) + g.a.a.b.b.a.r(2, this.MOF) + g.a.a.a.c(3, 1, this.KWr);
            AppMethodBeat.o(212293);
            return f2;
        } else if (i2 == 2) {
            this.KWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212293);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkq dkq = (dkq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkq.KWA = aVar3.UbS.readString();
                    AppMethodBeat.o(212293);
                    return 0;
                case 2:
                    dkq.MOF = aVar3.UbS.zl();
                    AppMethodBeat.o(212293);
                    return 0;
                case 3:
                    dkq.KWr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212293);
                    return 0;
                default:
                    AppMethodBeat.o(212293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212293);
            return -1;
        }
    }
}
