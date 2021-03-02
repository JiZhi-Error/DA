package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ad extends a {
    public boolean UXA;
    public String userName;
    public String yVk;
    public String yWD;
    public String yWE;
    public String yWF;
    public String yWG;
    public String yWH;
    public String yWI;
    public long yWo;
    public String yWp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91258);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.yWD != null) {
                aVar.e(1, this.yWD);
            }
            if (this.yWE != null) {
                aVar.e(2, this.yWE);
            }
            aVar.bb(3, this.yWo);
            if (this.yWp != null) {
                aVar.e(4, this.yWp);
            }
            if (this.yWF != null) {
                aVar.e(5, this.yWF);
            }
            if (this.yVk != null) {
                aVar.e(6, this.yVk);
            }
            if (this.yWG != null) {
                aVar.e(7, this.yWG);
            }
            if (this.userName != null) {
                aVar.e(8, this.userName);
            }
            if (this.yWH != null) {
                aVar.e(9, this.yWH);
            }
            if (this.yWI != null) {
                aVar.e(10, this.yWI);
            }
            aVar.cc(11, this.UXA);
            AppMethodBeat.o(91258);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.yWD != null ? g.a.a.b.b.a.f(1, this.yWD) + 0 : 0;
            if (this.yWE != null) {
                f2 += g.a.a.b.b.a.f(2, this.yWE);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.yWo);
            if (this.yWp != null) {
                r += g.a.a.b.b.a.f(4, this.yWp);
            }
            if (this.yWF != null) {
                r += g.a.a.b.b.a.f(5, this.yWF);
            }
            if (this.yVk != null) {
                r += g.a.a.b.b.a.f(6, this.yVk);
            }
            if (this.yWG != null) {
                r += g.a.a.b.b.a.f(7, this.yWG);
            }
            if (this.userName != null) {
                r += g.a.a.b.b.a.f(8, this.userName);
            }
            if (this.yWH != null) {
                r += g.a.a.b.b.a.f(9, this.yWH);
            }
            if (this.yWI != null) {
                r += g.a.a.b.b.a.f(10, this.yWI);
            }
            int fS = r + g.a.a.b.b.a.fS(11) + 1;
            AppMethodBeat.o(91258);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91258);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adVar.yWD = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 2:
                    adVar.yWE = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 3:
                    adVar.yWo = aVar3.UbS.zl();
                    AppMethodBeat.o(91258);
                    return 0;
                case 4:
                    adVar.yWp = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 5:
                    adVar.yWF = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 6:
                    adVar.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 7:
                    adVar.yWG = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 8:
                    adVar.userName = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 9:
                    adVar.yWH = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 10:
                    adVar.yWI = aVar3.UbS.readString();
                    AppMethodBeat.o(91258);
                    return 0;
                case 11:
                    adVar.UXA = aVar3.UbS.yZ();
                    AppMethodBeat.o(91258);
                    return 0;
                default:
                    AppMethodBeat.o(91258);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91258);
            return -1;
        }
    }
}
