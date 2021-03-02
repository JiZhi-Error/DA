package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class drb extends a {
    public String Desc;
    public String KWK;
    public int MTI;
    public String MTJ;
    public String MTK;
    public String Mjt;
    public String nBo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123643);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWK != null) {
                aVar.e(1, this.KWK);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            aVar.aM(3, this.MTI);
            if (this.nBo != null) {
                aVar.e(4, this.nBo);
            }
            if (this.Mjt != null) {
                aVar.e(5, this.Mjt);
            }
            if (this.MTJ != null) {
                aVar.e(6, this.MTJ);
            }
            if (this.MTK != null) {
                aVar.e(7, this.MTK);
            }
            AppMethodBeat.o(123643);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KWK != null ? g.a.a.b.b.a.f(1, this.KWK) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MTI);
            if (this.nBo != null) {
                bu += g.a.a.b.b.a.f(4, this.nBo);
            }
            if (this.Mjt != null) {
                bu += g.a.a.b.b.a.f(5, this.Mjt);
            }
            if (this.MTJ != null) {
                bu += g.a.a.b.b.a.f(6, this.MTJ);
            }
            if (this.MTK != null) {
                bu += g.a.a.b.b.a.f(7, this.MTK);
            }
            AppMethodBeat.o(123643);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123643);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drb drb = (drb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    drb.KWK = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                case 2:
                    drb.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                case 3:
                    drb.MTI = aVar3.UbS.zi();
                    AppMethodBeat.o(123643);
                    return 0;
                case 4:
                    drb.nBo = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                case 5:
                    drb.Mjt = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                case 6:
                    drb.MTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                case 7:
                    drb.MTK = aVar3.UbS.readString();
                    AppMethodBeat.o(123643);
                    return 0;
                default:
                    AppMethodBeat.o(123643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123643);
            return -1;
        }
    }
}
