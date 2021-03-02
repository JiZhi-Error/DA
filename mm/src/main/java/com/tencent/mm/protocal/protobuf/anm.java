package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class anm extends a {
    public int Lyl;
    public LinkedList<anl> Lym = new LinkedList<>();

    public anm() {
        AppMethodBeat.i(127486);
        AppMethodBeat.o(127486);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127487);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lyl);
            aVar.e(2, 8, this.Lym);
            AppMethodBeat.o(127487);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lyl) + 0 + g.a.a.a.c(2, 8, this.Lym);
            AppMethodBeat.o(127487);
            return bu;
        } else if (i2 == 2) {
            this.Lym.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127487);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anm anm = (anm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anm.Lyl = aVar3.UbS.zi();
                    AppMethodBeat.o(127487);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        anl anl = new anl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anl.populateBuilderWithField(aVar4, anl, a.getNextFieldNumber(aVar4))) {
                        }
                        anm.Lym.add(anl);
                    }
                    AppMethodBeat.o(127487);
                    return 0;
                default:
                    AppMethodBeat.o(127487);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127487);
            return -1;
        }
    }
}
