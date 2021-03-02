package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ahb extends a {
    public int LqL;
    public int dYT;
    public int fps;
    public int gGn;
    public int gGo;
    public int height;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90965);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.gGn);
            aVar.aM(2, this.fps);
            aVar.aM(3, this.gGo);
            aVar.aM(4, this.LqL);
            aVar.aM(5, this.dYT);
            aVar.aM(6, this.width);
            aVar.aM(7, this.height);
            AppMethodBeat.o(90965);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.gGn) + 0 + g.a.a.b.b.a.bu(2, this.fps) + g.a.a.b.b.a.bu(3, this.gGo) + g.a.a.b.b.a.bu(4, this.LqL) + g.a.a.b.b.a.bu(5, this.dYT) + g.a.a.b.b.a.bu(6, this.width) + g.a.a.b.b.a.bu(7, this.height);
            AppMethodBeat.o(90965);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90965);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahb ahb = (ahb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahb.gGn = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 2:
                    ahb.fps = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 3:
                    ahb.gGo = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 4:
                    ahb.LqL = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 5:
                    ahb.dYT = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 6:
                    ahb.width = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                case 7:
                    ahb.height = aVar3.UbS.zi();
                    AppMethodBeat.o(90965);
                    return 0;
                default:
                    AppMethodBeat.o(90965);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90965);
            return -1;
        }
    }
}
