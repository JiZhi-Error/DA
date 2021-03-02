package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ih extends a {
    public String KGX;
    public int KMt;
    public String KMu;
    public String KMv;
    public String UserName;
    public String keb;
    public String oUJ;
    public int wSO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32127);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KGX != null) {
                aVar.e(1, this.KGX);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            aVar.aM(4, this.KMt);
            if (this.KMu != null) {
                aVar.e(5, this.KMu);
            }
            if (this.keb != null) {
                aVar.e(6, this.keb);
            }
            if (this.KMv != null) {
                aVar.e(7, this.KMv);
            }
            aVar.aM(8, this.wSO);
            AppMethodBeat.o(32127);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KGX != null ? g.a.a.b.b.a.f(1, this.KGX) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(3, this.UserName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KMt);
            if (this.KMu != null) {
                bu += g.a.a.b.b.a.f(5, this.KMu);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(6, this.keb);
            }
            if (this.KMv != null) {
                bu += g.a.a.b.b.a.f(7, this.KMv);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.wSO);
            AppMethodBeat.o(32127);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32127);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ih ihVar = (ih) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ihVar.KGX = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 2:
                    ihVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 3:
                    ihVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 4:
                    ihVar.KMt = aVar3.UbS.zi();
                    AppMethodBeat.o(32127);
                    return 0;
                case 5:
                    ihVar.KMu = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 6:
                    ihVar.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 7:
                    ihVar.KMv = aVar3.UbS.readString();
                    AppMethodBeat.o(32127);
                    return 0;
                case 8:
                    ihVar.wSO = aVar3.UbS.zi();
                    AppMethodBeat.o(32127);
                    return 0;
                default:
                    AppMethodBeat.o(32127);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32127);
            return -1;
        }
    }
}
