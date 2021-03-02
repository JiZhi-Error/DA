package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbw extends a {
    public String Nickname;
    public String NxV;
    public int NxW;
    public String xJE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124574);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NxV != null) {
                aVar.e(1, this.NxV);
            }
            if (this.xJE != null) {
                aVar.e(2, this.xJE);
            }
            if (this.Nickname != null) {
                aVar.e(3, this.Nickname);
            }
            aVar.aM(4, this.NxW);
            AppMethodBeat.o(124574);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NxV != null ? g.a.a.b.b.a.f(1, this.NxV) + 0 : 0;
            if (this.xJE != null) {
                f2 += g.a.a.b.b.a.f(2, this.xJE);
            }
            if (this.Nickname != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nickname);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.NxW);
            AppMethodBeat.o(124574);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124574);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbw fbw = (fbw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbw.NxV = aVar3.UbS.readString();
                    AppMethodBeat.o(124574);
                    return 0;
                case 2:
                    fbw.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(124574);
                    return 0;
                case 3:
                    fbw.Nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(124574);
                    return 0;
                case 4:
                    fbw.NxW = aVar3.UbS.zi();
                    AppMethodBeat.o(124574);
                    return 0;
                default:
                    AppMethodBeat.o(124574);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124574);
            return -1;
        }
    }
}
