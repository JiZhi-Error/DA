package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fah extends a {
    public int MLG;
    public boolean NwA;
    public String NwB;
    public String Nwh;
    public int Nwi;
    public String Nwj;
    public boolean Nwk;
    public boolean Nwl;
    public String Nwm;
    public String Nwn;
    public int Nwo;
    public int Nwp;
    public int Nwq;
    public int Nwr;
    public String Nws;
    public int Nwt;
    public int Nwu;
    public long Nwv;
    public int Nww;
    public long Nwx;
    public String Nwy;
    public String Nwz;
    public String coverUrl;
    public String eag;
    public String eah;
    public String edo;
    public String id;
    public int mode;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(208711);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.edo != null) {
                aVar.e(2, this.edo);
            }
            if (this.Nwh != null) {
                aVar.e(3, this.Nwh);
            }
            aVar.aM(4, this.Nwi);
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.Nwj != null) {
                aVar.e(6, this.Nwj);
            }
            aVar.cc(7, this.Nwk);
            aVar.cc(8, this.Nwl);
            if (this.eag != null) {
                aVar.e(9, this.eag);
            }
            if (this.eah != null) {
                aVar.e(10, this.eah);
            }
            aVar.aM(11, this.mode);
            if (this.Nwm != null) {
                aVar.e(12, this.Nwm);
            }
            if (this.Nwn != null) {
                aVar.e(13, this.Nwn);
            }
            aVar.aM(14, this.Nwo);
            aVar.aM(15, this.Nwp);
            aVar.aM(16, this.MLG);
            aVar.aM(17, this.Nwq);
            aVar.aM(18, this.Nwr);
            if (this.Nws != null) {
                aVar.e(19, this.Nws);
            }
            aVar.aM(20, this.Nwt);
            aVar.aM(21, this.Nwu);
            aVar.bb(22, this.Nwv);
            aVar.aM(23, this.Nww);
            aVar.bb(24, this.Nwx);
            if (this.Nwy != null) {
                aVar.e(25, this.Nwy);
            }
            if (this.Nwz != null) {
                aVar.e(26, this.Nwz);
            }
            aVar.cc(27, this.NwA);
            if (this.NwB != null) {
                aVar.e(28, this.NwB);
            }
            if (this.coverUrl != null) {
                aVar.e(29, this.coverUrl);
            }
            AppMethodBeat.o(208711);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.edo != null) {
                f2 += g.a.a.b.b.a.f(2, this.edo);
            }
            if (this.Nwh != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nwh);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Nwi);
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(5, this.title);
            }
            if (this.Nwj != null) {
                bu += g.a.a.b.b.a.f(6, this.Nwj);
            }
            int fS = bu + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1;
            if (this.eag != null) {
                fS += g.a.a.b.b.a.f(9, this.eag);
            }
            if (this.eah != null) {
                fS += g.a.a.b.b.a.f(10, this.eah);
            }
            int bu2 = fS + g.a.a.b.b.a.bu(11, this.mode);
            if (this.Nwm != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Nwm);
            }
            if (this.Nwn != null) {
                bu2 += g.a.a.b.b.a.f(13, this.Nwn);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.Nwo) + g.a.a.b.b.a.bu(15, this.Nwp) + g.a.a.b.b.a.bu(16, this.MLG) + g.a.a.b.b.a.bu(17, this.Nwq) + g.a.a.b.b.a.bu(18, this.Nwr);
            if (this.Nws != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Nws);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(20, this.Nwt) + g.a.a.b.b.a.bu(21, this.Nwu) + g.a.a.b.b.a.r(22, this.Nwv) + g.a.a.b.b.a.bu(23, this.Nww) + g.a.a.b.b.a.r(24, this.Nwx);
            if (this.Nwy != null) {
                bu4 += g.a.a.b.b.a.f(25, this.Nwy);
            }
            if (this.Nwz != null) {
                bu4 += g.a.a.b.b.a.f(26, this.Nwz);
            }
            int fS2 = bu4 + g.a.a.b.b.a.fS(27) + 1;
            if (this.NwB != null) {
                fS2 += g.a.a.b.b.a.f(28, this.NwB);
            }
            if (this.coverUrl != null) {
                fS2 += g.a.a.b.b.a.f(29, this.coverUrl);
            }
            AppMethodBeat.o(208711);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(208711);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fah fah = (fah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fah.id = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 2:
                    fah.edo = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 3:
                    fah.Nwh = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 4:
                    fah.Nwi = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 5:
                    fah.title = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 6:
                    fah.Nwj = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 7:
                    fah.Nwk = aVar3.UbS.yZ();
                    AppMethodBeat.o(208711);
                    return 0;
                case 8:
                    fah.Nwl = aVar3.UbS.yZ();
                    AppMethodBeat.o(208711);
                    return 0;
                case 9:
                    fah.eag = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 10:
                    fah.eah = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 11:
                    fah.mode = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 12:
                    fah.Nwm = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 13:
                    fah.Nwn = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 14:
                    fah.Nwo = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 15:
                    fah.Nwp = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 16:
                    fah.MLG = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 17:
                    fah.Nwq = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 18:
                    fah.Nwr = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 19:
                    fah.Nws = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 20:
                    fah.Nwt = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 21:
                    fah.Nwu = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 22:
                    fah.Nwv = aVar3.UbS.zl();
                    AppMethodBeat.o(208711);
                    return 0;
                case 23:
                    fah.Nww = aVar3.UbS.zi();
                    AppMethodBeat.o(208711);
                    return 0;
                case 24:
                    fah.Nwx = aVar3.UbS.zl();
                    AppMethodBeat.o(208711);
                    return 0;
                case 25:
                    fah.Nwy = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 26:
                    fah.Nwz = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 27:
                    fah.NwA = aVar3.UbS.yZ();
                    AppMethodBeat.o(208711);
                    return 0;
                case 28:
                    fah.NwB = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                case 29:
                    fah.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(208711);
                    return 0;
                default:
                    AppMethodBeat.o(208711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(208711);
            return -1;
        }
    }
}
