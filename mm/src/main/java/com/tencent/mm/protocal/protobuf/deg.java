package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class deg extends a {
    public LinkedList<String> MJp = new LinkedList<>();

    public deg() {
        AppMethodBeat.i(224538);
        AppMethodBeat.o(224538);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224539);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 1, this.MJp);
            AppMethodBeat.o(224539);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.MJp) + 0;
            AppMethodBeat.o(224539);
            return c2;
        } else if (i2 == 2) {
            this.MJp.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(224539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            deg deg = (deg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    deg.MJp.add(aVar2.UbS.readString());
                    AppMethodBeat.o(224539);
                    return 0;
                default:
                    AppMethodBeat.o(224539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224539);
            return -1;
        }
    }
}
