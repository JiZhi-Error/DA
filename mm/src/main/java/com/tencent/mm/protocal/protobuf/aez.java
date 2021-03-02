package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aez extends a {
    public long Id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125720);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).bb(1, this.Id);
            AppMethodBeat.o(125720);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            AppMethodBeat.o(125720);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(125720);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            aez aez = (aez) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aez.Id = aVar2.UbS.zl();
                    AppMethodBeat.o(125720);
                    return 0;
                default:
                    AppMethodBeat.o(125720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125720);
            return -1;
        }
    }
}
