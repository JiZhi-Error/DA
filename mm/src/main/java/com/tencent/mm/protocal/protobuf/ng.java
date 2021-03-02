package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ng extends a {
    public int CreateTime;
    public int KHb;
    public int KSf;
    public int KSg;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124398);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KSf);
            aVar.aM(2, this.CreateTime);
            aVar.aM(3, this.KHb);
            aVar.aM(4, this.oUv);
            aVar.aM(5, this.KSg);
            AppMethodBeat.o(124398);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KSf) + 0 + g.a.a.b.b.a.bu(2, this.CreateTime) + g.a.a.b.b.a.bu(3, this.KHb) + g.a.a.b.b.a.bu(4, this.oUv) + g.a.a.b.b.a.bu(5, this.KSg);
            AppMethodBeat.o(124398);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124398);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ng ngVar = (ng) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ngVar.KSf = aVar3.UbS.zi();
                    AppMethodBeat.o(124398);
                    return 0;
                case 2:
                    ngVar.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(124398);
                    return 0;
                case 3:
                    ngVar.KHb = aVar3.UbS.zi();
                    AppMethodBeat.o(124398);
                    return 0;
                case 4:
                    ngVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(124398);
                    return 0;
                case 5:
                    ngVar.KSg = aVar3.UbS.zi();
                    AppMethodBeat.o(124398);
                    return 0;
                default:
                    AppMethodBeat.o(124398);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124398);
            return -1;
        }
    }
}
