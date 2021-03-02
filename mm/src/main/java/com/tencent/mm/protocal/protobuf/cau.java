package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cau extends a {
    public String IconUrl;
    public String KLg;
    public String KOS;
    public String MfY;
    public String MfZ;
    public int Mga;
    public int Mgb;
    public int Mgc;
    public int Mgd;
    public String Mge;
    public String Mgf;
    public String Mgg;
    public String Mgh;
    public int Mgi;
    public int fMf;
    public long fMg;
    public String fMh;
    public String fMi;
    public String fMj;
    public String fMk;
    public String ked;
    public String xIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82425);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MfY != null) {
                aVar.e(1, this.MfY);
            }
            if (this.KLg != null) {
                aVar.e(2, this.KLg);
            }
            if (this.KOS != null) {
                aVar.e(3, this.KOS);
            }
            if (this.MfZ != null) {
                aVar.e(4, this.MfZ);
            }
            aVar.aM(5, this.Mga);
            aVar.aM(6, this.Mgb);
            aVar.aM(7, this.Mgc);
            aVar.aM(8, this.Mgd);
            if (this.Mge != null) {
                aVar.e(9, this.Mge);
            }
            if (this.ked != null) {
                aVar.e(10, this.ked);
            }
            if (this.IconUrl != null) {
                aVar.e(11, this.IconUrl);
            }
            if (this.xIy != null) {
                aVar.e(12, this.xIy);
            }
            if (this.Mgf != null) {
                aVar.e(13, this.Mgf);
            }
            if (this.Mgg != null) {
                aVar.e(14, this.Mgg);
            }
            if (this.Mgh != null) {
                aVar.e(15, this.Mgh);
            }
            aVar.aM(16, this.Mgi);
            aVar.aM(17, this.fMf);
            aVar.bb(18, this.fMg);
            if (this.fMh != null) {
                aVar.e(19, this.fMh);
            }
            if (this.fMi != null) {
                aVar.e(20, this.fMi);
            }
            if (this.fMj != null) {
                aVar.e(21, this.fMj);
            }
            if (this.fMk != null) {
                aVar.e(22, this.fMk);
            }
            AppMethodBeat.o(82425);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MfY != null ? g.a.a.b.b.a.f(1, this.MfY) + 0 : 0;
            if (this.KLg != null) {
                f2 += g.a.a.b.b.a.f(2, this.KLg);
            }
            if (this.KOS != null) {
                f2 += g.a.a.b.b.a.f(3, this.KOS);
            }
            if (this.MfZ != null) {
                f2 += g.a.a.b.b.a.f(4, this.MfZ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Mga) + g.a.a.b.b.a.bu(6, this.Mgb) + g.a.a.b.b.a.bu(7, this.Mgc) + g.a.a.b.b.a.bu(8, this.Mgd);
            if (this.Mge != null) {
                bu += g.a.a.b.b.a.f(9, this.Mge);
            }
            if (this.ked != null) {
                bu += g.a.a.b.b.a.f(10, this.ked);
            }
            if (this.IconUrl != null) {
                bu += g.a.a.b.b.a.f(11, this.IconUrl);
            }
            if (this.xIy != null) {
                bu += g.a.a.b.b.a.f(12, this.xIy);
            }
            if (this.Mgf != null) {
                bu += g.a.a.b.b.a.f(13, this.Mgf);
            }
            if (this.Mgg != null) {
                bu += g.a.a.b.b.a.f(14, this.Mgg);
            }
            if (this.Mgh != null) {
                bu += g.a.a.b.b.a.f(15, this.Mgh);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(16, this.Mgi) + g.a.a.b.b.a.bu(17, this.fMf) + g.a.a.b.b.a.r(18, this.fMg);
            if (this.fMh != null) {
                bu2 += g.a.a.b.b.a.f(19, this.fMh);
            }
            if (this.fMi != null) {
                bu2 += g.a.a.b.b.a.f(20, this.fMi);
            }
            if (this.fMj != null) {
                bu2 += g.a.a.b.b.a.f(21, this.fMj);
            }
            if (this.fMk != null) {
                bu2 += g.a.a.b.b.a.f(22, this.fMk);
            }
            AppMethodBeat.o(82425);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82425);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cau cau = (cau) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cau.MfY = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 2:
                    cau.KLg = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 3:
                    cau.KOS = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 4:
                    cau.MfZ = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 5:
                    cau.Mga = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 6:
                    cau.Mgb = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 7:
                    cau.Mgc = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 8:
                    cau.Mgd = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 9:
                    cau.Mge = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 10:
                    cau.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 11:
                    cau.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 12:
                    cau.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 13:
                    cau.Mgf = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 14:
                    cau.Mgg = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 15:
                    cau.Mgh = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 16:
                    cau.Mgi = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 17:
                    cau.fMf = aVar3.UbS.zi();
                    AppMethodBeat.o(82425);
                    return 0;
                case 18:
                    cau.fMg = aVar3.UbS.zl();
                    AppMethodBeat.o(82425);
                    return 0;
                case 19:
                    cau.fMh = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 20:
                    cau.fMi = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 21:
                    cau.fMj = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                case 22:
                    cau.fMk = aVar3.UbS.readString();
                    AppMethodBeat.o(82425);
                    return 0;
                default:
                    AppMethodBeat.o(82425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82425);
            return -1;
        }
    }
}
