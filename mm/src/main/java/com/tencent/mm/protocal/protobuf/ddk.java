package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ddk extends a {
    public String MIA;
    public String MIB;
    public String MIw;
    public String MIx;
    public String MIy;
    public String MIz;
    public String desc;
    public String icon;
    public String title;
    public int type;
    public String value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209806);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.icon != null) {
                aVar.e(2, this.icon);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.aM(4, this.type);
            if (this.value != null) {
                aVar.e(5, this.value);
            }
            if (this.MIw != null) {
                aVar.e(6, this.MIw);
            }
            if (this.MIx != null) {
                aVar.e(7, this.MIx);
            }
            if (this.MIy != null) {
                aVar.e(8, this.MIy);
            }
            if (this.MIz != null) {
                aVar.e(9, this.MIz);
            }
            if (this.MIA != null) {
                aVar.e(10, this.MIA);
            }
            if (this.MIB != null) {
                aVar.e(11, this.MIB);
            }
            AppMethodBeat.o(209806);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(2, this.icon);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.type);
            if (this.value != null) {
                bu += g.a.a.b.b.a.f(5, this.value);
            }
            if (this.MIw != null) {
                bu += g.a.a.b.b.a.f(6, this.MIw);
            }
            if (this.MIx != null) {
                bu += g.a.a.b.b.a.f(7, this.MIx);
            }
            if (this.MIy != null) {
                bu += g.a.a.b.b.a.f(8, this.MIy);
            }
            if (this.MIz != null) {
                bu += g.a.a.b.b.a.f(9, this.MIz);
            }
            if (this.MIA != null) {
                bu += g.a.a.b.b.a.f(10, this.MIA);
            }
            if (this.MIB != null) {
                bu += g.a.a.b.b.a.f(11, this.MIB);
            }
            AppMethodBeat.o(209806);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209806);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddk ddk = (ddk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ddk.title = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 2:
                    ddk.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 3:
                    ddk.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 4:
                    ddk.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209806);
                    return 0;
                case 5:
                    ddk.value = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 6:
                    ddk.MIw = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 7:
                    ddk.MIx = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 8:
                    ddk.MIy = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 9:
                    ddk.MIz = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 10:
                    ddk.MIA = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                case 11:
                    ddk.MIB = aVar3.UbS.readString();
                    AppMethodBeat.o(209806);
                    return 0;
                default:
                    AppMethodBeat.o(209806);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209806);
            return -1;
        }
    }
}
