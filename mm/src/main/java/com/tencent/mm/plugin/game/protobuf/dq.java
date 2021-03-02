package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dq extends a {
    public String IconUrl;
    public String xIy;
    public String xNh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41832);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNh != null) {
                aVar.e(1, this.xNh);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.xIy != null) {
                aVar.e(3, this.xIy);
            }
            AppMethodBeat.o(41832);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNh != null ? g.a.a.b.b.a.f(1, this.xNh) + 0 : 0;
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIy);
            }
            AppMethodBeat.o(41832);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41832);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dq dqVar = (dq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqVar.xNh = aVar3.UbS.readString();
                    AppMethodBeat.o(41832);
                    return 0;
                case 2:
                    dqVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41832);
                    return 0;
                case 3:
                    dqVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41832);
                    return 0;
                default:
                    AppMethodBeat.o(41832);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41832);
            return -1;
        }
    }
}
