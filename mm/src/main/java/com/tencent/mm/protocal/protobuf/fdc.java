package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fdc extends a {
    public LinkedList<efx> KPd = new LinkedList<>();
    public int NyN;

    public fdc() {
        AppMethodBeat.i(153322);
        AppMethodBeat.o(153322);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153323);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KPd);
            aVar.aM(2, this.NyN);
            AppMethodBeat.o(153323);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KPd) + 0 + g.a.a.b.b.a.bu(2, this.NyN);
            AppMethodBeat.o(153323);
            return c2;
        } else if (i2 == 2) {
            this.KPd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153323);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdc fdc = (fdc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        efx efx = new efx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = efx.populateBuilderWithField(aVar4, efx, a.getNextFieldNumber(aVar4))) {
                        }
                        fdc.KPd.add(efx);
                    }
                    AppMethodBeat.o(153323);
                    return 0;
                case 2:
                    fdc.NyN = aVar3.UbS.zi();
                    AppMethodBeat.o(153323);
                    return 0;
                default:
                    AppMethodBeat.o(153323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153323);
            return -1;
        }
    }
}
