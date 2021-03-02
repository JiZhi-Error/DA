package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ag extends a {
    public String oTx;
    public LinkedList<Long> oUR = new LinkedList<>();
    public LinkedList<String> oUS = new LinkedList<>();
    public LinkedList<String> oUT = new LinkedList<>();

    public ag() {
        AppMethodBeat.i(22140);
        AppMethodBeat.o(22140);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22141);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oTx == null) {
                b bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22141);
                throw bVar;
            }
            aVar.e(1, 3, this.oUR);
            aVar.e(2, 1, this.oUS);
            aVar.e(3, 1, this.oUT);
            if (this.oTx != null) {
                aVar.e(4, this.oTx);
            }
            AppMethodBeat.o(22141);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 3, this.oUR) + 0 + g.a.a.a.c(2, 1, this.oUS) + g.a.a.a.c(3, 1, this.oUT);
            if (this.oTx != null) {
                c2 += g.a.a.b.b.a.f(4, this.oTx);
            }
            AppMethodBeat.o(22141);
            return c2;
        } else if (i2 == 2) {
            this.oUR.clear();
            this.oUS.clear();
            this.oUT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.oTx == null) {
                b bVar2 = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(22141);
                throw bVar2;
            }
            AppMethodBeat.o(22141);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.oUR.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(22141);
                    return 0;
                case 2:
                    agVar.oUS.add(aVar3.UbS.readString());
                    AppMethodBeat.o(22141);
                    return 0;
                case 3:
                    agVar.oUT.add(aVar3.UbS.readString());
                    AppMethodBeat.o(22141);
                    return 0;
                case 4:
                    agVar.oTx = aVar3.UbS.readString();
                    AppMethodBeat.o(22141);
                    return 0;
                default:
                    AppMethodBeat.o(22141);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22141);
            return -1;
        }
    }
}
