package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pi extends a {
    public int CreateTime;
    public int KHa;
    public String KSh;
    public int KSi;
    public String KSj;
    public String KSk;
    public String KSl;
    public String KSm;
    public String KSn;
    public String KSo;
    public int KSp;
    public int KSq;
    public String KSu;
    public int KSv;
    public int KSw;
    public int KSx;
    public long KWq;
    public LinkedList<String> KWr = new LinkedList<>();
    public int KWs;
    public String KWt;
    public int KWu;
    public int KWv;
    public String KWw;
    public String Title;
    public int iAb;
    public String iAc;
    public String xLi;

    public pi() {
        AppMethodBeat.i(212250);
        AppMethodBeat.o(212250);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212251);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KHa);
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.KSh != null) {
                aVar.e(3, this.KSh);
            }
            if (this.iAc != null) {
                aVar.e(4, this.iAc);
            }
            aVar.aM(5, this.KSi);
            if (this.KSj != null) {
                aVar.e(6, this.KSj);
            }
            if (this.KSk != null) {
                aVar.e(7, this.KSk);
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
            if (this.KSo != null) {
                aVar.e(12, this.KSo);
            }
            aVar.aM(13, this.KSp);
            aVar.aM(14, this.KSq);
            if (this.KSu != null) {
                aVar.e(15, this.KSu);
            }
            aVar.aM(16, this.KSv);
            aVar.aM(17, this.KSw);
            aVar.aM(18, this.KSx);
            aVar.aM(19, this.CreateTime);
            aVar.bb(20, this.KWq);
            aVar.e(21, 1, this.KWr);
            aVar.aM(22, this.KWs);
            if (this.xLi != null) {
                aVar.e(23, this.xLi);
            }
            if (this.KWt != null) {
                aVar.e(24, this.KWt);
            }
            aVar.aM(25, this.KWu);
            aVar.aM(26, this.KWv);
            if (this.KWw != null) {
                aVar.e(27, this.KWw);
            }
            AppMethodBeat.o(212251);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KHa) + 0;
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.KSh != null) {
                bu += g.a.a.b.b.a.f(3, this.KSh);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(4, this.iAc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.KSi);
            if (this.KSj != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KSj);
            }
            if (this.KSk != null) {
                bu2 += g.a.a.b.b.a.f(7, this.KSk);
            }
            if (this.KSl != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KSl);
            }
            if (this.KSm != null) {
                bu2 += g.a.a.b.b.a.f(9, this.KSm);
            }
            if (this.KSn != null) {
                bu2 += g.a.a.b.b.a.f(10, this.KSn);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.iAb);
            if (this.KSo != null) {
                bu3 += g.a.a.b.b.a.f(12, this.KSo);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.KSp) + g.a.a.b.b.a.bu(14, this.KSq);
            if (this.KSu != null) {
                bu4 += g.a.a.b.b.a.f(15, this.KSu);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(16, this.KSv) + g.a.a.b.b.a.bu(17, this.KSw) + g.a.a.b.b.a.bu(18, this.KSx) + g.a.a.b.b.a.bu(19, this.CreateTime) + g.a.a.b.b.a.r(20, this.KWq) + g.a.a.a.c(21, 1, this.KWr) + g.a.a.b.b.a.bu(22, this.KWs);
            if (this.xLi != null) {
                bu5 += g.a.a.b.b.a.f(23, this.xLi);
            }
            if (this.KWt != null) {
                bu5 += g.a.a.b.b.a.f(24, this.KWt);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(25, this.KWu) + g.a.a.b.b.a.bu(26, this.KWv);
            if (this.KWw != null) {
                bu6 += g.a.a.b.b.a.f(27, this.KWw);
            }
            AppMethodBeat.o(212251);
            return bu6;
        } else if (i2 == 2) {
            this.KWr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212251);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pi piVar = (pi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    piVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 2:
                    piVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 3:
                    piVar.KSh = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 4:
                    piVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 5:
                    piVar.KSi = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 6:
                    piVar.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 7:
                    piVar.KSk = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 8:
                    piVar.KSl = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 9:
                    piVar.KSm = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 10:
                    piVar.KSn = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 11:
                    piVar.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 12:
                    piVar.KSo = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 13:
                    piVar.KSp = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 14:
                    piVar.KSq = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 15:
                    piVar.KSu = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 16:
                    piVar.KSv = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 17:
                    piVar.KSw = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 18:
                    piVar.KSx = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 19:
                    piVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 20:
                    piVar.KWq = aVar3.UbS.zl();
                    AppMethodBeat.o(212251);
                    return 0;
                case 21:
                    piVar.KWr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212251);
                    return 0;
                case 22:
                    piVar.KWs = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 23:
                    piVar.xLi = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 24:
                    piVar.KWt = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                case 25:
                    piVar.KWu = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 26:
                    piVar.KWv = aVar3.UbS.zi();
                    AppMethodBeat.o(212251);
                    return 0;
                case 27:
                    piVar.KWw = aVar3.UbS.readString();
                    AppMethodBeat.o(212251);
                    return 0;
                default:
                    AppMethodBeat.o(212251);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212251);
            return -1;
        }
    }
}
