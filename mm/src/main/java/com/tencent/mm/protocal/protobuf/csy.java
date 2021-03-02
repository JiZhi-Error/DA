package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class csy extends a {
    public int KXD;
    public String MxW;
    public String MxX;
    public String path;
    public int type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123630);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.MxW != null) {
                aVar.e(2, this.MxW);
            }
            if (this.MxX != null) {
                aVar.e(3, this.MxX);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.aM(5, this.KXD);
            aVar.aM(6, this.type);
            AppMethodBeat.o(123630);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.MxW != null) {
                f2 += g.a.a.b.b.a.f(2, this.MxW);
            }
            if (this.MxX != null) {
                f2 += g.a.a.b.b.a.f(3, this.MxX);
            }
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(4, this.path);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KXD) + g.a.a.b.b.a.bu(6, this.type);
            AppMethodBeat.o(123630);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123630);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csy csy = (csy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csy.username = aVar3.UbS.readString();
                    AppMethodBeat.o(123630);
                    return 0;
                case 2:
                    csy.MxW = aVar3.UbS.readString();
                    AppMethodBeat.o(123630);
                    return 0;
                case 3:
                    csy.MxX = aVar3.UbS.readString();
                    AppMethodBeat.o(123630);
                    return 0;
                case 4:
                    csy.path = aVar3.UbS.readString();
                    AppMethodBeat.o(123630);
                    return 0;
                case 5:
                    csy.KXD = aVar3.UbS.zi();
                    AppMethodBeat.o(123630);
                    return 0;
                case 6:
                    csy.type = aVar3.UbS.zi();
                    AppMethodBeat.o(123630);
                    return 0;
                default:
                    AppMethodBeat.o(123630);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123630);
            return -1;
        }
    }
}
