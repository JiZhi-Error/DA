package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ewi extends a {
    public String MJz;
    public String Nue;
    public String Nuf;
    public String xJE;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32506);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MJz != null) {
                aVar.e(1, this.MJz);
            }
            if (this.Nue != null) {
                aVar.e(2, this.Nue);
            }
            if (this.xNH != null) {
                aVar.e(3, this.xNH);
            }
            if (this.xJE != null) {
                aVar.e(4, this.xJE);
            }
            if (this.Nuf != null) {
                aVar.e(5, this.Nuf);
            }
            AppMethodBeat.o(32506);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MJz != null ? g.a.a.b.b.a.f(1, this.MJz) + 0 : 0;
            if (this.Nue != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nue);
            }
            if (this.xNH != null) {
                f2 += g.a.a.b.b.a.f(3, this.xNH);
            }
            if (this.xJE != null) {
                f2 += g.a.a.b.b.a.f(4, this.xJE);
            }
            if (this.Nuf != null) {
                f2 += g.a.a.b.b.a.f(5, this.Nuf);
            }
            AppMethodBeat.o(32506);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32506);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewi ewi = (ewi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ewi.MJz = aVar3.UbS.readString();
                    AppMethodBeat.o(32506);
                    return 0;
                case 2:
                    ewi.Nue = aVar3.UbS.readString();
                    AppMethodBeat.o(32506);
                    return 0;
                case 3:
                    ewi.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(32506);
                    return 0;
                case 4:
                    ewi.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(32506);
                    return 0;
                case 5:
                    ewi.Nuf = aVar3.UbS.readString();
                    AppMethodBeat.o(32506);
                    return 0;
                default:
                    AppMethodBeat.o(32506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32506);
            return -1;
        }
    }
}