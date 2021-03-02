package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public int cSx;
    public int dTg;
    public LinkedList<b> gCs = new LinkedList<>();
    public String gCt;
    public int gCu;
    public int maxCount;
    public int status;
    public int type;

    public a() {
        AppMethodBeat.i(42660);
        AppMethodBeat.o(42660);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42661);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.gCs);
            aVar.aM(2, this.cSx);
            aVar.aM(3, this.type);
            aVar.aM(4, this.status);
            aVar.aM(5, this.maxCount);
            if (this.gCt != null) {
                aVar.e(6, this.gCt);
            }
            aVar.aM(7, this.dTg);
            aVar.aM(8, this.gCu);
            AppMethodBeat.o(42661);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.gCs) + 0 + g.a.a.b.b.a.bu(2, this.cSx) + g.a.a.b.b.a.bu(3, this.type) + g.a.a.b.b.a.bu(4, this.status) + g.a.a.b.b.a.bu(5, this.maxCount);
            if (this.gCt != null) {
                c2 += g.a.a.b.b.a.f(6, this.gCt);
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.dTg) + g.a.a.b.b.a.bu(8, this.gCu);
            AppMethodBeat.o(42661);
            return bu;
        } else if (i2 == 2) {
            this.gCs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42661);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        b bVar = new b();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bVar.populateBuilderWithField(aVar5, bVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.gCs.add(bVar);
                    }
                    AppMethodBeat.o(42661);
                    return 0;
                case 2:
                    aVar4.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                case 3:
                    aVar4.type = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                case 4:
                    aVar4.status = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                case 5:
                    aVar4.maxCount = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                case 6:
                    aVar4.gCt = aVar3.UbS.readString();
                    AppMethodBeat.o(42661);
                    return 0;
                case 7:
                    aVar4.dTg = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                case 8:
                    aVar4.gCu = aVar3.UbS.zi();
                    AppMethodBeat.o(42661);
                    return 0;
                default:
                    AppMethodBeat.o(42661);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42661);
            return -1;
        }
    }
}
