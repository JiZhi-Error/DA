package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ahl extends a {
    public int KZx;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91436);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.aM(2, this.KZx);
            AppMethodBeat.o(91436);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KZx);
            AppMethodBeat.o(91436);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91436);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahl ahl = (ahl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ahl.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(91436);
                    return 0;
                case 2:
                    ahl.KZx = aVar3.UbS.zi();
                    AppMethodBeat.o(91436);
                    return 0;
                default:
                    AppMethodBeat.o(91436);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91436);
            return -1;
        }
    }
}
