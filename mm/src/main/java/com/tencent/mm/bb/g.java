package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class g extends a {
    public LinkedList<e> jgS = new LinkedList<>();
    public double jgT;

    public g() {
        AppMethodBeat.i(150797);
        AppMethodBeat.o(150797);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150798);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.jgS);
            aVar.e(2, this.jgT);
            AppMethodBeat.o(150798);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.jgS) + 0 + g.a.a.b.b.a.fS(2) + 8;
            AppMethodBeat.o(150798);
            return c2;
        } else if (i2 == 2) {
            this.jgS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150798);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.jgS.add(eVar);
                    }
                    AppMethodBeat.o(150798);
                    return 0;
                case 2:
                    gVar.jgT = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(150798);
                    return 0;
                default:
                    AppMethodBeat.o(150798);
                    return -1;
            }
        } else {
            AppMethodBeat.o(150798);
            return -1;
        }
    }
}
