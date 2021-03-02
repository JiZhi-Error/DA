package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cvs extends a {
    public LinkedList<cvv> KHx = new LinkedList<>();
    public int MBn;

    public cvs() {
        AppMethodBeat.i(152633);
        AppMethodBeat.o(152633);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152634);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KHx);
            aVar.aM(2, this.MBn);
            AppMethodBeat.o(152634);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KHx) + 0 + g.a.a.b.b.a.bu(2, this.MBn);
            AppMethodBeat.o(152634);
            return c2;
        } else if (i2 == 2) {
            this.KHx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvs cvs = (cvs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cvv cvv = new cvv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cvv.populateBuilderWithField(aVar4, cvv, a.getNextFieldNumber(aVar4))) {
                        }
                        cvs.KHx.add(cvv);
                    }
                    AppMethodBeat.o(152634);
                    return 0;
                case 2:
                    cvs.MBn = aVar3.UbS.zi();
                    AppMethodBeat.o(152634);
                    return 0;
                default:
                    AppMethodBeat.o(152634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152634);
            return -1;
        }
    }
}
