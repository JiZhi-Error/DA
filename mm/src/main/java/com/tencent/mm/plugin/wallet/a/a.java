package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<c> HDZ = new LinkedList<>();
    public n HEa;

    public a() {
        AppMethodBeat.i(91283);
        AppMethodBeat.o(91283);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91284);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.HDZ);
            if (this.HEa != null) {
                aVar.ni(2, this.HEa.computeSize());
                this.HEa.writeFields(aVar);
            }
            AppMethodBeat.o(91284);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.HDZ) + 0;
            if (this.HEa != null) {
                c2 += g.a.a.a.nh(2, this.HEa.computeSize());
            }
            AppMethodBeat.o(91284);
            return c2;
        } else if (i2 == 2) {
            this.HDZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91284);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar5, cVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.HDZ.add(cVar);
                    }
                    AppMethodBeat.o(91284);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        n nVar = new n();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nVar.populateBuilderWithField(aVar6, nVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar6))) {
                        }
                        aVar4.HEa = nVar;
                    }
                    AppMethodBeat.o(91284);
                    return 0;
                default:
                    AppMethodBeat.o(91284);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91284);
            return -1;
        }
    }
}
