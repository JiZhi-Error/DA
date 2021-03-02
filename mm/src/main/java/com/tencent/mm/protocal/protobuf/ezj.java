package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ezj extends a {
    public b KKz;
    public long KMm;
    public int NvM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32552);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKz == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32552);
                throw bVar;
            }
            aVar.bb(1, this.KMm);
            if (this.KKz != null) {
                aVar.c(2, this.KKz);
            }
            aVar.aM(3, this.NvM);
            AppMethodBeat.o(32552);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KMm) + 0;
            if (this.KKz != null) {
                r += g.a.a.b.b.a.b(2, this.KKz);
            }
            int bu = r + g.a.a.b.b.a.bu(3, this.NvM);
            AppMethodBeat.o(32552);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKz == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(32552);
                throw bVar2;
            }
            AppMethodBeat.o(32552);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ezj ezj = (ezj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ezj.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(32552);
                    return 0;
                case 2:
                    ezj.KKz = aVar3.UbS.hPo();
                    AppMethodBeat.o(32552);
                    return 0;
                case 3:
                    ezj.NvM = aVar3.UbS.zi();
                    AppMethodBeat.o(32552);
                    return 0;
                default:
                    AppMethodBeat.o(32552);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32552);
            return -1;
        }
    }
}
