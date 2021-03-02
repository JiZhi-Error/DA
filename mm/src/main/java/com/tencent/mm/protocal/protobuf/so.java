package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class so extends a {
    public int ETL;
    public int ETM;
    public int LaB;
    public String LaC;
    public String LaD;
    public String LaE;
    public int Lan;
    public String aeskey;
    public String gTB;
    public int length;
    public String md5;
    public int type;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226008);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.aeskey == null) {
                b bVar = new b("Not all required fields were included: aeskey");
                AppMethodBeat.o(226008);
                throw bVar;
            } else if (this.url == null) {
                b bVar2 = new b("Not all required fields were included: url");
                AppMethodBeat.o(226008);
                throw bVar2;
            } else {
                if (this.aeskey != null) {
                    aVar.e(1, this.aeskey);
                }
                if (this.url != null) {
                    aVar.e(2, this.url);
                }
                aVar.aM(3, this.type);
                aVar.aM(4, this.length);
                aVar.aM(5, this.LaB);
                if (this.LaC != null) {
                    aVar.e(6, this.LaC);
                }
                if (this.gTB != null) {
                    aVar.e(7, this.gTB);
                }
                aVar.aM(8, this.Lan);
                aVar.aM(9, this.ETL);
                aVar.aM(10, this.ETM);
                if (this.md5 != null) {
                    aVar.e(11, this.md5);
                }
                if (this.LaD != null) {
                    aVar.e(12, this.LaD);
                }
                if (this.LaE != null) {
                    aVar.e(13, this.LaE);
                }
                AppMethodBeat.o(226008);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.aeskey != null ? g.a.a.b.b.a.f(1, this.aeskey) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.type) + g.a.a.b.b.a.bu(4, this.length) + g.a.a.b.b.a.bu(5, this.LaB);
            if (this.LaC != null) {
                bu += g.a.a.b.b.a.f(6, this.LaC);
            }
            if (this.gTB != null) {
                bu += g.a.a.b.b.a.f(7, this.gTB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Lan) + g.a.a.b.b.a.bu(9, this.ETL) + g.a.a.b.b.a.bu(10, this.ETM);
            if (this.md5 != null) {
                bu2 += g.a.a.b.b.a.f(11, this.md5);
            }
            if (this.LaD != null) {
                bu2 += g.a.a.b.b.a.f(12, this.LaD);
            }
            if (this.LaE != null) {
                bu2 += g.a.a.b.b.a.f(13, this.LaE);
            }
            AppMethodBeat.o(226008);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.aeskey == null) {
                b bVar3 = new b("Not all required fields were included: aeskey");
                AppMethodBeat.o(226008);
                throw bVar3;
            } else if (this.url == null) {
                b bVar4 = new b("Not all required fields were included: url");
                AppMethodBeat.o(226008);
                throw bVar4;
            } else {
                AppMethodBeat.o(226008);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            so soVar = (so) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    soVar.aeskey = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 2:
                    soVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 3:
                    soVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 4:
                    soVar.length = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 5:
                    soVar.LaB = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 6:
                    soVar.LaC = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 7:
                    soVar.gTB = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 8:
                    soVar.Lan = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 9:
                    soVar.ETL = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 10:
                    soVar.ETM = aVar3.UbS.zi();
                    AppMethodBeat.o(226008);
                    return 0;
                case 11:
                    soVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 12:
                    soVar.LaD = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                case 13:
                    soVar.LaE = aVar3.UbS.readString();
                    AppMethodBeat.o(226008);
                    return 0;
                default:
                    AppMethodBeat.o(226008);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226008);
            return -1;
        }
    }
}
