package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ccs extends a {
    public int Miz;
    public LinkedList<cct> xKD = new LinkedList<>();

    public ccs() {
        AppMethodBeat.i(143979);
        AppMethodBeat.o(143979);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143980);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Miz);
            aVar.e(2, 8, this.xKD);
            AppMethodBeat.o(143980);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Miz) + 0 + g.a.a.a.c(2, 8, this.xKD);
            AppMethodBeat.o(143980);
            return bu;
        } else if (i2 == 2) {
            this.xKD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143980);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccs ccs = (ccs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccs.Miz = aVar3.UbS.zi();
                    AppMethodBeat.o(143980);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cct cct = new cct();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cct.populateBuilderWithField(aVar4, cct, a.getNextFieldNumber(aVar4))) {
                        }
                        ccs.xKD.add(cct);
                    }
                    AppMethodBeat.o(143980);
                    return 0;
                default:
                    AppMethodBeat.o(143980);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143980);
            return -1;
        }
    }
}
