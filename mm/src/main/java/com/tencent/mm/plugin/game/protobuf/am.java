package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class am extends a {
    public String xKn;
    public String xKo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41731);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKn != null) {
                aVar.e(1, this.xKn);
            }
            if (this.xKo != null) {
                aVar.e(2, this.xKo);
            }
            AppMethodBeat.o(41731);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xKn != null ? g.a.a.b.b.a.f(1, this.xKn) + 0 : 0;
            if (this.xKo != null) {
                f2 += g.a.a.b.b.a.f(2, this.xKo);
            }
            AppMethodBeat.o(41731);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41731);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            am amVar = (am) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amVar.xKn = aVar3.UbS.readString();
                    AppMethodBeat.o(41731);
                    return 0;
                case 2:
                    amVar.xKo = aVar3.UbS.readString();
                    AppMethodBeat.o(41731);
                    return 0;
                default:
                    AppMethodBeat.o(41731);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41731);
            return -1;
        }
    }
}
