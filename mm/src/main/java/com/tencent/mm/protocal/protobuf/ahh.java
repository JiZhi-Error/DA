package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class ahh extends a {
    public LinkedList<ahi> KEQ = new LinkedList<>();
    public int cSx;
    public String nHe;

    public ahh() {
        AppMethodBeat.i(212270);
        AppMethodBeat.o(212270);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212271);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KEQ);
            if (this.nHe != null) {
                aVar.e(2, this.nHe);
            }
            aVar.aM(3, this.cSx);
            AppMethodBeat.o(212271);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KEQ) + 0;
            if (this.nHe != null) {
                c2 += g.a.a.b.b.a.f(2, this.nHe);
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.cSx);
            AppMethodBeat.o(212271);
            return bu;
        } else if (i2 == 2) {
            this.KEQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212271);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahh ahh = (ahh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahi ahi = new ahi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahi.populateBuilderWithField(aVar4, ahi, a.getNextFieldNumber(aVar4))) {
                        }
                        ahh.KEQ.add(ahi);
                    }
                    AppMethodBeat.o(212271);
                    return 0;
                case 2:
                    ahh.nHe = aVar3.UbS.readString();
                    AppMethodBeat.o(212271);
                    return 0;
                case 3:
                    ahh.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(212271);
                    return 0;
                default:
                    AppMethodBeat.o(212271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212271);
            return -1;
        }
    }
}
