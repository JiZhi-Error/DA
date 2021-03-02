package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dbe extends a {
    public String AOT;
    public String AOV;
    public String AOW;
    public int AOX;
    public String AOY;
    public int AOZ;
    public int APa;
    public String APc;
    public String APd;
    public String APe;
    public String APf;
    public int CreateTime;
    public int MFR;
    public String MGf;
    public String MGg;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91612);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.AOT != null) {
                aVar.e(1, this.AOT);
            }
            aVar.aM(2, this.MFR);
            if (this.AOV != null) {
                aVar.e(3, this.AOV);
            }
            aVar.aM(4, this.CreateTime);
            if (this.AOW != null) {
                aVar.e(5, this.AOW);
            }
            aVar.aM(6, this.AOX);
            if (this.AOY != null) {
                aVar.e(7, this.AOY);
            }
            aVar.aM(8, this.AOZ);
            aVar.aM(9, this.APa);
            if (this.xMq != null) {
                aVar.e(11, this.xMq);
            }
            if (this.APc != null) {
                aVar.e(12, this.APc);
            }
            if (this.APd != null) {
                aVar.e(13, this.APd);
            }
            if (this.APe != null) {
                aVar.e(14, this.APe);
            }
            if (this.APf != null) {
                aVar.e(15, this.APf);
            }
            if (this.MGf != null) {
                aVar.e(18, this.MGf);
            }
            if (this.MGg != null) {
                aVar.e(19, this.MGg);
            }
            AppMethodBeat.o(91612);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.AOT != null ? g.a.a.b.b.a.f(1, this.AOT) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MFR);
            if (this.AOV != null) {
                f2 += g.a.a.b.b.a.f(3, this.AOV);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.CreateTime);
            if (this.AOW != null) {
                bu += g.a.a.b.b.a.f(5, this.AOW);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.AOX);
            if (this.AOY != null) {
                bu2 += g.a.a.b.b.a.f(7, this.AOY);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.AOZ) + g.a.a.b.b.a.bu(9, this.APa);
            if (this.xMq != null) {
                bu3 += g.a.a.b.b.a.f(11, this.xMq);
            }
            if (this.APc != null) {
                bu3 += g.a.a.b.b.a.f(12, this.APc);
            }
            if (this.APd != null) {
                bu3 += g.a.a.b.b.a.f(13, this.APd);
            }
            if (this.APe != null) {
                bu3 += g.a.a.b.b.a.f(14, this.APe);
            }
            if (this.APf != null) {
                bu3 += g.a.a.b.b.a.f(15, this.APf);
            }
            if (this.MGf != null) {
                bu3 += g.a.a.b.b.a.f(18, this.MGf);
            }
            if (this.MGg != null) {
                bu3 += g.a.a.b.b.a.f(19, this.MGg);
            }
            AppMethodBeat.o(91612);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91612);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dbe dbe = (dbe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dbe.AOT = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 2:
                    dbe.MFR = aVar3.UbS.zi();
                    AppMethodBeat.o(91612);
                    return 0;
                case 3:
                    dbe.AOV = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 4:
                    dbe.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(91612);
                    return 0;
                case 5:
                    dbe.AOW = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 6:
                    dbe.AOX = aVar3.UbS.zi();
                    AppMethodBeat.o(91612);
                    return 0;
                case 7:
                    dbe.AOY = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 8:
                    dbe.AOZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91612);
                    return 0;
                case 9:
                    dbe.APa = aVar3.UbS.zi();
                    AppMethodBeat.o(91612);
                    return 0;
                case 10:
                case 16:
                case 17:
                default:
                    AppMethodBeat.o(91612);
                    return -1;
                case 11:
                    dbe.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 12:
                    dbe.APc = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 13:
                    dbe.APd = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 14:
                    dbe.APe = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 15:
                    dbe.APf = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 18:
                    dbe.MGf = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
                case 19:
                    dbe.MGg = aVar3.UbS.readString();
                    AppMethodBeat.o(91612);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91612);
            return -1;
        }
    }
}
