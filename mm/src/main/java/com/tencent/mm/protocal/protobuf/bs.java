package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class bs extends a {
    public String Dsg;
    public b KFA;
    public int KFB;
    public int KFC;
    public String KFD;
    public String KFE;
    public String KFF;
    public String KFG;
    public String KFH;
    public String KFI;
    public int KFy;
    public int KFz;
    public String imei;
    public int uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125690);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uin);
            aVar.aM(2, this.KFy);
            aVar.aM(3, this.KFz);
            if (this.KFA != null) {
                aVar.c(4, this.KFA);
            }
            aVar.aM(5, this.KFB);
            aVar.aM(6, this.KFC);
            if (this.Dsg != null) {
                aVar.e(7, this.Dsg);
            }
            if (this.imei != null) {
                aVar.e(8, this.imei);
            }
            if (this.KFD != null) {
                aVar.e(9, this.KFD);
            }
            if (this.KFE != null) {
                aVar.e(10, this.KFE);
            }
            if (this.KFF != null) {
                aVar.e(11, this.KFF);
            }
            if (this.KFG != null) {
                aVar.e(12, this.KFG);
            }
            if (this.KFH != null) {
                aVar.e(13, this.KFH);
            }
            if (this.KFI != null) {
                aVar.e(14, this.KFI);
            }
            AppMethodBeat.o(125690);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KFy) + g.a.a.b.b.a.bu(3, this.KFz);
            if (this.KFA != null) {
                bu += g.a.a.b.b.a.b(4, this.KFA);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KFB) + g.a.a.b.b.a.bu(6, this.KFC);
            if (this.Dsg != null) {
                bu2 += g.a.a.b.b.a.f(7, this.Dsg);
            }
            if (this.imei != null) {
                bu2 += g.a.a.b.b.a.f(8, this.imei);
            }
            if (this.KFD != null) {
                bu2 += g.a.a.b.b.a.f(9, this.KFD);
            }
            if (this.KFE != null) {
                bu2 += g.a.a.b.b.a.f(10, this.KFE);
            }
            if (this.KFF != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KFF);
            }
            if (this.KFG != null) {
                bu2 += g.a.a.b.b.a.f(12, this.KFG);
            }
            if (this.KFH != null) {
                bu2 += g.a.a.b.b.a.f(13, this.KFH);
            }
            if (this.KFI != null) {
                bu2 += g.a.a.b.b.a.f(14, this.KFI);
            }
            AppMethodBeat.o(125690);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125690);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bs bsVar = (bs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsVar.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(125690);
                    return 0;
                case 2:
                    bsVar.KFy = aVar3.UbS.zi();
                    AppMethodBeat.o(125690);
                    return 0;
                case 3:
                    bsVar.KFz = aVar3.UbS.zi();
                    AppMethodBeat.o(125690);
                    return 0;
                case 4:
                    bsVar.KFA = aVar3.UbS.hPo();
                    AppMethodBeat.o(125690);
                    return 0;
                case 5:
                    bsVar.KFB = aVar3.UbS.zi();
                    AppMethodBeat.o(125690);
                    return 0;
                case 6:
                    bsVar.KFC = aVar3.UbS.zi();
                    AppMethodBeat.o(125690);
                    return 0;
                case 7:
                    bsVar.Dsg = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 8:
                    bsVar.imei = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 9:
                    bsVar.KFD = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 10:
                    bsVar.KFE = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 11:
                    bsVar.KFF = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 12:
                    bsVar.KFG = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 13:
                    bsVar.KFH = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                case 14:
                    bsVar.KFI = aVar3.UbS.readString();
                    AppMethodBeat.o(125690);
                    return 0;
                default:
                    AppMethodBeat.o(125690);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125690);
            return -1;
        }
    }
}
