package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class anp extends a {
    public int LyA;
    public int LyB;
    public int Lyp;
    public int Lyq;
    public int Lyr;
    public int Lys;
    public int Lyt;
    public int Lyu;
    public int Lyv;
    public int Lyw;
    public int Lyx;
    public int Lyy;
    public int Lyz;
    public int fileCount;
    public int xiP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127492);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lyp);
            aVar.aM(2, this.Lyq);
            aVar.aM(3, this.Lyr);
            aVar.aM(4, this.xiP);
            aVar.aM(5, this.Lys);
            aVar.aM(6, this.Lyt);
            aVar.aM(7, this.Lyu);
            aVar.aM(8, this.fileCount);
            aVar.aM(9, this.Lyv);
            aVar.aM(10, this.Lyw);
            aVar.aM(11, this.Lyx);
            aVar.aM(12, this.Lyy);
            aVar.aM(13, this.Lyz);
            aVar.aM(14, this.LyA);
            aVar.aM(15, this.LyB);
            AppMethodBeat.o(127492);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lyp) + 0 + g.a.a.b.b.a.bu(2, this.Lyq) + g.a.a.b.b.a.bu(3, this.Lyr) + g.a.a.b.b.a.bu(4, this.xiP) + g.a.a.b.b.a.bu(5, this.Lys) + g.a.a.b.b.a.bu(6, this.Lyt) + g.a.a.b.b.a.bu(7, this.Lyu) + g.a.a.b.b.a.bu(8, this.fileCount) + g.a.a.b.b.a.bu(9, this.Lyv) + g.a.a.b.b.a.bu(10, this.Lyw) + g.a.a.b.b.a.bu(11, this.Lyx) + g.a.a.b.b.a.bu(12, this.Lyy) + g.a.a.b.b.a.bu(13, this.Lyz) + g.a.a.b.b.a.bu(14, this.LyA) + g.a.a.b.b.a.bu(15, this.LyB);
            AppMethodBeat.o(127492);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127492);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anp anp = (anp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    anp.Lyp = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 2:
                    anp.Lyq = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 3:
                    anp.Lyr = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 4:
                    anp.xiP = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 5:
                    anp.Lys = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 6:
                    anp.Lyt = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 7:
                    anp.Lyu = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 8:
                    anp.fileCount = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 9:
                    anp.Lyv = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 10:
                    anp.Lyw = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 11:
                    anp.Lyx = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 12:
                    anp.Lyy = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 13:
                    anp.Lyz = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 14:
                    anp.LyA = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                case 15:
                    anp.LyB = aVar3.UbS.zi();
                    AppMethodBeat.o(127492);
                    return 0;
                default:
                    AppMethodBeat.o(127492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127492);
            return -1;
        }
    }
}
