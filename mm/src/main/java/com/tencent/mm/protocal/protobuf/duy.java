package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class duy extends a {
    public String MWb;
    public String MWc;
    public String dMl;
    public String sGF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122526);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sGF != null) {
                aVar.e(1, this.sGF);
            }
            if (this.MWb != null) {
                aVar.e(2, this.MWb);
            }
            if (this.dMl != null) {
                aVar.e(3, this.dMl);
            }
            if (this.MWc != null) {
                aVar.e(4, this.MWc);
            }
            AppMethodBeat.o(122526);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sGF != null ? g.a.a.b.b.a.f(1, this.sGF) + 0 : 0;
            if (this.MWb != null) {
                f2 += g.a.a.b.b.a.f(2, this.MWb);
            }
            if (this.dMl != null) {
                f2 += g.a.a.b.b.a.f(3, this.dMl);
            }
            if (this.MWc != null) {
                f2 += g.a.a.b.b.a.f(4, this.MWc);
            }
            AppMethodBeat.o(122526);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122526);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duy duy = (duy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    duy.sGF = aVar3.UbS.readString();
                    AppMethodBeat.o(122526);
                    return 0;
                case 2:
                    duy.MWb = aVar3.UbS.readString();
                    AppMethodBeat.o(122526);
                    return 0;
                case 3:
                    duy.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(122526);
                    return 0;
                case 4:
                    duy.MWc = aVar3.UbS.readString();
                    AppMethodBeat.o(122526);
                    return 0;
                default:
                    AppMethodBeat.o(122526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122526);
            return -1;
        }
    }
}