package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czv extends a {
    public String HYG;
    public String HZX;
    public long Iai;
    public long Iaj;
    public long Iak;
    public int Ial;
    public int Iam;
    public long Ian;
    public String IhY;
    public String MFc;
    public String MFd;
    public String MFe;
    public int MFf;
    public String dQx;
    public String icon;
    public String title;
    public String type;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91578);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.icon != null) {
                aVar.e(3, this.icon);
            }
            if (this.IhY != null) {
                aVar.e(4, this.IhY);
            }
            if (this.HZX != null) {
                aVar.e(5, this.HZX);
            }
            if (this.MFc != null) {
                aVar.e(6, this.MFc);
            }
            if (this.type != null) {
                aVar.e(7, this.type);
            }
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            aVar.bb(9, this.Iai);
            aVar.bb(10, this.Iaj);
            if (this.HYG != null) {
                aVar.e(11, this.HYG);
            }
            aVar.bb(12, this.Iak);
            aVar.aM(13, this.Ial);
            aVar.aM(14, this.Iam);
            if (this.MFd != null) {
                aVar.e(15, this.MFd);
            }
            if (this.MFe != null) {
                aVar.e(16, this.MFe);
            }
            aVar.bb(17, this.Ian);
            aVar.aM(18, this.MFf);
            AppMethodBeat.o(91578);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(3, this.icon);
            }
            if (this.IhY != null) {
                f2 += g.a.a.b.b.a.f(4, this.IhY);
            }
            if (this.HZX != null) {
                f2 += g.a.a.b.b.a.f(5, this.HZX);
            }
            if (this.MFc != null) {
                f2 += g.a.a.b.b.a.f(6, this.MFc);
            }
            if (this.type != null) {
                f2 += g.a.a.b.b.a.f(7, this.type);
            }
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(8, this.title);
            }
            int r = f2 + g.a.a.b.b.a.r(9, this.Iai) + g.a.a.b.b.a.r(10, this.Iaj);
            if (this.HYG != null) {
                r += g.a.a.b.b.a.f(11, this.HYG);
            }
            int r2 = r + g.a.a.b.b.a.r(12, this.Iak) + g.a.a.b.b.a.bu(13, this.Ial) + g.a.a.b.b.a.bu(14, this.Iam);
            if (this.MFd != null) {
                r2 += g.a.a.b.b.a.f(15, this.MFd);
            }
            if (this.MFe != null) {
                r2 += g.a.a.b.b.a.f(16, this.MFe);
            }
            int r3 = r2 + g.a.a.b.b.a.r(17, this.Ian) + g.a.a.b.b.a.bu(18, this.MFf);
            AppMethodBeat.o(91578);
            return r3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91578);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czv czv = (czv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czv.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 2:
                    czv.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 3:
                    czv.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 4:
                    czv.IhY = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 5:
                    czv.HZX = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 6:
                    czv.MFc = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 7:
                    czv.type = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 8:
                    czv.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 9:
                    czv.Iai = aVar3.UbS.zl();
                    AppMethodBeat.o(91578);
                    return 0;
                case 10:
                    czv.Iaj = aVar3.UbS.zl();
                    AppMethodBeat.o(91578);
                    return 0;
                case 11:
                    czv.HYG = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 12:
                    czv.Iak = aVar3.UbS.zl();
                    AppMethodBeat.o(91578);
                    return 0;
                case 13:
                    czv.Ial = aVar3.UbS.zi();
                    AppMethodBeat.o(91578);
                    return 0;
                case 14:
                    czv.Iam = aVar3.UbS.zi();
                    AppMethodBeat.o(91578);
                    return 0;
                case 15:
                    czv.MFd = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 16:
                    czv.MFe = aVar3.UbS.readString();
                    AppMethodBeat.o(91578);
                    return 0;
                case 17:
                    czv.Ian = aVar3.UbS.zl();
                    AppMethodBeat.o(91578);
                    return 0;
                case 18:
                    czv.MFf = aVar3.UbS.zi();
                    AppMethodBeat.o(91578);
                    return 0;
                default:
                    AppMethodBeat.o(91578);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91578);
            return -1;
        }
    }
}
