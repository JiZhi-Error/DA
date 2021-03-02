package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pj extends a {
    public int KHa;
    public String KQY;
    public LinkedList<String> KWr = new LinkedList<>();
    public int KWs;
    public String KWx;
    public LinkedList<pi> KWy = new LinkedList<>();
    public String UserName;
    public String keb;
    public String oUJ;
    public String xLi;

    public pj() {
        AppMethodBeat.i(212252);
        AppMethodBeat.o(212252);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212253);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KHa);
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            if (this.xLi != null) {
                aVar.e(4, this.xLi);
            }
            if (this.keb != null) {
                aVar.e(5, this.keb);
            }
            if (this.KQY != null) {
                aVar.e(6, this.KQY);
            }
            if (this.KWx != null) {
                aVar.e(7, this.KWx);
            }
            aVar.e(8, 8, this.KWy);
            aVar.e(9, 1, this.KWr);
            aVar.aM(10, this.KWs);
            AppMethodBeat.o(212253);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KHa) + 0;
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.xLi != null) {
                bu += g.a.a.b.b.a.f(4, this.xLi);
            }
            if (this.keb != null) {
                bu += g.a.a.b.b.a.f(5, this.keb);
            }
            if (this.KQY != null) {
                bu += g.a.a.b.b.a.f(6, this.KQY);
            }
            if (this.KWx != null) {
                bu += g.a.a.b.b.a.f(7, this.KWx);
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.KWy) + g.a.a.a.c(9, 1, this.KWr) + g.a.a.b.b.a.bu(10, this.KWs);
            AppMethodBeat.o(212253);
            return c2;
        } else if (i2 == 2) {
            this.KWy.clear();
            this.KWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212253);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pj pjVar = (pj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pjVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(212253);
                    return 0;
                case 2:
                    pjVar.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 3:
                    pjVar.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 4:
                    pjVar.xLi = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 5:
                    pjVar.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 6:
                    pjVar.KQY = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 7:
                    pjVar.KWx = aVar3.UbS.readString();
                    AppMethodBeat.o(212253);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pi piVar = new pi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = piVar.populateBuilderWithField(aVar4, piVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pjVar.KWy.add(piVar);
                    }
                    AppMethodBeat.o(212253);
                    return 0;
                case 9:
                    pjVar.KWr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212253);
                    return 0;
                case 10:
                    pjVar.KWs = aVar3.UbS.zi();
                    AppMethodBeat.o(212253);
                    return 0;
                default:
                    AppMethodBeat.o(212253);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212253);
            return -1;
        }
    }
}
