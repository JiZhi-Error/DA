package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ctt extends a {
    public LinkedList<tx> Lps = new LinkedList<>();
    public int Lpt;
    public int Lpu;
    public long lastUpdateTime;
    public int version;

    public ctt() {
        AppMethodBeat.i(32357);
        AppMethodBeat.o(32357);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32358);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Lps);
            aVar.aM(2, this.version);
            aVar.aM(3, this.Lpt);
            aVar.aM(4, this.Lpu);
            aVar.bb(5, this.lastUpdateTime);
            AppMethodBeat.o(32358);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lps) + 0 + g.a.a.b.b.a.bu(2, this.version) + g.a.a.b.b.a.bu(3, this.Lpt) + g.a.a.b.b.a.bu(4, this.Lpu) + g.a.a.b.b.a.r(5, this.lastUpdateTime);
            AppMethodBeat.o(32358);
            return c2;
        } else if (i2 == 2) {
            this.Lps.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32358);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctt ctt = (ctt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        tx txVar = new tx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = txVar.populateBuilderWithField(aVar4, txVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ctt.Lps.add(txVar);
                    }
                    AppMethodBeat.o(32358);
                    return 0;
                case 2:
                    ctt.version = aVar3.UbS.zi();
                    AppMethodBeat.o(32358);
                    return 0;
                case 3:
                    ctt.Lpt = aVar3.UbS.zi();
                    AppMethodBeat.o(32358);
                    return 0;
                case 4:
                    ctt.Lpu = aVar3.UbS.zi();
                    AppMethodBeat.o(32358);
                    return 0;
                case 5:
                    ctt.lastUpdateTime = aVar3.UbS.zl();
                    AppMethodBeat.o(32358);
                    return 0;
                default:
                    AppMethodBeat.o(32358);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32358);
            return -1;
        }
    }
}
