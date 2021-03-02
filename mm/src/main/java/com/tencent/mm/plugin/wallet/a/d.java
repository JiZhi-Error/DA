package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class d extends a {
    public String Coh;
    public int HEl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91288);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Coh != null) {
                aVar.e(1, this.Coh);
            }
            aVar.aM(2, this.HEl);
            AppMethodBeat.o(91288);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Coh != null ? g.a.a.b.b.a.f(1, this.Coh) + 0 : 0) + g.a.a.b.b.a.bu(2, this.HEl);
            AppMethodBeat.o(91288);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91288);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.Coh = aVar3.UbS.readString();
                    AppMethodBeat.o(91288);
                    return 0;
                case 2:
                    dVar.HEl = aVar3.UbS.zi();
                    AppMethodBeat.o(91288);
                    return 0;
                default:
                    AppMethodBeat.o(91288);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91288);
            return -1;
        }
    }
}
