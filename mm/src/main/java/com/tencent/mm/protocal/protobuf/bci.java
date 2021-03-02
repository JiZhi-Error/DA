package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bci extends a {
    public String authIconUrl;
    public String nickname;
    public String uNR;
    public String username;
    public String wDX;
    public int wDY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196093);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.uNR != null) {
                aVar.e(3, this.uNR);
            }
            if (this.wDX != null) {
                aVar.e(4, this.wDX);
            }
            aVar.aM(5, this.wDY);
            if (this.authIconUrl != null) {
                aVar.e(6, this.authIconUrl);
            }
            AppMethodBeat.o(196093);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.uNR != null) {
                f2 += g.a.a.b.b.a.f(3, this.uNR);
            }
            if (this.wDX != null) {
                f2 += g.a.a.b.b.a.f(4, this.wDX);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.wDY);
            if (this.authIconUrl != null) {
                bu += g.a.a.b.b.a.f(6, this.authIconUrl);
            }
            AppMethodBeat.o(196093);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196093);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bci bci = (bci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bci.username = aVar3.UbS.readString();
                    AppMethodBeat.o(196093);
                    return 0;
                case 2:
                    bci.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(196093);
                    return 0;
                case 3:
                    bci.uNR = aVar3.UbS.readString();
                    AppMethodBeat.o(196093);
                    return 0;
                case 4:
                    bci.wDX = aVar3.UbS.readString();
                    AppMethodBeat.o(196093);
                    return 0;
                case 5:
                    bci.wDY = aVar3.UbS.zi();
                    AppMethodBeat.o(196093);
                    return 0;
                case 6:
                    bci.authIconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(196093);
                    return 0;
                default:
                    AppMethodBeat.o(196093);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196093);
            return -1;
        }
    }
}
