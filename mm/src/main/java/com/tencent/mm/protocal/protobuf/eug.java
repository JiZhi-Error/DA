package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eug extends a {
    public int Nsk;
    public int Nsl;
    public int Nsm;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115903);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            aVar.aM(2, this.Nsk);
            aVar.aM(3, this.Nsl);
            aVar.aM(4, this.Nsm);
            AppMethodBeat.o(115903);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0 + g.a.a.b.b.a.bu(2, this.Nsk) + g.a.a.b.b.a.bu(3, this.Nsl) + g.a.a.b.b.a.bu(4, this.Nsm);
            AppMethodBeat.o(115903);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115903);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eug eug = (eug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eug.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(115903);
                    return 0;
                case 2:
                    eug.Nsk = aVar3.UbS.zi();
                    AppMethodBeat.o(115903);
                    return 0;
                case 3:
                    eug.Nsl = aVar3.UbS.zi();
                    AppMethodBeat.o(115903);
                    return 0;
                case 4:
                    eug.Nsm = aVar3.UbS.zi();
                    AppMethodBeat.o(115903);
                    return 0;
                default:
                    AppMethodBeat.o(115903);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115903);
            return -1;
        }
    }
}
