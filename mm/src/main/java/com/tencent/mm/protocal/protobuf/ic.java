package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ic extends a {
    public String KLZ;
    public String KMa;
    public int KMb;
    public long KMc;
    public int KMd;
    public long KMe;
    public long KMf;
    public long KMi;
    public double KMj;
    public int KMk;
    public long KMm;
    public int KMn;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(87873);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KMm);
            if (this.KLZ != null) {
                aVar.e(2, this.KLZ);
            }
            if (this.KMa != null) {
                aVar.e(3, this.KMa);
            }
            aVar.aM(4, this.KMb);
            aVar.bb(5, this.KMc);
            aVar.aM(6, this.KMd);
            aVar.aM(7, this.oTW);
            aVar.bb(8, this.KMe);
            aVar.bb(9, this.KMf);
            aVar.aM(10, this.KMn);
            aVar.bb(11, this.KMi);
            aVar.e(12, this.KMj);
            aVar.aM(13, this.KMk);
            AppMethodBeat.o(87873);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KMm) + 0;
            if (this.KLZ != null) {
                r += g.a.a.b.b.a.f(2, this.KLZ);
            }
            if (this.KMa != null) {
                r += g.a.a.b.b.a.f(3, this.KMa);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.KMb) + g.a.a.b.b.a.r(5, this.KMc) + g.a.a.b.b.a.bu(6, this.KMd) + g.a.a.b.b.a.bu(7, this.oTW) + g.a.a.b.b.a.r(8, this.KMe) + g.a.a.b.b.a.r(9, this.KMf) + g.a.a.b.b.a.bu(10, this.KMn) + g.a.a.b.b.a.r(11, this.KMi) + g.a.a.b.b.a.fS(12) + 8 + g.a.a.b.b.a.bu(13, this.KMk);
            AppMethodBeat.o(87873);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(87873);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ic icVar = (ic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    icVar.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(87873);
                    return 0;
                case 2:
                    icVar.KLZ = aVar3.UbS.readString();
                    AppMethodBeat.o(87873);
                    return 0;
                case 3:
                    icVar.KMa = aVar3.UbS.readString();
                    AppMethodBeat.o(87873);
                    return 0;
                case 4:
                    icVar.KMb = aVar3.UbS.zi();
                    AppMethodBeat.o(87873);
                    return 0;
                case 5:
                    icVar.KMc = aVar3.UbS.zl();
                    AppMethodBeat.o(87873);
                    return 0;
                case 6:
                    icVar.KMd = aVar3.UbS.zi();
                    AppMethodBeat.o(87873);
                    return 0;
                case 7:
                    icVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(87873);
                    return 0;
                case 8:
                    icVar.KMe = aVar3.UbS.zl();
                    AppMethodBeat.o(87873);
                    return 0;
                case 9:
                    icVar.KMf = aVar3.UbS.zl();
                    AppMethodBeat.o(87873);
                    return 0;
                case 10:
                    icVar.KMn = aVar3.UbS.zi();
                    AppMethodBeat.o(87873);
                    return 0;
                case 11:
                    icVar.KMi = aVar3.UbS.zl();
                    AppMethodBeat.o(87873);
                    return 0;
                case 12:
                    icVar.KMj = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87873);
                    return 0;
                case 13:
                    icVar.KMk = aVar3.UbS.zi();
                    AppMethodBeat.o(87873);
                    return 0;
                default:
                    AppMethodBeat.o(87873);
                    return -1;
            }
        } else {
            AppMethodBeat.o(87873);
            return -1;
        }
    }
}
