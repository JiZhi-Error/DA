package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class doc extends a {
    public String KOR;
    public String KXA;
    public long KZg;
    public int LlO;
    public String MEq;
    public long MKf;
    public String MQY;
    public int MQZ;
    public int MRa;
    public int MRb;
    public String MRc;
    public String MRd;
    public String MRe;
    public int MRf;
    public int MRg;
    public int MRh;
    public int MRi;
    public String MRj;
    public String MRk;
    public int MRl;
    public String MRm;
    public int MRn;
    public int MRo;
    public String MRp;
    public int MRq;
    public String MRr;
    public String MRs;
    public String MRt;
    public int MaY;
    public String Mba;
    public String Mbb;
    public int MiF;
    public int Mnu;
    public int Scene;
    public String SessionId;
    public String Title;
    public String pLm;
    public String xIy;
    public String xLk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117900);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            if (this.Mbb != null) {
                aVar.e(2, this.Mbb);
            }
            if (this.MQY != null) {
                aVar.e(3, this.MQY);
            }
            aVar.bb(4, this.KZg);
            if (this.MEq != null) {
                aVar.e(5, this.MEq);
            }
            aVar.aM(6, this.MQZ);
            aVar.aM(7, this.MRa);
            aVar.aM(8, this.MRb);
            aVar.bb(9, this.MKf);
            aVar.aM(10, this.MiF);
            if (this.MRc != null) {
                aVar.e(11, this.MRc);
            }
            aVar.aM(12, this.LlO);
            if (this.MRd != null) {
                aVar.e(13, this.MRd);
            }
            if (this.MRe != null) {
                aVar.e(14, this.MRe);
            }
            aVar.aM(15, this.Mnu);
            aVar.aM(16, this.MRf);
            aVar.aM(17, this.MaY);
            if (this.KXA != null) {
                aVar.e(18, this.KXA);
            }
            aVar.aM(19, this.MRg);
            aVar.aM(20, this.MRh);
            if (this.xIy != null) {
                aVar.e(21, this.xIy);
            }
            if (this.SessionId != null) {
                aVar.e(22, this.SessionId);
            }
            aVar.aM(23, this.MRi);
            if (this.MRj != null) {
                aVar.e(24, this.MRj);
            }
            if (this.Title != null) {
                aVar.e(25, this.Title);
            }
            if (this.KOR != null) {
                aVar.e(26, this.KOR);
            }
            if (this.MRk != null) {
                aVar.e(27, this.MRk);
            }
            if (this.pLm != null) {
                aVar.e(28, this.pLm);
            }
            if (this.Mba != null) {
                aVar.e(29, this.Mba);
            }
            aVar.aM(30, this.MRl);
            if (this.MRm != null) {
                aVar.e(31, this.MRm);
            }
            aVar.aM(32, this.MRn);
            aVar.aM(33, this.MRo);
            if (this.MRp != null) {
                aVar.e(34, this.MRp);
            }
            aVar.aM(35, this.MRq);
            if (this.MRr != null) {
                aVar.e(36, this.MRr);
            }
            if (this.MRs != null) {
                aVar.e(37, this.MRs);
            }
            if (this.xLk != null) {
                aVar.e(38, this.xLk);
            }
            if (this.MRt != null) {
                aVar.e(39, this.MRt);
            }
            AppMethodBeat.o(117900);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0;
            if (this.Mbb != null) {
                bu += g.a.a.b.b.a.f(2, this.Mbb);
            }
            if (this.MQY != null) {
                bu += g.a.a.b.b.a.f(3, this.MQY);
            }
            int r = bu + g.a.a.b.b.a.r(4, this.KZg);
            if (this.MEq != null) {
                r += g.a.a.b.b.a.f(5, this.MEq);
            }
            int bu2 = r + g.a.a.b.b.a.bu(6, this.MQZ) + g.a.a.b.b.a.bu(7, this.MRa) + g.a.a.b.b.a.bu(8, this.MRb) + g.a.a.b.b.a.r(9, this.MKf) + g.a.a.b.b.a.bu(10, this.MiF);
            if (this.MRc != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MRc);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.LlO);
            if (this.MRd != null) {
                bu3 += g.a.a.b.b.a.f(13, this.MRd);
            }
            if (this.MRe != null) {
                bu3 += g.a.a.b.b.a.f(14, this.MRe);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.Mnu) + g.a.a.b.b.a.bu(16, this.MRf) + g.a.a.b.b.a.bu(17, this.MaY);
            if (this.KXA != null) {
                bu4 += g.a.a.b.b.a.f(18, this.KXA);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(19, this.MRg) + g.a.a.b.b.a.bu(20, this.MRh);
            if (this.xIy != null) {
                bu5 += g.a.a.b.b.a.f(21, this.xIy);
            }
            if (this.SessionId != null) {
                bu5 += g.a.a.b.b.a.f(22, this.SessionId);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(23, this.MRi);
            if (this.MRj != null) {
                bu6 += g.a.a.b.b.a.f(24, this.MRj);
            }
            if (this.Title != null) {
                bu6 += g.a.a.b.b.a.f(25, this.Title);
            }
            if (this.KOR != null) {
                bu6 += g.a.a.b.b.a.f(26, this.KOR);
            }
            if (this.MRk != null) {
                bu6 += g.a.a.b.b.a.f(27, this.MRk);
            }
            if (this.pLm != null) {
                bu6 += g.a.a.b.b.a.f(28, this.pLm);
            }
            if (this.Mba != null) {
                bu6 += g.a.a.b.b.a.f(29, this.Mba);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(30, this.MRl);
            if (this.MRm != null) {
                bu7 += g.a.a.b.b.a.f(31, this.MRm);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(32, this.MRn) + g.a.a.b.b.a.bu(33, this.MRo);
            if (this.MRp != null) {
                bu8 += g.a.a.b.b.a.f(34, this.MRp);
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(35, this.MRq);
            if (this.MRr != null) {
                bu9 += g.a.a.b.b.a.f(36, this.MRr);
            }
            if (this.MRs != null) {
                bu9 += g.a.a.b.b.a.f(37, this.MRs);
            }
            if (this.xLk != null) {
                bu9 += g.a.a.b.b.a.f(38, this.xLk);
            }
            if (this.MRt != null) {
                bu9 += g.a.a.b.b.a.f(39, this.MRt);
            }
            AppMethodBeat.o(117900);
            return bu9;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117900);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doc doc = (doc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doc.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 2:
                    doc.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 3:
                    doc.MQY = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 4:
                    doc.KZg = aVar3.UbS.zl();
                    AppMethodBeat.o(117900);
                    return 0;
                case 5:
                    doc.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 6:
                    doc.MQZ = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 7:
                    doc.MRa = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 8:
                    doc.MRb = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 9:
                    doc.MKf = aVar3.UbS.zl();
                    AppMethodBeat.o(117900);
                    return 0;
                case 10:
                    doc.MiF = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 11:
                    doc.MRc = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 12:
                    doc.LlO = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 13:
                    doc.MRd = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 14:
                    doc.MRe = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 15:
                    doc.Mnu = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 16:
                    doc.MRf = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 17:
                    doc.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 18:
                    doc.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 19:
                    doc.MRg = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 20:
                    doc.MRh = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 21:
                    doc.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 22:
                    doc.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 23:
                    doc.MRi = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 24:
                    doc.MRj = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 25:
                    doc.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 26:
                    doc.KOR = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 27:
                    doc.MRk = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 28:
                    doc.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 29:
                    doc.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 30:
                    doc.MRl = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 31:
                    doc.MRm = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 32:
                    doc.MRn = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 33:
                    doc.MRo = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 34:
                    doc.MRp = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 35:
                    doc.MRq = aVar3.UbS.zi();
                    AppMethodBeat.o(117900);
                    return 0;
                case 36:
                    doc.MRr = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 37:
                    doc.MRs = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 38:
                    doc.xLk = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                case 39:
                    doc.MRt = aVar3.UbS.readString();
                    AppMethodBeat.o(117900);
                    return 0;
                default:
                    AppMethodBeat.o(117900);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117900);
            return -1;
        }
    }
}
