package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdk extends a {
    public boolean NyX;
    public int NyY;
    public double NyZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50121);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.NyX);
            aVar.aM(2, this.NyY);
            aVar.e(3, this.NyZ);
            AppMethodBeat.o(50121);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.bu(2, this.NyY) + g.a.a.b.b.a.fS(3) + 8;
            AppMethodBeat.o(50121);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50121);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdk fdk = (fdk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdk.NyX = aVar3.UbS.yZ();
                    AppMethodBeat.o(50121);
                    return 0;
                case 2:
                    fdk.NyY = aVar3.UbS.zi();
                    AppMethodBeat.o(50121);
                    return 0;
                case 3:
                    fdk.NyZ = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(50121);
                    return 0;
                default:
                    AppMethodBeat.o(50121);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50121);
            return -1;
        }
    }
}
