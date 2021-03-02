package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dps extends a {
    public int MSR;
    public LinkedList<dpr> MSS = new LinkedList<>();

    public dps() {
        AppMethodBeat.i(194549);
        AppMethodBeat.o(194549);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MSR);
            aVar.e(2, 8, this.MSS);
            AppMethodBeat.o(194550);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MSR) + 0 + g.a.a.a.c(2, 8, this.MSS);
            AppMethodBeat.o(194550);
            return bu;
        } else if (i2 == 2) {
            this.MSS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dps dps = (dps) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dps.MSR = aVar3.UbS.zi();
                    AppMethodBeat.o(194550);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dpr dpr = new dpr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dpr.populateBuilderWithField(aVar4, dpr, a.getNextFieldNumber(aVar4))) {
                        }
                        dps.MSS.add(dpr);
                    }
                    AppMethodBeat.o(194550);
                    return 0;
                default:
                    AppMethodBeat.o(194550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194550);
            return -1;
        }
    }
}
