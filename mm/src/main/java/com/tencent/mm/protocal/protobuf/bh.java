package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bh extends a {
    public boolean KEI;
    public boolean KEJ;
    public int KEK;
    public boolean KEL;
    public b KEM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123537);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KEI);
            aVar.cc(2, this.KEJ);
            aVar.aM(3, this.KEK);
            aVar.cc(4, this.KEL);
            if (this.KEM != null) {
                aVar.c(5, this.KEM);
            }
            AppMethodBeat.o(123537);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.KEK) + g.a.a.b.b.a.fS(4) + 1;
            if (this.KEM != null) {
                fS += g.a.a.b.b.a.b(5, this.KEM);
            }
            AppMethodBeat.o(123537);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123537);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bh bhVar = (bh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhVar.KEI = aVar3.UbS.yZ();
                    AppMethodBeat.o(123537);
                    return 0;
                case 2:
                    bhVar.KEJ = aVar3.UbS.yZ();
                    AppMethodBeat.o(123537);
                    return 0;
                case 3:
                    bhVar.KEK = aVar3.UbS.zi();
                    AppMethodBeat.o(123537);
                    return 0;
                case 4:
                    bhVar.KEL = aVar3.UbS.yZ();
                    AppMethodBeat.o(123537);
                    return 0;
                case 5:
                    bhVar.KEM = aVar3.UbS.hPo();
                    AppMethodBeat.o(123537);
                    return 0;
                default:
                    AppMethodBeat.o(123537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123537);
            return -1;
        }
    }
}
