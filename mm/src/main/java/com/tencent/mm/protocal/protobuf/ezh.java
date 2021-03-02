package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezh extends a {
    public String MVg;
    public int NcY;
    public b NvI;
    public b NvJ;
    public String NvK;
    public String NvL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MVg == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Msg");
                AppMethodBeat.o(32550);
                throw bVar;
            }
            aVar.aM(1, this.NcY);
            if (this.MVg != null) {
                aVar.e(2, this.MVg);
            }
            if (this.NvI != null) {
                aVar.c(3, this.NvI);
            }
            if (this.NvJ != null) {
                aVar.c(4, this.NvJ);
            }
            if (this.NvK != null) {
                aVar.e(5, this.NvK);
            }
            if (this.NvL != null) {
                aVar.e(6, this.NvL);
            }
            AppMethodBeat.o(32550);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NcY) + 0;
            if (this.MVg != null) {
                bu += g.a.a.b.b.a.f(2, this.MVg);
            }
            if (this.NvI != null) {
                bu += g.a.a.b.b.a.b(3, this.NvI);
            }
            if (this.NvJ != null) {
                bu += g.a.a.b.b.a.b(4, this.NvJ);
            }
            if (this.NvK != null) {
                bu += g.a.a.b.b.a.f(5, this.NvK);
            }
            if (this.NvL != null) {
                bu += g.a.a.b.b.a.f(6, this.NvL);
            }
            AppMethodBeat.o(32550);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MVg == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Msg");
                AppMethodBeat.o(32550);
                throw bVar2;
            }
            AppMethodBeat.o(32550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezh ezh = (ezh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezh.NcY = aVar3.UbS.zi();
                    AppMethodBeat.o(32550);
                    return 0;
                case 2:
                    ezh.MVg = aVar3.UbS.readString();
                    AppMethodBeat.o(32550);
                    return 0;
                case 3:
                    ezh.NvI = aVar3.UbS.hPo();
                    AppMethodBeat.o(32550);
                    return 0;
                case 4:
                    ezh.NvJ = aVar3.UbS.hPo();
                    AppMethodBeat.o(32550);
                    return 0;
                case 5:
                    ezh.NvK = aVar3.UbS.readString();
                    AppMethodBeat.o(32550);
                    return 0;
                case 6:
                    ezh.NvL = aVar3.UbS.readString();
                    AppMethodBeat.o(32550);
                    return 0;
                default:
                    AppMethodBeat.o(32550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32550);
            return -1;
        }
    }
}
