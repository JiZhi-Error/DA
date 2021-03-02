package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cvd extends a {
    public int FileSize;
    public int KXP;
    public int Llx;
    public int MAA;
    public int MAB;
    public String MAC;
    public int MAD;
    public String MAE;
    public String xuz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32360);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xuz != null) {
                aVar.e(1, this.xuz);
            }
            aVar.aM(2, this.MAA);
            aVar.aM(3, this.MAB);
            aVar.aM(4, this.KXP);
            if (this.MAC != null) {
                aVar.e(5, this.MAC);
            }
            aVar.aM(6, this.FileSize);
            aVar.aM(7, this.MAD);
            aVar.aM(8, this.Llx);
            if (this.MAE != null) {
                aVar.e(9, this.MAE);
            }
            AppMethodBeat.o(32360);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xuz != null ? g.a.a.b.b.a.f(1, this.xuz) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MAA) + g.a.a.b.b.a.bu(3, this.MAB) + g.a.a.b.b.a.bu(4, this.KXP);
            if (this.MAC != null) {
                f2 += g.a.a.b.b.a.f(5, this.MAC);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.FileSize) + g.a.a.b.b.a.bu(7, this.MAD) + g.a.a.b.b.a.bu(8, this.Llx);
            if (this.MAE != null) {
                bu += g.a.a.b.b.a.f(9, this.MAE);
            }
            AppMethodBeat.o(32360);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32360);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cvd cvd = (cvd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvd.xuz = aVar3.UbS.readString();
                    AppMethodBeat.o(32360);
                    return 0;
                case 2:
                    cvd.MAA = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 3:
                    cvd.MAB = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 4:
                    cvd.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 5:
                    cvd.MAC = aVar3.UbS.readString();
                    AppMethodBeat.o(32360);
                    return 0;
                case 6:
                    cvd.FileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 7:
                    cvd.MAD = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 8:
                    cvd.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(32360);
                    return 0;
                case 9:
                    cvd.MAE = aVar3.UbS.readString();
                    AppMethodBeat.o(32360);
                    return 0;
                default:
                    AppMethodBeat.o(32360);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32360);
            return -1;
        }
    }
}
