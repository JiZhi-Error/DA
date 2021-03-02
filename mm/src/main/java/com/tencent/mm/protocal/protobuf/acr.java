package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acr extends a {
    public LinkedList<acq> KHx = new LinkedList<>();
    public long Lnv;
    public long Lnw;

    public acr() {
        AppMethodBeat.i(184493);
        AppMethodBeat.o(184493);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(184494);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnv);
            aVar.bb(2, this.Lnw);
            aVar.e(3, 8, this.KHx);
            AppMethodBeat.o(184494);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnv) + 0 + g.a.a.b.b.a.r(2, this.Lnw) + g.a.a.a.c(3, 8, this.KHx);
            AppMethodBeat.o(184494);
            return r;
        } else if (i2 == 2) {
            this.KHx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(184494);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acr acr = (acr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acr.Lnv = aVar3.UbS.zl();
                    AppMethodBeat.o(184494);
                    return 0;
                case 2:
                    acr.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(184494);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acq acq = new acq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acq.populateBuilderWithField(aVar4, acq, a.getNextFieldNumber(aVar4))) {
                        }
                        acr.KHx.add(acq);
                    }
                    AppMethodBeat.o(184494);
                    return 0;
                default:
                    AppMethodBeat.o(184494);
                    return -1;
            }
        } else {
            AppMethodBeat.o(184494);
            return -1;
        }
    }
}
