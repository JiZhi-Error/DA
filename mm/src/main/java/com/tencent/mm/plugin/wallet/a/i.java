package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<j> HEH = new LinkedList<>();
    public b HEI;

    public i() {
        AppMethodBeat.i(91294);
        AppMethodBeat.o(91294);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91295);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.HEH);
            if (this.HEI != null) {
                aVar.c(2, this.HEI);
            }
            AppMethodBeat.o(91295);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.HEH) + 0;
            if (this.HEI != null) {
                c2 += g.a.a.b.b.a.b(2, this.HEI);
            }
            AppMethodBeat.o(91295);
            return c2;
        } else if (i2 == 2) {
            this.HEH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91295);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        j jVar = new j();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.HEH.add(jVar);
                    }
                    AppMethodBeat.o(91295);
                    return 0;
                case 2:
                    iVar.HEI = aVar3.UbS.hPo();
                    AppMethodBeat.o(91295);
                    return 0;
                default:
                    AppMethodBeat.o(91295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91295);
            return -1;
        }
    }
}
