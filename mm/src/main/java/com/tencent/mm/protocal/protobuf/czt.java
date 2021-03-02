package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czt extends a {
    public int KOs;
    public String MEW;
    public String MEX;
    public String MEY;
    public String MEZ;
    public String MFa;
    public String MFb;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91577);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEW != null) {
                aVar.e(1, this.MEW);
            }
            aVar.aM(2, this.oTW);
            if (this.MEX != null) {
                aVar.e(3, this.MEX);
            }
            if (this.MEY != null) {
                aVar.e(4, this.MEY);
            }
            if (this.MEZ != null) {
                aVar.e(5, this.MEZ);
            }
            aVar.aM(6, this.KOs);
            if (this.MFa != null) {
                aVar.e(7, this.MFa);
            }
            if (this.MFb != null) {
                aVar.e(8, this.MFb);
            }
            AppMethodBeat.o(91577);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MEW != null ? g.a.a.b.b.a.f(1, this.MEW) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTW);
            if (this.MEX != null) {
                f2 += g.a.a.b.b.a.f(3, this.MEX);
            }
            if (this.MEY != null) {
                f2 += g.a.a.b.b.a.f(4, this.MEY);
            }
            if (this.MEZ != null) {
                f2 += g.a.a.b.b.a.f(5, this.MEZ);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.KOs);
            if (this.MFa != null) {
                bu += g.a.a.b.b.a.f(7, this.MFa);
            }
            if (this.MFb != null) {
                bu += g.a.a.b.b.a.f(8, this.MFb);
            }
            AppMethodBeat.o(91577);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91577);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czt czt = (czt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czt.MEW = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                case 2:
                    czt.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(91577);
                    return 0;
                case 3:
                    czt.MEX = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                case 4:
                    czt.MEY = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                case 5:
                    czt.MEZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                case 6:
                    czt.KOs = aVar3.UbS.zi();
                    AppMethodBeat.o(91577);
                    return 0;
                case 7:
                    czt.MFa = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                case 8:
                    czt.MFb = aVar3.UbS.readString();
                    AppMethodBeat.o(91577);
                    return 0;
                default:
                    AppMethodBeat.o(91577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91577);
            return -1;
        }
    }
}
