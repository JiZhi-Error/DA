package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class css extends a {
    public int Alz;
    public String BPc;
    public String EsK;
    public String Ktn;
    public String Kto;
    public String Ktp;
    public String Ktq;
    public String albumName;
    public String extraInfo;
    public String identification;
    public long issueDate;
    public String jfz;
    public String musicGenre;
    public String singerName;
    public String songLyric;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196100);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ktn != null) {
                aVar.e(1, this.Ktn);
            }
            if (this.Kto != null) {
                aVar.e(2, this.Kto);
            }
            if (this.Ktp != null) {
                aVar.e(3, this.Ktp);
            }
            if (this.Ktq != null) {
                aVar.e(4, this.Ktq);
            }
            if (this.singerName != null) {
                aVar.e(5, this.singerName);
            }
            if (this.albumName != null) {
                aVar.e(6, this.albumName);
            }
            if (this.extraInfo != null) {
                aVar.e(7, this.extraInfo);
            }
            if (this.musicGenre != null) {
                aVar.e(8, this.musicGenre);
            }
            aVar.bb(9, this.issueDate);
            if (this.identification != null) {
                aVar.e(10, this.identification);
            }
            aVar.aM(11, this.Alz);
            if (this.jfz != null) {
                aVar.e(21, this.jfz);
            }
            if (this.BPc != null) {
                aVar.e(22, this.BPc);
            }
            if (this.songLyric != null) {
                aVar.e(23, this.songLyric);
            }
            if (this.EsK != null) {
                aVar.e(25, this.EsK);
            }
            AppMethodBeat.o(196100);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Ktn != null ? g.a.a.b.b.a.f(1, this.Ktn) + 0 : 0;
            if (this.Kto != null) {
                f2 += g.a.a.b.b.a.f(2, this.Kto);
            }
            if (this.Ktp != null) {
                f2 += g.a.a.b.b.a.f(3, this.Ktp);
            }
            if (this.Ktq != null) {
                f2 += g.a.a.b.b.a.f(4, this.Ktq);
            }
            if (this.singerName != null) {
                f2 += g.a.a.b.b.a.f(5, this.singerName);
            }
            if (this.albumName != null) {
                f2 += g.a.a.b.b.a.f(6, this.albumName);
            }
            if (this.extraInfo != null) {
                f2 += g.a.a.b.b.a.f(7, this.extraInfo);
            }
            if (this.musicGenre != null) {
                f2 += g.a.a.b.b.a.f(8, this.musicGenre);
            }
            int r = f2 + g.a.a.b.b.a.r(9, this.issueDate);
            if (this.identification != null) {
                r += g.a.a.b.b.a.f(10, this.identification);
            }
            int bu = r + g.a.a.b.b.a.bu(11, this.Alz);
            if (this.jfz != null) {
                bu += g.a.a.b.b.a.f(21, this.jfz);
            }
            if (this.BPc != null) {
                bu += g.a.a.b.b.a.f(22, this.BPc);
            }
            if (this.songLyric != null) {
                bu += g.a.a.b.b.a.f(23, this.songLyric);
            }
            if (this.EsK != null) {
                bu += g.a.a.b.b.a.f(25, this.EsK);
            }
            AppMethodBeat.o(196100);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196100);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            css css = (css) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    css.Ktn = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 2:
                    css.Kto = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 3:
                    css.Ktp = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 4:
                    css.Ktq = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 5:
                    css.singerName = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 6:
                    css.albumName = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 7:
                    css.extraInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 8:
                    css.musicGenre = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 9:
                    css.issueDate = aVar3.UbS.zl();
                    AppMethodBeat.o(196100);
                    return 0;
                case 10:
                    css.identification = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 11:
                    css.Alz = aVar3.UbS.zi();
                    AppMethodBeat.o(196100);
                    return 0;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 24:
                default:
                    AppMethodBeat.o(196100);
                    return -1;
                case 21:
                    css.jfz = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 22:
                    css.BPc = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 23:
                    css.songLyric = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
                case 25:
                    css.EsK = aVar3.UbS.readString();
                    AppMethodBeat.o(196100);
                    return 0;
            }
        } else {
            AppMethodBeat.o(196100);
            return -1;
        }
    }
}
