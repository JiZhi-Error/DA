package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fat extends a {
    public String IEA;
    public String IEB;
    public long IEC;
    public String IED;
    public String IEE;
    public String IEF;
    public String IEG;
    public String IEH;
    public String IEI;
    public String IEJ;
    public long IEK;
    public String IEL;
    public String IEy;
    public String IEz;
    public String eby;
    public String msN;
    public String rCq;
    public String source;
    public String thumbUrl;
    public String xDQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153016);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.IEy != null) {
                aVar.e(1, this.IEy);
            }
            if (this.IEz != null) {
                aVar.e(2, this.IEz);
            }
            if (this.IEA != null) {
                aVar.e(3, this.IEA);
            }
            if (this.IEB != null) {
                aVar.e(4, this.IEB);
            }
            aVar.bb(5, this.IEC);
            if (this.IEG != null) {
                aVar.e(6, this.IEG);
            }
            if (this.rCq != null) {
                aVar.e(7, this.rCq);
            }
            if (this.msN != null) {
                aVar.e(8, this.msN);
            }
            if (this.xDQ != null) {
                aVar.e(9, this.xDQ);
            }
            if (this.IED != null) {
                aVar.e(10, this.IED);
            }
            if (this.IEE != null) {
                aVar.e(11, this.IEE);
            }
            if (this.IEF != null) {
                aVar.e(12, this.IEF);
            }
            if (this.source != null) {
                aVar.e(13, this.source);
            }
            if (this.eby != null) {
                aVar.e(14, this.eby);
            }
            if (this.IEH != null) {
                aVar.e(15, this.IEH);
            }
            if (this.IEI != null) {
                aVar.e(16, this.IEI);
            }
            if (this.IEJ != null) {
                aVar.e(17, this.IEJ);
            }
            aVar.bb(18, this.IEK);
            if (this.thumbUrl != null) {
                aVar.e(19, this.thumbUrl);
            }
            if (this.IEL != null) {
                aVar.e(20, this.IEL);
            }
            AppMethodBeat.o(153016);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.IEy != null ? g.a.a.b.b.a.f(1, this.IEy) + 0 : 0;
            if (this.IEz != null) {
                f2 += g.a.a.b.b.a.f(2, this.IEz);
            }
            if (this.IEA != null) {
                f2 += g.a.a.b.b.a.f(3, this.IEA);
            }
            if (this.IEB != null) {
                f2 += g.a.a.b.b.a.f(4, this.IEB);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.IEC);
            if (this.IEG != null) {
                r += g.a.a.b.b.a.f(6, this.IEG);
            }
            if (this.rCq != null) {
                r += g.a.a.b.b.a.f(7, this.rCq);
            }
            if (this.msN != null) {
                r += g.a.a.b.b.a.f(8, this.msN);
            }
            if (this.xDQ != null) {
                r += g.a.a.b.b.a.f(9, this.xDQ);
            }
            if (this.IED != null) {
                r += g.a.a.b.b.a.f(10, this.IED);
            }
            if (this.IEE != null) {
                r += g.a.a.b.b.a.f(11, this.IEE);
            }
            if (this.IEF != null) {
                r += g.a.a.b.b.a.f(12, this.IEF);
            }
            if (this.source != null) {
                r += g.a.a.b.b.a.f(13, this.source);
            }
            if (this.eby != null) {
                r += g.a.a.b.b.a.f(14, this.eby);
            }
            if (this.IEH != null) {
                r += g.a.a.b.b.a.f(15, this.IEH);
            }
            if (this.IEI != null) {
                r += g.a.a.b.b.a.f(16, this.IEI);
            }
            if (this.IEJ != null) {
                r += g.a.a.b.b.a.f(17, this.IEJ);
            }
            int r2 = r + g.a.a.b.b.a.r(18, this.IEK);
            if (this.thumbUrl != null) {
                r2 += g.a.a.b.b.a.f(19, this.thumbUrl);
            }
            if (this.IEL != null) {
                r2 += g.a.a.b.b.a.f(20, this.IEL);
            }
            AppMethodBeat.o(153016);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153016);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fat fat = (fat) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fat.IEy = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 2:
                    fat.IEz = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 3:
                    fat.IEA = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 4:
                    fat.IEB = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 5:
                    fat.IEC = aVar3.UbS.zl();
                    AppMethodBeat.o(153016);
                    return 0;
                case 6:
                    fat.IEG = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 7:
                    fat.rCq = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 8:
                    fat.msN = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 9:
                    fat.xDQ = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 10:
                    fat.IED = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 11:
                    fat.IEE = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 12:
                    fat.IEF = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 13:
                    fat.source = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 14:
                    fat.eby = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 15:
                    fat.IEH = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 16:
                    fat.IEI = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 17:
                    fat.IEJ = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 18:
                    fat.IEK = aVar3.UbS.zl();
                    AppMethodBeat.o(153016);
                    return 0;
                case 19:
                    fat.thumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                case 20:
                    fat.IEL = aVar3.UbS.readString();
                    AppMethodBeat.o(153016);
                    return 0;
                default:
                    AppMethodBeat.o(153016);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153016);
            return -1;
        }
    }
}
