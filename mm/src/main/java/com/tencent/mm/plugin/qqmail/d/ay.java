package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ay extends a {
    public long Btl;
    public String Btm;
    public String Btn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198643);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Btl);
            if (this.Btm != null) {
                aVar.e(2, this.Btm);
            }
            if (this.Btn != null) {
                aVar.e(3, this.Btn);
            }
            AppMethodBeat.o(198643);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Btl) + 0;
            if (this.Btm != null) {
                r += g.a.a.b.b.a.f(2, this.Btm);
            }
            if (this.Btn != null) {
                r += g.a.a.b.b.a.f(3, this.Btn);
            }
            AppMethodBeat.o(198643);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198643);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.Btl = aVar3.UbS.zl();
                    AppMethodBeat.o(198643);
                    return 0;
                case 2:
                    ayVar.Btm = aVar3.UbS.readString();
                    AppMethodBeat.o(198643);
                    return 0;
                case 3:
                    ayVar.Btn = aVar3.UbS.readString();
                    AppMethodBeat.o(198643);
                    return 0;
                default:
                    AppMethodBeat.o(198643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198643);
            return -1;
        }
    }
}
