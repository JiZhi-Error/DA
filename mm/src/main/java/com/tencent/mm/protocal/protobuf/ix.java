package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ix extends a {
    public String ANo;
    public String HQc;
    public String KNr;
    public String KNs;
    public String KNt;
    public String KNu;
    public String dDj;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91355);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KNr != null) {
                aVar.e(1, this.KNr);
            }
            if (this.HQc != null) {
                aVar.e(2, this.HQc);
            }
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            if (this.ANo != null) {
                aVar.e(4, this.ANo);
            }
            if (this.ynT != null) {
                aVar.e(5, this.ynT);
            }
            if (this.KNs != null) {
                aVar.e(6, this.KNs);
            }
            if (this.KNt != null) {
                aVar.e(7, this.KNt);
            }
            if (this.KNu != null) {
                aVar.e(8, this.KNu);
            }
            AppMethodBeat.o(91355);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KNr != null ? g.a.a.b.b.a.f(1, this.KNr) + 0 : 0;
            if (this.HQc != null) {
                f2 += g.a.a.b.b.a.f(2, this.HQc);
            }
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(3, this.dDj);
            }
            if (this.ANo != null) {
                f2 += g.a.a.b.b.a.f(4, this.ANo);
            }
            if (this.ynT != null) {
                f2 += g.a.a.b.b.a.f(5, this.ynT);
            }
            if (this.KNs != null) {
                f2 += g.a.a.b.b.a.f(6, this.KNs);
            }
            if (this.KNt != null) {
                f2 += g.a.a.b.b.a.f(7, this.KNt);
            }
            if (this.KNu != null) {
                f2 += g.a.a.b.b.a.f(8, this.KNu);
            }
            AppMethodBeat.o(91355);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91355);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ix ixVar = (ix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ixVar.KNr = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 2:
                    ixVar.HQc = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 3:
                    ixVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 4:
                    ixVar.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 5:
                    ixVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 6:
                    ixVar.KNs = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 7:
                    ixVar.KNt = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                case 8:
                    ixVar.KNu = aVar3.UbS.readString();
                    AppMethodBeat.o(91355);
                    return 0;
                default:
                    AppMethodBeat.o(91355);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91355);
            return -1;
        }
    }
}
