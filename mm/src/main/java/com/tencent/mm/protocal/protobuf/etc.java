package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class etc extends a {
    public long Lta;
    public long NeG;
    public int NqC;
    public int NqD;
    public int NqE;
    public int NqF;
    public b NqG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125501);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NeG);
            aVar.bb(2, this.Lta);
            aVar.aM(3, this.NqC);
            aVar.aM(4, this.NqD);
            aVar.aM(5, this.NqE);
            aVar.aM(6, this.NqF);
            if (this.NqG != null) {
                aVar.c(7, this.NqG);
            }
            AppMethodBeat.o(125501);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NeG) + 0 + g.a.a.b.b.a.r(2, this.Lta) + g.a.a.b.b.a.bu(3, this.NqC) + g.a.a.b.b.a.bu(4, this.NqD) + g.a.a.b.b.a.bu(5, this.NqE) + g.a.a.b.b.a.bu(6, this.NqF);
            if (this.NqG != null) {
                r += g.a.a.b.b.a.b(7, this.NqG);
            }
            AppMethodBeat.o(125501);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125501);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etc etc = (etc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    etc.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(125501);
                    return 0;
                case 2:
                    etc.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(125501);
                    return 0;
                case 3:
                    etc.NqC = aVar3.UbS.zi();
                    AppMethodBeat.o(125501);
                    return 0;
                case 4:
                    etc.NqD = aVar3.UbS.zi();
                    AppMethodBeat.o(125501);
                    return 0;
                case 5:
                    etc.NqE = aVar3.UbS.zi();
                    AppMethodBeat.o(125501);
                    return 0;
                case 6:
                    etc.NqF = aVar3.UbS.zi();
                    AppMethodBeat.o(125501);
                    return 0;
                case 7:
                    etc.NqG = aVar3.UbS.hPo();
                    AppMethodBeat.o(125501);
                    return 0;
                default:
                    AppMethodBeat.o(125501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125501);
            return -1;
        }
    }
}
