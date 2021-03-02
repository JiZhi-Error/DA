package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cgd extends a {
    public long KVX = 0;
    public LinkedList<String> MlP = new LinkedList<>();

    public cgd() {
        AppMethodBeat.i(220713);
        AppMethodBeat.o(220713);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220714);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KVX);
            aVar.e(2, 1, this.MlP);
            AppMethodBeat.o(220714);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KVX) + 0 + g.a.a.a.c(2, 1, this.MlP);
            AppMethodBeat.o(220714);
            return r;
        } else if (i2 == 2) {
            this.MlP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220714);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgd cgd = (cgd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgd.KVX = aVar3.UbS.zl();
                    AppMethodBeat.o(220714);
                    return 0;
                case 2:
                    cgd.MlP.add(aVar3.UbS.readString());
                    AppMethodBeat.o(220714);
                    return 0;
                default:
                    AppMethodBeat.o(220714);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220714);
            return -1;
        }
    }
}
