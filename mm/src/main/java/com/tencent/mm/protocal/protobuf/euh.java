package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class euh extends a {
    public int GWw;
    public int GWx;
    public String dQC;
    public int oXT;
    public String userName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115904);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oXT);
            aVar.aM(2, this.GWx);
            aVar.aM(3, this.GWw);
            if (this.userName != null) {
                aVar.e(4, this.userName);
            }
            if (this.dQC != null) {
                aVar.e(5, this.dQC);
            }
            AppMethodBeat.o(115904);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oXT) + 0 + g.a.a.b.b.a.bu(2, this.GWx) + g.a.a.b.b.a.bu(3, this.GWw);
            if (this.userName != null) {
                bu += g.a.a.b.b.a.f(4, this.userName);
            }
            if (this.dQC != null) {
                bu += g.a.a.b.b.a.f(5, this.dQC);
            }
            AppMethodBeat.o(115904);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115904);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euh euh = (euh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    euh.oXT = aVar3.UbS.zi();
                    AppMethodBeat.o(115904);
                    return 0;
                case 2:
                    euh.GWx = aVar3.UbS.zi();
                    AppMethodBeat.o(115904);
                    return 0;
                case 3:
                    euh.GWw = aVar3.UbS.zi();
                    AppMethodBeat.o(115904);
                    return 0;
                case 4:
                    euh.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(115904);
                    return 0;
                case 5:
                    euh.dQC = aVar3.UbS.readString();
                    AppMethodBeat.o(115904);
                    return 0;
                default:
                    AppMethodBeat.o(115904);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115904);
            return -1;
        }
    }
}
