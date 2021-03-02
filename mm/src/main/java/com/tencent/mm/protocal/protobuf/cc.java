package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cc extends a {
    public int Dvc;
    public int Dvd;
    public float KGc;
    public float KGd;
    public float KGe;
    public long KGf;
    public long KGg;
    public long KGh;
    public long KGi;
    public long endTime;
    public long startTime;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125698);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Dvc);
            aVar.aM(2, this.Dvd);
            aVar.E(3, this.KGc);
            aVar.E(4, this.KGd);
            aVar.E(5, this.KGe);
            aVar.bb(6, this.startTime);
            aVar.bb(7, this.endTime);
            aVar.bb(8, this.KGf);
            aVar.bb(9, this.KGg);
            aVar.bb(10, this.KGh);
            aVar.bb(11, this.KGi);
            AppMethodBeat.o(125698);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Dvc) + 0 + g.a.a.b.b.a.bu(2, this.Dvd) + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.r(6, this.startTime) + g.a.a.b.b.a.r(7, this.endTime) + g.a.a.b.b.a.r(8, this.KGf) + g.a.a.b.b.a.r(9, this.KGg) + g.a.a.b.b.a.r(10, this.KGh) + g.a.a.b.b.a.r(11, this.KGi);
            AppMethodBeat.o(125698);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125698);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccVar.Dvc = aVar3.UbS.zi();
                    AppMethodBeat.o(125698);
                    return 0;
                case 2:
                    ccVar.Dvd = aVar3.UbS.zi();
                    AppMethodBeat.o(125698);
                    return 0;
                case 3:
                    ccVar.KGc = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125698);
                    return 0;
                case 4:
                    ccVar.KGd = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125698);
                    return 0;
                case 5:
                    ccVar.KGe = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(125698);
                    return 0;
                case 6:
                    ccVar.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                case 7:
                    ccVar.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                case 8:
                    ccVar.KGf = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                case 9:
                    ccVar.KGg = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                case 10:
                    ccVar.KGh = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                case 11:
                    ccVar.KGi = aVar3.UbS.zl();
                    AppMethodBeat.o(125698);
                    return 0;
                default:
                    AppMethodBeat.o(125698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125698);
            return -1;
        }
    }
}
