package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fem extends a {
    public int NzJ;
    public int NzK;
    public int NzL;
    public int NzM;
    public String NzN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153337);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NzJ);
            aVar.aM(2, this.NzK);
            aVar.aM(3, this.NzL);
            aVar.aM(4, this.NzM);
            if (this.NzN != null) {
                aVar.e(5, this.NzN);
            }
            AppMethodBeat.o(153337);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NzJ) + 0 + g.a.a.b.b.a.bu(2, this.NzK) + g.a.a.b.b.a.bu(3, this.NzL) + g.a.a.b.b.a.bu(4, this.NzM);
            if (this.NzN != null) {
                bu += g.a.a.b.b.a.f(5, this.NzN);
            }
            AppMethodBeat.o(153337);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153337);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fem fem = (fem) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fem.NzJ = aVar3.UbS.zi();
                    AppMethodBeat.o(153337);
                    return 0;
                case 2:
                    fem.NzK = aVar3.UbS.zi();
                    AppMethodBeat.o(153337);
                    return 0;
                case 3:
                    fem.NzL = aVar3.UbS.zi();
                    AppMethodBeat.o(153337);
                    return 0;
                case 4:
                    fem.NzM = aVar3.UbS.zi();
                    AppMethodBeat.o(153337);
                    return 0;
                case 5:
                    fem.NzN = aVar3.UbS.readString();
                    AppMethodBeat.o(153337);
                    return 0;
                default:
                    AppMethodBeat.o(153337);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153337);
            return -1;
        }
    }
}
