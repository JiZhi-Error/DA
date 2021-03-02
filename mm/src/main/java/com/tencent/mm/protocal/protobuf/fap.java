package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fap extends a {
    public long NwQ;
    public qu NwR;
    public int NwS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117950);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NwQ);
            if (this.NwR != null) {
                aVar.ni(2, this.NwR.computeSize());
                this.NwR.writeFields(aVar);
            }
            aVar.aM(3, this.NwS);
            AppMethodBeat.o(117950);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NwQ) + 0;
            if (this.NwR != null) {
                r += g.a.a.a.nh(2, this.NwR.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.NwS);
            AppMethodBeat.o(117950);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117950);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fap fap = (fap) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fap.NwQ = aVar3.UbS.zl();
                    AppMethodBeat.o(117950);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        qu quVar = new qu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = quVar.populateBuilderWithField(aVar4, quVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fap.NwR = quVar;
                    }
                    AppMethodBeat.o(117950);
                    return 0;
                case 3:
                    fap.NwS = aVar3.UbS.zi();
                    AppMethodBeat.o(117950);
                    return 0;
                default:
                    AppMethodBeat.o(117950);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117950);
            return -1;
        }
    }
}
