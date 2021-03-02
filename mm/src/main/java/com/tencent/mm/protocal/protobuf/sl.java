package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class sl extends a {
    public int ETL;
    public int ETM;
    public int Lak;
    public int Lal;
    public int Lam;
    public int Lan;
    public int Lao;
    public int Lap;
    public int Laq;
    public int Lar;
    public int Las;
    public int Lat;
    public int Lau;
    public String aeskey;
    public String md5;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226005);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.aeskey != null) {
                aVar.e(1, this.aeskey);
            }
            aVar.aM(2, this.Lak);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.aM(4, this.Lal);
            aVar.aM(5, this.Lam);
            aVar.aM(6, this.Lan);
            aVar.aM(7, this.ETM);
            aVar.aM(8, this.ETL);
            if (this.md5 != null) {
                aVar.e(9, this.md5);
            }
            aVar.aM(10, this.Lao);
            aVar.aM(11, this.Lap);
            aVar.aM(12, this.Laq);
            aVar.aM(13, this.Lar);
            aVar.aM(14, this.Las);
            aVar.aM(15, this.Lat);
            aVar.aM(16, this.Lau);
            AppMethodBeat.o(226005);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.aeskey != null ? g.a.a.b.b.a.f(1, this.aeskey) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Lak);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(3, this.url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lal) + g.a.a.b.b.a.bu(5, this.Lam) + g.a.a.b.b.a.bu(6, this.Lan) + g.a.a.b.b.a.bu(7, this.ETM) + g.a.a.b.b.a.bu(8, this.ETL);
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(9, this.md5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Lao) + g.a.a.b.b.a.bu(11, this.Lap) + g.a.a.b.b.a.bu(12, this.Laq) + g.a.a.b.b.a.bu(13, this.Lar) + g.a.a.b.b.a.bu(14, this.Las) + g.a.a.b.b.a.bu(15, this.Lat) + g.a.a.b.b.a.bu(16, this.Lau);
            AppMethodBeat.o(226005);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(226005);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sl slVar = (sl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    slVar.aeskey = aVar3.UbS.readString();
                    AppMethodBeat.o(226005);
                    return 0;
                case 2:
                    slVar.Lak = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 3:
                    slVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(226005);
                    return 0;
                case 4:
                    slVar.Lal = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 5:
                    slVar.Lam = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 6:
                    slVar.Lan = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 7:
                    slVar.ETM = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 8:
                    slVar.ETL = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 9:
                    slVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(226005);
                    return 0;
                case 10:
                    slVar.Lao = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 11:
                    slVar.Lap = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 12:
                    slVar.Laq = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 13:
                    slVar.Lar = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 14:
                    slVar.Las = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 15:
                    slVar.Lat = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                case 16:
                    slVar.Lau = aVar3.UbS.zi();
                    AppMethodBeat.o(226005);
                    return 0;
                default:
                    AppMethodBeat.o(226005);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226005);
            return -1;
        }
    }
}
