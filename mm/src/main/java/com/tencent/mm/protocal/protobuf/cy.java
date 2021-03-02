package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cy extends a {
    public int KGZ;
    public int KHa;
    public int KHb;
    public int KHc;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127429);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KGZ);
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.KHa);
            aVar.aM(4, this.KHb);
            aVar.aM(5, this.KHc);
            AppMethodBeat.o(127429);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KGZ) + 0 + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.KHa) + g.a.a.b.b.a.bu(4, this.KHb) + g.a.a.b.b.a.bu(5, this.KHc);
            AppMethodBeat.o(127429);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127429);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cy cyVar = (cy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cyVar.KGZ = aVar3.UbS.zi();
                    AppMethodBeat.o(127429);
                    return 0;
                case 2:
                    cyVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(127429);
                    return 0;
                case 3:
                    cyVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(127429);
                    return 0;
                case 4:
                    cyVar.KHb = aVar3.UbS.zi();
                    AppMethodBeat.o(127429);
                    return 0;
                case 5:
                    cyVar.KHc = aVar3.UbS.zi();
                    AppMethodBeat.o(127429);
                    return 0;
                default:
                    AppMethodBeat.o(127429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127429);
            return -1;
        }
    }
}
