package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cgm extends a {
    public int MlV;
    public String UserName;
    public String oTI;
    public String oUJ;
    public String xJE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256409);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.xJE != null) {
                aVar.e(3, this.xJE);
            }
            if (this.oTI != null) {
                aVar.e(4, this.oTI);
            }
            aVar.aM(5, this.MlV);
            AppMethodBeat.o(256409);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.xJE != null) {
                f2 += g.a.a.b.b.a.f(3, this.xJE);
            }
            if (this.oTI != null) {
                f2 += g.a.a.b.b.a.f(4, this.oTI);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MlV);
            AppMethodBeat.o(256409);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256409);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgm cgm = (cgm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgm.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(256409);
                    return 0;
                case 2:
                    cgm.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(256409);
                    return 0;
                case 3:
                    cgm.xJE = aVar3.UbS.readString();
                    AppMethodBeat.o(256409);
                    return 0;
                case 4:
                    cgm.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(256409);
                    return 0;
                case 5:
                    cgm.MlV = aVar3.UbS.zi();
                    AppMethodBeat.o(256409);
                    return 0;
                default:
                    AppMethodBeat.o(256409);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256409);
            return -1;
        }
    }
}
