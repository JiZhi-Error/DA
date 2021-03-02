package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dfc extends a {
    public String LmX;
    public String LmY;
    public String pTL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200219);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LmX != null) {
                aVar.e(1, this.LmX);
            }
            if (this.LmY != null) {
                aVar.e(2, this.LmY);
            }
            if (this.pTL != null) {
                aVar.e(3, this.pTL);
            }
            AppMethodBeat.o(200219);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LmX != null ? g.a.a.b.b.a.f(1, this.LmX) + 0 : 0;
            if (this.LmY != null) {
                f2 += g.a.a.b.b.a.f(2, this.LmY);
            }
            if (this.pTL != null) {
                f2 += g.a.a.b.b.a.f(3, this.pTL);
            }
            AppMethodBeat.o(200219);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200219);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfc dfc = (dfc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dfc.LmX = aVar3.UbS.readString();
                    AppMethodBeat.o(200219);
                    return 0;
                case 2:
                    dfc.LmY = aVar3.UbS.readString();
                    AppMethodBeat.o(200219);
                    return 0;
                case 3:
                    dfc.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(200219);
                    return 0;
                default:
                    AppMethodBeat.o(200219);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200219);
            return -1;
        }
    }
}
