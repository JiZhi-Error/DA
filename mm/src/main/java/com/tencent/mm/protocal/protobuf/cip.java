package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cip extends a {
    public int Gaz;
    public String LpF;
    public String MnB;
    public String MnC;
    public long hyH;
    public int rotation;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(207495);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hyH);
            if (this.MnB != null) {
                aVar.e(2, this.MnB);
            }
            aVar.aM(3, this.rotation);
            if (this.LpF != null) {
                aVar.e(4, this.LpF);
            }
            aVar.aM(5, this.Gaz);
            if (this.MnC != null) {
                aVar.e(6, this.MnC);
            }
            AppMethodBeat.o(207495);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hyH) + 0;
            if (this.MnB != null) {
                r += g.a.a.b.b.a.f(2, this.MnB);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.rotation);
            if (this.LpF != null) {
                bu += g.a.a.b.b.a.f(4, this.LpF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Gaz);
            if (this.MnC != null) {
                bu2 += g.a.a.b.b.a.f(6, this.MnC);
            }
            AppMethodBeat.o(207495);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(207495);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cip cip = (cip) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cip.hyH = aVar3.UbS.zl();
                    AppMethodBeat.o(207495);
                    return 0;
                case 2:
                    cip.MnB = aVar3.UbS.readString();
                    AppMethodBeat.o(207495);
                    return 0;
                case 3:
                    cip.rotation = aVar3.UbS.zi();
                    AppMethodBeat.o(207495);
                    return 0;
                case 4:
                    cip.LpF = aVar3.UbS.readString();
                    AppMethodBeat.o(207495);
                    return 0;
                case 5:
                    cip.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(207495);
                    return 0;
                case 6:
                    cip.MnC = aVar3.UbS.readString();
                    AppMethodBeat.o(207495);
                    return 0;
                default:
                    AppMethodBeat.o(207495);
                    return -1;
            }
        } else {
            AppMethodBeat.o(207495);
            return -1;
        }
    }
}
