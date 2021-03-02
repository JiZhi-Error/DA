package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ys extends a {
    public b LjS;
    public LinkedList<b> LjT = new LinkedList<>();

    public ys() {
        AppMethodBeat.i(123563);
        AppMethodBeat.o(123563);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123564);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LjS != null) {
                aVar.c(1, this.LjS);
            }
            aVar.e(2, 6, this.LjT);
            AppMethodBeat.o(123564);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.LjS != null ? g.a.a.b.b.a.b(1, this.LjS) + 0 : 0) + g.a.a.a.c(2, 6, this.LjT);
            AppMethodBeat.o(123564);
            return b2;
        } else if (i2 == 2) {
            this.LjT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123564);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ys ysVar = (ys) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ysVar.LjS = aVar3.UbS.hPo();
                    AppMethodBeat.o(123564);
                    return 0;
                case 2:
                    ysVar.LjT.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(123564);
                    return 0;
                default:
                    AppMethodBeat.o(123564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123564);
            return -1;
        }
    }
}
