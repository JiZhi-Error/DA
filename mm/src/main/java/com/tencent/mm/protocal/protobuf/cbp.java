package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbp extends a {
    public String ClU;
    public String ClV;
    public int ClW;
    public String id;
    public String pSm;
    public long timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72499);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.ClU != null) {
                aVar.e(2, this.ClU);
            }
            if (this.ClV != null) {
                aVar.e(3, this.ClV);
            }
            if (this.pSm != null) {
                aVar.e(4, this.pSm);
            }
            aVar.bb(6, this.timestamp);
            aVar.aM(5, this.ClW);
            AppMethodBeat.o(72499);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0;
            if (this.ClU != null) {
                f2 += g.a.a.b.b.a.f(2, this.ClU);
            }
            if (this.ClV != null) {
                f2 += g.a.a.b.b.a.f(3, this.ClV);
            }
            if (this.pSm != null) {
                f2 += g.a.a.b.b.a.f(4, this.pSm);
            }
            int r = f2 + g.a.a.b.b.a.r(6, this.timestamp) + g.a.a.b.b.a.bu(5, this.ClW);
            AppMethodBeat.o(72499);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72499);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbp cbp = (cbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbp.id = aVar3.UbS.readString();
                    AppMethodBeat.o(72499);
                    return 0;
                case 2:
                    cbp.ClU = aVar3.UbS.readString();
                    AppMethodBeat.o(72499);
                    return 0;
                case 3:
                    cbp.ClV = aVar3.UbS.readString();
                    AppMethodBeat.o(72499);
                    return 0;
                case 4:
                    cbp.pSm = aVar3.UbS.readString();
                    AppMethodBeat.o(72499);
                    return 0;
                case 5:
                    cbp.ClW = aVar3.UbS.zi();
                    AppMethodBeat.o(72499);
                    return 0;
                case 6:
                    cbp.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(72499);
                    return 0;
                default:
                    AppMethodBeat.o(72499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72499);
            return -1;
        }
    }
}