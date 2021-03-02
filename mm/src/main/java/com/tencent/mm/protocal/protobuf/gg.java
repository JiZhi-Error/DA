package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class gg extends a {
    public long KKb;
    public int ReqType;
    public String Url;
    public int iAb;
    public String izX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124391);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.izX != null) {
                aVar.e(1, this.izX);
            }
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            aVar.aM(3, this.ReqType);
            aVar.aM(4, this.iAb);
            aVar.bb(5, this.KKb);
            AppMethodBeat.o(124391);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.izX != null ? g.a.a.b.b.a.f(1, this.izX) + 0 : 0;
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(2, this.Url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.ReqType) + g.a.a.b.b.a.bu(4, this.iAb) + g.a.a.b.b.a.r(5, this.KKb);
            AppMethodBeat.o(124391);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124391);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gg ggVar = (gg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ggVar.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(124391);
                    return 0;
                case 2:
                    ggVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(124391);
                    return 0;
                case 3:
                    ggVar.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(124391);
                    return 0;
                case 4:
                    ggVar.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(124391);
                    return 0;
                case 5:
                    ggVar.KKb = aVar3.UbS.zl();
                    AppMethodBeat.o(124391);
                    return 0;
                default:
                    AppMethodBeat.o(124391);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124391);
            return -1;
        }
    }
}
