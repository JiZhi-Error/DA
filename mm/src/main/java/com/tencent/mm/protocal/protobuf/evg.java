package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class evg extends a {
    public b LrK;
    public int MVo;
    public int Ntf;
    public int apr;
    public String category;
    public int jlm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147790);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.jlm);
            aVar.aM(2, this.apr);
            if (this.category != null) {
                aVar.e(3, this.category);
            }
            if (this.LrK != null) {
                aVar.c(4, this.LrK);
            }
            aVar.aM(5, this.MVo);
            aVar.aM(6, this.Ntf);
            AppMethodBeat.o(147790);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.jlm) + 0 + g.a.a.b.b.a.bu(2, this.apr);
            if (this.category != null) {
                bu += g.a.a.b.b.a.f(3, this.category);
            }
            if (this.LrK != null) {
                bu += g.a.a.b.b.a.b(4, this.LrK);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MVo) + g.a.a.b.b.a.bu(6, this.Ntf);
            AppMethodBeat.o(147790);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147790);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evg evg = (evg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evg.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(147790);
                    return 0;
                case 2:
                    evg.apr = aVar3.UbS.zi();
                    AppMethodBeat.o(147790);
                    return 0;
                case 3:
                    evg.category = aVar3.UbS.readString();
                    AppMethodBeat.o(147790);
                    return 0;
                case 4:
                    evg.LrK = aVar3.UbS.hPo();
                    AppMethodBeat.o(147790);
                    return 0;
                case 5:
                    evg.MVo = aVar3.UbS.zi();
                    AppMethodBeat.o(147790);
                    return 0;
                case 6:
                    evg.Ntf = aVar3.UbS.zi();
                    AppMethodBeat.o(147790);
                    return 0;
                default:
                    AppMethodBeat.o(147790);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147790);
            return -1;
        }
    }
}
