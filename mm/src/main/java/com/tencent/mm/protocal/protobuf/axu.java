package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axu extends a {
    public long hFK;
    public String objectNonceId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209573);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hFK);
            if (this.objectNonceId != null) {
                aVar.e(2, this.objectNonceId);
            }
            AppMethodBeat.o(209573);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hFK) + 0;
            if (this.objectNonceId != null) {
                r += g.a.a.b.b.a.f(2, this.objectNonceId);
            }
            AppMethodBeat.o(209573);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209573);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axu axu = (axu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axu.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209573);
                    return 0;
                case 2:
                    axu.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(209573);
                    return 0;
                default:
                    AppMethodBeat.o(209573);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209573);
            return -1;
        }
    }
}
