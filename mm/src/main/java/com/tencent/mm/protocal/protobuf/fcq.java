package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fcq extends a {
    public int Cya;
    public int Cyb;
    public int IPh;
    public int LQr;
    public String Lru;
    public String Nyw;
    public String Nyx;
    public String Nyy;
    public int Nyz;
    public String SessionId;
    public int ecU;
    public String ecV;
    public String jfi;
    public String nIU;
    public int nIY;
    public int oUv;
    public int rBX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123693);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.Nyw != null) {
                aVar.e(3, this.Nyw);
            }
            aVar.aM(4, this.Cya);
            aVar.aM(5, this.rBX);
            aVar.aM(6, this.Cyb);
            if (this.Nyx != null) {
                aVar.e(7, this.Nyx);
            }
            aVar.aM(8, this.LQr);
            if (this.SessionId != null) {
                aVar.e(9, this.SessionId);
            }
            if (this.Nyy != null) {
                aVar.e(10, this.Nyy);
            }
            aVar.aM(11, this.IPh);
            aVar.aM(12, this.Nyz);
            if (this.Lru != null) {
                aVar.e(13, this.Lru);
            }
            if (this.nIU != null) {
                aVar.e(14, this.nIU);
            }
            aVar.aM(15, this.ecU);
            if (this.ecV != null) {
                aVar.e(16, this.ecV);
            }
            aVar.aM(17, this.nIY);
            AppMethodBeat.o(123693);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.Nyw != null) {
                bu += g.a.a.b.b.a.f(3, this.Nyw);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Cya) + g.a.a.b.b.a.bu(5, this.rBX) + g.a.a.b.b.a.bu(6, this.Cyb);
            if (this.Nyx != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Nyx);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.LQr);
            if (this.SessionId != null) {
                bu3 += g.a.a.b.b.a.f(9, this.SessionId);
            }
            if (this.Nyy != null) {
                bu3 += g.a.a.b.b.a.f(10, this.Nyy);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.IPh) + g.a.a.b.b.a.bu(12, this.Nyz);
            if (this.Lru != null) {
                bu4 += g.a.a.b.b.a.f(13, this.Lru);
            }
            if (this.nIU != null) {
                bu4 += g.a.a.b.b.a.f(14, this.nIU);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(15, this.ecU);
            if (this.ecV != null) {
                bu5 += g.a.a.b.b.a.f(16, this.ecV);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(17, this.nIY);
            AppMethodBeat.o(123693);
            return bu6;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123693);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcq fcq = (fcq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fcq.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 2:
                    fcq.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 3:
                    fcq.Nyw = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 4:
                    fcq.Cya = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 5:
                    fcq.rBX = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 6:
                    fcq.Cyb = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 7:
                    fcq.Nyx = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 8:
                    fcq.LQr = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 9:
                    fcq.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 10:
                    fcq.Nyy = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 11:
                    fcq.IPh = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 12:
                    fcq.Nyz = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 13:
                    fcq.Lru = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 14:
                    fcq.nIU = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 15:
                    fcq.ecU = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                case 16:
                    fcq.ecV = aVar3.UbS.readString();
                    AppMethodBeat.o(123693);
                    return 0;
                case 17:
                    fcq.nIY = aVar3.UbS.zi();
                    AppMethodBeat.o(123693);
                    return 0;
                default:
                    AppMethodBeat.o(123693);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123693);
            return -1;
        }
    }
}
