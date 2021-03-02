package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class evs extends a {
    public String KDQ;
    public boolean Ntt;
    public String Ntu;
    public int Ntv;
    public int Ntw;
    public int Ntx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147805);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.Ntt);
            if (this.KDQ != null) {
                aVar.e(2, this.KDQ);
            }
            if (this.Ntu != null) {
                aVar.e(3, this.Ntu);
            }
            aVar.aM(4, this.Ntv);
            aVar.aM(5, this.Ntw);
            aVar.aM(6, this.Ntx);
            AppMethodBeat.o(147805);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0;
            if (this.KDQ != null) {
                fS += g.a.a.b.b.a.f(2, this.KDQ);
            }
            if (this.Ntu != null) {
                fS += g.a.a.b.b.a.f(3, this.Ntu);
            }
            int bu = fS + g.a.a.b.b.a.bu(4, this.Ntv) + g.a.a.b.b.a.bu(5, this.Ntw) + g.a.a.b.b.a.bu(6, this.Ntx);
            AppMethodBeat.o(147805);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147805);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            evs evs = (evs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    evs.Ntt = aVar3.UbS.yZ();
                    AppMethodBeat.o(147805);
                    return 0;
                case 2:
                    evs.KDQ = aVar3.UbS.readString();
                    AppMethodBeat.o(147805);
                    return 0;
                case 3:
                    evs.Ntu = aVar3.UbS.readString();
                    AppMethodBeat.o(147805);
                    return 0;
                case 4:
                    evs.Ntv = aVar3.UbS.zi();
                    AppMethodBeat.o(147805);
                    return 0;
                case 5:
                    evs.Ntw = aVar3.UbS.zi();
                    AppMethodBeat.o(147805);
                    return 0;
                case 6:
                    evs.Ntx = aVar3.UbS.zi();
                    AppMethodBeat.o(147805);
                    return 0;
                default:
                    AppMethodBeat.o(147805);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147805);
            return -1;
        }
    }
}
