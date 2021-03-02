package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dxh extends a {
    public int KWR;
    public String eaO;
    public int pVR;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114074);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            aVar.aM(2, this.pVR);
            aVar.aM(3, this.KWR);
            aVar.bb(4, this.seq);
            AppMethodBeat.o(114074);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pVR) + g.a.a.b.b.a.bu(3, this.KWR) + g.a.a.b.b.a.r(4, this.seq);
            AppMethodBeat.o(114074);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114074);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxh dxh = (dxh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dxh.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114074);
                    return 0;
                case 2:
                    dxh.pVR = aVar3.UbS.zi();
                    AppMethodBeat.o(114074);
                    return 0;
                case 3:
                    dxh.KWR = aVar3.UbS.zi();
                    AppMethodBeat.o(114074);
                    return 0;
                case 4:
                    dxh.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(114074);
                    return 0;
                default:
                    AppMethodBeat.o(114074);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114074);
            return -1;
        }
    }
}
