package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ckg extends a {
    public int KCC;
    public String KQi;
    public String MpD;
    public int MpE;
    public String UUID;
    public String UserName;
    public int oTW;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(232378);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UUID != null) {
                aVar.e(1, this.UUID);
            }
            aVar.aM(2, this.oTW);
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            if (this.KQi != null) {
                aVar.e(4, this.KQi);
            }
            if (this.MpD != null) {
                aVar.e(5, this.MpD);
            }
            aVar.aM(6, this.MpE);
            if (this.oUJ != null) {
                aVar.e(7, this.oUJ);
            }
            aVar.aM(8, this.KCC);
            AppMethodBeat.o(232378);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UUID != null ? g.a.a.b.b.a.f(1, this.UUID) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTW);
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(3, this.UserName);
            }
            if (this.KQi != null) {
                f2 += g.a.a.b.b.a.f(4, this.KQi);
            }
            if (this.MpD != null) {
                f2 += g.a.a.b.b.a.f(5, this.MpD);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.MpE);
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(7, this.oUJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.KCC);
            AppMethodBeat.o(232378);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(232378);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckg ckg = (ckg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckg.UUID = aVar3.UbS.readString();
                    AppMethodBeat.o(232378);
                    return 0;
                case 2:
                    ckg.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(232378);
                    return 0;
                case 3:
                    ckg.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(232378);
                    return 0;
                case 4:
                    ckg.KQi = aVar3.UbS.readString();
                    AppMethodBeat.o(232378);
                    return 0;
                case 5:
                    ckg.MpD = aVar3.UbS.readString();
                    AppMethodBeat.o(232378);
                    return 0;
                case 6:
                    ckg.MpE = aVar3.UbS.zi();
                    AppMethodBeat.o(232378);
                    return 0;
                case 7:
                    ckg.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(232378);
                    return 0;
                case 8:
                    ckg.KCC = aVar3.UbS.zi();
                    AppMethodBeat.o(232378);
                    return 0;
                default:
                    AppMethodBeat.o(232378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(232378);
            return -1;
        }
    }
}
