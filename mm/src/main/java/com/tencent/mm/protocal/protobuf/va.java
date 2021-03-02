package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class va extends a {
    public String Lfm;
    public String code;
    public String dNI;
    public String pRX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113977);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.pRX != null) {
                aVar.e(1, this.pRX);
            }
            if (this.code != null) {
                aVar.e(2, this.code);
            }
            if (this.Lfm != null) {
                aVar.e(3, this.Lfm);
            }
            if (this.dNI != null) {
                aVar.e(4, this.dNI);
            }
            AppMethodBeat.o(113977);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.pRX != null ? g.a.a.b.b.a.f(1, this.pRX) + 0 : 0;
            if (this.code != null) {
                f2 += g.a.a.b.b.a.f(2, this.code);
            }
            if (this.Lfm != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lfm);
            }
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(4, this.dNI);
            }
            AppMethodBeat.o(113977);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113977);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            va vaVar = (va) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vaVar.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(113977);
                    return 0;
                case 2:
                    vaVar.code = aVar3.UbS.readString();
                    AppMethodBeat.o(113977);
                    return 0;
                case 3:
                    vaVar.Lfm = aVar3.UbS.readString();
                    AppMethodBeat.o(113977);
                    return 0;
                case 4:
                    vaVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(113977);
                    return 0;
                default:
                    AppMethodBeat.o(113977);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113977);
            return -1;
        }
    }
}
