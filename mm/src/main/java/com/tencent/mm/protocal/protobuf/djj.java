package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class djj extends a {
    public LinkedList<djk> MNv = new LinkedList<>();
    public int count;
    public int qwL;

    public djj() {
        AppMethodBeat.i(32400);
        AppMethodBeat.o(32400);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32401);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.count);
            aVar.e(2, 8, this.MNv);
            aVar.aM(3, this.qwL);
            AppMethodBeat.o(32401);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.count) + 0 + g.a.a.a.c(2, 8, this.MNv) + g.a.a.b.b.a.bu(3, this.qwL);
            AppMethodBeat.o(32401);
            return bu;
        } else if (i2 == 2) {
            this.MNv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32401);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djj djj = (djj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    djj.count = aVar3.UbS.zi();
                    AppMethodBeat.o(32401);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        djk djk = new djk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = djk.populateBuilderWithField(aVar4, djk, a.getNextFieldNumber(aVar4))) {
                        }
                        djj.MNv.add(djk);
                    }
                    AppMethodBeat.o(32401);
                    return 0;
                case 3:
                    djj.qwL = aVar3.UbS.zi();
                    AppMethodBeat.o(32401);
                    return 0;
                default:
                    AppMethodBeat.o(32401);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32401);
            return -1;
        }
    }
}
