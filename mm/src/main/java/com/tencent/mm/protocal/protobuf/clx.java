package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class clx extends a {
    public LinkedList<b> Mrl = new LinkedList<>();

    public clx() {
        AppMethodBeat.i(147771);
        AppMethodBeat.o(147771);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147772);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 6, this.Mrl);
            AppMethodBeat.o(147772);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 6, this.Mrl) + 0;
            AppMethodBeat.o(147772);
            return c2;
        } else if (i2 == 2) {
            this.Mrl.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(147772);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            clx clx = (clx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clx.Mrl.add(aVar2.UbS.hPo());
                    AppMethodBeat.o(147772);
                    return 0;
                default:
                    AppMethodBeat.o(147772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147772);
            return -1;
        }
    }
}
