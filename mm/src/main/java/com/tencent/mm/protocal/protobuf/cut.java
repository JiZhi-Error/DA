package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cut extends a {
    public String Bri;
    public int KXP;
    public String UserName;
    public String dRe;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184131);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.Bri != null) {
                aVar.e(2, this.Bri);
            }
            aVar.aM(3, this.KXP);
            if (this.oUJ != null) {
                aVar.e(4, this.oUJ);
            }
            if (this.dRe != null) {
                aVar.e(5, this.dRe);
            }
            AppMethodBeat.o(184131);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.Bri != null) {
                f2 += g.a.a.b.b.a.f(2, this.Bri);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KXP);
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(4, this.oUJ);
            }
            if (this.dRe != null) {
                bu += g.a.a.b.b.a.f(5, this.dRe);
            }
            AppMethodBeat.o(184131);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184131);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cut cut = (cut) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cut.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(184131);
                    return 0;
                case 2:
                    cut.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(184131);
                    return 0;
                case 3:
                    cut.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(184131);
                    return 0;
                case 4:
                    cut.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(184131);
                    return 0;
                case 5:
                    cut.dRe = aVar3.UbS.readString();
                    AppMethodBeat.o(184131);
                    return 0;
                default:
                    AppMethodBeat.o(184131);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184131);
            return -1;
        }
    }
}
