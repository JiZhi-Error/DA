package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dpu extends a {
    public int MST;
    public LinkedList<dqc> MSU = new LinkedList<>();

    public dpu() {
        AppMethodBeat.i(181504);
        AppMethodBeat.o(181504);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(181505);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MST);
            aVar.e(2, 8, this.MSU);
            AppMethodBeat.o(181505);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MST) + 0 + g.a.a.a.c(2, 8, this.MSU);
            AppMethodBeat.o(181505);
            return bu;
        } else if (i2 == 2) {
            this.MSU.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(181505);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpu dpu = (dpu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpu.MST = aVar3.UbS.zi();
                    AppMethodBeat.o(181505);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqc dqc = new dqc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqc.populateBuilderWithField(aVar4, dqc, a.getNextFieldNumber(aVar4))) {
                        }
                        dpu.MSU.add(dqc);
                    }
                    AppMethodBeat.o(181505);
                    return 0;
                default:
                    AppMethodBeat.o(181505);
                    return -1;
            }
        } else {
            AppMethodBeat.o(181505);
            return -1;
        }
    }
}
