package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ebj extends a {
    public int Nbc;
    public int Nbd;
    public int kej;
    public String kek;
    public long kel;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43131);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.kej);
            if (this.kek != null) {
                aVar.e(2, this.kek);
            }
            aVar.bb(3, this.kel);
            aVar.aM(4, this.Nbc);
            aVar.aM(5, this.Nbd);
            AppMethodBeat.o(43131);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.kej) + 0;
            if (this.kek != null) {
                bu += g.a.a.b.b.a.f(2, this.kek);
            }
            int r = bu + g.a.a.b.b.a.r(3, this.kel) + g.a.a.b.b.a.bu(4, this.Nbc) + g.a.a.b.b.a.bu(5, this.Nbd);
            AppMethodBeat.o(43131);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43131);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebj ebj = (ebj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebj.kej = aVar3.UbS.zi();
                    AppMethodBeat.o(43131);
                    return 0;
                case 2:
                    ebj.kek = aVar3.UbS.readString();
                    AppMethodBeat.o(43131);
                    return 0;
                case 3:
                    ebj.kel = aVar3.UbS.zl();
                    AppMethodBeat.o(43131);
                    return 0;
                case 4:
                    ebj.Nbc = aVar3.UbS.zi();
                    AppMethodBeat.o(43131);
                    return 0;
                case 5:
                    ebj.Nbd = aVar3.UbS.zi();
                    AppMethodBeat.o(43131);
                    return 0;
                default:
                    AppMethodBeat.o(43131);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43131);
            return -1;
        }
    }
}
