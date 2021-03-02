package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class g extends a {
    public int KAB;
    public int KAR;
    public LinkedList<b> KAS = new LinkedList<>();
    public b KAT;

    public g() {
        AppMethodBeat.i(143947);
        AppMethodBeat.o(143947);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143948);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KAB);
            aVar.aM(2, this.KAR);
            aVar.e(3, 8, this.KAS);
            if (this.KAT != null) {
                aVar.c(4, this.KAT);
            }
            AppMethodBeat.o(143948);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAB) + 0 + g.a.a.b.b.a.bu(2, this.KAR) + g.a.a.a.c(3, 8, this.KAS);
            if (this.KAT != null) {
                bu += g.a.a.b.b.a.b(4, this.KAT);
            }
            AppMethodBeat.o(143948);
            return bu;
        } else if (i2 == 2) {
            this.KAS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143948);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.KAB = aVar3.UbS.zi();
                    AppMethodBeat.o(143948);
                    return 0;
                case 2:
                    gVar.KAR = aVar3.UbS.zi();
                    AppMethodBeat.o(143948);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        b bVar = new b();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.KAS.add(bVar);
                    }
                    AppMethodBeat.o(143948);
                    return 0;
                case 4:
                    gVar.KAT = aVar3.UbS.hPo();
                    AppMethodBeat.o(143948);
                    return 0;
                default:
                    AppMethodBeat.o(143948);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143948);
            return -1;
        }
    }
}
