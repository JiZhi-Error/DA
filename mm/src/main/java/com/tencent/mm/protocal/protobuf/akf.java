package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class akf extends a {
    public int Ltp;
    public int count;
    public String dNI;
    public String nHd;
    public String nHe;
    public String nHf;
    public String nHg;
    public int nHh;
    public String nHi;
    public int position;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50085);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.aM(2, this.count);
            if (this.nHd != null) {
                aVar.e(3, this.nHd);
            }
            if (this.nHe != null) {
                aVar.e(4, this.nHe);
            }
            aVar.aM(5, this.Ltp);
            if (this.dNI != null) {
                aVar.e(6, this.dNI);
            }
            if (this.nHf != null) {
                aVar.e(7, this.nHf);
            }
            if (this.nHg != null) {
                aVar.e(8, this.nHg);
            }
            aVar.aM(9, this.nHh);
            if (this.nHi != null) {
                aVar.e(10, this.nHi);
            }
            aVar.aM(11, this.position);
            AppMethodBeat.o(50085);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.b.b.a.bu(2, this.count);
            if (this.nHd != null) {
                f2 += g.a.a.b.b.a.f(3, this.nHd);
            }
            if (this.nHe != null) {
                f2 += g.a.a.b.b.a.f(4, this.nHe);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Ltp);
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(6, this.dNI);
            }
            if (this.nHf != null) {
                bu += g.a.a.b.b.a.f(7, this.nHf);
            }
            if (this.nHg != null) {
                bu += g.a.a.b.b.a.f(8, this.nHg);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.nHh);
            if (this.nHi != null) {
                bu2 += g.a.a.b.b.a.f(10, this.nHi);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.position);
            AppMethodBeat.o(50085);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50085);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akf akf = (akf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akf.username = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 2:
                    akf.count = aVar3.UbS.zi();
                    AppMethodBeat.o(50085);
                    return 0;
                case 3:
                    akf.nHd = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 4:
                    akf.nHe = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 5:
                    akf.Ltp = aVar3.UbS.zi();
                    AppMethodBeat.o(50085);
                    return 0;
                case 6:
                    akf.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 7:
                    akf.nHf = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 8:
                    akf.nHg = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 9:
                    akf.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(50085);
                    return 0;
                case 10:
                    akf.nHi = aVar3.UbS.readString();
                    AppMethodBeat.o(50085);
                    return 0;
                case 11:
                    akf.position = aVar3.UbS.zi();
                    AppMethodBeat.o(50085);
                    return 0;
                default:
                    AppMethodBeat.o(50085);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50085);
            return -1;
        }
    }
}
