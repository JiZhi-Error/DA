package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class crq extends a {
    public String AbG;
    public long Jrc;
    public String MwC;
    public boolean MwD;
    public String MwE;
    public boolean MwF;
    public boolean MwG;
    public int MwH;
    public String lcm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208704);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwC != null) {
                aVar.e(1, this.MwC);
            }
            if (this.lcm != null) {
                aVar.e(2, this.lcm);
            }
            aVar.cc(3, this.MwD);
            if (this.MwE != null) {
                aVar.e(4, this.MwE);
            }
            if (this.AbG != null) {
                aVar.e(5, this.AbG);
            }
            aVar.cc(6, this.MwF);
            aVar.cc(7, this.MwG);
            aVar.aM(8, this.MwH);
            aVar.bb(9, this.Jrc);
            AppMethodBeat.o(208704);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwC != null ? g.a.a.b.b.a.f(1, this.MwC) + 0 : 0;
            if (this.lcm != null) {
                f2 += g.a.a.b.b.a.f(2, this.lcm);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1;
            if (this.MwE != null) {
                fS += g.a.a.b.b.a.f(4, this.MwE);
            }
            if (this.AbG != null) {
                fS += g.a.a.b.b.a.f(5, this.AbG);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.bu(8, this.MwH) + g.a.a.b.b.a.r(9, this.Jrc);
            AppMethodBeat.o(208704);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208704);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crq crq = (crq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crq.MwC = aVar3.UbS.readString();
                    AppMethodBeat.o(208704);
                    return 0;
                case 2:
                    crq.lcm = aVar3.UbS.readString();
                    AppMethodBeat.o(208704);
                    return 0;
                case 3:
                    crq.MwD = aVar3.UbS.yZ();
                    AppMethodBeat.o(208704);
                    return 0;
                case 4:
                    crq.MwE = aVar3.UbS.readString();
                    AppMethodBeat.o(208704);
                    return 0;
                case 5:
                    crq.AbG = aVar3.UbS.readString();
                    AppMethodBeat.o(208704);
                    return 0;
                case 6:
                    crq.MwF = aVar3.UbS.yZ();
                    AppMethodBeat.o(208704);
                    return 0;
                case 7:
                    crq.MwG = aVar3.UbS.yZ();
                    AppMethodBeat.o(208704);
                    return 0;
                case 8:
                    crq.MwH = aVar3.UbS.zi();
                    AppMethodBeat.o(208704);
                    return 0;
                case 9:
                    crq.Jrc = aVar3.UbS.zl();
                    AppMethodBeat.o(208704);
                    return 0;
                default:
                    AppMethodBeat.o(208704);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208704);
            return -1;
        }
    }
}
