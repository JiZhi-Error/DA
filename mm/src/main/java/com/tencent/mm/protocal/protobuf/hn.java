package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class hn extends a {
    public int Ijz;
    public boolean KLw;
    public String KLx;
    public String dNR;
    public String dNS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(19404);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KLw);
            aVar.aM(2, this.Ijz);
            if (this.dNR != null) {
                aVar.e(3, this.dNR);
            }
            if (this.dNS != null) {
                aVar.e(4, this.dNS);
            }
            if (this.KLx != null) {
                aVar.e(5, this.KLx);
            }
            AppMethodBeat.o(19404);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.bu(2, this.Ijz);
            if (this.dNR != null) {
                fS += g.a.a.b.b.a.f(3, this.dNR);
            }
            if (this.dNS != null) {
                fS += g.a.a.b.b.a.f(4, this.dNS);
            }
            if (this.KLx != null) {
                fS += g.a.a.b.b.a.f(5, this.KLx);
            }
            AppMethodBeat.o(19404);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(19404);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hn hnVar = (hn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hnVar.KLw = aVar3.UbS.yZ();
                    AppMethodBeat.o(19404);
                    return 0;
                case 2:
                    hnVar.Ijz = aVar3.UbS.zi();
                    AppMethodBeat.o(19404);
                    return 0;
                case 3:
                    hnVar.dNR = aVar3.UbS.readString();
                    AppMethodBeat.o(19404);
                    return 0;
                case 4:
                    hnVar.dNS = aVar3.UbS.readString();
                    AppMethodBeat.o(19404);
                    return 0;
                case 5:
                    hnVar.KLx = aVar3.UbS.readString();
                    AppMethodBeat.o(19404);
                    return 0;
                default:
                    AppMethodBeat.o(19404);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19404);
            return -1;
        }
    }
}
