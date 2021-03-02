package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ddg extends a {
    public int MIp;
    public LinkedList<efg> MIq = new LinkedList<>();
    public int him;

    public ddg() {
        AppMethodBeat.i(152661);
        AppMethodBeat.o(152661);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152662);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.him);
            aVar.aM(2, this.MIp);
            aVar.e(3, 8, this.MIq);
            AppMethodBeat.o(152662);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.him) + 0 + g.a.a.b.b.a.bu(2, this.MIp) + g.a.a.a.c(3, 8, this.MIq);
            AppMethodBeat.o(152662);
            return bu;
        } else if (i2 == 2) {
            this.MIq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152662);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddg ddg = (ddg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddg.him = aVar3.UbS.zi();
                    AppMethodBeat.o(152662);
                    return 0;
                case 2:
                    ddg.MIp = aVar3.UbS.zi();
                    AppMethodBeat.o(152662);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        efg efg = new efg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = efg.populateBuilderWithField(aVar4, efg, a.getNextFieldNumber(aVar4))) {
                        }
                        ddg.MIq.add(efg);
                    }
                    AppMethodBeat.o(152662);
                    return 0;
                default:
                    AppMethodBeat.o(152662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152662);
            return -1;
        }
    }
}
