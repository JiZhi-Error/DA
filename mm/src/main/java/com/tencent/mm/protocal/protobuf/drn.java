package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class drn extends a {
    public String KQY;
    public String MUb;
    public String MUc;
    public b MUd;
    public b MUe;
    public b MUf;
    public int MmK;
    public String Username;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public String keh;
    public int kem;
    public String oUJ;
    public String xJE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187877);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.MUb != null) {
                aVar.e(3, this.MUb);
            }
            if (this.MUc != null) {
                aVar.e(4, this.MUc);
            }
            if (this.keh != null) {
                aVar.e(5, this.keh);
            }
            if (this.kdZ != null) {
                aVar.e(6, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(7, this.kea);
            }
            if (this.keb != null) {
                aVar.e(8, this.keb);
            }
            aVar.aM(9, this.kdY);
            aVar.aM(10, this.MmK);
            if (this.MUd != null) {
                aVar.c(11, this.MUd);
            }
            if (this.KQY != null) {
                aVar.e(12, this.KQY);
            }
            if (this.MUe != null) {
                aVar.c(13, this.MUe);
            }
            if (this.MUf != null) {
                aVar.c(14, this.MUf);
            }
            aVar.aM(15, this.kem);
            if (this.xJE != null) {
                aVar.e(16, this.xJE);
            }
            AppMethodBeat.o(187877);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.MUb != null) {
                f2 += g.a.a.b.b.a.f(3, this.MUb);
            }
            if (this.MUc != null) {
                f2 += g.a.a.b.b.a.f(4, this.MUc);
            }
            if (this.keh != null) {
                f2 += g.a.a.b.b.a.f(5, this.keh);
            }
            if (this.kdZ != null) {
                f2 += g.a.a.b.b.a.f(6, this.kdZ);
            }
            if (this.kea != null) {
                f2 += g.a.a.b.b.a.f(7, this.kea);
            }
            if (this.keb != null) {
                f2 += g.a.a.b.b.a.f(8, this.keb);
            }
            int bu = f2 + g.a.a.b.b.a.bu(9, this.kdY) + g.a.a.b.b.a.bu(10, this.MmK);
            if (this.MUd != null) {
                bu += g.a.a.b.b.a.b(11, this.MUd);
            }
            if (this.KQY != null) {
                bu += g.a.a.b.b.a.f(12, this.KQY);
            }
            if (this.MUe != null) {
                bu += g.a.a.b.b.a.b(13, this.MUe);
            }
            if (this.MUf != null) {
                bu += g.a.a.b.b.a.b(14, this.MUf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.kem);
            if (this.xJE != null) {
                bu2 += g.a.a.b.b.a.f(16, this.xJE);
            }
            AppMethodBeat.o(187877);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187877);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drn drn = (drn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drn.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 2:
                    drn.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 3:
                    drn.MUb = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 4:
                    drn.MUc = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 5:
                    drn.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 6:
                    drn.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 7:
                    drn.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 8:
                    drn.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 9:
                    drn.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(187877);
                    return 0;
                case 10:
                    drn.MmK = aVar3.UbS.zi();
                    AppMethodBeat.o(187877);
                    return 0;
                case 11:
                    drn.MUd = aVar3.UbS.hPo();
                    AppMethodBeat.o(187877);
                    return 0;
                case 12:
                    drn.KQY = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                case 13:
                    drn.MUe = aVar3.UbS.hPo();
                    AppMethodBeat.o(187877);
                    return 0;
                case 14:
                    drn.MUf = aVar3.UbS.hPo();
                    AppMethodBeat.o(187877);
                    return 0;
                case 15:
                    drn.kem = aVar3.UbS.zi();
                    AppMethodBeat.o(187877);
                    return 0;
                case 16:
                    drn.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(187877);
                    return 0;
                default:
                    AppMethodBeat.o(187877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187877);
            return -1;
        }
    }
}
