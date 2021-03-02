package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ayq extends a {
    public String nickname;
    public int source;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209598);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aM(2, this.source);
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            AppMethodBeat.o(209598);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.source);
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.nickname);
            }
            AppMethodBeat.o(209598);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209598);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayq ayq = (ayq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayq.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209598);
                    return 0;
                case 2:
                    ayq.source = aVar3.UbS.zi();
                    AppMethodBeat.o(209598);
                    return 0;
                case 3:
                    ayq.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(209598);
                    return 0;
                default:
                    AppMethodBeat.o(209598);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209598);
            return -1;
        }
    }
}
