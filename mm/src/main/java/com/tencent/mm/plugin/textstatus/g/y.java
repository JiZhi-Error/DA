package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class y extends a {
    public String VdQ;
    public String VdR;
    public int VdS;
    public int VdT;
    public int VdU;
    public int VdV;
    public int VdW;
    public String sessionId;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259507);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sessionId != null) {
                aVar.e(1, this.sessionId);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.VdQ != null) {
                aVar.e(3, this.VdQ);
            }
            if (this.VdR != null) {
                aVar.e(4, this.VdR);
            }
            aVar.aM(5, this.VdS);
            aVar.aM(6, this.VdT);
            aVar.aM(7, this.VdU);
            aVar.aM(8, this.VdV);
            aVar.aM(9, this.VdW);
            AppMethodBeat.o(259507);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sessionId != null ? g.a.a.b.b.a.f(1, this.sessionId) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.VdQ != null) {
                f2 += g.a.a.b.b.a.f(3, this.VdQ);
            }
            if (this.VdR != null) {
                f2 += g.a.a.b.b.a.f(4, this.VdR);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.VdS) + g.a.a.b.b.a.bu(6, this.VdT) + g.a.a.b.b.a.bu(7, this.VdU) + g.a.a.b.b.a.bu(8, this.VdV) + g.a.a.b.b.a.bu(9, this.VdW);
            AppMethodBeat.o(259507);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259507);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(259507);
                    return 0;
                case 2:
                    yVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(259507);
                    return 0;
                case 3:
                    yVar.VdQ = aVar3.UbS.readString();
                    AppMethodBeat.o(259507);
                    return 0;
                case 4:
                    yVar.VdR = aVar3.UbS.readString();
                    AppMethodBeat.o(259507);
                    return 0;
                case 5:
                    yVar.VdS = aVar3.UbS.zi();
                    AppMethodBeat.o(259507);
                    return 0;
                case 6:
                    yVar.VdT = aVar3.UbS.zi();
                    AppMethodBeat.o(259507);
                    return 0;
                case 7:
                    yVar.VdU = aVar3.UbS.zi();
                    AppMethodBeat.o(259507);
                    return 0;
                case 8:
                    yVar.VdV = aVar3.UbS.zi();
                    AppMethodBeat.o(259507);
                    return 0;
                case 9:
                    yVar.VdW = aVar3.UbS.zi();
                    AppMethodBeat.o(259507);
                    return 0;
                default:
                    AppMethodBeat.o(259507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259507);
            return -1;
        }
    }
}
