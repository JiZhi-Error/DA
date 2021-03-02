package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bl extends a {
    public String Hwr;
    public String Hws;
    public String IhY;
    public int IhZ;
    public String dQx;
    public String icon;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91345);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.icon != null) {
                aVar.e(3, this.icon);
            }
            if (this.IhY != null) {
                aVar.e(4, this.IhY);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.Hwr != null) {
                aVar.e(6, this.Hwr);
            }
            if (this.Hws != null) {
                aVar.e(7, this.Hws);
            }
            aVar.aM(8, this.IhZ);
            AppMethodBeat.o(91345);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(3, this.icon);
            }
            if (this.IhY != null) {
                f2 += g.a.a.b.b.a.f(4, this.IhY);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(5, this.title);
            }
            if (this.Hwr != null) {
                f2 += g.a.a.b.b.a.f(6, this.Hwr);
            }
            if (this.Hws != null) {
                f2 += g.a.a.b.b.a.f(7, this.Hws);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.IhZ);
            AppMethodBeat.o(91345);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91345);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bl blVar = (bl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 2:
                    blVar.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 3:
                    blVar.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 4:
                    blVar.IhY = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 5:
                    blVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 6:
                    blVar.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 7:
                    blVar.Hws = aVar3.UbS.readString();
                    AppMethodBeat.o(91345);
                    return 0;
                case 8:
                    blVar.IhZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91345);
                    return 0;
                default:
                    AppMethodBeat.o(91345);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91345);
            return -1;
        }
    }
}
