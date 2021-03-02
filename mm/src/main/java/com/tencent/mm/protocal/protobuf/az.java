package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class az extends a {
    public String KDV;
    public String KDW;
    public String KDX;
    public int KDY;
    public int pTI;
    public String qHg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209317);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KDV != null) {
                aVar.e(1, this.KDV);
            }
            if (this.KDW != null) {
                aVar.e(2, this.KDW);
            }
            if (this.KDX != null) {
                aVar.e(3, this.KDX);
            }
            aVar.aM(4, this.pTI);
            if (this.qHg != null) {
                aVar.e(5, this.qHg);
            }
            aVar.aM(6, this.KDY);
            AppMethodBeat.o(209317);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KDV != null ? g.a.a.b.b.a.f(1, this.KDV) + 0 : 0;
            if (this.KDW != null) {
                f2 += g.a.a.b.b.a.f(2, this.KDW);
            }
            if (this.KDX != null) {
                f2 += g.a.a.b.b.a.f(3, this.KDX);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.pTI);
            if (this.qHg != null) {
                bu += g.a.a.b.b.a.f(5, this.qHg);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.KDY);
            AppMethodBeat.o(209317);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209317);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azVar.KDV = aVar3.UbS.readString();
                    AppMethodBeat.o(209317);
                    return 0;
                case 2:
                    azVar.KDW = aVar3.UbS.readString();
                    AppMethodBeat.o(209317);
                    return 0;
                case 3:
                    azVar.KDX = aVar3.UbS.readString();
                    AppMethodBeat.o(209317);
                    return 0;
                case 4:
                    azVar.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(209317);
                    return 0;
                case 5:
                    azVar.qHg = aVar3.UbS.readString();
                    AppMethodBeat.o(209317);
                    return 0;
                case 6:
                    azVar.KDY = aVar3.UbS.zi();
                    AppMethodBeat.o(209317);
                    return 0;
                default:
                    AppMethodBeat.o(209317);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209317);
            return -1;
        }
    }
}
