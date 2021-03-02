package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class j extends a {
    public LinkedList<String> oTB = new LinkedList<>();
    public LinkedList<Long> oTC = new LinkedList<>();

    public j() {
        AppMethodBeat.i(22112);
        AppMethodBeat.o(22112);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22113);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.oTB);
            aVar.e(2, 3, this.oTC);
            AppMethodBeat.o(22113);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.oTB) + 0 + g.a.a.a.c(2, 3, this.oTC);
            AppMethodBeat.o(22113);
            return c2;
        } else if (i2 == 2) {
            this.oTB.clear();
            this.oTC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22113);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.oTB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(22113);
                    return 0;
                case 2:
                    jVar.oTC.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(22113);
                    return 0;
                default:
                    AppMethodBeat.o(22113);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22113);
            return -1;
        }
    }
}
