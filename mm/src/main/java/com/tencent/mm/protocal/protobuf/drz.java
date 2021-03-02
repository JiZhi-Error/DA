package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class drz extends a {
    public String HeadUrl;
    public String MUC;
    public String MUD;
    public String Title;
    public String UserName;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187880);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.HeadUrl != null) {
                aVar.e(3, this.HeadUrl);
            }
            if (this.oUJ != null) {
                aVar.e(4, this.oUJ);
            }
            if (this.MUC != null) {
                aVar.e(5, this.MUC);
            }
            if (this.MUD != null) {
                aVar.e(6, this.MUD);
            }
            AppMethodBeat.o(187880);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.HeadUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.HeadUrl);
            }
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(4, this.oUJ);
            }
            if (this.MUC != null) {
                f2 += g.a.a.b.b.a.f(5, this.MUC);
            }
            if (this.MUD != null) {
                f2 += g.a.a.b.b.a.f(6, this.MUD);
            }
            AppMethodBeat.o(187880);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187880);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drz drz = (drz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drz.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                case 2:
                    drz.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                case 3:
                    drz.HeadUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                case 4:
                    drz.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                case 5:
                    drz.MUC = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                case 6:
                    drz.MUD = aVar3.UbS.readString();
                    AppMethodBeat.o(187880);
                    return 0;
                default:
                    AppMethodBeat.o(187880);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187880);
            return -1;
        }
    }
}
