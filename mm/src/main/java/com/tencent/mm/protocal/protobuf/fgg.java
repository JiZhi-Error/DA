package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class fgg extends a {
    public String ViN;
    public int ViO;
    public String ViP;
    public int ViQ;
    public b ViR;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259339);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ViN != null) {
                aVar.e(1, this.ViN);
            }
            aVar.aM(2, this.ViO);
            if (this.ViP != null) {
                aVar.e(101, this.ViP);
            }
            aVar.aM(102, this.ViQ);
            if (this.ViR != null) {
                aVar.c(103, this.ViR);
            }
            aVar.bb(104, this.seq);
            AppMethodBeat.o(259339);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ViN != null ? g.a.a.b.b.a.f(1, this.ViN) + 0 : 0) + g.a.a.b.b.a.bu(2, this.ViO);
            if (this.ViP != null) {
                f2 += g.a.a.b.b.a.f(101, this.ViP);
            }
            int bu = f2 + g.a.a.b.b.a.bu(102, this.ViQ);
            if (this.ViR != null) {
                bu += g.a.a.b.b.a.b(103, this.ViR);
            }
            int r = bu + g.a.a.b.b.a.r(104, this.seq);
            AppMethodBeat.o(259339);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259339);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgg fgg = (fgg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fgg.ViN = aVar3.UbS.readString();
                    AppMethodBeat.o(259339);
                    return 0;
                case 2:
                    fgg.ViO = aVar3.UbS.zi();
                    AppMethodBeat.o(259339);
                    return 0;
                case 101:
                    fgg.ViP = aVar3.UbS.readString();
                    AppMethodBeat.o(259339);
                    return 0;
                case 102:
                    fgg.ViQ = aVar3.UbS.zi();
                    AppMethodBeat.o(259339);
                    return 0;
                case 103:
                    fgg.ViR = aVar3.UbS.hPo();
                    AppMethodBeat.o(259339);
                    return 0;
                case 104:
                    fgg.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(259339);
                    return 0;
                default:
                    AppMethodBeat.o(259339);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259339);
            return -1;
        }
    }
}
