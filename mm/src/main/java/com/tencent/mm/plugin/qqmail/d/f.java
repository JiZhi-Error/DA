package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class f extends a {
    public int Brl;
    public String Brm;
    public long Brn;
    public int FileSize;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122660);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Brl);
            if (this.Brm != null) {
                aVar.e(2, this.Brm);
            }
            aVar.aM(3, this.oTW);
            aVar.aM(4, this.FileSize);
            aVar.bb(5, this.Brn);
            AppMethodBeat.o(122660);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brl) + 0;
            if (this.Brm != null) {
                bu += g.a.a.b.b.a.f(2, this.Brm);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.oTW) + g.a.a.b.b.a.bu(4, this.FileSize) + g.a.a.b.b.a.r(5, this.Brn);
            AppMethodBeat.o(122660);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122660);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(122660);
                    return 0;
                case 2:
                    fVar.Brm = aVar3.UbS.readString();
                    AppMethodBeat.o(122660);
                    return 0;
                case 3:
                    fVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(122660);
                    return 0;
                case 4:
                    fVar.FileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(122660);
                    return 0;
                case 5:
                    fVar.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(122660);
                    return 0;
                default:
                    AppMethodBeat.o(122660);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122660);
            return -1;
        }
    }
}
