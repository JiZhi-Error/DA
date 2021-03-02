package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dxy extends a {
    public LinkedList<String> MXB = new LinkedList<>();
    public LinkedList<String> MXC = new LinkedList<>();
    public LinkedList<Integer> MXD = new LinkedList<>();
    public LinkedList<Integer> MXE = new LinkedList<>();

    public dxy() {
        AppMethodBeat.i(114079);
        AppMethodBeat.o(114079);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114080);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.MXB);
            aVar.e(2, 1, this.MXC);
            aVar.e(3, 2, this.MXD);
            aVar.e(4, 2, this.MXE);
            AppMethodBeat.o(114080);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.MXB) + 0 + g.a.a.a.c(2, 1, this.MXC) + g.a.a.a.c(3, 2, this.MXD) + g.a.a.a.c(4, 2, this.MXE);
            AppMethodBeat.o(114080);
            return c2;
        } else if (i2 == 2) {
            this.MXB.clear();
            this.MXC.clear();
            this.MXD.clear();
            this.MXE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114080);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxy dxy = (dxy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dxy.MXB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(114080);
                    return 0;
                case 2:
                    dxy.MXC.add(aVar3.UbS.readString());
                    AppMethodBeat.o(114080);
                    return 0;
                case 3:
                    dxy.MXD.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(114080);
                    return 0;
                case 4:
                    dxy.MXE.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(114080);
                    return 0;
                default:
                    AppMethodBeat.o(114080);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114080);
            return -1;
        }
    }
}
