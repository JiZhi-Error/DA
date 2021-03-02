package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class alg extends a {
    public int Lul;
    public String Name;
    public long oIi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155404);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.oIi);
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            aVar.aM(3, this.Lul);
            AppMethodBeat.o(155404);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.oIi) + 0;
            if (this.Name != null) {
                r += g.a.a.b.b.a.f(2, this.Name);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.Lul);
            AppMethodBeat.o(155404);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155404);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alg alg = (alg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alg.oIi = aVar3.UbS.zl();
                    AppMethodBeat.o(155404);
                    return 0;
                case 2:
                    alg.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(155404);
                    return 0;
                case 3:
                    alg.Lul = aVar3.UbS.zi();
                    AppMethodBeat.o(155404);
                    return 0;
                default:
                    AppMethodBeat.o(155404);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155404);
            return -1;
        }
    }
}
