package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dkp extends a {
    public String IFw;
    public String Lui;
    public long MOC;
    public int MOD;
    public String MOE;
    public String appId;
    public String businessId;
    public String cardId;
    public String dSJ;
    public String data;
    public int pos;
    public String title;
    public int weight;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212291);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.aM(2, this.pos);
            aVar.aM(3, this.weight);
            aVar.bb(4, this.MOC);
            aVar.aM(5, this.MOD);
            if (this.businessId != null) {
                aVar.e(6, this.businessId);
            }
            if (this.cardId != null) {
                aVar.e(7, this.cardId);
            }
            if (this.data != null) {
                aVar.e(8, this.data);
            }
            if (this.Lui != null) {
                aVar.e(9, this.Lui);
            }
            if (this.appId != null) {
                aVar.e(10, this.appId);
            }
            if (this.IFw != null) {
                aVar.e(11, this.IFw);
            }
            if (this.dSJ != null) {
                aVar.e(12, this.dSJ);
            }
            if (this.MOE != null) {
                aVar.e(13, this.MOE);
            }
            AppMethodBeat.o(212291);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pos) + g.a.a.b.b.a.bu(3, this.weight) + g.a.a.b.b.a.r(4, this.MOC) + g.a.a.b.b.a.bu(5, this.MOD);
            if (this.businessId != null) {
                f2 += g.a.a.b.b.a.f(6, this.businessId);
            }
            if (this.cardId != null) {
                f2 += g.a.a.b.b.a.f(7, this.cardId);
            }
            if (this.data != null) {
                f2 += g.a.a.b.b.a.f(8, this.data);
            }
            if (this.Lui != null) {
                f2 += g.a.a.b.b.a.f(9, this.Lui);
            }
            if (this.appId != null) {
                f2 += g.a.a.b.b.a.f(10, this.appId);
            }
            if (this.IFw != null) {
                f2 += g.a.a.b.b.a.f(11, this.IFw);
            }
            if (this.dSJ != null) {
                f2 += g.a.a.b.b.a.f(12, this.dSJ);
            }
            if (this.MOE != null) {
                f2 += g.a.a.b.b.a.f(13, this.MOE);
            }
            AppMethodBeat.o(212291);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212291);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkp dkp = (dkp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkp.title = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 2:
                    dkp.pos = aVar3.UbS.zi();
                    AppMethodBeat.o(212291);
                    return 0;
                case 3:
                    dkp.weight = aVar3.UbS.zi();
                    AppMethodBeat.o(212291);
                    return 0;
                case 4:
                    dkp.MOC = aVar3.UbS.zl();
                    AppMethodBeat.o(212291);
                    return 0;
                case 5:
                    dkp.MOD = aVar3.UbS.zi();
                    AppMethodBeat.o(212291);
                    return 0;
                case 6:
                    dkp.businessId = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 7:
                    dkp.cardId = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 8:
                    dkp.data = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 9:
                    dkp.Lui = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 10:
                    dkp.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 11:
                    dkp.IFw = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 12:
                    dkp.dSJ = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                case 13:
                    dkp.MOE = aVar3.UbS.readString();
                    AppMethodBeat.o(212291);
                    return 0;
                default:
                    AppMethodBeat.o(212291);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212291);
            return -1;
        }
    }
}
