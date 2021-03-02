package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class x extends a {
    public int yVn;
    public LinkedList<y> yVw = new LinkedList<>();
    public int yWi;
    public long yWj;
    public int yWk;
    public long yWl;
    public int yWm;

    public x() {
        AppMethodBeat.i(91255);
        AppMethodBeat.o(91255);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91256);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.yWi);
            aVar.bb(2, this.yWj);
            aVar.aM(3, this.yWk);
            aVar.bb(4, this.yWl);
            aVar.aM(5, this.yWm);
            aVar.aM(6, this.yVn);
            aVar.e(7, 8, this.yVw);
            AppMethodBeat.o(91256);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.yWi) + 0 + g.a.a.b.b.a.r(2, this.yWj) + g.a.a.b.b.a.bu(3, this.yWk) + g.a.a.b.b.a.r(4, this.yWl) + g.a.a.b.b.a.bu(5, this.yWm) + g.a.a.b.b.a.bu(6, this.yVn) + g.a.a.a.c(7, 8, this.yVw);
            AppMethodBeat.o(91256);
            return bu;
        } else if (i2 == 2) {
            this.yVw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91256);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xVar.yWi = aVar3.UbS.zi();
                    AppMethodBeat.o(91256);
                    return 0;
                case 2:
                    xVar.yWj = aVar3.UbS.zl();
                    AppMethodBeat.o(91256);
                    return 0;
                case 3:
                    xVar.yWk = aVar3.UbS.zi();
                    AppMethodBeat.o(91256);
                    return 0;
                case 4:
                    xVar.yWl = aVar3.UbS.zl();
                    AppMethodBeat.o(91256);
                    return 0;
                case 5:
                    xVar.yWm = aVar3.UbS.zi();
                    AppMethodBeat.o(91256);
                    return 0;
                case 6:
                    xVar.yVn = aVar3.UbS.zi();
                    AppMethodBeat.o(91256);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        y yVar = new y();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = yVar.populateBuilderWithField(aVar4, yVar, a.getNextFieldNumber(aVar4))) {
                        }
                        xVar.yVw.add(yVar);
                    }
                    AppMethodBeat.o(91256);
                    return 0;
                default:
                    AppMethodBeat.o(91256);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91256);
            return -1;
        }
    }
}
