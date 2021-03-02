package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class awh extends a {
    public String LBC;
    public String iAR;
    public String nickname;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209528);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.iAR != null) {
                aVar.e(3, this.iAR);
            }
            if (this.LBC != null) {
                aVar.e(4, this.LBC);
            }
            AppMethodBeat.o(209528);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.iAR != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAR);
            }
            if (this.LBC != null) {
                f2 += g.a.a.b.b.a.f(4, this.LBC);
            }
            AppMethodBeat.o(209528);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209528);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awh awh = (awh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awh.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209528);
                    return 0;
                case 2:
                    awh.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(209528);
                    return 0;
                case 3:
                    awh.iAR = aVar3.UbS.readString();
                    AppMethodBeat.o(209528);
                    return 0;
                case 4:
                    awh.LBC = aVar3.UbS.readString();
                    AppMethodBeat.o(209528);
                    return 0;
                default:
                    AppMethodBeat.o(209528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209528);
            return -1;
        }
    }
}
