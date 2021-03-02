package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<Long> DSa = new LinkedList<>();
    public int DSb;
    public int DSc;
    public int DSd;
    public int state;
    public LinkedList<Long> tbl = new LinkedList<>();
    public long timestamp;

    public l() {
        AppMethodBeat.i(179121);
        AppMethodBeat.o(179121);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(179122);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 3, this.tbl);
            aVar.bb(2, this.timestamp);
            aVar.aM(3, this.state);
            aVar.e(4, 3, this.DSa);
            aVar.aM(5, this.DSb);
            aVar.aM(6, this.DSc);
            aVar.aM(7, this.DSd);
            AppMethodBeat.o(179122);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 3, this.tbl) + 0 + g.a.a.b.b.a.r(2, this.timestamp) + g.a.a.b.b.a.bu(3, this.state) + g.a.a.a.c(4, 3, this.DSa) + g.a.a.b.b.a.bu(5, this.DSb) + g.a.a.b.b.a.bu(6, this.DSc) + g.a.a.b.b.a.bu(7, this.DSd);
            AppMethodBeat.o(179122);
            return c2;
        } else if (i2 == 2) {
            this.tbl.clear();
            this.DSa.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(179122);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.tbl.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(179122);
                    return 0;
                case 2:
                    lVar.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(179122);
                    return 0;
                case 3:
                    lVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(179122);
                    return 0;
                case 4:
                    lVar.DSa.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(179122);
                    return 0;
                case 5:
                    lVar.DSb = aVar3.UbS.zi();
                    AppMethodBeat.o(179122);
                    return 0;
                case 6:
                    lVar.DSc = aVar3.UbS.zi();
                    AppMethodBeat.o(179122);
                    return 0;
                case 7:
                    lVar.DSd = aVar3.UbS.zi();
                    AppMethodBeat.o(179122);
                    return 0;
                default:
                    AppMethodBeat.o(179122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(179122);
            return -1;
        }
    }
}
