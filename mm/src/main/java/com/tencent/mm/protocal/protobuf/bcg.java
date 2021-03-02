package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bcg extends a {
    public String LIb;
    public float dTj;
    public float latitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(164044);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LIb != null) {
                aVar.e(1, this.LIb);
            }
            aVar.E(2, this.dTj);
            aVar.E(3, this.latitude);
            AppMethodBeat.o(164044);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LIb != null ? g.a.a.b.b.a.f(1, this.LIb) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4;
            AppMethodBeat.o(164044);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(164044);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcg bcg = (bcg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcg.LIb = aVar3.UbS.readString();
                    AppMethodBeat.o(164044);
                    return 0;
                case 2:
                    bcg.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(164044);
                    return 0;
                case 3:
                    bcg.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(164044);
                    return 0;
                default:
                    AppMethodBeat.o(164044);
                    return -1;
            }
        } else {
            AppMethodBeat.o(164044);
            return -1;
        }
    }
}
