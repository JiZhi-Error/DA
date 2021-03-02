package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bbn extends a {
    public int dLS;
    public String extraInfo;
    public String sGE;
    public String sGH;
    public String sGQ;
    public String sessionId;
    public int tCE;
    public int tyh;
    public int uCt;
    public long wyW;
    public String wyX;
    public int wyY;
    public int wyZ;
    public String wza;
    public boolean wzb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209654);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sessionId != null) {
                aVar.e(1, this.sessionId);
            }
            if (this.sGQ != null) {
                aVar.e(2, this.sGQ);
            }
            if (this.sGE != null) {
                aVar.e(3, this.sGE);
            }
            if (this.wyX != null) {
                aVar.e(4, this.wyX);
            }
            aVar.aM(5, this.uCt);
            aVar.aM(6, this.tCE);
            aVar.bb(7, this.wyW);
            aVar.aM(8, this.tyh);
            aVar.aM(9, this.wyY);
            if (this.wza != null) {
                aVar.e(10, this.wza);
            }
            aVar.aM(11, this.wyZ);
            if (this.extraInfo != null) {
                aVar.e(12, this.extraInfo);
            }
            if (this.sGH != null) {
                aVar.e(13, this.sGH);
            }
            aVar.cc(14, this.wzb);
            aVar.aM(15, this.dLS);
            AppMethodBeat.o(209654);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sessionId != null ? g.a.a.b.b.a.f(1, this.sessionId) + 0 : 0;
            if (this.sGQ != null) {
                f2 += g.a.a.b.b.a.f(2, this.sGQ);
            }
            if (this.sGE != null) {
                f2 += g.a.a.b.b.a.f(3, this.sGE);
            }
            if (this.wyX != null) {
                f2 += g.a.a.b.b.a.f(4, this.wyX);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.uCt) + g.a.a.b.b.a.bu(6, this.tCE) + g.a.a.b.b.a.r(7, this.wyW) + g.a.a.b.b.a.bu(8, this.tyh) + g.a.a.b.b.a.bu(9, this.wyY);
            if (this.wza != null) {
                bu += g.a.a.b.b.a.f(10, this.wza);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.wyZ);
            if (this.extraInfo != null) {
                bu2 += g.a.a.b.b.a.f(12, this.extraInfo);
            }
            if (this.sGH != null) {
                bu2 += g.a.a.b.b.a.f(13, this.sGH);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(14) + 1 + g.a.a.b.b.a.bu(15, this.dLS);
            AppMethodBeat.o(209654);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209654);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbn bbn = (bbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbn.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 2:
                    bbn.sGQ = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 3:
                    bbn.sGE = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 4:
                    bbn.wyX = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 5:
                    bbn.uCt = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                case 6:
                    bbn.tCE = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                case 7:
                    bbn.wyW = aVar3.UbS.zl();
                    AppMethodBeat.o(209654);
                    return 0;
                case 8:
                    bbn.tyh = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                case 9:
                    bbn.wyY = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                case 10:
                    bbn.wza = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 11:
                    bbn.wyZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                case 12:
                    bbn.extraInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 13:
                    bbn.sGH = aVar3.UbS.readString();
                    AppMethodBeat.o(209654);
                    return 0;
                case 14:
                    bbn.wzb = aVar3.UbS.yZ();
                    AppMethodBeat.o(209654);
                    return 0;
                case 15:
                    bbn.dLS = aVar3.UbS.zi();
                    AppMethodBeat.o(209654);
                    return 0;
                default:
                    AppMethodBeat.o(209654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209654);
            return -1;
        }
    }
}
