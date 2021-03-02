package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class awt extends a {
    public String LHv;
    public int LHw;
    public int LHx;
    public String coverImgUrl;
    public String dDJ;
    public int dvv;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209545);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dvv);
            aVar.aM(2, this.status);
            if (this.coverImgUrl != null) {
                aVar.e(3, this.coverImgUrl);
            }
            if (this.LHv != null) {
                aVar.e(4, this.LHv);
            }
            if (this.dDJ != null) {
                aVar.e(5, this.dDJ);
            }
            aVar.aM(6, this.LHw);
            aVar.aM(7, this.LHx);
            AppMethodBeat.o(209545);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dvv) + 0 + g.a.a.b.b.a.bu(2, this.status);
            if (this.coverImgUrl != null) {
                bu += g.a.a.b.b.a.f(3, this.coverImgUrl);
            }
            if (this.LHv != null) {
                bu += g.a.a.b.b.a.f(4, this.LHv);
            }
            if (this.dDJ != null) {
                bu += g.a.a.b.b.a.f(5, this.dDJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LHw) + g.a.a.b.b.a.bu(7, this.LHx);
            AppMethodBeat.o(209545);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209545);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awt awt = (awt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awt.dvv = aVar3.UbS.zi();
                    AppMethodBeat.o(209545);
                    return 0;
                case 2:
                    awt.status = aVar3.UbS.zi();
                    AppMethodBeat.o(209545);
                    return 0;
                case 3:
                    awt.coverImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209545);
                    return 0;
                case 4:
                    awt.LHv = aVar3.UbS.readString();
                    AppMethodBeat.o(209545);
                    return 0;
                case 5:
                    awt.dDJ = aVar3.UbS.readString();
                    AppMethodBeat.o(209545);
                    return 0;
                case 6:
                    awt.LHw = aVar3.UbS.zi();
                    AppMethodBeat.o(209545);
                    return 0;
                case 7:
                    awt.LHx = aVar3.UbS.zi();
                    AppMethodBeat.o(209545);
                    return 0;
                default:
                    AppMethodBeat.o(209545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209545);
            return -1;
        }
    }
}
