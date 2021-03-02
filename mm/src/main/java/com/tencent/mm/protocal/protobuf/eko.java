package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eko extends a {
    public long NjG;
    public long NjH;
    public long NjI;
    public double NjJ;
    public double NjK;
    public double NjL;
    public double NjM;
    public long NjN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110914);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NjG);
            aVar.bb(2, this.NjH);
            aVar.bb(3, this.NjI);
            aVar.e(4, this.NjJ);
            aVar.e(5, this.NjK);
            aVar.e(6, this.NjL);
            aVar.e(7, this.NjM);
            aVar.bb(8, this.NjN);
            AppMethodBeat.o(110914);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NjG) + 0 + g.a.a.b.b.a.r(2, this.NjH) + g.a.a.b.b.a.r(3, this.NjI) + g.a.a.b.b.a.fS(4) + 8 + g.a.a.b.b.a.fS(5) + 8 + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8 + g.a.a.b.b.a.r(8, this.NjN);
            AppMethodBeat.o(110914);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110914);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eko eko = (eko) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eko.NjG = aVar3.UbS.zl();
                    AppMethodBeat.o(110914);
                    return 0;
                case 2:
                    eko.NjH = aVar3.UbS.zl();
                    AppMethodBeat.o(110914);
                    return 0;
                case 3:
                    eko.NjI = aVar3.UbS.zl();
                    AppMethodBeat.o(110914);
                    return 0;
                case 4:
                    eko.NjJ = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110914);
                    return 0;
                case 5:
                    eko.NjK = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110914);
                    return 0;
                case 6:
                    eko.NjL = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110914);
                    return 0;
                case 7:
                    eko.NjM = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110914);
                    return 0;
                case 8:
                    eko.NjN = aVar3.UbS.zl();
                    AppMethodBeat.o(110914);
                    return 0;
                default:
                    AppMethodBeat.o(110914);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110914);
            return -1;
        }
    }
}
