package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class tb extends a {
    public int Lbc;
    public int Lbd;
    public int Lbe;
    public int Lbf;
    public int Lbg;
    public int Lbh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133161);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lbc);
            aVar.aM(2, this.Lbd);
            aVar.aM(3, this.Lbe);
            aVar.aM(4, this.Lbf);
            aVar.aM(5, this.Lbg);
            aVar.aM(6, this.Lbh);
            AppMethodBeat.o(133161);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lbc) + 0 + g.a.a.b.b.a.bu(2, this.Lbd) + g.a.a.b.b.a.bu(3, this.Lbe) + g.a.a.b.b.a.bu(4, this.Lbf) + g.a.a.b.b.a.bu(5, this.Lbg) + g.a.a.b.b.a.bu(6, this.Lbh);
            AppMethodBeat.o(133161);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133161);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tb tbVar = (tb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tbVar.Lbc = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                case 2:
                    tbVar.Lbd = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                case 3:
                    tbVar.Lbe = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                case 4:
                    tbVar.Lbf = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                case 5:
                    tbVar.Lbg = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                case 6:
                    tbVar.Lbh = aVar3.UbS.zi();
                    AppMethodBeat.o(133161);
                    return 0;
                default:
                    AppMethodBeat.o(133161);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133161);
            return -1;
        }
    }
}
