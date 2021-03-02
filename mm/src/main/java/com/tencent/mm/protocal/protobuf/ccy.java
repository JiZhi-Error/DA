package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ccy extends a {
    public String KNW;
    public float height;
    public String url;
    public float width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91522);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.KNW != null) {
                aVar.e(2, this.KNW);
            }
            aVar.E(3, this.width);
            aVar.E(4, this.height);
            AppMethodBeat.o(91522);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.KNW != null) {
                f2 += g.a.a.b.b.a.f(2, this.KNW);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            AppMethodBeat.o(91522);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91522);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccy ccy = (ccy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccy.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91522);
                    return 0;
                case 2:
                    ccy.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91522);
                    return 0;
                case 3:
                    ccy.width = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(91522);
                    return 0;
                case 4:
                    ccy.height = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(91522);
                    return 0;
                default:
                    AppMethodBeat.o(91522);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91522);
            return -1;
        }
    }
}
