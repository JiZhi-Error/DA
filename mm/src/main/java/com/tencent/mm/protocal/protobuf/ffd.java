package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ffd extends a {
    public int MCa;
    public String NAt;
    public boolean NAy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50127);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NAt != null) {
                aVar.e(1, this.NAt);
            }
            aVar.cc(2, this.NAy);
            aVar.aM(3, this.MCa);
            AppMethodBeat.o(50127);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.NAt != null ? g.a.a.b.b.a.f(1, this.NAt) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.MCa);
            AppMethodBeat.o(50127);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50127);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffd ffd = (ffd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffd.NAt = aVar3.UbS.readString();
                    AppMethodBeat.o(50127);
                    return 0;
                case 2:
                    ffd.NAy = aVar3.UbS.yZ();
                    AppMethodBeat.o(50127);
                    return 0;
                case 3:
                    ffd.MCa = aVar3.UbS.zi();
                    AppMethodBeat.o(50127);
                    return 0;
                default:
                    AppMethodBeat.o(50127);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50127);
            return -1;
        }
    }
}