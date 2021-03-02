package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cpd extends a {
    public String Lir;
    public String Lis;
    public int Mvd;
    public int Mve;
    public String UserName;
    public int kdY;
    public String kdZ;
    public String kea;
    public String keb;
    public String keh;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32348);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.kdY);
            if (this.kea != null) {
                aVar.e(4, this.kea);
            }
            if (this.kdZ != null) {
                aVar.e(5, this.kdZ);
            }
            if (this.keb != null) {
                aVar.e(6, this.keb);
            }
            aVar.aM(7, this.Mvd);
            aVar.aM(8, this.Mve);
            if (this.keh != null) {
                aVar.e(9, this.keh);
            }
            if (this.Lir != null) {
                aVar.e(10, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(11, this.Lis);
            }
            AppMethodBeat.o(32348);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.kdY);
            if (this.kea != null) {
                f2 += g.a.a.b.b.a.f(4, this.kea);
            }
            if (this.kdZ != null) {
                f2 += g.a.a.b.b.a.f(5, this.kdZ);
            }
            if (this.keb != null) {
                f2 += g.a.a.b.b.a.f(6, this.keb);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.Mvd) + g.a.a.b.b.a.bu(8, this.Mve);
            if (this.keh != null) {
                bu += g.a.a.b.b.a.f(9, this.keh);
            }
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(10, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(11, this.Lis);
            }
            AppMethodBeat.o(32348);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32348);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpd cpd = (cpd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpd.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 2:
                    cpd.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32348);
                    return 0;
                case 3:
                    cpd.kdY = aVar3.UbS.zi();
                    AppMethodBeat.o(32348);
                    return 0;
                case 4:
                    cpd.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 5:
                    cpd.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 6:
                    cpd.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 7:
                    cpd.Mvd = aVar3.UbS.zi();
                    AppMethodBeat.o(32348);
                    return 0;
                case 8:
                    cpd.Mve = aVar3.UbS.zi();
                    AppMethodBeat.o(32348);
                    return 0;
                case 9:
                    cpd.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 10:
                    cpd.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                case 11:
                    cpd.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(32348);
                    return 0;
                default:
                    AppMethodBeat.o(32348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32348);
            return -1;
        }
    }
}
