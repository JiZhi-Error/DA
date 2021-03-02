package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class i extends a {
    public String AOT;
    public double AOU;
    public String AOV;
    public String AOW;
    public int AOX;
    public String AOY;
    public int AOZ;
    public int APa;
    public String APb;
    public String APc;
    public String APd;
    public String APe;
    public String APf;
    public int APg;
    public LinkedList<k> APh = new LinkedList<>();
    public String APi;
    public String APj;
    public double APk;
    public String APl;
    public int CreateTime;
    public String xMq;

    public i() {
        AppMethodBeat.i(91261);
        AppMethodBeat.o(91261);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91262);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.AOT != null) {
                aVar.e(1, this.AOT);
            }
            aVar.e(2, this.AOU);
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
            if (this.APb != null) {
                aVar.e(10, this.APb);
            }
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
            aVar.aM(16, this.APg);
            aVar.e(17, 8, this.APh);
            if (this.APi != null) {
                aVar.e(18, this.APi);
            }
            if (this.APj != null) {
                aVar.e(19, this.APj);
            }
            aVar.e(20, this.APk);
            if (this.APl != null) {
                aVar.e(21, this.APl);
            }
            AppMethodBeat.o(91262);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.AOT != null ? g.a.a.b.b.a.f(1, this.AOT) + 0 : 0) + g.a.a.b.b.a.fS(2) + 8;
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
            if (this.APb != null) {
                bu3 += g.a.a.b.b.a.f(10, this.APb);
            }
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
            int bu4 = bu3 + g.a.a.b.b.a.bu(16, this.APg) + g.a.a.a.c(17, 8, this.APh);
            if (this.APi != null) {
                bu4 += g.a.a.b.b.a.f(18, this.APi);
            }
            if (this.APj != null) {
                bu4 += g.a.a.b.b.a.f(19, this.APj);
            }
            int fS = bu4 + g.a.a.b.b.a.fS(20) + 8;
            if (this.APl != null) {
                fS += g.a.a.b.b.a.f(21, this.APl);
            }
            AppMethodBeat.o(91262);
            return fS;
        } else if (i2 == 2) {
            this.APh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91262);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.AOT = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 2:
                    iVar.AOU = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91262);
                    return 0;
                case 3:
                    iVar.AOV = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 4:
                    iVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(91262);
                    return 0;
                case 5:
                    iVar.AOW = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 6:
                    iVar.AOX = aVar3.UbS.zi();
                    AppMethodBeat.o(91262);
                    return 0;
                case 7:
                    iVar.AOY = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 8:
                    iVar.AOZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91262);
                    return 0;
                case 9:
                    iVar.APa = aVar3.UbS.zi();
                    AppMethodBeat.o(91262);
                    return 0;
                case 10:
                    iVar.APb = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 11:
                    iVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 12:
                    iVar.APc = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 13:
                    iVar.APd = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 14:
                    iVar.APe = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 15:
                    iVar.APf = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 16:
                    iVar.APg = aVar3.UbS.zi();
                    AppMethodBeat.o(91262);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        k kVar = new k();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.APh.add(kVar);
                    }
                    AppMethodBeat.o(91262);
                    return 0;
                case 18:
                    iVar.APi = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 19:
                    iVar.APj = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                case 20:
                    iVar.APk = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91262);
                    return 0;
                case 21:
                    iVar.APl = aVar3.UbS.readString();
                    AppMethodBeat.o(91262);
                    return 0;
                default:
                    AppMethodBeat.o(91262);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91262);
            return -1;
        }
    }
}
