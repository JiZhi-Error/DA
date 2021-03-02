package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dci extends a {
    public float LbC;
    public float LbD;
    public String MHg;
    public String MHh;
    public long MHi;
    public String Mil;
    public String kea;
    public String keh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117892);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MHg != null) {
                aVar.e(1, this.MHg);
            }
            if (this.keh != null) {
                aVar.e(2, this.keh);
            }
            if (this.kea != null) {
                aVar.e(3, this.kea);
            }
            if (this.Mil != null) {
                aVar.e(4, this.Mil);
            }
            aVar.E(5, this.LbD);
            aVar.E(6, this.LbC);
            if (this.MHh != null) {
                aVar.e(7, this.MHh);
            }
            aVar.bb(8, this.MHi);
            AppMethodBeat.o(117892);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MHg != null ? g.a.a.b.b.a.f(1, this.MHg) + 0 : 0;
            if (this.keh != null) {
                f2 += g.a.a.b.b.a.f(2, this.keh);
            }
            if (this.kea != null) {
                f2 += g.a.a.b.b.a.f(3, this.kea);
            }
            if (this.Mil != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mil);
            }
            int fS = f2 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.fS(6) + 4;
            if (this.MHh != null) {
                fS += g.a.a.b.b.a.f(7, this.MHh);
            }
            int r = fS + g.a.a.b.b.a.r(8, this.MHi);
            AppMethodBeat.o(117892);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117892);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dci dci = (dci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dci.MHg = aVar3.UbS.readString();
                    AppMethodBeat.o(117892);
                    return 0;
                case 2:
                    dci.keh = aVar3.UbS.readString();
                    AppMethodBeat.o(117892);
                    return 0;
                case 3:
                    dci.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(117892);
                    return 0;
                case 4:
                    dci.Mil = aVar3.UbS.readString();
                    AppMethodBeat.o(117892);
                    return 0;
                case 5:
                    dci.LbD = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117892);
                    return 0;
                case 6:
                    dci.LbC = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(117892);
                    return 0;
                case 7:
                    dci.MHh = aVar3.UbS.readString();
                    AppMethodBeat.o(117892);
                    return 0;
                case 8:
                    dci.MHi = aVar3.UbS.zl();
                    AppMethodBeat.o(117892);
                    return 0;
                default:
                    AppMethodBeat.o(117892);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117892);
            return -1;
        }
    }
}
