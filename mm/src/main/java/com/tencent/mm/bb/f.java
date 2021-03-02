package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class f extends a {
    public String jgR;
    public String lang;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(150796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jgR != null) {
                aVar.e(1, this.jgR);
            }
            if (this.lang != null) {
                aVar.e(2, this.lang);
            }
            AppMethodBeat.o(150796);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jgR != null ? g.a.a.b.b.a.f(1, this.jgR) + 0 : 0;
            if (this.lang != null) {
                f2 += g.a.a.b.b.a.f(2, this.lang);
            }
            AppMethodBeat.o(150796);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(150796);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fVar.jgR = aVar3.UbS.readString();
                    AppMethodBeat.o(150796);
                    return 0;
                case 2:
                    fVar.lang = aVar3.UbS.readString();
                    AppMethodBeat.o(150796);
                    return 0;
                default:
                    AppMethodBeat.o(150796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(150796);
            return -1;
        }
    }
}
