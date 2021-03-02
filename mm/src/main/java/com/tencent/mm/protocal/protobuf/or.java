package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class or extends a {
    public String KUC;
    public String KUD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209318);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KUC != null) {
                aVar.e(1, this.KUC);
            }
            if (this.KUD != null) {
                aVar.e(2, this.KUD);
            }
            AppMethodBeat.o(209318);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KUC != null ? g.a.a.b.b.a.f(1, this.KUC) + 0 : 0;
            if (this.KUD != null) {
                f2 += g.a.a.b.b.a.f(2, this.KUD);
            }
            AppMethodBeat.o(209318);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209318);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            or orVar = (or) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    orVar.KUC = aVar3.UbS.readString();
                    AppMethodBeat.o(209318);
                    return 0;
                case 2:
                    orVar.KUD = aVar3.UbS.readString();
                    AppMethodBeat.o(209318);
                    return 0;
                default:
                    AppMethodBeat.o(209318);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209318);
            return -1;
        }
    }
}
