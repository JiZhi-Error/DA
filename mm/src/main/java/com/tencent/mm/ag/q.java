package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class q extends a {
    public int ReqType;
    public String Url;
    public int iAb;
    public String iAc;
    public long msgId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            aVar.aM(2, this.ReqType);
            aVar.aM(3, this.iAb);
            if (this.iAc != null) {
                aVar.e(4, this.iAc);
            }
            aVar.bb(5, this.msgId);
            AppMethodBeat.o(116412);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Url != null ? g.a.a.b.b.a.f(1, this.Url) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ReqType) + g.a.a.b.b.a.bu(3, this.iAb);
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(4, this.iAc);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.msgId);
            AppMethodBeat.o(116412);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(116412);
                    return 0;
                case 2:
                    qVar.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(116412);
                    return 0;
                case 3:
                    qVar.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(116412);
                    return 0;
                case 4:
                    qVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(116412);
                    return 0;
                case 5:
                    qVar.msgId = aVar3.UbS.zl();
                    AppMethodBeat.o(116412);
                    return 0;
                default:
                    AppMethodBeat.o(116412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116412);
            return -1;
        }
    }
}
