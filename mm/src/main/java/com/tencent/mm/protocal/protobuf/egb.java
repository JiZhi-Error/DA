package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class egb extends a {
    public int KHa;
    public String KQY;
    public String NfV;
    public String UserName;
    public String keb;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124559);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            aVar.aM(3, this.KHa);
            if (this.NfV != null) {
                aVar.e(4, this.NfV);
            }
            if (this.keb != null) {
                aVar.e(5, this.keb);
            }
            if (this.KQY != null) {
                aVar.e(6, this.KQY);
            }
            AppMethodBeat.o(124559);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KHa);
            if (this.NfV != null) {
                bu += g.a.a.b.b.a.f(4, this.NfV);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(5, this.keb);
            }
            if (this.KQY != null) {
                bu += g.a.a.b.b.a.f(6, this.KQY);
            }
            AppMethodBeat.o(124559);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124559);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egb egb = (egb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egb.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(124559);
                    return 0;
                case 2:
                    egb.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(124559);
                    return 0;
                case 3:
                    egb.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(124559);
                    return 0;
                case 4:
                    egb.NfV = aVar3.UbS.readString();
                    AppMethodBeat.o(124559);
                    return 0;
                case 5:
                    egb.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(124559);
                    return 0;
                case 6:
                    egb.KQY = aVar3.UbS.readString();
                    AppMethodBeat.o(124559);
                    return 0;
                default:
                    AppMethodBeat.o(124559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124559);
            return -1;
        }
    }
}
