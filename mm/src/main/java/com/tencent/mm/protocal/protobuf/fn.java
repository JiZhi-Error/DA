package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class fn extends a {
    public int Brl;
    public int KIQ = 600;
    public String KIR;
    public int KIS;
    public boolean KIT;
    public int KIU;
    public int KIV;
    public int KIW;
    public int KIX;
    public boolean KIY = false;
    public LinkedList<eib> KIZ = new LinkedList<>();
    public String Url;
    public int iAb = -1;
    public String iAc;

    public fn() {
        AppMethodBeat.i(6388);
        AppMethodBeat.o(6388);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6389);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            if (this.iAc != null) {
                aVar.e(2, this.iAc);
            }
            aVar.aM(3, this.KIQ);
            if (this.KIR != null) {
                aVar.e(4, this.KIR);
            }
            aVar.aM(5, this.KIS);
            aVar.cc(6, this.KIT);
            aVar.aM(7, this.KIU);
            aVar.aM(8, this.KIV);
            aVar.aM(9, this.Brl);
            aVar.aM(10, this.KIW);
            aVar.aM(11, this.KIX);
            aVar.aM(12, this.iAb);
            aVar.cc(13, this.KIY);
            aVar.e(14, 8, this.KIZ);
            AppMethodBeat.o(6389);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Url != null ? g.a.a.b.b.a.f(1, this.Url) + 0 : 0;
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(2, this.iAc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KIQ);
            if (this.KIR != null) {
                bu += g.a.a.b.b.a.f(4, this.KIR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KIS) + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.bu(7, this.KIU) + g.a.a.b.b.a.bu(8, this.KIV) + g.a.a.b.b.a.bu(9, this.Brl) + g.a.a.b.b.a.bu(10, this.KIW) + g.a.a.b.b.a.bu(11, this.KIX) + g.a.a.b.b.a.bu(12, this.iAb) + g.a.a.b.b.a.fS(13) + 1 + g.a.a.a.c(14, 8, this.KIZ);
            AppMethodBeat.o(6389);
            return bu2;
        } else if (i2 == 2) {
            this.KIZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6389);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fn fnVar = (fn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fnVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(6389);
                    return 0;
                case 2:
                    fnVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(6389);
                    return 0;
                case 3:
                    fnVar.KIQ = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 4:
                    fnVar.KIR = aVar3.UbS.readString();
                    AppMethodBeat.o(6389);
                    return 0;
                case 5:
                    fnVar.KIS = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 6:
                    fnVar.KIT = aVar3.UbS.yZ();
                    AppMethodBeat.o(6389);
                    return 0;
                case 7:
                    fnVar.KIU = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 8:
                    fnVar.KIV = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 9:
                    fnVar.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 10:
                    fnVar.KIW = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 11:
                    fnVar.KIX = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 12:
                    fnVar.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(6389);
                    return 0;
                case 13:
                    fnVar.KIY = aVar3.UbS.yZ();
                    AppMethodBeat.o(6389);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eib eib = new eib();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eib.populateBuilderWithField(aVar4, eib, a.getNextFieldNumber(aVar4))) {
                        }
                        fnVar.KIZ.add(eib);
                    }
                    AppMethodBeat.o(6389);
                    return 0;
                default:
                    AppMethodBeat.o(6389);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6389);
            return -1;
        }
    }
}
