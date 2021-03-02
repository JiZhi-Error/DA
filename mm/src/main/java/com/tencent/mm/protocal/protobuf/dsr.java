package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dsr extends a {
    public int MJT;
    public String MUT;
    public b MUU;
    public String Mba;
    public String Mbb;
    public String SessionId;
    public int xMB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187884);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.SessionId != null) {
                aVar.e(1, this.SessionId);
            }
            if (this.Mbb != null) {
                aVar.e(2, this.Mbb);
            }
            if (this.Mba != null) {
                aVar.e(3, this.Mba);
            }
            aVar.aM(4, this.xMB);
            aVar.aM(5, this.MJT);
            if (this.MUT != null) {
                aVar.e(6, this.MUT);
            }
            if (this.MUU != null) {
                aVar.c(7, this.MUU);
            }
            AppMethodBeat.o(187884);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.SessionId != null ? g.a.a.b.b.a.f(1, this.SessionId) + 0 : 0;
            if (this.Mbb != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mbb);
            }
            if (this.Mba != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mba);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.xMB) + g.a.a.b.b.a.bu(5, this.MJT);
            if (this.MUT != null) {
                bu += g.a.a.b.b.a.f(6, this.MUT);
            }
            if (this.MUU != null) {
                bu += g.a.a.b.b.a.b(7, this.MUU);
            }
            AppMethodBeat.o(187884);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187884);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsr dsr = (dsr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsr.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(187884);
                    return 0;
                case 2:
                    dsr.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(187884);
                    return 0;
                case 3:
                    dsr.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(187884);
                    return 0;
                case 4:
                    dsr.xMB = aVar3.UbS.zi();
                    AppMethodBeat.o(187884);
                    return 0;
                case 5:
                    dsr.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(187884);
                    return 0;
                case 6:
                    dsr.MUT = aVar3.UbS.readString();
                    AppMethodBeat.o(187884);
                    return 0;
                case 7:
                    dsr.MUU = aVar3.UbS.hPo();
                    AppMethodBeat.o(187884);
                    return 0;
                default:
                    AppMethodBeat.o(187884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187884);
            return -1;
        }
    }
}
