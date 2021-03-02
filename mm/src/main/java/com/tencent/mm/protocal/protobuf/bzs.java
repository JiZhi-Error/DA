package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bzs extends a {
    public LinkedList<bzr> oTA = new LinkedList<>();
    public int oTz;

    public bzs() {
        AppMethodBeat.i(43098);
        AppMethodBeat.o(43098);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43099);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oTz);
            aVar.e(2, 8, this.oTA);
            AppMethodBeat.o(43099);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTz) + 0 + g.a.a.a.c(2, 8, this.oTA);
            AppMethodBeat.o(43099);
            return bu;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43099);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzs bzs = (bzs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bzs.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(43099);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bzr bzr = new bzr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bzr.populateBuilderWithField(aVar4, bzr, a.getNextFieldNumber(aVar4))) {
                        }
                        bzs.oTA.add(bzr);
                    }
                    AppMethodBeat.o(43099);
                    return 0;
                default:
                    AppMethodBeat.o(43099);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43099);
            return -1;
        }
    }
}
