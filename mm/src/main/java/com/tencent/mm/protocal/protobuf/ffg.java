package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ffg extends a {
    public int Lrq;
    public LinkedList<cgy> NAB = new LinkedList<>();
    public int oTz;

    public ffg() {
        AppMethodBeat.i(197142);
        AppMethodBeat.o(197142);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(197143);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lrq);
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.NAB);
            AppMethodBeat.o(197143);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lrq) + 0 + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.NAB);
            AppMethodBeat.o(197143);
            return bu;
        } else if (i2 == 2) {
            this.NAB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(197143);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffg ffg = (ffg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ffg.Lrq = aVar3.UbS.zi();
                    AppMethodBeat.o(197143);
                    return 0;
                case 2:
                    ffg.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(197143);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cgy cgy = new cgy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cgy.populateBuilderWithField(aVar4, cgy, a.getNextFieldNumber(aVar4))) {
                        }
                        ffg.NAB.add(cgy);
                    }
                    AppMethodBeat.o(197143);
                    return 0;
                default:
                    AppMethodBeat.o(197143);
                    return -1;
            }
        } else {
            AppMethodBeat.o(197143);
            return -1;
        }
    }
}
