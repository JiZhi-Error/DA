package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cym extends a {
    public LinkedList<Long> MDv = new LinkedList<>();
    public int aHK = 0;
    public String dMl;
    public int dYn = 0;
    public String extraInfo;
    public long sGB = 0;
    public long sGC = 0;
    public long sGD = 0;
    public String sGE;
    public String sGF;
    public String sGH;
    public String sessionId;

    public cym() {
        AppMethodBeat.i(220715);
        AppMethodBeat.o(220715);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220716);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sessionId != null) {
                aVar.e(1, this.sessionId);
            }
            if (this.dMl != null) {
                aVar.e(2, this.dMl);
            }
            aVar.aM(3, this.aHK);
            aVar.bb(4, this.sGB);
            aVar.bb(5, this.sGC);
            aVar.bb(6, this.sGD);
            if (this.sGE != null) {
                aVar.e(7, this.sGE);
            }
            if (this.sGF != null) {
                aVar.e(8, this.sGF);
            }
            aVar.aM(9, this.dYn);
            aVar.e(10, 3, this.MDv);
            if (this.extraInfo != null) {
                aVar.e(11, this.extraInfo);
            }
            if (this.sGH != null) {
                aVar.e(12, this.sGH);
            }
            AppMethodBeat.o(220716);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sessionId != null ? g.a.a.b.b.a.f(1, this.sessionId) + 0 : 0;
            if (this.dMl != null) {
                f2 += g.a.a.b.b.a.f(2, this.dMl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.aHK) + g.a.a.b.b.a.r(4, this.sGB) + g.a.a.b.b.a.r(5, this.sGC) + g.a.a.b.b.a.r(6, this.sGD);
            if (this.sGE != null) {
                bu += g.a.a.b.b.a.f(7, this.sGE);
            }
            if (this.sGF != null) {
                bu += g.a.a.b.b.a.f(8, this.sGF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.dYn) + g.a.a.a.c(10, 3, this.MDv);
            if (this.extraInfo != null) {
                bu2 += g.a.a.b.b.a.f(11, this.extraInfo);
            }
            if (this.sGH != null) {
                bu2 += g.a.a.b.b.a.f(12, this.sGH);
            }
            AppMethodBeat.o(220716);
            return bu2;
        } else if (i2 == 2) {
            this.MDv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cym cym = (cym) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cym.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                case 2:
                    cym.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                case 3:
                    cym.aHK = aVar3.UbS.zi();
                    AppMethodBeat.o(220716);
                    return 0;
                case 4:
                    cym.sGB = aVar3.UbS.zl();
                    AppMethodBeat.o(220716);
                    return 0;
                case 5:
                    cym.sGC = aVar3.UbS.zl();
                    AppMethodBeat.o(220716);
                    return 0;
                case 6:
                    cym.sGD = aVar3.UbS.zl();
                    AppMethodBeat.o(220716);
                    return 0;
                case 7:
                    cym.sGE = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                case 8:
                    cym.sGF = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                case 9:
                    cym.dYn = aVar3.UbS.zi();
                    AppMethodBeat.o(220716);
                    return 0;
                case 10:
                    cym.MDv.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(220716);
                    return 0;
                case 11:
                    cym.extraInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                case 12:
                    cym.sGH = aVar3.UbS.readString();
                    AppMethodBeat.o(220716);
                    return 0;
                default:
                    AppMethodBeat.o(220716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220716);
            return -1;
        }
    }
}
