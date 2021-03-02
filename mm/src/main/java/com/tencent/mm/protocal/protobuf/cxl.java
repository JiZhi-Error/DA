package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cxl extends a {
    public String Title;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43117);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.iAc != null) {
                aVar.e(1, this.iAc);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            AppMethodBeat.o(43117);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.iAc != null ? g.a.a.b.b.a.f(1, this.iAc) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            AppMethodBeat.o(43117);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43117);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxl cxl = (cxl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxl.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(43117);
                    return 0;
                case 2:
                    cxl.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(43117);
                    return 0;
                default:
                    AppMethodBeat.o(43117);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43117);
            return -1;
        }
    }
}
