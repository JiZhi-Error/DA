package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cpa extends a {
    public boolean Htd;
    public String Hte;
    public LinkedList<Integer> Mvb = new LinkedList<>();

    public cpa() {
        AppMethodBeat.i(91541);
        AppMethodBeat.o(91541);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91542);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.Htd);
            if (this.Hte != null) {
                aVar.e(2, this.Hte);
            }
            aVar.e(3, 2, this.Mvb);
            AppMethodBeat.o(91542);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.Hte != null) {
                fS += g.a.a.b.b.a.f(2, this.Hte);
            }
            int c2 = fS + g.a.a.a.c(3, 2, this.Mvb);
            AppMethodBeat.o(91542);
            return c2;
        } else if (i2 == 2) {
            this.Mvb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91542);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpa cpa = (cpa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpa.Htd = aVar3.UbS.yZ();
                    AppMethodBeat.o(91542);
                    return 0;
                case 2:
                    cpa.Hte = aVar3.UbS.readString();
                    AppMethodBeat.o(91542);
                    return 0;
                case 3:
                    cpa.Mvb.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(91542);
                    return 0;
                default:
                    AppMethodBeat.o(91542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91542);
            return -1;
        }
    }
}
