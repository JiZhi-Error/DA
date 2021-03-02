package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cix extends a {
    public String MnR;
    public int MnS;
    public String content;
    public String gzC;
    public int ybm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207502);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MnR != null) {
                aVar.e(1, this.MnR);
            }
            if (this.gzC != null) {
                aVar.e(2, this.gzC);
            }
            aVar.aM(3, this.ybm);
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.aM(5, this.MnS);
            AppMethodBeat.o(207502);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MnR != null ? g.a.a.b.b.a.f(1, this.MnR) + 0 : 0;
            if (this.gzC != null) {
                f2 += g.a.a.b.b.a.f(2, this.gzC);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.ybm);
            if (this.content != null) {
                bu += g.a.a.b.b.a.f(4, this.content);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MnS);
            AppMethodBeat.o(207502);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207502);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cix cix = (cix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cix.MnR = aVar3.UbS.readString();
                    AppMethodBeat.o(207502);
                    return 0;
                case 2:
                    cix.gzC = aVar3.UbS.readString();
                    AppMethodBeat.o(207502);
                    return 0;
                case 3:
                    cix.ybm = aVar3.UbS.zi();
                    AppMethodBeat.o(207502);
                    return 0;
                case 4:
                    cix.content = aVar3.UbS.readString();
                    AppMethodBeat.o(207502);
                    return 0;
                case 5:
                    cix.MnS = aVar3.UbS.zi();
                    AppMethodBeat.o(207502);
                    return 0;
                default:
                    AppMethodBeat.o(207502);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207502);
            return -1;
        }
    }
}
