package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aug extends a {
    public String LFa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209471);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFa != null) {
                aVar.e(1, this.LFa);
            }
            AppMethodBeat.o(209471);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LFa != null ? g.a.a.b.b.a.f(1, this.LFa) + 0 : 0;
            AppMethodBeat.o(209471);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209471);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aug aug = (aug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aug.LFa = aVar3.UbS.readString();
                    AppMethodBeat.o(209471);
                    return 0;
                default:
                    AppMethodBeat.o(209471);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209471);
            return -1;
        }
    }
}
