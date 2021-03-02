package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class df extends a {
    public LinkedList<dg> xMT = new LinkedList<>();
    public String xMU;
    public String xMk;

    public df() {
        AppMethodBeat.i(41819);
        AppMethodBeat.o(41819);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41820);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xMT);
            if (this.xMk != null) {
                aVar.e(2, this.xMk);
            }
            if (this.xMU != null) {
                aVar.e(3, this.xMU);
            }
            AppMethodBeat.o(41820);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xMT) + 0;
            if (this.xMk != null) {
                c2 += g.a.a.b.b.a.f(2, this.xMk);
            }
            if (this.xMU != null) {
                c2 += g.a.a.b.b.a.f(3, this.xMU);
            }
            AppMethodBeat.o(41820);
            return c2;
        } else if (i2 == 2) {
            this.xMT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41820);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dg dgVar = new dg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dgVar.populateBuilderWithField(aVar4, dgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dfVar.xMT.add(dgVar);
                    }
                    AppMethodBeat.o(41820);
                    return 0;
                case 2:
                    dfVar.xMk = aVar3.UbS.readString();
                    AppMethodBeat.o(41820);
                    return 0;
                case 3:
                    dfVar.xMU = aVar3.UbS.readString();
                    AppMethodBeat.o(41820);
                    return 0;
                default:
                    AppMethodBeat.o(41820);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41820);
            return -1;
        }
    }
}
