package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class amj extends a {
    public String Lve;
    public String appId;
    public String dCx;
    public int dMe;
    public String eda;
    public String iconUrl;
    public int leb;
    public int lyE;
    public int subType;
    public int type;
    public String username;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127455);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            aVar.aM(3, this.dMe);
            if (this.iconUrl != null) {
                aVar.e(4, this.iconUrl);
            }
            aVar.aM(5, this.type);
            if (this.dCx != null) {
                aVar.e(6, this.dCx);
            }
            if (this.Lve != null) {
                aVar.e(7, this.Lve);
            }
            aVar.aM(8, this.version);
            aVar.aM(9, this.lyE);
            aVar.aM(10, this.leb);
            if (this.eda != null) {
                aVar.e(11, this.eda);
            }
            aVar.aM(12, this.subType);
            AppMethodBeat.o(127455);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.appId != null) {
                f2 += g.a.a.b.b.a.f(2, this.appId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.dMe);
            if (this.iconUrl != null) {
                bu += g.a.a.b.b.a.f(4, this.iconUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.type);
            if (this.dCx != null) {
                bu2 += g.a.a.b.b.a.f(6, this.dCx);
            }
            if (this.Lve != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Lve);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.version) + g.a.a.b.b.a.bu(9, this.lyE) + g.a.a.b.b.a.bu(10, this.leb);
            if (this.eda != null) {
                bu3 += g.a.a.b.b.a.f(11, this.eda);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(12, this.subType);
            AppMethodBeat.o(127455);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127455);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amj amj = (amj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amj.username = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 2:
                    amj.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 3:
                    amj.dMe = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                case 4:
                    amj.iconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 5:
                    amj.type = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                case 6:
                    amj.dCx = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 7:
                    amj.Lve = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 8:
                    amj.version = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                case 9:
                    amj.lyE = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                case 10:
                    amj.leb = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                case 11:
                    amj.eda = aVar3.UbS.readString();
                    AppMethodBeat.o(127455);
                    return 0;
                case 12:
                    amj.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(127455);
                    return 0;
                default:
                    AppMethodBeat.o(127455);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127455);
            return -1;
        }
    }
}
