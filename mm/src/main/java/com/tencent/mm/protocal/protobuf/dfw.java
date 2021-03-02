package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dfw extends a {
    public int MKG;
    public int MKH;
    public int MKI;
    public int rBL;
    public String rBM;
    public int ypM;
    public String ypN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32392);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MKH);
            aVar.aM(2, this.MKI);
            aVar.aM(3, this.MKG);
            aVar.aM(4, this.rBL);
            if (this.rBM != null) {
                aVar.e(5, this.rBM);
            }
            aVar.aM(6, this.ypM);
            if (this.ypN != null) {
                aVar.e(7, this.ypN);
            }
            AppMethodBeat.o(32392);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MKH) + 0 + g.a.a.b.b.a.bu(2, this.MKI) + g.a.a.b.b.a.bu(3, this.MKG) + g.a.a.b.b.a.bu(4, this.rBL);
            if (this.rBM != null) {
                bu += g.a.a.b.b.a.f(5, this.rBM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.ypM);
            if (this.ypN != null) {
                bu2 += g.a.a.b.b.a.f(7, this.ypN);
            }
            AppMethodBeat.o(32392);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32392);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfw dfw = (dfw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dfw.MKH = aVar3.UbS.zi();
                    AppMethodBeat.o(32392);
                    return 0;
                case 2:
                    dfw.MKI = aVar3.UbS.zi();
                    AppMethodBeat.o(32392);
                    return 0;
                case 3:
                    dfw.MKG = aVar3.UbS.zi();
                    AppMethodBeat.o(32392);
                    return 0;
                case 4:
                    dfw.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(32392);
                    return 0;
                case 5:
                    dfw.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(32392);
                    return 0;
                case 6:
                    dfw.ypM = aVar3.UbS.zi();
                    AppMethodBeat.o(32392);
                    return 0;
                case 7:
                    dfw.ypN = aVar3.UbS.readString();
                    AppMethodBeat.o(32392);
                    return 0;
                default:
                    AppMethodBeat.o(32392);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32392);
            return -1;
        }
    }
}
