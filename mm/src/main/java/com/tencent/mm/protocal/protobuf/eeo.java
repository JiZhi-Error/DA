package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eeo extends a {
    public int NeL;
    public int NeM;
    public LinkedList<ctq> NeN = new LinkedList<>();

    public eeo() {
        AppMethodBeat.i(143986);
        AppMethodBeat.o(143986);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143987);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NeL);
            aVar.aM(2, this.NeM);
            aVar.e(3, 8, this.NeN);
            AppMethodBeat.o(143987);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NeL) + 0 + g.a.a.b.b.a.bu(2, this.NeM) + g.a.a.a.c(3, 8, this.NeN);
            AppMethodBeat.o(143987);
            return bu;
        } else if (i2 == 2) {
            this.NeN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143987);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eeo eeo = (eeo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eeo.NeL = aVar3.UbS.zi();
                    AppMethodBeat.o(143987);
                    return 0;
                case 2:
                    eeo.NeM = aVar3.UbS.zi();
                    AppMethodBeat.o(143987);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ctq ctq = new ctq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ctq.populateBuilderWithField(aVar4, ctq, a.getNextFieldNumber(aVar4))) {
                        }
                        eeo.NeN.add(ctq);
                    }
                    AppMethodBeat.o(143987);
                    return 0;
                default:
                    AppMethodBeat.o(143987);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143987);
            return -1;
        }
    }
}
