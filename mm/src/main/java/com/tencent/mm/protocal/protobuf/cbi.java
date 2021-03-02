package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbi extends a {
    public int Mha;
    public LinkedList<crd> Mhb = new LinkedList<>();
    public int Mhc;

    public cbi() {
        AppMethodBeat.i(143977);
        AppMethodBeat.o(143977);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143978);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mha);
            aVar.e(2, 8, this.Mhb);
            aVar.aM(3, this.Mhc);
            AppMethodBeat.o(143978);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mha) + 0 + g.a.a.a.c(2, 8, this.Mhb) + g.a.a.b.b.a.bu(3, this.Mhc);
            AppMethodBeat.o(143978);
            return bu;
        } else if (i2 == 2) {
            this.Mhb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143978);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbi cbi = (cbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbi.Mha = aVar3.UbS.zi();
                    AppMethodBeat.o(143978);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        crd crd = new crd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = crd.populateBuilderWithField(aVar4, crd, a.getNextFieldNumber(aVar4))) {
                        }
                        cbi.Mhb.add(crd);
                    }
                    AppMethodBeat.o(143978);
                    return 0;
                case 3:
                    cbi.Mhc = aVar3.UbS.zi();
                    AppMethodBeat.o(143978);
                    return 0;
                default:
                    AppMethodBeat.o(143978);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143978);
            return -1;
        }
    }
}
