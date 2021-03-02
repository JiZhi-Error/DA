package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czu extends a {
    public long KEC;
    public String KED;
    public String KEE;
    public String KEF;
    public String KEG;
    public String fuJ;
    public String fuK;
    public double latitude;
    public double longitude;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152660);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.fuJ != null) {
                aVar.e(1, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(2, this.fuK);
            }
            aVar.e(3, this.latitude);
            aVar.e(4, this.longitude);
            aVar.bb(5, this.KEC);
            if (this.KED != null) {
                aVar.e(6, this.KED);
            }
            if (this.KEE != null) {
                aVar.e(7, this.KEE);
            }
            if (this.KEF != null) {
                aVar.e(8, this.KEF);
            }
            if (this.KEG != null) {
                aVar.e(9, this.KEG);
            }
            AppMethodBeat.o(152660);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.fuJ != null ? g.a.a.b.b.a.f(1, this.fuJ) + 0 : 0;
            if (this.fuK != null) {
                f2 += g.a.a.b.b.a.f(2, this.fuK);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.fS(4) + 8 + g.a.a.b.b.a.r(5, this.KEC);
            if (this.KED != null) {
                fS += g.a.a.b.b.a.f(6, this.KED);
            }
            if (this.KEE != null) {
                fS += g.a.a.b.b.a.f(7, this.KEE);
            }
            if (this.KEF != null) {
                fS += g.a.a.b.b.a.f(8, this.KEF);
            }
            if (this.KEG != null) {
                fS += g.a.a.b.b.a.f(9, this.KEG);
            }
            AppMethodBeat.o(152660);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152660);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czu czu = (czu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czu.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                case 2:
                    czu.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                case 3:
                    czu.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(152660);
                    return 0;
                case 4:
                    czu.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(152660);
                    return 0;
                case 5:
                    czu.KEC = aVar3.UbS.zl();
                    AppMethodBeat.o(152660);
                    return 0;
                case 6:
                    czu.KED = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                case 7:
                    czu.KEE = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                case 8:
                    czu.KEF = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                case 9:
                    czu.KEG = aVar3.UbS.readString();
                    AppMethodBeat.o(152660);
                    return 0;
                default:
                    AppMethodBeat.o(152660);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152660);
            return -1;
        }
    }
}
