package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dlg extends a {
    public String ErZ;
    public int Esb;
    public int Esd;
    public String LIb;
    public float LbC;
    public float LbD;
    public String Mpt;
    public int Mpu;
    public int Mpv;
    public b Mpw;
    public String Mpx;
    public float cjn;
    public String country;
    public String kHV;
    public String kea;
    public int score;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101530);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.LbC);
            aVar.E(2, this.LbD);
            if (this.kea != null) {
                aVar.e(3, this.kea);
            }
            if (this.kHV != null) {
                aVar.e(4, this.kHV);
            }
            if (this.ErZ != null) {
                aVar.e(5, this.ErZ);
            }
            if (this.LIb != null) {
                aVar.e(6, this.LIb);
            }
            aVar.aM(7, this.Esb);
            if (this.Mpt != null) {
                aVar.e(8, this.Mpt);
            }
            aVar.aM(9, this.Mpu);
            aVar.aM(10, this.Mpv);
            aVar.aM(11, this.Esd);
            aVar.E(12, this.cjn);
            if (this.Mpw != null) {
                aVar.c(13, this.Mpw);
            }
            aVar.aM(14, this.score);
            if (this.Mpx != null) {
                aVar.e(15, this.Mpx);
            }
            if (this.country != null) {
                aVar.e(16, this.country);
            }
            AppMethodBeat.o(101530);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4;
            if (this.kea != null) {
                fS += g.a.a.b.b.a.f(3, this.kea);
            }
            if (this.kHV != null) {
                fS += g.a.a.b.b.a.f(4, this.kHV);
            }
            if (this.ErZ != null) {
                fS += g.a.a.b.b.a.f(5, this.ErZ);
            }
            if (this.LIb != null) {
                fS += g.a.a.b.b.a.f(6, this.LIb);
            }
            int bu = fS + g.a.a.b.b.a.bu(7, this.Esb);
            if (this.Mpt != null) {
                bu += g.a.a.b.b.a.f(8, this.Mpt);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Mpu) + g.a.a.b.b.a.bu(10, this.Mpv) + g.a.a.b.b.a.bu(11, this.Esd) + g.a.a.b.b.a.fS(12) + 4;
            if (this.Mpw != null) {
                bu2 += g.a.a.b.b.a.b(13, this.Mpw);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.score);
            if (this.Mpx != null) {
                bu3 += g.a.a.b.b.a.f(15, this.Mpx);
            }
            if (this.country != null) {
                bu3 += g.a.a.b.b.a.f(16, this.country);
            }
            AppMethodBeat.o(101530);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(101530);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlg dlg = (dlg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlg.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(101530);
                    return 0;
                case 2:
                    dlg.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(101530);
                    return 0;
                case 3:
                    dlg.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 4:
                    dlg.kHV = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 5:
                    dlg.ErZ = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 6:
                    dlg.LIb = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 7:
                    dlg.Esb = aVar3.UbS.zi();
                    AppMethodBeat.o(101530);
                    return 0;
                case 8:
                    dlg.Mpt = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 9:
                    dlg.Mpu = aVar3.UbS.zi();
                    AppMethodBeat.o(101530);
                    return 0;
                case 10:
                    dlg.Mpv = aVar3.UbS.zi();
                    AppMethodBeat.o(101530);
                    return 0;
                case 11:
                    dlg.Esd = aVar3.UbS.zi();
                    AppMethodBeat.o(101530);
                    return 0;
                case 12:
                    dlg.cjn = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(101530);
                    return 0;
                case 13:
                    dlg.Mpw = aVar3.UbS.hPo();
                    AppMethodBeat.o(101530);
                    return 0;
                case 14:
                    dlg.score = aVar3.UbS.zi();
                    AppMethodBeat.o(101530);
                    return 0;
                case 15:
                    dlg.Mpx = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                case 16:
                    dlg.country = aVar3.UbS.readString();
                    AppMethodBeat.o(101530);
                    return 0;
                default:
                    AppMethodBeat.o(101530);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101530);
            return -1;
        }
    }
}
