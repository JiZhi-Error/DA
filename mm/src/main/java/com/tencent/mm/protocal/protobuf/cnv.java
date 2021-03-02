package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cnv extends a {
    public int LCO;
    public int LCP;
    public int LCQ;
    public int LCR;
    public int Muh;
    public int Mui;
    public int Muj;
    public int Muk;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209751);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            aVar.aM(2, this.LCO);
            aVar.aM(3, this.Muh);
            aVar.aM(4, this.Mui);
            aVar.aM(5, this.LCP);
            aVar.aM(6, this.LCQ);
            aVar.aM(7, this.LCR);
            aVar.aM(8, this.Muj);
            aVar.aM(9, this.Muk);
            AppMethodBeat.o(209751);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0 + g.a.a.b.b.a.bu(2, this.LCO) + g.a.a.b.b.a.bu(3, this.Muh) + g.a.a.b.b.a.bu(4, this.Mui) + g.a.a.b.b.a.bu(5, this.LCP) + g.a.a.b.b.a.bu(6, this.LCQ) + g.a.a.b.b.a.bu(7, this.LCR) + g.a.a.b.b.a.bu(8, this.Muj) + g.a.a.b.b.a.bu(9, this.Muk);
            AppMethodBeat.o(209751);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209751);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnv cnv = (cnv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cnv.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 2:
                    cnv.LCO = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 3:
                    cnv.Muh = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 4:
                    cnv.Mui = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 5:
                    cnv.LCP = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 6:
                    cnv.LCQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 7:
                    cnv.LCR = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 8:
                    cnv.Muj = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                case 9:
                    cnv.Muk = aVar3.UbS.zi();
                    AppMethodBeat.o(209751);
                    return 0;
                default:
                    AppMethodBeat.o(209751);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209751);
            return -1;
        }
    }
}
