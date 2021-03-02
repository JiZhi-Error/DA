package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class sk extends a {
    public String CEN;
    public String KZW;
    public String KZX;
    public int KZY;
    public String KZZ;
    public String Laa;
    public String Lab;
    public String Lac;
    public String Lad;
    public String Lae;
    public String Laf;
    public String Lag;
    public String Lah;
    public boolean Lai;
    public String Laj;
    public String aeskey;
    public int height;
    public String iwN;
    public int len;
    public String md5;
    public String thumburl;
    public int type;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226004);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.md5 == null) {
                b bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(226004);
                throw bVar;
            }
            if (this.md5 != null) {
                aVar.e(1, this.md5);
            }
            aVar.aM(2, this.len);
            if (this.CEN != null) {
                aVar.e(3, this.CEN);
            }
            aVar.aM(4, this.type);
            if (this.KZW != null) {
                aVar.e(5, this.KZW);
            }
            if (this.KZX != null) {
                aVar.e(6, this.KZX);
            }
            aVar.aM(7, this.KZY);
            if (this.KZZ != null) {
                aVar.e(8, this.KZZ);
            }
            if (this.thumburl != null) {
                aVar.e(9, this.thumburl);
            }
            if (this.Laa != null) {
                aVar.e(10, this.Laa);
            }
            if (this.aeskey != null) {
                aVar.e(11, this.aeskey);
            }
            aVar.aM(12, this.width);
            aVar.aM(13, this.height);
            if (this.Lab != null) {
                aVar.e(14, this.Lab);
            }
            if (this.Lac != null) {
                aVar.e(15, this.Lac);
            }
            if (this.Lad != null) {
                aVar.e(16, this.Lad);
            }
            if (this.iwN != null) {
                aVar.e(17, this.iwN);
            }
            if (this.Lae != null) {
                aVar.e(18, this.Lae);
            }
            if (this.Laf != null) {
                aVar.e(19, this.Laf);
            }
            if (this.Lag != null) {
                aVar.e(20, this.Lag);
            }
            if (this.Lah != null) {
                aVar.e(21, this.Lah);
            }
            aVar.cc(22, this.Lai);
            if (this.Laj != null) {
                aVar.e(23, this.Laj);
            }
            AppMethodBeat.o(226004);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.md5 != null ? g.a.a.b.b.a.f(1, this.md5) + 0 : 0) + g.a.a.b.b.a.bu(2, this.len);
            if (this.CEN != null) {
                f2 += g.a.a.b.b.a.f(3, this.CEN);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.type);
            if (this.KZW != null) {
                bu += g.a.a.b.b.a.f(5, this.KZW);
            }
            if (this.KZX != null) {
                bu += g.a.a.b.b.a.f(6, this.KZX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KZY);
            if (this.KZZ != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KZZ);
            }
            if (this.thumburl != null) {
                bu2 += g.a.a.b.b.a.f(9, this.thumburl);
            }
            if (this.Laa != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Laa);
            }
            if (this.aeskey != null) {
                bu2 += g.a.a.b.b.a.f(11, this.aeskey);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.width) + g.a.a.b.b.a.bu(13, this.height);
            if (this.Lab != null) {
                bu3 += g.a.a.b.b.a.f(14, this.Lab);
            }
            if (this.Lac != null) {
                bu3 += g.a.a.b.b.a.f(15, this.Lac);
            }
            if (this.Lad != null) {
                bu3 += g.a.a.b.b.a.f(16, this.Lad);
            }
            if (this.iwN != null) {
                bu3 += g.a.a.b.b.a.f(17, this.iwN);
            }
            if (this.Lae != null) {
                bu3 += g.a.a.b.b.a.f(18, this.Lae);
            }
            if (this.Laf != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Laf);
            }
            if (this.Lag != null) {
                bu3 += g.a.a.b.b.a.f(20, this.Lag);
            }
            if (this.Lah != null) {
                bu3 += g.a.a.b.b.a.f(21, this.Lah);
            }
            int fS = bu3 + g.a.a.b.b.a.fS(22) + 1;
            if (this.Laj != null) {
                fS += g.a.a.b.b.a.f(23, this.Laj);
            }
            AppMethodBeat.o(226004);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.md5 == null) {
                b bVar2 = new b("Not all required fields were included: md5");
                AppMethodBeat.o(226004);
                throw bVar2;
            }
            AppMethodBeat.o(226004);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sk skVar = (sk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    skVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 2:
                    skVar.len = aVar3.UbS.zi();
                    AppMethodBeat.o(226004);
                    return 0;
                case 3:
                    skVar.CEN = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 4:
                    skVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(226004);
                    return 0;
                case 5:
                    skVar.KZW = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 6:
                    skVar.KZX = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 7:
                    skVar.KZY = aVar3.UbS.zi();
                    AppMethodBeat.o(226004);
                    return 0;
                case 8:
                    skVar.KZZ = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 9:
                    skVar.thumburl = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 10:
                    skVar.Laa = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 11:
                    skVar.aeskey = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 12:
                    skVar.width = aVar3.UbS.zi();
                    AppMethodBeat.o(226004);
                    return 0;
                case 13:
                    skVar.height = aVar3.UbS.zi();
                    AppMethodBeat.o(226004);
                    return 0;
                case 14:
                    skVar.Lab = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 15:
                    skVar.Lac = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 16:
                    skVar.Lad = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 17:
                    skVar.iwN = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 18:
                    skVar.Lae = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 19:
                    skVar.Laf = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 20:
                    skVar.Lag = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 21:
                    skVar.Lah = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                case 22:
                    skVar.Lai = aVar3.UbS.yZ();
                    AppMethodBeat.o(226004);
                    return 0;
                case 23:
                    skVar.Laj = aVar3.UbS.readString();
                    AppMethodBeat.o(226004);
                    return 0;
                default:
                    AppMethodBeat.o(226004);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226004);
            return -1;
        }
    }
}
