package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class duw extends a {
    public boolean HIl;
    public String lHM;
    public String nickname;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153296);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.cc(2, this.HIl);
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.lHM != null) {
                aVar.e(4, this.lHM);
            }
            AppMethodBeat.o(153296);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.lHM != null) {
                f2 += g.a.a.b.b.a.f(4, this.lHM);
            }
            AppMethodBeat.o(153296);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153296);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duw duw = (duw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    duw.username = aVar3.UbS.readString();
                    AppMethodBeat.o(153296);
                    return 0;
                case 2:
                    duw.HIl = aVar3.UbS.yZ();
                    AppMethodBeat.o(153296);
                    return 0;
                case 3:
                    duw.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(153296);
                    return 0;
                case 4:
                    duw.lHM = aVar3.UbS.readString();
                    AppMethodBeat.o(153296);
                    return 0;
                default:
                    AppMethodBeat.o(153296);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153296);
            return -1;
        }
    }
}
