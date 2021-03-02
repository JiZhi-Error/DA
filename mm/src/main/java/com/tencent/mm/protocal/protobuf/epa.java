package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class epa extends a {
    public String IconUrl;
    public String KLO;
    public String Lox;
    public String MEP;
    public String MfZ;
    public long NmW;
    public String oTI;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32491);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lox != null) {
                aVar.e(1, this.Lox);
            }
            if (this.KLO != null) {
                aVar.e(2, this.KLO);
            }
            if (this.MEP != null) {
                aVar.e(3, this.MEP);
            }
            if (this.xMq != null) {
                aVar.e(4, this.xMq);
            }
            if (this.oTI != null) {
                aVar.e(5, this.oTI);
            }
            if (this.IconUrl != null) {
                aVar.e(6, this.IconUrl);
            }
            if (this.MfZ != null) {
                aVar.e(7, this.MfZ);
            }
            aVar.bb(8, this.NmW);
            AppMethodBeat.o(32491);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lox != null ? g.a.a.b.b.a.f(1, this.Lox) + 0 : 0;
            if (this.KLO != null) {
                f2 += g.a.a.b.b.a.f(2, this.KLO);
            }
            if (this.MEP != null) {
                f2 += g.a.a.b.b.a.f(3, this.MEP);
            }
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(4, this.xMq);
            }
            if (this.oTI != null) {
                f2 += g.a.a.b.b.a.f(5, this.oTI);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(6, this.IconUrl);
            }
            if (this.MfZ != null) {
                f2 += g.a.a.b.b.a.f(7, this.MfZ);
            }
            int r = f2 + g.a.a.b.b.a.r(8, this.NmW);
            AppMethodBeat.o(32491);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32491);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epa epa = (epa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    epa.Lox = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 2:
                    epa.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 3:
                    epa.MEP = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 4:
                    epa.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 5:
                    epa.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 6:
                    epa.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 7:
                    epa.MfZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32491);
                    return 0;
                case 8:
                    epa.NmW = aVar3.UbS.zl();
                    AppMethodBeat.o(32491);
                    return 0;
                default:
                    AppMethodBeat.o(32491);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32491);
            return -1;
        }
    }
}
