package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aas extends a {
    public String Lma;
    public String sGE;
    public String sGQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196086);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sGQ != null) {
                aVar.e(1, this.sGQ);
            }
            if (this.sGE != null) {
                aVar.e(2, this.sGE);
            }
            if (this.Lma != null) {
                aVar.e(3, this.Lma);
            }
            AppMethodBeat.o(196086);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sGQ != null ? g.a.a.b.b.a.f(1, this.sGQ) + 0 : 0;
            if (this.sGE != null) {
                f2 += g.a.a.b.b.a.f(2, this.sGE);
            }
            if (this.Lma != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lma);
            }
            AppMethodBeat.o(196086);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196086);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aas aas = (aas) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aas.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(196086);
                    return 0;
                case 2:
                    aas.sGE = aVar3.UbS.readString();
                    AppMethodBeat.o(196086);
                    return 0;
                case 3:
                    aas.Lma = aVar3.UbS.readString();
                    AppMethodBeat.o(196086);
                    return 0;
                default:
                    AppMethodBeat.o(196086);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196086);
            return -1;
        }
    }
}
