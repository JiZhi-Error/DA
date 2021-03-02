package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctu extends a {
    public String Mzd;
    public String Mze;
    public String Mzf;
    public int action;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194512);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mzd != null) {
                aVar.e(1, this.Mzd);
            }
            if (this.Mze != null) {
                aVar.e(2, this.Mze);
            }
            if (this.Mzf != null) {
                aVar.e(3, this.Mzf);
            }
            aVar.aM(4, this.action);
            AppMethodBeat.o(194512);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mzd != null ? g.a.a.b.b.a.f(1, this.Mzd) + 0 : 0;
            if (this.Mze != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mze);
            }
            if (this.Mzf != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mzf);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.action);
            AppMethodBeat.o(194512);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194512);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctu ctu = (ctu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctu.Mzd = aVar3.UbS.readString();
                    AppMethodBeat.o(194512);
                    return 0;
                case 2:
                    ctu.Mze = aVar3.UbS.readString();
                    AppMethodBeat.o(194512);
                    return 0;
                case 3:
                    ctu.Mzf = aVar3.UbS.readString();
                    AppMethodBeat.o(194512);
                    return 0;
                case 4:
                    ctu.action = aVar3.UbS.zi();
                    AppMethodBeat.o(194512);
                    return 0;
                default:
                    AppMethodBeat.o(194512);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194512);
            return -1;
        }
    }
}
