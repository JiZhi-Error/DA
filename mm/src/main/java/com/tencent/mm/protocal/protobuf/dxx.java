package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dxx extends a {
    public dqh MXA;
    public int vjQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209814);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.vjQ);
            if (this.MXA != null) {
                aVar.ni(2, this.MXA.computeSize());
                this.MXA.writeFields(aVar);
            }
            AppMethodBeat.o(209814);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.vjQ) + 0;
            if (this.MXA != null) {
                bu += g.a.a.a.nh(2, this.MXA.computeSize());
            }
            AppMethodBeat.o(209814);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209814);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxx dxx = (dxx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dxx.vjQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209814);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqh dqh = new dqh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqh.populateBuilderWithField(aVar4, dqh, a.getNextFieldNumber(aVar4))) {
                        }
                        dxx.MXA = dqh;
                    }
                    AppMethodBeat.o(209814);
                    return 0;
                default:
                    AppMethodBeat.o(209814);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209814);
            return -1;
        }
    }
}
