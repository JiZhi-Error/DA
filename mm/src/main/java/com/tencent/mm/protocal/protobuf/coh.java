package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class coh extends a {
    public float LKx;
    public int MuA;
    public int Muw;
    public float Mux;
    public int Muy;
    public int Muz;
    public int uUm;
    public int uUn;
    public int uUs;
    public int uUu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209766);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uUm);
            aVar.aM(2, this.uUn);
            aVar.aM(3, this.Muw);
            aVar.E(4, this.Mux);
            aVar.aM(5, this.Muy);
            aVar.aM(6, this.Muz);
            aVar.aM(7, this.MuA);
            aVar.aM(8, this.uUs);
            aVar.E(9, this.LKx);
            aVar.aM(10, this.uUu);
            AppMethodBeat.o(209766);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uUm) + 0 + g.a.a.b.b.a.bu(2, this.uUn) + g.a.a.b.b.a.bu(3, this.Muw) + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.bu(5, this.Muy) + g.a.a.b.b.a.bu(6, this.Muz) + g.a.a.b.b.a.bu(7, this.MuA) + g.a.a.b.b.a.bu(8, this.uUs) + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.bu(10, this.uUu);
            AppMethodBeat.o(209766);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209766);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coh coh = (coh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coh.uUm = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 2:
                    coh.uUn = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 3:
                    coh.Muw = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 4:
                    coh.Mux = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209766);
                    return 0;
                case 5:
                    coh.Muy = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 6:
                    coh.Muz = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 7:
                    coh.MuA = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 8:
                    coh.uUs = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                case 9:
                    coh.LKx = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209766);
                    return 0;
                case 10:
                    coh.uUu = aVar3.UbS.zi();
                    AppMethodBeat.o(209766);
                    return 0;
                default:
                    AppMethodBeat.o(209766);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209766);
            return -1;
        }
    }
}
