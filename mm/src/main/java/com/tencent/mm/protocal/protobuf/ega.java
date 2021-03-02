package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ega extends a {
    public int CreateTime;
    public int KHa;
    public String KSh;
    public String KSj;
    public String KSl;
    public String KSm;
    public String KSn;
    public String KSu;
    public int KSv;
    public int KSw;
    public int KSx;
    public long KWq;
    public String KWt;
    public int KWu;
    public String Title;
    public int iAb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124558);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KHa);
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.KSh != null) {
                aVar.e(3, this.KSh);
            }
            if (this.KSj != null) {
                aVar.e(6, this.KSj);
            }
            if (this.KSl != null) {
                aVar.e(8, this.KSl);
            }
            if (this.KSm != null) {
                aVar.e(9, this.KSm);
            }
            if (this.KSn != null) {
                aVar.e(10, this.KSn);
            }
            aVar.aM(11, this.iAb);
            if (this.KSu != null) {
                aVar.e(15, this.KSu);
            }
            aVar.aM(16, this.KSv);
            aVar.aM(17, this.KSw);
            aVar.aM(18, this.KSx);
            aVar.aM(19, this.CreateTime);
            aVar.bb(20, this.KWq);
            if (this.KWt != null) {
                aVar.e(21, this.KWt);
            }
            aVar.aM(22, this.KWu);
            AppMethodBeat.o(124558);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KHa) + 0;
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.KSh != null) {
                bu += g.a.a.b.b.a.f(3, this.KSh);
            }
            if (this.KSj != null) {
                bu += g.a.a.b.b.a.f(6, this.KSj);
            }
            if (this.KSl != null) {
                bu += g.a.a.b.b.a.f(8, this.KSl);
            }
            if (this.KSm != null) {
                bu += g.a.a.b.b.a.f(9, this.KSm);
            }
            if (this.KSn != null) {
                bu += g.a.a.b.b.a.f(10, this.KSn);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.iAb);
            if (this.KSu != null) {
                bu2 += g.a.a.b.b.a.f(15, this.KSu);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.KSv) + g.a.a.b.b.a.bu(17, this.KSw) + g.a.a.b.b.a.bu(18, this.KSx) + g.a.a.b.b.a.bu(19, this.CreateTime) + g.a.a.b.b.a.r(20, this.KWq);
            if (this.KWt != null) {
                bu3 += g.a.a.b.b.a.f(21, this.KWt);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(22, this.KWu);
            AppMethodBeat.o(124558);
            return bu4;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124558);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ega ega = (ega) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ega.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 2:
                    ega.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 3:
                    ega.KSh = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 4:
                case 5:
                case 7:
                case 12:
                case 13:
                case 14:
                default:
                    AppMethodBeat.o(124558);
                    return -1;
                case 6:
                    ega.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 8:
                    ega.KSl = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 9:
                    ega.KSm = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 10:
                    ega.KSn = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 11:
                    ega.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 15:
                    ega.KSu = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 16:
                    ega.KSv = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 17:
                    ega.KSw = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 18:
                    ega.KSx = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 19:
                    ega.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
                case 20:
                    ega.KWq = aVar3.UbS.zl();
                    AppMethodBeat.o(124558);
                    return 0;
                case 21:
                    ega.KWt = aVar3.UbS.readString();
                    AppMethodBeat.o(124558);
                    return 0;
                case 22:
                    ega.KWu = aVar3.UbS.zi();
                    AppMethodBeat.o(124558);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124558);
            return -1;
        }
    }
}
