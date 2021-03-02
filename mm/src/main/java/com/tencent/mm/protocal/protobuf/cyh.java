package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cyh extends a {
    public boolean MDe = false;
    public String MDf;
    public boolean MDg;
    public int aHK = 0;
    public String dMl = "";
    public String dRM = "";
    public int dRq = -1;
    public long endTime = 0;
    public String kvy = "";
    public long seq = 0;
    public long startTime = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122521);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dRM != null) {
                aVar.e(1, this.dRM);
            }
            aVar.cc(2, this.MDe);
            aVar.bb(3, this.seq);
            aVar.bb(4, this.startTime);
            aVar.bb(5, this.endTime);
            aVar.aM(6, this.dRq);
            if (this.dMl != null) {
                aVar.e(7, this.dMl);
            }
            aVar.aM(8, this.aHK);
            if (this.MDf != null) {
                aVar.e(9, this.MDf);
            }
            aVar.cc(10, this.MDg);
            if (this.kvy != null) {
                aVar.e(11, this.kvy);
            }
            AppMethodBeat.o(122521);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dRM != null ? g.a.a.b.b.a.f(1, this.dRM) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.r(3, this.seq) + g.a.a.b.b.a.r(4, this.startTime) + g.a.a.b.b.a.r(5, this.endTime) + g.a.a.b.b.a.bu(6, this.dRq);
            if (this.dMl != null) {
                f2 += g.a.a.b.b.a.f(7, this.dMl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.aHK);
            if (this.MDf != null) {
                bu += g.a.a.b.b.a.f(9, this.MDf);
            }
            int fS = bu + g.a.a.b.b.a.fS(10) + 1;
            if (this.kvy != null) {
                fS += g.a.a.b.b.a.f(11, this.kvy);
            }
            AppMethodBeat.o(122521);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122521);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyh cyh = (cyh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyh.dRM = aVar3.UbS.readString();
                    AppMethodBeat.o(122521);
                    return 0;
                case 2:
                    cyh.MDe = aVar3.UbS.yZ();
                    AppMethodBeat.o(122521);
                    return 0;
                case 3:
                    cyh.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(122521);
                    return 0;
                case 4:
                    cyh.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122521);
                    return 0;
                case 5:
                    cyh.endTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122521);
                    return 0;
                case 6:
                    cyh.dRq = aVar3.UbS.zi();
                    AppMethodBeat.o(122521);
                    return 0;
                case 7:
                    cyh.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(122521);
                    return 0;
                case 8:
                    cyh.aHK = aVar3.UbS.zi();
                    AppMethodBeat.o(122521);
                    return 0;
                case 9:
                    cyh.MDf = aVar3.UbS.readString();
                    AppMethodBeat.o(122521);
                    return 0;
                case 10:
                    cyh.MDg = aVar3.UbS.yZ();
                    AppMethodBeat.o(122521);
                    return 0;
                case 11:
                    cyh.kvy = aVar3.UbS.readString();
                    AppMethodBeat.o(122521);
                    return 0;
                default:
                    AppMethodBeat.o(122521);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122521);
            return -1;
        }
    }
}
