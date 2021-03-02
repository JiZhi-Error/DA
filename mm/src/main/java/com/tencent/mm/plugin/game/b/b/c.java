package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class c extends a {
    public String desc;
    public String xuG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40866);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.desc != null) {
                aVar.e(1, this.desc);
            }
            if (this.xuG != null) {
                aVar.e(2, this.xuG);
            }
            AppMethodBeat.o(40866);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.desc != null ? g.a.a.b.b.a.f(1, this.desc) + 0 : 0;
            if (this.xuG != null) {
                f2 += g.a.a.b.b.a.f(2, this.xuG);
            }
            AppMethodBeat.o(40866);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40866);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(40866);
                    return 0;
                case 2:
                    cVar.xuG = aVar3.UbS.readString();
                    AppMethodBeat.o(40866);
                    return 0;
                default:
                    AppMethodBeat.o(40866);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40866);
            return -1;
        }
    }
}
