package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class few extends a {
    public String NAk;
    public String NAl;
    public String dNI;
    public int nJE;
    public int nLk;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123710);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.NAk != null) {
                aVar.e(3, this.NAk);
            }
            if (this.NAl != null) {
                aVar.e(4, this.NAl);
            }
            aVar.aM(5, this.nJE);
            aVar.aM(6, this.nLk);
            AppMethodBeat.o(123710);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.NAk != null) {
                bu += g.a.a.b.b.a.f(3, this.NAk);
            }
            if (this.NAl != null) {
                bu += g.a.a.b.b.a.f(4, this.NAl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.nJE) + g.a.a.b.b.a.bu(6, this.nLk);
            AppMethodBeat.o(123710);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123710);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            few few = (few) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    few.type = aVar3.UbS.zi();
                    AppMethodBeat.o(123710);
                    return 0;
                case 2:
                    few.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123710);
                    return 0;
                case 3:
                    few.NAk = aVar3.UbS.readString();
                    AppMethodBeat.o(123710);
                    return 0;
                case 4:
                    few.NAl = aVar3.UbS.readString();
                    AppMethodBeat.o(123710);
                    return 0;
                case 5:
                    few.nJE = aVar3.UbS.zi();
                    AppMethodBeat.o(123710);
                    return 0;
                case 6:
                    few.nLk = aVar3.UbS.zi();
                    AppMethodBeat.o(123710);
                    return 0;
                default:
                    AppMethodBeat.o(123710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123710);
            return -1;
        }
    }
}
