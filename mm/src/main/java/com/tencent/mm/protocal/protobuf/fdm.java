package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdm extends a {
    public int Nza;
    public int Nzb;
    public int Nzc;
    public int Nzd;
    public int Nze;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50122);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nza);
            aVar.aM(2, this.Nzb);
            aVar.aM(3, this.Nzc);
            aVar.aM(4, this.Nzd);
            aVar.aM(5, this.Nze);
            AppMethodBeat.o(50122);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nza) + 0 + g.a.a.b.b.a.bu(2, this.Nzb) + g.a.a.b.b.a.bu(3, this.Nzc) + g.a.a.b.b.a.bu(4, this.Nzd) + g.a.a.b.b.a.bu(5, this.Nze);
            AppMethodBeat.o(50122);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50122);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdm fdm = (fdm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdm.Nza = aVar3.UbS.zi();
                    AppMethodBeat.o(50122);
                    return 0;
                case 2:
                    fdm.Nzb = aVar3.UbS.zi();
                    AppMethodBeat.o(50122);
                    return 0;
                case 3:
                    fdm.Nzc = aVar3.UbS.zi();
                    AppMethodBeat.o(50122);
                    return 0;
                case 4:
                    fdm.Nzd = aVar3.UbS.zi();
                    AppMethodBeat.o(50122);
                    return 0;
                case 5:
                    fdm.Nze = aVar3.UbS.zi();
                    AppMethodBeat.o(50122);
                    return 0;
                default:
                    AppMethodBeat.o(50122);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50122);
            return -1;
        }
    }
}
