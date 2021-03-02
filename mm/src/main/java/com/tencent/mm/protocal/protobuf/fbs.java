package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fbs extends a {
    public LinkedList<String> NxQ = new LinkedList<>();
    public int version;

    public fbs() {
        AppMethodBeat.i(196216);
        AppMethodBeat.o(196216);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196217);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.version);
            aVar.e(2, 1, this.NxQ);
            AppMethodBeat.o(196217);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.version) + 0 + g.a.a.a.c(2, 1, this.NxQ);
            AppMethodBeat.o(196217);
            return bu;
        } else if (i2 == 2) {
            this.NxQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196217);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbs fbs = (fbs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbs.version = aVar3.UbS.zi();
                    AppMethodBeat.o(196217);
                    return 0;
                case 2:
                    fbs.NxQ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(196217);
                    return 0;
                default:
                    AppMethodBeat.o(196217);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196217);
            return -1;
        }
    }
}
