package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eyo extends a {
    public int KZk;
    public LinkedList<eyh> LUC = new LinkedList<>();
    public boolean LYI;

    public eyo() {
        AppMethodBeat.i(32525);
        AppMethodBeat.o(32525);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32526);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LUC);
            aVar.aM(2, this.KZk);
            aVar.cc(3, this.LYI);
            AppMethodBeat.o(32526);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LUC) + 0 + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(32526);
            return c2;
        } else if (i2 == 2) {
            this.LUC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32526);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyo eyo = (eyo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eyh eyh = new eyh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eyh.populateBuilderWithField(aVar4, eyh, a.getNextFieldNumber(aVar4))) {
                        }
                        eyo.LUC.add(eyh);
                    }
                    AppMethodBeat.o(32526);
                    return 0;
                case 2:
                    eyo.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(32526);
                    return 0;
                case 3:
                    eyo.LYI = aVar3.UbS.yZ();
                    AppMethodBeat.o(32526);
                    return 0;
                default:
                    AppMethodBeat.o(32526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32526);
            return -1;
        }
    }
}
