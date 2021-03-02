package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class efv extends a {
    public int MXU;
    public LinkedList<cgg> MXV = new LinkedList<>();

    public efv() {
        AppMethodBeat.i(133201);
        AppMethodBeat.o(133201);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133202);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MXU);
            aVar.e(2, 8, this.MXV);
            AppMethodBeat.o(133202);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MXU) + 0 + g.a.a.a.c(2, 8, this.MXV);
            AppMethodBeat.o(133202);
            return bu;
        } else if (i2 == 2) {
            this.MXV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133202);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efv efv = (efv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    efv.MXU = aVar3.UbS.zi();
                    AppMethodBeat.o(133202);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cgg cgg = new cgg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cgg.populateBuilderWithField(aVar4, cgg, a.getNextFieldNumber(aVar4))) {
                        }
                        efv.MXV.add(cgg);
                    }
                    AppMethodBeat.o(133202);
                    return 0;
                default:
                    AppMethodBeat.o(133202);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133202);
            return -1;
        }
    }
}
