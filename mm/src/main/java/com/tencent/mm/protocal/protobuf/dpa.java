package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dpa extends a {
    public LinkedList<dov> MSz = new LinkedList<>();
    public int oUv;

    public dpa() {
        AppMethodBeat.i(152673);
        AppMethodBeat.o(152673);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152674);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            aVar.e(2, 8, this.MSz);
            AppMethodBeat.o(152674);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.a.c(2, 8, this.MSz);
            AppMethodBeat.o(152674);
            return bu;
        } else if (i2 == 2) {
            this.MSz.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152674);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpa dpa = (dpa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpa.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(152674);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dov dov = new dov();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dov.populateBuilderWithField(aVar4, dov, a.getNextFieldNumber(aVar4))) {
                        }
                        dpa.MSz.add(dov);
                    }
                    AppMethodBeat.o(152674);
                    return 0;
                default:
                    AppMethodBeat.o(152674);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152674);
            return -1;
        }
    }
}
