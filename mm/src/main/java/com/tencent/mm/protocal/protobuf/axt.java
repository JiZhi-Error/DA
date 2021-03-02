package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axt extends a {
    public String ErZ;
    public int Esb;
    public String LIb;
    public String country;
    public float dTj;
    public String fuJ;
    public String fuK;
    public String jlI;
    public String kHV;
    public float latitude;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169004);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.dTj);
            aVar.E(2, this.latitude);
            if (this.fuK != null) {
                aVar.e(3, this.fuK);
            }
            if (this.kHV != null) {
                aVar.e(4, this.kHV);
            }
            if (this.ErZ != null) {
                aVar.e(5, this.ErZ);
            }
            if (this.LIb != null) {
                aVar.e(6, this.LIb);
            }
            aVar.aM(7, this.Esb);
            if (this.fuJ != null) {
                aVar.e(8, this.fuJ);
            }
            if (this.jlI != null) {
                aVar.e(9, this.jlI);
            }
            if (this.country != null) {
                aVar.e(10, this.country);
            }
            aVar.aM(11, this.source);
            AppMethodBeat.o(169004);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4;
            if (this.fuK != null) {
                fS += g.a.a.b.b.a.f(3, this.fuK);
            }
            if (this.kHV != null) {
                fS += g.a.a.b.b.a.f(4, this.kHV);
            }
            if (this.ErZ != null) {
                fS += g.a.a.b.b.a.f(5, this.ErZ);
            }
            if (this.LIb != null) {
                fS += g.a.a.b.b.a.f(6, this.LIb);
            }
            int bu = fS + g.a.a.b.b.a.bu(7, this.Esb);
            if (this.fuJ != null) {
                bu += g.a.a.b.b.a.f(8, this.fuJ);
            }
            if (this.jlI != null) {
                bu += g.a.a.b.b.a.f(9, this.jlI);
            }
            if (this.country != null) {
                bu += g.a.a.b.b.a.f(10, this.country);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.source);
            AppMethodBeat.o(169004);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169004);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axt axt = (axt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axt.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169004);
                    return 0;
                case 2:
                    axt.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169004);
                    return 0;
                case 3:
                    axt.fuK = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 4:
                    axt.kHV = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 5:
                    axt.ErZ = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 6:
                    axt.LIb = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 7:
                    axt.Esb = aVar3.UbS.zi();
                    AppMethodBeat.o(169004);
                    return 0;
                case 8:
                    axt.fuJ = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 9:
                    axt.jlI = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 10:
                    axt.country = aVar3.UbS.readString();
                    AppMethodBeat.o(169004);
                    return 0;
                case 11:
                    axt.source = aVar3.UbS.zi();
                    AppMethodBeat.o(169004);
                    return 0;
                default:
                    AppMethodBeat.o(169004);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169004);
            return -1;
        }
    }
}
