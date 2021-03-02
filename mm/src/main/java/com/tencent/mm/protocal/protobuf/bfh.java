package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfh extends a {
    public String HVY;
    public String HVZ;
    public String HWa;
    public long LOR;
    public int LOS;
    public double LOT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91470);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LOR);
            aVar.aM(2, this.LOS);
            aVar.e(3, this.LOT);
            if (this.HVY != null) {
                aVar.e(4, this.HVY);
            }
            if (this.HVZ != null) {
                aVar.e(5, this.HVZ);
            }
            if (this.HWa != null) {
                aVar.e(6, this.HWa);
            }
            AppMethodBeat.o(91470);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LOR) + 0 + g.a.a.b.b.a.bu(2, this.LOS) + g.a.a.b.b.a.fS(3) + 8;
            if (this.HVY != null) {
                r += g.a.a.b.b.a.f(4, this.HVY);
            }
            if (this.HVZ != null) {
                r += g.a.a.b.b.a.f(5, this.HVZ);
            }
            if (this.HWa != null) {
                r += g.a.a.b.b.a.f(6, this.HWa);
            }
            AppMethodBeat.o(91470);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91470);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfh bfh = (bfh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfh.LOR = aVar3.UbS.zl();
                    AppMethodBeat.o(91470);
                    return 0;
                case 2:
                    bfh.LOS = aVar3.UbS.zi();
                    AppMethodBeat.o(91470);
                    return 0;
                case 3:
                    bfh.LOT = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91470);
                    return 0;
                case 4:
                    bfh.HVY = aVar3.UbS.readString();
                    AppMethodBeat.o(91470);
                    return 0;
                case 5:
                    bfh.HVZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91470);
                    return 0;
                case 6:
                    bfh.HWa = aVar3.UbS.readString();
                    AppMethodBeat.o(91470);
                    return 0;
                default:
                    AppMethodBeat.o(91470);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91470);
            return -1;
        }
    }
}
