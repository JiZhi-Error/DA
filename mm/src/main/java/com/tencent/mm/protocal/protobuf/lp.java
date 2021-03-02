package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class lp extends a {
    public long KPk;
    public long KPl;
    public LinkedList<ln> KPm = new LinkedList<>();
    public boolean KPn = false;
    public long uin;

    public lp() {
        AppMethodBeat.i(110888);
        AppMethodBeat.o(110888);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110889);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KPk);
            aVar.bb(2, this.uin);
            aVar.bb(3, this.KPl);
            aVar.e(4, 8, this.KPm);
            aVar.cc(5, this.KPn);
            AppMethodBeat.o(110889);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KPk) + 0 + g.a.a.b.b.a.r(2, this.uin) + g.a.a.b.b.a.r(3, this.KPl) + g.a.a.a.c(4, 8, this.KPm) + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(110889);
            return r;
        } else if (i2 == 2) {
            this.KPm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110889);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            lp lpVar = (lp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lpVar.KPk = aVar3.UbS.zl();
                    AppMethodBeat.o(110889);
                    return 0;
                case 2:
                    lpVar.uin = aVar3.UbS.zl();
                    AppMethodBeat.o(110889);
                    return 0;
                case 3:
                    lpVar.KPl = aVar3.UbS.zl();
                    AppMethodBeat.o(110889);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ln lnVar = new ln();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lnVar.populateBuilderWithField(aVar4, lnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lpVar.KPm.add(lnVar);
                    }
                    AppMethodBeat.o(110889);
                    return 0;
                case 5:
                    lpVar.KPn = aVar3.UbS.yZ();
                    AppMethodBeat.o(110889);
                    return 0;
                default:
                    AppMethodBeat.o(110889);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110889);
            return -1;
        }
    }
}
