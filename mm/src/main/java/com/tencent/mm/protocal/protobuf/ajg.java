package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ajg extends a {
    public int KHa;
    public String LsK;
    public String LsL;
    public String LsM;
    public String LsN;
    public String LsO;
    public int LsP;
    public int LsQ;
    public String LsR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104780);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LsK == null) {
                b bVar = new b("Not all required fields were included: BegWord");
                AppMethodBeat.o(104780);
                throw bVar;
            } else if (this.LsL == null) {
                b bVar2 = new b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.o(104780);
                throw bVar2;
            } else if (this.LsM == null) {
                b bVar3 = new b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.o(104780);
                throw bVar3;
            } else {
                if (this.LsK != null) {
                    aVar.e(1, this.LsK);
                }
                if (this.LsL != null) {
                    aVar.e(2, this.LsL);
                }
                if (this.LsM != null) {
                    aVar.e(3, this.LsM);
                }
                if (this.LsN != null) {
                    aVar.e(4, this.LsN);
                }
                if (this.LsO != null) {
                    aVar.e(5, this.LsO);
                }
                aVar.aM(6, this.LsP);
                aVar.aM(7, this.LsQ);
                if (this.LsR != null) {
                    aVar.e(8, this.LsR);
                }
                aVar.aM(9, this.KHa);
                AppMethodBeat.o(104780);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.LsK != null ? g.a.a.b.b.a.f(1, this.LsK) + 0 : 0;
            if (this.LsL != null) {
                f2 += g.a.a.b.b.a.f(2, this.LsL);
            }
            if (this.LsM != null) {
                f2 += g.a.a.b.b.a.f(3, this.LsM);
            }
            if (this.LsN != null) {
                f2 += g.a.a.b.b.a.f(4, this.LsN);
            }
            if (this.LsO != null) {
                f2 += g.a.a.b.b.a.f(5, this.LsO);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.LsP) + g.a.a.b.b.a.bu(7, this.LsQ);
            if (this.LsR != null) {
                bu += g.a.a.b.b.a.f(8, this.LsR);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.KHa);
            AppMethodBeat.o(104780);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LsK == null) {
                b bVar4 = new b("Not all required fields were included: BegWord");
                AppMethodBeat.o(104780);
                throw bVar4;
            } else if (this.LsL == null) {
                b bVar5 = new b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.o(104780);
                throw bVar5;
            } else if (this.LsM == null) {
                b bVar6 = new b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.o(104780);
                throw bVar6;
            } else {
                AppMethodBeat.o(104780);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajg ajg = (ajg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajg.LsK = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 2:
                    ajg.LsL = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 3:
                    ajg.LsM = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 4:
                    ajg.LsN = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 5:
                    ajg.LsO = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 6:
                    ajg.LsP = aVar3.UbS.zi();
                    AppMethodBeat.o(104780);
                    return 0;
                case 7:
                    ajg.LsQ = aVar3.UbS.zi();
                    AppMethodBeat.o(104780);
                    return 0;
                case 8:
                    ajg.LsR = aVar3.UbS.readString();
                    AppMethodBeat.o(104780);
                    return 0;
                case 9:
                    ajg.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(104780);
                    return 0;
                default:
                    AppMethodBeat.o(104780);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104780);
            return -1;
        }
    }
}
