package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class chh extends a {
    public double latitude;
    public double longitude;
    public String pVT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(93333);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, this.latitude);
            aVar.e(2, this.longitude);
            if (this.pVT != null) {
                aVar.e(3, this.pVT);
            }
            AppMethodBeat.o(93333);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 8 + 0 + g.a.a.b.b.a.fS(2) + 8;
            if (this.pVT != null) {
                fS += g.a.a.b.b.a.f(3, this.pVT);
            }
            AppMethodBeat.o(93333);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(93333);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chh chh = (chh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chh.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(93333);
                    return 0;
                case 2:
                    chh.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(93333);
                    return 0;
                case 3:
                    chh.pVT = aVar3.UbS.readString();
                    AppMethodBeat.o(93333);
                    return 0;
                default:
                    AppMethodBeat.o(93333);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93333);
            return -1;
        }
    }
}
