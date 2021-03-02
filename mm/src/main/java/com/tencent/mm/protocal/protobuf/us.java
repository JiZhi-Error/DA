package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class us extends a {
    public float DWG;
    public String Leo;
    public String Lep;
    public String country;
    public float dTj;
    public String descriptor;
    public String fuJ;
    public String fuK;
    public String iUO;
    public float latitude;
    public String name;
    public String pSm;
    public String pTL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113969);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.e(2, this.descriptor);
            }
            if (this.pSm != null) {
                aVar.e(3, this.pSm);
            }
            if (this.country != null) {
                aVar.e(4, this.country);
            }
            if (this.fuJ != null) {
                aVar.e(5, this.fuJ);
            }
            if (this.fuK != null) {
                aVar.e(6, this.fuK);
            }
            if (this.iUO != null) {
                aVar.e(7, this.iUO);
            }
            aVar.E(8, this.DWG);
            aVar.E(9, this.dTj);
            aVar.E(10, this.latitude);
            if (this.pTL != null) {
                aVar.e(11, this.pTL);
            }
            if (this.Leo != null) {
                aVar.e(12, this.Leo);
            }
            if (this.Lep != null) {
                aVar.e(13, this.Lep);
            }
            AppMethodBeat.o(113969);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0;
            if (this.descriptor != null) {
                f2 += g.a.a.b.b.a.f(2, this.descriptor);
            }
            if (this.pSm != null) {
                f2 += g.a.a.b.b.a.f(3, this.pSm);
            }
            if (this.country != null) {
                f2 += g.a.a.b.b.a.f(4, this.country);
            }
            if (this.fuJ != null) {
                f2 += g.a.a.b.b.a.f(5, this.fuJ);
            }
            if (this.fuK != null) {
                f2 += g.a.a.b.b.a.f(6, this.fuK);
            }
            if (this.iUO != null) {
                f2 += g.a.a.b.b.a.f(7, this.iUO);
            }
            int fS = f2 + g.a.a.b.b.a.fS(8) + 4 + g.a.a.b.b.a.fS(9) + 4 + g.a.a.b.b.a.fS(10) + 4;
            if (this.pTL != null) {
                fS += g.a.a.b.b.a.f(11, this.pTL);
            }
            if (this.Leo != null) {
                fS += g.a.a.b.b.a.f(12, this.Leo);
            }
            if (this.Lep != null) {
                fS += g.a.a.b.b.a.f(13, this.Lep);
            }
            AppMethodBeat.o(113969);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113969);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            us usVar = (us) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    usVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 2:
                    usVar.descriptor = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 3:
                    usVar.pSm = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 4:
                    usVar.country = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 5:
                    usVar.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 6:
                    usVar.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 7:
                    usVar.iUO = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 8:
                    usVar.DWG = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(113969);
                    return 0;
                case 9:
                    usVar.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(113969);
                    return 0;
                case 10:
                    usVar.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(113969);
                    return 0;
                case 11:
                    usVar.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 12:
                    usVar.Leo = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                case 13:
                    usVar.Lep = aVar3.UbS.readString();
                    AppMethodBeat.o(113969);
                    return 0;
                default:
                    AppMethodBeat.o(113969);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113969);
            return -1;
        }
    }
}
