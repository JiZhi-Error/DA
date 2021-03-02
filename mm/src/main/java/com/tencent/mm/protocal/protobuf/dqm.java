package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dqm extends a {
    public LinkedList<ckf> MTs = new LinkedList<>();
    public boolean MTt;
    public boolean MTu;
    public boolean MTv;
    public boolean MTw;
    public boolean MTx;

    public dqm() {
        AppMethodBeat.i(155454);
        AppMethodBeat.o(155454);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155455);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.MTs);
            aVar.cc(2, this.MTt);
            aVar.cc(3, this.MTu);
            aVar.cc(4, this.MTv);
            aVar.cc(5, this.MTw);
            aVar.cc(6, this.MTx);
            AppMethodBeat.o(155455);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MTs) + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(155455);
            return c2;
        } else if (i2 == 2) {
            this.MTs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155455);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqm dqm = (dqm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ckf ckf = new ckf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ckf.populateBuilderWithField(aVar4, ckf, a.getNextFieldNumber(aVar4))) {
                        }
                        dqm.MTs.add(ckf);
                    }
                    AppMethodBeat.o(155455);
                    return 0;
                case 2:
                    dqm.MTt = aVar3.UbS.yZ();
                    AppMethodBeat.o(155455);
                    return 0;
                case 3:
                    dqm.MTu = aVar3.UbS.yZ();
                    AppMethodBeat.o(155455);
                    return 0;
                case 4:
                    dqm.MTv = aVar3.UbS.yZ();
                    AppMethodBeat.o(155455);
                    return 0;
                case 5:
                    dqm.MTw = aVar3.UbS.yZ();
                    AppMethodBeat.o(155455);
                    return 0;
                case 6:
                    dqm.MTx = aVar3.UbS.yZ();
                    AppMethodBeat.o(155455);
                    return 0;
                default:
                    AppMethodBeat.o(155455);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155455);
            return -1;
        }
    }
}
