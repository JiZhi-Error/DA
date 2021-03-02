package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pd extends a {
    public long KVX = 0;
    public LinkedList<cbn> KVY = new LinkedList<>();

    public pd() {
        AppMethodBeat.i(220681);
        AppMethodBeat.o(220681);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220682);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KVX);
            aVar.e(2, 8, this.KVY);
            AppMethodBeat.o(220682);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KVX) + 0 + g.a.a.a.c(2, 8, this.KVY);
            AppMethodBeat.o(220682);
            return r;
        } else if (i2 == 2) {
            this.KVY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220682);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pd pdVar = (pd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pdVar.KVX = aVar3.UbS.zl();
                    AppMethodBeat.o(220682);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbn cbn = new cbn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbn.populateBuilderWithField(aVar4, cbn, a.getNextFieldNumber(aVar4))) {
                        }
                        pdVar.KVY.add(cbn);
                    }
                    AppMethodBeat.o(220682);
                    return 0;
                default:
                    AppMethodBeat.o(220682);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220682);
            return -1;
        }
    }
}
