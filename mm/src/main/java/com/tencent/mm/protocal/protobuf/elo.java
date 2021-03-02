package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class elo extends a {
    public String MXr;
    public int MXv;
    public String MXx;
    public String content;
    public int dDN;
    public int state;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153308);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MXx != null) {
                aVar.e(1, this.MXx);
            }
            aVar.aM(2, this.dDN);
            if (this.content != null) {
                aVar.e(3, this.content);
            }
            if (this.MXr != null) {
                aVar.e(4, this.MXr);
            }
            aVar.aM(5, this.MXv);
            aVar.aM(6, this.state);
            AppMethodBeat.o(153308);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MXx != null ? g.a.a.b.b.a.f(1, this.MXx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(3, this.content);
            }
            if (this.MXr != null) {
                f2 += g.a.a.b.b.a.f(4, this.MXr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MXv) + g.a.a.b.b.a.bu(6, this.state);
            AppMethodBeat.o(153308);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153308);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            elo elo = (elo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    elo.MXx = aVar3.UbS.readString();
                    AppMethodBeat.o(153308);
                    return 0;
                case 2:
                    elo.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(153308);
                    return 0;
                case 3:
                    elo.content = aVar3.UbS.readString();
                    AppMethodBeat.o(153308);
                    return 0;
                case 4:
                    elo.MXr = aVar3.UbS.readString();
                    AppMethodBeat.o(153308);
                    return 0;
                case 5:
                    elo.MXv = aVar3.UbS.zi();
                    AppMethodBeat.o(153308);
                    return 0;
                case 6:
                    elo.state = aVar3.UbS.zi();
                    AppMethodBeat.o(153308);
                    return 0;
                default:
                    AppMethodBeat.o(153308);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153308);
            return -1;
        }
    }
}
