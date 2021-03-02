package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cxs extends a {
    public String MCA;
    public String MCB;
    public String MCC;
    public String MCD;
    public String MCx;
    public String MCy;
    public String MCz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209773);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MCx != null) {
                aVar.e(1, this.MCx);
            }
            if (this.MCy != null) {
                aVar.e(2, this.MCy);
            }
            if (this.MCz != null) {
                aVar.e(3, this.MCz);
            }
            if (this.MCA != null) {
                aVar.e(4, this.MCA);
            }
            if (this.MCB != null) {
                aVar.e(5, this.MCB);
            }
            if (this.MCC != null) {
                aVar.e(6, this.MCC);
            }
            if (this.MCD != null) {
                aVar.e(7, this.MCD);
            }
            AppMethodBeat.o(209773);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MCx != null ? g.a.a.b.b.a.f(1, this.MCx) + 0 : 0;
            if (this.MCy != null) {
                f2 += g.a.a.b.b.a.f(2, this.MCy);
            }
            if (this.MCz != null) {
                f2 += g.a.a.b.b.a.f(3, this.MCz);
            }
            if (this.MCA != null) {
                f2 += g.a.a.b.b.a.f(4, this.MCA);
            }
            if (this.MCB != null) {
                f2 += g.a.a.b.b.a.f(5, this.MCB);
            }
            if (this.MCC != null) {
                f2 += g.a.a.b.b.a.f(6, this.MCC);
            }
            if (this.MCD != null) {
                f2 += g.a.a.b.b.a.f(7, this.MCD);
            }
            AppMethodBeat.o(209773);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209773);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxs cxs = (cxs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxs.MCx = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 2:
                    cxs.MCy = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 3:
                    cxs.MCz = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 4:
                    cxs.MCA = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 5:
                    cxs.MCB = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 6:
                    cxs.MCC = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                case 7:
                    cxs.MCD = aVar3.UbS.readString();
                    AppMethodBeat.o(209773);
                    return 0;
                default:
                    AppMethodBeat.o(209773);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209773);
            return -1;
        }
    }
}
