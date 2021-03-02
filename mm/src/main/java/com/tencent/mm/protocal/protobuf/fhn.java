package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fhn extends a {
    public String KDW;
    public int KDY;
    public String VjW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259373);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.VjW != null) {
                aVar.e(1, this.VjW);
            }
            if (this.KDW != null) {
                aVar.e(2, this.KDW);
            }
            aVar.aM(3, this.KDY);
            AppMethodBeat.o(259373);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.VjW != null ? g.a.a.b.b.a.f(1, this.VjW) + 0 : 0;
            if (this.KDW != null) {
                f2 += g.a.a.b.b.a.f(2, this.KDW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KDY);
            AppMethodBeat.o(259373);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259373);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhn fhn = (fhn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fhn.VjW = aVar3.UbS.readString();
                    AppMethodBeat.o(259373);
                    return 0;
                case 2:
                    fhn.KDW = aVar3.UbS.readString();
                    AppMethodBeat.o(259373);
                    return 0;
                case 3:
                    fhn.KDY = aVar3.UbS.zi();
                    AppMethodBeat.o(259373);
                    return 0;
                default:
                    AppMethodBeat.o(259373);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259373);
            return -1;
        }
    }
}
