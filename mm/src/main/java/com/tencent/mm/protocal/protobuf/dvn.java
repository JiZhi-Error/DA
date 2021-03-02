package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvn extends a {
    public LinkedList<String> Mhr = new LinkedList<>();

    public dvn() {
        AppMethodBeat.i(185588);
        AppMethodBeat.o(185588);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(185589);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 1, this.Mhr);
            AppMethodBeat.o(185589);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.Mhr) + 0;
            AppMethodBeat.o(185589);
            return c2;
        } else if (i2 == 2) {
            this.Mhr.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(185589);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            dvn dvn = (dvn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dvn.Mhr.add(aVar2.UbS.readString());
                    AppMethodBeat.o(185589);
                    return 0;
                default:
                    AppMethodBeat.o(185589);
                    return -1;
            }
        } else {
            AppMethodBeat.o(185589);
            return -1;
        }
    }
}
