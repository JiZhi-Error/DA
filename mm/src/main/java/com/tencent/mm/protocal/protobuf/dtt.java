package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtt extends dop {
    public LinkedList<cot> oTA = new LinkedList<>();
    public int oTz;

    public dtt() {
        AppMethodBeat.i(43127);
        AppMethodBeat.o(43127);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43128);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            aVar.aM(1, this.oTz);
            aVar.e(2, 8, this.oTA);
            AppMethodBeat.o(43128);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTz) + 0 + g.a.a.a.c(2, 8, this.oTA);
            AppMethodBeat.o(43128);
            return bu;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43128);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtt dtt = (dtt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dtt.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(43128);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cot cot = new cot();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cot.populateBuilderWithField(aVar4, cot, dop.getNextFieldNumber(aVar4))) {
                        }
                        dtt.oTA.add(cot);
                    }
                    AppMethodBeat.o(43128);
                    return 0;
                default:
                    AppMethodBeat.o(43128);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43128);
            return -1;
        }
    }
}
