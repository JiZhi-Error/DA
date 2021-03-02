package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dbo extends a {
    public LinkedList<pe> MGw = new LinkedList<>();
    public LinkedList<String> MGx = new LinkedList<>();
    public LinkedList<String> MGy = new LinkedList<>();

    public dbo() {
        AppMethodBeat.i(212283);
        AppMethodBeat.o(212283);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212284);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.MGw);
            aVar.e(2, 1, this.MGx);
            aVar.e(3, 1, this.MGy);
            AppMethodBeat.o(212284);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MGw) + 0 + g.a.a.a.c(2, 1, this.MGx) + g.a.a.a.c(3, 1, this.MGy);
            AppMethodBeat.o(212284);
            return c2;
        } else if (i2 == 2) {
            this.MGw.clear();
            this.MGx.clear();
            this.MGy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212284);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbo dbo = (dbo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pe peVar = new pe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = peVar.populateBuilderWithField(aVar4, peVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dbo.MGw.add(peVar);
                    }
                    AppMethodBeat.o(212284);
                    return 0;
                case 2:
                    dbo.MGx.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212284);
                    return 0;
                case 3:
                    dbo.MGy.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212284);
                    return 0;
                default:
                    AppMethodBeat.o(212284);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212284);
            return -1;
        }
    }
}
