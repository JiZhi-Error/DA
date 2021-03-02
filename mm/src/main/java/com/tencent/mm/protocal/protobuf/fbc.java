package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fbc extends a {
    public LinkedList<ewq> Ltx = new LinkedList<>();
    public LinkedList<ehq> Nxs = new LinkedList<>();

    public fbc() {
        AppMethodBeat.i(192795);
        AppMethodBeat.o(192795);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(192796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Ltx);
            aVar.e(2, 8, this.Nxs);
            AppMethodBeat.o(192796);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Ltx) + 0 + g.a.a.a.c(2, 8, this.Nxs);
            AppMethodBeat.o(192796);
            return c2;
        } else if (i2 == 2) {
            this.Ltx.clear();
            this.Nxs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(192796);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbc fbc = (fbc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ewq ewq = new ewq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ewq.populateBuilderWithField(aVar4, ewq, a.getNextFieldNumber(aVar4))) {
                        }
                        fbc.Ltx.add(ewq);
                    }
                    AppMethodBeat.o(192796);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehq ehq = new ehq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehq.populateBuilderWithField(aVar5, ehq, a.getNextFieldNumber(aVar5))) {
                        }
                        fbc.Nxs.add(ehq);
                    }
                    AppMethodBeat.o(192796);
                    return 0;
                default:
                    AppMethodBeat.o(192796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(192796);
            return -1;
        }
    }
}
