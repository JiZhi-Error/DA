package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ecp extends a {
    public String ElT;
    public String KxO;
    public String NcK;
    public int NcL;
    public int adType;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125845);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.adType);
            if (this.NcK != null) {
                aVar.e(2, this.NcK);
            }
            if (this.KxO != null) {
                aVar.e(3, this.KxO);
            }
            aVar.aM(4, this.source);
            if (this.ElT != null) {
                aVar.e(5, this.ElT);
            }
            aVar.aM(6, this.NcL);
            AppMethodBeat.o(125845);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.adType) + 0;
            if (this.NcK != null) {
                bu += g.a.a.b.b.a.f(2, this.NcK);
            }
            if (this.KxO != null) {
                bu += g.a.a.b.b.a.f(3, this.KxO);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.source);
            if (this.ElT != null) {
                bu2 += g.a.a.b.b.a.f(5, this.ElT);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.NcL);
            AppMethodBeat.o(125845);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125845);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecp ecp = (ecp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecp.adType = aVar3.UbS.zi();
                    AppMethodBeat.o(125845);
                    return 0;
                case 2:
                    ecp.NcK = aVar3.UbS.readString();
                    AppMethodBeat.o(125845);
                    return 0;
                case 3:
                    ecp.KxO = aVar3.UbS.readString();
                    AppMethodBeat.o(125845);
                    return 0;
                case 4:
                    ecp.source = aVar3.UbS.zi();
                    AppMethodBeat.o(125845);
                    return 0;
                case 5:
                    ecp.ElT = aVar3.UbS.readString();
                    AppMethodBeat.o(125845);
                    return 0;
                case 6:
                    ecp.NcL = aVar3.UbS.zi();
                    AppMethodBeat.o(125845);
                    return 0;
                default:
                    AppMethodBeat.o(125845);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125845);
            return -1;
        }
    }
}
