package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class coe extends a {
    public int LEL;
    public int LGa;
    public String dVY;
    public String uUI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209763);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dVY != null) {
                aVar.e(1, this.dVY);
            }
            aVar.aM(2, this.LEL);
            aVar.aM(3, this.LGa);
            if (this.uUI != null) {
                aVar.e(4, this.uUI);
            }
            AppMethodBeat.o(209763);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dVY != null ? g.a.a.b.b.a.f(1, this.dVY) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LEL) + g.a.a.b.b.a.bu(3, this.LGa);
            if (this.uUI != null) {
                f2 += g.a.a.b.b.a.f(4, this.uUI);
            }
            AppMethodBeat.o(209763);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209763);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coe coe = (coe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coe.dVY = aVar3.UbS.readString();
                    AppMethodBeat.o(209763);
                    return 0;
                case 2:
                    coe.LEL = aVar3.UbS.zi();
                    AppMethodBeat.o(209763);
                    return 0;
                case 3:
                    coe.LGa = aVar3.UbS.zi();
                    AppMethodBeat.o(209763);
                    return 0;
                case 4:
                    coe.uUI = aVar3.UbS.readString();
                    AppMethodBeat.o(209763);
                    return 0;
                default:
                    AppMethodBeat.o(209763);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209763);
            return -1;
        }
    }
}