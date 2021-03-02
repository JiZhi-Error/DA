package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class abm extends a {
    public int KXj;
    public b Lmq;
    public dbg Lmr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91422);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KXj);
            if (this.Lmq != null) {
                aVar.c(2, this.Lmq);
            }
            if (this.Lmr != null) {
                aVar.ni(3, this.Lmr.computeSize());
                this.Lmr.writeFields(aVar);
            }
            AppMethodBeat.o(91422);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KXj) + 0;
            if (this.Lmq != null) {
                bu += g.a.a.b.b.a.b(2, this.Lmq);
            }
            if (this.Lmr != null) {
                bu += g.a.a.a.nh(3, this.Lmr.computeSize());
            }
            AppMethodBeat.o(91422);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91422);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abm abm = (abm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abm.KXj = aVar3.UbS.zi();
                    AppMethodBeat.o(91422);
                    return 0;
                case 2:
                    abm.Lmq = aVar3.UbS.hPo();
                    AppMethodBeat.o(91422);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbg dbg = new dbg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbg.populateBuilderWithField(aVar4, dbg, a.getNextFieldNumber(aVar4))) {
                        }
                        abm.Lmr = dbg;
                    }
                    AppMethodBeat.o(91422);
                    return 0;
                default:
                    AppMethodBeat.o(91422);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91422);
            return -1;
        }
    }
}
