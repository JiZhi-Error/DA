package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ji extends a {
    public String KNR;
    public String KNS;
    public String KNT;
    public String KNU;
    public String KNV;
    public String pTL;
    public String qGB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124392);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNR != null) {
                aVar.e(1, this.KNR);
            }
            if (this.KNS != null) {
                aVar.e(2, this.KNS);
            }
            if (this.KNT != null) {
                aVar.e(3, this.KNT);
            }
            if (this.qGB != null) {
                aVar.e(4, this.qGB);
            }
            if (this.pTL != null) {
                aVar.e(5, this.pTL);
            }
            if (this.KNU != null) {
                aVar.e(6, this.KNU);
            }
            if (this.KNV != null) {
                aVar.e(7, this.KNV);
            }
            AppMethodBeat.o(124392);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KNR != null ? g.a.a.b.b.a.f(1, this.KNR) + 0 : 0;
            if (this.KNS != null) {
                f2 += g.a.a.b.b.a.f(2, this.KNS);
            }
            if (this.KNT != null) {
                f2 += g.a.a.b.b.a.f(3, this.KNT);
            }
            if (this.qGB != null) {
                f2 += g.a.a.b.b.a.f(4, this.qGB);
            }
            if (this.pTL != null) {
                f2 += g.a.a.b.b.a.f(5, this.pTL);
            }
            if (this.KNU != null) {
                f2 += g.a.a.b.b.a.f(6, this.KNU);
            }
            if (this.KNV != null) {
                f2 += g.a.a.b.b.a.f(7, this.KNV);
            }
            AppMethodBeat.o(124392);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124392);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ji jiVar = (ji) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jiVar.KNR = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 2:
                    jiVar.KNS = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 3:
                    jiVar.KNT = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 4:
                    jiVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 5:
                    jiVar.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 6:
                    jiVar.KNU = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                case 7:
                    jiVar.KNV = aVar3.UbS.readString();
                    AppMethodBeat.o(124392);
                    return 0;
                default:
                    AppMethodBeat.o(124392);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124392);
            return -1;
        }
    }
}
