package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eul extends a {
    public int NsB;
    public int NsC;
    public int NsD;
    public int NsE;
    public int NsF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115910);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NsB);
            aVar.aM(2, this.NsC);
            aVar.aM(3, this.NsD);
            aVar.aM(4, this.NsE);
            aVar.aM(5, this.NsF);
            AppMethodBeat.o(115910);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NsB) + 0 + g.a.a.b.b.a.bu(2, this.NsC) + g.a.a.b.b.a.bu(3, this.NsD) + g.a.a.b.b.a.bu(4, this.NsE) + g.a.a.b.b.a.bu(5, this.NsF);
            AppMethodBeat.o(115910);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115910);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eul eul = (eul) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eul.NsB = aVar3.UbS.zi();
                    AppMethodBeat.o(115910);
                    return 0;
                case 2:
                    eul.NsC = aVar3.UbS.zi();
                    AppMethodBeat.o(115910);
                    return 0;
                case 3:
                    eul.NsD = aVar3.UbS.zi();
                    AppMethodBeat.o(115910);
                    return 0;
                case 4:
                    eul.NsE = aVar3.UbS.zi();
                    AppMethodBeat.o(115910);
                    return 0;
                case 5:
                    eul.NsF = aVar3.UbS.zi();
                    AppMethodBeat.o(115910);
                    return 0;
                default:
                    AppMethodBeat.o(115910);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115910);
            return -1;
        }
    }
}
