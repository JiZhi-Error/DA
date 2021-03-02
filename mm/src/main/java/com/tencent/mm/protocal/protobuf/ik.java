package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ik extends a {
    public LinkedList<String> KMy = new LinkedList<>();
    public int KMz;
    public int xIY;

    public ik() {
        AppMethodBeat.i(104747);
        AppMethodBeat.o(104747);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104748);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.KMy);
            aVar.aM(2, this.KMz);
            aVar.aM(3, this.xIY);
            AppMethodBeat.o(104748);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.KMy) + 0 + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.xIY);
            AppMethodBeat.o(104748);
            return c2;
        } else if (i2 == 2) {
            this.KMy.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104748);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ik ikVar = (ik) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ikVar.KMy.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104748);
                    return 0;
                case 2:
                    ikVar.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(104748);
                    return 0;
                case 3:
                    ikVar.xIY = aVar3.UbS.zi();
                    AppMethodBeat.o(104748);
                    return 0;
                default:
                    AppMethodBeat.o(104748);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104748);
            return -1;
        }
    }
}
