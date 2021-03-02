package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvf extends a {
    public int KXP;
    public int Llx;
    public int MAD;
    public String MAE;
    public String MAG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43114);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KXP);
            if (this.MAG != null) {
                aVar.e(3, this.MAG);
            }
            aVar.aM(4, this.MAD);
            aVar.aM(5, this.Llx);
            if (this.MAE != null) {
                aVar.e(6, this.MAE);
            }
            AppMethodBeat.o(43114);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KXP) + 0;
            if (this.MAG != null) {
                bu += g.a.a.b.b.a.f(3, this.MAG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.MAD) + g.a.a.b.b.a.bu(5, this.Llx);
            if (this.MAE != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MAE);
            }
            AppMethodBeat.o(43114);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43114);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvf cvf = (cvf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvf.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(43114);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(43114);
                    return -1;
                case 3:
                    cvf.MAG = aVar3.UbS.readString();
                    AppMethodBeat.o(43114);
                    return 0;
                case 4:
                    cvf.MAD = aVar3.UbS.zi();
                    AppMethodBeat.o(43114);
                    return 0;
                case 5:
                    cvf.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(43114);
                    return 0;
                case 6:
                    cvf.MAE = aVar3.UbS.readString();
                    AppMethodBeat.o(43114);
                    return 0;
            }
        } else {
            AppMethodBeat.o(43114);
            return -1;
        }
    }
}
