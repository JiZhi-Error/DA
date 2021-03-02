package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class amg extends a {
    public String LuX;
    public String SmallImgUrl;
    public String UserName;
    public int oTW;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32210);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.LuX != null) {
                aVar.e(2, this.LuX);
            }
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(4, this.SmallImgUrl);
            }
            aVar.aM(5, this.oTW);
            AppMethodBeat.o(32210);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.LuX != null) {
                f2 += g.a.a.b.b.a.f(2, this.LuX);
            }
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.SmallImgUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.SmallImgUrl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.oTW);
            AppMethodBeat.o(32210);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32210);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amg amg = (amg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amg.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32210);
                    return 0;
                case 2:
                    amg.LuX = aVar3.UbS.readString();
                    AppMethodBeat.o(32210);
                    return 0;
                case 3:
                    amg.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32210);
                    return 0;
                case 4:
                    amg.SmallImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(32210);
                    return 0;
                case 5:
                    amg.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(32210);
                    return 0;
                default:
                    AppMethodBeat.o(32210);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32210);
            return -1;
        }
    }
}
