package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class apt extends a {
    public int LBD;
    public LinkedList<apu> iAd = new LinkedList<>();

    public apt() {
        AppMethodBeat.i(209359);
        AppMethodBeat.o(209359);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209360);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.iAd);
            aVar.aM(2, this.LBD);
            AppMethodBeat.o(209360);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.iAd) + 0 + g.a.a.b.b.a.bu(2, this.LBD);
            AppMethodBeat.o(209360);
            return c2;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209360);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apt apt = (apt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        apu apu = new apu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = apu.populateBuilderWithField(aVar4, apu, a.getNextFieldNumber(aVar4))) {
                        }
                        apt.iAd.add(apu);
                    }
                    AppMethodBeat.o(209360);
                    return 0;
                case 2:
                    apt.LBD = aVar3.UbS.zi();
                    AppMethodBeat.o(209360);
                    return 0;
                default:
                    AppMethodBeat.o(209360);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209360);
            return -1;
        }
    }
}
