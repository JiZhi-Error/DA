package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dr extends a {
    public String KHE;
    public String KHF;
    public String UserName;
    public String kdZ;
    public String kea;
    public String keh;
    public String xKd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91348);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.keh != null) {
                aVar.e(1, this.keh);
            }
            if (this.kdZ != null) {
                aVar.e(2, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(3, this.kea);
            }
            if (this.xKd != null) {
                aVar.e(4, this.xKd);
            }
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            if (this.KHE != null) {
                aVar.e(6, this.KHE);
            }
            if (this.KHF != null) {
                aVar.e(7, this.KHF);
            }
            AppMethodBeat.o(91348);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.keh != null ? g.a.a.b.b.a.f(1, this.keh) + 0 : 0;
            if (this.kdZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.kdZ);
            }
            if (this.kea != null) {
                f2 += g.a.a.b.b.a.f(3, this.kea);
            }
            if (this.xKd != null) {
                f2 += g.a.a.b.b.a.f(4, this.xKd);
            }
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(5, this.UserName);
            }
            if (this.KHE != null) {
                f2 += g.a.a.b.b.a.f(6, this.KHE);
            }
            if (this.KHF != null) {
                f2 += g.a.a.b.b.a.f(7, this.KHF);
            }
            AppMethodBeat.o(91348);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91348);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drVar.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 2:
                    drVar.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 3:
                    drVar.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 4:
                    drVar.xKd = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 5:
                    drVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 6:
                    drVar.KHE = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                case 7:
                    drVar.KHF = aVar3.UbS.readString();
                    AppMethodBeat.o(91348);
                    return 0;
                default:
                    AppMethodBeat.o(91348);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91348);
            return -1;
        }
    }
}
