package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<String> oTB = new LinkedList<>();
    public LinkedList<Long> oTC = new LinkedList<>();

    public i() {
        AppMethodBeat.i(22110);
        AppMethodBeat.o(22110);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22111);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.oTB);
            aVar.e(2, 3, this.oTC);
            AppMethodBeat.o(22111);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.oTB) + 0 + g.a.a.a.c(2, 3, this.oTC);
            AppMethodBeat.o(22111);
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
            AppMethodBeat.o(22111);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iVar.oTB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(22111);
                    return 0;
                case 2:
                    iVar.oTC.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(22111);
                    return 0;
                default:
                    AppMethodBeat.o(22111);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22111);
            return -1;
        }
    }
}
