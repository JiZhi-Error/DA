package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qu extends a {
    public int Doa;
    public int KXC;
    public int KXD;
    public int KXE;
    public String KXF;
    public int KXG;
    public int KXH;
    public int KXI;
    public String KXJ;
    public String dNI;
    public String qHp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117838);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            aVar.aM(2, this.KXC);
            aVar.aM(3, this.KXD);
            if (this.qHp != null) {
                aVar.e(4, this.qHp);
            }
            aVar.aM(5, this.KXE);
            if (this.KXF != null) {
                aVar.e(6, this.KXF);
            }
            aVar.aM(7, this.KXG);
            aVar.aM(8, this.KXH);
            aVar.aM(9, this.KXI);
            if (this.KXJ != null) {
                aVar.e(10, this.KXJ);
            }
            aVar.aM(15, this.Doa);
            AppMethodBeat.o(117838);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KXC) + g.a.a.b.b.a.bu(3, this.KXD);
            if (this.qHp != null) {
                f2 += g.a.a.b.b.a.f(4, this.qHp);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KXE);
            if (this.KXF != null) {
                bu += g.a.a.b.b.a.f(6, this.KXF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KXG) + g.a.a.b.b.a.bu(8, this.KXH) + g.a.a.b.b.a.bu(9, this.KXI);
            if (this.KXJ != null) {
                bu2 += g.a.a.b.b.a.f(10, this.KXJ);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(15, this.Doa);
            AppMethodBeat.o(117838);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117838);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qu quVar = (qu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    quVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(117838);
                    return 0;
                case 2:
                    quVar.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 3:
                    quVar.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 4:
                    quVar.qHp = aVar3.UbS.readString();
                    AppMethodBeat.o(117838);
                    return 0;
                case 5:
                    quVar.KXE = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 6:
                    quVar.KXF = aVar3.UbS.readString();
                    AppMethodBeat.o(117838);
                    return 0;
                case 7:
                    quVar.KXG = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 8:
                    quVar.KXH = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 9:
                    quVar.KXI = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
                case 10:
                    quVar.KXJ = aVar3.UbS.readString();
                    AppMethodBeat.o(117838);
                    return 0;
                case 11:
                case 12:
                case 13:
                case 14:
                default:
                    AppMethodBeat.o(117838);
                    return -1;
                case 15:
                    quVar.Doa = aVar3.UbS.zi();
                    AppMethodBeat.o(117838);
                    return 0;
            }
        } else {
            AppMethodBeat.o(117838);
            return -1;
        }
    }
}
