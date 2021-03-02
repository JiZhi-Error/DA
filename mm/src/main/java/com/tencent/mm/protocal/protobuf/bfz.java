package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfz extends a {
    public LinkedList<dve> LPD = new LinkedList<>();
    public bga LPE;

    public bfz() {
        AppMethodBeat.i(122497);
        AppMethodBeat.o(122497);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122498);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LPD);
            if (this.LPE != null) {
                aVar.ni(2, this.LPE.computeSize());
                this.LPE.writeFields(aVar);
            }
            AppMethodBeat.o(122498);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LPD) + 0;
            if (this.LPE != null) {
                c2 += g.a.a.a.nh(2, this.LPE.computeSize());
            }
            AppMethodBeat.o(122498);
            return c2;
        } else if (i2 == 2) {
            this.LPD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122498);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfz bfz = (bfz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dve dve = new dve();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dve.populateBuilderWithField(aVar4, dve, a.getNextFieldNumber(aVar4))) {
                        }
                        bfz.LPD.add(dve);
                    }
                    AppMethodBeat.o(122498);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bga bga = new bga();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bga.populateBuilderWithField(aVar5, bga, a.getNextFieldNumber(aVar5))) {
                        }
                        bfz.LPE = bga;
                    }
                    AppMethodBeat.o(122498);
                    return 0;
                default:
                    AppMethodBeat.o(122498);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122498);
            return -1;
        }
    }
}
