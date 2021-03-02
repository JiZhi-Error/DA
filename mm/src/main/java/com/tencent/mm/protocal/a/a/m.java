package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class m extends a {
    public int KBe;
    public int KBf;
    public LinkedList<n> KBg = new LinkedList<>();

    public m() {
        AppMethodBeat.i(143956);
        AppMethodBeat.o(143956);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143957);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KBe);
            aVar.aM(2, this.KBf);
            aVar.e(3, 8, this.KBg);
            AppMethodBeat.o(143957);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KBe) + 0 + g.a.a.b.b.a.bu(2, this.KBf) + g.a.a.a.c(3, 8, this.KBg);
            AppMethodBeat.o(143957);
            return bu;
        } else if (i2 == 2) {
            this.KBg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143957);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.KBe = aVar3.UbS.zi();
                    AppMethodBeat.o(143957);
                    return 0;
                case 2:
                    mVar.KBf = aVar3.UbS.zi();
                    AppMethodBeat.o(143957);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        n nVar = new n();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.KBg.add(nVar);
                    }
                    AppMethodBeat.o(143957);
                    return 0;
                default:
                    AppMethodBeat.o(143957);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143957);
            return -1;
        }
    }
}
