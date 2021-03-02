package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dtb extends a {
    public int LdV;
    public LinkedList<ur> MVh = new LinkedList<>();

    public dtb() {
        AppMethodBeat.i(114066);
        AppMethodBeat.o(114066);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114067);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LdV);
            aVar.e(2, 8, this.MVh);
            AppMethodBeat.o(114067);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LdV) + 0 + g.a.a.a.c(2, 8, this.MVh);
            AppMethodBeat.o(114067);
            return bu;
        } else if (i2 == 2) {
            this.MVh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114067);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtb dtb = (dtb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dtb.LdV = aVar3.UbS.zi();
                    AppMethodBeat.o(114067);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ur urVar = new ur();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = urVar.populateBuilderWithField(aVar4, urVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dtb.MVh.add(urVar);
                    }
                    AppMethodBeat.o(114067);
                    return 0;
                default:
                    AppMethodBeat.o(114067);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114067);
            return -1;
        }
    }
}
