package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class l extends a {
    public LinkedList<k> oTF = new LinkedList<>();
    public int oTG;

    public l() {
        AppMethodBeat.i(22115);
        AppMethodBeat.o(22115);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22116);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.oTF);
            aVar.aM(2, this.oTG);
            AppMethodBeat.o(22116);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.oTF) + 0 + g.a.a.b.b.a.bu(2, this.oTG);
            AppMethodBeat.o(22116);
            return c2;
        } else if (i2 == 2) {
            this.oTF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(22116);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        k kVar = new k();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lVar.oTF.add(kVar);
                    }
                    AppMethodBeat.o(22116);
                    return 0;
                case 2:
                    lVar.oTG = aVar3.UbS.zi();
                    AppMethodBeat.o(22116);
                    return 0;
                default:
                    AppMethodBeat.o(22116);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22116);
            return -1;
        }
    }
}
