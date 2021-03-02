package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ajb extends a {
    public LinkedList<ene> LsE = new LinkedList<>();
    public int LsF;
    public boolean LsG = false;
    public int Scene;
    public int xIY = 0;

    public ajb() {
        AppMethodBeat.i(104763);
        AppMethodBeat.o(104763);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104764);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LsE);
            aVar.aM(2, this.LsF);
            aVar.cc(3, this.LsG);
            aVar.aM(4, this.xIY);
            aVar.aM(5, this.Scene);
            AppMethodBeat.o(104764);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LsE) + 0 + g.a.a.b.b.a.bu(2, this.LsF) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.xIY) + g.a.a.b.b.a.bu(5, this.Scene);
            AppMethodBeat.o(104764);
            return c2;
        } else if (i2 == 2) {
            this.LsE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104764);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajb ajb = (ajb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ene ene = new ene();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ene.populateBuilderWithField(aVar4, ene, a.getNextFieldNumber(aVar4))) {
                        }
                        ajb.LsE.add(ene);
                    }
                    AppMethodBeat.o(104764);
                    return 0;
                case 2:
                    ajb.LsF = aVar3.UbS.zi();
                    AppMethodBeat.o(104764);
                    return 0;
                case 3:
                    ajb.LsG = aVar3.UbS.yZ();
                    AppMethodBeat.o(104764);
                    return 0;
                case 4:
                    ajb.xIY = aVar3.UbS.zi();
                    AppMethodBeat.o(104764);
                    return 0;
                case 5:
                    ajb.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104764);
                    return 0;
                default:
                    AppMethodBeat.o(104764);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104764);
            return -1;
        }
    }
}
