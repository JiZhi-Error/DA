package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class jr extends a {
    public b KOh;
    public b KOi;
    public int KOj;
    public b KOk;
    public int Scene;
    public int rBx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133156);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KOh != null) {
                aVar.c(1, this.KOh);
            }
            aVar.aM(2, this.rBx);
            if (this.KOi != null) {
                aVar.c(3, this.KOi);
            }
            aVar.aM(4, this.KOj);
            if (this.KOk != null) {
                aVar.c(5, this.KOk);
            }
            aVar.aM(6, this.Scene);
            AppMethodBeat.o(133156);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.KOh != null ? g.a.a.b.b.a.b(1, this.KOh) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBx);
            if (this.KOi != null) {
                b2 += g.a.a.b.b.a.b(3, this.KOi);
            }
            int bu = b2 + g.a.a.b.b.a.bu(4, this.KOj);
            if (this.KOk != null) {
                bu += g.a.a.b.b.a.b(5, this.KOk);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Scene);
            AppMethodBeat.o(133156);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133156);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jr jrVar = (jr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jrVar.KOh = aVar3.UbS.hPo();
                    AppMethodBeat.o(133156);
                    return 0;
                case 2:
                    jrVar.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(133156);
                    return 0;
                case 3:
                    jrVar.KOi = aVar3.UbS.hPo();
                    AppMethodBeat.o(133156);
                    return 0;
                case 4:
                    jrVar.KOj = aVar3.UbS.zi();
                    AppMethodBeat.o(133156);
                    return 0;
                case 5:
                    jrVar.KOk = aVar3.UbS.hPo();
                    AppMethodBeat.o(133156);
                    return 0;
                case 6:
                    jrVar.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(133156);
                    return 0;
                default:
                    AppMethodBeat.o(133156);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133156);
            return -1;
        }
    }
}
